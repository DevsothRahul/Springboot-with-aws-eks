# Springboot-with-aws-eks

A sample Spring Boot **CRUD REST API** (Products), containerized and deployable to **Amazon EKS**.

## Features

- RESTful CRUD endpoints backed by Spring Data JPA
- Runs out of the box against an in-memory H2 database — no setup required
- Same datasource config switches to MySQL/RDS via environment variables for EKS
- Dockerfile (multi-stage build) and Kubernetes manifests included

## Project Layout

```
.
├── src/main/java/com/devsoth/springbootawseks/
│   ├── controller/    # REST endpoints
│   ├── model/         # JPA entities
│   ├── repository/    # Spring Data repositories
│   └── exception/     # Custom exceptions
├── src/main/resources/application.properties
├── Dockerfile
├── k8s/springboot-aws-eks-deployment.yaml   # MySQL + app Deployments/Services for EKS
└── pom.xml
```

## Run Locally

```bash
./mvnw clean package
java -jar target/springboot-aws-eks-0.0.1-SNAPSHOT.jar
```

The app starts on port 8080 against an in-memory H2 database by default.

## API Endpoints

| HTTP Method | Endpoint                | Description                |
|-------------|--------------------------|-----------------------------|
| GET         | `/api/v1/health`         | Health check               |
| GET         | `/api/v1/products`       | Returns all products       |
| GET         | `/api/v1/products/{id}`  | Returns a product by ID    |
| POST        | `/api/v1/products`       | Creates a new product      |
| PUT         | `/api/v1/products/{id}`  | Updates an existing product|
| DELETE      | `/api/v1/products/{id}`  | Deletes a product          |

## Run with Docker

```bash
docker build -t springboot-aws-eks .
docker run -p 8080:8080 springboot-aws-eks
```

## Deploy to EKS

`k8s/springboot-aws-eks-deployment.yaml` provisions a MySQL Deployment/Service plus the app Deployment/Service, wired together via a ConfigMap and Secret.

1. Build and push your image, then update the `image:` field in the manifest:
   ```bash
   docker build -t <your-dockerhub-user>/springboot-aws-eks:latest .
   docker push <your-dockerhub-user>/springboot-aws-eks:latest
   ```
2. Point `kubectl` at your EKS cluster:
   ```bash
   aws eks update-kubeconfig --region <your-region> --name <your-cluster-name>
   ```
3. Apply the manifest:
   ```bash
   kubectl apply -f k8s/springboot-aws-eks-deployment.yaml
   kubectl get svc springboot-aws-eks-service
   ```

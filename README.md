# secured-jwt-sb
An implementation of JWT in Spring Boot.

## Local deployment
This is meant for local deployment for study of how JWT is used.
That's why the following decisions were made: \
❌ ECR ✅ GHCR \
❌ ECS ✅ Docker compose

## Secrets
- FRENCH_KEYS - Base64 encoded 32 bytes HmacSHA256 private key

## Helper scripts
- build_dummy_key.sh - For building with maven locally using a dummy key
- macos_colima_testcontainers.sh - This is for setting the environment variables needed when Colima is used instead of the regular docker engine\

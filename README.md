# secured-jwt-sb
An implementation of JWT in Spring Boot.

## Secrets
- FRENCH_KEYS - Base64 encoded 32 bytes HmacSHA256 private key

## Helper scripts
- build_dummy_key.sh - For building with maven locally using a dummy key
- macos_colima_testcontainers.sh - This is for setting the environment variables needed when Colima is used instead of the regular docker engine 
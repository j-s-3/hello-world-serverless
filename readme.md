
# Development Environment

- Requires Java 21
- For building native images requires graalvm 21
- Docker required for building in a docker container (os agnostic)

# Building and running locally
Build: `mvnd clean package`

Run Locally: `mvn spring-boot:run`

# Testing

`curl localhost:8080 -H "Content-Type: text/plain" -d "hello world"`

# Native images (GraalVM)
To improve boot times we make use of GraalVM. This can take a while to build and also is OS specific.
If you're testing locally and don't need to test booting in GraalVM I recommend using plain java

## Building local native image
Build: `mvnd clean spring-boot:build-image -Pnative`

Run Locally: `mvn spring-boot:run`

## Building for AWS (Linux)
Build: `mvnd clean spring-boot:build-image -P native,aws`

Create AWS Lambda zip: `mvn assembly:assembly`

## Building for AWS (Mac/Windows)
The AWS lambda environment we use is a linux environment so we need to build the native image using a docker
container so that we can build on any OS. If you are running on a linux environment

`docker build t hello_world_serverless_build_image . -f  ./build/Dockerfile`

`docker create --name tmp_container hello_world_serverless_build_image`

`docker cp tmp_container:/app/target/hello-world-serverless ./target/`

`docker rm tmp_container`

Create AWS Lambda zip: `mvn assembly:assembly`

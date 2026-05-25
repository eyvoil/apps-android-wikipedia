#!/bin/bash

docker run --rm -d \
  --name my-container \
  -v "$(pwd):/project" \
  -w /project \
  android-jdk21 \
  sleep infinity

docker exec my-container sh -c \
  "sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew app:clean"
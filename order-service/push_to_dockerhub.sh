#!/bin/bash

# Variables
DOCKER_USERNAME=${DOCKER_USERNAME}
DOCKER_PASSWORD=${DOCKER_PASSWORD}
LOCAL_IMAGE_NAME=${LOCAL_IMAGE_NAME}
DOCKER_HUB_REPO=${DOCKER_HUB_REPO}
TAG=${TAG:-latest} # Default to 'latest' if no tag is provided

# Check if required variables are set
if [ -z "$DOCKER_USERNAME" ] || [ -z "$DOCKER_PASSWORD" ] || [ -z "$LOCAL_IMAGE_NAME" ]; then
  echo "Required environment variables are not set."
  exit 1
fi

# Log in to Docker Hub
echo "Logging in to Docker Hub..."
echo $DOCKER_PASSWORD | docker login --username $DOCKER_USERNAME --password-stdin
if [ $? -ne 0 ]; then
  echo "Docker login failed"
  exit 1
fi

# Tag the image
echo "Tagging the image..."
docker tag $LOCAL_IMAGE_NAME $DOCKER_HUB_REPO

# Push the image
echo "Pushing the image to Docker Hub..."
docker push $DOCKER_HUB_REPO

# Log out from Docker Hub
echo "Logging out from Docker Hub..."
docker logout

echo "Done!"
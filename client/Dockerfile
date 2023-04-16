FROM node:18-alpine3.17

# COPY [host machine] [container] (first path are relative to the Dockerfile, second is relative to root on the container)
COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm build
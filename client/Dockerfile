FROM node:18.16.0-alpine3.17 as prod

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=${REACT_APP_API_BASE_URL}

RUN npm run build

# ENTRYPOINT [ "npm","start" ]

FROM nginx:1.24.0-alpine

WORKDIR /usr/share/nginx/html

COPY --from=prod /app/build /var/www

COPY ./nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]
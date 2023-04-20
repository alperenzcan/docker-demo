FROM node:18.16.0-alpine3.17 as build

WORKDIR /app

ENV PATH /app/node_modules/.bin:$PATH

COPY package.json /app/package.json

RUN npm install --silent

RUN npm install react-scripts@3.0.1 -g --silent

COPY . /app

RUN npm run build

# ENTRYPOINT [ "npm","start" ]

FROM nginx:1.24.0-alpine

COPY --from=build /app/build /usr/share/nginx/html

RUN rm /etc/nginx/conf.d/default.conf

COPY ./nginx.conf /etc/nginx/conf.d

EXPOSE 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]
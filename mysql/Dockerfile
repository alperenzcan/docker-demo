# FROM mysql:8.0.28 as builder

# RUN apt-get update \
#     && apt-get install -y --no-install-recommends \
#        tzdata \
#        && rm -rf /var/lib/apt/lists/*

# COPY my.cnf /etc/mysql/my.cnf

# FROM mysql:8.0.28

# COPY --from=builder /etc/mysql/my.cnf /etc/mysql/my.cnf

# RUN apt-get update \
#     && apt-get remove -y tzdata \
#     && apt-get autoremove -y \
#     && rm -rf /var/lib/apt/lists/*

# RUN docker save mysql:8.0.28 | gzip > mysql.tar.gz


# Build stage
FROM mysql:latest AS build
COPY my.cnf /etc/mysql/my.cnf

# Final stage
FROM alpine:latest
RUN apk add --no-cache mysql-client
COPY --from=build /usr/local/bin/ /usr/local/bin/
COPY --from=build /usr/local/lib/mysql/ /usr/local/lib/mysql/
CMD ["mysqld"]

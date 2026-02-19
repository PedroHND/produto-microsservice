docker build -t ms-produto:dev .

docker network create dev-ms-produto

docker compose -f compose.yaml up -d

docker rm dev-ms-produto
docker run -d \
    --name dev-ms-produto \
    --network dev-ms-produto \
    --env-file .env \
    ms-produto:dev
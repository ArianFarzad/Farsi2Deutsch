# Create Database

## Linux

````bash
docker run -d \
  --name farsi2deutsch-localdev \
  -e POSTGRES_USER=farsi2deutsch \
  -e POSTGRES_PASSWORD=farsi2deutsch \
  -e POSTGRES_DB=farsi2deutschDB \
  -p 5432:5432 \
  -v pgdata:/var/lib/postgresql/data \
  postgres
````

## Powershell
````bash
docker run -d `
  --name farsi2deutsch-localdev `
  -e POSTGRES_USER=farsi2deutsch `
  -e POSTGRES_PASSWORD=farsi2deutsch `
  -e POSTGRES_DB=farsi2deutschDB `
  -p 5432:5432 `
  -v pgdata:/var/lib/postgresql/data `
  postgres
````

# Migrations
## Linux

````bash

docker run --rm \
  -v ${PWD}/sql:/flyway/sql \
  flyway/flyway \
  -url=jdbc:postgresql://host.docker.internal:5432/farsi2deutschDB \
  -user=farsi2deutsch \
  -password=farsi2deutsch \
  migrate
````

## Powershell

````bash
docker run --rm `
  -v ${PWD}/sql:/flyway/sql `
  flyway/flyway `
  -url=jdbc:postgresql://host.docker.internal:5432/farsi2deutschDB `
  -user=farsi2deutsch `
  -password=farsi2deutsch `
  migrate
````

# SQL CLI
````bash
docker exec -it farsi2deutsch-localdev psql -U farsi2deutsch -d farsi2deutschDB
````
# Start the DB
````bash
docker start farsi2deutsch-localdev
````
# Stop DB
````bash
docker stop farsi2deutsch-localdev
````

# Remove DB
````bash
docker rm farsi2deutsch-localdev
````


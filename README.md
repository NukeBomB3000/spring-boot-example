# Start a local postgre container
docker run --publish 127.0.0.1:5432:5432 --name postgre -e POSTGRES_PASSWORD=1234 -d postgres

# PSQL to Postgre DB
docker exec -it postgre psql -U postgres -W postgres postgres
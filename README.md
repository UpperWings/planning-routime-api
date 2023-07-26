# planning-routime


## Docker build 

```dockerfile
sudo docker run -e PGDATA=/var/lib/postgresql/data/db_files -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -v /home/ubuntu/database:/var/lib/postgresql/data/pgdata/db_files --name pg-database2 postgres

```

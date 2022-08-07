# PSnpBind Webapp

![GitHub top language](https://img.shields.io/github/languages/top/ammar257ammar/psnpbind-webapp) ![GitHub](https://img.shields.io/github/license/ammar257ammar/psnpbind-webapp) ![GitHub release (latest by date)](https://img.shields.io/github/v/release/ammar257ammar/psnpbind-webapp) ![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/aammar/psnpbind-webapp) [![Dockerhub](https://img.shields.io/badge/dockerhub-aammar%2Fpsnpbind--webapp-green)](https://hub.docker.com/r/aammar/psnpbind-webapp) [![DOI](https://zenodo.org/badge/339152290.svg)](https://zenodo.org/badge/latestdoi/339152290)

PSnpBind Webapp is the repository behind the PSnpBind website that is made to visualize the results of the PSnpBind dataset and provide a REST API to access its content.

This repository is part of the "PSnpBind, a database to highlight pocket SNPs effects on protein-ligand binding affinity" project and it is the final step after constructing the PSnpBind dataset as described in the [main repository](https://github.com/ammar257ammar/PSnpBind-Build).

Please prepare and build the docker using the following instruction.



## Build the Image locally

### if you want to build the docker image locally then clone this repository, "cd" to its directory and run:

```bash
docker build -t psnpbind-webapp .
```



## Run without building

### Run the following commands after setting the appropriate paths:

Note, you need to construct the MySQL data constructed from the [main repository](https://github.com/ammar257ammar/PSnpBind-Build).

```bash
docker network create psnpbind-network 

docker run --network=psnpbind-network --rm --name psnpbind-mysql  -d -v PATH_TO_MYSQL_DATA_FOLDER:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root aammar/psnpbind-db

docker run --network=psnpbind-network --rm --name psnpbind-webapp -d -v PATH_TO_DOCKINGS_DOWNLOADED_FROM_ZENODO:/dockings -p 8086:8086 aammar/psnpbind-webapp:1.2.3
```



#### Now you are ready! 

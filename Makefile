up-back:
	docker compose up


up-front:
	cd ng-totvs-frontend && ng serve -o

up-db:
	docker-compose up -d mongo

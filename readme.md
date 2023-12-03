Build locally:
mvn package
docker image build -t calculator:latest .

Run locally:
docker run -p 8080:8080 calculator:latest

http://localhost:8080/v1/calculation/?operation=addition&oa=3&ob=5

Push image to gcp manually:
docker tag calculator:latest europe-north1-docker.pkg.dev/calculator-server-379817/calculator-revisions/calculator
docker push europe-north1-docker.pkg.dev/calculator-server-379817/calculator-revisions/calculator

Build and push image to gcp using script:
zsh ./scripts/build-deploy.sh

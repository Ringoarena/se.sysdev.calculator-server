mvn package
docker image build -t calculator:latest .
docker tag calculator:latest europe-north1-docker.pkg.dev/calculator-server-379817/calculator-revisions/calculator
docker push europe-north1-docker.pkg.dev/calculator-server-379817/calculator-revisions/calculator
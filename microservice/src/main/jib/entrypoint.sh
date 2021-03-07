#!/bin/sh

echo "Dockerizando aplicação MICROSERVICE por JIB"
exec java -cp /app/resources/:/app/classes/:/app/libs/* "br.com.kyouma54.MicroServiceApplication" "$@"

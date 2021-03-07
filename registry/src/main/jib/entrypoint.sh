#!/bin/sh

echo "Dockerizando aplicação EUREKAREGISTRY por JIB"
exec java -cp /app/resources/:/app/classes/:/app/libs/* "br.com.kyouma54.EurekaRegistryApplication" "$@"

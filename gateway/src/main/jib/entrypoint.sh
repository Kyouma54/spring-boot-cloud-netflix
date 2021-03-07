#!/bin/sh

echo "Dockerizando aplicação GATEWAY por JIB"
exec java -cp /app/resources/:/app/classes/:/app/libs/* "br.com.kyouma54.GatewayApplication" "$@"

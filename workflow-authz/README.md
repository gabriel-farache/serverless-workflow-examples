# workflow-authz

## Keycloak
Keycloak will be used as OIDC auth server in which the users and theirs roles will be defined.

The authorization definition will be delegated to the application.properties.

Install keycloak be following: https://www.keycloak.org/getting-started/getting-started-kube

On minikube you may need to start tunneling:
```bash
minikube tunnel 
```

If the DNS resolving do not work, you may have to have 
```
[main]
dns=dnsmasq
```
In `/etc/NetworkManager/NetworkManager.conf`, if not add it and restart the service:
```bash
systemctl restart NetworkManager.service
```
Then check you have a result 
```bash
cat /etc/resolv.conf | grep nameserver
```
```
nameserver 127.0.0.53
```

Now get the address of keycloak:
```bash
kubectl get ingress
```
```
NAME       CLASS   HOSTS                          ADDRESS        PORTS     AGE
keycloak   nginx   keycloak.192.168.58.2.nip.io   192.168.58.2   80, 443   5h30m```
```

You can now access `https://keycloak.192.168.58.2.nip.io/admin` with admin/admin as credentials. 

Create a new realm by importing [realm.json](realm.json).

With this file, `alice` is assigned with the `user` role but `alice2` is assigned with none

Update the property `quarkus.oidc.auth-server-url` in  [application.properties](src/main/resources/application.properties) with keycloak's address
## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Request execution
### Get access token:
- For `alice`
```bash
export access_token=$(\                                                                                                                                               
    curl --insecure -X POST https://keycloak.192.168.58.2.nip.io/realms/quarkus/protocol/openid-connect/token \
    --user backend-service:secret \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'username=alice&password=alice&grant_type=password' | jq --raw-output '.access_token' \
 )
```
- For `alice2`
```bash
export access_token=$(\                                                                                                                                               
    curl --insecure -X POST https://keycloak.192.168.58.2.nip.io/realms/quarkus/protocol/openid-connect/token \
    --user backend-service:secret \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'username=alice2&password=alice&grant_type=password' | jq --raw-output '.access_token' \
 )
```

Then request execution:
```bash
curl -X POST -H 'Content-Type:application/json' -H 'Accept:application/json' -d '{}'    http://localhost:8080/BasicExample -H "Authorization: Bearer "$access_token -v
```

By trying to access with `alice` token, the execution request will be accepted.

With `alice2` token you will have a 403 error and without any token a 401 error.

This behaviour occurs as only user with role `user` are granted access (from [application.properties](src/main/resources/application.properties)):
```
quarkus.http.auth.policy.role-policy1.roles-allowed=user
quarkus.http.auth.permission.roles1.paths=/*
quarkus.http.auth.permission.roles1.policy=role-policy1
```

We are using the `test` realm hence the rules of the `quarkus` realm are not applied here (with authz protection set on the resources) 
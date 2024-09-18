# http2-api

## Endpoints
 https://localhost:8443/api/v1/users

## Implemented Features

### HTTP/2
* **Description:** This API uses the HTTP/2 instead of HTTP/1.1.
* **Configuration:** 
   ````  
    server:
      http2:
        enabled: true

* **Features:**
  1. Supports Multiplex
  2. Single connection for multiple request and response
  3. provides priority for request for execution
  4. Provides server Push
  5. Uses the header encryption.
  6. Uses the HTTPS over HTTP.



### HTTPS
* **Description:** HTTP/2 uses the HTTPS, so we have to configure the HTTPS.
*  **Configuration:**
   ````
   server:
     port: 8443
     ssl:
       key-store-type: PKCS12
       key-store: classpath:keystore.p12
       key-store-password: changeit
       key-alias: selfsigned
   
#### Steps to create certificate
1. Use below command to create self-signed certificate.
   ````
   keytool -genkeypair -alias selfsigned -keyalg RSA -keysize 2048 -storetype PKCS12   -keystore keystore.p12 -validity 3650

2. Above command will create the keystore.p12 file under the current location. Now copy this file into the resources folder in the application.

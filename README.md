# Basic Zoom API Integration
In this example you going to know how to integrate with Zoom API using JWT authentication to list and schedule/create meetings.

### Requirements
First of all, you should generate the API Key and API Secret, so please follow the instructions bellow.

* [Create a JWT App](https://marketplace.zoom.us/docs/guides/build/jwt-app)

After done it, replace the following values with the genereted on your Zoom JWT App (previous step)
```
zoom:
  apiKey: aaaaaaaaa
  apiSecret: zzzzzzzzzz
```

### API
Here is the reference of used methods.

* [List meetings](https://marketplace.zoom.us/docs/api-reference/zoom-api/meetings/meetings)
* [Schedule a new meeting](https://marketplace.zoom.us/docs/api-reference/zoom-api/meetings/meetingcreate)

### Reference
* [Create and Sign a Token](https://github.com/auth0/java-jwt#create-and-sign-a-token)
```Algorithm algorithm = Algorithm.HMAC256(apiSecret);
             Date date = Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
             String token = JWT.create()
                     .withIssuer(apiKey)
                     .withExpiresAt(date)
                     .sign(algorithm);
```
You can validate your generated token in https://jwt.io/

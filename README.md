# springfox-issue
Showing a swagger issue with SpringFox 

### Issue

I have a simple controller that maps to the context root `/swagger/{message}` with a `PathVariable`.
 
However, the `/swagger/swagger-ui.html` cannot render the page, it shows a `406` white label error instead:

```
Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Thu Sep 21 13:53:50 PDT 2017
There was an unexpected error (type=Not Acceptable, status=406).
Could not find acceptable representation
```

But, if you hit the `/swagger/api-docs` endpoint, you get the json payload about the API:
```
{"swagger":"2.0","info":{"description":"Api Documentation","version":"1.0","title":"Api Documentation","termsOfService":"urn:tos","contact":{},"license":{"name":"Apache 2.0","url":"http://www.apache.org/licenses/LICENSE-2.0"}},"host":"localhost:8080","basePath":"/swagger","tags":[{"name":"swagger-controller","description":"Swagger Controller"}],"paths":{"/{message}":{"get":{"tags":["swagger-controller"],"summary":"pathHello","operationId":"pathHelloUsingGET","consumes":["application/json"],"produces":["application/json"],"parameters":[{"name":"message","in":"path","description":"message","required":true,"type":"string"}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/MessageDto"}},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}}}}},"definitions":{"MessageDto":{"type":"object","properties":{"message":{"type":"string"}}}}}
```

### Testing the issue

Run the `gradlew` command:
```
./gradlew bootRun
```

Then navigate to `http://localhost:8080/swagger/swagger-ui.html` to see the error.
 
The json data can be seen at: `http://localhost:8080/swagger/api-docs`

Note, the api works fine; i.e. `http://localhost:8080/swagger/hello`.
```
{"message":"hello"}
```

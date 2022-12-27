package com.garanti.endpoint;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

// localhost:9090/FirstRestfulService/hello
@jakarta.ws.rs.Path(value = "hello")
public class HelloRest {
    @GET
    @Path(value = "rest")
    public String abuziddin()
    {
        // localhost:9090/FirstRestfulService/hello/rest
        return "hello jakarta rest";
    }

    @GET
    @Path(value = "rest2")
    public String abuziddin2()
    {
        // localhost:9090/FirstRestfulService/hello/rest2
        return "hello jakarta rest 2";
    }

    @GET
    @Path(value = "/rest/rest2")
    public String abuziddin3()
    {
        // localhost:9090/FirstRestfulService/hello/rest2
        return "hello jakarta rest 3";
    }
}
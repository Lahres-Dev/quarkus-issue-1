package com.github.lahresdev;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Response;

public class HelloServiceImpl
        implements HelloService {

    @Override
    @RolesAllowed("user")
    public Response hello() {
        return Response.ok("Hello").build();
    }
}

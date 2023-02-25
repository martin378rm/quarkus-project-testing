package id.martin.rest;

import id.martin.dto.UserData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.*;

@Path("users")
public class UserResource {

    Map<Integer, UserData> users = new HashMap<>();

    public static Integer id = 1;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok(users).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(UserData user){
        users.put(id++,user);
        return Response.created(URI.create("/users/"+user.getNIM())).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(Integer id){
        UserData user = users.get(id);
        if (Objects.isNull(user)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

}

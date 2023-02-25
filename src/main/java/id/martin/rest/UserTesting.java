package id.martin.rest;


import id.martin.dto.Result;
import id.martin.dto.UserData;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

@Path("test")
public class UserTesting {

    @Inject
    Validator validator;


    HashMap<Integer, UserData> users = new HashMap<>();

    public static Integer id = 1;


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(users).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result addUser(UserData user){
        Set<ConstraintViolation<UserData>> violations = validator.validate(user);
        if (violations.isEmpty()){
            users.put(id++ , user);
            return new Result("data dengan NIM " + user.getNIM() + " berhasil di tambahkan");
        } else {
            return new Result(violations.toString());
        }
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserData getById(Integer id){
        return users.get(id);
    }


    @PUT
    @Path("{id}")
    public Result editUser(Integer id, UserData userData){
        Set<ConstraintViolation<UserData>> violations = validator.validate(userData);
        if (violations.isEmpty()){
            users.replace(id , userData);
            return new Result("data " + userData.getNIM() + " berhasil di ubah");
        } else {
            return new Result(violations.toString());
        }
    }

    @DELETE
    @Path("{id}")
    public  HashMap<Integer, UserData> deleteUser(Integer id){
        users.remove(id.intValue());
        return users;
    }

}

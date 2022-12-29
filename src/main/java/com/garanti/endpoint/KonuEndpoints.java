package com.garanti.endpoint;
import com.garanti.model.Konu;
import com.garanti.repo.KonuRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "konu")
public class KonuEndpoints {
    private KonuRepo repo;

    public KonuEndpoints()
    {
        this.repo = new KonuRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Konu> getAll()
    {
        // localhost:9090/FirstRestfulService/konu/getAll
        return repo.getALl();
    }


    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // path param yazarsam bütün param 'lar set edilmiş olmak zorunda
        // localhost:9090/FirstRestfulService/konu/getById/1
        return repo.getById(id);
    }

    //header
    @GET
    @Path(value = "getByIdHeader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Konu getByIdHeader(@HeaderParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/konu/getByIdHeader
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Konu konu)
    {
        // localhost:9090/FirstRestfulService/konu/save
        repo.save(konu);
        return "Başarı ile kaydedildi";
    }

    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/konu/deleteById/1
        if (repo.deleteById(id)) {
            return "Başarılı ile silindi";
        }
        else {
            return "Silinemedi";
        }
    }
}

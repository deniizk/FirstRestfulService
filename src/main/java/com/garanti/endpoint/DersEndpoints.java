package com.garanti.endpoint;
import com.garanti.model.Ders;
import com.garanti.repo.DersRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "ders")
public class DersEndpoints {
    private DersRepo repo;

    public DersEndpoints()
    {
        this.repo = new DersRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders> getAll()
    {
        // localhost:9090/FirstRestfulService/ders/getAll
        return repo.getAll();
    }


    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // path param yazarsam bütün param 'lar set edilmiş olmak zorunda
        // localhost:9090/FirstRestfulService/ders/getById/1
        return repo.getById(id);
    }

    //header
    @GET
    @Path(value = "getByIdHeader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByIdHeader(@HeaderParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ders/getByIdHeader
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders ders)
    {
        // localhost:9090/FirstRestfulService/ders/save
        //{"KONU_ID": 1,"OGR_ID": 4}
        repo.save(ders);
        return "Başarı ile kaydedildi";
    }

    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ders/deleteById/1
        if (repo.deleteById(id)) {
            return "Başarılı ile silindi";
        }
        else {
            return "Silinemedi";
        }
    }

}

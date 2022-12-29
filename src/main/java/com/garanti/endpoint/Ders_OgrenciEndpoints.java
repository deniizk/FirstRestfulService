package com.garanti.endpoint;

import com.garanti.model.Ders_Ogrenci;
import com.garanti.repo.Ders_OgrenciRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "ders_ogrenci")
public class Ders_OgrenciEndpoints {
    private Ders_OgrenciRepo repo;

    public Ders_OgrenciEndpoints()
    {
        this.repo = new Ders_OgrenciRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders_Ogrenci> getAll()
    {
        // localhost:9090/FirstRestfulService/ders_ogrenci/getAll
        return repo.getAll();
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // path param yazarsam bütün param 'lar set edilmiş olmak zorunda
        // localhost:9090/FirstRestfulService/ders_ogrenci/getById/3
        return repo.getById(id);
    }

    //header
    @GET
    @Path(value = "getByIdHeader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders_Ogrenci getByIdHeader(@HeaderParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ders_ogrenci/getByIdHeader
        return repo.getById(id);
    }


    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders_Ogrenci ders_ogrenci)
    {
        // localhost:9090/FirstRestfulService/ders_ogrenci/save
        // {
        //
        //        "DERS_ID": 1,
        //
        //        "DEVAMSIZLIK": 4,
        //
        //        "NOTE": 50,
        //
        //        "OGRENCI_ID": 1
        //
        //    }
        repo.save(ders_ogrenci);
        return "Başarı ile kaydedildi";
    }

    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ders_ogrenci//deleteById/1
        if (repo.deleteById(id)) {
            return "Başarılı ile silindi";
        }
        else {
            return "Silinemedi";
        }
    }

}

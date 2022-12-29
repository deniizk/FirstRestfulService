package com.garanti.endpoint;

import com.garanti.model.Ogretmen;
import com.garanti.repo.OgretmenRepo;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import java.util.ArrayList;

@Path(value = "ogretmen")
public class OgretmenEndpoints {
    //ders öğrenci repoda tüm kolonları içeren constructor oluştur
    private OgretmenRepo repo;

    public OgretmenEndpoints() {
        this.repo = new OgretmenRepo();
    }

    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogretmen> getAll()
    {
        // localhost:9090/FirstRestfulService/ogretmen/getAll
        return repo.getAll();
    }

    @GET
    @Path(value = "getById")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdQueryParam(@QueryParam(value = "id") @NotNull(message = "ID olmak zorunda") Integer id)
    {
        // localhost:9090/FirstRestfulService/ogretmen/getById?id=1
        return repo.getById(id);
    }

    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ogretmen/getById/1
        //bütün parametreleri vermek zorundayız
        //consume restful servisin dışardan alacağı data türünü belirtir
        //produce web servisin dışarıya vereceği türü belirtir
        return repo.getById(id);
    }

    //header
    @GET
    @Path(value = "getByIdHeader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogretmen getByIdHeader(@HeaderParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ogretmen/getByIdHeader
        return repo.getById(id);
    }


    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogretmen ogretmen)
    {
        // localhost:9090/FirstRestfulService/ogretmen/save
        repo.save(ogretmen);
        return "Başarı ile kaydedildi";
    }

    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ogretmen/deleteById/1
        if (repo.deleteById(id)) {
            return "Başarılı ile silindi";
        }
        else {
            return "Silinemedi";
        }
    }

}

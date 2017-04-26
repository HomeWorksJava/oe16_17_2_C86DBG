package com.obudai_egyetem.oe_peterlilli;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.obudai_egyetem.oe_peterlilli.entity.Castingok;
import com.obudai_egyetem.oe_peterlilli.entity.Filmek;
import com.obudai_egyetem.oe_peterlilli.entity.Mufajok;
import com.obudai_egyetem.oe_peterlilli.entity.Szereplok;
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/")
@XmlRootElement
public class REST {

    @Inject
    FilmService filmService;

    @Inject
    SzereploService szereploService;

    @Inject
    CastingService castingService;

    @Inject
    MufajService mufajService;

    /* 
    *****************************************
    FILM - CREATE | READ | UPDATE
    *****************************************
     */
    @GET
    @Path("/read/filmek")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFilmek() {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filmService.Read());

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/create/film")
    public String createFilm(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Filmek obj = mapper.readValue(json, Filmek.class);
            filmService.Create(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @GET
    @Path("/read/film/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String readFilm(@PathParam("id") String id) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(filmService.ReadOne(Integer.parseInt(id)));

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/update/film")
    public String updateFilm(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Filmek obj = mapper.readValue(json, Filmek.class);
            filmService.Update(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }
    
    @POST
    @Path("/delete/film")
    public String deleteFilm(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Filmek obj = mapper.readValue(json, Filmek.class);
            filmService.Delete(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    /* 
    *****************************************
    SZEREPLO - CREATE | READ | UPDATE
    *****************************************
     */
    @GET
    @Path("/read/szereplok")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSzereplok() {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(szereploService.Read());

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/create/szereplo")
    public String createSzereplo(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Szereplok obj = mapper.readValue(json, Szereplok.class);
            szereploService.Create(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @GET
    @Path("/read/szereplo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String readSzereplo(@PathParam("id") String id) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(szereploService.ReadOne(Integer.parseInt(id)));

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/update/szereplo")
    public String updateSzereplo(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Szereplok obj = mapper.readValue(json, Szereplok.class);
            szereploService.Update(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }
    
    @POST
    @Path("/delete/szereplo")
    public String deleteSzereplo(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Szereplok obj = mapper.readValue(json, Szereplok.class);
            szereploService.Delete(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    /* 
    *****************************************
    CASTING - CREATE | READ | UPDATE
    *****************************************
     */
    @GET
    @Path("/read/castingok")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCastingok() {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(castingService.Read());

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/create/casting")
    public String createCasting(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Castingok obj = mapper.readValue(json, Castingok.class);
            castingService.Create(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @GET
    @Path("/read/casting/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String readCasting(@PathParam("id") String id) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(castingService.ReadOne(Integer.parseInt(id)));

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/update/casting")
    public String updateCasting(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Castingok obj = mapper.readValue(json, Castingok.class);
            castingService.Update(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }
    
    @POST
    @Path("/delete/casting")
    public String deleteCasting(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Castingok obj = mapper.readValue(json, Castingok.class);
            castingService.Delete(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    /* 
    *****************************************
    MUFAJ - CREATE | READ | UPDATE
    *****************************************
     */
    @GET
    @Path("/read/mufajok")
    @Produces(MediaType.APPLICATION_JSON)
    public String readMufajok() {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mufajService.Read());

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/create/mufaj")
    public String createMufaj(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Mufajok obj = mapper.readValue(json, Mufajok.class);
            mufajService.Create(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @GET
    @Path("/read/mufaj/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String readMufaj(@PathParam("id") String id) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mufajService.ReadOne(Integer.parseInt(id)));

            return new String(jsonInString);

        } catch (JsonGenerationException e) {
            return e.getMessage();
        } catch (JsonMappingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @POST
    @Path("/update/mufaj")
    public String updateMufaj(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Mufajok obj = mapper.readValue(json, Mufajok.class);
            mufajService.Update(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }
    
    @POST
    @Path("/delete/mufaj")
    public String deleteMufaj(String json) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            Mufajok obj = mapper.readValue(json, Mufajok.class);
            mufajService.Delete(obj);

            mapper = new ObjectMapper();

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            return new String(jsonInString);

        } catch (Exception e) {
            return e.getMessage();
        }

    }

}

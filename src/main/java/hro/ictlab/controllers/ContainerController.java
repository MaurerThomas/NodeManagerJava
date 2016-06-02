package main.java.hro.ictlab.controllers;

import main.java.hro.ictlab.Database.Connector;
import main.java.hro.ictlab.services.ContainerRepository;
import org.json.JSONArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/containers")
public class ContainerController {

    private ContainerRepository containerRepository = new ContainerRepository();
    private Connector connector = new Connector();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContainers() throws IOException {
        return Response.ok().entity(containerRepository.getAllContainers().toString()).build();
    }

    @GET
    @Path("/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContainerById(@PathParam("id") String id) throws IOException {
        String output = connector.main();
        return Response.ok().entity(output).build();
    }
}

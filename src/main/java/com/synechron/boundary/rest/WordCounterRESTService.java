package com.synechron.boundary.rest;

import com.synechron.service.WordCountService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/word-counter")
public class WordCounterRESTService {

    @Inject
    WordCountService wordCountService;

    /**
     * Add one or more items to our Word Counter.
     *
     * @param list list
     * @return Response
     */
    @POST
    @Path("/add")
    public Response add(@QueryParam("words") final List<String> list) {
        wordCountService.add(list);
        return Response.ok("Invoked Successfully").build();
    }

    /**
     * Return a count on how many times a given word has been added to the counter.
     *
     * @param word word
     * @return Response
     */
    @GET
    @Path("/count")
    public Response count(@QueryParam("word") final String word) {
        return Response.ok(wordCountService.count(word)).build();
    }

}

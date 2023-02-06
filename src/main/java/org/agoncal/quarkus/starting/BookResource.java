package org.agoncal.quarkus.starting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Amour de vie", "Donald Donchi", 2022, "Romantique"),
                new Book(2, "Tuerie", "Donald Donchi", 2023, "Action"),
                new Book(3, "GP Valser", "Donald Donchi", 2022, "Assasin")
        );
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks(){
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(
                book -> book.id == id).findFirst();
    }


}
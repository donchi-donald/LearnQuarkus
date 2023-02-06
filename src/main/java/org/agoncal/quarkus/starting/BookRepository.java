package org.agoncal.quarkus.starting;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {


    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Amour de vie", "Donald Donchi", 2022, "Romantique"),
                new Book(2, "Tuerie", "Donald Donchi", 2023, "Action"),
                new Book(3, "GP Valser", "Donald Donchi", 2022, "Assasin")
        );
    }


    public int countAllBooks(){
        return getAllBooks().size();
    }


    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(
                book -> book.id == id).findFirst();
    }
}

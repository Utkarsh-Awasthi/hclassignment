package lms.co;

import lms.co.controller.BookControllerImpl;
import lms.co.model.Book;
import lms.co.repository.BookRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LMSApplication.class)
@WebAppConfiguration
public class BooksResourceITTest {

    private MockMvc mockMvc;

    @Autowired
    private BookRepository booksRepo;

    private BookControllerImpl booksResource;

    @Before("")
    public void setup(){
        MockitoAnnotations.initMocks(this);
        booksResource = new BookControllerImpl();
        mockMvc = MockMvcBuilders.standaloneSetup(booksResource).build();
        ReflectionTestUtils.setField(booksResource, "booksRepo", booksRepo);
    }

    @Test
    public void getBooksTest() throws Exception {
        Book book1 = new Book("isbn3","Test3","Test Author","","","","","");

        Book book2 = new Book("isbn4","Test4","Test Author","","","","","");
        MvcResult result = mockMvc.perform(get("/api/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].title", hasItems("Test4", "Test3")))
                .andReturn();
    }
}

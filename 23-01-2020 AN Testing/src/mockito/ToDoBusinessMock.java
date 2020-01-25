package mockito;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ToDoBusinessMock {
    @Test
    public void testUsingMocks(){
        ToDoService toDoService = mock(ToDoService.class);
        List<String> list  = Arrays.asList("logesh", "rajini", "vijay");
        when(toDoService.getTodos("logesh")).thenReturn(list);

        ToDoBusiness business = new ToDoBusiness(toDoService);
        list = business.getTodosforHibernate("logesh");
        System.out.println(list);
    }
}
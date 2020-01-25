package mockito;

import java.util.ArrayList;
import java.util.List;

// ToDoBusiness is a SUT (system under test)   
// ToDoService is a Dependency (as ToDoBusiness is dependent on it)  

public class ToDoBusiness {

    public ToDoService doService;

    public ToDoBusiness(ToDoService doService) {
        this.doService = doService;
    }

    public List<String> getTodosforHibernate(String user) {

        List<String> hibernatelist = new ArrayList<String>();
        List<String> Combinedlist = doService.getTodos(user);

        for (String todo : Combinedlist) {
            if (todo.contains("logesh")) {
                hibernatelist.add(todo);
            }
        }

        return hibernatelist;
    }
}
import controllers.Controller;
import controllers.SortingMethos;
import controllers.SearchMethos;
import views.View;

public class App {
    public static void main(String[] args) {
        View view = new View();
        SortingMethos sorter = new SortingMethos();
        SearchMethos searcher = new SearchMethos();
        Controller controller = new Controller(view, sorter, searcher);

        controller.start();
    }
}


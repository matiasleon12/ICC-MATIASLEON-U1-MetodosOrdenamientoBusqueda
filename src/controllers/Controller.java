package controllers;
import models.Person;
import views.View;

public class Controller {
    private View view;
    private SortingMethos sorter;
    private SearchMethos searcher;
    private Person[] persons = new Person[10];
    private int count = 0;
    public Controller(View view, SortingMethos sorter, SearchMethos searcher) {
        this.view = view;
        this.sorter = sorter;
        this.searcher = searcher;
    }
    public void start(){
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    inputPersons();
                    break;
                case 2:
                    view.displayPersons(getCurrentPersons());
                    break;
                case 3:
                    sortPersons();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 5);

    }
    public void inputPersons() {
        Person p = view.inputPerson();
        if (count < persons.length) {
            persons[count++] = p;
        } else {
            System.out.println("Lista llena");
        }
    }
    public Person[] getCurrentPersons() {
        Person[] current = new Person[count];
        for (int i = 0; i < count; i++) {
            current[i] = persons[i];
        }
        return current;
    }

    public void sortPersons() {
        int method = view.selectSortingMethod();
        Person[] current = getCurrentPersons();

        switch (method) {
            case 1:
                sorter.sortByNameWithBubble(current);
                break;
            case 2:
                sorter.sortByNameWithSelectionDes(current);
                break;
            case 3:
                sorter.sortByAgeWithInsertion(current);
                break;
            case 4:
                sorter.sortByNameWithInsertion(current);
                break;
            default:
                System.out.println("Método inválido.");
        }
        for (int i = 0; i < count; i++) {
            persons[i] = current[i];
        }
    }

    public void searchPerson() {
        int criterion = view.selectSearchCriterion();
        Person[] current = getCurrentPersons();

        if (criterion == 1) {
            if (!searcher.isSortedByName(current)) {
                System.out.println("La lista no está ordenada por nombre. Ordenando...");
                sorter.sortByNameWithBubble(current);
            }
            String name = view.inputName();
            Person result = searcher.binarySearchByName(current, name);
            view.displaySearchResult(result);
        } else if (criterion == 2) { 
            if (!searcher.isSortedByAge(current)) {
                System.out.println("La lista no está ordenada por edad. Ordenando...");
                sorter.sortByAgeWithInsertion(current);
            }
            int age = view.inputAge();
            Person result = searcher.binarySearchByAge(current, age);
            view.displaySearchResult(result);
        } else {
            System.out.println("Criterio inválido.");
        }
    }
    
}

package views;

import java.util.Scanner;

import models.Person;

public class View {
    private Scanner scanner=new Scanner(System.in);

    public int showMenu(){
        System.out.println("-----Menu-----");
        System.out.println("1. Ingresar Perosnas ");
        System.out.println("2. Mostrar Personas ");
        System.out.println("3. Ordenar Personas ");
        System.out.println("4. Buscar Personas ");
        System.out.println("5. Salir ");
        System.out.println( "Escoja una opcion");
        return scanner.nextInt();
    }
    public Person inputPerson(){
        scanner.nextLine(); 
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Edad: ");
        int age = scanner.nextInt();
        return new Person(name, age);
    }
    public String inputName(){
        scanner.nextLine();
        System.out.println("Ingrese el nombre que desea ordenar");
        return scanner.nextLine();
    }
    public int inputAge(){
        System.out.println("Ingrese la edad  que deea ordenar");
        return scanner.nextInt();
    
    }
    public int selectSortingMethod(){
        scanner.nextLine();
        System.out.println("----Metodos de Ordenamienmto----");
        System.out.println("1. metodo Borbuja por nombres " );
        System.out.println("2. Metodo De Seleccion por nombres Ascendentente");
        System.out.println("3. Insercion por edad");
        System.out.println("4. Insercion por nombre");
        return scanner.nextInt();
    }
    public int selectSearchCriterion() {
        System.out.println("\n--- Buscar por ---");
        System.out.println("1. Nombre");
        System.out.println("2. Edad");
        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }
    public void displayPersons(Person[] people){
        System.out.println("----Lista De Perosnas----");
        for (Person p : people) {
            if (p != null) {
                System.out.println("Nombre: " + p.getName() + ", Edad: " + p.getAge());
            }
        }
    }
    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Resultado encontrado:");
            System.out.println("Nombre: " + person.getName() + ", Edad: " + person.getAge());
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
        
    
}

package controllers;

import models.Person;

public class SortingMethos {
    public void sortByNameWithBubble(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[j + 1].getName()) > 0) {
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }    
    
    }  
    public void sortByNameWithSelectionDes(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < persons.length; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[maxIdx].getName()) > 0) {
                    maxIdx = j;
                }
            }
            Person temp = persons[i];
            persons[i] = persons[maxIdx];
            persons[maxIdx] = temp;
        }
    } 
    public void sortByAgeWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getAge() > key.getAge()) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = key;
        }
    }

    public void sortByNameWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            Person key = persons[i];
            int j = i - 1;
            while (j >= 0 && persons[j].getName().compareToIgnoreCase(key.getName()) > 0) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = key;
        }
    } 
}

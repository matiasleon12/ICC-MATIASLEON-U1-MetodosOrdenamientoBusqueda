package controllers;

import models.Person;

public class SearchMethos {

    public Person binarySearchByName(Person[] persons, String name) {
        int low = 0;
        int high = persons.length - 1;
    
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = persons[mid].getName().compareToIgnoreCase(name);

            if (cmp == 0) {
                return persons[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    
        return null;
    }
    
        public Person binarySearchByAge(Person[] persons, int age) {
            int low = 0;
            int high = persons.length - 1;
    
            while (low <= high) {
                int mid = (low + high) / 2;
                if (persons[mid].getAge() == age) {
                    return persons[mid];
                } else if (persons[mid].getAge() < age) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
    
            return null;
        }
    
        public boolean isSortedByName(Person[] persons) {
            for (int i = 0; i < persons.length - 1; i++) {
                if (persons[i].getName().compareToIgnoreCase(persons[i + 1].getName()) > 0) {
                    return false;
                }
            }
            return true;
        }
    
        public boolean isSortedByAge(Person[] persons) {
            for (int i = 0; i < persons.length - 1; i++) {
                if (persons[i].getAge() > persons[i + 1].getAge()) {
                    return false;
                }
            }
            return true;
        }
    

    
}

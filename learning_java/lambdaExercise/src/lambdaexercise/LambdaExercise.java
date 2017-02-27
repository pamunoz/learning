/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdaexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author pablo
 */
public class LambdaExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Person> people = Arrays.asList(
                new Person("Pablo", "Farias", 33),
                new Person("Cri2", "Rojas", 27),
                new Person("Robert", "dias", 23),
                new Person("Andrea", "Rojas2", 26),
                new Person("Cristopher3", "Cunt", 57),
                new Person("Guaton", "Guata", 37),
                new Person("Cristopher6", "Rojas5", 27),
                new Person("Cristopher7", "careraja", 27),
                new Person("Cristopher8", "holandes", 27),
                new Person("Bernard", "ipocrita", 17),
                new Person("Cristopher10", "Aguayo", 67),
                new Person("Cristopher11", "cocuyo", 27),
                new Person("Cristopher12", "Rojas11", 87),
                new Person("Diego", "Rojas12", 67),
                new Person("Cristopher14", "baca", 27),
                new Person("Cristopher15", "Cagadiña", 47),
                new Person("Cristopher16", "foca", 37),
                new Person("Francisco", "Rojas16", 87),
                new Person("Cristopher18", "guata", 27)
        );

        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).getLastName());

        }

        System.out.println("/////////////////////////");

        // Step 1: Sort list by last name
      
        Collections.sort(people, (Person p1, Person p2) -> 
                p1.getLastName().toLowerCase().compareTo(p2.getLastName().toLowerCase()));

        // Step 2: Create a method that prints all element in the list
        DoSomethingToList printAll = () -> {
            for (int i = 0; i < people.size(); i++) {
                System.out.println(people.get(i).getLastName());

            }
        };
        
        printAll.doAction();
        
        System.out.println("---------****----------------**********");
        
        

        // Step 3: Create a method that prints all the people that have last name
        // beginning with c
        
        DoSomethingToList printAllClastName = () -> {
            for (Person person : people) {
                
                if (person.getLastName().toLowerCase().substring(0, 1).equals("c")) {
                    System.out.println(person.toString());
                }
            }
        };
        System.out.println("/////////////////////////");
        printAllClastName.doAction();
    }

    interface DoSomethingToList {

        void doAction();
    }
    
    

}

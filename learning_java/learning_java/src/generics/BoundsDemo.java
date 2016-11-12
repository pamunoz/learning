package generics;

/**
 *
 * @author pablo
 */
/*
In this version of Stats, the type argument for
T must be either Number, or a class derived
from Number.
*/
class Stats<T extends Number> {
    T[] nums; // array of Number or subclass
    /*
    Pass the constructor a reference to
    an array of type Number of subclass
    */
    Stats(T[] o) {
        nums = o;
    }
    
    // Return type double in all cases
    double average() {
        double sum = 0.0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }
    
    /*
    Determine if two averages are the same.
    Notice the use of the wildcard.
    */
    boolean sameAvg(Stats<?> ob) {
        return this.average() == ob.average();       
    }
    /*
    It is important to understant that the wildcard
    does not affect what type of Stats objects can be
    created. This is governed by the extends clause 
    in the Stats declaration. The wildcard simply 
    matches any valid Stats object.
    */
}

// Demostrates Stats
class BoundsDemo {
    public static void main(String[] args) {
        
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> iOb = new Stats<Integer>(inums);
        double v = iOb.average();
        System.out.println("iOb average is: " + v);
        
        Double dnums[] = {1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats<Double> dob = new Stats<Double>(dnums);
        double w = dob.average();
        System.out.println("dob average is: " + w);
        
        /*
        This won't compile because String is not
        a subclass of Number.
        */
//        String strs[] = {"1", "2", "3", "4", "5"};
//        Stats<String> strob = new Stats<String>(strs);
//        
//        double x = strob.average();
//        System.out.println("strob average is: " + x);
//        
    }
    
}

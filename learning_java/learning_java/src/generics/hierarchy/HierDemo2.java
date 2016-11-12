package generics.hierarchy;

/*
A non-generic class can be the superclass of a generic
subclass.
*/

// A non-generic class
class NonGen {
    int num;

    public NonGen(int i) {
        this.num = i;
    }

    public int getNum() {
        return num;
    }
}

// a generic subclass
class SubGen<T> extends NonGen {
    T ob; // declare an object of type T
    
    /*
    Pass the constructor a reference
    to an object of type T
    */

    public SubGen(T o, int i) {
        super(i);
        this.ob = o;
    }
    
    // Return ob
    T getob() {
        return ob;
    }
}

// Create a SubGen object
public class HierDemo2 {
    public static void main(String[] args) {
        
        // Create a SubGen object for String
        SubGen<String> w = new SubGen<String>("Hello", 47);
        
        System.out.print(w.getob() + " ");
        System.out.println(w.getNum());
    }
}
    

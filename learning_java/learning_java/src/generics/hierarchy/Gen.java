package generics.hierarchy;

/**
 * In generic hierarcky, any type arguments
 * needed by a geeric super class must be 
 * passed up the hierarcky by all subclasses.
 */
public class Gen<T> {
    T ob;

    public Gen(T o) {
        this.ob = o;
    }
    
    // Return ob.
    T getob() {
        return ob;
    }
}

// A subclass of Gen.
class Gen2<T> extends Gen<T> {

    public Gen2(T o) {
        super(o);
    }
}

package lambdaexpression;

// Demostrate a simple lambda expression.

// A functional interface.
interface MyNumber {
    double getValue();
}

class LambdaDemo {
    public static void main(String[] args) {
        
        MyNumber myNumber;
        
        /*
        Here, the lambda expression is simply a constant expression.
        When it is assigned to myNum, a class instance is
        constructed in which the lambda expression implements
        the getValue() method in MyNumber.
        */
        myNumber = () -> 123.24;
        
        /*
        Call getValue(), which is provided by the previous assigned
        lambda expression.
        */
        System.out.println("A fixed value: " + myNumber.getValue());
        
        // Here, a more complex expression is used.
        myNumber = () -> Math.random() * 100;
        
        // These call the lambda expression in the previous line.
        System.out.println("A random value: " + myNumber.getValue());
        System.out.println("Another random value: " + myNumber.getValue());
        
        /*
        A lambda expression must be compatible with the method
        defined by the functional interface. Therefore, this won't work.
        */
//        myNumber = () -> "123.03"; // Error!!
    }
    
}

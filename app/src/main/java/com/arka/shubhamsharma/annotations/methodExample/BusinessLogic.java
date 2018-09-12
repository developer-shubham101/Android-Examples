package com.arka.shubhamsharma.annotations.methodExample;

public class BusinessLogic {

    private int value = 0;

    public BusinessLogic(int value) {
        this.value = value;
    }

    public void compltedMethod() {
        System.out.println("This method is complete");
    }

    @Todo(priority = Todo.Priority.HIGH)
    public void notYetStartedMethod() {
        // No Code Written yet
        System.out.println(value + " * " + value + " = " + (value * value));
    }

    @Todo(priority = Todo.Priority.MEDIUM, author = "Uday", status = Todo.Status.STARTED)
    public void incompleteMethod1() {
        //Some business logic is written
        //But its not complete yet

        System.out.println(value + " + " + value + " = " + (value + value));
    }

    @Todo(priority = Todo.Priority.LOW, status = Todo.Status.STARTED)
    public void incompleteMethod2() {
        //Some business logic is written
        //But its not complete yet
        System.out.println(value);
    }
}

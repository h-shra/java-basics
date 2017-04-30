package basics.oop.polymorphism;

public class Child extends Parent {

    public static void main(String[] args) {
        Child child = new Child();
    }

    /**
     * A child class cannot override final methods of parent.
     * We get a compilation error here.
     * Without Override, cannot have a method with same signature as well!!
     */
    //@Override
    //public void finalParentMethod() {

    //}

    /**
     * A child class cannot override static methods of parent.
     * We get a compilation error here.
     */
    //@Override
    public static void staticParentMethod() {
        System.out.println("From the A child's static method");
    }

    /**
     * A child class cannot override private methods of parent.
     * We get a compilation error here.
     */
    //@Override
    private void privateParentMethod() {

    }

    /**
     * A child can override protected parent method.
     */
    @Override
    protected void protectedParentMethod() {
        //A child can see super.protectedParentMethod();
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        System.out.println("In child");
    }

    /**
     * A child can always override, use, see parent's public method.
     */
    @Override
    public void publicParentMethod() {
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    /**
     * Number and/or type of parameters can change for overloading a method.
     * Has to follow same return type.
     * This is actually overridden method from parent.
     */
    private void childMethodForOverLoading(String s) {
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    private void childMethodForOverLoading(int count) {
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    /**
     * Number and/or type of parameters can change for overloading a method.
     * Has to follow same return type.
     * This is actually overridden method from parent.
     */
    public void parentMethodForOverloading(String s) {
        System.out.println("String " + s);
    }

}

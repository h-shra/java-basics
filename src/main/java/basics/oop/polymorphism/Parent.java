package basics.oop.polymorphism;

public class Parent {

    //NOTE: binding of static, final and private methods is always a static binding

    /**
     * A child cannot override final method of parent.
     * A child cannot have a method with same signature as well!!
     */
    public final void finalParentMethod() {
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    /**
     * A child cannot override static method of parent.
     */
    public static void staticParentMethod() {
        System.out.println("From the parent's static method");
    }

    /**
     * A child cannot override private method of parent.
     * A child cannot see / use super.private method.
     */
    private void privateParentMethod() {
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    /**
     * A child can see / use super.protected method.
     */
    protected void protectedParentMethod() {
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    public void publicParentMethod() {
        System.out.println(this.getClass().getName());
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    public void parentMethodForOverloading(String s) {
        System.out.println("String " + s);
    }
}
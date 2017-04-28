package basics.oop.overriding;

public class ParentChildTest {
    /**
     * Important Points
     * Private, final and static members (methods and variables) use static binding.
     * Virtual methods are bound during run time based upon run time object.
     * <p>
     * Static binding uses Reference Type information for binding.
     * Dynamic binding uses Objects to resolve binding.
     * <p>
     * Overloaded methods are resolved using static binding.
     * Overridden methods using dynamic binding, i.e, at run time.
     */

    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        parent.publicParentMethod();
        child.publicParentMethod();

        /**
         * During compilation, the compiler doesn't know which class's protectedParentMethod to
         * call, since compiler goes only by referencing variable not by type of object,
         * The binding would be delayed to runtime and protectedParentMethod will be
         * called based on type on object.
         * */
        Parent parent1 = new Parent();
        Parent parent2 = new Child();
        parent1.protectedParentMethod();
        parent2.protectedParentMethod();//Calls child's method

        //Compilation error here
        //Child child1 = new Parent();

    }
}

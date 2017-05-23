package designpatterns.creational.singleton;

/**
 * Enum class compiles to have static final variables with private constructor.
 * It disallows clone(), supports Serialization and is thread safe.
 */
public enum SingletonViaEnum {
    INSTANCE_ONE,
    INSTANCE_TWO;

    private String text;

    //explicit constructor
    private SingletonViaEnum() {
        text = "Concise, pro serialization, guaranteed for single instantiation";
    }
}

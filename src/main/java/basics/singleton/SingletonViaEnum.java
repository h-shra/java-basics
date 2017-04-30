package basics.singleton;

/**
 * Enum class compiles to have static final variables with private constructor.
 * It disallows clone(), supports Serialization.
 */
public enum SingletonViaEnum {
    INSTANCE;
    private String text;

    //explicit constructor
    private SingletonViaEnum() {
        text = "Concise, pro serialization, guaranteed for single instantiation";
    }
}

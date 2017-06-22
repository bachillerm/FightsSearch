package main.java.enums;

/**
 * Class that stores all the airline«s information.
 * @author martabachiller
 *
 */
public enum Airline {
    IBERIA ("IB", 10f),
    BRITISH_AIRWAYS ("BA", 15f),
    LUFTHANSA ("LH", 7f),
    RYANAIR ("FR", 20f),
    VUELING ("VY", 10f),
    TURKISH_AIRLINES ("TK", 5f),
    EASYJET ("U2", 19.90f)
    ;

    Airline(String code, Float infantPrice) {
        this.code = code;
        this.infantPrice = infantPrice;
    }

    private final String code;
    private final Float infantPrice;

    public String getCode() {
        return code;
    }

    public Float getInfantPrice() {
        return infantPrice;
    }

    @Override
    public String toString() {
        return getCode();
    }

}


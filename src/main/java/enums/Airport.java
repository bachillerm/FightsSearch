package main.java.enums;

/**
 * Class that stores all the airport«s information.
 * @author martabachiller
 *
 */
public enum Airport {
    MADRID ("MAD"),
    BARCELONA ("BCN"),
    LONDON ("LHR"),
    PARIS ("CDG"),
    FRANKFURT ("FRA"),
    ISTANBUL ("IST"),
    AMSTERDAM ("AMS"),
    ROME ("FCO"),
    COPENHAGEN ("CPH")
    ;

    Airport(String code) {
        this.code = code;
    }

    private final String code;

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return getCode();
    }
}


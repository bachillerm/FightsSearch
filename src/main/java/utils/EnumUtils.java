package main.java.utils;

/**
 * Class that stores helper methods for enums.
 * @author martabachiller
 *
 */
public class EnumUtils {

	    public static <T extends Enum<T>> Enum search (Class<T> e, String code) {
	        for (T en : e.getEnumConstants()) {
	            if (en.toString().equals(code)) {
	                return en;
	            }
	        }
	        return null;
	    }
}

package ldk.l.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Util {
    public static String readTextFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean isNumberValue(Object v) {
        return Util.isIntegerValue(v) || Util.isDecimalValue(v);
    }

    public static boolean isIntegerValue(Object v) {
        return v instanceof Byte || v instanceof Short || v instanceof Integer || v instanceof Long;
    }

    public static boolean isDecimalValue(Object v) {
        return v instanceof Float || v instanceof Double;
    }
}
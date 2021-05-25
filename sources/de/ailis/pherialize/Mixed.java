package de.ailis.pherialize;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
public class Mixed implements Serializable, Comparable<Object> {
    public static final int TYPE_ARRAY = 9;
    public static final int TYPE_BOOLEAN = 7;
    public static final int TYPE_BYTE = 1;
    public static final int TYPE_CHAR = 0;
    public static final int TYPE_DOUBLE = 6;
    public static final int TYPE_FLOAT = 5;
    public static final int TYPE_INT = 3;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_SHORT = 2;
    public static final int TYPE_STRING = 8;
    public static final int TYPE_UNKNOWN = -1;
    private static final long serialVersionUID = -599069055376420973L;
    public Object a;
    public final int b;

    public Mixed(Object obj) {
        int typeOf = getTypeOf(obj);
        this.b = typeOf;
        if (typeOf == 8) {
            this.a = obj.toString();
        } else if (typeOf != 9) {
            this.a = obj;
        } else if (obj instanceof MixedArray) {
            this.a = obj;
        } else if (obj instanceof List) {
            this.a = new MixedArray((List) obj);
        } else {
            this.a = new MixedArray((Map) obj);
        }
    }

    public static int getTypeOf(Object obj) {
        if (obj instanceof String) {
            return 8;
        }
        if (obj != null && obj.getClass().isEnum()) {
            return 8;
        }
        boolean z = obj instanceof Integer;
        if (z) {
            return 3;
        }
        if ((obj instanceof List) || (obj instanceof Map)) {
            return 9;
        }
        if (obj instanceof Character) {
            return 0;
        }
        if (obj instanceof Byte) {
            return 1;
        }
        if (obj instanceof Short) {
            return 2;
        }
        if (z) {
            return 3;
        }
        if (obj instanceof Long) {
            return 4;
        }
        if (obj instanceof Float) {
            return 5;
        }
        if (obj instanceof Double) {
            return 6;
        }
        return obj instanceof Boolean ? 7 : -1;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof Mixed) {
            return ((Comparable) this.a).compareTo(((Mixed) obj).a);
        }
        return ((Comparable) this.a).compareTo(obj);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Mixed) {
            return toString().equals(obj.toString());
        }
        return toString().equals(obj.toString());
    }

    public int getType() {
        return this.b;
    }

    public Object getValue() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isArray() {
        return this.b == 9;
    }

    public boolean isBoolean() {
        return this.b == 7;
    }

    public boolean isByte() {
        return this.b == 1;
    }

    public boolean isChar() {
        return this.b == 0;
    }

    public boolean isDouble() {
        return this.b == 6;
    }

    public boolean isFloat() {
        return this.b == 5;
    }

    public boolean isInt() {
        return this.b == 3;
    }

    public boolean isLong() {
        return this.b == 4;
    }

    public boolean isNumber() {
        return isFloat() || isDouble() || isByte() || isShort() || isInt() || isLong();
    }

    public boolean isShort() {
        return this.b == 2;
    }

    public boolean isString() {
        return this.b == 8;
    }

    public MixedArray toArray() {
        if (this.a != null && isArray()) {
            return (MixedArray) this.a;
        }
        return null;
    }

    public boolean toBoolean() {
        if (this.a == null) {
            return false;
        }
        if (isBoolean()) {
            return ((Boolean) this.a).booleanValue();
        }
        if (isString()) {
            if (toString().length() > 0) {
                return true;
            }
            return false;
        } else if (isNumber()) {
            if (toDouble() != 0.0d) {
                return true;
            }
            return false;
        } else if (isChar()) {
            if (toChar() != 0) {
                return true;
            }
            return false;
        } else if (!isArray() || toArray().size() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public byte toByte() {
        int i = 0;
        if (this.a == null) {
            return 0;
        }
        if (isBoolean()) {
            return toBoolean() ? (byte) 1 : 0;
        }
        if (isArray()) {
            if (((MixedArray) this.a).size() != 0) {
                i = 1;
            }
            return (byte) i;
        }
        try {
            return (byte) ((int) toLong());
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public char toChar() {
        int i = 0;
        if (this.a == null) {
            return 0;
        }
        if (isArray()) {
            if (((MixedArray) this.a).size() != 0) {
                i = 1;
            }
            return (char) i;
        } else if (toString().length() > 0) {
            return toString().charAt(0);
        } else {
            return 0;
        }
    }

    public double toDouble() {
        if (this.a == null) {
            return 0.0d;
        }
        if (isBoolean()) {
            if (toBoolean()) {
                return 1.0d;
            }
            return 0.0d;
        } else if (!isArray()) {
            try {
                return Double.parseDouble(this.a.toString());
            } catch (NumberFormatException unused) {
                return 0.0d;
            }
        } else if (((MixedArray) this.a).size() == 0) {
            return 0.0d;
        } else {
            return 1.0d;
        }
    }

    public float toFloat() {
        if (this.a == null) {
            return 0.0f;
        }
        if (isBoolean()) {
            if (toBoolean()) {
                return 1.0f;
            }
            return 0.0f;
        } else if (!isArray()) {
            try {
                return Float.parseFloat(this.a.toString());
            } catch (NumberFormatException unused) {
                return 0.0f;
            }
        } else if (((MixedArray) this.a).size() == 0) {
            return 0.0f;
        } else {
            return 1.0f;
        }
    }

    public int toInt() {
        if (this.a == null) {
            return 0;
        }
        if (isBoolean()) {
            return toBoolean() ? 1 : 0;
        }
        if (!isArray()) {
            try {
                return (int) toLong();
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else if (((MixedArray) this.a).size() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public long toLong() {
        if (this.a == null) {
            return 0;
        }
        if (isBoolean()) {
            if (toBoolean()) {
                return 1;
            }
            return 0;
        } else if (!isArray()) {
            try {
                return (long) toDouble();
            } catch (NumberFormatException unused) {
                return 0;
            }
        } else if (((MixedArray) this.a).size() == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public short toShort() {
        int i = 0;
        if (this.a == null) {
            return 0;
        }
        if (isBoolean()) {
            return toBoolean() ? (short) 1 : 0;
        }
        if (isArray()) {
            if (((MixedArray) this.a).size() != 0) {
                i = 1;
            }
            return (short) i;
        }
        try {
            return (short) ((int) toLong());
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        Object obj = this.a;
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Object toType(int i) {
        if (this.b == i) {
            return this.a;
        }
        switch (i) {
            case 0:
                return Character.valueOf(toChar());
            case 1:
                return Byte.valueOf(toByte());
            case 2:
                return Short.valueOf(toShort());
            case 3:
                return Integer.valueOf(toInt());
            case 4:
                return Long.valueOf(toLong());
            case 5:
                return Float.valueOf(toFloat());
            case 6:
                return Double.valueOf((double) toFloat());
            case 7:
                return Boolean.valueOf(toBoolean());
            case 8:
                return toString();
            case 9:
                return toArray();
            default:
                return this.a;
        }
    }

    public Mixed(char c) {
        this.a = Character.valueOf(c);
        this.b = 0;
    }

    public Mixed(byte b2) {
        this.a = Byte.valueOf(b2);
        this.b = 1;
    }

    public Mixed(short s) {
        this.a = Short.valueOf(s);
        this.b = 2;
    }

    public Mixed(int i) {
        this.a = Integer.valueOf(i);
        this.b = 3;
    }

    public Mixed(long j) {
        this.a = Long.valueOf(j);
        this.b = 4;
    }

    public Mixed(float f) {
        this.a = Float.valueOf(f);
        this.b = 5;
    }

    public Mixed(double d) {
        this.a = Double.valueOf(d);
        this.b = 6;
    }

    public Mixed(boolean z) {
        this.a = Boolean.valueOf(z);
        this.b = 7;
    }
}

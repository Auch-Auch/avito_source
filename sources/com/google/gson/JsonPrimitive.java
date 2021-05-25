package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
public final class JsonPrimitive extends JsonElement {
    public final Object a;

    public JsonPrimitive(Boolean bool) {
        this.a = C$Gson$Preconditions.checkNotNull(bool);
    }

    public static boolean a(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.a == null) {
            if (jsonPrimitive.a == null) {
                return true;
            }
            return false;
        } else if (!a(this) || !a(jsonPrimitive)) {
            Object obj2 = this.a;
            if (!(obj2 instanceof Number) || !(jsonPrimitive.a instanceof Number)) {
                return obj2.equals(jsonPrimitive.a);
            }
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object obj = this.a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(this.a.toString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object obj = this.a;
        return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(this.a.toString());
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((Boolean) this.a).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object obj = this.a;
        return obj instanceof String ? new LazilyParsedNumber((String) this.a) : (Number) obj;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((Boolean) this.a).toString();
        }
        return (String) this.a;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean isBoolean() {
        return this.a instanceof Boolean;
    }

    public boolean isNumber() {
        return this.a instanceof Number;
    }

    public boolean isString() {
        return this.a instanceof String;
    }

    public JsonPrimitive(Number number) {
        this.a = C$Gson$Preconditions.checkNotNull(number);
    }

    public JsonPrimitive(String str) {
        this.a = C$Gson$Preconditions.checkNotNull(str);
    }

    public JsonPrimitive(Character ch) {
        this.a = ((Character) C$Gson$Preconditions.checkNotNull(ch)).toString();
    }
}

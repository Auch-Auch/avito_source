package com.avito.android.remote;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\"\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0019\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u0011*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u0015*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0019\u0010 \u001a\u0004\u0018\u00010\u001d*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0019\u0010$\u001a\u0004\u0018\u00010!*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0019\u0010(\u001a\u0004\u0018\u00010%*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0019\u0010,\u001a\u0004\u0018\u00010)*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0019\u00100\u001a\u0004\u0018\u00010-*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0019\u00104\u001a\u0004\u0018\u000101*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b2\u00103\"\u0019\u00108\u001a\u0004\u0018\u000105*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b6\u00107\"\u0019\u0010<\u001a\u0004\u0018\u000109*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/google/gson/JsonElement;", "", "getAsNumberOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Number;", "asNumberOrNull", "Lcom/google/gson/JsonPrimitive;", "getAsJsonPrimitiveOrNull", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonPrimitive;", "asJsonPrimitiveOrNull", "", "getAsShortOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Short;", "asShortOrNull", "", "getAsIntOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;", "asIntOrNull", "Ljava/math/BigInteger;", "getAsBigIntegerOrNull", "(Lcom/google/gson/JsonElement;)Ljava/math/BigInteger;", "asBigIntegerOrNull", "Ljava/math/BigDecimal;", "getAsBigDecimalOrNull", "(Lcom/google/gson/JsonElement;)Ljava/math/BigDecimal;", "asBigDecimalOrNull", "", "getAsStringOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/String;", "asStringOrNull", "Lcom/google/gson/JsonObject;", "getAsJsonObjectOrNull", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;", "asJsonObjectOrNull", "", "getAsFloatOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Float;", "asFloatOrNull", "Lcom/google/gson/JsonArray;", "getAsJsonArrayOrNull", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;", "asJsonArrayOrNull", "", "getAsByteOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Byte;", "asByteOrNull", "", "getAsCharOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Character;", "asCharOrNull", "", "getAsBooleanOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Boolean;", "asBooleanOrNull", "", "getAsDoubleOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Double;", "asDoubleOrNull", "", "getAsLongOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Long;", "asLongOrNull", "gson"}, k = 2, mv = {1, 4, 2})
public final class JsonElementsKt {
    @Nullable
    public static final BigDecimal getAsBigDecimalOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asBigDecimalOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsBigDecimal();
    }

    @Nullable
    public static final BigInteger getAsBigIntegerOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asBigIntegerOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsBigInteger();
    }

    @Nullable
    public static final Boolean getAsBooleanOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asBooleanOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Boolean.valueOf(jsonElement.getAsBoolean());
    }

    @Nullable
    public static final Byte getAsByteOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asByteOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Byte.valueOf(jsonElement.getAsByte());
    }

    @Nullable
    public static final Character getAsCharOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asCharOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Character.valueOf(jsonElement.getAsCharacter());
    }

    @Nullable
    public static final Double getAsDoubleOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asDoubleOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Double.valueOf(jsonElement.getAsDouble());
    }

    @Nullable
    public static final Float getAsFloatOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asFloatOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Float.valueOf(jsonElement.getAsFloat());
    }

    @Nullable
    public static final Integer getAsIntOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asIntOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Integer.valueOf(jsonElement.getAsInt());
    }

    @Nullable
    public static final JsonArray getAsJsonArrayOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asJsonArrayOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsJsonArray();
    }

    @Nullable
    public static final JsonObject getAsJsonObjectOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asJsonObjectOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsJsonObject();
    }

    @Nullable
    public static final JsonPrimitive getAsJsonPrimitiveOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asJsonPrimitiveOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsJsonPrimitive();
    }

    @Nullable
    public static final Long getAsLongOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asLongOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Long.valueOf(jsonElement.getAsLong());
    }

    @Nullable
    public static final Number getAsNumberOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asNumberOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsNumber();
    }

    @Nullable
    public static final Short getAsShortOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asShortOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return Short.valueOf(jsonElement.getAsShort());
    }

    @Nullable
    public static final String getAsStringOrNull(@NotNull JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "$this$asStringOrNull");
        if (jsonElement.isJsonNull()) {
            return null;
        }
        return jsonElement.getAsString();
    }
}

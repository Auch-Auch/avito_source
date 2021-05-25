package com.avito.android.util;

import a2.b.a.a.a;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a0\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\b\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u0003H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0000H\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u0000H\b¢\u0006\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"Lcom/google/gson/stream/JsonReader;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "fieldConsumer", "readObject", "(Lcom/google/gson/stream/JsonReader;Lkotlin/jvm/functions/Function1;)V", "elementConsumer", "readArray", "", "nextNullableInt", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Integer;", "", "nextNullableLong", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Long;", "gson"}, k = 2, mv = {1, 4, 2})
public final class JsonReaderKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[5] = 1;
            iArr[6] = 2;
            JsonToken.values();
            int[] iArr2 = new int[10];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[5] = 1;
            iArr2[6] = 2;
        }
    }

    @Nullable
    public static final Integer nextNullableInt(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "$this$nextNullableInt");
        try {
            JsonToken peek = jsonReader.peek();
            if (peek != null) {
                int ordinal = peek.ordinal();
                if (ordinal == 5) {
                    String nextString = jsonReader.nextString();
                    Intrinsics.checkNotNullExpressionValue(nextString, "nextString()");
                    return Integer.valueOf(Integer.parseInt(nextString));
                } else if (ordinal == 6) {
                    return Integer.valueOf(jsonReader.nextInt());
                }
            }
            jsonReader.skipValue();
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static final Long nextNullableLong(@NotNull JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "$this$nextNullableLong");
        try {
            JsonToken peek = jsonReader.peek();
            if (peek != null) {
                int ordinal = peek.ordinal();
                if (ordinal == 5) {
                    String nextString = jsonReader.nextString();
                    Intrinsics.checkNotNullExpressionValue(nextString, "nextString()");
                    return Long.valueOf(Long.parseLong(nextString));
                } else if (ordinal == 6) {
                    return Long.valueOf(jsonReader.nextLong());
                }
            }
            jsonReader.skipValue();
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final void readArray(@NotNull JsonReader jsonReader, @NotNull Function1<? super JsonReader, Unit> function1) {
        Intrinsics.checkNotNullParameter(jsonReader, "$this$readArray");
        Intrinsics.checkNotNullParameter(function1, "elementConsumer");
        JsonToken peek = jsonReader.peek();
        JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
        if (peek == jsonToken) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                function1.invoke(jsonReader);
            }
            jsonReader.endArray();
            return;
        }
        throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
    }

    public static final void readObject(@NotNull JsonReader jsonReader, @NotNull Function1<? super JsonReader, Unit> function1) {
        Intrinsics.checkNotNullParameter(jsonReader, "$this$readObject");
        Intrinsics.checkNotNullParameter(function1, "fieldConsumer");
        if (jsonReader.peek() != JsonToken.NULL) {
            JsonToken peek = jsonReader.peek();
            JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
            if (peek == jsonToken) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    function1.invoke(jsonReader);
                }
                jsonReader.endObject();
                return;
            }
            throw new IllegalStateException(a.z2(jsonReader, a.P("Expected ", jsonToken, " but was "), " at ", jsonReader));
        }
        throw new JsonNullParsingException();
    }
}

package com.google.gson.internal.bind;

import com.avito.android.BuildConfig;
import com.avito.android.lib.design.input.FormatterType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
public final class JsonTreeReader extends JsonReader {
    public static final Reader u = new a();
    public static final Object v = new Object();
    public Object[] q = new Object[32];
    public int r = 0;
    public String[] s = new String[32];
    public int[] t = new int[32];

    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    }

    public JsonTreeReader(JsonElement jsonElement) {
        super(u);
        q(jsonElement);
    }

    @Override // com.google.gson.stream.JsonReader
    private String e() {
        StringBuilder L = a2.b.a.a.a.L(" at path ");
        L.append(getPath());
        return L.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        n(JsonToken.BEGIN_ARRAY);
        q(((JsonArray) o()).iterator());
        this.t[this.r - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        n(JsonToken.BEGIN_OBJECT);
        q(((JsonObject) o()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.q = new Object[]{v};
        this.r = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        n(JsonToken.END_ARRAY);
        p();
        p();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        n(JsonToken.END_OBJECT);
        p();
        p();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        StringBuilder I = a2.b.a.a.a.I(Typography.dollar);
        int i = 0;
        while (i < this.r) {
            Object[] objArr = this.q;
            if (objArr[i] instanceof JsonArray) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    I.append('[');
                    I.append(this.t[i]);
                    I.append(']');
                }
            } else if (objArr[i] instanceof JsonObject) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    I.append(FormatterType.defaultDecimalSeparator);
                    String[] strArr = this.s;
                    if (strArr[i] != null) {
                        I.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return I.toString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    public final void n(JsonToken jsonToken) throws IOException {
        if (peek() != jsonToken) {
            StringBuilder P = a2.b.a.a.a.P("Expected ", jsonToken, " but was ");
            P.append(peek());
            P.append(e());
            throw new IllegalStateException(P.toString());
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        n(JsonToken.BOOLEAN);
        boolean asBoolean = ((JsonPrimitive) p()).getAsBoolean();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return asBoolean;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            double asDouble = ((JsonPrimitive) o()).getAsDouble();
            if (isLenient() || (!Double.isNaN(asDouble) && !Double.isInfinite(asDouble))) {
                p();
                int i = this.r;
                if (i > 0) {
                    int[] iArr = this.t;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return asDouble;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + e());
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            int asInt = ((JsonPrimitive) o()).getAsInt();
            p();
            int i = this.r;
            if (i > 0) {
                int[] iArr = this.t;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return asInt;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + e());
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (peek == jsonToken || peek == JsonToken.STRING) {
            long asLong = ((JsonPrimitive) o()).getAsLong();
            p();
            int i = this.r;
            if (i > 0) {
                int[] iArr = this.t;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return asLong;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + e());
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        n(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) o()).next();
        String str = (String) entry.getKey();
        this.s[this.r - 1] = str;
        q(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        n(JsonToken.NULL);
        p();
        int i = this.r;
        if (i > 0) {
            int[] iArr = this.t;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken peek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (peek == jsonToken || peek == JsonToken.NUMBER) {
            String asString = ((JsonPrimitive) p()).getAsString();
            int i = this.r;
            if (i > 0) {
                int[] iArr = this.t;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return asString;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek + e());
    }

    public final Object o() {
        return this.q[this.r - 1];
    }

    public final Object p() {
        Object[] objArr = this.q;
        int i = this.r - 1;
        this.r = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.r == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object o = o();
        if (o instanceof Iterator) {
            boolean z = this.q[this.r - 2] instanceof JsonObject;
            Iterator it = (Iterator) o;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            q(it.next());
            return peek();
        } else if (o instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (o instanceof JsonArray) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (o instanceof JsonPrimitive) {
                JsonPrimitive jsonPrimitive = (JsonPrimitive) o;
                if (jsonPrimitive.isString()) {
                    return JsonToken.STRING;
                }
                if (jsonPrimitive.isBoolean()) {
                    return JsonToken.BOOLEAN;
                }
                if (jsonPrimitive.isNumber()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (o instanceof JsonNull) {
                return JsonToken.NULL;
            } else {
                if (o == v) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public void promoteNameToValue() throws IOException {
        n(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) o()).next();
        q(entry.getValue());
        q(new JsonPrimitive((String) entry.getKey()));
    }

    public final void q(Object obj) {
        int i = this.r;
        Object[] objArr = this.q;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.q = Arrays.copyOf(objArr, i2);
            this.t = Arrays.copyOf(this.t, i2);
            this.s = (String[]) Arrays.copyOf(this.s, i2);
        }
        Object[] objArr2 = this.q;
        int i3 = this.r;
        this.r = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.s[this.r - 2] = BuildConfig.ADJUST_DEFAULT_TRACKER;
        } else {
            p();
            int i = this.r;
            if (i > 0) {
                this.s[i - 1] = BuildConfig.ADJUST_DEFAULT_TRACKER;
            }
        }
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader, java.lang.Object
    public String toString() {
        return JsonTreeReader.class.getSimpleName();
    }
}

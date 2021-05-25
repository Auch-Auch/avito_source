package com.google.gson.stream;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;
public class JsonWriter implements Closeable, Flushable {
    public static final String[] j = new String[128];
    public static final String[] k;
    public final Writer a;
    public int[] b = new int[32];
    public int c = 0;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public String h;
    public boolean i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            j[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        e(6);
        this.e = ":";
        this.i = true;
        Objects.requireNonNull(writer, "out == null");
        this.a = writer;
    }

    public final void a() throws IOException {
        int d2 = d();
        if (d2 == 1) {
            f(2);
            c();
        } else if (d2 == 2) {
            this.a.append(',');
            c();
        } else if (d2 != 4) {
            if (d2 != 6) {
                if (d2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            f(7);
        } else {
            this.a.append((CharSequence) this.e);
            f(5);
        }
    }

    public final JsonWriter b(int i2, int i3, char c2) throws IOException {
        int d2 = d();
        if (d2 != i3 && d2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.h == null) {
            this.c--;
            if (d2 == i3) {
                c();
            }
            this.a.write(c2);
            return this;
        } else {
            StringBuilder L = a.L("Dangling name: ");
            L.append(this.h);
            throw new IllegalStateException(L.toString());
        }
    }

    public JsonWriter beginArray() throws IOException {
        h();
        a();
        e(1);
        this.a.write(91);
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        h();
        a();
        e(3);
        this.a.write(123);
        return this;
    }

    public final void c() throws IOException {
        if (this.d != null) {
            this.a.write(10);
            int i2 = this.c;
            for (int i3 = 1; i3 < i2; i3++) {
                this.a.write(this.d);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        int i2 = this.c;
        if (i2 > 1 || (i2 == 1 && this.b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.c = 0;
    }

    public final int d() {
        int i2 = this.c;
        if (i2 != 0) {
            return this.b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void e(int i2) {
        int i3 = this.c;
        int[] iArr = this.b;
        if (i3 == iArr.length) {
            this.b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.b;
        int i4 = this.c;
        this.c = i4 + 1;
        iArr2[i4] = i2;
    }

    public JsonWriter endArray() throws IOException {
        b(1, 2, ']');
        return this;
    }

    public JsonWriter endObject() throws IOException {
        b(3, 5, '}');
        return this;
    }

    public final void f(int i2) {
        this.b[this.c - 1] = i2;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.c != 0) {
            this.a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void g(String str) throws IOException {
        String str2;
        String[] strArr = this.g ? k : j;
        this.a.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.a.write(str, i2, i3 - i2);
            }
            this.a.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.a.write(str, i2, length - i2);
        }
        this.a.write(34);
    }

    public final boolean getSerializeNulls() {
        return this.i;
    }

    public final void h() throws IOException {
        if (this.h != null) {
            int d2 = d();
            if (d2 == 5) {
                this.a.write(44);
            } else if (d2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            c();
            f(4);
            g(this.h);
            this.h = null;
        }
    }

    public final boolean isHtmlSafe() {
        return this.g;
    }

    public boolean isLenient() {
        return this.f;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        h();
        a();
        this.a.append((CharSequence) str);
        return this;
    }

    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.h != null) {
            throw new IllegalStateException();
        } else if (this.c != 0) {
            this.h = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public JsonWriter nullValue() throws IOException {
        if (this.h != null) {
            if (this.i) {
                h();
            } else {
                this.h = null;
                return this;
            }
        }
        a();
        this.a.write(BuildConfig.ADJUST_DEFAULT_TRACKER);
        return this;
    }

    public final void setHtmlSafe(boolean z) {
        this.g = z;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.d = null;
            this.e = ":";
            return;
        }
        this.d = str;
        this.e = ": ";
    }

    public final void setLenient(boolean z) {
        this.f = z;
    }

    public final void setSerializeNulls(boolean z) {
        this.i = z;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        h();
        a();
        g(str);
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        h();
        a();
        this.a.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        h();
        a();
        this.a.write(bool.booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public JsonWriter value(double d2) throws IOException {
        h();
        if (this.f || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            a();
            this.a.append((CharSequence) Double.toString(d2));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
    }

    public JsonWriter value(long j2) throws IOException {
        h();
        a();
        this.a.write(Long.toString(j2));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        h();
        String obj = number.toString();
        if (this.f || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            a();
            this.a.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }
}

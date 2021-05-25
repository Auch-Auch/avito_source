package com.google.gson.stream;

import com.avito.android.BuildConfig;
import com.avito.android.lib.design.input.FormatterType;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;
public class JsonReader implements Closeable {
    public static final char[] p = ")]}'\n".toCharArray();
    public final Reader a;
    public boolean b = false;
    public final char[] c = new char[1024];
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public long i;
    public int j;
    public String k;
    public int[] l;
    public int m;
    public String[] n;
    public int[] o;

    public class a extends JsonReaderInternalAccess {
        @Override // com.google.gson.internal.JsonReaderInternalAccess
        public void promoteNameToValue(JsonReader jsonReader) throws IOException {
            if (jsonReader instanceof JsonTreeReader) {
                ((JsonTreeReader) jsonReader).promoteNameToValue();
                return;
            }
            int i = jsonReader.h;
            if (i == 0) {
                i = jsonReader.b();
            }
            if (i == 13) {
                jsonReader.h = 9;
            } else if (i == 12) {
                jsonReader.h = 8;
            } else if (i == 14) {
                jsonReader.h = 10;
            } else {
                StringBuilder L = a2.b.a.a.a.L("Expected a name but was ");
                L.append(jsonReader.peek());
                L.append(jsonReader.e());
                throw new IllegalStateException(L.toString());
            }
        }
    }

    static {
        JsonReaderInternalAccess.INSTANCE = new a();
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        this.m = 0;
        this.m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.a = reader;
    }

    public final void a() throws IOException {
        if (!this.b) {
            m("Use JsonReader.setLenient(true) to accept malformed JSON");
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0203, code lost:
        if (d(r6) != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0205, code lost:
        if (r13 != 2) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0207, code lost:
        if (r15 == false) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x020d, code lost:
        if (r10 != Long.MIN_VALUE) goto L_0x0211;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x020f, code lost:
        if (r16 == false) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0215, code lost:
        if (r10 != 0) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0217, code lost:
        if (r16 != false) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0219, code lost:
        if (r16 == false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x021c, code lost:
        r10 = -r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x021d, code lost:
        r19.i = r10;
        r19.d += r9;
        r6 = 15;
        r19.h = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0229, code lost:
        if (r13 == 2) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x022c, code lost:
        if (r13 == 4) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x022f, code lost:
        if (r13 != 7) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0231, code lost:
        r19.j = r9;
        r6 = 16;
        r19.h = 16;
     */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0174 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 793
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.b():int");
    }

    public void beginArray() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 3) {
            i(1);
            this.o[this.m - 1] = 0;
            this.h = 0;
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("Expected BEGIN_ARRAY but was ");
        L.append(peek());
        L.append(e());
        throw new IllegalStateException(L.toString());
    }

    public void beginObject() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 1) {
            i(3);
            this.h = 0;
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("Expected BEGIN_OBJECT but was ");
        L.append(peek());
        L.append(e());
        throw new IllegalStateException(L.toString());
    }

    public final boolean c(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.c;
        int i5 = this.g;
        int i6 = this.d;
        this.g = i5 - i6;
        int i7 = this.e;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.e = 0;
        }
        this.d = 0;
        do {
            Reader reader = this.a;
            int i9 = this.e;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.e + read;
            this.e = i3;
            if (this.f == 0 && (i4 = this.g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.d++;
                this.g = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.h = 0;
        this.l[0] = 8;
        this.m = 1;
        this.a.close();
    }

    public final boolean d(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        a();
        return false;
    }

    public String e() {
        StringBuilder N = a2.b.a.a.a.N(" at line ", this.f + 1, " column ", (this.d - this.g) + 1, " path ");
        N.append(getPath());
        return N.toString();
    }

    public void endArray() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 4) {
            int i3 = this.m - 1;
            this.m = i3;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.h = 0;
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("Expected END_ARRAY but was ");
        L.append(peek());
        L.append(e());
        throw new IllegalStateException(L.toString());
    }

    public void endObject() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 2) {
            int i3 = this.m - 1;
            this.m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.h = 0;
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("Expected END_OBJECT but was ");
        L.append(peek());
        L.append(e());
        throw new IllegalStateException(L.toString());
    }

    public final int f(boolean z) throws IOException {
        char[] cArr = this.c;
        int i2 = this.d;
        int i3 = this.e;
        while (true) {
            boolean z2 = true;
            if (i2 == i3) {
                this.d = i2;
                if (c(1)) {
                    i2 = this.d;
                    i3 = this.e;
                } else if (!z) {
                    return -1;
                } else {
                    StringBuilder L = a2.b.a.a.a.L("End of input");
                    L.append(e());
                    throw new EOFException(L.toString());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f++;
                this.g = i4;
            } else if (!(c2 == ' ' || c2 == '\r' || c2 == '\t')) {
                if (c2 == '/') {
                    this.d = i4;
                    if (i4 == i3) {
                        this.d = i4 - 1;
                        boolean c3 = c(2);
                        this.d++;
                        if (!c3) {
                            return c2;
                        }
                    }
                    a();
                    int i5 = this.d;
                    char c4 = cArr[i5];
                    if (c4 == '*') {
                        this.d = i5 + 1;
                        while (true) {
                            if (this.d + 2 > this.e && !c(2)) {
                                z2 = false;
                                break;
                            }
                            char[] cArr2 = this.c;
                            int i6 = this.d;
                            if (cArr2[i6] != '\n') {
                                for (int i7 = 0; i7 < 2; i7++) {
                                    if (this.c[this.d + i7] == "*/".charAt(i7)) {
                                    }
                                }
                                break;
                            }
                            this.f++;
                            this.g = i6 + 1;
                            this.d++;
                        }
                        if (z2) {
                            i2 = this.d + 2;
                            i3 = this.e;
                        } else {
                            m("Unterminated comment");
                            throw null;
                        }
                    } else if (c4 != '/') {
                        return c2;
                    } else {
                        this.d = i5 + 1;
                        l();
                        i2 = this.d;
                        i3 = this.e;
                    }
                } else if (c2 == '#') {
                    this.d = i4;
                    a();
                    l();
                    i2 = this.d;
                    i3 = this.e;
                } else {
                    this.d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r2 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        r2.append(r0, r3, r3 - r3);
        r10.d = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String g(char r11) throws java.io.IOException {
        /*
            r10 = this;
            char[] r0 = r10.c
            r1 = 0
            r2 = r1
        L_0x0004:
            int r3 = r10.d
            int r4 = r10.e
        L_0x0008:
            r5 = r4
            r4 = r3
        L_0x000a:
            r6 = 16
            r7 = 1
            if (r3 >= r5) goto L_0x005d
            int r8 = r3 + 1
            char r3 = r0[r3]
            if (r3 != r11) goto L_0x0029
            r10.d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L_0x0021
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r4, r8)
            return r11
        L_0x0021:
            r2.append(r0, r4, r8)
            java.lang.String r11 = r2.toString()
            return r11
        L_0x0029:
            r9 = 92
            if (r3 != r9) goto L_0x0050
            r10.d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L_0x0041
            int r2 = r8 + 1
            int r2 = r2 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r3.<init>(r2)
            r2 = r3
        L_0x0041:
            r2.append(r0, r4, r8)
            char r3 = r10.j()
            r2.append(r3)
            int r3 = r10.d
            int r4 = r10.e
            goto L_0x0008
        L_0x0050:
            r6 = 10
            if (r3 != r6) goto L_0x005b
            int r3 = r10.f
            int r3 = r3 + r7
            r10.f = r3
            r10.g = r8
        L_0x005b:
            r3 = r8
            goto L_0x000a
        L_0x005d:
            if (r2 != 0) goto L_0x006d
            int r2 = r3 - r4
            int r2 = r2 * 2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r5.<init>(r2)
            r2 = r5
        L_0x006d:
            int r5 = r3 - r4
            r2.append(r0, r4, r5)
            r10.d = r3
            boolean r3 = r10.c(r7)
            if (r3 == 0) goto L_0x007b
            goto L_0x0004
        L_0x007b:
            java.lang.String r11 = "Unterminated string"
            r10.m(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.g(char):java.lang.String");
    }

    public String getPath() {
        StringBuilder I = a2.b.a.a.a.I(Typography.dollar);
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.l[i3];
            if (i4 == 1 || i4 == 2) {
                I.append('[');
                I.append(this.o[i3]);
                I.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                I.append(FormatterType.defaultDecimalSeparator);
                String[] strArr = this.n;
                if (strArr[i3] != null) {
                    I.append(strArr[i3]);
                }
            }
        }
        return I.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String h() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.d
            int r4 = r3 + r2
            int r5 = r6.e
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.a()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.c
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.c(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.c
            int r4 = r6.d
            r1.append(r3, r4, r2)
            int r3 = r6.d
            int r3 = r3 + r2
            r6.d = r3
            r2 = 1
            boolean r2 = r6.c(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.c
            int r3 = r6.d
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.c
            int r3 = r6.d
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.d
            int r2 = r2 + r0
            r6.d = r2
            return r1
            switch-data {91->0x005c, 92->0x004a, 93->0x005c, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.h():java.lang.String");
    }

    public boolean hasNext() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final void i(int i2) {
        int i3 = this.m;
        int[] iArr = this.l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr2[i5] = i2;
    }

    public final boolean isLenient() {
        return this.b;
    }

    public final char j() throws IOException {
        int i2;
        int i3;
        if (this.d != this.e || c(1)) {
            char[] cArr = this.c;
            int i4 = this.d;
            int i5 = i4 + 1;
            this.d = i5;
            char c2 = cArr[i4];
            if (c2 == '\n') {
                this.f++;
                this.g = i5;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return '\b';
                }
                if (c2 == 'f') {
                    return '\f';
                }
                if (c2 == 'n') {
                    return '\n';
                }
                if (c2 == 'r') {
                    return '\r';
                }
                if (c2 == 't') {
                    return '\t';
                }
                if (c2 != 'u') {
                    m("Invalid escape sequence");
                    throw null;
                } else if (i5 + 4 <= this.e || c(4)) {
                    char c3 = 0;
                    int i6 = this.d;
                    int i7 = i6 + 4;
                    while (i6 < i7) {
                        char c4 = this.c[i6];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i3 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                StringBuilder L = a2.b.a.a.a.L("\\u");
                                L.append(new String(this.c, this.d, 4));
                                throw new NumberFormatException(L.toString());
                            } else {
                                i3 = c4 - 'A';
                            }
                            i2 = i3 + 10;
                        } else {
                            i2 = c4 - '0';
                        }
                        c3 = (char) (i2 + c5);
                        i6++;
                    }
                    this.d += 4;
                    return c3;
                } else {
                    m("Unterminated escape sequence");
                    throw null;
                }
            }
            return c2;
        }
        m("Unterminated escape sequence");
        throw null;
    }

    public final void k(char c2) throws IOException {
        char[] cArr = this.c;
        do {
            int i2 = this.d;
            int i3 = this.e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.d = i4;
                    return;
                } else if (c3 == '\\') {
                    this.d = i4;
                    j();
                    i2 = this.d;
                    i3 = this.e;
                } else {
                    if (c3 == '\n') {
                        this.f++;
                        this.g = i4;
                    }
                    i2 = i4;
                }
            }
            this.d = i2;
        } while (c(1));
        m("Unterminated string");
        throw null;
    }

    public final void l() throws IOException {
        char c2;
        do {
            if (this.d < this.e || c(1)) {
                char[] cArr = this.c;
                int i2 = this.d;
                int i3 = i2 + 1;
                this.d = i3;
                c2 = cArr[i2];
                if (c2 == '\n') {
                    this.f++;
                    this.g = i3;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != '\r');
    }

    public final IOException m(String str) throws IOException {
        StringBuilder L = a2.b.a.a.a.L(str);
        L.append(e());
        throw new MalformedJsonException(L.toString());
    }

    public boolean nextBoolean() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 5) {
            this.h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.h = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            StringBuilder L = a2.b.a.a.a.L("Expected a boolean but was ");
            L.append(peek());
            L.append(e());
            throw new IllegalStateException(L.toString());
        }
    }

    public double nextDouble() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.i;
        }
        if (i2 == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else if (i2 == 8 || i2 == 9) {
            this.k = g(i2 == 8 ? '\'' : Typography.quote);
        } else if (i2 == 10) {
            this.k = h();
        } else if (i2 != 11) {
            StringBuilder L = a2.b.a.a.a.L("Expected a double but was ");
            L.append(peek());
            L.append(e());
            throw new IllegalStateException(L.toString());
        }
        this.h = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (this.b || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.k = null;
            this.h = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + e());
    }

    public int nextInt() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 15) {
            long j2 = this.i;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.h = 0;
                int[] iArr = this.o;
                int i4 = this.m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            StringBuilder L = a2.b.a.a.a.L("Expected an int but was ");
            L.append(this.i);
            L.append(e());
            throw new NumberFormatException(L.toString());
        }
        if (i2 == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = h();
            } else {
                this.k = g(i2 == 8 ? '\'' : Typography.quote);
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder L2 = a2.b.a.a.a.L("Expected an int but was ");
            L2.append(peek());
            L2.append(e());
            throw new IllegalStateException(L2.toString());
        }
        this.h = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.k = null;
            this.h = 0;
            int[] iArr3 = this.o;
            int i7 = this.m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        StringBuilder L3 = a2.b.a.a.a.L("Expected an int but was ");
        L3.append(this.k);
        L3.append(e());
        throw new NumberFormatException(L3.toString());
    }

    public long nextLong() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 15) {
            this.h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.i;
        }
        if (i2 == 16) {
            this.k = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.k = h();
            } else {
                this.k = g(i2 == 8 ? '\'' : Typography.quote);
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.h = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder L = a2.b.a.a.a.L("Expected a long but was ");
            L.append(peek());
            L.append(e());
            throw new IllegalStateException(L.toString());
        }
        this.h = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.k = null;
            this.h = 0;
            int[] iArr3 = this.o;
            int i5 = this.m - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        StringBuilder L2 = a2.b.a.a.a.L("Expected a long but was ");
        L2.append(this.k);
        L2.append(e());
        throw new NumberFormatException(L2.toString());
    }

    public String nextName() throws IOException {
        String str;
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 14) {
            str = h();
        } else if (i2 == 12) {
            str = g('\'');
        } else if (i2 == 13) {
            str = g(Typography.quote);
        } else {
            StringBuilder L = a2.b.a.a.a.L("Expected a name but was ");
            L.append(peek());
            L.append(e());
            throw new IllegalStateException(L.toString());
        }
        this.h = 0;
        this.n[this.m - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 7) {
            this.h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("Expected null but was ");
        L.append(peek());
        L.append(e());
        throw new IllegalStateException(L.toString());
    }

    public String nextString() throws IOException {
        String str;
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        if (i2 == 10) {
            str = h();
        } else if (i2 == 8) {
            str = g('\'');
        } else if (i2 == 9) {
            str = g(Typography.quote);
        } else if (i2 == 11) {
            str = this.k;
            this.k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.i);
        } else if (i2 == 16) {
            str = new String(this.c, this.d, this.j);
            this.d += this.j;
        } else {
            StringBuilder L = a2.b.a.a.a.L("Expected a string but was ");
            L.append(peek());
            L.append(e());
            throw new IllegalStateException(L.toString());
        }
        this.h = 0;
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i2 = this.h;
        if (i2 == 0) {
            i2 = b();
        }
        switch (i2) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z) {
        this.b = z;
    }

    public void skipValue() throws IOException {
        int i2;
        int i3 = 0;
        do {
            int i4 = this.h;
            if (i4 == 0) {
                i4 = b();
            }
            if (i4 == 3) {
                i(1);
            } else if (i4 == 1) {
                i(3);
            } else {
                if (i4 == 4) {
                    this.m--;
                } else if (i4 == 2) {
                    this.m--;
                } else if (i4 == 14 || i4 == 10) {
                    while (true) {
                        i2 = 0;
                        while (true) {
                            int i5 = this.d + i2;
                            if (i5 < this.e) {
                                char c2 = this.c[i5];
                                if (!(c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ')) {
                                    if (c2 != '#') {
                                        if (c2 != ',') {
                                            if (!(c2 == '/' || c2 == '=')) {
                                                if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                                    if (c2 != ';') {
                                                        switch (c2) {
                                                            case '[':
                                                            case ']':
                                                                break;
                                                            case '\\':
                                                                break;
                                                            default:
                                                                i2++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.d = i5;
                                if (!c(1)) {
                                }
                            }
                        }
                    }
                    a();
                    this.d += i2;
                    this.h = 0;
                } else if (i4 == 8 || i4 == 12) {
                    k('\'');
                    this.h = 0;
                } else if (i4 == 9 || i4 == 13) {
                    k(Typography.quote);
                    this.h = 0;
                } else {
                    if (i4 == 16) {
                        this.d += this.j;
                    }
                    this.h = 0;
                }
                i3--;
                this.h = 0;
            }
            i3++;
            this.h = 0;
        } while (i3 != 0);
        int[] iArr = this.o;
        int i6 = this.m;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.n[i6 - 1] = BuildConfig.ADJUST_DEFAULT_TRACKER;
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + e();
    }
}

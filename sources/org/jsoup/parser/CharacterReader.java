package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import kotlin.jvm.internal.CharCompanionObject;
import org.jsoup.UncheckedIOException;
import org.jsoup.helper.Validate;
public final class CharacterReader {
    public char[] a;
    public Reader b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public String[] h;
    public boolean i;

    public CharacterReader(Reader reader, int i2) {
        this.g = -1;
        this.h = new String[512];
        Validate.notNull(reader);
        Validate.isTrue(reader.markSupported());
        this.b = reader;
        this.a = new char[(i2 > 32768 ? 32768 : i2)];
        a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(char[] r9, java.lang.String[] r10, int r11, int r12) {
        /*
            r0 = 12
            if (r12 <= r0) goto L_0x000a
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9, r11, r12)
            return r10
        L_0x000a:
            r0 = 1
            if (r12 >= r0) goto L_0x0010
            java.lang.String r9 = ""
            return r9
        L_0x0010:
            int r1 = r12 * 31
            r2 = 0
            r4 = r11
            r3 = 0
        L_0x0015:
            if (r3 >= r12) goto L_0x0022
            int r1 = r1 * 31
            int r5 = r4 + 1
            char r4 = r9[r4]
            int r1 = r1 + r4
            int r3 = r3 + 1
            r4 = r5
            goto L_0x0015
        L_0x0022:
            r1 = r1 & 511(0x1ff, float:7.16E-43)
            r3 = r10[r1]
            if (r3 != 0) goto L_0x0030
            java.lang.String r0 = new java.lang.String
            r0.<init>(r9, r11, r12)
            r10[r1] = r0
            goto L_0x0059
        L_0x0030:
            int r4 = r3.length()
            if (r12 != r4) goto L_0x004e
            r5 = r11
            r4 = r12
            r6 = 0
        L_0x0039:
            int r7 = r4 + -1
            if (r4 == 0) goto L_0x004f
            int r4 = r5 + 1
            char r5 = r9[r5]
            int r8 = r6 + 1
            char r6 = r3.charAt(r6)
            if (r5 == r6) goto L_0x004a
            goto L_0x004e
        L_0x004a:
            r5 = r4
            r4 = r7
            r6 = r8
            goto L_0x0039
        L_0x004e:
            r0 = 0
        L_0x004f:
            if (r0 == 0) goto L_0x0052
            return r3
        L_0x0052:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r9, r11, r12)
            r10[r1] = r0
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.CharacterReader.b(char[], java.lang.String[], int, int):java.lang.String");
    }

    public final void a() {
        int i2;
        int i3;
        boolean z;
        if (!this.i && (i2 = this.e) >= this.d) {
            int i4 = this.g;
            if (i4 != -1) {
                i3 = i2 - i4;
                i2 = i4;
            } else {
                i3 = 0;
            }
            try {
                long j = (long) i2;
                long skip = this.b.skip(j);
                this.b.mark(32768);
                int i5 = 0;
                while (true) {
                    z = true;
                    if (i5 > 1024) {
                        break;
                    }
                    Reader reader = this.b;
                    char[] cArr = this.a;
                    int read = reader.read(cArr, i5, cArr.length - i5);
                    if (read == -1) {
                        this.i = true;
                    }
                    if (read <= 0) {
                        break;
                    }
                    i5 += read;
                }
                this.b.reset();
                if (i5 > 0) {
                    if (skip != j) {
                        z = false;
                    }
                    Validate.isTrue(z);
                    this.c = i5;
                    this.f += i2;
                    this.e = i3;
                    if (this.g != -1) {
                        this.g = 0;
                    }
                    if (i5 > 24576) {
                        i5 = 24576;
                    }
                    this.d = i5;
                }
            } catch (IOException e2) {
                throw new UncheckedIOException(e2);
            }
        }
    }

    public void advance() {
        this.e++;
    }

    public char c() {
        a();
        char c2 = h() ? CharCompanionObject.MAX_VALUE : this.a[this.e];
        this.e++;
        return c2;
    }

    public void close() {
        Reader reader = this.b;
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.b = null;
                this.a = null;
                this.h = null;
                throw th;
            }
            this.b = null;
            this.a = null;
            this.h = null;
        }
    }

    public String consumeTo(char c2) {
        int i2;
        a();
        int i3 = this.e;
        while (true) {
            if (i3 >= this.c) {
                i2 = -1;
                break;
            } else if (c2 == this.a[i3]) {
                i2 = i3 - this.e;
                break;
            } else {
                i3++;
            }
        }
        if (i2 == -1) {
            return g();
        }
        String b2 = b(this.a, this.h, this.e, i2);
        this.e += i2;
        return b2;
    }

    public String consumeToAny(char... cArr) {
        a();
        int i2 = this.e;
        int i3 = this.c;
        char[] cArr2 = this.a;
        int i4 = i2;
        loop0:
        while (i4 < i3) {
            for (char c2 : cArr) {
                if (cArr2[i4] == c2) {
                    break loop0;
                }
            }
            i4++;
        }
        this.e = i4;
        return i4 > i2 ? b(this.a, this.h, i2, i4 - i2) : "";
    }

    public char current() {
        a();
        return h() ? CharCompanionObject.MAX_VALUE : this.a[this.e];
    }

    public String d() {
        int i2 = this.e;
        int i3 = this.c;
        char[] cArr = this.a;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == '&' || c2 == '<') {
                break;
            }
            i4++;
        }
        this.e = i4;
        return i4 > i2 ? b(this.a, this.h, i2, i4 - i2) : "";
    }

    public String e() {
        char c2;
        a();
        int i2 = this.e;
        while (true) {
            int i3 = this.e;
            if (i3 >= this.c || (((c2 = this.a[i3]) < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2)))) {
                break;
            }
            this.e++;
        }
        return b(this.a, this.h, i2, this.e - i2);
    }

    public String f(char... cArr) {
        a();
        int i2 = this.e;
        int i3 = this.c;
        char[] cArr2 = this.a;
        int i4 = i2;
        while (i4 < i3 && Arrays.binarySearch(cArr, cArr2[i4]) < 0) {
            i4++;
        }
        this.e = i4;
        return i4 > i2 ? b(this.a, this.h, i2, i4 - i2) : "";
    }

    public String g() {
        a();
        char[] cArr = this.a;
        String[] strArr = this.h;
        int i2 = this.e;
        String b2 = b(cArr, strArr, i2, this.c - i2);
        this.e = this.c;
        return b2;
    }

    public final boolean h() {
        return this.e >= this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(java.lang.String r8) {
        /*
            r7 = this;
            r7.a()
            r7.a()
            int r0 = r8.length()
            int r1 = r7.c
            int r2 = r7.e
            int r1 = r1 - r2
            r2 = 0
            r3 = 1
            if (r0 <= r1) goto L_0x0014
            goto L_0x0024
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 >= r0) goto L_0x0029
            char r4 = r8.charAt(r1)
            char[] r5 = r7.a
            int r6 = r7.e
            int r6 = r6 + r1
            char r5 = r5[r6]
            if (r4 == r5) goto L_0x0026
        L_0x0024:
            r0 = 0
            goto L_0x002a
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x0015
        L_0x0029:
            r0 = 1
        L_0x002a:
            if (r0 == 0) goto L_0x0036
            int r0 = r7.e
            int r8 = r8.length()
            int r8 = r8 + r0
            r7.e = r8
            return r3
        L_0x0036:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.CharacterReader.i(java.lang.String):boolean");
    }

    public boolean isEmpty() {
        a();
        return this.e >= this.c;
    }

    public boolean j(String str) {
        boolean z;
        a();
        int length = str.length();
        if (length <= this.c - this.e) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (Character.toUpperCase(str.charAt(i2)) != Character.toUpperCase(this.a[this.e + i2])) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        if (!z) {
            return false;
        }
        this.e = str.length() + this.e;
        return true;
    }

    public boolean k(char c2) {
        return !isEmpty() && this.a[this.e] == c2;
    }

    public boolean l(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        a();
        char c2 = this.a[this.e];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        if (isEmpty()) {
            return false;
        }
        char c2 = this.a[this.e];
        if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !Character.isLetter(c2))) {
            return false;
        }
        return true;
    }

    public int n(CharSequence charSequence) {
        a();
        char charAt = charSequence.charAt(0);
        int i2 = this.e;
        while (i2 < this.c) {
            int i3 = 1;
            if (charAt != this.a[i2]) {
                do {
                    i2++;
                    if (i2 >= this.c) {
                        break;
                    }
                } while (charAt != this.a[i2]);
            }
            int i4 = i2 + 1;
            int length = (charSequence.length() + i4) - 1;
            int i5 = this.c;
            if (i2 < i5 && length <= i5) {
                int i6 = i4;
                while (i6 < length && charSequence.charAt(i3) == this.a[i6]) {
                    i6++;
                    i3++;
                }
                if (i6 == length) {
                    return i2 - this.e;
                }
            }
            i2 = i4;
        }
        return -1;
    }

    public void o() {
        int i2 = this.g;
        if (i2 != -1) {
            this.e = i2;
            this.g = -1;
            return;
        }
        throw new UncheckedIOException(new IOException("Mark invalid"));
    }

    public void p() {
        int i2 = this.e;
        if (i2 >= 1) {
            this.e = i2 - 1;
            return;
        }
        throw new UncheckedIOException(new IOException("No buffer left to unconsume"));
    }

    public int pos() {
        return this.f + this.e;
    }

    public String toString() {
        if (this.c - this.e < 0) {
            return "";
        }
        char[] cArr = this.a;
        int i2 = this.e;
        return new String(cArr, i2, this.c - i2);
    }

    public CharacterReader(Reader reader) {
        this(reader, 32768);
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }
}

package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public abstract class BaseEncoding {
    public static final BaseEncoding a = new e("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    public static final BaseEncoding b = new e("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    public static final BaseEncoding c = new g(new c("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".toCharArray()), '=');
    public static final BaseEncoding d = new g(new c("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV".toCharArray()), '=');
    public static final BaseEncoding e = new d(new c("base16()", "0123456789ABCDEF".toCharArray()));

    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }
    }

    public class a extends ByteSink {
        public final /* synthetic */ CharSink a;

        public a(CharSink charSink) {
            this.a = charSink;
        }

        @Override // com.google.common.io.ByteSink
        public OutputStream openStream() throws IOException {
            return BaseEncoding.this.encodingStream(this.a.openStream());
        }
    }

    public class b extends ByteSource {
        public final /* synthetic */ CharSource a;

        public b(CharSource charSource) {
            this.a = charSource;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return BaseEncoding.this.decodingStream(this.a.openStream());
        }
    }

    public static final class c {
        public final String a;
        public final char[] b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final byte[] g;
        public final boolean[] h;

        public c(String str, char[] cArr) {
            this.a = (String) Preconditions.checkNotNull(str);
            this.b = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.d = log2;
                int min = Math.min(8, Integer.lowestOneBit(log2));
                try {
                    this.e = 8 / min;
                    this.f = log2 / min;
                    this.c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c2 = cArr[i];
                        Preconditions.checkArgument(c2 < 128, "Non-ASCII character: %s", c2);
                        Preconditions.checkArgument(bArr[c2] == -1, "Duplicate character: %s", c2);
                        bArr[c2] = (byte) i;
                    }
                    this.g = bArr;
                    boolean[] zArr = new boolean[this.e];
                    for (int i2 = 0; i2 < this.f; i2++) {
                        zArr[IntMath.divide(i2 * 8, this.d, RoundingMode.CEILING)] = true;
                    }
                    this.h = zArr;
                } catch (ArithmeticException e2) {
                    StringBuilder L = a2.b.a.a.a.L("Illegal alphabet ");
                    L.append(new String(cArr));
                    throw new IllegalArgumentException(L.toString(), e2);
                }
            } catch (ArithmeticException e3) {
                StringBuilder L2 = a2.b.a.a.a.L("Illegal alphabet length ");
                L2.append(cArr.length);
                throw new IllegalArgumentException(L2.toString(), e3);
            }
        }

        public int a(char c2) throws DecodingException {
            if (c2 <= 127) {
                byte b2 = this.g[c2];
                if (b2 != -1) {
                    return b2;
                }
                if (c2 <= ' ' || c2 == 127) {
                    StringBuilder L = a2.b.a.a.a.L("Unrecognized character: 0x");
                    L.append(Integer.toHexString(c2));
                    throw new DecodingException(L.toString());
                }
                throw new DecodingException(a2.b.a.a.a.K2("Unrecognized character: ", c2));
            }
            StringBuilder L2 = a2.b.a.a.a.L("Unrecognized character: 0x");
            L2.append(Integer.toHexString(c2));
            throw new DecodingException(L2.toString());
        }

        public final boolean b() {
            for (char c2 : this.b) {
                if (Ascii.isLowerCase(c2)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean c() {
            for (char c2 : this.b) {
                if (Ascii.isUpperCase(c2)) {
                    return true;
                }
            }
            return false;
        }

        public boolean d(int i) {
            return this.h[i % this.e];
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(this.b, ((c) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.b);
        }

        public String toString() {
            return this.a;
        }
    }

    public static final class d extends g {
        public final char[] j = new char[512];

        public d(c cVar) {
            super(cVar, null);
            Preconditions.checkArgument(cVar.b.length == 16);
            for (int i = 0; i < 256; i++) {
                char[] cArr = this.j;
                char[] cArr2 = cVar.b;
                cArr[i] = cArr2[i >>> 4];
                cArr[i | 256] = cArr2[i & 15];
            }
        }

        @Override // com.google.common.io.BaseEncoding.g, com.google.common.io.BaseEncoding
        public int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 != 1) {
                int i = 0;
                int i2 = 0;
                while (i < charSequence.length()) {
                    bArr[i2] = (byte) ((this.f.a(charSequence.charAt(i)) << 4) | this.f.a(charSequence.charAt(i + 1)));
                    i += 2;
                    i2++;
                }
                return i2;
            }
            StringBuilder L = a2.b.a.a.a.L("Invalid input length ");
            L.append(charSequence.length());
            throw new DecodingException(L.toString());
        }

        @Override // com.google.common.io.BaseEncoding.g, com.google.common.io.BaseEncoding
        public void b(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.j[i4]);
                appendable.append(this.j[i4 | 256]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.g
        public BaseEncoding g(c cVar, @NullableDecl Character ch) {
            return new d(cVar);
        }
    }

    public static final class f extends BaseEncoding {
        public final BaseEncoding f;
        public final String g;
        public final int h;

        public f(BaseEncoding baseEncoding, String str, int i) {
            this.f = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.g = (String) Preconditions.checkNotNull(str);
            this.h = i;
            Preconditions.checkArgument(i > 0, "Cannot add a separator after every %s chars", i);
        }

        @Override // com.google.common.io.BaseEncoding
        public int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f.a(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public void b(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            BaseEncoding baseEncoding = this.f;
            String str = this.g;
            int i3 = this.h;
            Preconditions.checkNotNull(appendable);
            Preconditions.checkNotNull(str);
            Preconditions.checkArgument(i3 > 0);
            baseEncoding.b(new a2.j.d.h.c(i3, appendable, str), bArr, i, i2);
        }

        @Override // com.google.common.io.BaseEncoding
        public int c(int i) {
            return this.f.c(i);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.g.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.f.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public int d(int i) {
            int d = this.f.d(i);
            return (IntMath.divide(Math.max(0, d - 1), this.h, RoundingMode.FLOOR) * this.g.length()) + d;
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            BaseEncoding baseEncoding = this.f;
            String str = this.g;
            Preconditions.checkNotNull(reader);
            Preconditions.checkNotNull(str);
            return baseEncoding.decodingStream(new a2.j.d.h.b(reader, str));
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence e(CharSequence charSequence) {
            return this.f.e(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            BaseEncoding baseEncoding = this.f;
            String str = this.g;
            int i = this.h;
            Preconditions.checkNotNull(writer);
            Preconditions.checkNotNull(str);
            Preconditions.checkArgument(i > 0);
            return baseEncoding.encodingStream(new a2.j.d.h.d(new a2.j.d.h.c(i, writer, str), writer));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.f.lowerCase().withSeparator(this.g, this.h);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.f.omitPadding().withSeparator(this.g, this.h);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f);
            sb.append(".withSeparator(\"");
            sb.append(this.g);
            sb.append("\", ");
            return a2.b.a.a.a.j(sb, this.h, ")");
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.f.upperCase().withSeparator(this.g, this.h);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            return this.f.withPadChar(c).withSeparator(this.g, this.h);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    public static BaseEncoding base16() {
        return e;
    }

    public static BaseEncoding base32() {
        return c;
    }

    public static BaseEncoding base32Hex() {
        return d;
    }

    public static BaseEncoding base64() {
        return a;
    }

    public static BaseEncoding base64Url() {
        return b;
    }

    public abstract int a(byte[] bArr, CharSequence charSequence) throws DecodingException;

    public abstract void b(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    public abstract int c(int i);

    public abstract boolean canDecode(CharSequence charSequence);

    public abstract int d(int i);

    public final byte[] decode(CharSequence charSequence) {
        try {
            CharSequence e2 = e(charSequence);
            int c2 = c(e2.length());
            byte[] bArr = new byte[c2];
            int a3 = a(bArr, e2);
            if (a3 == c2) {
                return bArr;
            }
            byte[] bArr2 = new byte[a3];
            System.arraycopy(bArr, 0, bArr2, 0, a3);
            return bArr2;
        } catch (DecodingException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    @GwtIncompatible
    public final ByteSource decodingSource(CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new b(charSource);
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public CharSequence e(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    @GwtIncompatible
    public final ByteSink encodingSink(CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new a(charSink);
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c2);

    public abstract BaseEncoding withSeparator(String str, int i);

    public final String encode(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(d(i2));
        try {
            b(sb, bArr, i, i2);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public static final class e extends g {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public e(java.lang.String r2, java.lang.String r3, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character r4) {
            /*
                r1 = this;
                com.google.common.io.BaseEncoding$c r0 = new com.google.common.io.BaseEncoding$c
                char[] r3 = r3.toCharArray()
                r0.<init>(r2, r3)
                r1.<init>(r0, r4)
                char[] r2 = r0.b
                int r2 = r2.length
                r3 = 64
                if (r2 != r3) goto L_0x0015
                r2 = 1
                goto L_0x0016
            L_0x0015:
                r2 = 0
            L_0x0016:
                com.google.common.base.Preconditions.checkArgument(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.e.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
        }

        @Override // com.google.common.io.BaseEncoding.g, com.google.common.io.BaseEncoding
        public int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence e = e(charSequence);
            if (this.f.d(e.length())) {
                int i = 0;
                int i2 = 0;
                while (i < e.length()) {
                    int i3 = i + 1;
                    int i4 = i3 + 1;
                    int a = (this.f.a(e.charAt(i)) << 18) | (this.f.a(e.charAt(i3)) << 12);
                    int i5 = i2 + 1;
                    bArr[i2] = (byte) (a >>> 16);
                    if (i4 < e.length()) {
                        int i6 = i4 + 1;
                        int a3 = a | (this.f.a(e.charAt(i4)) << 6);
                        i2 = i5 + 1;
                        bArr[i5] = (byte) ((a3 >>> 8) & 255);
                        if (i6 < e.length()) {
                            i4 = i6 + 1;
                            i5 = i2 + 1;
                            bArr[i2] = (byte) ((a3 | this.f.a(e.charAt(i6))) & 255);
                        } else {
                            i = i6;
                        }
                    }
                    i2 = i5;
                    i = i4;
                }
                return i2;
            }
            StringBuilder L = a2.b.a.a.a.L("Invalid input length ");
            L.append(e.length());
            throw new DecodingException(L.toString());
        }

        @Override // com.google.common.io.BaseEncoding.g, com.google.common.io.BaseEncoding
        public void b(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i3 = i + i2;
            Preconditions.checkPositionIndexes(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8);
                int i7 = i6 | (bArr[i5] & 255);
                appendable.append(this.f.b[i7 >>> 18]);
                appendable.append(this.f.b[(i7 >>> 12) & 63]);
                appendable.append(this.f.b[(i7 >>> 6) & 63]);
                appendable.append(this.f.b[i7 & 63]);
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                f(appendable, bArr, i, i3 - i);
            }
        }

        @Override // com.google.common.io.BaseEncoding.g
        public BaseEncoding g(c cVar, @NullableDecl Character ch) {
            return new e(cVar, ch);
        }

        public e(c cVar, @NullableDecl Character ch) {
            super(cVar, ch);
            Preconditions.checkArgument(cVar.b.length == 64);
        }
    }

    public static class g extends BaseEncoding {
        public final c f;
        @NullableDecl
        public final Character g;
        @MonotonicNonNullDecl
        public transient BaseEncoding h;
        @MonotonicNonNullDecl
        public transient BaseEncoding i;

        public class a extends OutputStream {
            public int a = 0;
            public int b = 0;
            public int c = 0;
            public final /* synthetic */ Writer d;

            public a(Writer writer) {
                this.d = writer;
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                int i = this.b;
                if (i > 0) {
                    int i2 = this.a;
                    c cVar = g.this.f;
                    this.d.write(cVar.b[(i2 << (cVar.d - i)) & cVar.c]);
                    this.c++;
                    if (g.this.g != null) {
                        while (true) {
                            int i3 = this.c;
                            g gVar = g.this;
                            if (i3 % gVar.f.e == 0) {
                                break;
                            }
                            this.d.write(gVar.g.charValue());
                            this.c++;
                        }
                    }
                }
                this.d.close();
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws IOException {
                this.d.flush();
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                int i2 = this.a << 8;
                this.a = i2;
                this.a = (i & 255) | i2;
                this.b += 8;
                while (true) {
                    int i3 = this.b;
                    c cVar = g.this.f;
                    int i4 = cVar.d;
                    if (i3 >= i4) {
                        this.d.write(cVar.b[(this.a >> (i3 - i4)) & cVar.c]);
                        this.c++;
                        this.b -= g.this.f.d;
                    } else {
                        return;
                    }
                }
            }
        }

        public g(c cVar, @NullableDecl Character ch) {
            this.f = (c) Preconditions.checkNotNull(cVar);
            boolean z = true;
            if (ch != null) {
                char charValue = ch.charValue();
                byte[] bArr = cVar.g;
                if (charValue < bArr.length && bArr[charValue] != -1) {
                    z = false;
                }
            }
            Preconditions.checkArgument(z, "Padding character %s was already in alphabet", ch);
            this.g = ch;
        }

        @Override // com.google.common.io.BaseEncoding
        public int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            c cVar;
            Preconditions.checkNotNull(bArr);
            CharSequence e = e(charSequence);
            if (this.f.d(e.length())) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < e.length()) {
                    long j = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        cVar = this.f;
                        if (i4 >= cVar.e) {
                            break;
                        }
                        j <<= cVar.d;
                        if (i2 + i4 < e.length()) {
                            j |= (long) this.f.a(e.charAt(i5 + i2));
                            i5++;
                        }
                        i4++;
                    }
                    int i6 = cVar.f;
                    int i7 = (i6 * 8) - (i5 * cVar.d);
                    int i8 = (i6 - 1) * 8;
                    while (i8 >= i7) {
                        bArr[i3] = (byte) ((int) ((j >>> i8) & 255));
                        i8 -= 8;
                        i3++;
                    }
                    i2 += this.f.e;
                }
                return i3;
            }
            StringBuilder L = a2.b.a.a.a.L("Invalid input length ");
            L.append(e.length());
            throw new DecodingException(L.toString());
        }

        @Override // com.google.common.io.BaseEncoding
        public void b(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
            int i4 = 0;
            while (i4 < i3) {
                f(appendable, bArr, i2 + i4, Math.min(this.f.f, i3 - i4));
                i4 += this.f.f;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public int c(int i2) {
            return (int) (((((long) this.f.d) * ((long) i2)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence e = e(charSequence);
            if (!this.f.d(e.length())) {
                return false;
            }
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= e.length()) {
                    return true;
                }
                c cVar = this.f;
                char charAt = e.charAt(i2);
                Objects.requireNonNull(cVar);
                if (charAt > 127 || cVar.g[charAt] == -1) {
                    z = false;
                }
                if (!z) {
                    return false;
                }
                i2++;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public int d(int i2) {
            c cVar = this.f;
            return IntMath.divide(i2, cVar.f, RoundingMode.CEILING) * cVar.e;
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            Preconditions.checkNotNull(reader);
            return new b(reader);
        }

        @Override // com.google.common.io.BaseEncoding
        public CharSequence e(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.g;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            Preconditions.checkNotNull(writer);
            return new a(writer);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            if (!this.f.equals(gVar.f) || !com.google.common.base.Objects.equal(this.g, gVar.g)) {
                return false;
            }
            return true;
        }

        public void f(Appendable appendable, byte[] bArr, int i2, int i3) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i2, i2 + i3, bArr.length);
            int i4 = 0;
            Preconditions.checkArgument(i3 <= this.f.f);
            long j = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                j = (j | ((long) (bArr[i2 + i5] & 255))) << 8;
            }
            int i6 = ((i3 + 1) * 8) - this.f.d;
            while (i4 < i3 * 8) {
                c cVar = this.f;
                appendable.append(cVar.b[((int) (j >>> (i6 - i4))) & cVar.c]);
                i4 += this.f.d;
            }
            if (this.g != null) {
                while (i4 < this.f.f * 8) {
                    appendable.append(this.g.charValue());
                    i4 += this.f.d;
                }
            }
        }

        public BaseEncoding g(c cVar, @NullableDecl Character ch) {
            return new g(cVar, ch);
        }

        public int hashCode() {
            return this.f.hashCode() ^ com.google.common.base.Objects.hashCode(this.g);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.i;
            if (baseEncoding == null) {
                c cVar = this.f;
                if (cVar.c()) {
                    Preconditions.checkState(!cVar.b(), "Cannot call lowerCase() on a mixed-case alphabet");
                    char[] cArr = new char[cVar.b.length];
                    int i2 = 0;
                    while (true) {
                        char[] cArr2 = cVar.b;
                        if (i2 >= cArr2.length) {
                            break;
                        }
                        cArr[i2] = Ascii.toLowerCase(cArr2[i2]);
                        i2++;
                    }
                    cVar = new c(a2.b.a.a.a.t(new StringBuilder(), cVar.a, ".lowerCase()"), cArr);
                }
                baseEncoding = cVar == this.f ? this : g(cVar, this.g);
                this.i = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.g == null ? this : g(this.f, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f.a);
            if (8 % this.f.d != 0) {
                if (this.g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.h;
            if (baseEncoding == null) {
                c cVar = this.f;
                if (cVar.b()) {
                    Preconditions.checkState(!cVar.c(), "Cannot call upperCase() on a mixed-case alphabet");
                    char[] cArr = new char[cVar.b.length];
                    int i2 = 0;
                    while (true) {
                        char[] cArr2 = cVar.b;
                        if (i2 >= cArr2.length) {
                            break;
                        }
                        cArr[i2] = Ascii.toUpperCase(cArr2[i2]);
                        i2++;
                    }
                    cVar = new c(a2.b.a.a.a.t(new StringBuilder(), cVar.a, ".upperCase()"), cArr);
                }
                baseEncoding = cVar == this.f ? this : g(cVar, this.g);
                this.h = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            Character ch;
            return (8 % this.f.d == 0 || ((ch = this.g) != null && ch.charValue() == c)) ? this : g(this.f, Character.valueOf(c));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i2) {
            boolean z = false;
            for (int i3 = 0; i3 < str.length(); i3++) {
                c cVar = this.f;
                char charAt = str.charAt(i3);
                byte[] bArr = cVar.g;
                Preconditions.checkArgument(!(charAt < bArr.length && bArr[charAt] != -1), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.g;
            if (ch != null) {
                if (str.indexOf(ch.charValue()) < 0) {
                    z = true;
                }
                Preconditions.checkArgument(z, "Separator (%s) cannot contain padding character", str);
            }
            return new f(this, str, i2);
        }

        public class b extends InputStream {
            public int a = 0;
            public int b = 0;
            public int c = 0;
            public boolean d = false;
            public final /* synthetic */ Reader e;

            public b(Reader reader) {
                this.e = reader;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.e.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                int i;
                while (true) {
                    int read = this.e.read();
                    if (read != -1) {
                        this.c++;
                        char c2 = (char) read;
                        Character ch = g.this.g;
                        if (ch == null || ch.charValue() != c2) {
                            if (!this.d) {
                                int i2 = this.a;
                                c cVar = g.this.f;
                                int i3 = i2 << cVar.d;
                                this.a = i3;
                                int a3 = cVar.a(c2) | i3;
                                this.a = a3;
                                int i4 = this.b + g.this.f.d;
                                this.b = i4;
                                if (i4 >= 8) {
                                    int i5 = i4 - 8;
                                    this.b = i5;
                                    return (a3 >> i5) & 255;
                                }
                            } else {
                                throw new DecodingException("Expected padding character but found '" + c2 + "' at index " + this.c);
                            }
                        } else if (this.d || ((i = this.c) != 1 && g.this.f.d(i - 1))) {
                            this.d = true;
                        }
                    } else if (this.d || g.this.f.d(this.c)) {
                        return -1;
                    } else {
                        StringBuilder L = a2.b.a.a.a.L("Invalid input length ");
                        L.append(this.c);
                        throw new DecodingException(L.toString());
                    }
                }
                StringBuilder L2 = a2.b.a.a.a.L("Padding cannot start at index ");
                L2.append(this.c);
                throw new DecodingException(L2.toString());
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = i2 + i;
                Preconditions.checkPositionIndexes(i, i3, bArr.length);
                int i4 = i;
                while (i4 < i3) {
                    int read = read();
                    if (read == -1) {
                        int i5 = i4 - i;
                        if (i5 == 0) {
                            return -1;
                        }
                        return i5;
                    }
                    bArr[i4] = (byte) read;
                    i4++;
                }
                return i4 - i;
            }
        }
    }
}

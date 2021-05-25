package a2.f.a.a.j.a;

import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class a implements XmlSerializer {
    public static final String[] k = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    public final char[] a = new char[8192];
    public int b;
    public Writer c;
    public OutputStream d;
    public CharsetEncoder e;
    public ByteBuffer f = ByteBuffer.allocate(8192);
    public boolean g = false;
    public boolean h;
    public int i = 0;
    public boolean j = true;

    public final void a(char c2) throws IOException {
        int i2 = this.b;
        if (i2 >= 8191) {
            flush();
            i2 = this.b;
        }
        this.a[i2] = c2;
        this.b = i2 + 1;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        a(' ');
        if (str != null) {
            b(str);
            a(':');
        }
        b(str2);
        b("=\"");
        e(str3);
        a(Typography.quote);
        this.j = false;
        return this;
    }

    public final void b(String str) throws IOException {
        c(str, 0, str.length());
    }

    public final void c(String str, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i3 + i2;
            while (i2 < i4) {
                int i5 = i2 + 8192;
                c(str, i2, i5 < i4 ? 8192 : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.b;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.b;
        }
        str.getChars(i2, i2 + i3, this.a, i6);
        this.b = i6 + i3;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void d(char[] cArr, int i2, int i3) throws IOException {
        if (i3 > 8192) {
            int i4 = i3 + i2;
            while (i2 < i4) {
                int i5 = i2 + 8192;
                d(cArr, i2, i5 < i4 ? 8192 : i4 - i2);
                i2 = i5;
            }
            return;
        }
        int i6 = this.b;
        if (i6 + i3 > 8192) {
            flush();
            i6 = this.b;
        }
        System.arraycopy(cArr, i2, this.a, i6, i3);
        this.b = i6 + i3;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void e(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = k;
        char length2 = (char) strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i3 < i2) {
                    c(str, i3, i2 - i3);
                }
                i3 = i2 + 1;
                b(str2);
            }
            i2++;
        }
        if (i3 < i2) {
            c(str, i3, i2 - i3);
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        int i2 = this.i - 1;
        this.i = i2;
        if (this.h) {
            b(" />\n");
        } else {
            if (this.g && this.j) {
                int i3 = i2 * 4;
                if (i3 > 62) {
                    i3 = 62;
                }
                c("                                                              ", 0, i3);
            }
            b("</");
            if (str != null) {
                b(str);
                a(':');
            }
            b(str2);
            b(">\n");
        }
        this.j = true;
        this.h = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void f() throws IOException {
        int position = this.f.position();
        if (position > 0) {
            this.f.flip();
            this.d.write(this.f.array(), 0, position);
            this.f.clear();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        int i2 = this.b;
        if (i2 > 0) {
            if (this.d != null) {
                CharBuffer wrap = CharBuffer.wrap(this.a, 0, i2);
                CoderResult encode = this.e.encode(wrap, this.f, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        f();
                        encode = this.e.encode(wrap, this.f, true);
                    } else {
                        f();
                        this.d.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.c.write(this.a, 0, i2);
            this.c.flush();
            this.b = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            this.g = true;
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.e = Charset.forName(str).newEncoder();
                this.d = outputStream;
            } catch (IllegalCharsetNameException e2) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
            } catch (UnsupportedCharsetException e3) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e3));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder L = a2.b.a.a.a.L("<?xml version='1.0' encoding='utf-8' standalone='");
        L.append(bool.booleanValue() ? "yes" : "no");
        L.append("' ?>\n");
        b(L.toString());
        this.j = true;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.h) {
            b(">\n");
        }
        if (this.g) {
            int i2 = this.i * 4;
            if (i2 > 62) {
                i2 = 62;
            }
            c("                                                              ", 0, i2);
        }
        this.i++;
        a(Typography.less);
        if (str != null) {
            b(str);
            a(':');
        }
        b(str2);
        this.h = true;
        this.j = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i2, int i3) throws IOException, IllegalArgumentException, IllegalStateException {
        String str;
        boolean z = false;
        if (this.h) {
            b(">");
            this.h = false;
        }
        String[] strArr = k;
        char length = (char) strArr.length;
        int i4 = i3 + i2;
        int i5 = i2;
        while (i2 < i4) {
            char c2 = cArr[i2];
            if (c2 < length && (str = strArr[c2]) != null) {
                if (i5 < i2) {
                    d(cArr, i5, i2 - i5);
                }
                i5 = i2 + 1;
                b(str);
            }
            i2++;
        }
        if (i5 < i2) {
            d(cArr, i5, i2 - i5);
        }
        if (this.g) {
            if (cArr[i4 - 1] == '\n') {
                z = true;
            }
            this.j = z;
        }
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.c = writer;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean z = false;
        if (this.h) {
            b(">");
            this.h = false;
        }
        e(str);
        if (this.g) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == '\n') {
                z = true;
            }
            this.j = z;
        }
        return this;
    }
}

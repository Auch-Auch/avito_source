package de.ailis.pherialize;

import a2.b.a.a.a;
import de.ailis.pherialize.exceptions.UnserializeException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
public class Unserializer {
    public int a;
    public final String b;
    public final Charset c;
    public final List<Object> d;

    public Unserializer(String str) {
        this(str, Charset.forName("UTF-8"));
    }

    public final Mixed a() {
        int indexOf = this.b.indexOf(58, this.a + 2);
        int parseInt = Integer.parseInt(this.b.substring(this.a + 2, indexOf));
        this.a = indexOf + 2;
        MixedArray mixedArray = new MixedArray(parseInt);
        Mixed mixed = new Mixed(mixedArray);
        this.d.add(mixed);
        for (int i = 0; i < parseInt; i++) {
            Mixed unserializeObject = unserializeObject();
            List<Object> list = this.d;
            list.remove(list.size() - 1);
            mixedArray.put(unserializeObject, unserializeObject());
        }
        this.a++;
        return mixed;
    }

    public final String b() {
        int indexOf = this.b.indexOf(58, this.a + 2);
        int parseInt = Integer.parseInt(this.b.substring(this.a + 2, indexOf));
        this.a = indexOf + parseInt + 4;
        int i = indexOf + 2;
        return this.b.substring(i, parseInt + i);
    }

    public Mixed unserializeObject() {
        Mixed mixed;
        Mixed mixed2;
        char charAt = this.b.charAt(this.a);
        if (charAt == 'N') {
            this.a += 2;
            mixed = null;
        } else if (charAt != 'O') {
            boolean z = true;
            if (charAt == 'R') {
                int indexOf = this.b.indexOf(59, this.a + 2);
                int parseInt = Integer.parseInt(this.b.substring(this.a + 2, indexOf));
                this.a = indexOf + 1;
                mixed = (Mixed) this.d.get(parseInt - 1);
            } else if (charAt == 'd') {
                int indexOf2 = this.b.indexOf(59, this.a + 2);
                Double valueOf = Double.valueOf(this.b.substring(this.a + 2, indexOf2));
                this.a = indexOf2 + 1;
                mixed2 = new Mixed(valueOf);
                mixed = mixed2;
            } else if (charAt == 'i') {
                int indexOf3 = this.b.indexOf(59, this.a + 2);
                try {
                    Integer valueOf2 = Integer.valueOf(this.b.substring(this.a + 2, indexOf3));
                    this.a = indexOf3 + 1;
                    mixed = new Mixed(valueOf2);
                } catch (NumberFormatException unused) {
                    Long valueOf3 = Long.valueOf(this.b.substring(this.a + 2, indexOf3));
                    this.a = indexOf3 + 1;
                    mixed2 = new Mixed(valueOf3);
                }
            } else if (charAt == 's') {
                String b2 = b();
                try {
                    b2 = new String(b2.getBytes("ISO-8859-1"), this.c);
                } catch (UnsupportedEncodingException unused2) {
                }
                mixed = new Mixed(b2);
            } else if (charAt == 'a') {
                return a();
            } else {
                if (charAt == 'b') {
                    if (this.b.charAt(this.a + 2) != '1') {
                        z = false;
                    }
                    Boolean valueOf4 = Boolean.valueOf(z);
                    this.a += 4;
                    mixed = new Mixed(valueOf4);
                } else {
                    throw new UnserializeException(a.K2("Unable to unserialize unknown type ", charAt), this.a);
                }
            }
        } else {
            String b3 = b();
            this.a -= 2;
            if (b3.equals("stdClass")) {
                mixed = a();
            } else {
                throw new RuntimeException(a.e3("stdClass objects only supported. `", b3, "' received."));
            }
        }
        this.d.add(mixed);
        return mixed;
    }

    public Unserializer(String str, Charset charset) {
        try {
            str = new String(str.getBytes(charset), "ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
        }
        this.b = str;
        this.c = charset;
        this.a = 0;
        this.d = new ArrayList();
    }
}

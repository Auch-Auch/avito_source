package org.spongycastle.asn1.x509;
public class X509NameTokenizer {
    public String a;
    public int b;
    public char c;
    public StringBuffer d;

    public X509NameTokenizer(String str) {
        this(str, ',');
    }

    public boolean hasMoreTokens() {
        return this.b != this.a.length();
    }

    public String nextToken() {
        if (this.b == this.a.length()) {
            return null;
        }
        int i = this.b + 1;
        this.d.setLength(0);
        boolean z = false;
        boolean z2 = false;
        while (i != this.a.length()) {
            char charAt = this.a.charAt(i);
            if (charAt == '\"') {
                if (!z) {
                    z2 = !z2;
                }
                this.d.append(charAt);
            } else if (z || z2) {
                this.d.append(charAt);
            } else {
                if (charAt == '\\') {
                    this.d.append(charAt);
                    z = true;
                } else if (charAt == this.c) {
                    break;
                } else {
                    this.d.append(charAt);
                }
                i++;
            }
            z = false;
            i++;
        }
        this.b = i;
        return this.d.toString();
    }

    public X509NameTokenizer(String str, char c2) {
        this.d = new StringBuffer();
        this.a = str;
        this.b = -1;
        this.c = c2;
    }
}

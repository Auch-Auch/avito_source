package org.spongycastle.asn1.eac;
public class Flags {
    public int a = 0;

    public Flags() {
    }

    public int getFlags() {
        return this.a;
    }

    public boolean isSet(int i) {
        return (i & this.a) != 0;
    }

    public void set(int i) {
        this.a = i | this.a;
    }

    public Flags(int i) {
        this.a = i;
    }
}

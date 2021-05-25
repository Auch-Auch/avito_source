package x6.e.d.a;

import org.spongycastle.asn1.x509.ReasonFlags;
public class i {
    public static final i b = new i(33023);
    public int a;

    public i(ReasonFlags reasonFlags) {
        this.a = reasonFlags.intValue();
    }

    public boolean a() {
        return this.a == b.a;
    }

    public i() {
        this.a = 0;
    }

    public i(int i) {
        this.a = i;
    }
}

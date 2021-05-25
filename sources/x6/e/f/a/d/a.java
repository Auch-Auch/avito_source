package x6.e.f.a.d;

import java.io.Serializable;
import org.spongycastle.pqc.crypto.xmss.XMSSNode;
public class a implements Serializable {
    private static final long serialVersionUID = 1;
    public XMSSNode a;
    public final int b;
    public int c;
    public int d;
    public boolean e = false;
    public boolean f = false;

    public a(int i) {
        this.b = i;
    }

    public int a() {
        if (!this.e || this.f) {
            return Integer.MAX_VALUE;
        }
        return this.c;
    }
}

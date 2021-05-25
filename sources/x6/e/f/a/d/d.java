package x6.e.f.a.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.pqc.crypto.xmss.XMSSOid;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
public final class d implements XMSSOid {
    public static final Map<String, d> c;
    public final int a;
    public final String b;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a("SHA-256", 32, 16, 67), new d(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(a(McElieceCCA2KeyGenParameterSpec.SHA512, 64, 16, 131), new d(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(a("SHAKE128", 32, 16, 67), new d(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(a("SHAKE256", 64, 16, 131), new d(67108868, "WOTSP_SHAKE256_W16"));
        c = Collections.unmodifiableMap(hashMap);
    }

    public d(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public static String a(String str, int i, int i2, int i3) {
        return str + "-" + i + "-" + i2 + "-" + i3;
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSOid
    public int getOid() {
        return this.a;
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSOid
    public String toString() {
        return this.b;
    }
}

package org.spongycastle.pqc.crypto.xmss;

import a2.b.a.a.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public final class DefaultXMSSMTOid implements XMSSOid {
    public static final Map<String, DefaultXMSSMTOid> c;
    public final int a;
    public final String b;

    static {
        HashMap hashMap = new HashMap();
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H20_D2", hashMap, a("SHA-256", 32, 16, 67, 20, 2));
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H20_D4", hashMap, a("SHA-256", 32, 16, 67, 20, 4));
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H40_D2", hashMap, a("SHA-256", 32, 16, 67, 40, 2));
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H40_D4", hashMap, a("SHA-256", 32, 16, 67, 40, 2));
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H40_D8", hashMap, a("SHA-256", 32, 16, 67, 40, 4));
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H60_D3", hashMap, a("SHA-256", 32, 16, 67, 60, 8));
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H60_D6", hashMap, a("SHA-256", 32, 16, 67, 60, 6));
        a.C0(16777217, "XMSSMT_SHA2-256_W16_H60_D12", hashMap, a("SHA-256", 32, 16, 67, 60, 12));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H20_D2", hashMap, a("SHA2-512", 64, 16, 131, 20, 2));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H20_D4", hashMap, a("SHA2-512", 64, 16, 131, 20, 4));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H40_D2", hashMap, a("SHA2-512", 64, 16, 131, 40, 2));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H40_D4", hashMap, a("SHA2-512", 64, 16, 131, 40, 4));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H40_D8", hashMap, a("SHA2-512", 64, 16, 131, 40, 8));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H60_D3", hashMap, a("SHA2-512", 64, 16, 131, 60, 3));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H60_D6", hashMap, a("SHA2-512", 64, 16, 131, 60, 6));
        a.C0(16777217, "XMSSMT_SHA2-512_W16_H60_D12", hashMap, a("SHA2-512", 64, 16, 131, 60, 12));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H20_D2", hashMap, a("SHAKE128", 32, 16, 67, 20, 2));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H20_D4", hashMap, a("SHAKE128", 32, 16, 67, 20, 4));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H40_D2", hashMap, a("SHAKE128", 32, 16, 67, 40, 2));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H40_D4", hashMap, a("SHAKE128", 32, 16, 67, 40, 4));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H40_D8", hashMap, a("SHAKE128", 32, 16, 67, 40, 8));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H60_D3", hashMap, a("SHAKE128", 32, 16, 67, 60, 3));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H60_D6", hashMap, a("SHAKE128", 32, 16, 67, 60, 6));
        a.C0(16777217, "XMSSMT_SHAKE128_W16_H60_D12", hashMap, a("SHAKE128", 32, 16, 67, 60, 12));
        a.C0(16777217, "XMSSMT_SHAKE256_W16_H20_D2", hashMap, a("SHAKE256", 64, 16, 131, 20, 2));
        a.C0(16777217, "XMSSMT_SHAKE256_W16_H20_D4", hashMap, a("SHAKE256", 64, 16, 131, 20, 4));
        a.C0(16777217, "XMSSMT_SHAKE256_W16_H40_D2", hashMap, a("SHAKE256", 64, 16, 131, 40, 2));
        a.C0(16777217, "XMSSMT_SHAKE256_W16_H40_D4", hashMap, a("SHAKE256", 64, 16, 131, 40, 4));
        a.C0(16777217, "XMSSMT_SHAKE256_W16_H40_D8", hashMap, a("SHAKE256", 64, 16, 131, 40, 8));
        a.C0(16777217, "XMSSMT_SHAKE256_W16_H60_D3", hashMap, a("SHAKE256", 64, 16, 131, 60, 3));
        a.C0(16777217, "XMSSMT_SHAKE256_W16_H60_D6", hashMap, a("SHAKE256", 64, 16, 131, 60, 6));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 12), new DefaultXMSSMTOid(16777217, "XMSSMT_SHAKE256_W16_H60_D12"));
        c = Collections.unmodifiableMap(hashMap);
    }

    public DefaultXMSSMTOid(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public static String a(String str, int i, int i2, int i3, int i4, int i5) {
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4 + "-" + i5;
    }

    public static DefaultXMSSMTOid lookup(String str, int i, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(str, "algorithmName == null");
        return c.get(a(str, i, i2, i3, i4, i5));
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

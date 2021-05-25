package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.util.Arrays;
public class GOST28147ParameterSpec implements AlgorithmParameterSpec {
    public static Map c;
    public byte[] a;
    public byte[] b;

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, "E-A");
        c.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet, "E-B");
        c.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet, "E-C");
        c.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet, "E-D");
    }

    public GOST28147ParameterSpec(byte[] bArr) {
        this.a = null;
        this.b = null;
        byte[] bArr2 = new byte[bArr.length];
        this.b = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public byte[] getIV() {
        return Arrays.clone(this.a);
    }

    public byte[] getSBox() {
        return Arrays.clone(this.b);
    }

    public byte[] getSbox() {
        return Arrays.clone(this.b);
    }

    public GOST28147ParameterSpec(byte[] bArr, byte[] bArr2) {
        this(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        this.a = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
    }

    public GOST28147ParameterSpec(String str) {
        this.a = null;
        this.b = null;
        this.b = GOST28147Engine.getSBox(str);
    }

    public GOST28147ParameterSpec(String str, byte[] bArr) {
        this(str);
        byte[] bArr2 = new byte[bArr.length];
        this.a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GOST28147ParameterSpec(org.spongycastle.asn1.ASN1ObjectIdentifier r3, byte[] r4) {
        /*
            r2 = this;
            java.util.Map r0 = org.spongycastle.jcajce.spec.GOST28147ParameterSpec.c
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0014
            r2.<init>(r0)
            byte[] r3 = org.spongycastle.util.Arrays.clone(r4)
            r2.a = r3
            return
        L_0x0014:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unknown OID: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.spec.GOST28147ParameterSpec.<init>(org.spongycastle.asn1.ASN1ObjectIdentifier, byte[]):void");
    }
}

package org.spongycastle.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.util.Arrays;
public class TLSKeyMaterialSpec implements KeySpec {
    public static final String KEY_EXPANSION = "key expansion";
    public static final String MASTER_SECRET = "master secret";
    public final byte[] a;
    public final String b;
    public final int c;
    public final byte[] d;

    public TLSKeyMaterialSpec(byte[] bArr, String str, int i, byte[]... bArr2) {
        this.a = Arrays.clone(bArr);
        this.b = str;
        this.c = i;
        this.d = Arrays.concatenate(bArr2);
    }

    public String getLabel() {
        return this.b;
    }

    public int getLength() {
        return this.c;
    }

    public byte[] getSecret() {
        return Arrays.clone(this.a);
    }

    public byte[] getSeed() {
        return Arrays.clone(this.d);
    }
}

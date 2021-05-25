package org.spongycastle.crypto.macs;

import a2.b.a.a.a;
import com.adjust.sdk.Constants;
import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.spongycastle.util.Integers;
import org.spongycastle.util.Memoable;
public class HMac implements Mac {
    public static Hashtable h;
    public Digest a;
    public int b;
    public int c;
    public Memoable d;
    public Memoable e;
    public byte[] f;
    public byte[] g;

    static {
        Hashtable hashtable = new Hashtable();
        h = hashtable;
        hashtable.put("GOST3411", Integers.valueOf(32));
        h.put("MD2", Integers.valueOf(16));
        h.put("MD4", Integers.valueOf(64));
        h.put(Constants.MD5, Integers.valueOf(64));
        h.put("RIPEMD128", Integers.valueOf(64));
        h.put("RIPEMD160", Integers.valueOf(64));
        h.put("SHA-1", Integers.valueOf(64));
        h.put(McElieceCCA2KeyGenParameterSpec.SHA224, Integers.valueOf(64));
        h.put("SHA-256", Integers.valueOf(64));
        h.put(McElieceCCA2KeyGenParameterSpec.SHA384, Integers.valueOf(128));
        h.put(McElieceCCA2KeyGenParameterSpec.SHA512, Integers.valueOf(128));
        h.put("Tiger", Integers.valueOf(64));
        h.put("Whirlpool", Integers.valueOf(64));
    }

    public HMac(Digest digest) {
        int i;
        if (digest instanceof ExtendedDigest) {
            i = ((ExtendedDigest) digest).getByteLength();
        } else {
            Integer num = (Integer) h.get(digest.getAlgorithmName());
            if (num != null) {
                i = num.intValue();
            } else {
                StringBuilder L = a.L("unknown digest passed: ");
                L.append(digest.getAlgorithmName());
                throw new IllegalArgumentException(L.toString());
            }
        }
        this.a = digest;
        int digestSize = digest.getDigestSize();
        this.b = digestSize;
        this.c = i;
        this.f = new byte[i];
        this.g = new byte[(i + digestSize)];
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        this.a.doFinal(this.g, this.c);
        Memoable memoable = this.e;
        if (memoable != null) {
            ((Memoable) this.a).reset(memoable);
            Digest digest = this.a;
            digest.update(this.g, this.c, digest.getDigestSize());
        } else {
            Digest digest2 = this.a;
            byte[] bArr2 = this.g;
            digest2.update(bArr2, 0, bArr2.length);
        }
        int doFinal = this.a.doFinal(bArr, i);
        int i2 = this.c;
        while (true) {
            byte[] bArr3 = this.g;
            if (i2 >= bArr3.length) {
                break;
            }
            bArr3[i2] = 0;
            i2++;
        }
        Memoable memoable2 = this.d;
        if (memoable2 != null) {
            ((Memoable) this.a).reset(memoable2);
        } else {
            Digest digest3 = this.a;
            byte[] bArr4 = this.f;
            digest3.update(bArr4, 0, bArr4.length);
        }
        return doFinal;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.a.getAlgorithmName() + "/HMAC";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.b;
    }

    public Digest getUnderlyingDigest() {
        return this.a;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        byte[] bArr;
        this.a.reset();
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        int length = key.length;
        if (length > this.c) {
            this.a.update(key, 0, length);
            this.a.doFinal(this.f, 0);
            length = this.b;
        } else {
            System.arraycopy(key, 0, this.f, 0, length);
        }
        while (true) {
            bArr = this.f;
            if (length >= bArr.length) {
                break;
            }
            bArr[length] = 0;
            length++;
        }
        System.arraycopy(bArr, 0, this.g, 0, this.c);
        byte[] bArr2 = this.f;
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) (bArr2[i2] ^ 54);
        }
        byte[] bArr3 = this.g;
        int i3 = this.c;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArr3[i4] ^ 92);
        }
        Digest digest = this.a;
        if (digest instanceof Memoable) {
            Memoable copy = ((Memoable) digest).copy();
            this.e = copy;
            ((Digest) copy).update(this.g, 0, this.c);
        }
        Digest digest2 = this.a;
        byte[] bArr4 = this.f;
        digest2.update(bArr4, 0, bArr4.length);
        Digest digest3 = this.a;
        if (digest3 instanceof Memoable) {
            this.d = ((Memoable) digest3).copy();
        }
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.a.reset();
        Digest digest = this.a;
        byte[] bArr = this.f;
        digest.update(bArr, 0, bArr.length);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b2) {
        this.a.update(b2);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}

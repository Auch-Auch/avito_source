package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.RainbowPrivateKey;
import org.spongycastle.pqc.crypto.rainbow.Layer;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
public class BCRainbowPrivateKey implements PrivateKey {
    private static final long serialVersionUID = 1;
    public short[][] a;
    public short[] b;
    public short[][] c;
    public short[] d;
    public Layer[] e;
    public int[] f;

    public BCRainbowPrivateKey(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.a = sArr;
        this.b = sArr2;
        this.c = sArr3;
        this.d = sArr4;
        this.f = iArr;
        this.e = layerArr;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCRainbowPrivateKey)) {
            return false;
        }
        BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) obj;
        boolean z = ((((RainbowUtil.equals(this.a, bCRainbowPrivateKey.getInvA1())) && RainbowUtil.equals(this.c, bCRainbowPrivateKey.getInvA2())) && RainbowUtil.equals(this.b, bCRainbowPrivateKey.getB1())) && RainbowUtil.equals(this.d, bCRainbowPrivateKey.getB2())) && Arrays.equals(this.f, bCRainbowPrivateKey.getVi());
        if (this.e.length != bCRainbowPrivateKey.getLayers().length) {
            return false;
        }
        for (int length = this.e.length - 1; length >= 0; length--) {
            z &= this.e[length].equals(bCRainbowPrivateKey.getLayers()[length]);
        }
        return z;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[] getB1() {
        return this.b;
    }

    public short[] getB2() {
        return this.d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.rainbow, DERNull.INSTANCE), new RainbowPrivateKey(this.a, this.b, this.c, this.d, this.f, this.e)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public short[][] getInvA1() {
        return this.a;
    }

    public short[][] getInvA2() {
        return this.c;
    }

    public Layer[] getLayers() {
        return this.e;
    }

    public int[] getVi() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = org.spongycastle.util.Arrays.hashCode(this.a);
        int hashCode2 = org.spongycastle.util.Arrays.hashCode(this.b);
        int hashCode3 = org.spongycastle.util.Arrays.hashCode(this.c);
        int hashCode4 = org.spongycastle.util.Arrays.hashCode(this.f) + ((org.spongycastle.util.Arrays.hashCode(this.d) + ((hashCode3 + ((hashCode2 + ((hashCode + (this.e.length * 37)) * 37)) * 37)) * 37)) * 37);
        for (int length = this.e.length - 1; length >= 0; length--) {
            hashCode4 = (hashCode4 * 37) + this.e[length].hashCode();
        }
        return hashCode4;
    }

    public BCRainbowPrivateKey(RainbowPrivateKeySpec rainbowPrivateKeySpec) {
        this(rainbowPrivateKeySpec.getInvA1(), rainbowPrivateKeySpec.getB1(), rainbowPrivateKeySpec.getInvA2(), rainbowPrivateKeySpec.getB2(), rainbowPrivateKeySpec.getVi(), rainbowPrivateKeySpec.getLayers());
    }

    public BCRainbowPrivateKey(RainbowPrivateKeyParameters rainbowPrivateKeyParameters) {
        this(rainbowPrivateKeyParameters.getInvA1(), rainbowPrivateKeyParameters.getB1(), rainbowPrivateKeyParameters.getInvA2(), rainbowPrivateKeyParameters.getB2(), rainbowPrivateKeyParameters.getVi(), rainbowPrivateKeyParameters.getLayers());
    }
}

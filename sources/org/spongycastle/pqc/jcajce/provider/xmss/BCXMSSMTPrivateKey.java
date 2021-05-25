package org.spongycastle.pqc.jcajce.provider.xmss;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.XMSSMTKeyParams;
import org.spongycastle.pqc.asn1.XMSSMTPrivateKey;
import org.spongycastle.pqc.asn1.XMSSPrivateKey;
import org.spongycastle.pqc.crypto.xmss.BDSStateMap;
import org.spongycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
import org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey;
import org.spongycastle.util.Arrays;
public class BCXMSSMTPrivateKey implements PrivateKey, XMSSMTKey {
    public final ASN1ObjectIdentifier a;
    public final XMSSMTPrivateKeyParameters b;

    public BCXMSSMTPrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters) {
        this.a = aSN1ObjectIdentifier;
        this.b = xMSSMTPrivateKeyParameters;
    }

    public final XMSSMTPrivateKey a() {
        byte[] byteArray = this.b.toByteArray();
        int digestSize = this.b.getParameters().getDigestSize();
        int height = this.b.getParameters().getHeight();
        int i = (height + 7) / 8;
        int bytesToXBigEndian = (int) XMSSUtil.bytesToXBigEndian(byteArray, 0, i);
        if (XMSSUtil.isIndexValid(height, (long) bytesToXBigEndian)) {
            int i2 = i + 0;
            byte[] extractBytesAtOffset = XMSSUtil.extractBytesAtOffset(byteArray, i2, digestSize);
            int i3 = i2 + digestSize;
            byte[] extractBytesAtOffset2 = XMSSUtil.extractBytesAtOffset(byteArray, i3, digestSize);
            int i4 = i3 + digestSize;
            byte[] extractBytesAtOffset3 = XMSSUtil.extractBytesAtOffset(byteArray, i4, digestSize);
            int i5 = i4 + digestSize;
            byte[] extractBytesAtOffset4 = XMSSUtil.extractBytesAtOffset(byteArray, i5, digestSize);
            int i6 = i5 + digestSize;
            return new XMSSMTPrivateKey(bytesToXBigEndian, extractBytesAtOffset, extractBytesAtOffset2, extractBytesAtOffset3, extractBytesAtOffset4, XMSSUtil.extractBytesAtOffset(byteArray, i6, byteArray.length - i6));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPrivateKey)) {
            return false;
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) obj;
        if (!this.a.equals(bCXMSSMTPrivateKey.a) || !Arrays.areEqual(this.b.toByteArray(), bCXMSSMTPrivateKey.b.toByteArray())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss_mt, new XMSSMTKeyParams(this.b.getParameters().getHeight(), this.b.getParameters().getLayers(), new AlgorithmIdentifier(this.a))), a()).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey
    public int getHeight() {
        return this.b.getParameters().getHeight();
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey
    public int getLayers() {
        return this.b.getParameters().getLayers();
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey
    public String getTreeDigest() {
        return AppCompatDelegateImpl.i.J0(this.a);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (Arrays.hashCode(this.b.toByteArray()) * 37) + this.a.hashCode();
    }

    public BCXMSSMTPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        XMSSMTKeyParams instance = XMSSMTKeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        ASN1ObjectIdentifier algorithm = instance.getTreeDigest().getAlgorithm();
        this.a = algorithm;
        XMSSPrivateKey instance2 = XMSSPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
        try {
            XMSSMTPrivateKeyParameters.Builder withRoot = new XMSSMTPrivateKeyParameters.Builder(new XMSSMTParameters(instance.getHeight(), instance.getLayers(), AppCompatDelegateImpl.i.w0(algorithm))).withIndex((long) instance2.getIndex()).withSecretKeySeed(instance2.getSecretKeySeed()).withSecretKeyPRF(instance2.getSecretKeyPRF()).withPublicSeed(instance2.getPublicSeed()).withRoot(instance2.getRoot());
            if (instance2.getBdsState() != null) {
                withRoot.withBDSState((BDSStateMap) XMSSUtil.deserialize(instance2.getBdsState()));
            }
            this.b = withRoot.build();
        } catch (ClassNotFoundException e) {
            StringBuilder L = a.L("ClassNotFoundException processing BDS state: ");
            L.append(e.getMessage());
            throw new IOException(L.toString());
        }
    }
}

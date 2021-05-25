package org.spongycastle.pqc.jcajce.provider.xmss;

import a2.b.a.a.a;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.XMSSKeyParams;
import org.spongycastle.pqc.asn1.XMSSPrivateKey;
import org.spongycastle.pqc.crypto.xmss.BDS;
import org.spongycastle.pqc.crypto.xmss.XMSSParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
import org.spongycastle.pqc.jcajce.interfaces.XMSSKey;
import org.spongycastle.util.Arrays;
public class BCXMSSPrivateKey implements PrivateKey, XMSSKey {
    public final XMSSPrivateKeyParameters a;
    public final ASN1ObjectIdentifier b;

    public BCXMSSPrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, XMSSPrivateKeyParameters xMSSPrivateKeyParameters) {
        this.b = aSN1ObjectIdentifier;
        this.a = xMSSPrivateKeyParameters;
    }

    public final XMSSPrivateKey a() {
        byte[] byteArray = this.a.toByteArray();
        int digestSize = this.a.getParameters().getDigestSize();
        int height = this.a.getParameters().getHeight();
        int bytesToXBigEndian = (int) XMSSUtil.bytesToXBigEndian(byteArray, 0, 4);
        if (XMSSUtil.isIndexValid(height, (long) bytesToXBigEndian)) {
            byte[] extractBytesAtOffset = XMSSUtil.extractBytesAtOffset(byteArray, 4, digestSize);
            int i = 4 + digestSize;
            byte[] extractBytesAtOffset2 = XMSSUtil.extractBytesAtOffset(byteArray, i, digestSize);
            int i2 = i + digestSize;
            byte[] extractBytesAtOffset3 = XMSSUtil.extractBytesAtOffset(byteArray, i2, digestSize);
            int i3 = i2 + digestSize;
            byte[] extractBytesAtOffset4 = XMSSUtil.extractBytesAtOffset(byteArray, i3, digestSize);
            int i4 = i3 + digestSize;
            return new XMSSPrivateKey(bytesToXBigEndian, extractBytesAtOffset, extractBytesAtOffset2, extractBytesAtOffset3, extractBytesAtOffset4, XMSSUtil.extractBytesAtOffset(byteArray, i4, byteArray.length - i4));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSPrivateKey)) {
            return false;
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) obj;
        if (!this.b.equals(bCXMSSPrivateKey.b) || !Arrays.areEqual(this.a.toByteArray(), bCXMSSPrivateKey.a.toByteArray())) {
            return false;
        }
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.xmss, new XMSSKeyParams(this.a.getParameters().getHeight(), new AlgorithmIdentifier(this.b))), a()).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSKey
    public int getHeight() {
        return this.a.getParameters().getHeight();
    }

    @Override // org.spongycastle.pqc.jcajce.interfaces.XMSSKey
    public String getTreeDigest() {
        return AppCompatDelegateImpl.i.J0(this.b);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (Arrays.hashCode(this.a.toByteArray()) * 37) + this.b.hashCode();
    }

    public BCXMSSPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        XMSSKeyParams instance = XMSSKeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        ASN1ObjectIdentifier algorithm = instance.getTreeDigest().getAlgorithm();
        this.b = algorithm;
        XMSSPrivateKey instance2 = XMSSPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
        try {
            XMSSPrivateKeyParameters.Builder withRoot = new XMSSPrivateKeyParameters.Builder(new XMSSParameters(instance.getHeight(), AppCompatDelegateImpl.i.w0(algorithm))).withIndex(instance2.getIndex()).withSecretKeySeed(instance2.getSecretKeySeed()).withSecretKeyPRF(instance2.getSecretKeyPRF()).withPublicSeed(instance2.getPublicSeed()).withRoot(instance2.getRoot());
            if (instance2.getBdsState() != null) {
                withRoot.withBDSState((BDS) XMSSUtil.deserialize(instance2.getBdsState()));
            }
            this.a = withRoot.build();
        } catch (ClassNotFoundException e) {
            StringBuilder L = a.L("ClassNotFoundException processing BDS state: ");
            L.append(e.getMessage());
            throw new IOException(L.toString());
        }
    }
}

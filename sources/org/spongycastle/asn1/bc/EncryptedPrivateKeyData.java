package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.x509.Certificate;
public class EncryptedPrivateKeyData extends ASN1Object {
    public final EncryptedPrivateKeyInfo a;
    public final Certificate[] b;

    public EncryptedPrivateKeyData(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo, Certificate[] certificateArr) {
        this.a = encryptedPrivateKeyInfo;
        Certificate[] certificateArr2 = new Certificate[certificateArr.length];
        this.b = certificateArr2;
        System.arraycopy(certificateArr, 0, certificateArr2, 0, certificateArr.length);
    }

    public static EncryptedPrivateKeyData getInstance(Object obj) {
        if (obj instanceof EncryptedPrivateKeyData) {
            return (EncryptedPrivateKeyData) obj;
        }
        if (obj != null) {
            return new EncryptedPrivateKeyData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Certificate[] getCertificateChain() {
        Certificate[] certificateArr = this.b;
        Certificate[] certificateArr2 = new Certificate[certificateArr.length];
        System.arraycopy(certificateArr, 0, certificateArr2, 0, certificateArr.length);
        return certificateArr2;
    }

    public EncryptedPrivateKeyInfo getEncryptedPrivateKeyInfo() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new DERSequence(this.b));
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedPrivateKeyData(ASN1Sequence aSN1Sequence) {
        int i = 0;
        this.a = EncryptedPrivateKeyInfo.getInstance(aSN1Sequence.getObjectAt(0));
        ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        this.b = new Certificate[instance.size()];
        while (true) {
            Certificate[] certificateArr = this.b;
            if (i != certificateArr.length) {
                certificateArr[i] = Certificate.getInstance(instance.getObjectAt(i));
                i++;
            } else {
                return;
            }
        }
    }
}

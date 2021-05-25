package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERUTF8String;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.GeneralName;
public class EncKeyWithID extends ASN1Object {
    public final PrivateKeyInfo a;
    public final ASN1Encodable b;

    public EncKeyWithID(ASN1Sequence aSN1Sequence) {
        this.a = PrivateKeyInfo.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() <= 1) {
            this.b = null;
        } else if (!(aSN1Sequence.getObjectAt(1) instanceof DERUTF8String)) {
            this.b = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            this.b = aSN1Sequence.getObjectAt(1);
        }
    }

    public static EncKeyWithID getInstance(Object obj) {
        if (obj instanceof EncKeyWithID) {
            return (EncKeyWithID) obj;
        }
        if (obj != null) {
            return new EncKeyWithID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Encodable getIdentifier() {
        return this.b;
    }

    public PrivateKeyInfo getPrivateKey() {
        return this.a;
    }

    public boolean hasIdentifier() {
        return this.b != null;
    }

    public boolean isIdentifierUTF8String() {
        return this.b instanceof DERUTF8String;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        ASN1Encodable aSN1Encodable = this.b;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.add(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public EncKeyWithID(PrivateKeyInfo privateKeyInfo) {
        this.a = privateKeyInfo;
        this.b = null;
    }

    public EncKeyWithID(PrivateKeyInfo privateKeyInfo, DERUTF8String dERUTF8String) {
        this.a = privateKeyInfo;
        this.b = dERUTF8String;
    }

    public EncKeyWithID(PrivateKeyInfo privateKeyInfo, GeneralName generalName) {
        this.a = privateKeyInfo;
        this.b = generalName;
    }
}

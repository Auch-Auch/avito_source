package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.EnvelopedData;
public class EncryptedKey extends ASN1Object implements ASN1Choice {
    public EnvelopedData a;
    public EncryptedValue b;

    public EncryptedKey(EnvelopedData envelopedData) {
        this.a = envelopedData;
    }

    public static EncryptedKey getInstance(Object obj) {
        if (obj instanceof EncryptedKey) {
            return (EncryptedKey) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new EncryptedKey(EnvelopedData.getInstance((ASN1TaggedObject) obj, false));
        }
        if (obj instanceof EncryptedValue) {
            return new EncryptedKey((EncryptedValue) obj);
        }
        return new EncryptedKey(EncryptedValue.getInstance(obj));
    }

    public ASN1Encodable getValue() {
        EncryptedValue encryptedValue = this.b;
        if (encryptedValue != null) {
            return encryptedValue;
        }
        return this.a;
    }

    public boolean isEncryptedValue() {
        return this.b != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        EncryptedValue encryptedValue = this.b;
        if (encryptedValue != null) {
            return encryptedValue.toASN1Primitive();
        }
        return new DERTaggedObject(false, 0, this.a);
    }

    public EncryptedKey(EncryptedValue encryptedValue) {
        this.b = encryptedValue;
    }
}

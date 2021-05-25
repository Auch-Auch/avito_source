package org.spongycastle.asn1.ess;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
public class ContentIdentifier extends ASN1Object {
    public ASN1OctetString a;

    public ContentIdentifier(ASN1OctetString aSN1OctetString) {
        this.a = aSN1OctetString;
    }

    public static ContentIdentifier getInstance(Object obj) {
        if (obj instanceof ContentIdentifier) {
            return (ContentIdentifier) obj;
        }
        if (obj != null) {
            return new ContentIdentifier(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getValue() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public ContentIdentifier(byte[] bArr) {
        this.a = new DEROctetString(bArr);
    }
}

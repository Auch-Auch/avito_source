package org.spongycastle.asn1.eac;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERTaggedObject;
public class UnsignedInteger extends ASN1Object {
    public int a;
    public BigInteger b;

    public UnsignedInteger(int i, BigInteger bigInteger) {
        this.a = i;
        this.b = bigInteger;
    }

    public static UnsignedInteger getInstance(Object obj) {
        if (obj instanceof UnsignedInteger) {
            return (UnsignedInteger) obj;
        }
        if (obj != null) {
            return new UnsignedInteger(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public int getTagNo() {
        return this.a;
    }

    public BigInteger getValue() {
        return this.b;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        int i = this.a;
        byte[] byteArray = this.b.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            byteArray = bArr;
        }
        return new DERTaggedObject(false, i, new DEROctetString(byteArray));
    }

    public UnsignedInteger(ASN1TaggedObject aSN1TaggedObject) {
        this.a = aSN1TaggedObject.getTagNo();
        this.b = new BigInteger(1, ASN1OctetString.getInstance(aSN1TaggedObject, false).getOctets());
    }
}

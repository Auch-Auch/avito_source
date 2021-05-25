package org.spongycastle.asn1.cmc;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
public class BodyPartID extends ASN1Object {
    public static final long bodyIdMax = 4294967295L;
    public final long a;

    public BodyPartID(long j) {
        if (j < 0 || j > bodyIdMax) {
            throw new IllegalArgumentException("id out of range");
        }
        this.a = j;
    }

    public static BodyPartID getInstance(Object obj) {
        if (obj instanceof BodyPartID) {
            return (BodyPartID) obj;
        }
        if (obj == null) {
            return null;
        }
        BigInteger value = ASN1Integer.getInstance(obj).getValue();
        if (value.bitLength() <= 32) {
            return new BodyPartID(value.longValue());
        }
        throw new IllegalArgumentException("id out of range");
    }

    public long getID() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.a);
    }
}

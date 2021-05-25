package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.util.Arrays;
public class MacData extends ASN1Object {
    public static final BigInteger d = BigInteger.valueOf(1);
    public DigestInfo a;
    public byte[] b;
    public BigInteger c;

    public MacData(ASN1Sequence aSN1Sequence) {
        this.a = DigestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.b = Arrays.clone(((ASN1OctetString) aSN1Sequence.getObjectAt(1)).getOctets());
        if (aSN1Sequence.size() == 3) {
            this.c = ((ASN1Integer) aSN1Sequence.getObjectAt(2)).getValue();
        } else {
            this.c = d;
        }
    }

    public static MacData getInstance(Object obj) {
        if (obj instanceof MacData) {
            return (MacData) obj;
        }
        if (obj != null) {
            return new MacData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getIterationCount() {
        return this.c;
    }

    public DigestInfo getMac() {
        return this.a;
    }

    public byte[] getSalt() {
        return Arrays.clone(this.b);
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(new DEROctetString(this.b));
        if (!this.c.equals(d)) {
            aSN1EncodableVector.add(new ASN1Integer(this.c));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public MacData(DigestInfo digestInfo, byte[] bArr, int i) {
        this.a = digestInfo;
        this.b = Arrays.clone(bArr);
        this.c = BigInteger.valueOf((long) i);
    }
}

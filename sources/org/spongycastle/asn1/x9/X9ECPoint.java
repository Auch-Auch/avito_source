package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;
public class X9ECPoint extends ASN1Object {
    public final ASN1OctetString a;
    public ECCurve b;
    public ECPoint c;

    public X9ECPoint(ECPoint eCPoint) {
        this(eCPoint, false);
    }

    public synchronized ECPoint getPoint() {
        if (this.c == null) {
            this.c = this.b.decodePoint(this.a.getOctets()).normalize();
        }
        return this.c;
    }

    public byte[] getPointEncoding() {
        return Arrays.clone(this.a.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] octets = this.a.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        if (octets[0] == 2 || octets[0] == 3) {
            return true;
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public X9ECPoint(ECPoint eCPoint, boolean z) {
        this.c = eCPoint.normalize();
        this.a = new DEROctetString(eCPoint.getEncoded(z));
    }

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.b = eCCurve;
        this.a = new DEROctetString(Arrays.clone(bArr));
    }

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this(eCCurve, aSN1OctetString.getOctets());
    }
}

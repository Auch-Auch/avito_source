package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
public class OtherStatusInfo extends ASN1Object implements ASN1Choice {
    public final CMCFailInfo a;
    public final PendInfo b;
    public final ExtendedFailInfo c;

    public OtherStatusInfo(CMCFailInfo cMCFailInfo) {
        this.a = cMCFailInfo;
        this.b = null;
        this.c = null;
    }

    public static OtherStatusInfo getInstance(Object obj) {
        if (obj instanceof OtherStatusInfo) {
            return (OtherStatusInfo) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1Integer) {
                return new OtherStatusInfo(CMCFailInfo.getInstance(aSN1Primitive));
            }
            if (aSN1Primitive instanceof ASN1Sequence) {
                if (((ASN1Sequence) aSN1Primitive).getObjectAt(0) instanceof ASN1ObjectIdentifier) {
                    return new OtherStatusInfo(null, null, ExtendedFailInfo.getInstance(aSN1Primitive));
                }
                return new OtherStatusInfo(null, PendInfo.getInstance(aSN1Primitive), null);
            }
        } else if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(a.A2(e, a.L("parsing error: ")));
            }
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance(): ")));
    }

    public boolean isExtendedFailInfo() {
        return this.c != null;
    }

    public boolean isFailInfo() {
        return this.a != null;
    }

    public boolean isPendingInfo() {
        return this.b != null;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        PendInfo pendInfo = this.b;
        if (pendInfo != null) {
            return pendInfo.toASN1Primitive();
        }
        CMCFailInfo cMCFailInfo = this.a;
        if (cMCFailInfo != null) {
            return cMCFailInfo.toASN1Primitive();
        }
        return this.c.toASN1Primitive();
    }

    public OtherStatusInfo(CMCFailInfo cMCFailInfo, PendInfo pendInfo, ExtendedFailInfo extendedFailInfo) {
        this.a = null;
        this.b = pendInfo;
        this.c = extendedFailInfo;
    }
}

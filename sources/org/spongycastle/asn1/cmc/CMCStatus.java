package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
public class CMCStatus extends ASN1Object {
    public static Map b;
    public static final CMCStatus confirmRequired;
    public static final CMCStatus failed;
    public static final CMCStatus noSupport;
    public static final CMCStatus partial;
    public static final CMCStatus pending;
    public static final CMCStatus popRequired;
    public static final CMCStatus success;
    public final ASN1Integer a;

    static {
        CMCStatus cMCStatus = new CMCStatus(new ASN1Integer(0));
        success = cMCStatus;
        CMCStatus cMCStatus2 = new CMCStatus(new ASN1Integer(2));
        failed = cMCStatus2;
        CMCStatus cMCStatus3 = new CMCStatus(new ASN1Integer(3));
        pending = cMCStatus3;
        CMCStatus cMCStatus4 = new CMCStatus(new ASN1Integer(4));
        noSupport = cMCStatus4;
        CMCStatus cMCStatus5 = new CMCStatus(new ASN1Integer(5));
        confirmRequired = cMCStatus5;
        CMCStatus cMCStatus6 = new CMCStatus(new ASN1Integer(6));
        popRequired = cMCStatus6;
        CMCStatus cMCStatus7 = new CMCStatus(new ASN1Integer(7));
        partial = cMCStatus7;
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(cMCStatus.a, cMCStatus);
        b.put(cMCStatus2.a, cMCStatus2);
        b.put(cMCStatus3.a, cMCStatus3);
        b.put(cMCStatus4.a, cMCStatus4);
        b.put(cMCStatus5.a, cMCStatus5);
        b.put(cMCStatus6.a, cMCStatus6);
        b.put(cMCStatus7.a, cMCStatus7);
    }

    public CMCStatus(ASN1Integer aSN1Integer) {
        this.a = aSN1Integer;
    }

    public static CMCStatus getInstance(Object obj) {
        if (obj instanceof CMCStatus) {
            return (CMCStatus) obj;
        }
        if (obj == null) {
            return null;
        }
        CMCStatus cMCStatus = (CMCStatus) b.get(ASN1Integer.getInstance(obj));
        if (cMCStatus != null) {
            return cMCStatus;
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance(): ")));
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }
}

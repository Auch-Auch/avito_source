package org.spongycastle.asn1.cmc;

import a2.b.a.a.a;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
public class CMCFailInfo extends ASN1Object {
    public static final CMCFailInfo authDataFail;
    public static Map b;
    public static final CMCFailInfo badAlg;
    public static final CMCFailInfo badCertId;
    public static final CMCFailInfo badIdentity;
    public static final CMCFailInfo badMessageCheck;
    public static final CMCFailInfo badRequest;
    public static final CMCFailInfo badTime;
    public static final CMCFailInfo internalCAError;
    public static final CMCFailInfo mustArchiveKeys;
    public static final CMCFailInfo noKeyReuse;
    public static final CMCFailInfo popFailed;
    public static final CMCFailInfo popRequired;
    public static final CMCFailInfo tryLater;
    public static final CMCFailInfo unsupportedExt;
    public final ASN1Integer a;

    static {
        CMCFailInfo cMCFailInfo = new CMCFailInfo(new ASN1Integer(0));
        badAlg = cMCFailInfo;
        CMCFailInfo cMCFailInfo2 = new CMCFailInfo(new ASN1Integer(1));
        badMessageCheck = cMCFailInfo2;
        CMCFailInfo cMCFailInfo3 = new CMCFailInfo(new ASN1Integer(2));
        badRequest = cMCFailInfo3;
        CMCFailInfo cMCFailInfo4 = new CMCFailInfo(new ASN1Integer(3));
        badTime = cMCFailInfo4;
        CMCFailInfo cMCFailInfo5 = new CMCFailInfo(new ASN1Integer(4));
        badCertId = cMCFailInfo5;
        CMCFailInfo cMCFailInfo6 = new CMCFailInfo(new ASN1Integer(5));
        unsupportedExt = cMCFailInfo6;
        CMCFailInfo cMCFailInfo7 = new CMCFailInfo(new ASN1Integer(6));
        mustArchiveKeys = cMCFailInfo7;
        CMCFailInfo cMCFailInfo8 = new CMCFailInfo(new ASN1Integer(7));
        badIdentity = cMCFailInfo8;
        CMCFailInfo cMCFailInfo9 = new CMCFailInfo(new ASN1Integer(8));
        popRequired = cMCFailInfo9;
        CMCFailInfo cMCFailInfo10 = new CMCFailInfo(new ASN1Integer(9));
        popFailed = cMCFailInfo10;
        CMCFailInfo cMCFailInfo11 = new CMCFailInfo(new ASN1Integer(10));
        noKeyReuse = cMCFailInfo11;
        CMCFailInfo cMCFailInfo12 = new CMCFailInfo(new ASN1Integer(11));
        internalCAError = cMCFailInfo12;
        CMCFailInfo cMCFailInfo13 = new CMCFailInfo(new ASN1Integer(12));
        tryLater = cMCFailInfo13;
        CMCFailInfo cMCFailInfo14 = new CMCFailInfo(new ASN1Integer(13));
        authDataFail = cMCFailInfo14;
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put(cMCFailInfo.a, cMCFailInfo);
        b.put(cMCFailInfo2.a, cMCFailInfo2);
        b.put(cMCFailInfo3.a, cMCFailInfo3);
        b.put(cMCFailInfo4.a, cMCFailInfo4);
        b.put(cMCFailInfo5.a, cMCFailInfo5);
        b.put(cMCFailInfo9.a, cMCFailInfo9);
        b.put(cMCFailInfo6.a, cMCFailInfo6);
        b.put(cMCFailInfo7.a, cMCFailInfo7);
        b.put(cMCFailInfo8.a, cMCFailInfo8);
        b.put(cMCFailInfo9.a, cMCFailInfo9);
        b.put(cMCFailInfo10.a, cMCFailInfo10);
        b.put(cMCFailInfo5.a, cMCFailInfo5);
        b.put(cMCFailInfo9.a, cMCFailInfo9);
        b.put(cMCFailInfo11.a, cMCFailInfo11);
        b.put(cMCFailInfo12.a, cMCFailInfo12);
        b.put(cMCFailInfo13.a, cMCFailInfo13);
        b.put(cMCFailInfo14.a, cMCFailInfo14);
    }

    public CMCFailInfo(ASN1Integer aSN1Integer) {
        this.a = aSN1Integer;
    }

    public static CMCFailInfo getInstance(Object obj) {
        if (obj instanceof CMCFailInfo) {
            return (CMCFailInfo) obj;
        }
        if (obj == null) {
            return null;
        }
        CMCFailInfo cMCFailInfo = (CMCFailInfo) b.get(ASN1Integer.getInstance(obj));
        if (cMCFailInfo != null) {
            return cMCFailInfo;
        }
        throw new IllegalArgumentException(a.H2(obj, a.L("unknown object in getInstance(): ")));
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }
}

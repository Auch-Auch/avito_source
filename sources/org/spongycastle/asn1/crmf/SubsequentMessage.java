package org.spongycastle.asn1.crmf;

import a2.b.a.a.a;
import org.spongycastle.asn1.ASN1Integer;
public class SubsequentMessage extends ASN1Integer {
    public static final SubsequentMessage challengeResp = new SubsequentMessage(1);
    public static final SubsequentMessage encrCert = new SubsequentMessage(0);

    public SubsequentMessage(int i) {
        super((long) i);
    }

    public static SubsequentMessage valueOf(int i) {
        if (i == 0) {
            return encrCert;
        }
        if (i == 1) {
            return challengeResp;
        }
        throw new IllegalArgumentException(a.M2("unknown value: ", i));
    }
}

package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.util.Integers;
public class CRLReason extends ASN1Object {
    public static final int AA_COMPROMISE = 10;
    public static final int AFFILIATION_CHANGED = 3;
    public static final int CA_COMPROMISE = 2;
    public static final int CERTIFICATE_HOLD = 6;
    public static final int CESSATION_OF_OPERATION = 5;
    public static final int KEY_COMPROMISE = 1;
    public static final int PRIVILEGE_WITHDRAWN = 9;
    public static final int REMOVE_FROM_CRL = 8;
    public static final int SUPERSEDED = 4;
    public static final int UNSPECIFIED = 0;
    public static final int aACompromise = 10;
    public static final int affiliationChanged = 3;
    public static final String[] b = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
    public static final Hashtable c = new Hashtable();
    public static final int cACompromise = 2;
    public static final int certificateHold = 6;
    public static final int cessationOfOperation = 5;
    public static final int keyCompromise = 1;
    public static final int privilegeWithdrawn = 9;
    public static final int removeFromCRL = 8;
    public static final int superseded = 4;
    public static final int unspecified = 0;
    public ASN1Enumerated a;

    public CRLReason(int i) {
        this.a = new ASN1Enumerated(i);
    }

    public static CRLReason getInstance(Object obj) {
        if (obj instanceof CRLReason) {
            return (CRLReason) obj;
        }
        if (obj != null) {
            return lookup(ASN1Enumerated.getInstance(obj).getValue().intValue());
        }
        return null;
    }

    public static CRLReason lookup(int i) {
        Integer valueOf = Integers.valueOf(i);
        Hashtable hashtable = c;
        if (!hashtable.containsKey(valueOf)) {
            hashtable.put(valueOf, new CRLReason(i));
        }
        return (CRLReason) hashtable.get(valueOf);
    }

    public BigInteger getValue() {
        return this.a.getValue();
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.a;
    }

    public String toString() {
        int intValue = getValue().intValue();
        return a.c3("CRLReason: ", (intValue < 0 || intValue > 10) ? "invalid" : b[intValue]);
    }
}

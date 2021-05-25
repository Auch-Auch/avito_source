package org.spongycastle.asn1;

import java.math.BigInteger;
public class DEREnumerated extends ASN1Enumerated {
    public DEREnumerated(BigInteger bigInteger) {
        super(bigInteger);
    }

    public DEREnumerated(int i) {
        super(i);
    }
}

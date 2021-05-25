package org.spongycastle.crypto.agreement.jpake;

import java.math.BigInteger;
public class JPAKERound3Payload {
    public final String a;
    public final BigInteger b;

    public JPAKERound3Payload(String str, BigInteger bigInteger) {
        this.a = str;
        this.b = bigInteger;
    }

    public BigInteger getMacTag() {
        return this.b;
    }

    public String getParticipantId() {
        return this.a;
    }
}

package org.spongycastle.crypto.agreement.jpake;

import java.math.BigInteger;
import org.spongycastle.util.Arrays;
public class JPAKERound1Payload {
    public final String a;
    public final BigInteger b;
    public final BigInteger c;
    public final BigInteger[] d;
    public final BigInteger[] e;

    public JPAKERound1Payload(String str, BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2) {
        JPAKEUtil.validateNotNull(str, "participantId");
        JPAKEUtil.validateNotNull(bigInteger, "gx1");
        JPAKEUtil.validateNotNull(bigInteger2, "gx2");
        JPAKEUtil.validateNotNull(bigIntegerArr, "knowledgeProofForX1");
        JPAKEUtil.validateNotNull(bigIntegerArr2, "knowledgeProofForX2");
        this.a = str;
        this.b = bigInteger;
        this.c = bigInteger2;
        this.d = Arrays.copyOf(bigIntegerArr, bigIntegerArr.length);
        this.e = Arrays.copyOf(bigIntegerArr2, bigIntegerArr2.length);
    }

    public BigInteger getGx1() {
        return this.b;
    }

    public BigInteger getGx2() {
        return this.c;
    }

    public BigInteger[] getKnowledgeProofForX1() {
        BigInteger[] bigIntegerArr = this.d;
        return Arrays.copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public BigInteger[] getKnowledgeProofForX2() {
        BigInteger[] bigIntegerArr = this.e;
        return Arrays.copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public String getParticipantId() {
        return this.a;
    }
}

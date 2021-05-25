package org.spongycastle.crypto.agreement.jpake;

import com.avito.android.remote.auth.AuthSource;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;
public class JPAKERound2Payload {
    public final String a;
    public final BigInteger b;
    public final BigInteger[] c;

    public JPAKERound2Payload(String str, BigInteger bigInteger, BigInteger[] bigIntegerArr) {
        JPAKEUtil.validateNotNull(str, "participantId");
        JPAKEUtil.validateNotNull(bigInteger, AuthSource.SEND_ABUSE);
        JPAKEUtil.validateNotNull(bigIntegerArr, "knowledgeProofForX2s");
        this.a = str;
        this.b = bigInteger;
        this.c = Arrays.copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public BigInteger getA() {
        return this.b;
    }

    public BigInteger[] getKnowledgeProofForX2s() {
        BigInteger[] bigIntegerArr = this.c;
        return Arrays.copyOf(bigIntegerArr, bigIntegerArr.length);
    }

    public String getParticipantId() {
        return this.a;
    }
}

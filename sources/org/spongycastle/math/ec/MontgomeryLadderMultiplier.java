package org.spongycastle.math.ec;
public class MontgomeryLadderMultiplier extends AbstractECMultiplier {
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.spongycastle.math.ec.AbstractECMultiplier
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.math.ec.ECPoint multiplyPositive(org.spongycastle.math.ec.ECPoint r7, java.math.BigInteger r8) {
        /*
            r6 = this;
            r0 = 2
            org.spongycastle.math.ec.ECPoint[] r0 = new org.spongycastle.math.ec.ECPoint[r0]
            org.spongycastle.math.ec.ECCurve r1 = r7.getCurve()
            org.spongycastle.math.ec.ECPoint r1 = r1.getInfinity()
            r2 = 0
            r0[r2] = r1
            r1 = 1
            r0[r1] = r7
            int r7 = r8.bitLength()
        L_0x0015:
            int r7 = r7 + -1
            if (r7 < 0) goto L_0x0032
            boolean r1 = r8.testBit(r7)
            int r3 = 1 - r1
            r4 = r0[r3]
            r5 = r0[r1]
            org.spongycastle.math.ec.ECPoint r4 = r4.add(r5)
            r0[r3] = r4
            r3 = r0[r1]
            org.spongycastle.math.ec.ECPoint r3 = r3.twice()
            r0[r1] = r3
            goto L_0x0015
        L_0x0032:
            r7 = r0[r2]
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.MontgomeryLadderMultiplier.multiplyPositive(org.spongycastle.math.ec.ECPoint, java.math.BigInteger):org.spongycastle.math.ec.ECPoint");
    }
}

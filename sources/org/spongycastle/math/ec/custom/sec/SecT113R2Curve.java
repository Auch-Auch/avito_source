package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;
public class SecT113R2Curve extends ECCurve.AbstractF2m {
    public SecT113R2Point infinity = new SecT113R2Point(this, null, null);

    public SecT113R2Curve() {
        super(113, 9, 0, 0);
        this.a = fromBigInteger(new BigInteger(1, Hex.decode("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.b = fromBigInteger(new BigInteger(1, Hex.decode("0095E9A9EC9B297BD4BF36E059184F")));
        this.order = new BigInteger(1, Hex.decode("010000000000000108789B2496AF93"));
        this.cofactor = BigInteger.valueOf(2);
        this.coord = 6;
    }

    @Override // org.spongycastle.math.ec.ECCurve
    public ECCurve cloneCurve() {
        return new SecT113R2Curve();
    }

    @Override // org.spongycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT113R2Point(this, eCFieldElement, eCFieldElement2, z);
    }

    @Override // org.spongycastle.math.ec.ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT113FieldElement(bigInteger);
    }

    @Override // org.spongycastle.math.ec.ECCurve
    public int getFieldSize() {
        return 113;
    }

    @Override // org.spongycastle.math.ec.ECCurve
    public ECPoint getInfinity() {
        return this.infinity;
    }

    public int getK1() {
        return 9;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 113;
    }

    @Override // org.spongycastle.math.ec.ECCurve.AbstractF2m
    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return true;
    }

    @Override // org.spongycastle.math.ec.ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 6;
    }

    @Override // org.spongycastle.math.ec.ECCurve
    public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT113R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }
}

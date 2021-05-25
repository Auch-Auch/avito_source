package org.spongycastle.crypto.ec;

import org.spongycastle.math.ec.ECPoint;
public class ECPair {
    public final ECPoint a;
    public final ECPoint b;

    public ECPair(ECPoint eCPoint, ECPoint eCPoint2) {
        this.a = eCPoint;
        this.b = eCPoint2;
    }

    public boolean equals(ECPair eCPair) {
        return eCPair.getX().equals(getX()) && eCPair.getY().equals(getY());
    }

    public ECPoint getX() {
        return this.a;
    }

    public ECPoint getY() {
        return this.b;
    }

    public int hashCode() {
        return (this.b.hashCode() * 37) + this.a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ECPair) {
            return equals((ECPair) obj);
        }
        return false;
    }
}

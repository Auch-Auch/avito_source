package org.spongycastle.crypto.params;
public class GOST3410ValidationParameters {
    public int a;
    public int b;
    public long c;
    public long d;

    public GOST3410ValidationParameters(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        if (gOST3410ValidationParameters.b == this.b && gOST3410ValidationParameters.a == this.a && gOST3410ValidationParameters.d == this.d && gOST3410ValidationParameters.c == this.c) {
            return true;
        }
        return false;
    }

    public int getC() {
        return this.b;
    }

    public long getCL() {
        return this.d;
    }

    public int getX0() {
        return this.a;
    }

    public long getX0L() {
        return this.c;
    }

    public int hashCode() {
        int i = this.a ^ this.b;
        long j = this.c;
        long j2 = this.d;
        return (((i ^ ((int) j)) ^ ((int) (j >> 32))) ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.c = j;
        this.d = j2;
    }
}

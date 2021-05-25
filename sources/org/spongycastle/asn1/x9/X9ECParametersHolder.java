package org.spongycastle.asn1.x9;
public abstract class X9ECParametersHolder {
    public X9ECParameters a;

    public abstract X9ECParameters createParameters();

    public synchronized X9ECParameters getParameters() {
        if (this.a == null) {
            this.a = createParameters();
        }
        return this.a;
    }
}

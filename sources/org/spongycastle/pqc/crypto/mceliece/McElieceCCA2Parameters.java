package org.spongycastle.pqc.crypto.mceliece;
public class McElieceCCA2Parameters extends McElieceParameters {
    public final String f;

    public McElieceCCA2Parameters() {
        this(11, 50, "SHA-256");
    }

    public String getDigest() {
        return this.f;
    }

    public McElieceCCA2Parameters(String str) {
        this(11, 50, str);
    }

    public McElieceCCA2Parameters(int i) {
        this(i, "SHA-256");
    }

    public McElieceCCA2Parameters(int i, String str) {
        super(i);
        this.f = str;
    }

    public McElieceCCA2Parameters(int i, int i2) {
        this(i, i2, "SHA-256");
    }

    public McElieceCCA2Parameters(int i, int i2, String str) {
        super(i, i2);
        this.f = str;
    }

    public McElieceCCA2Parameters(int i, int i2, int i3) {
        this(i, i2, i3, "SHA-256");
    }

    public McElieceCCA2Parameters(int i, int i2, int i3, String str) {
        super(i, i2, i3);
        this.f = str;
    }
}

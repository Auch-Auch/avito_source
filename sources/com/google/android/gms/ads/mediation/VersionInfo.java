package com.google.android.gms.ads.mediation;
public final class VersionInfo {
    private final int zzeqs;
    private final int zzeqt;
    private final int zzequ;

    public VersionInfo(int i, int i2, int i3) {
        this.zzeqs = i;
        this.zzeqt = i2;
        this.zzequ = i3;
    }

    public final int getMajorVersion() {
        return this.zzeqs;
    }

    public final int getMicroVersion() {
        return this.zzequ;
    }

    public final int getMinorVersion() {
        return this.zzeqt;
    }
}

package com.google.zxing.qrcode.detector;
public final class FinderPatternInfo {
    public final FinderPattern a;
    public final FinderPattern b;
    public final FinderPattern c;

    public FinderPatternInfo(FinderPattern[] finderPatternArr) {
        this.a = finderPatternArr[0];
        this.b = finderPatternArr[1];
        this.c = finderPatternArr[2];
    }

    public FinderPattern getBottomLeft() {
        return this.a;
    }

    public FinderPattern getTopLeft() {
        return this.b;
    }

    public FinderPattern getTopRight() {
        return this.c;
    }
}

package com.bumptech.glide.load.engine.bitmap_recycle;

import a2.d.a.d.b.u.a;
public final class IntegerArrayAdapter implements a<int[]> {
    @Override // a2.d.a.d.b.u.a
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override // a2.d.a.d.b.u.a
    public String getTag() {
        return "IntegerArrayPool";
    }

    public int getArrayLength(int[] iArr) {
        return iArr.length;
    }

    @Override // a2.d.a.d.b.u.a
    public int[] newArray(int i) {
        return new int[i];
    }
}

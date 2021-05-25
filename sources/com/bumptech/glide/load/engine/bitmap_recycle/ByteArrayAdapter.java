package com.bumptech.glide.load.engine.bitmap_recycle;

import a2.d.a.d.b.u.a;
public final class ByteArrayAdapter implements a<byte[]> {
    @Override // a2.d.a.d.b.u.a
    public int getElementSizeInBytes() {
        return 1;
    }

    @Override // a2.d.a.d.b.u.a
    public String getTag() {
        return "ByteArrayPool";
    }

    public int getArrayLength(byte[] bArr) {
        return bArr.length;
    }

    @Override // a2.d.a.d.b.u.a
    public byte[] newArray(int i) {
        return new byte[i];
    }
}

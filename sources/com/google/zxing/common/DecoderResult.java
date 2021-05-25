package com.google.zxing.common;

import java.util.List;
public final class DecoderResult {
    public final byte[] a;
    public int b;
    public final String c;
    public final List<byte[]> d;
    public final String e;
    public Integer f;
    public Integer g;
    public Object h;
    public final int i;
    public final int j;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> getByteSegments() {
        return this.d;
    }

    public String getECLevel() {
        return this.e;
    }

    public Integer getErasures() {
        return this.g;
    }

    public Integer getErrorsCorrected() {
        return this.f;
    }

    public int getNumBits() {
        return this.b;
    }

    public Object getOther() {
        return this.h;
    }

    public byte[] getRawBytes() {
        return this.a;
    }

    public int getStructuredAppendParity() {
        return this.i;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.j;
    }

    public String getText() {
        return this.c;
    }

    public boolean hasStructuredAppend() {
        return this.i >= 0 && this.j >= 0;
    }

    public void setErasures(Integer num) {
        this.g = num;
    }

    public void setErrorsCorrected(Integer num) {
        this.f = num;
    }

    public void setNumBits(int i2) {
        this.b = i2;
    }

    public void setOther(Object obj) {
        this.h = obj;
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        int i4;
        this.a = bArr;
        if (bArr == null) {
            i4 = 0;
        } else {
            i4 = bArr.length * 8;
        }
        this.b = i4;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i3;
        this.j = i2;
    }
}

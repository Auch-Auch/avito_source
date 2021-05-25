package com.google.zxing.pdf417;
public final class PDF417ResultMetadata {
    public int a;
    public String b;
    public boolean c;
    public int d = -1;
    public String e;
    public String f;
    public String g;
    public long h = -1;
    public long i = -1;
    public int j = -1;
    public int[] k;

    public String getAddressee() {
        return this.f;
    }

    public int getChecksum() {
        return this.j;
    }

    public String getFileId() {
        return this.b;
    }

    public String getFileName() {
        return this.g;
    }

    public long getFileSize() {
        return this.h;
    }

    @Deprecated
    public int[] getOptionalData() {
        return this.k;
    }

    public int getSegmentCount() {
        return this.d;
    }

    public int getSegmentIndex() {
        return this.a;
    }

    public String getSender() {
        return this.e;
    }

    public long getTimestamp() {
        return this.i;
    }

    public boolean isLastSegment() {
        return this.c;
    }

    public void setAddressee(String str) {
        this.f = str;
    }

    public void setChecksum(int i2) {
        this.j = i2;
    }

    public void setFileId(String str) {
        this.b = str;
    }

    public void setFileName(String str) {
        this.g = str;
    }

    public void setFileSize(long j2) {
        this.h = j2;
    }

    public void setLastSegment(boolean z) {
        this.c = z;
    }

    @Deprecated
    public void setOptionalData(int[] iArr) {
        this.k = iArr;
    }

    public void setSegmentCount(int i2) {
        this.d = i2;
    }

    public void setSegmentIndex(int i2) {
        this.a = i2;
    }

    public void setSender(String str) {
        this.e = str;
    }

    public void setTimestamp(long j2) {
        this.i = j2;
    }
}

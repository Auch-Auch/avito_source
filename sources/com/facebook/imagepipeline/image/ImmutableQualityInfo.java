package com.facebook.imagepipeline.image;
public class ImmutableQualityInfo implements QualityInfo {
    public static final QualityInfo FULL_QUALITY = of(Integer.MAX_VALUE, true, true);
    public int a;
    public boolean b;
    public boolean c;

    public ImmutableQualityInfo(int i, boolean z, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = z2;
    }

    public static QualityInfo of(int i, boolean z, boolean z2) {
        return new ImmutableQualityInfo(i, z, z2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableQualityInfo)) {
            return false;
        }
        ImmutableQualityInfo immutableQualityInfo = (ImmutableQualityInfo) obj;
        if (this.a == immutableQualityInfo.a && this.b == immutableQualityInfo.b && this.c == immutableQualityInfo.c) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public int getQuality() {
        return this.a;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.a ^ (this.b ? 4194304 : 0);
        if (this.c) {
            i = 8388608;
        }
        return i2 ^ i;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfFullQuality() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfGoodEnoughQuality() {
        return this.b;
    }
}

package com.avito.android.image_loader;

import a2.g.r.g;
import androidx.annotation.FloatRange;
import com.avito.android.remote.model.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0003\u0010#\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014¨\u0006&"}, d2 = {"Lcom/avito/android/image_loader/AvitoPicture;", "Lcom/avito/android/image_loader/RemotePicture;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/remote/model/Image;", "e", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", g.a, "F", "getMinScale", "()F", "minScale", "Lcom/avito/android/image_loader/ForegroundInfo;", "i", "Lcom/avito/android/image_loader/ForegroundInfo;", "getForegroundInfo", "()Lcom/avito/android/image_loader/ForegroundInfo;", "foregroundInfo", "f", "Z", "getFitWidth", "()Z", "fitWidth", "h", "getMaxScale", "maxScale", "<init>", "(Lcom/avito/android/remote/model/Image;ZFFLcom/avito/android/image_loader/ForegroundInfo;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoPicture extends RemotePicture {
    @Nullable
    public final Image e;
    public final boolean f;
    public final float g;
    public final float h;
    @Nullable
    public final ForegroundInfo i;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvitoPicture(Image image, boolean z, float f2, float f3, ForegroundInfo foregroundInfo, int i2, j jVar) {
        this(image, z, (i2 & 4) != 0 ? 0.0f : f2, (i2 & 8) != 0 ? 1.5f : f3, (i2 & 16) != 0 ? null : foregroundInfo);
    }

    @Override // com.avito.android.image_loader.RemotePicture
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvitoPicture) || !super.equals(obj)) {
            return false;
        }
        AvitoPicture avitoPicture = (AvitoPicture) obj;
        return !(Intrinsics.areEqual(getImage(), avitoPicture.getImage()) ^ true) && getFitWidth() == avitoPicture.getFitWidth() && getMinScale() == avitoPicture.getMinScale() && getMaxScale() == avitoPicture.getMaxScale() && !(Intrinsics.areEqual(this.i, avitoPicture.i) ^ true);
    }

    @Override // com.avito.android.image_loader.RemotePicture
    public boolean getFitWidth() {
        return this.f;
    }

    @Nullable
    public final ForegroundInfo getForegroundInfo() {
        return this.i;
    }

    @Override // com.avito.android.image_loader.RemotePicture
    @Nullable
    public Image getImage() {
        return this.e;
    }

    @Override // com.avito.android.image_loader.RemotePicture
    public float getMaxScale() {
        return this.h;
    }

    @Override // com.avito.android.image_loader.RemotePicture
    public float getMinScale() {
        return this.g;
    }

    @Override // com.avito.android.image_loader.RemotePicture
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        Image image = getImage();
        int i2 = 0;
        int hashCode2 = image != null ? image.hashCode() : 0;
        int floatToIntBits = (Float.floatToIntBits(getMaxScale()) + ((Float.floatToIntBits(getMinScale()) + ((((hashCode + hashCode2) * 31) + a.a(getFitWidth())) * 31)) * 31)) * 31;
        ForegroundInfo foregroundInfo = this.i;
        if (foregroundInfo != null) {
            i2 = foregroundInfo.hashCode();
        }
        return floatToIntBits + i2;
    }

    public AvitoPicture(@Nullable Image image, boolean z, @FloatRange(from = 0.0d) float f2, @FloatRange(from = 0.0d) float f3, @Nullable ForegroundInfo foregroundInfo) {
        super(image, z, f2, f3);
        this.e = image;
        this.f = z;
        this.g = f2;
        this.h = f3;
        this.i = foregroundInfo;
    }
}

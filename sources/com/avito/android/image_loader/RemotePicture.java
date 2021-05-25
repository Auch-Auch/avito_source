package com.avito.android.image_loader;

import android.net.Uri;
import android.view.View;
import androidx.annotation.FloatRange;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ImageFitting;
import com.avito.android.util.Images;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0003\u0010\"\u001a\u00020\u000f¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013¨\u0006%"}, d2 = {"Lcom/avito/android/image_loader/RemotePicture;", "Lcom/avito/android/image_loader/Picture;", "Landroid/view/View;", "view", "Landroid/net/Uri;", "getUri", "(Landroid/view/View;)Landroid/net/Uri;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "c", "F", "getMinScale", "()F", "minScale", AuthSource.BOOKING_ORDER, "Z", "getFitWidth", "()Z", "fitWidth", "Lcom/avito/android/remote/model/Image;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "d", "getMaxScale", "maxScale", "<init>", "(Lcom/avito/android/remote/model/Image;ZFF)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public class RemotePicture implements Picture {
    @Nullable
    public final Image a;
    public final boolean b;
    public final float c;
    public final float d;

    public RemotePicture(@Nullable Image image, boolean z, @FloatRange(from = 0.0d) float f, @FloatRange(from = 0.0d) float f2) {
        this.a = image;
        this.b = z;
        this.c = f;
        this.d = f2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemotePicture)) {
            return false;
        }
        RemotePicture remotePicture = (RemotePicture) obj;
        return !(Intrinsics.areEqual(getImage(), remotePicture.getImage()) ^ true) && getFitWidth() == remotePicture.getFitWidth() && getMinScale() == remotePicture.getMinScale() && getMaxScale() == remotePicture.getMaxScale();
    }

    public boolean getFitWidth() {
        return this.b;
    }

    @Nullable
    public Image getImage() {
        return this.a;
    }

    public float getMaxScale() {
        return this.d;
    }

    public float getMinScale() {
        return this.c;
    }

    @Override // com.avito.android.image_loader.Picture
    @NotNull
    public Uri getUri(@NotNull View view) {
        Uri uri;
        Intrinsics.checkNotNullParameter(view, "view");
        ImageFitting fit = Images.fit(getImage(), view, getMinScale(), getMaxScale(), 2);
        if (getFitWidth()) {
            uri = fit.width();
        } else {
            uri = fit.height();
        }
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri2, "Uri.EMPTY");
        return uri2;
    }

    public int hashCode() {
        Image image = getImage();
        int hashCode = image != null ? image.hashCode() : 0;
        return Float.floatToIntBits(getMaxScale()) + ((Float.floatToIntBits(getMinScale()) + (((hashCode * 31) + a.a(getFitWidth())) * 31)) * 31);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RemotePicture(Image image, boolean z, float f, float f2, int i, j jVar) {
        this(image, z, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? 1.5f : f2);
    }
}

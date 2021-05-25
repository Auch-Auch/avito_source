package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;
public final class zac extends zab {
    private WeakReference<ImageManager.OnImageLoadedListener> zac;

    public zac(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(onImageLoadedListener);
        this.zac = new WeakReference<>(onImageLoadedListener);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zac)) {
            return false;
        }
        zac zac2 = (zac) obj;
        ImageManager.OnImageLoadedListener onImageLoadedListener = this.zac.get();
        ImageManager.OnImageLoadedListener onImageLoadedListener2 = zac2.zac.get();
        return onImageLoadedListener2 != null && onImageLoadedListener != null && Objects.equal(onImageLoadedListener2, onImageLoadedListener) && Objects.equal(zac2.zaa, this.zaa);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa);
    }

    @Override // com.google.android.gms.common.images.zab
    public final void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.OnImageLoadedListener onImageLoadedListener;
        if (!z2 && (onImageLoadedListener = this.zac.get()) != null) {
            onImageLoadedListener.onImageLoaded(this.zaa.zaa, drawable, z3);
        }
    }
}

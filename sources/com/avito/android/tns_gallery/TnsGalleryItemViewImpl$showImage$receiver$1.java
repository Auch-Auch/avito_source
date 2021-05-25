package com.avito.android.tns_gallery;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import com.avito.android.image_loader.BackgroundColorReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/tns_gallery/TnsGalleryItemViewImpl$showImage$receiver$1", "Lcom/avito/android/image_loader/BackgroundColorReceiver;", "Landroid/graphics/drawable/ColorDrawable;", "color", "", "onColorReceived", "(Landroid/graphics/drawable/ColorDrawable;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryItemViewImpl$showImage$receiver$1 implements BackgroundColorReceiver {
    public final /* synthetic */ TnsGalleryItemViewImpl a;

    public static final class a implements Runnable {
        public final /* synthetic */ TnsGalleryItemViewImpl$showImage$receiver$1 a;
        public final /* synthetic */ ColorDrawable b;

        public a(TnsGalleryItemViewImpl$showImage$receiver$1 tnsGalleryItemViewImpl$showImage$receiver$1, ColorDrawable colorDrawable) {
            this.a = tnsGalleryItemViewImpl$showImage$receiver$1;
            this.b = colorDrawable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.s.setBackground(this.b);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public TnsGalleryItemViewImpl$showImage$receiver$1(TnsGalleryItemViewImpl tnsGalleryItemViewImpl) {
        this.a = tnsGalleryItemViewImpl;
    }

    @Override // com.avito.android.image_loader.BackgroundColorReceiver
    public void onColorReceived(@NotNull ColorDrawable colorDrawable) {
        Intrinsics.checkNotNullParameter(colorDrawable, "color");
        new Handler(Looper.getMainLooper()).post(new a(this, colorDrawable));
    }
}

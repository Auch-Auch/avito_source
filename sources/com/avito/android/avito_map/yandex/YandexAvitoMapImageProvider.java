package com.avito.android.avito_map.yandex;

import android.graphics.Bitmap;
import com.avito.android.remote.auth.AuthSource;
import com.yandex.runtime.image.ImageProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/avito_map/yandex/YandexAvitoMapImageProvider;", "Lcom/yandex/runtime/image/ImageProvider;", "", "getId", "()Ljava/lang/String;", "Landroid/graphics/Bitmap;", "getImage", "()Landroid/graphics/Bitmap;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "imageId", AuthSource.SEND_ABUSE, "Landroid/graphics/Bitmap;", "imageBitmap", "<init>", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAvitoMapImageProvider extends ImageProvider {
    public final Bitmap a;
    public final String b;

    public YandexAvitoMapImageProvider(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "imageBitmap");
        Intrinsics.checkNotNullParameter(str, "imageId");
        this.a = bitmap;
        this.b = str;
    }

    @Override // com.yandex.runtime.image.ImageProvider
    @NotNull
    public String getId() {
        return this.b;
    }

    @Override // com.yandex.runtime.image.ImageProvider
    @NotNull
    public Bitmap getImage() {
        return this.a;
    }
}

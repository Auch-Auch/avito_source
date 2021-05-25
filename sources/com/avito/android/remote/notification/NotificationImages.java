package com.avito.android.remote.notification;

import android.graphics.Bitmap;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/notification/NotificationImages;", "", "Landroid/graphics/Bitmap;", AuthSource.SEND_ABUSE, "Landroid/graphics/Bitmap;", "getBig", "()Landroid/graphics/Bitmap;", "big", AuthSource.BOOKING_ORDER, "getSmall", "small", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "notification_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationImages {
    @NotNull
    public final Bitmap a;
    @NotNull
    public final Bitmap b;

    public NotificationImages(@NotNull Bitmap bitmap, @NotNull Bitmap bitmap2) {
        Intrinsics.checkNotNullParameter(bitmap, "big");
        Intrinsics.checkNotNullParameter(bitmap2, "small");
        this.a = bitmap;
        this.b = bitmap2;
    }

    @NotNull
    public final Bitmap getBig() {
        return this.a;
    }

    @NotNull
    public final Bitmap getSmall() {
        return this.b;
    }
}

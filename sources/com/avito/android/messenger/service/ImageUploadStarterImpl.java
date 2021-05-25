package com.avito.android.messenger.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/service/ImageUploadStarterImpl;", "Lcom/avito/android/messenger/service/ImageUploadStarter;", "", "operationId", "", "photoId", "", "uploadAfterNonRestorableError", "", "startImageUpload", "(Ljava/lang/String;Ljava/lang/Long;Z)V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/ServiceIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "<init>", "(Landroid/content/Context;Lcom/avito/android/ServiceIntentFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadStarterImpl implements ImageUploadStarter {
    public final Context a;
    public final ServiceIntentFactory b;

    public ImageUploadStarterImpl(@NotNull Context context, @NotNull ServiceIntentFactory serviceIntentFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(serviceIntentFactory, "serviceIntentFactory");
        this.a = context;
        this.b = serviceIntentFactory;
    }

    @Override // com.avito.android.messenger.service.ImageUploadStarter
    public void startImageUpload(@NotNull String str, @Nullable Long l, boolean z) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intent imageUploadServiceIntent = this.b.imageUploadServiceIntent(str, l != null ? String.valueOf(l.longValue()) : null, z);
        if (Build.VERSION.SDK_INT < 26) {
            this.a.startService(imageUploadServiceIntent);
        } else {
            this.a.startForegroundService(imageUploadServiceIntent);
        }
    }
}

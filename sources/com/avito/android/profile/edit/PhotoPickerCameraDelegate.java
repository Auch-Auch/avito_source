package com.avito.android.profile.edit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.RandomKeyProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/profile/edit/PhotoPickerCameraDelegate;", "Lcom/avito/android/profile/edit/CameraDelegate;", "Landroid/content/Intent;", "data", "Landroid/net/Uri;", "handleTakePhotoResult", "(Landroid/content/Intent;)Landroid/net/Uri;", "Landroid/content/Context;", "context", "createTakePhotoIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/util/RandomKeyProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "<init>", "(Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/RandomKeyProvider;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerCameraDelegate implements CameraDelegate {
    public final ActivityIntentFactory a;
    public final RandomKeyProvider b;

    public PhotoPickerCameraDelegate(@NotNull ActivityIntentFactory activityIntentFactory, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        this.a = activityIntentFactory;
        this.b = randomKeyProvider;
    }

    @Override // com.avito.android.profile.edit.CameraDelegate
    @Nullable
    public Intent createTakePhotoIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.a.createPhotoPickerIntentForProfile(this.b.generateKey());
    }

    @Override // com.avito.android.profile.edit.CameraDelegate
    @Nullable
    public Uri handleTakePhotoResult(@Nullable Intent intent) {
        if (intent != null) {
            return (Uri) intent.getParcelableExtra(PhotoPickerActivityKt.EXTRA_PHOTO_URI);
        }
        return null;
    }
}

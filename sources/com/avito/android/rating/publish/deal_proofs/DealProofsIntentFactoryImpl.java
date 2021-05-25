package com.avito.android.rating.publish.deal_proofs;

import android.content.Context;
import android.content.Intent;
import com.avito.android.DealProofsIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/rating/publish/deal_proofs/DealProofsIntentFactoryImpl;", "Lcom/avito/android/DealProofsIntentFactory;", "", "operationId", "", "maxPhotoCount", "selectedPhotoId", "Landroid/content/Intent;", "createPhotoPickerIntentForRatingsFiles", "(Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", "createPhotoPickerIntentForRatingImages", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class DealProofsIntentFactoryImpl implements DealProofsIntentFactory {
    public final Context a;

    @Inject
    public DealProofsIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.DealProofsIntentFactory
    @NotNull
    public Intent createPhotoPickerIntentForRatingImages(@NotNull String str, int i, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return PhotoPickerActivityKt.createPhotoPickerActivityIntent$default(this.a, str, PhotoUploadKt.UPLOAD_TYPE_RATINGS_IMAGES, 0, i, str2, false, false, null, PublishIntentFactory.PhotoPickerMode.MODE_LEGACY, 456, null);
    }

    @Override // com.avito.android.DealProofsIntentFactory
    @NotNull
    public Intent createPhotoPickerIntentForRatingsFiles(@NotNull String str, int i, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return PhotoPickerActivityKt.createPhotoPickerActivityIntent$default(this.a, str, PhotoUploadKt.UPLOAD_TYPE_RATINGS_FILES, 0, i, str2, false, false, null, PublishIntentFactory.PhotoPickerMode.MODE_LEGACY, 456, null);
    }
}

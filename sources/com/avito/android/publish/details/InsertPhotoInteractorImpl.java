package com.avito.android.publish.details;

import android.net.Uri;
import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish/details/InsertPhotoInteractorImpl;", "Lcom/avito/android/publish/details/PhotoInteractorWrapper;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", VKApiConst.POSITION, "", "uploadId", "", ProductAction.ACTION_ADD, "(Landroid/net/Uri;ILjava/lang/String;)V", "deleteAll", "()V", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "draftId", "<init>", "(Ljava/lang/String;Lcom/avito/android/photo_picker/legacy/PhotoInteractor;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InsertPhotoInteractorImpl implements PhotoInteractorWrapper {
    public final String a;
    public final PhotoInteractor b;

    public InsertPhotoInteractorImpl(@NotNull String str, @NotNull PhotoInteractor photoInteractor) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        this.a = str;
        this.b = photoInteractor;
    }

    @Override // com.avito.android.publish.details.PhotoInteractorWrapper
    public void add(@NotNull Uri uri, int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(str, "uploadId");
        PhotoInteractor.DefaultImpls.add$default(this.b, PhotoUploadKt.UPLOAD_TYPE_PUBLISH, this.a, str, i, uri, null, 32, null);
    }

    @Override // com.avito.android.publish.details.PhotoInteractorWrapper
    public void deleteAll() {
        this.b.deleteAll(PhotoUploadKt.UPLOAD_TYPE_PUBLISH);
    }
}

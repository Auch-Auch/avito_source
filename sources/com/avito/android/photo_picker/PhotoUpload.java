package com.avito.android.photo_picker;

import android.net.Uri;
import android.os.Parcelable;
import com.avito.android.remote.model.ErrorType;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019¨\u0006 "}, d2 = {"Lcom/avito/android/photo_picker/PhotoUpload;", "Landroid/os/Parcelable;", "Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "newBuilder", "()Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "", "getCreated", "()J", "created", "", "getPosition", "()I", VKApiConst.POSITION, "Lcom/avito/android/remote/model/ErrorType;", "getError", "()Lcom/avito/android/remote/model/ErrorType;", "error", "Landroid/net/Uri;", "getContentUri", "()Landroid/net/Uri;", "contentUri", "getSourceUri", "sourceUri", "", "getType", "()Ljava/lang/String;", "type", "getId", "id", "getUploadId", "uploadId", "Builder", "models_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoUpload extends Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "", "Lcom/avito/android/remote/model/ErrorType;", "error", "(Lcom/avito/android/remote/model/ErrorType;)Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "", "uploadId", "(Ljava/lang/String;)Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "contentUri", "(Landroid/net/Uri;)Lcom/avito/android/photo_picker/PhotoUpload$Builder;", "Lcom/avito/android/photo_picker/PhotoUpload;", "build", "()Lcom/avito/android/photo_picker/PhotoUpload;", "models_release"}, k = 1, mv = {1, 4, 2})
    public interface Builder {
        @NotNull
        PhotoUpload build();

        @NotNull
        Builder contentUri(@NotNull Uri uri);

        @NotNull
        Builder error(@NotNull ErrorType errorType);

        @NotNull
        Builder uploadId(@Nullable String str);
    }

    @Nullable
    Uri getContentUri();

    long getCreated();

    @NotNull
    ErrorType getError();

    long getId();

    int getPosition();

    @Nullable
    Uri getSourceUri();

    @NotNull
    String getType();

    @Nullable
    String getUploadId();

    @NotNull
    Builder newBuilder();
}

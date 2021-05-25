package com.avito.android.remote.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u00020\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/Video;", "Landroid/os/Parcelable;", "", "hasPreviewImage", "()Z", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "Lcom/avito/android/remote/model/Image;", "previewImage", "Lcom/avito/android/remote/model/Image;", "getPreviewImage", "()Lcom/avito/android/remote/model/Image;", "Landroid/net/Uri;", "videoUrl", "Landroid/net/Uri;", "getVideoUrl", "()Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;Lcom/avito/android/remote/model/Image;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Video implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Video> CREATOR = Parcels.creator(Video$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("videoImages")
    @Nullable
    private final Image previewImage;
    @SerializedName("videoUrl")
    @NotNull
    private final Uri videoUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Video$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Video;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public Video(@NotNull Uri uri, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(uri, "videoUrl");
        this.videoUrl = uri;
        this.previewImage = image;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, Video.class)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.Video");
        Video video = (Video) obj;
        return !(Intrinsics.areEqual(this.videoUrl, video.videoUrl) ^ true) && !(Intrinsics.areEqual(this.previewImage, video.previewImage) ^ true);
    }

    @Nullable
    public final Image getPreviewImage() {
        return this.previewImage;
    }

    @NotNull
    public final Uri getVideoUrl() {
        return this.videoUrl;
    }

    public final boolean hasPreviewImage() {
        return this.previewImage != null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = this.videoUrl.hashCode();
        int i = hashCode * 31;
        Image image = this.previewImage;
        return i + (image != null ? image.hashCode() : 0) + hashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.videoUrl, i);
        parcel.writeParcelable(this.previewImage, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Video(Uri uri, Image image, int i, j jVar) {
        this(uri, (i & 2) != 0 ? null : image);
    }
}

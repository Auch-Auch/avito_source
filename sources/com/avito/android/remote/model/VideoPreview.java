package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/VideoPreview;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "videoTitle", "Ljava/lang/String;", "getVideoTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/Video;", "getVideo", "()Lcom/avito/android/remote/model/Video;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Video;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class VideoPreview implements Parcelable {
    public static final Parcelable.Creator<VideoPreview> CREATOR = new Creator();
    @SerializedName("video")
    @NotNull
    private final Video video;
    @SerializedName("videoTitle")
    @NotNull
    private final String videoTitle;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VideoPreview> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VideoPreview createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VideoPreview(parcel.readString(), (Video) parcel.readParcelable(VideoPreview.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VideoPreview[] newArray(int i) {
            return new VideoPreview[i];
        }
    }

    public VideoPreview(@NotNull String str, @NotNull Video video2) {
        Intrinsics.checkNotNullParameter(str, "videoTitle");
        Intrinsics.checkNotNullParameter(video2, "video");
        this.videoTitle = str;
        this.video = video2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Video getVideo() {
        return this.video;
    }

    @NotNull
    public final String getVideoTitle() {
        return this.videoTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.videoTitle);
        parcel.writeParcelable(this.video, i);
    }
}

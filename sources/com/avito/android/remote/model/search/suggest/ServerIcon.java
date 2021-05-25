package com.avito.android.remote.model.search.suggest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/ServerIcon;", "Lcom/avito/android/remote/model/search/suggest/IconSource;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/search/suggest/IconSize;", "size", "Lcom/avito/android/remote/model/search/suggest/IconSize;", "getSize", "()Lcom/avito/android/remote/model/search/suggest/IconSize;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "<init>", "(Lcom/avito/android/remote/model/search/suggest/IconSize;Landroid/net/Uri;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ServerIcon extends IconSource {
    public static final Parcelable.Creator<ServerIcon> CREATOR = new Creator();
    @SerializedName("size")
    @Nullable
    private final IconSize size;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final Uri uri;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ServerIcon> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ServerIcon createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ServerIcon(parcel.readInt() != 0 ? IconSize.CREATOR.createFromParcel(parcel) : null, (Uri) parcel.readParcelable(ServerIcon.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ServerIcon[] newArray(int i) {
            return new ServerIcon[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServerIcon(@Nullable IconSize iconSize, @NotNull Uri uri2) {
        super(null);
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.size = iconSize;
        this.uri = uri2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final IconSize getSize() {
        return this.size;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IconSize iconSize = this.size;
        if (iconSize != null) {
            parcel.writeInt(1);
            iconSize.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.uri, i);
    }
}

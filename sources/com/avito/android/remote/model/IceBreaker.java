package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/IceBreaker;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "id", "I", "getId", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "previewText", "Ljava/lang/String;", "getPreviewText", "()Ljava/lang/String;", "messageText", "getMessageText", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class IceBreaker implements Parcelable {
    public static final Parcelable.Creator<IceBreaker> CREATOR = new Creator();
    @SerializedName("id")
    private final int id;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink link;
    @SerializedName("messageText")
    @NotNull
    private final String messageText;
    @SerializedName("previewText")
    @NotNull
    private final String previewText;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<IceBreaker> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IceBreaker createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new IceBreaker(parcel.readInt(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(IceBreaker.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IceBreaker[] newArray(int i) {
            return new IceBreaker[i];
        }
    }

    public IceBreaker(int i, @NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink) {
        a.W0(str, "previewText", str2, "messageText", deepLink, "link");
        this.id = i;
        this.previewText = str;
        this.messageText = str2;
        this.link = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final DeepLink getLink() {
        return this.link;
    }

    @NotNull
    public final String getMessageText() {
        return this.messageText;
    }

    @NotNull
    public final String getPreviewText() {
        return this.previewText;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.previewText);
        parcel.writeString(this.messageText);
        parcel.writeParcelable(this.link, i);
    }
}

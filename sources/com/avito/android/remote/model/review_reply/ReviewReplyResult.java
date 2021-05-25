package com.avito.android.remote.model.review_reply;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010'\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\u001a\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010#\u001a\u00020\u001a\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001e\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001c\u0010#\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001c\u0010%\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001eR\u001c\u0010'\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001e\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,¨\u0006/"}, d2 = {"Lcom/avito/android/remote/model/review_reply/ReviewReplyResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "id", "J", "getId", "()J", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "statusText", "Ljava/lang/String;", "getStatusText", "()Ljava/lang/String;", "status", "getStatus", "rejectMessage", "getRejectMessage", "text", "getText", "answerDate", "getAnswerDate", "title", "getTitle", "", "isShop", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewReplyResult implements Parcelable {
    public static final Parcelable.Creator<ReviewReplyResult> CREATOR = new Creator();
    @SerializedName("answered")
    @NotNull
    private final String answerDate;
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName("answerId")
    private final long id;
    @SerializedName("isShop")
    @Nullable
    private final Boolean isShop;
    @SerializedName("link")
    @Nullable
    private final DeepLink link;
    @SerializedName("rejectMessage")
    @Nullable
    private final String rejectMessage;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName("statusText")
    @Nullable
    private final String statusText;
    @SerializedName("text")
    @NotNull
    private final String text;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ReviewReplyResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReviewReplyResult createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Image image = (Image) parcel.readParcelable(ReviewReplyResult.class.getClassLoader());
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new ReviewReplyResult(readLong, readString, readString2, image, readString3, bool, parcel.readString(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(ReviewReplyResult.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ReviewReplyResult[] newArray(int i) {
            return new ReviewReplyResult[i];
        }
    }

    public ReviewReplyResult(long j, @NotNull String str, @NotNull String str2, @Nullable Image image, @NotNull String str3, @Nullable Boolean bool, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable DeepLink deepLink) {
        a.Z0(str, "title", str2, "answerDate", str3, "text");
        this.id = j;
        this.title = str;
        this.answerDate = str2;
        this.avatar = image;
        this.text = str3;
        this.isShop = bool;
        this.status = str4;
        this.statusText = str5;
        this.rejectMessage = str6;
        this.link = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getAnswerDate() {
        return this.answerDate;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final DeepLink getLink() {
        return this.link;
    }

    @Nullable
    public final String getRejectMessage() {
        return this.rejectMessage;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getStatusText() {
        return this.statusText;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isShop() {
        return this.isShop;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.answerDate);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeString(this.text);
        Boolean bool = this.isShop;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        parcel.writeInt(i2);
        parcel.writeString(this.status);
        parcel.writeString(this.statusText);
        parcel.writeString(this.rejectMessage);
        parcel.writeParcelable(this.link, i);
    }
}

package com.avito.android.remote.model.advert_badge_bar;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B%\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse$Action;", "action", "Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse$Action;", "getAction", "()Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse$Action;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "content", "getContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse$Action;)V", "Action", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeDetailsResponse implements Parcelable {
    public static final Parcelable.Creator<BadgeDetailsResponse> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("content")
    @Nullable
    private final String content;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/advert_badge_bar/BadgeDetailsResponse$Action;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action implements Parcelable {
        public static final Parcelable.Creator<Action> CREATOR = new Creator();
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink uri;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Action> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Action(parcel.readString(), (DeepLink) parcel.readParcelable(Action.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Action[] newArray(int i) {
                return new Action[i];
            }
        }

        public Action(@NotNull String str, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.uri = deepLink;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final DeepLink getUri() {
            return this.uri;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.uri, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BadgeDetailsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeDetailsResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BadgeDetailsResponse(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Action.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeDetailsResponse[] newArray(int i) {
            return new BadgeDetailsResponse[i];
        }
    }

    public BadgeDetailsResponse(@Nullable String str, @Nullable String str2, @Nullable Action action2) {
        this.title = str;
        this.content = str2;
        this.action = action2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        Action action2 = this.action;
        if (action2 != null) {
            parcel.writeInt(1);
            action2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}

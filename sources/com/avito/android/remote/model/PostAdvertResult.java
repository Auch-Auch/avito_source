package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB#\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/PostAdvertResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "nextStepUri", "Lcom/avito/android/deep_linking/links/DeepLink;", "getNextStepUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/PostAdvertResult$PostedAdvert;", "postedAdvert", "Lcom/avito/android/remote/model/PostAdvertResult$PostedAdvert;", "getPostedAdvert", "()Lcom/avito/android/remote/model/PostAdvertResult$PostedAdvert;", "Lcom/avito/android/remote/model/PostAdvertResult$Messages;", "messages", "Lcom/avito/android/remote/model/PostAdvertResult$Messages;", "getMessages", "()Lcom/avito/android/remote/model/PostAdvertResult$Messages;", "<init>", "(Lcom/avito/android/remote/model/PostAdvertResult$PostedAdvert;Lcom/avito/android/remote/model/PostAdvertResult$Messages;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Messages", "PostedAdvert", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PostAdvertResult implements Parcelable {
    public static final Parcelable.Creator<PostAdvertResult> CREATOR = new Creator();
    @SerializedName("messages")
    @Nullable
    private final Messages messages;
    @SerializedName("nextStepUri")
    @Nullable
    private final DeepLink nextStepUri;
    @SerializedName("item")
    @NotNull
    private final PostedAdvert postedAdvert;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PostAdvertResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostAdvertResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PostAdvertResult(PostedAdvert.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Messages.CREATOR.createFromParcel(parcel) : null, (DeepLink) parcel.readParcelable(PostAdvertResult.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PostAdvertResult[] newArray(int i) {
            return new PostAdvertResult[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/PostAdvertResult$Messages;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "fees", "Ljava/lang/String;", "getFees", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Messages implements Parcelable {
        public static final Parcelable.Creator<Messages> CREATOR = new Creator();
        @SerializedName("fees")
        @Nullable
        private final String fees;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Messages> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Messages createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Messages(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Messages[] newArray(int i) {
                return new Messages[i];
            }
        }

        public Messages(@Nullable String str) {
            this.fees = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getFees() {
            return this.fees;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.fees);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/PostAdvertResult$PostedAdvert;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class PostedAdvert implements Parcelable {
        public static final Parcelable.Creator<PostedAdvert> CREATOR = new Creator();
        @SerializedName("id")
        @NotNull
        private final String id;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<PostedAdvert> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PostedAdvert createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new PostedAdvert(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final PostedAdvert[] newArray(int i) {
                return new PostedAdvert[i];
            }
        }

        public PostedAdvert(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
        }
    }

    public PostAdvertResult(@NotNull PostedAdvert postedAdvert2, @Nullable Messages messages2, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(postedAdvert2, "postedAdvert");
        this.postedAdvert = postedAdvert2;
        this.messages = messages2;
        this.nextStepUri = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Messages getMessages() {
        return this.messages;
    }

    @Nullable
    public final DeepLink getNextStepUri() {
        return this.nextStepUri;
    }

    @NotNull
    public final PostedAdvert getPostedAdvert() {
        return this.postedAdvert;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.postedAdvert.writeToParcel(parcel, 0);
        Messages messages2 = this.messages;
        if (messages2 != null) {
            parcel.writeInt(1);
            messages2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.nextStepUri, i);
    }
}

package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse;", "", "<init>", "()V", "Failure", "Ok", "Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Ok;", "Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Failure;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class ExtendedProfilePhoneResponse {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Failure;", "Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/DialogInfo;", "dialogInfo", "Lcom/avito/android/remote/model/DialogInfo;", "getDialogInfo", "()Lcom/avito/android/remote/model/DialogInfo;", "<init>", "(Lcom/avito/android/remote/model/DialogInfo;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends ExtendedProfilePhoneResponse implements Parcelable {
        public static final Parcelable.Creator<Failure> CREATOR = new Creator();
        @SerializedName("dialog")
        @NotNull
        private final DialogInfo dialogInfo;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Failure> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Failure createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Failure((DialogInfo) parcel.readParcelable(Failure.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Failure[] newArray(int i) {
                return new Failure[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull DialogInfo dialogInfo2) {
            super(null);
            Intrinsics.checkNotNullParameter(dialogInfo2, "dialogInfo");
            this.dialogInfo = dialogInfo2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final DialogInfo getDialogInfo() {
            return this.dialogInfo;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.dialogInfo, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Ok;", "Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Ok$Action;", "action", "Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Ok$Action;", "getAction", "()Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Ok$Action;", "<init>", "(Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Ok$Action;)V", "Action", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends ExtendedProfilePhoneResponse implements Parcelable {
        public static final Parcelable.Creator<Ok> CREATOR = new Creator();
        @SerializedName("action")
        @NotNull
        private final Action action;

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/ExtendedProfilePhoneResponse$Ok$Action;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Action implements Parcelable {
            public static final Parcelable.Creator<Action> CREATOR = new Creator();
            @SerializedName("title")
            @NotNull
            private final String title;
            @SerializedName(ShareConstants.MEDIA_URI)
            @NotNull
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

            public Action(@NotNull String str, @NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
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

            @NotNull
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
        public static class Creator implements Parcelable.Creator<Ok> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Ok createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Ok(Action.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Ok[] newArray(int i) {
                return new Ok[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ok(@NotNull Action action2) {
            super(null);
            Intrinsics.checkNotNullParameter(action2, "action");
            this.action = action2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Action getAction() {
            return this.action;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.action.writeToParcel(parcel, 0);
        }
    }

    private ExtendedProfilePhoneResponse() {
    }

    public /* synthetic */ ExtendedProfilePhoneResponse(j jVar) {
        this();
    }
}

package com.avito.android.remote.model.feature_teaser;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "title", "getTitle", "actionText", "getActionText", "Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito$ActionInfo;", "actionInfo", "Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito$ActionInfo;", "getActionInfo", "()Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito$ActionInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito$ActionInfo;)V", "ActionInfo", "api_release"}, k = 1, mv = {1, 4, 2})
public final class CheckedByAvito implements Parcelable {
    public static final Parcelable.Creator<CheckedByAvito> CREATOR = new Creator();
    @SerializedName("actionInfo")
    @NotNull
    private final ActionInfo actionInfo;
    @SerializedName("actionText")
    @NotNull
    private final String actionText;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CheckedByAvito$ActionInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "checks", "Ljava/util/List;", "getChecks", "()Ljava/util/List;", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "applyBtnText", "getApplyBtnText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActionInfo implements Parcelable {
        public static final Parcelable.Creator<ActionInfo> CREATOR = new Creator();
        @SerializedName("applyBtnText")
        @NotNull
        private final String applyBtnText;
        @SerializedName("checks")
        @NotNull
        private final List<String> checks;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @NotNull
        private final String subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ActionInfo> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ActionInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ActionInfo(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ActionInfo[] newArray(int i) {
                return new ActionInfo[i];
            }
        }

        public ActionInfo(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
            Intrinsics.checkNotNullParameter(list, "checks");
            Intrinsics.checkNotNullParameter(str3, "applyBtnText");
            this.title = str;
            this.subtitle = str2;
            this.checks = list;
            this.applyBtnText = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getApplyBtnText() {
            return this.applyBtnText;
        }

        @NotNull
        public final List<String> getChecks() {
            return this.checks;
        }

        @NotNull
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            parcel.writeStringList(this.checks);
            parcel.writeString(this.applyBtnText);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CheckedByAvito> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckedByAvito createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CheckedByAvito(parcel.readString(), parcel.readString(), parcel.readString(), ActionInfo.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckedByAvito[] newArray(int i) {
            return new CheckedByAvito[i];
        }
    }

    public CheckedByAvito(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull ActionInfo actionInfo2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(str3, "actionText");
        Intrinsics.checkNotNullParameter(actionInfo2, "actionInfo");
        this.title = str;
        this.subtitle = str2;
        this.actionText = str3;
        this.actionInfo = actionInfo2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    @NotNull
    public final String getActionText() {
        return this.actionText;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeString(this.actionText);
        this.actionInfo.writeToParcel(parcel, 0);
    }
}

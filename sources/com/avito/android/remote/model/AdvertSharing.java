package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/AdvertSharing;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "liveJournal", "Ljava/lang/String;", "getLiveJournal", "()Ljava/lang/String;", "url", "getUrl", "odnoklassniki", "getOdnoklassniki", "twitter", "getTwitter", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "getNative", "myMail", "getMyMail", "facebook", "getFacebook", "vkontakte", "getVkontakte", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSharing implements Parcelable {
    public static final Parcelable.Creator<AdvertSharing> CREATOR = new Creator();
    @SerializedName("fb")
    @Nullable
    private final String facebook;
    @SerializedName("lj")
    @Nullable
    private final String liveJournal;
    @SerializedName("mm")
    @Nullable
    private final String myMail;
    @SerializedName(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)
    @Nullable

    /* renamed from: native  reason: not valid java name */
    private final String f7native;
    @SerializedName("ok")
    @Nullable
    private final String odnoklassniki;
    @SerializedName("tw")
    @Nullable
    private final String twitter;
    @SerializedName("url")
    @NotNull
    private final String url;
    @SerializedName("vk")
    @Nullable
    private final String vkontakte;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertSharing> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertSharing createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertSharing(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertSharing[] newArray(int i) {
            return new AdvertSharing[i];
        }
    }

    public AdvertSharing(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkNotNullParameter(str8, "url");
        this.facebook = str;
        this.liveJournal = str2;
        this.myMail = str3;
        this.f7native = str4;
        this.odnoklassniki = str5;
        this.twitter = str6;
        this.vkontakte = str7;
        this.url = str8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getFacebook() {
        return this.facebook;
    }

    @Nullable
    public final String getLiveJournal() {
        return this.liveJournal;
    }

    @Nullable
    public final String getMyMail() {
        return this.myMail;
    }

    @Nullable
    public final String getNative() {
        return this.f7native;
    }

    @Nullable
    public final String getOdnoklassniki() {
        return this.odnoklassniki;
    }

    @Nullable
    public final String getTwitter() {
        return this.twitter;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getVkontakte() {
        return this.vkontakte;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.facebook);
        parcel.writeString(this.liveJournal);
        parcel.writeString(this.myMail);
        parcel.writeString(this.f7native);
        parcel.writeString(this.odnoklassniki);
        parcel.writeString(this.twitter);
        parcel.writeString(this.vkontakte);
        parcel.writeString(this.url);
    }
}

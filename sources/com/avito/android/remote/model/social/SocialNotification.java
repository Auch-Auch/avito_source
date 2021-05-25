package com.avito.android.remote.model.social;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.preferences.GeoContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/social/SocialNotification;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "notification", "Lcom/avito/android/remote/model/text/AttributedText;", "getNotification", "()Lcom/avito/android/remote/model/text/AttributedText;", GeoContract.PROVIDER, "getProvider", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class SocialNotification implements Parcelable {
    public static final Parcelable.Creator<SocialNotification> CREATOR = new Creator();
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("notification")
    @NotNull
    private final AttributedText notification;
    @SerializedName(GeoContract.PROVIDER)
    @Nullable
    private final String provider;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SocialNotification> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SocialNotification createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SocialNotification(parcel.readString(), (AttributedText) parcel.readParcelable(SocialNotification.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SocialNotification[] newArray(int i) {
            return new SocialNotification[i];
        }
    }

    public SocialNotification(@NotNull String str, @NotNull AttributedText attributedText, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(attributedText, "notification");
        this.id = str;
        this.notification = attributedText;
        this.provider = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final AttributedText getNotification() {
        return this.notification;
    }

    @Nullable
    public final String getProvider() {
        return this.provider;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeParcelable(this.notification, i);
        parcel.writeString(this.provider);
    }
}

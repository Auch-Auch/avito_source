package com.avito.android.remote.model.user_profile.items;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B#\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/VerificationWay;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "Lcom/avito/android/remote/model/user_profile/items/VerificationWay$VerificationButtonConfig;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/remote/model/user_profile/items/VerificationWay$VerificationButtonConfig;", "getButton", "()Lcom/avito/android/remote/model/user_profile/items/VerificationWay$VerificationButtonConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/items/VerificationWay$VerificationButtonConfig;)V", "VerificationButtonConfig", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationWay implements Parcelable {
    public static final Parcelable.Creator<VerificationWay> CREATOR = new Creator();
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @NotNull
    private final VerificationButtonConfig button;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerificationWay> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationWay createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new VerificationWay(parcel.readString(), parcel.readString(), VerificationButtonConfig.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationWay[] newArray(int i) {
            return new VerificationWay[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/VerificationWay$VerificationButtonConfig;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "enabled", "Ljava/lang/Boolean;", "getEnabled", "()Ljava/lang/Boolean;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "getStyle", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/deep_linking/links/DeepLink;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class VerificationButtonConfig implements Parcelable {
        public static final Parcelable.Creator<VerificationButtonConfig> CREATOR = new Creator();
        @SerializedName("deepLink")
        @NotNull
        private final DeepLink deepLink;
        @SerializedName("enabled")
        @Nullable
        private final Boolean enabled;
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        @Nullable
        private final String style;
        @SerializedName("text")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<VerificationButtonConfig> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final VerificationButtonConfig createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new VerificationButtonConfig(readString, readString2, bool, (DeepLink) parcel.readParcelable(VerificationButtonConfig.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final VerificationButtonConfig[] newArray(int i) {
                return new VerificationButtonConfig[i];
            }
        }

        public VerificationButtonConfig(@NotNull String str, @Nullable String str2, @Nullable Boolean bool, @NotNull DeepLink deepLink2) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            this.text = str;
            this.style = str2;
            this.enabled = bool;
            this.deepLink = deepLink2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Nullable
        public final Boolean getEnabled() {
            return this.enabled;
        }

        @Nullable
        public final String getStyle() {
            return this.style;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.text);
            parcel.writeString(this.style);
            Boolean bool = this.enabled;
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
            parcel.writeParcelable(this.deepLink, i);
        }
    }

    public VerificationWay(@Nullable String str, @Nullable String str2, @NotNull VerificationButtonConfig verificationButtonConfig) {
        Intrinsics.checkNotNullParameter(verificationButtonConfig, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        this.title = str;
        this.description = str2;
        this.button = verificationButtonConfig;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final VerificationButtonConfig getButton() {
        return this.button;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        this.button.writeToParcel(parcel, 0);
    }
}

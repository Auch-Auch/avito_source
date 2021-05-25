package com.avito.android.remote.model.delivery;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$Body;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$Body;", "getBody", "()Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$Body;", "Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$EnableField;", "enableField", "Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$EnableField;", "getEnableField", "()Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$EnableField;", "<init>", "(Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$Body;Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$EnableField;)V", "Body", "EnableField", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryProfileSettingsResponse implements Parcelable {
    public static final Parcelable.Creator<DeliveryProfileSettingsResponse> CREATOR = new Creator();
    @SerializedName(SDKConstants.PARAM_A2U_BODY)
    @NotNull
    private final Body body;
    @SerializedName("enableField")
    @NotNull
    private final EnableField enableField;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$Body;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "Lcom/avito/android/remote/model/text/AttributedText;", "getAttributedText", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/Image;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Body implements Parcelable {
        public static final Parcelable.Creator<Body> CREATOR = new Creator();
        @SerializedName("attributedText")
        @NotNull
        private final AttributedText attributedText;
        @SerializedName("image")
        @NotNull
        private final Image image;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Body> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Body createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Body((AttributedText) parcel.readParcelable(Body.class.getClassLoader()), (Image) parcel.readParcelable(Body.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Body[] newArray(int i) {
                return new Body[i];
            }
        }

        public Body(@NotNull AttributedText attributedText2, @NotNull Image image2) {
            Intrinsics.checkNotNullParameter(attributedText2, "attributedText");
            Intrinsics.checkNotNullParameter(image2, "image");
            this.attributedText = attributedText2;
            this.image = image2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final AttributedText getAttributedText() {
            return this.attributedText;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.attributedText, i);
            parcel.writeParcelable(this.image, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryProfileSettingsResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryProfileSettingsResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliveryProfileSettingsResponse(Body.CREATOR.createFromParcel(parcel), EnableField.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryProfileSettingsResponse[] newArray(int i) {
            return new DeliveryProfileSettingsResponse[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryProfileSettingsResponse$EnableField;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "value", "Z", "getValue", "()Z", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/text/AttributedText;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class EnableField implements Parcelable {
        public static final Parcelable.Creator<EnableField> CREATOR = new Creator();
        @SerializedName("disclaimer")
        @NotNull
        private final AttributedText disclaimer;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("value")
        private final boolean value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<EnableField> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EnableField createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new EnableField(parcel.readString(), parcel.readInt() != 0, (AttributedText) parcel.readParcelable(EnableField.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final EnableField[] newArray(int i) {
                return new EnableField[i];
            }
        }

        public EnableField(@NotNull String str, boolean z, @NotNull AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
            this.title = str;
            this.value = z;
            this.disclaimer = attributedText;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final AttributedText getDisclaimer() {
            return this.disclaimer;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final boolean getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.value ? 1 : 0);
            parcel.writeParcelable(this.disclaimer, i);
        }
    }

    public DeliveryProfileSettingsResponse(@NotNull Body body2, @NotNull EnableField enableField2) {
        Intrinsics.checkNotNullParameter(body2, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(enableField2, "enableField");
        this.body = body2;
        this.enableField = enableField2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Body getBody() {
        return this.body;
    }

    @NotNull
    public final EnableField getEnableField() {
        return this.enableField;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.body.writeToParcel(parcel, 0);
        this.enableField.writeToParcel(parcel, 0);
    }
}

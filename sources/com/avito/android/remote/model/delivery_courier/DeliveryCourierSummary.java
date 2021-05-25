package com.avito.android.remote.model.delivery_courier;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.Constraint;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u00069:;<=>Bk\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010(\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001f\u001a\u00020\u0010\u0012\u0006\u0010/\u001a\u00020\u0010\u0012\u0006\u0010&\u001a\u00020\u0010\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020201\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014R\u001c\u0010(\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014R\u001e\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u0010\u0014R\"\u00103\u001a\b\u0012\u0004\u0012\u000202018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u0006?"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$AdvertImage;", "advertImage", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$AdvertImage;", "getAdvertImage", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$AdvertImage;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;", AbuseSendingResult.COMMENT, "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;", "getComment", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$HowWork;", "howWork", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$HowWork;", "getHowWork", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$HowWork;", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierServices;", "courierServices", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierServices;", "getCourierServices", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierServices;", "name", "getName", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "email", "getEmail", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getAddress", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "lastAddress", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "getLastAddress", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "phone", "getPhone", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Cost;", "cost", "Ljava/util/List;", "getCost", "()Ljava/util/List;", "<init>", "(Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$AdvertImage;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierServices;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$HowWork;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "AdvertImage", "Cost", "CourierService", "CourierServices", "Field", "HowWork", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummary implements Parcelable {
    public static final Parcelable.Creator<DeliveryCourierSummary> CREATOR = new Creator();
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @NotNull
    private final Field address;
    @SerializedName("advertImage")
    @NotNull
    private final AdvertImage advertImage;
    @SerializedName(AbuseSendingResult.COMMENT)
    @NotNull
    private final Field comment;
    @SerializedName("cost")
    @NotNull
    private final List<Cost> cost;
    @SerializedName("courierServices")
    @Nullable
    private final CourierServices courierServices;
    @SerializedName("disclaimer")
    @Nullable
    private final AttributedText disclaimer;
    @SerializedName("email")
    @NotNull
    private final Field email;
    @SerializedName("howWork")
    @NotNull
    private final HowWork howWork;
    @SerializedName("lastAddress")
    @Nullable
    private final AddressParameter.Value lastAddress;
    @SerializedName("name")
    @NotNull
    private final Field name;
    @SerializedName("phone")
    @NotNull
    private final Field phone;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$AdvertImage;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertImage implements Parcelable {
        public static final Parcelable.Creator<AdvertImage> CREATOR = new Creator();
        @SerializedName("image")
        @NotNull
        private final Image image;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AdvertImage> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdvertImage createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AdvertImage((Image) parcel.readParcelable(AdvertImage.class.getClassLoader()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AdvertImage[] newArray(int i) {
                return new AdvertImage[i];
            }
        }

        public AdvertImage(@NotNull Image image2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(image2, "image");
            Intrinsics.checkNotNullParameter(str, "title");
            this.image = image2;
            this.title = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.image, i);
            parcel.writeString(this.title);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Cost;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "highlightValue", "Ljava/lang/Boolean;", "getHighlightValue", "()Ljava/lang/Boolean;", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Cost implements Parcelable {
        public static final Parcelable.Creator<Cost> CREATOR = new Creator();
        @SerializedName("highlightValue")
        @Nullable
        private final Boolean highlightValue;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("value")
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Cost> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Cost createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Cost(readString, readString2, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Cost[] newArray(int i) {
                return new Cost[i];
            }
        }

        public Cost(@NotNull String str, @NotNull String str2, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.title = str;
            this.value = str2;
            this.highlightValue = bool;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Boolean getHighlightValue() {
            return this.highlightValue;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.value);
            Boolean bool = this.highlightValue;
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
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJJ\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0018J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\"\u0010#R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b\u0010\u0010\bR\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierService;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "component4", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Cost;", "component5", "()Ljava/util/List;", "title", MessengerShareContentUtility.SUBTITLE, "isChecked", "providerKey", "cost", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierService;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getCost", "Ljava/lang/String;", "getSubtitle", "Z", "getProviderKey", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class CourierService implements Parcelable {
        public static final Parcelable.Creator<CourierService> CREATOR = new Creator();
        @SerializedName("cost")
        @NotNull
        private final List<Cost> cost;
        @SerializedName("isChecked")
        private final boolean isChecked;
        @SerializedName("providerKey")
        @NotNull
        private final String providerKey;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<CourierService> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CourierService createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean z = parcel.readInt() != 0;
                String readString3 = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Cost.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new CourierService(readString, readString2, z, readString3, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CourierService[] newArray(int i) {
                return new CourierService[i];
            }
        }

        public CourierService(@NotNull String str, @Nullable String str2, boolean z, @NotNull String str3, @NotNull List<Cost> list) {
            a.c1(str, "title", str3, "providerKey", list, "cost");
            this.title = str;
            this.subtitle = str2;
            this.isChecked = z;
            this.providerKey = str3;
            this.cost = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary$CourierService */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CourierService copy$default(CourierService courierService, String str, String str2, boolean z, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = courierService.title;
            }
            if ((i & 2) != 0) {
                str2 = courierService.subtitle;
            }
            if ((i & 4) != 0) {
                z = courierService.isChecked;
            }
            if ((i & 8) != 0) {
                str3 = courierService.providerKey;
            }
            if ((i & 16) != 0) {
                list = courierService.cost;
            }
            return courierService.copy(str, str2, z, str3, list);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final String component2() {
            return this.subtitle;
        }

        public final boolean component3() {
            return this.isChecked;
        }

        @NotNull
        public final String component4() {
            return this.providerKey;
        }

        @NotNull
        public final List<Cost> component5() {
            return this.cost;
        }

        @NotNull
        public final CourierService copy(@NotNull String str, @Nullable String str2, boolean z, @NotNull String str3, @NotNull List<Cost> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str3, "providerKey");
            Intrinsics.checkNotNullParameter(list, "cost");
            return new CourierService(str, str2, z, str3, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CourierService)) {
                return false;
            }
            CourierService courierService = (CourierService) obj;
            return Intrinsics.areEqual(this.title, courierService.title) && Intrinsics.areEqual(this.subtitle, courierService.subtitle) && this.isChecked == courierService.isChecked && Intrinsics.areEqual(this.providerKey, courierService.providerKey) && Intrinsics.areEqual(this.cost, courierService.cost);
        }

        @NotNull
        public final List<Cost> getCost() {
            return this.cost;
        }

        @NotNull
        public final String getProviderKey() {
            return this.providerKey;
        }

        @Nullable
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.subtitle;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.isChecked;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode2 + i2) * 31;
            String str3 = this.providerKey;
            int hashCode3 = (i5 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<Cost> list = this.cost;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode3 + i;
        }

        public final boolean isChecked() {
            return this.isChecked;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("CourierService(title=");
            L.append(this.title);
            L.append(", subtitle=");
            L.append(this.subtitle);
            L.append(", isChecked=");
            L.append(this.isChecked);
            L.append(", providerKey=");
            L.append(this.providerKey);
            L.append(", cost=");
            return a.w(L, this.cost, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            parcel.writeInt(this.isChecked ? 1 : 0);
            parcel.writeString(this.providerKey);
            Iterator n0 = a.n0(this.cost, parcel);
            while (n0.hasNext()) {
                ((Cost) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJD\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\u0004R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b%\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierServices;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierService;", "component4", "()Ljava/util/List;", "groupTitle", "groupSubtitle", "groupHint", VKApiConst.SERVICES, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$CourierServices;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getGroupSubtitle", "Ljava/util/List;", "getServices", "getGroupTitle", "getGroupHint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class CourierServices implements Parcelable {
        public static final Parcelable.Creator<CourierServices> CREATOR = new Creator();
        @SerializedName("hint")
        @Nullable
        private final String groupHint;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String groupSubtitle;
        @SerializedName("title")
        @Nullable
        private final String groupTitle;
        @SerializedName(VKApiConst.SERVICES)
        @NotNull
        private final List<CourierService> services;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<CourierServices> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CourierServices createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(CourierService.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new CourierServices(readString, readString2, readString3, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CourierServices[] newArray(int i) {
                return new CourierServices[i];
            }
        }

        public CourierServices(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull List<CourierService> list) {
            Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
            this.groupTitle = str;
            this.groupSubtitle = str2;
            this.groupHint = str3;
            this.services = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary$CourierServices */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CourierServices copy$default(CourierServices courierServices, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = courierServices.groupTitle;
            }
            if ((i & 2) != 0) {
                str2 = courierServices.groupSubtitle;
            }
            if ((i & 4) != 0) {
                str3 = courierServices.groupHint;
            }
            if ((i & 8) != 0) {
                list = courierServices.services;
            }
            return courierServices.copy(str, str2, str3, list);
        }

        @Nullable
        public final String component1() {
            return this.groupTitle;
        }

        @Nullable
        public final String component2() {
            return this.groupSubtitle;
        }

        @Nullable
        public final String component3() {
            return this.groupHint;
        }

        @NotNull
        public final List<CourierService> component4() {
            return this.services;
        }

        @NotNull
        public final CourierServices copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull List<CourierService> list) {
            Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
            return new CourierServices(str, str2, str3, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CourierServices)) {
                return false;
            }
            CourierServices courierServices = (CourierServices) obj;
            return Intrinsics.areEqual(this.groupTitle, courierServices.groupTitle) && Intrinsics.areEqual(this.groupSubtitle, courierServices.groupSubtitle) && Intrinsics.areEqual(this.groupHint, courierServices.groupHint) && Intrinsics.areEqual(this.services, courierServices.services);
        }

        @Nullable
        public final String getGroupHint() {
            return this.groupHint;
        }

        @Nullable
        public final String getGroupSubtitle() {
            return this.groupSubtitle;
        }

        @Nullable
        public final String getGroupTitle() {
            return this.groupTitle;
        }

        @NotNull
        public final List<CourierService> getServices() {
            return this.services;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.groupTitle;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.groupSubtitle;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.groupHint;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            List<CourierService> list = this.services;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("CourierServices(groupTitle=");
            L.append(this.groupTitle);
            L.append(", groupSubtitle=");
            L.append(this.groupSubtitle);
            L.append(", groupHint=");
            L.append(this.groupHint);
            L.append(", services=");
            return a.w(L, this.services, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.groupTitle);
            parcel.writeString(this.groupSubtitle);
            parcel.writeString(this.groupHint);
            Iterator n0 = a.n0(this.services, parcel);
            while (n0.hasNext()) {
                ((CourierService) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryCourierSummary> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierSummary createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            AdvertImage createFromParcel = AdvertImage.CREATOR.createFromParcel(parcel);
            CourierServices createFromParcel2 = parcel.readInt() != 0 ? CourierServices.CREATOR.createFromParcel(parcel) : null;
            Parcelable.Creator<Field> creator = Field.CREATOR;
            Field createFromParcel3 = creator.createFromParcel(parcel);
            Field createFromParcel4 = creator.createFromParcel(parcel);
            HowWork createFromParcel5 = HowWork.CREATOR.createFromParcel(parcel);
            Field createFromParcel6 = creator.createFromParcel(parcel);
            Field createFromParcel7 = creator.createFromParcel(parcel);
            Field createFromParcel8 = creator.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Cost.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new DeliveryCourierSummary(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, arrayList, (AttributedText) parcel.readParcelable(DeliveryCourierSummary.class.getClassLoader()), (AddressParameter.Value) parcel.readParcelable(DeliveryCourierSummary.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierSummary[] newArray(int i) {
            return new DeliveryCourierSummary[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Field;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "constraints", "Ljava/util/List;", "getConstraints", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "", InternalConstsKt.PLACEHOLDER, "Ljava/lang/String;", "getPlaceholder", "()Ljava/lang/String;", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Field implements Parcelable {
        public static final Parcelable.Creator<Field> CREATOR = new Creator();
        @SerializedName("constraints")
        @Nullable
        private final List<Constraint> constraints;
        @SerializedName("motivation")
        @Nullable
        private final AttributedText motivation;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("value")
        @Nullable
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Field> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Field createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                AttributedText attributedText = (AttributedText) parcel.readParcelable(Field.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add((Constraint) parcel.readParcelable(Field.class.getClassLoader()));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                return new Field(readString, readString2, attributedText, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Field[] newArray(int i) {
                return new Field[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
        /* JADX WARN: Multi-variable type inference failed */
        public Field(@Nullable String str, @Nullable String str2, @Nullable AttributedText attributedText, @Nullable List<? extends Constraint> list) {
            this.placeholder = str;
            this.value = str2;
            this.motivation = attributedText;
            this.constraints = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final List<Constraint> getConstraints() {
            return this.constraints;
        }

        @Nullable
        public final AttributedText getMotivation() {
            return this.motivation;
        }

        @Nullable
        public final String getPlaceholder() {
            return this.placeholder;
        }

        @Nullable
        public final String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.placeholder);
            parcel.writeString(this.value);
            parcel.writeParcelable(this.motivation, i);
            List<Constraint> list = this.constraints;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    parcel.writeParcelable((Constraint) l0.next(), i);
                }
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$HowWork;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "description", "Ljava/util/List;", "getDescription", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class HowWork implements Parcelable {
        public static final Parcelable.Creator<HowWork> CREATOR = new Creator();
        @SerializedName("description")
        @NotNull
        private final List<String> description;
        @SerializedName("text")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<HowWork> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final HowWork createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new HowWork(parcel.readString(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final HowWork[] newArray(int i) {
                return new HowWork[i];
            }
        }

        public HowWork(@NotNull String str, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(list, "description");
            this.text = str;
            this.description = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<String> getDescription() {
            return this.description;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.text);
            parcel.writeStringList(this.description);
        }
    }

    public DeliveryCourierSummary(@NotNull AdvertImage advertImage2, @Nullable CourierServices courierServices2, @NotNull Field field, @NotNull Field field2, @NotNull HowWork howWork2, @NotNull Field field3, @NotNull Field field4, @NotNull Field field5, @NotNull List<Cost> list, @Nullable AttributedText attributedText, @Nullable AddressParameter.Value value) {
        Intrinsics.checkNotNullParameter(advertImage2, "advertImage");
        Intrinsics.checkNotNullParameter(field, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(field2, AbuseSendingResult.COMMENT);
        Intrinsics.checkNotNullParameter(howWork2, "howWork");
        Intrinsics.checkNotNullParameter(field3, "name");
        Intrinsics.checkNotNullParameter(field4, "phone");
        Intrinsics.checkNotNullParameter(field5, "email");
        Intrinsics.checkNotNullParameter(list, "cost");
        this.advertImage = advertImage2;
        this.courierServices = courierServices2;
        this.address = field;
        this.comment = field2;
        this.howWork = howWork2;
        this.name = field3;
        this.phone = field4;
        this.email = field5;
        this.cost = list;
        this.disclaimer = attributedText;
        this.lastAddress = value;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Field getAddress() {
        return this.address;
    }

    @NotNull
    public final AdvertImage getAdvertImage() {
        return this.advertImage;
    }

    @NotNull
    public final Field getComment() {
        return this.comment;
    }

    @NotNull
    public final List<Cost> getCost() {
        return this.cost;
    }

    @Nullable
    public final CourierServices getCourierServices() {
        return this.courierServices;
    }

    @Nullable
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @NotNull
    public final Field getEmail() {
        return this.email;
    }

    @NotNull
    public final HowWork getHowWork() {
        return this.howWork;
    }

    @Nullable
    public final AddressParameter.Value getLastAddress() {
        return this.lastAddress;
    }

    @NotNull
    public final Field getName() {
        return this.name;
    }

    @NotNull
    public final Field getPhone() {
        return this.phone;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.advertImage.writeToParcel(parcel, 0);
        CourierServices courierServices2 = this.courierServices;
        if (courierServices2 != null) {
            parcel.writeInt(1);
            courierServices2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        this.address.writeToParcel(parcel, 0);
        this.comment.writeToParcel(parcel, 0);
        this.howWork.writeToParcel(parcel, 0);
        this.name.writeToParcel(parcel, 0);
        this.phone.writeToParcel(parcel, 0);
        this.email.writeToParcel(parcel, 0);
        Iterator n0 = a.n0(this.cost, parcel);
        while (n0.hasNext()) {
            ((Cost) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.disclaimer, i);
        parcel.writeParcelable(this.lastAddress, i);
    }
}

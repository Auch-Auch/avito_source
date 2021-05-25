package com.avito.android.remote.model.payment;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.preferences.SessionContract;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0013\u0014\u0015B!\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u0001\u0003\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/payment/PaymentMethod;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", SessionContract.SIGNATURE, "getSignature", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "ButtonMethod", "GooglePay", "SelectableMethod", "Lcom/avito/android/remote/model/payment/PaymentMethod$ButtonMethod;", "Lcom/avito/android/remote/model/payment/PaymentMethod$SelectableMethod;", "Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentMethod implements Parcelable {
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink deepLink;
    @SerializedName(SessionContract.SIGNATURE)
    @NotNull
    private final String signature;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/payment/PaymentMethod$ButtonMethod;", "Lcom/avito/android/remote/model/payment/PaymentMethod;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", SessionContract.SIGNATURE, "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class ButtonMethod extends PaymentMethod {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<ButtonMethod> CREATOR = Parcels.creator(PaymentMethod$ButtonMethod$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/payment/PaymentMethod$ButtonMethod$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/PaymentMethod$ButtonMethod;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ButtonMethod(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink) {
            super(str, str2, deepLink, null);
            a.W0(str, "title", str2, SessionContract.SIGNATURE, deepLink, "deepLink");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(getTitle());
            parcel.writeString(getSignature());
            parcel.writeParcelable(getDeepLink(), i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay;", "Lcom/avito/android/remote/model/payment/PaymentMethod;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", SessionContract.SIGNATURE, "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class GooglePay extends PaymentMethod {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<GooglePay> CREATOR = Parcels.creator(PaymentMethod$GooglePay$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/PaymentMethod$GooglePay;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GooglePay(@NotNull String str, @NotNull DeepLink deepLink) {
            super("Google Pay", str, deepLink, null);
            Intrinsics.checkNotNullParameter(str, SessionContract.SIGNATURE);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(getSignature());
            parcel.writeParcelable(getDeepLink(), i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B=\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/payment/PaymentMethod$SelectableMethod;", "Lcom/avito/android/remote/model/payment/PaymentMethod;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "information", "getInformation", "description", "getDescription", "title", SessionContract.SIGNATURE, "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class SelectableMethod extends PaymentMethod {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SelectableMethod> CREATOR = Parcels.creator(PaymentMethod$SelectableMethod$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("information")
        @Nullable
        private final String information;
        @SerializedName("label")
        @Nullable
        private final String label;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/payment/PaymentMethod$SelectableMethod$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/payment/PaymentMethod$SelectableMethod;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectableMethod(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @NotNull DeepLink deepLink) {
            super(str4, str5, deepLink, null);
            a.W0(str4, "title", str5, SessionContract.SIGNATURE, deepLink, "deepLink");
            this.label = str;
            this.description = str2;
            this.information = str3;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getInformation() {
            return this.information;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(getTitle());
            parcel.writeString(getSignature());
            parcel.writeParcelable(getDeepLink(), i);
            ParcelsKt.writeNullableValue(parcel, this.label);
            ParcelsKt.writeNullableValue(parcel, this.description);
            ParcelsKt.writeNullableValue(parcel, this.information);
        }
    }

    private PaymentMethod(String str, String str2, DeepLink deepLink2) {
        this.title = str;
        this.signature = str2;
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

    @NotNull
    public final String getSignature() {
        return this.signature;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public /* synthetic */ PaymentMethod(String str, String str2, DeepLink deepLink2, j jVar) {
        this(str, str2, deepLink2);
    }
}

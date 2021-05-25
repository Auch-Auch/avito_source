package com.avito.android.basket.checkout.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.DialogInfo;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutNextStepData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/paid_services/routing/DialogInfo;", "c", "Lcom/avito/android/paid_services/routing/DialogInfo;", "getActiveDialog", "()Lcom/avito/android/paid_services/routing/DialogInfo;", "activeDialog", AuthSource.BOOKING_ORDER, "getSuccessDialog", "successDialog", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/paid_services/routing/DialogInfo;Lcom/avito/android/paid_services/routing/DialogInfo;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutNextStepData implements Parcelable {
    public static final Parcelable.Creator<CheckoutNextStepData> CREATOR = new Creator();
    @NotNull
    public final DeepLink a;
    @Nullable
    public final DialogInfo b;
    @Nullable
    public final DialogInfo c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CheckoutNextStepData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckoutNextStepData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CheckoutNextStepData((DeepLink) parcel.readParcelable(CheckoutNextStepData.class.getClassLoader()), (DialogInfo) parcel.readParcelable(CheckoutNextStepData.class.getClassLoader()), (DialogInfo) parcel.readParcelable(CheckoutNextStepData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckoutNextStepData[] newArray(int i) {
            return new CheckoutNextStepData[i];
        }
    }

    public CheckoutNextStepData(@NotNull DeepLink deepLink, @Nullable DialogInfo dialogInfo, @Nullable DialogInfo dialogInfo2) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.a = deepLink;
        this.b = dialogInfo;
        this.c = dialogInfo2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DialogInfo getActiveDialog() {
        return this.c;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.a;
    }

    @Nullable
    public final DialogInfo getSuccessDialog() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }
}

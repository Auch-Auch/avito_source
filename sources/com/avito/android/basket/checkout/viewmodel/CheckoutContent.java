package com.avito.android.basket.checkout.viewmodel;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.ParcelableItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutContent;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getPriceTemplate", "()Ljava/lang/String;", "priceTemplate", "c", "getEmptyActionTitle", "emptyActionTitle", AuthSource.SEND_ABUSE, "getActionTitle", "actionTitle", AuthSource.BOOKING_ORDER, "getCloseButtonTitle", "closeButtonTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "f", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDelayedAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "delayedAction", "", "Lcom/avito/conveyor_item/ParcelableItem;", "d", "Ljava/util/List;", "getList", "()Ljava/util/List;", "list", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutContent implements Parcelable {
    public static final Parcelable.Creator<CheckoutContent> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final List<ParcelableItem> d;
    @Nullable
    public final String e;
    @Nullable
    public final DeepLink f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CheckoutContent> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckoutContent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((ParcelableItem) parcel.readParcelable(CheckoutContent.class.getClassLoader()));
                readInt--;
            }
            return new CheckoutContent(readString, readString2, readString3, arrayList, parcel.readString(), (DeepLink) parcel.readParcelable(CheckoutContent.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CheckoutContent[] newArray(int i) {
            return new CheckoutContent[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.avito.conveyor_item.ParcelableItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public CheckoutContent(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<? extends ParcelableItem> list, @Nullable String str4, @Nullable DeepLink deepLink) {
        a.c1(str, "actionTitle", str2, "closeButtonTitle", list, "list");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = str4;
        this.f = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getActionTitle() {
        return this.a;
    }

    @NotNull
    public final String getCloseButtonTitle() {
        return this.b;
    }

    @Nullable
    public final DeepLink getDelayedAction() {
        return this.f;
    }

    @Nullable
    public final String getEmptyActionTitle() {
        return this.c;
    }

    @NotNull
    public final List<ParcelableItem> getList() {
        return this.d;
    }

    @Nullable
    public final String getPriceTemplate() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        Iterator n0 = a.n0(this.d, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ParcelableItem) n0.next(), i);
        }
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
    }
}

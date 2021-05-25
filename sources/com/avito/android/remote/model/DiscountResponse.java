package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/DiscountResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/UserAdvert;", "adverts", "Ljava/util/List;", "getAdverts", "()Ljava/util/List;", "Lcom/avito/android/remote/model/DiscountInfo;", "discountInfo", "Lcom/avito/android/remote/model/DiscountInfo;", "getDiscountInfo", "()Lcom/avito/android/remote/model/DiscountInfo;", "", "advertsTitle", "Ljava/lang/String;", "getAdvertsTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Lcom/avito/android/remote/model/DiscountInfo;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Ljava/util/List;)V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountResponse implements Parcelable {
    public static final Parcelable.Creator<DiscountResponse> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_ADVERT_ITEMS)
    @NotNull
    private final List<UserAdvert> adverts;
    @SerializedName("advertisementsTitle")
    @Nullable
    private final String advertsTitle;
    @SerializedName("discountInfo")
    @NotNull
    private final DiscountInfo discountInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DiscountResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DiscountResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            DiscountInfo createFromParcel = DiscountInfo.CREATOR.createFromParcel(parcel);
            Action action = (Action) parcel.readParcelable(DiscountResponse.class.getClassLoader());
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((UserAdvert) parcel.readParcelable(DiscountResponse.class.getClassLoader()));
                readInt--;
            }
            return new DiscountResponse(createFromParcel, action, readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DiscountResponse[] newArray(int i) {
            return new DiscountResponse[i];
        }
    }

    public DiscountResponse(@NotNull DiscountInfo discountInfo2, @Nullable Action action2, @Nullable String str, @NotNull List<UserAdvert> list) {
        Intrinsics.checkNotNullParameter(discountInfo2, "discountInfo");
        Intrinsics.checkNotNullParameter(list, "adverts");
        this.discountInfo = discountInfo2;
        this.action = action2;
        this.advertsTitle = str;
        this.adverts = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final List<UserAdvert> getAdverts() {
        return this.adverts;
    }

    @Nullable
    public final String getAdvertsTitle() {
        return this.advertsTitle;
    }

    @NotNull
    public final DiscountInfo getDiscountInfo() {
        return this.discountInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.discountInfo.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.action, i);
        parcel.writeString(this.advertsTitle);
        Iterator n0 = a.n0(this.adverts, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((UserAdvert) n0.next(), i);
        }
    }
}

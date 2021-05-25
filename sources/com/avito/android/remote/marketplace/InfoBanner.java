package com.avito.android.remote.marketplace;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.SimpleAdvertAction;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/remote/marketplace/InfoBanner;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "action", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "getAction", "()Lcom/avito/android/remote/model/SimpleAdvertAction;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "title", "getTitle", "Lcom/avito/android/remote/marketplace/InfoBannerPopup;", "popup", "Lcom/avito/android/remote/marketplace/InfoBannerPopup;", "getPopup", "()Lcom/avito/android/remote/marketplace/InfoBannerPopup;", "", "Lcom/avito/android/remote/marketplace/InfoBannerItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/SimpleAdvertAction;Lcom/avito/android/remote/marketplace/InfoBannerPopup;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class InfoBanner implements Parcelable {
    public static final Parcelable.Creator<InfoBanner> CREATOR = new Creator();
    @SerializedName("action")
    @NotNull
    private final SimpleAdvertAction action;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("items")
    @NotNull
    private final List<InfoBannerItem> items;
    @SerializedName("popup")
    @NotNull
    private final InfoBannerPopup popup;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<InfoBanner> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InfoBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(InfoBannerItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new InfoBanner(readString, readString2, arrayList, (SimpleAdvertAction) parcel.readParcelable(InfoBanner.class.getClassLoader()), InfoBannerPopup.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InfoBanner[] newArray(int i) {
            return new InfoBanner[i];
        }
    }

    public InfoBanner(@NotNull String str, @NotNull String str2, @NotNull List<InfoBannerItem> list, @NotNull SimpleAdvertAction simpleAdvertAction, @NotNull InfoBannerPopup infoBannerPopup) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(simpleAdvertAction, "action");
        Intrinsics.checkNotNullParameter(infoBannerPopup, "popup");
        this.title = str;
        this.description = str2;
        this.items = list;
        this.action = simpleAdvertAction;
        this.popup = infoBannerPopup;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final SimpleAdvertAction getAction() {
        return this.action;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<InfoBannerItem> getItems() {
        return this.items;
    }

    @NotNull
    public final InfoBannerPopup getPopup() {
        return this.popup;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Iterator n0 = a.n0(this.items, parcel);
        while (n0.hasNext()) {
            ((InfoBannerItem) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.action, i);
        this.popup.writeToParcel(parcel, 0);
    }
}

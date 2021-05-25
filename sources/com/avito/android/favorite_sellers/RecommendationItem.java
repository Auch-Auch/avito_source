package com.avito.android.favorite_sellers;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.favorite_sellers.FavoriteSellersItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSpannedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010 \u001a\u00020\n\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b-\u0010.J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0013R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000eR\u001c\u0010%\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/favorite_sellers/RecommendationItem;", "Lcom/avito/android/favorite_sellers/FavoriteSellersItem;", "Lcom/avito/android/serp/adapter/PersistableSpannedItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "isEditable", "Z", "()Z", "isEditable$annotations", "()V", "Landroid/os/Parcelable;", "e", "Landroid/os/Parcelable;", "getScrollState", "()Landroid/os/Parcelable;", "setScrollState", "(Landroid/os/Parcelable;)V", "scrollState", AuthSource.SEND_ABUSE, "getStringId", "stringId", "d", "I", "getSpanCount", "()I", "spanCount", "", "Lcom/avito/android/favorite_sellers/RecommendationCarouselItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getCarousel", "()Ljava/util/List;", "carousel", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILandroid/os/Parcelable;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public class RecommendationItem implements FavoriteSellersItem, PersistableSpannedItem {
    public static final Parcelable.Creator<RecommendationItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final List<RecommendationCarouselItem> b;
    @Nullable
    public final String c;
    public final int d;
    @Nullable
    public Parcelable e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RecommendationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((RecommendationCarouselItem) parcel.readParcelable(RecommendationItem.class.getClassLoader()));
                readInt--;
            }
            return new RecommendationItem(readString, arrayList, parcel.readString(), parcel.readInt(), parcel.readParcelable(RecommendationItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecommendationItem[] newArray(int i) {
            return new RecommendationItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.favorite_sellers.RecommendationCarouselItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public RecommendationItem(@NotNull String str, @NotNull List<? extends RecommendationCarouselItem> list, @Nullable String str2, int i, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(list, "carousel");
        this.a = str;
        this.b = list;
        this.c = str2;
        this.d = i;
        this.e = parcelable;
    }

    public static /* synthetic */ void isEditable$annotations() {
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem, android.os.Parcelable
    public int describeContents() {
        return FavoriteSellersItem.DefaultImpls.describeContents(this);
    }

    @NotNull
    public final List<RecommendationCarouselItem> getCarousel() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return FavoriteSellersItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final Parcelable getScrollState() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getTitle() {
        return this.c;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersItem
    public boolean isEditable() {
        return false;
    }

    public final void setScrollState(@Nullable Parcelable parcelable) {
        this.e = parcelable;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((RecommendationCarouselItem) n0.next(), i);
        }
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeParcelable(this.e, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecommendationItem(String str, List list, String str2, int i, Parcelable parcelable, int i2, j jVar) {
        this(str, list, str2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : parcelable);
    }
}

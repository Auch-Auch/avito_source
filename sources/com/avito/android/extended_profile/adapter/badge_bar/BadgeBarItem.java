package com.avito.android.extended_profile.adapter.badge_bar;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.component.badge_bar.badge.BadgeItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/extended_profile/adapter/badge_bar/BadgeBarItem;", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "getGridItemType", "()Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;", "gridItemType", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", "Lcom/avito/android/component/badge_bar/badge/BadgeItem;", "c", "Ljava/util/List;", "getBadges", "()Ljava/util/List;", "badges", "<init>", "(Ljava/lang/String;Lcom/avito/android/extended_profile/adapter/ExtendedProfileSpanLookup$GridItemType;Ljava/util/List;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeBarItem implements ExtendedProfileListItem {
    public static final Parcelable.Creator<BadgeBarItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final ExtendedProfileSpanLookup.GridItemType b;
    @NotNull
    public final List<BadgeItem> c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BadgeBarItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeBarItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            ExtendedProfileSpanLookup.GridItemType gridItemType = (ExtendedProfileSpanLookup.GridItemType) Enum.valueOf(ExtendedProfileSpanLookup.GridItemType.class, parcel.readString());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BadgeItem) parcel.readParcelable(BadgeBarItem.class.getClassLoader()));
                readInt--;
            }
            return new BadgeBarItem(readString, gridItemType, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BadgeBarItem[] newArray(int i) {
            return new BadgeBarItem[i];
        }
    }

    public BadgeBarItem(@NotNull String str, @NotNull ExtendedProfileSpanLookup.GridItemType gridItemType, @NotNull List<BadgeItem> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(gridItemType, "gridItemType");
        Intrinsics.checkNotNullParameter(list, "badges");
        this.a = str;
        this.b = gridItemType;
        this.c = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<BadgeItem> getBadges() {
        return this.c;
    }

    @Override // com.avito.android.extended_profile.adapter.ExtendedProfileListItem
    @NotNull
    public ExtendedProfileSpanLookup.GridItemType getGridItemType() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ExtendedProfileListItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        Iterator n0 = a.n0(this.c, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((BadgeItem) n0.next(), i);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgeBarItem(String str, ExtendedProfileSpanLookup.GridItemType gridItemType, List list, int i, j jVar) {
        this((i & 1) != 0 ? "badge_bar_item" : str, (i & 2) != 0 ? ExtendedProfileSpanLookup.GridItemType.FULL_WIDTH : gridItemType, list);
    }
}

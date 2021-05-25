package com.avito.android.advert.item.safedeal.label;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SafeDeal;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BI\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u00106\u001a\u000201\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u001c\u0012\b\b\u0002\u00100\u001a\u00020+¢\u0006\u0004\b7\u00108J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010&\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R\u001c\u0010*\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\tR\u001c\u00100\u001a\u00020+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00106\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/avito/android/advert/item/safedeal/label/AdvertDetailsSafeDealLabelItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getCategoryId", "()Ljava/lang/String;", "categoryId", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/remote/model/SerpDisplayType;", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "e", "I", "getSpanCount", "spanCount", "Lcom/avito/android/serp/adapter/SerpViewType;", g.a, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "d", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "getActions", "()Lcom/avito/android/remote/model/SafeDeal$Actions;", "actions", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SafeDeal$Actions;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSafeDealLabelItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsSafeDealLabelItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final SafeDeal.Actions d;
    public final int e;
    @NotNull
    public SerpDisplayType f;
    @NotNull
    public final SerpViewType g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsSafeDealLabelItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsSafeDealLabelItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsSafeDealLabelItem(parcel.readLong(), parcel.readString(), parcel.readString(), (SafeDeal.Actions) parcel.readParcelable(AdvertDetailsSafeDealLabelItem.class.getClassLoader()), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsSafeDealLabelItem[] newArray(int i) {
            return new AdvertDetailsSafeDealLabelItem[i];
        }
    }

    public AdvertDetailsSafeDealLabelItem(long j, @NotNull String str, @Nullable String str2, @NotNull SafeDeal.Actions actions, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = actions;
        this.e = i;
        this.f = serpDisplayType;
        this.g = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new AdvertDetailsSafeDealLabelItem(getId(), getStringId(), this.c, this.d, i, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final SafeDeal.Actions getActions() {
        return this.d;
    }

    @Nullable
    public final String getCategoryId() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.f = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.e);
        parcel.writeString(this.f.name());
        parcel.writeString(this.g.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsSafeDealLabelItem(long r12, java.lang.String r14, java.lang.String r15, com.avito.android.remote.model.SafeDeal.Actions r16, int r17, com.avito.android.remote.model.SerpDisplayType r18, com.avito.android.serp.adapter.SerpViewType r19, int r20, t6.r.a.j r21) {
        /*
            r11 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_SAFEDEAL_LABEL
            r0 = 24
            long r0 = (long) r0
            r3 = r0
            goto L_0x000c
        L_0x000b:
            r3 = r12
        L_0x000c:
            r0 = r20 & 2
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = java.lang.String.valueOf(r3)
            r5 = r0
            goto L_0x0017
        L_0x0016:
            r5 = r14
        L_0x0017:
            r0 = r20 & 32
            if (r0 == 0) goto L_0x001f
            com.avito.android.remote.model.SerpDisplayType r0 = com.avito.android.remote.model.SerpDisplayType.Grid
            r9 = r0
            goto L_0x0021
        L_0x001f:
            r9 = r18
        L_0x0021:
            r0 = r20 & 64
            if (r0 == 0) goto L_0x0029
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r10 = r0
            goto L_0x002b
        L_0x0029:
            r10 = r19
        L_0x002b:
            r2 = r11
            r6 = r15
            r7 = r16
            r8 = r17
            r2.<init>(r3, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelItem.<init>(long, java.lang.String, java.lang.String, com.avito.android.remote.model.SafeDeal$Actions, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}

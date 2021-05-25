package com.avito.android.advert.item.dfpcreditinfo.broker_link;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BG\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014\u0012\b\b\u0002\u0010 \u001a\u00020\u0017¢\u0006\u0004\bG\u0010HJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JV\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b#\u0010\rJ\u0010\u0010$\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b$\u0010\u0013J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b*\u0010\u0013J \u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b/\u00100R\u001c\u0010\u001d\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\rR\"\u0010\u001f\u001a\u00020\u00148\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u00108R\u001c\u0010\u001e\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\u0013R\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u0010\rR\u001c\u0010 \u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\nR\u001c\u0010\u001c\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0010¨\u0006I"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "component1", "()Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "", "component2", "()Ljava/lang/String;", "", "component3", "()J", "component4", "component5", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "component6", "()Lcom/avito/android/remote/model/SerpDisplayType;", "Lcom/avito/android/serp/adapter/SerpViewType;", "component7", "()Lcom/avito/android/serp/adapter/SerpViewType;", "linkType", "payment", "id", "stringId", "spanCount", "displayType", "viewType", "copy", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;Ljava/lang/String;JLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Ljava/lang/String;", "getStringId", "f", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "e", "I", "getSpanCount", AuthSource.BOOKING_ORDER, "getPayment", g.a, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "getLinkType", "c", "J", "getId", "<init>", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;Ljava/lang/String;JLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CreditBrokerLinkItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<CreditBrokerLinkItem> CREATOR = new Creator();
    @NotNull
    public final DfpCreditInfo.CreditCalculator.CalculatorLinkType a;
    @NotNull
    public final String b;
    public final long c;
    @NotNull
    public final String d;
    public final int e;
    @NotNull
    public SerpDisplayType f;
    @NotNull
    public final SerpViewType g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CreditBrokerLinkItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CreditBrokerLinkItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CreditBrokerLinkItem((DfpCreditInfo.CreditCalculator.CalculatorLinkType) Enum.valueOf(DfpCreditInfo.CreditCalculator.CalculatorLinkType.class, parcel.readString()), parcel.readString(), parcel.readLong(), parcel.readString(), parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CreditBrokerLinkItem[] newArray(int i) {
            return new CreditBrokerLinkItem[i];
        }
    }

    public CreditBrokerLinkItem(@NotNull DfpCreditInfo.CreditCalculator.CalculatorLinkType calculatorLinkType, @NotNull String str, long j, @NotNull String str2, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(calculatorLinkType, "linkType");
        Intrinsics.checkNotNullParameter(str, "payment");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = calculatorLinkType;
        this.b = str;
        this.c = j;
        this.d = str2;
        this.e = i;
        this.f = serpDisplayType;
        this.g = serpViewType;
    }

    public static /* synthetic */ CreditBrokerLinkItem copy$default(CreditBrokerLinkItem creditBrokerLinkItem, DfpCreditInfo.CreditCalculator.CalculatorLinkType calculatorLinkType, String str, long j, String str2, int i, SerpDisplayType serpDisplayType, SerpViewType serpViewType, int i2, Object obj) {
        return creditBrokerLinkItem.copy((i2 & 1) != 0 ? creditBrokerLinkItem.a : calculatorLinkType, (i2 & 2) != 0 ? creditBrokerLinkItem.b : str, (i2 & 4) != 0 ? creditBrokerLinkItem.getId() : j, (i2 & 8) != 0 ? creditBrokerLinkItem.getStringId() : str2, (i2 & 16) != 0 ? creditBrokerLinkItem.getSpanCount() : i, (i2 & 32) != 0 ? creditBrokerLinkItem.getDisplayType() : serpDisplayType, (i2 & 64) != 0 ? creditBrokerLinkItem.getViewType() : serpViewType);
    }

    @NotNull
    public final DfpCreditInfo.CreditCalculator.CalculatorLinkType component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final long component3() {
        return getId();
    }

    @NotNull
    public final String component4() {
        return getStringId();
    }

    public final int component5() {
        return getSpanCount();
    }

    @NotNull
    public final SerpDisplayType component6() {
        return getDisplayType();
    }

    @NotNull
    public final SerpViewType component7() {
        return getViewType();
    }

    @NotNull
    public final CreditBrokerLinkItem copy(@NotNull DfpCreditInfo.CreditCalculator.CalculatorLinkType calculatorLinkType, @NotNull String str, long j, @NotNull String str2, int i, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(calculatorLinkType, "linkType");
        Intrinsics.checkNotNullParameter(str, "payment");
        Intrinsics.checkNotNullParameter(str2, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        return new CreditBrokerLinkItem(calculatorLinkType, str, j, str2, i, serpDisplayType, serpViewType);
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i) {
        return new CreditBrokerLinkItem(this.a, this.b, getId(), getStringId(), i, getDisplayType(), getViewType());
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
        if (!(obj instanceof CreditBrokerLinkItem)) {
            return false;
        }
        CreditBrokerLinkItem creditBrokerLinkItem = (CreditBrokerLinkItem) obj;
        return Intrinsics.areEqual(this.a, creditBrokerLinkItem.a) && Intrinsics.areEqual(this.b, creditBrokerLinkItem.b) && getId() == creditBrokerLinkItem.getId() && Intrinsics.areEqual(getStringId(), creditBrokerLinkItem.getStringId()) && getSpanCount() == creditBrokerLinkItem.getSpanCount() && Intrinsics.areEqual(getDisplayType(), creditBrokerLinkItem.getDisplayType()) && Intrinsics.areEqual(getViewType(), creditBrokerLinkItem.getViewType());
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.c;
    }

    @NotNull
    public final DfpCreditInfo.CreditCalculator.CalculatorLinkType getLinkType() {
        return this.a;
    }

    @NotNull
    public final String getPayment() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.g;
    }

    @Override // java.lang.Object
    public int hashCode() {
        DfpCreditInfo.CreditCalculator.CalculatorLinkType calculatorLinkType = this.a;
        int i = 0;
        int hashCode = (calculatorLinkType != null ? calculatorLinkType.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + c.a(getId())) * 31;
        String stringId = getStringId();
        int spanCount = (getSpanCount() + ((hashCode2 + (stringId != null ? stringId.hashCode() : 0)) * 31)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode3 = (spanCount + (displayType != null ? displayType.hashCode() : 0)) * 31;
        SerpViewType viewType = getViewType();
        if (viewType != null) {
            i = viewType.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.f = serpDisplayType;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CreditBrokerLinkItem(linkType=");
        L.append(this.a);
        L.append(", payment=");
        L.append(this.b);
        L.append(", id=");
        L.append(getId());
        L.append(", stringId=");
        L.append(getStringId());
        L.append(", spanCount=");
        L.append(getSpanCount());
        L.append(", displayType=");
        L.append(getDisplayType());
        L.append(", viewType=");
        L.append(getViewType());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a.name());
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f.name());
        parcel.writeString(this.g.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CreditBrokerLinkItem(com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo.CreditCalculator.CalculatorLinkType r12, java.lang.String r13, long r14, java.lang.String r16, int r17, com.avito.android.remote.model.SerpDisplayType r18, com.avito.android.serp.adapter.SerpViewType r19, int r20, t6.r.a.j r21) {
        /*
            r11 = this;
            r0 = r20 & 4
            if (r0 == 0) goto L_0x000b
            com.avito.android.advert_core.advert.AdvertDetailsItem r0 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_CREDIT_CALCULATOR_LINK
            r0 = 17
            long r0 = (long) r0
            r5 = r0
            goto L_0x000c
        L_0x000b:
            r5 = r14
        L_0x000c:
            r0 = r20 & 8
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = java.lang.String.valueOf(r5)
            r7 = r0
            goto L_0x0018
        L_0x0016:
            r7 = r16
        L_0x0018:
            r0 = r20 & 32
            if (r0 == 0) goto L_0x0020
            com.avito.android.remote.model.SerpDisplayType r0 = com.avito.android.remote.model.SerpDisplayType.Grid
            r9 = r0
            goto L_0x0022
        L_0x0020:
            r9 = r18
        L_0x0022:
            r0 = r20 & 64
            if (r0 == 0) goto L_0x002a
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r10 = r0
            goto L_0x002c
        L_0x002a:
            r10 = r19
        L_0x002c:
            r2 = r11
            r3 = r12
            r4 = r13
            r8 = r17
            r2.<init>(r3, r4, r5, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkItem.<init>(com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo$CreditCalculator$CalculatorLinkType, java.lang.String, long, java.lang.String, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}

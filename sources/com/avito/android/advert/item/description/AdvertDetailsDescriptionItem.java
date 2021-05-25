package com.avito.android.advert.item.description;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.html_formatter.HtmlCharSequence;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bs\u0012\b\b\u0002\u0010!\u001a\u00020\u001c\u0012\b\b\u0002\u00103\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u00100\u001a\u00020&\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u0010@\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010N\u001a\u00020G\u0012\b\b\u0002\u0010F\u001a\u00020A¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\tR\u0019\u0010+\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u00100\u001a\u00020&8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*\"\u0004\b.\u0010/R\u001c\u00103\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010@\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010#\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010?R\u001c\u0010F\u001a\u00020A8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\"\u0010N\u001a\u00020G8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006Q"}, d2 = {"Lcom/avito/android/advert/item/description/AdvertDetailsDescriptionItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getCategoryName", "()Ljava/lang/String;", "categoryName", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "d", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "getDescription", "()Lcom/avito/android/html_formatter/HtmlCharSequence;", "description", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "i", "I", "getSpanCount", "spanCount", "", "h", "Z", "getClosedAdvert", "()Z", "closedAdvert", "e", "getShowDivider", "setShowDivider", "(Z)V", "showDivider", AuthSource.BOOKING_ORDER, "getStringId", "stringId", "Landroid/os/Parcelable;", "f", "Landroid/os/Parcelable;", "getExpandPanelState", "()Landroid/os/Parcelable;", "setExpandPanelState", "(Landroid/os/Parcelable;)V", "expandPanelState", g.a, "getCollapsedLinesCount", "setCollapsedLinesCount", "(I)V", "collapsedLinesCount", "Lcom/avito/android/serp/adapter/SerpViewType;", "k", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/remote/model/SerpDisplayType;", "j", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/html_formatter/HtmlCharSequence;ZLandroid/os/Parcelable;IZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDescriptionItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<AdvertDetailsDescriptionItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final HtmlCharSequence d;
    public boolean e;
    @Nullable
    public Parcelable f;
    public int g;
    public final boolean h;
    public final int i;
    @NotNull
    public SerpDisplayType j;
    @NotNull
    public final SerpViewType k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDetailsDescriptionItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsDescriptionItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDetailsDescriptionItem(parcel.readLong(), parcel.readString(), parcel.readString(), (HtmlCharSequence) parcel.readParcelable(AdvertDetailsDescriptionItem.class.getClassLoader()), parcel.readInt() != 0, parcel.readParcelable(AdvertDetailsDescriptionItem.class.getClassLoader()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDetailsDescriptionItem[] newArray(int i) {
            return new AdvertDetailsDescriptionItem[i];
        }
    }

    public AdvertDetailsDescriptionItem(long j2, @NotNull String str, @Nullable String str2, @Nullable HtmlCharSequence htmlCharSequence, boolean z, @Nullable Parcelable parcelable, int i2, boolean z2, int i3, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = htmlCharSequence;
        this.e = z;
        this.f = parcelable;
        this.g = i2;
        this.h = z2;
        this.i = i3;
        this.j = serpDisplayType;
        this.k = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new AdvertDetailsDescriptionItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, this.h, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getCategoryName() {
        return this.c;
    }

    public final boolean getClosedAdvert() {
        return this.h;
    }

    public final int getCollapsedLinesCount() {
        return this.g;
    }

    @Nullable
    public final HtmlCharSequence getDescription() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.j;
    }

    @Nullable
    public final Parcelable getExpandPanelState() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    public final boolean getShowDivider() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.k;
    }

    public final void setCollapsedLinesCount(int i2) {
        this.g = i2;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.j = serpDisplayType;
    }

    public final void setExpandPanelState(@Nullable Parcelable parcelable) {
        this.f = parcelable;
    }

    public final void setShowDivider(boolean z) {
        this.e = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i2);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeParcelable(this.f, i2);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i);
        parcel.writeString(this.j.name());
        parcel.writeString(this.k.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertDetailsDescriptionItem(long r17, java.lang.String r19, java.lang.String r20, com.avito.android.html_formatter.HtmlCharSequence r21, boolean r22, android.os.Parcelable r23, int r24, boolean r25, int r26, com.avito.android.remote.model.SerpDisplayType r27, com.avito.android.serp.adapter.SerpViewType r28, int r29, t6.r.a.j r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_DESCRIPTION
            r1 = 5
            long r1 = (long) r1
            r4 = r1
            goto L_0x000e
        L_0x000c:
            r4 = r17
        L_0x000e:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001a
        L_0x0018:
            r6 = r19
        L_0x001a:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0021
            r1 = 0
            r9 = 0
            goto L_0x0023
        L_0x0021:
            r9 = r22
        L_0x0023:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002a
            r1 = 0
            r10 = r1
            goto L_0x002c
        L_0x002a:
            r10 = r23
        L_0x002c:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0033
            r1 = 4
            r11 = 4
            goto L_0x0035
        L_0x0033:
            r11 = r24
        L_0x0035:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x003d
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r14 = r1
            goto L_0x003f
        L_0x003d:
            r14 = r27
        L_0x003f:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0047
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r15 = r0
            goto L_0x0049
        L_0x0047:
            r15 = r28
        L_0x0049:
            r3 = r16
            r7 = r20
            r8 = r21
            r12 = r25
            r13 = r26
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.description.AdvertDetailsDescriptionItem.<init>(long, java.lang.String, java.lang.String, com.avito.android.html_formatter.HtmlCharSequence, boolean, android.os.Parcelable, int, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}

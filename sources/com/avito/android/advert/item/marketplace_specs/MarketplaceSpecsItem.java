package com.avito.android.advert.item.marketplace_specs;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.advert.BlockItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bq\u0012\b\b\u0002\u00108\u001a\u000203\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010;\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020=0<\u0012\u0006\u0010&\u001a\u00020\u0016\u0012\b\b\u0002\u0010D\u001a\u00020-\u0012\b\b\u0002\u00102\u001a\u00020-\u0012\u0006\u0010J\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u001c\u0012\b\b\u0002\u0010,\u001a\u00020'¢\u0006\u0004\bK\u0010LJ\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0019\u0010&\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u001c\u0010,\u001a\u00020'8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u00102\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00108\u001a\u0002038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u0010;\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0018\u001a\u0004\b:\u0010\u001aR\u001f\u0010B\u001a\b\u0012\u0004\u0012\u00020=0<8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\"\u0010D\u001a\u00020-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010/\u001a\u0004\bD\u00101\"\u0004\bE\u0010FR\u001c\u0010J\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\t¨\u0006M"}, d2 = {"Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;", "Lcom/avito/android/advert_core/advert/BlockItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "", "span", "copyWithSpanCount", "(I)Lcom/avito/android/advert_core/advert/BlockItem;", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/ModelSpecifications;", "d", "Lcom/avito/android/remote/model/ModelSpecifications;", "getSpecs", "()Lcom/avito/android/remote/model/ModelSpecifications;", "specs", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/SerpDisplayType;", "j", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "displayType", "f", "getButtonTitle", "buttonTitle", "Lcom/avito/android/serp/adapter/SerpViewType;", "k", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "", "h", "Z", "getShowMore", "()Z", "showMore", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "c", "getTitle", "title", "", "Lcom/avito/android/remote/model/ModelSpecifications$Parameter;", "e", "Ljava/util/List;", "getPreviewSpecs", "()Ljava/util/List;", "previewSpecs", g.a, "isDialogShown", "setDialogShown", "(Z)V", "i", "I", "getSpanCount", "spanCount", "<init>", "(JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ModelSpecifications;Ljava/util/List;Ljava/lang/String;ZZILcom/avito/android/remote/model/SerpDisplayType;Lcom/avito/android/serp/adapter/SerpViewType;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceSpecsItem implements BlockItem, DisplayTypeAwareItem, ViewTypeSerpItem {
    public static final Parcelable.Creator<MarketplaceSpecsItem> CREATOR = new Creator();
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final ModelSpecifications d;
    @NotNull
    public final List<ModelSpecifications.Parameter> e;
    @NotNull
    public final String f;
    public boolean g;
    public final boolean h;
    public final int i;
    @NotNull
    public SerpDisplayType j;
    @NotNull
    public final SerpViewType k;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceSpecsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceSpecsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ModelSpecifications modelSpecifications = (ModelSpecifications) parcel.readParcelable(MarketplaceSpecsItem.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((ModelSpecifications.Parameter) parcel.readParcelable(MarketplaceSpecsItem.class.getClassLoader()));
                readInt--;
            }
            String readString3 = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new MarketplaceSpecsItem(readLong, readString, readString2, modelSpecifications, arrayList, readString3, z2, z, parcel.readInt(), (SerpDisplayType) Enum.valueOf(SerpDisplayType.class, parcel.readString()), (SerpViewType) Enum.valueOf(SerpViewType.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceSpecsItem[] newArray(int i) {
            return new MarketplaceSpecsItem[i];
        }
    }

    public MarketplaceSpecsItem(long j2, @NotNull String str, @NotNull String str2, @NotNull ModelSpecifications modelSpecifications, @NotNull List<ModelSpecifications.Parameter> list, @NotNull String str3, boolean z, boolean z2, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull SerpViewType serpViewType) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(modelSpecifications, "specs");
        Intrinsics.checkNotNullParameter(list, "previewSpecs");
        Intrinsics.checkNotNullParameter(str3, "buttonTitle");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        this.a = j2;
        this.b = str;
        this.c = str2;
        this.d = modelSpecifications;
        this.e = list;
        this.f = str3;
        this.g = z;
        this.h = z2;
        this.i = i2;
        this.j = serpDisplayType;
        this.k = serpViewType;
    }

    @Override // com.avito.android.advert_core.advert.BlockItem
    @NotNull
    public BlockItem copyWithSpanCount(int i2) {
        return new MarketplaceSpecsItem(getId(), getStringId(), this.c, this.d, this.e, this.f, this.g, this.h, i2, getDisplayType(), getViewType());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getButtonTitle() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.j;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final List<ModelSpecifications.Parameter> getPreviewSpecs() {
        return this.e;
    }

    public final boolean getShowMore() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.i;
    }

    @NotNull
    public final ModelSpecifications getSpecs() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.k;
    }

    public final boolean isDialogShown() {
        return this.g;
    }

    public final void setDialogShown(boolean z) {
        this.g = z;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.j = serpDisplayType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i2);
        Iterator n0 = a.n0(this.e, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ModelSpecifications.Parameter) n0.next(), i2);
        }
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i);
        parcel.writeString(this.j.name());
        parcel.writeString(this.k.name());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MarketplaceSpecsItem(long r17, java.lang.String r19, java.lang.String r20, com.avito.android.remote.model.ModelSpecifications r21, java.util.List r22, java.lang.String r23, boolean r24, boolean r25, int r26, com.avito.android.remote.model.SerpDisplayType r27, com.avito.android.serp.adapter.SerpViewType r28, int r29, t6.r.a.j r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            com.avito.android.advert_core.advert.AdvertDetailsItem r1 = com.avito.android.advert_core.advert.AdvertDetailsItem.ITEM_MARKETPLACE_SPECS
            r1 = 51
            long r1 = (long) r1
            r4 = r1
            goto L_0x000f
        L_0x000d:
            r4 = r17
        L_0x000f:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0019
            java.lang.String r1 = java.lang.String.valueOf(r4)
            r6 = r1
            goto L_0x001b
        L_0x0019:
            r6 = r19
        L_0x001b:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0022
            r11 = 0
            goto L_0x0024
        L_0x0022:
            r11 = r24
        L_0x0024:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002a
            r12 = 0
            goto L_0x002c
        L_0x002a:
            r12 = r25
        L_0x002c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0034
            com.avito.android.remote.model.SerpDisplayType r1 = com.avito.android.remote.model.SerpDisplayType.Grid
            r14 = r1
            goto L_0x0036
        L_0x0034:
            r14 = r27
        L_0x0036:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x003e
            com.avito.android.serp.adapter.SerpViewType r0 = com.avito.android.serp.adapter.SerpViewType.SINGLE
            r15 = r0
            goto L_0x0040
        L_0x003e:
            r15 = r28
        L_0x0040:
            r3 = r16
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r13 = r26
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsItem.<init>(long, java.lang.String, java.lang.String, com.avito.android.remote.model.ModelSpecifications, java.util.List, java.lang.String, boolean, boolean, int, com.avito.android.remote.model.SerpDisplayType, com.avito.android.serp.adapter.SerpViewType, int, t6.r.a.j):void");
    }
}

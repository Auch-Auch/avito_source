package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery_courier.DeliveryCourierSummary;
import com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJJ\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u0012\u0010\r\"\u0004\b%\u0010&R\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServiceRadioButtonItem;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Cost;", "component4", "()Ljava/util/List;", "", "component5", "()Z", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "cost", "isChecked", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/multiple_services/CourierServiceRadioButtonItem;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/util/List;", "getCost", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "e", "Z", "setChecked", "(Z)V", AuthSource.BOOKING_ORDER, "getTitle", "c", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class CourierServiceRadioButtonItem implements BaseCourierServiceItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final List<DeliveryCourierSummary.Cost> d;
    public boolean e;

    public CourierServiceRadioButtonItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<DeliveryCourierSummary.Cost> list, boolean z) {
        a.c1(str, "stringId", str2, "title", list, "cost");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.multiple_services.CourierServiceRadioButtonItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CourierServiceRadioButtonItem copy$default(CourierServiceRadioButtonItem courierServiceRadioButtonItem, String str, String str2, String str3, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courierServiceRadioButtonItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = courierServiceRadioButtonItem.getTitle();
        }
        if ((i & 4) != 0) {
            str3 = courierServiceRadioButtonItem.getSubtitle();
        }
        if ((i & 8) != 0) {
            list = courierServiceRadioButtonItem.getCost();
        }
        if ((i & 16) != 0) {
            z = courierServiceRadioButtonItem.e;
        }
        return courierServiceRadioButtonItem.copy(str, str2, str3, list, z);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @Nullable
    public final String component3() {
        return getSubtitle();
    }

    @NotNull
    public final List<DeliveryCourierSummary.Cost> component4() {
        return getCost();
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final CourierServiceRadioButtonItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<DeliveryCourierSummary.Cost> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "cost");
        return new CourierServiceRadioButtonItem(str, str2, str3, list, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourierServiceRadioButtonItem)) {
            return false;
        }
        CourierServiceRadioButtonItem courierServiceRadioButtonItem = (CourierServiceRadioButtonItem) obj;
        return Intrinsics.areEqual(getStringId(), courierServiceRadioButtonItem.getStringId()) && Intrinsics.areEqual(getTitle(), courierServiceRadioButtonItem.getTitle()) && Intrinsics.areEqual(getSubtitle(), courierServiceRadioButtonItem.getSubtitle()) && Intrinsics.areEqual(getCost(), courierServiceRadioButtonItem.getCost()) && this.e == courierServiceRadioButtonItem.e;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem
    @NotNull
    public List<DeliveryCourierSummary.Cost> getCost() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return BaseCourierServiceItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem
    @Nullable
    public String getSubtitle() {
        return this.c;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.BaseCourierServiceItem
    @NotNull
    public String getTitle() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String title = getTitle();
        int hashCode2 = (hashCode + (title != null ? title.hashCode() : 0)) * 31;
        String subtitle = getSubtitle();
        int hashCode3 = (hashCode2 + (subtitle != null ? subtitle.hashCode() : 0)) * 31;
        List<DeliveryCourierSummary.Cost> cost = getCost();
        if (cost != null) {
            i = cost.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isChecked() {
        return this.e;
    }

    public final void setChecked(boolean z) {
        this.e = z;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CourierServiceRadioButtonItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", subtitle=");
        L.append(getSubtitle());
        L.append(", cost=");
        L.append(getCost());
        L.append(", isChecked=");
        return a.B(L, this.e, ")");
    }
}

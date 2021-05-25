package com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ@\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItem;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/BaseCourierServiceItem;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierSummary$Cost;", "component4", "()Ljava/util/List;", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "cost", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/courier_service/single_service/SingleCourierServiceItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "d", "Ljava/util/List;", "getCost", AuthSource.SEND_ABUSE, "getStringId", "c", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SingleCourierServiceItem implements BaseCourierServiceItem {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final List<DeliveryCourierSummary.Cost> d;

    public SingleCourierServiceItem(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<DeliveryCourierSummary.Cost> list) {
        a.c1(str, "stringId", str2, "title", list, "cost");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.safedeal.delivery_courier.summary.konveyor.courier_service.single_service.SingleCourierServiceItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleCourierServiceItem copy$default(SingleCourierServiceItem singleCourierServiceItem, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = singleCourierServiceItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = singleCourierServiceItem.getTitle();
        }
        if ((i & 4) != 0) {
            str3 = singleCourierServiceItem.getSubtitle();
        }
        if ((i & 8) != 0) {
            list = singleCourierServiceItem.getCost();
        }
        return singleCourierServiceItem.copy(str, str2, str3, list);
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

    @NotNull
    public final SingleCourierServiceItem copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull List<DeliveryCourierSummary.Cost> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "cost");
        return new SingleCourierServiceItem(str, str2, str3, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SingleCourierServiceItem)) {
            return false;
        }
        SingleCourierServiceItem singleCourierServiceItem = (SingleCourierServiceItem) obj;
        return Intrinsics.areEqual(getStringId(), singleCourierServiceItem.getStringId()) && Intrinsics.areEqual(getTitle(), singleCourierServiceItem.getTitle()) && Intrinsics.areEqual(getSubtitle(), singleCourierServiceItem.getSubtitle()) && Intrinsics.areEqual(getCost(), singleCourierServiceItem.getCost());
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
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SingleCourierServiceItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", subtitle=");
        L.append(getSubtitle());
        L.append(", cost=");
        L.append(getCost());
        L.append(")");
        return L.toString();
    }
}

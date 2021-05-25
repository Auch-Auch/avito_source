package com.avito.android.delivery.summary.konveyor.shipment;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\f¨\u0006)"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup$Shipment$Item;", "component4", "()Ljava/util/List;", "stringId", "title", MessengerShareContentUtility.SUBTITLE, "items", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;)Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "getTitle", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "d", "Ljava/util/List;", "getItems", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ShipmentItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final AttributedText c;
    @NotNull
    public final List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> d;

    public ShipmentItem(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @NotNull List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> list) {
        a.c1(str, "stringId", str2, "title", list, "items");
        this.a = str;
        this.b = str2;
        this.c = attributedText;
        this.d = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.delivery.summary.konveyor.shipment.ShipmentItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShipmentItem copy$default(ShipmentItem shipmentItem, String str, String str2, AttributedText attributedText, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shipmentItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = shipmentItem.b;
        }
        if ((i & 4) != 0) {
            attributedText = shipmentItem.c;
        }
        if ((i & 8) != 0) {
            list = shipmentItem.d;
        }
        return shipmentItem.copy(str, str2, attributedText, list);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final AttributedText component3() {
        return this.c;
    }

    @NotNull
    public final List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> component4() {
        return this.d;
    }

    @NotNull
    public final ShipmentItem copy(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @NotNull List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list, "items");
        return new ShipmentItem(str, str2, attributedText, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShipmentItem)) {
            return false;
        }
        ShipmentItem shipmentItem = (ShipmentItem) obj;
        return Intrinsics.areEqual(getStringId(), shipmentItem.getStringId()) && Intrinsics.areEqual(this.b, shipmentItem.b) && Intrinsics.areEqual(this.c, shipmentItem.c) && Intrinsics.areEqual(this.d, shipmentItem.d);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> getItems() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final AttributedText getSubtitle() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        AttributedText attributedText = this.c;
        int hashCode3 = (hashCode2 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> list = this.d;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShipmentItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", subtitle=");
        L.append(this.c);
        L.append(", items=");
        return a.w(L, this.d, ")");
    }
}

package com.avito.android.publish.slots.cpa_tariff.item;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaButtonAction;
import com.avito.conveyor_item.Item;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\\\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\u0004R'\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\rR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b+\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010\u0004¨\u00060"}, d2 = {"Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;", "component5", "()Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;", "", "component6", "()Ljava/util/Map;", "stringId", "title", "description", "buttonTitle", "buttonAction", "attributesAndValues", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;Ljava/util/Map;)Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;", "getButtonAction", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "getTitle", "f", "Ljava/util/Map;", "getAttributesAndValues", "c", "getDescription", "d", "getButtonTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaButtonAction;Ljava/util/Map;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffSlotItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final CpaButtonAction e;
    @Nullable
    public final Map<String, String> f;

    public CpaTariffSlotItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable CpaButtonAction cpaButtonAction, @Nullable Map<String, String> map) {
        a.b1(str, "stringId", str2, "title", str3, "description", str4, "buttonTitle");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = cpaButtonAction;
        this.f = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CpaTariffSlotItem copy$default(CpaTariffSlotItem cpaTariffSlotItem, String str, String str2, String str3, String str4, CpaButtonAction cpaButtonAction, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cpaTariffSlotItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = cpaTariffSlotItem.b;
        }
        if ((i & 4) != 0) {
            str3 = cpaTariffSlotItem.c;
        }
        if ((i & 8) != 0) {
            str4 = cpaTariffSlotItem.d;
        }
        if ((i & 16) != 0) {
            cpaButtonAction = cpaTariffSlotItem.e;
        }
        if ((i & 32) != 0) {
            map = cpaTariffSlotItem.f;
        }
        return cpaTariffSlotItem.copy(str, str2, str3, str4, cpaButtonAction, map);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final CpaButtonAction component5() {
        return this.e;
    }

    @Nullable
    public final Map<String, String> component6() {
        return this.f;
    }

    @NotNull
    public final CpaTariffSlotItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable CpaButtonAction cpaButtonAction, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "buttonTitle");
        return new CpaTariffSlotItem(str, str2, str3, str4, cpaButtonAction, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CpaTariffSlotItem)) {
            return false;
        }
        CpaTariffSlotItem cpaTariffSlotItem = (CpaTariffSlotItem) obj;
        return Intrinsics.areEqual(getStringId(), cpaTariffSlotItem.getStringId()) && Intrinsics.areEqual(this.b, cpaTariffSlotItem.b) && Intrinsics.areEqual(this.c, cpaTariffSlotItem.c) && Intrinsics.areEqual(this.d, cpaTariffSlotItem.d) && Intrinsics.areEqual(this.e, cpaTariffSlotItem.e) && Intrinsics.areEqual(this.f, cpaTariffSlotItem.f);
    }

    @Nullable
    public final Map<String, String> getAttributesAndValues() {
        return this.f;
    }

    @Nullable
    public final CpaButtonAction getButtonAction() {
        return this.e;
    }

    @NotNull
    public final String getButtonTitle() {
        return this.d;
    }

    @NotNull
    public final String getDescription() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
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
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        CpaButtonAction cpaButtonAction = this.e;
        int hashCode5 = (hashCode4 + (cpaButtonAction != null ? cpaButtonAction.hashCode() : 0)) * 31;
        Map<String, String> map = this.f;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CpaTariffSlotItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", description=");
        L.append(this.c);
        L.append(", buttonTitle=");
        L.append(this.d);
        L.append(", buttonAction=");
        L.append(this.e);
        L.append(", attributesAndValues=");
        return a.x(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CpaTariffSlotItem(String str, String str2, String str3, String str4, CpaButtonAction cpaButtonAction, Map map, int i, j jVar) {
        this(str, str2, str3, str4, cpaButtonAction, (i & 32) != 0 ? null : map);
    }
}

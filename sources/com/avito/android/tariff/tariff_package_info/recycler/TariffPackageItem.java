package com.avito.android.tariff.tariff_package_info.recycler;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageMicroCategoryItem;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\t¨\u0006\""}, d2 = {"Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageMicroCategoryItem;", "component3", "()Ljava/util/List;", "stringId", "title", "microCategories", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/tariff/tariff_package_info/recycler/TariffPackageItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", AuthSource.BOOKING_ORDER, "getTitle", "c", "Ljava/util/List;", "getMicroCategories", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final List<EditPackageMicroCategoryItem> c;

    public TariffPackageItem(@NotNull String str, @NotNull String str2, @Nullable List<EditPackageMicroCategoryItem> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = str2;
        this.c = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.tariff.tariff_package_info.recycler.TariffPackageItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TariffPackageItem copy$default(TariffPackageItem tariffPackageItem, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tariffPackageItem.getStringId();
        }
        if ((i & 2) != 0) {
            str2 = tariffPackageItem.b;
        }
        if ((i & 4) != 0) {
            list = tariffPackageItem.c;
        }
        return tariffPackageItem.copy(str, str2, list);
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
    public final List<EditPackageMicroCategoryItem> component3() {
        return this.c;
    }

    @NotNull
    public final TariffPackageItem copy(@NotNull String str, @NotNull String str2, @Nullable List<EditPackageMicroCategoryItem> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new TariffPackageItem(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TariffPackageItem)) {
            return false;
        }
        TariffPackageItem tariffPackageItem = (TariffPackageItem) obj;
        return Intrinsics.areEqual(getStringId(), tariffPackageItem.getStringId()) && Intrinsics.areEqual(this.b, tariffPackageItem.b) && Intrinsics.areEqual(this.c, tariffPackageItem.c);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Nullable
    public final List<EditPackageMicroCategoryItem> getMicroCategories() {
        return this.c;
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
        List<EditPackageMicroCategoryItem> list = this.c;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TariffPackageItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", microCategories=");
        return a.w(L, this.c, ")");
    }
}

package com.avito.android.tariff.fees_methods.items.tariff_package;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageMicroCategoryItem;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/tariff_package/FeeMethodPackageItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "c", "getLocations", "locations", "", "Lcom/avito/android/tariff/edit_info/item/edit_package/EditPackageMicroCategoryItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getMicrocategories", "()Ljava/util/List;", "microcategories", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodPackageItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final List<EditPackageMicroCategoryItem> b;
    @NotNull
    public final String c;

    public FeeMethodPackageItem(@NotNull String str, @NotNull List<EditPackageMicroCategoryItem> list, @NotNull String str2) {
        a.d1(str, "stringId", list, "microcategories", str2, "locations");
        this.a = str;
        this.b = list;
        this.c = str2;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final String getLocations() {
        return this.c;
    }

    @NotNull
    public final List<EditPackageMicroCategoryItem> getMicrocategories() {
        return this.b;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }
}

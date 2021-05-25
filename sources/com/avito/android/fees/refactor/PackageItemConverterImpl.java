package com.avito.android.fees.refactor;

import com.avito.android.fees.refactor.item.PackageItem;
import com.avito.android.fees.refactor.item.header.HeaderItem;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/fees/refactor/PackageItemConverterImpl;", "Lcom/avito/android/fees/refactor/PackageItemConverter;", "", "message", "", "Lcom/avito/android/remote/model/OwnedPackage;", "ownedPackages", "Lcom/avito/conveyor_item/Item;", "convert", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "fees_release"}, k = 1, mv = {1, 4, 2})
public final class PackageItemConverterImpl implements PackageItemConverter {
    @Override // com.avito.android.fees.refactor.PackageItemConverter
    @NotNull
    public List<Item> convert(@NotNull String str, @NotNull List<OwnedPackage> list) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(list, "ownedPackages");
        int i = 0;
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new HeaderItem("headerId", str));
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            arrayList.add(new PackageItem(String.valueOf(i), t2.getCountDetails(), t2.getCountPercentage(), t2.getDaysLeft(), t2.getLocation(), t2.getRestrictions(), t2.getId()));
            i = i2;
        }
        h.addAll(mutableListOf, CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList));
        return mutableListOf;
    }
}

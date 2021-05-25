package com.avito.android.tariff.edit_info.ui;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.recycler.data_aware.EqualityComparator;
import com.avito.android.tariff.edit_info.item.edit_package.EditPackageItem;
import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItem;
import com.avito.android.tariff.edit_info.item.tabs.TabsItem;
import com.avito.android.tariff.info.item.info.InfoItem;
import com.avito.android.tariff.info.item.package_title.PackageTitleItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/edit_info/ui/EditInfoEqualityComparator;", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "isEqual", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoEqualityComparator implements EqualityComparator {
    @Override // com.avito.android.recycler.data_aware.EqualityComparator
    public boolean isEqual(@Nullable Item item, @Nullable Item item2) {
        if ((item instanceof InfoItem) && (item2 instanceof InfoItem)) {
            return Intrinsics.areEqual(((InfoItem) item).getStringId(), ((InfoItem) item2).getStringId());
        }
        if ((item instanceof TariffProlongationItem) && (item2 instanceof TariffProlongationItem)) {
            return Intrinsics.areEqual(((TariffProlongationItem) item).getStringId(), ((TariffProlongationItem) item2).getStringId());
        }
        if ((item instanceof PaidServiceHeaderItem) && (item2 instanceof PaidServiceHeaderItem)) {
            return Intrinsics.areEqual(((PaidServiceHeaderItem) item).getTitle(), ((PaidServiceHeaderItem) item2).getTitle());
        }
        if ((item instanceof TabsItem) && (item2 instanceof TabsItem)) {
            return true;
        }
        if ((item instanceof PackageTitleItem) && (item2 instanceof PackageTitleItem)) {
            return Intrinsics.areEqual(((PackageTitleItem) item).getText(), ((PackageTitleItem) item2).getText());
        }
        if (!(item instanceof EditPackageItem) || !(item2 instanceof EditPackageItem)) {
            return false;
        }
        return Intrinsics.areEqual(((EditPackageItem) item).getStringId(), ((EditPackageItem) item2).getStringId());
    }
}

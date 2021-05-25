package com.avito.android.tariff.edit_info.ui;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.tariff.edit_info.item.tabs.TabsItem;
import com.avito.android.tariff.info.item.info.InfoItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/tariff/edit_info/ui/EditInfoContentsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class EditInfoContentsComparator implements ContentsComparator {
    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        if ((item instanceof PaidServiceHeaderItem) && (item2 instanceof PaidServiceHeaderItem)) {
            PaidServiceHeaderItem paidServiceHeaderItem = (PaidServiceHeaderItem) item;
            PaidServiceHeaderItem paidServiceHeaderItem2 = (PaidServiceHeaderItem) item2;
            if (!Intrinsics.areEqual(paidServiceHeaderItem.getDescription(), paidServiceHeaderItem2.getDescription()) || !Intrinsics.areEqual(paidServiceHeaderItem.getTitle(), paidServiceHeaderItem2.getTitle())) {
                return false;
            }
            return true;
        } else if ((item instanceof TabsItem) && (item2 instanceof TabsItem)) {
            return true;
        } else {
            if (!(item instanceof InfoItem) || !(item2 instanceof InfoItem)) {
                return false;
            }
            InfoItem infoItem = (InfoItem) item;
            InfoItem infoItem2 = (InfoItem) item2;
            if (!Intrinsics.areEqual(infoItem.getDescription(), infoItem2.getDescription()) || !Intrinsics.areEqual(infoItem.getTitle(), infoItem2.getTitle())) {
                return false;
            }
            return true;
        }
    }
}

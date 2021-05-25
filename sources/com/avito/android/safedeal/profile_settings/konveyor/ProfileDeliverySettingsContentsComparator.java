package com.avito.android.safedeal.profile_settings.konveyor;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.safedeal.profile_settings.konveyor.list_item.ListItem;
import com.avito.android.safedeal.profile_settings.konveyor.switcher.SwitcherItem;
import com.avito.android.safedeal.profile_settings.konveyor.text.TextItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/safedeal/profile_settings/konveyor/ProfileDeliverySettingsContentsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileDeliverySettingsContentsComparator implements ContentsComparator {
    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        Long l = null;
        Long valueOf = item != null ? Long.valueOf(item.getId()) : null;
        if (item2 != null) {
            l = Long.valueOf(item2.getId());
        }
        if (!Intrinsics.areEqual(valueOf, l)) {
            return false;
        }
        if ((item instanceof TextItem) && (item2 instanceof TextItem)) {
            return Intrinsics.areEqual(((TextItem) item).getText(), ((TextItem) item2).getText());
        }
        if ((item instanceof SwitcherItem) && (item2 instanceof SwitcherItem)) {
            SwitcherItem switcherItem = (SwitcherItem) item;
            SwitcherItem switcherItem2 = (SwitcherItem) item2;
            if (Intrinsics.areEqual(switcherItem.getTitle(), switcherItem2.getTitle()) && Intrinsics.areEqual(switcherItem.getSubtitle(), switcherItem2.getSubtitle()) && Intrinsics.areEqual(switcherItem.getLink(), switcherItem2.getLink()) && switcherItem.isChecked() == switcherItem2.isChecked() && Intrinsics.areEqual(switcherItem.getImageRes(), switcherItem2.getImageRes())) {
                return true;
            }
        } else if ((item instanceof ListItem) && (item2 instanceof ListItem)) {
            ListItem listItem = (ListItem) item;
            ListItem listItem2 = (ListItem) item2;
            if (Intrinsics.areEqual(listItem.getTitle(), listItem2.getTitle()) && Intrinsics.areEqual(listItem.getSubtitle(), listItem2.getSubtitle()) && Intrinsics.areEqual(listItem.getLink(), listItem2.getLink()) && Intrinsics.areEqual(listItem.getImageRes(), listItem2.getImageRes())) {
                return true;
            }
        }
        return false;
    }
}

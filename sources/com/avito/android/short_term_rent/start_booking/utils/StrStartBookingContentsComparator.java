package com.avito.android.short_term_rent.start_booking.utils;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItem;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItem;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItem;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItem;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/utils/StrStartBookingContentsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingContentsComparator implements ContentsComparator {
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
        if ((item instanceof SelectItem) && (item2 instanceof SelectItem)) {
            return Intrinsics.areEqual(((SelectItem) item).getValue(), ((SelectItem) item2).getValue());
        }
        if ((item instanceof SummaryItem) && (item2 instanceof SummaryItem)) {
            SummaryItem summaryItem = (SummaryItem) item;
            SummaryItem summaryItem2 = (SummaryItem) item2;
            if (!Intrinsics.areEqual(summaryItem.getTitle(), summaryItem2.getTitle()) || !Intrinsics.areEqual(summaryItem.getDescription(), summaryItem2.getDescription())) {
                return false;
            }
            return true;
        } else if (!(item instanceof DisclaimerItem) || !(item2 instanceof DisclaimerItem)) {
            return (item instanceof GuestsCountItem) && (item2 instanceof GuestsCountItem);
        } else {
            DisclaimerItem disclaimerItem = (DisclaimerItem) item;
            return Intrinsics.areEqual(disclaimerItem.getText(), disclaimerItem.getText());
        }
    }
}

package com.avito.android.util;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.conveyor_shared_item.notification.NotificationItem;
import com.avito.android.items.InputItem;
import com.avito.android.items.MarketPriceItem;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/util/ParametersListContentsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersListContentsComparator implements ContentsComparator {
    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        Long l = null;
        if (!Intrinsics.areEqual(item != null ? Long.valueOf(item.getId()) : null, item2 != null ? Long.valueOf(item2.getId()) : null)) {
            return false;
        }
        if ((item instanceof ParameterElement.TextAreaInput) && (item2 instanceof ParameterElement.TextAreaInput)) {
            return Intrinsics.areEqual(((ParameterElement.TextAreaInput) item).getValue(), ((ParameterElement.TextAreaInput) item2).getValue());
        }
        if ((item instanceof NotificationItem) && (item2 instanceof NotificationItem)) {
            NotificationItem notificationItem = (NotificationItem) item;
            NotificationItem notificationItem2 = (NotificationItem) item2;
            if (Intrinsics.areEqual(notificationItem.getType(), notificationItem2.getType()) && Intrinsics.areEqual(notificationItem.getText(), notificationItem2.getText())) {
                return true;
            }
        } else if ((item instanceof InputItem) && (item2 instanceof InputItem)) {
            return Intrinsics.areEqual(((InputItem) item).getValue(), ((InputItem) item2).getValue());
        } else {
            if ((item instanceof ParameterElement.Select) && (item2 instanceof ParameterElement.Select)) {
                ParameterElement.Select select = (ParameterElement.Select) item;
                ParameterElement.Select select2 = (ParameterElement.Select) item2;
                if (Intrinsics.areEqual(select.getValue(), select2.getValue()) && Intrinsics.areEqual(select.getError(), select2.getError()) && select.isEnabled() == select2.isEnabled()) {
                    return true;
                }
            } else if ((item instanceof ParameterElement.Multiselect) && (item2 instanceof ParameterElement.Multiselect)) {
                ParameterElement.Multiselect multiselect = (ParameterElement.Multiselect) item;
                ParameterElement.Multiselect multiselect2 = (ParameterElement.Multiselect) item2;
                if (Intrinsics.areEqual(multiselect.getValue(), multiselect2.getValue()) && Intrinsics.areEqual(multiselect.getError(), multiselect2.getError())) {
                    return true;
                }
            } else if ((item instanceof ParameterElement.Objects) && (item2 instanceof ParameterElement.Objects)) {
                return Intrinsics.areEqual(((ParameterElement.Objects) item).getItems(), ((ParameterElement.Objects) item2).getItems());
            } else {
                if ((item instanceof ParameterElement.DateTime) && (item2 instanceof ParameterElement.DateTime)) {
                    ParameterElement.DateTime dateTime = (ParameterElement.DateTime) item;
                    ParameterElement.DateTime dateTime2 = (ParameterElement.DateTime) item2;
                    if (Intrinsics.areEqual(dateTime.getValue(), dateTime2.getValue()) && Intrinsics.areEqual(dateTime.getError(), dateTime2.getError())) {
                        return true;
                    }
                } else if ((item instanceof MarketPriceItem) && (item2 instanceof MarketPriceItem)) {
                    return Intrinsics.areEqual(item, item2);
                } else {
                    if ((item instanceof ParameterElement.DateInterval) && (item2 instanceof ParameterElement.DateInterval)) {
                        ParameterElement.DateInterval dateInterval = (ParameterElement.DateInterval) item;
                        ParameterElement.DateInterval dateInterval2 = (ParameterElement.DateInterval) item2;
                        if (areContentsTheSame(dateInterval.getStart(), dateInterval2.getStart()) && areContentsTheSame(dateInterval.getEnd(), dateInterval2.getEnd())) {
                            return true;
                        }
                    } else if (!(item instanceof ParameterElement.EditCategoryButton) || !(item2 instanceof ParameterElement.EditCategoryButton)) {
                        Long valueOf = item != null ? Long.valueOf(item.getId()) : null;
                        if (item2 != null) {
                            l = Long.valueOf(item2.getId());
                        }
                        return Intrinsics.areEqual(valueOf, l);
                    } else {
                        ParameterElement.EditCategoryButton editCategoryButton = (ParameterElement.EditCategoryButton) item;
                        ParameterElement.EditCategoryButton editCategoryButton2 = (ParameterElement.EditCategoryButton) item2;
                        if (Intrinsics.areEqual(editCategoryButton.getTitle(), editCategoryButton2.getTitle()) && Intrinsics.areEqual(editCategoryButton.getParentTitle(), editCategoryButton2.getParentTitle())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

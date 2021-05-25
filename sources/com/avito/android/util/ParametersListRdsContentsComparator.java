package com.avito.android.util;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.InputItem;
import com.avito.android.items.MarketPriceItem;
import com.avito.android.items.MarketPriceV2Item;
import com.avito.android.items.RangeItem;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.remote.model.category_parameters.DisplayingOptions;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/util/ParametersListRdsContentsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersListRdsContentsComparator implements ContentsComparator {
    @Override // com.avito.android.recycler.data_aware.ContentsComparator
    public boolean areContentsTheSame(@Nullable Item item, @Nullable Item item2) {
        Object obj = null;
        if (!Intrinsics.areEqual(item != null ? Long.valueOf(item.getId()) : null, item2 != null ? Long.valueOf(item2.getId()) : null)) {
            return false;
        }
        if ((item instanceof InputItem) && (item2 instanceof InputItem)) {
            InputItem inputItem = (InputItem) item;
            InputItem inputItem2 = (InputItem) item2;
            if (Intrinsics.areEqual(inputItem.getValue(), inputItem2.getValue()) && Intrinsics.areEqual(inputItem.getState(), inputItem2.getState())) {
                DisplayingOptions displayingOptions = inputItem.getDisplayingOptions();
                Boolean enabled = displayingOptions != null ? displayingOptions.getEnabled() : null;
                DisplayingOptions displayingOptions2 = inputItem2.getDisplayingOptions();
                if (displayingOptions2 != null) {
                    obj = displayingOptions2.getEnabled();
                }
                if (Intrinsics.areEqual(enabled, obj) && Intrinsics.areEqual(inputItem.getMotivation(), inputItem2.getMotivation())) {
                    return true;
                }
            }
        } else if ((item instanceof ParameterElement.TaggedInput) && (item2 instanceof ParameterElement.TaggedInput)) {
            ParameterElement.TaggedInput taggedInput = (ParameterElement.TaggedInput) item;
            ParameterElement.TaggedInput taggedInput2 = (ParameterElement.TaggedInput) item2;
            if (Intrinsics.areEqual(taggedInput.getValue(), taggedInput2.getValue()) && Intrinsics.areEqual(taggedInput.getState(), taggedInput2.getState())) {
                return true;
            }
        } else if ((item instanceof ParameterElement.Select) && (item2 instanceof ParameterElement.Select)) {
            ParameterElement.Select select = (ParameterElement.Select) item;
            ParameterElement.Select select2 = (ParameterElement.Select) item2;
            if (Intrinsics.areEqual(select.getValue(), select2.getValue()) && Intrinsics.areEqual(select.getState(), select2.getState()) && select.isEnabled() == select2.isEnabled()) {
                return true;
            }
        } else if ((item instanceof ParameterElement.Multiselect) && (item2 instanceof ParameterElement.Multiselect)) {
            ParameterElement.Multiselect multiselect = (ParameterElement.Multiselect) item;
            ParameterElement.Multiselect multiselect2 = (ParameterElement.Multiselect) item2;
            if (Intrinsics.areEqual(multiselect.getValue(), multiselect2.getValue()) && Intrinsics.areEqual(multiselect.getState(), multiselect2.getState())) {
                return true;
            }
        } else if ((item instanceof ParameterElement.Objects) && (item2 instanceof ParameterElement.Objects)) {
            return Intrinsics.areEqual(((ParameterElement.Objects) item).getItems(), ((ParameterElement.Objects) item2).getItems());
        } else {
            if ((item instanceof ParameterElement.DateTime) && (item2 instanceof ParameterElement.DateTime)) {
                ParameterElement.DateTime dateTime = (ParameterElement.DateTime) item;
                ParameterElement.DateTime dateTime2 = (ParameterElement.DateTime) item2;
                if (Intrinsics.areEqual(dateTime.getValue(), dateTime2.getValue()) && Intrinsics.areEqual(dateTime.getState(), dateTime2.getState())) {
                    return true;
                }
            } else if ((item instanceof ParameterElement.DateInterval) && (item2 instanceof ParameterElement.DateInterval)) {
                ParameterElement.DateInterval dateInterval = (ParameterElement.DateInterval) item;
                ParameterElement.DateInterval dateInterval2 = (ParameterElement.DateInterval) item2;
                if (areContentsTheSame(dateInterval.getStart(), dateInterval2.getStart()) && areContentsTheSame(dateInterval.getEnd(), dateInterval2.getEnd())) {
                    return true;
                }
            } else if ((item instanceof ParameterElement.EditCategoryButton) && (item2 instanceof ParameterElement.EditCategoryButton)) {
                ParameterElement.EditCategoryButton editCategoryButton = (ParameterElement.EditCategoryButton) item;
                ParameterElement.EditCategoryButton editCategoryButton2 = (ParameterElement.EditCategoryButton) item2;
                if (Intrinsics.areEqual(editCategoryButton.getTitle(), editCategoryButton2.getTitle()) && Intrinsics.areEqual(editCategoryButton.getParentTitle(), editCategoryButton2.getParentTitle())) {
                    return true;
                }
            } else if ((item instanceof ParameterElement.Photo) && (item2 instanceof ParameterElement.Photo)) {
                return Intrinsics.areEqual(((ParameterElement.Photo) item).getState(), ((ParameterElement.Photo) item2).getState());
            } else {
                if ((item instanceof MarketPriceItem) && (item2 instanceof MarketPriceItem)) {
                    return Intrinsics.areEqual(item, item2);
                }
                if ((item instanceof MarketPriceV2Item) && (item2 instanceof MarketPriceV2Item)) {
                    return Intrinsics.areEqual(item, item2);
                }
                if ((item instanceof RangeItem) && (item2 instanceof RangeItem)) {
                    return Intrinsics.areEqual(((RangeItem) item).getState(), ((RangeItem) item2).getState());
                }
                if (!(item instanceof ParameterElement.Video) || !(item2 instanceof ParameterElement.Video)) {
                    Long valueOf = item != null ? Long.valueOf(item.getId()) : null;
                    if (item2 != null) {
                        obj = Long.valueOf(item2.getId());
                    }
                    return Intrinsics.areEqual(valueOf, obj);
                }
                ParameterElement.Video video = (ParameterElement.Video) item;
                ParameterElement.Video video2 = (ParameterElement.Video) item2;
                if (Intrinsics.areEqual(video.getValue(), video2.getValue()) && Intrinsics.areEqual(video.getState(), video2.getState()) && Intrinsics.areEqual(video.getPreviewState(), video2.getPreviewState())) {
                    return true;
                }
            }
        }
        return false;
    }
}

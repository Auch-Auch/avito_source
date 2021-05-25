package com.avito.android.delivery.summary.konveyor;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.delivery.summary.konveyor.button.ButtonItem;
import com.avito.android.delivery.summary.konveyor.divider.DividerItem;
import com.avito.android.delivery.summary.konveyor.header.HeaderItem;
import com.avito.android.delivery.summary.konveyor.image.ImageItem;
import com.avito.android.delivery.summary.konveyor.link.LinkItem;
import com.avito.android.delivery.summary.konveyor.price.PriceItem;
import com.avito.android.delivery.summary.konveyor.shipment.ShipmentItem;
import com.avito.android.delivery.summary.konveyor.text.TextItem;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/DeliverySummaryContentsComparator;", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "Lcom/avito/konveyor/blueprint/Item;", InternalConstsKt.FIRST_IMAGE, "second", "", "areContentsTheSame", "(Lcom/avito/konveyor/blueprint/Item;Lcom/avito/konveyor/blueprint/Item;)Z", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliverySummaryContentsComparator implements ContentsComparator {
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
        if ((item instanceof ParameterElement.Input) && (item2 instanceof ParameterElement.Input) && Intrinsics.areEqual(((ParameterElement.Input) item).getError(), ((ParameterElement.Input) item2).getError())) {
            return true;
        }
        if ((item instanceof ImageItem) && (item2 instanceof ImageItem)) {
            ImageItem imageItem = (ImageItem) item;
            ImageItem imageItem2 = (ImageItem) item2;
            if (Intrinsics.areEqual(imageItem.getText(), imageItem2.getText()) && Intrinsics.areEqual(imageItem.getImage(), imageItem2.getImage())) {
                return true;
            }
        }
        if ((item instanceof TextItem) && (item2 instanceof TextItem)) {
            TextItem textItem = (TextItem) item;
            TextItem textItem2 = (TextItem) item2;
            if (Intrinsics.areEqual(textItem.getTitle(), textItem2.getTitle()) && Intrinsics.areEqual(textItem.getDescription(), textItem2.getDescription())) {
                return true;
            }
        }
        if ((item instanceof LinkItem) && (item2 instanceof LinkItem) && Intrinsics.areEqual(((LinkItem) item).getTitle(), ((LinkItem) item2).getTitle())) {
            return true;
        }
        if ((item instanceof DividerItem) && (item2 instanceof DividerItem)) {
            return true;
        }
        if ((item instanceof HeaderItem) && (item2 instanceof HeaderItem)) {
            HeaderItem headerItem = (HeaderItem) item;
            HeaderItem headerItem2 = (HeaderItem) item2;
            if (Intrinsics.areEqual(headerItem.getText(), headerItem2.getText()) && headerItem.getEditable() == headerItem2.getEditable() && headerItem.getAddTopMargin() == headerItem2.getAddTopMargin()) {
                return true;
            }
        }
        if ((item instanceof PriceItem) && (item2 instanceof PriceItem) && Intrinsics.areEqual(((PriceItem) item).getPrice(), ((PriceItem) item2).getPrice())) {
            return true;
        }
        if ((item instanceof ButtonItem) && (item2 instanceof ButtonItem)) {
            ButtonItem buttonItem = (ButtonItem) item;
            ButtonItem buttonItem2 = (ButtonItem) item2;
            if (Intrinsics.areEqual(buttonItem.getText(), buttonItem2.getText()) && buttonItem.isEnabled() == buttonItem2.isEnabled() && buttonItem.isLoading() == buttonItem2.isLoading()) {
                return true;
            }
        }
        if (!(item instanceof ShipmentItem) || !(item2 instanceof ShipmentItem)) {
            return false;
        }
        return Intrinsics.areEqual(item, item2);
    }
}

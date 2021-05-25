package com.avito.android.booking.remote.converter;

import com.avito.android.booking.item.description.DescriptionItem;
import com.avito.android.booking.item.padding.PaddingItem;
import com.avito.android.booking.item.picture.PictureItem;
import com.avito.android.booking.item.subtitle.SubtitleItem;
import com.avito.android.booking.item.title.TitleItem;
import com.avito.android.booking.remote.model.BookingInfoModel;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/booking/remote/converter/BookingInfoItemConverterImpl;", "Lcom/avito/android/booking/remote/converter/BookingInfoItemConverter;", "Lcom/avito/android/booking/remote/model/BookingInfoModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/booking/remote/model/BookingInfoModel;)Ljava/util/List;", "<init>", "()V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class BookingInfoItemConverterImpl implements BookingInfoItemConverter {
    @Override // com.avito.android.booking.remote.converter.BookingInfoItemConverter
    @NotNull
    public List<Item> convert(@NotNull BookingInfoModel bookingInfoModel) {
        Intrinsics.checkNotNullParameter(bookingInfoModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PictureItem(null, 1, null));
        String title = bookingInfoModel.getTitle();
        if (title != null) {
            arrayList.add(new TitleItem(null, title, 1, null));
        } else {
            arrayList.add(new PaddingItem(null, 1, null));
        }
        for (T t : bookingInfoModel.getItems()) {
            boolean z = false;
            String title2 = t.getTitle();
            if (title2 != null) {
                arrayList.add(new SubtitleItem(null, title2, 1, null));
                z = true;
            }
            String description = t.getDescription();
            if (description != null) {
                arrayList.add(new DescriptionItem(null, description, 1, null));
                z = true;
            }
            if (z) {
                arrayList.add(new PaddingItem(null, 1, null));
            }
        }
        return arrayList;
    }
}

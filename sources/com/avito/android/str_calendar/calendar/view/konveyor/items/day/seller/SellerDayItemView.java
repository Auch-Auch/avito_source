package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.seller.calendar.data.SellerDayItemState;
import com.avito.konveyor.blueprint.ItemView;
import io.reactivex.functions.Consumer;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;", "state", "Lio/reactivex/functions/Consumer;", "Ljava/util/Date;", "clickConsumer", Sort.DATE, "", "bind", "(Ljava/lang/String;Lcom/avito/android/str_calendar/seller/calendar/data/SellerDayItemState;Lio/reactivex/functions/Consumer;Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface SellerDayItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SellerDayItemView sellerDayItemView) {
            ItemView.DefaultImpls.onUnbind(sellerDayItemView);
        }
    }

    void bind(@NotNull String str, @NotNull SellerDayItemState sellerDayItemState, @NotNull Consumer<Date> consumer, @NotNull Date date);
}

package com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemView;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItemView;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/day/seller/SellerDayItem;I)V", "Lio/reactivex/functions/Consumer;", "Ljava/util/Date;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "clickConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerDayItemPresenter implements ItemPresenter<SellerDayItemView, SellerDayItem> {
    public final Consumer<Date> a;

    public SellerDayItemPresenter(@NotNull Consumer<Date> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clickConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull SellerDayItemView sellerDayItemView, @NotNull SellerDayItem sellerDayItem, int i) {
        Intrinsics.checkNotNullParameter(sellerDayItemView, "view");
        Intrinsics.checkNotNullParameter(sellerDayItem, "item");
        sellerDayItemView.bind(sellerDayItem.getText(), sellerDayItem.getState(), this.a, sellerDayItem.getDate());
    }
}

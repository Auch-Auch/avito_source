package com.avito.android.str_calendar.seller.calendar;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.konveyor.blueprint.Item;
import io.reactivex.functions.Consumer;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005¨\u0006!"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModel;", "Landroidx/lifecycle/LiveData;", "", "getShowEditParamsButton", "()Landroidx/lifecycle/LiveData;", "showEditParamsButton", "", "getOpenEditParametersScreen", "openEditParametersScreen", "Lio/reactivex/functions/Consumer;", "getClearClicksConsumer", "()Lio/reactivex/functions/Consumer;", "clearClicksConsumer", "getRefreshCalendarConsumer", "refreshCalendarConsumer", "", "getToolbarTitleChanges", "toolbarTitleChanges", "Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedRange", "()Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "Ljava/util/Date;", "getDayClicksConsumer", "dayClicksConsumer", "getEditClicksConsumer", "editClicksConsumer", "getSelectedDay", "()Ljava/util/Date;", "selectedDay", "getShowClearButtonChanges", "showClearButtonChanges", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface SellerCalendarViewModel extends BaseCalendarViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static DiffUtil.DiffResult calculateDiff(@NotNull SellerCalendarViewModel sellerCalendarViewModel, @NotNull List<? extends Item> list, @NotNull List<? extends Item> list2) {
            Intrinsics.checkNotNullParameter(list, "oldList");
            Intrinsics.checkNotNullParameter(list2, "newList");
            return BaseCalendarViewModel.DefaultImpls.calculateDiff(sellerCalendarViewModel, list, list2);
        }
    }

    @NotNull
    Consumer<Unit> getClearClicksConsumer();

    @NotNull
    Consumer<Date> getDayClicksConsumer();

    @NotNull
    Consumer<Unit> getEditClicksConsumer();

    @NotNull
    LiveData<Unit> getOpenEditParametersScreen();

    @NotNull
    Consumer<Unit> getRefreshCalendarConsumer();

    @Nullable
    Date getSelectedDay();

    @Nullable
    DateRange getSelectedRange();

    @NotNull
    LiveData<Boolean> getShowClearButtonChanges();

    @NotNull
    LiveData<Boolean> getShowEditParamsButton();

    @NotNull
    LiveData<String> getToolbarTitleChanges();
}

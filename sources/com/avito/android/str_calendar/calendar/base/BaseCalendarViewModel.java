package com.avito.android.str_calendar.calendar.base;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.str_calendar.calendar.view.CalendarItemsDiffUtilCallback;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0014R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014¨\u0006$"}, d2 = {"Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModel;", "", "", "getData", "()V", "", "Lcom/avito/konveyor/blueprint/Item;", "oldList", "newList", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "calculateDiff", "(Ljava/util/List;Ljava/util/List;)Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "onCalendarDataLoading", "Ljava/lang/Runnable;", "retryRunnable", "onCalendarDataError", "(Ljava/lang/Runnable;)V", "Landroidx/lifecycle/LiveData;", "", "getErrorMessageChanges", "()Landroidx/lifecycle/LiveData;", "errorMessageChanges", "getErrorChanges", "errorChanges", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "adapterPresenter", "getUpdateViewChanges", "updateViewChanges", "getProgressChanges", "progressChanges", "getShowContentChanges", "showContentChanges", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface BaseCalendarViewModel {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static DiffUtil.DiffResult calculateDiff(@NotNull BaseCalendarViewModel baseCalendarViewModel, @NotNull List<? extends Item> list, @NotNull List<? extends Item> list2) {
            Intrinsics.checkNotNullParameter(list, "oldList");
            Intrinsics.checkNotNullParameter(list2, "newList");
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new CalendarItemsDiffUtilCallback(list, list2));
            Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(diffCallback)");
            return calculateDiff;
        }
    }

    @NotNull
    DiffUtil.DiffResult calculateDiff(@NotNull List<? extends Item> list, @NotNull List<? extends Item> list2);

    @Nullable
    AdapterPresenter getAdapterPresenter();

    void getData();

    @NotNull
    LiveData<Runnable> getErrorChanges();

    @NotNull
    LiveData<String> getErrorMessageChanges();

    @NotNull
    LiveData<Unit> getProgressChanges();

    @NotNull
    LiveData<Unit> getShowContentChanges();

    @NotNull
    LiveData<DiffUtil.DiffResult> getUpdateViewChanges();

    void onCalendarDataError(@NotNull Runnable runnable);

    void onCalendarDataLoading();

    void setAdapterPresenter(@Nullable AdapterPresenter adapterPresenter);
}

package com.avito.android.str_calendar.calendar.base;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b:\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R.\u0010(\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0004@\u0004X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\b\u0012\u0004\u0012\u000201008\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u0015\u001a\u0004\b8\u0010\u0017¨\u0006;"}, d2 = {"Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/str_calendar/calendar/base/BaseCalendarViewModel;", "", "onCalendarDataLoading", "()V", "Ljava/lang/Runnable;", "retryRunnable", "onCalendarDataError", "(Ljava/lang/Runnable;)V", "", "Lcom/avito/konveyor/blueprint/Item;", "i", "Ljava/util/List;", "getListItems", "()Ljava/util/List;", "setListItems", "(Ljava/util/List;)V", "listItems", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getShowContentChanges", "()Landroidx/lifecycle/MutableLiveData;", "showContentChanges", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "c", "getUpdateViewChanges", "updateViewChanges", "f", "getErrorChanges", "errorChanges", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "value", "h", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "adapterPresenter", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "calendarDataSource", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "getCalendarDataSource", "()Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "setCalendarDataSource", "(Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", g.a, "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getErrorMessageChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "errorMessageChanges", "e", "getProgressChanges", "progressChanges", "<init>", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseCalendarViewModelImpl extends ViewModel implements BaseCalendarViewModel {
    @NotNull
    public final MutableLiveData<DiffUtil.DiffResult> c = new MutableLiveData<>();
    public CalendarDataSource calendarDataSource;
    @NotNull
    public final MutableLiveData<Unit> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Unit> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Runnable> f = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<String> g = new SingleLiveEvent<>();
    @Nullable
    public AdapterPresenter h;
    @NotNull
    public List<? extends Item> i = CollectionsKt__CollectionsKt.emptyList();

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public DiffUtil.DiffResult calculateDiff(@NotNull List<? extends Item> list, @NotNull List<? extends Item> list2) {
        Intrinsics.checkNotNullParameter(list, "oldList");
        Intrinsics.checkNotNullParameter(list2, "newList");
        return BaseCalendarViewModel.DefaultImpls.calculateDiff(this, list, list2);
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @Nullable
    public AdapterPresenter getAdapterPresenter() {
        return this.h;
    }

    @NotNull
    public final CalendarDataSource getCalendarDataSource() {
        CalendarDataSource calendarDataSource2 = this.calendarDataSource;
        if (calendarDataSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarDataSource");
        }
        return calendarDataSource2;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.konveyor.blueprint.Item>, java.util.List<com.avito.konveyor.blueprint.Item> */
    @NotNull
    public final List<Item> getListItems() {
        return this.i;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    public void onCalendarDataError(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "retryRunnable");
        getUpdateViewChanges().setValue(null);
        getShowContentChanges().setValue(null);
        getErrorChanges().setValue(runnable);
        getProgressChanges().setValue(null);
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    public void onCalendarDataLoading() {
        getUpdateViewChanges().setValue(null);
        getShowContentChanges().setValue(null);
        getErrorChanges().setValue(null);
        getProgressChanges().setValue(Unit.INSTANCE);
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    public void setAdapterPresenter(@Nullable AdapterPresenter adapterPresenter) {
        this.h = adapterPresenter;
        if (adapterPresenter != null) {
            adapterPresenter.onDataSourceChanged(new ListDataSource(this.i));
        }
    }

    public final void setCalendarDataSource(@NotNull CalendarDataSource calendarDataSource2) {
        Intrinsics.checkNotNullParameter(calendarDataSource2, "<set-?>");
        this.calendarDataSource = calendarDataSource2;
    }

    public final void setListItems(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.i = list;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public MutableLiveData<Runnable> getErrorChanges() {
        return this.f;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public SingleLiveEvent<String> getErrorMessageChanges() {
        return this.g;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public MutableLiveData<Unit> getProgressChanges() {
        return this.e;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public MutableLiveData<Unit> getShowContentChanges() {
        return this.d;
    }

    @Override // com.avito.android.str_calendar.calendar.base.BaseCalendarViewModel
    @NotNull
    public MutableLiveData<DiffUtil.DiffResult> getUpdateViewChanges() {
        return this.c;
    }
}

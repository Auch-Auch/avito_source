package com.avito.android.inline_filters.dialog.calendar;

import a2.a.a.g1.e.b.b;
import a2.a.a.g1.e.b.c;
import a2.a.a.g1.e.b.d;
import a2.a.a.g1.e.b.e;
import a2.a.a.g1.e.b.f;
import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.inline_filters.di.DaggerInlineFilterCalendarComponent;
import com.avito.android.inline_filters.di.InlineFilterCalendarComponent;
import com.avito.android.inline_filters.dialog.InlineFilterDialog;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModel;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.serp_core.R;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
import com.avito.android.str_calendar.di.component.StrBookingCalendarDependencies;
import com.avito.android.util.Contexts;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002BR\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012!\u0010F\u001a\u001d\u0012\u0013\u0012\u00110@¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00030?\u0012\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030G\u0012\u0006\u00107\u001a\u000204\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\\\u0010]J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R1\u0010F\u001a\u001d\u0012\u0013\u0012\u00110@¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00030?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010IR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarDialog;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "Landroidx/lifecycle/LifecycleOwner;", "", "show", "()V", "dismiss", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Landroid/app/Activity;", g.a, "Landroid/app/Activity;", "activity", "Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel;", "calendarViewModel", "Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel;", "getCalendarViewModel", "()Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel;", "setCalendarViewModel", "(Lcom/avito/android/inline_filters/dialog/calendar/InlineFiltersCalendarViewModel;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/remote/model/search/Filter;", "j", "Lcom/avito/android/remote/model/search/Filter;", "filter", "k", "Landroid/os/Parcelable;", "state", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "d", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "calendarDialog", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "h", "Lkotlin/jvm/functions/Function1;", "selectedItemListener", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "closeListener", "Landroidx/lifecycle/LifecycleRegistry;", "e", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "i", "externalCloseListener", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "closeClicksSubscription", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/avito/android/remote/model/search/Filter;Landroid/os/Parcelable;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersCalendarDialog extends InlineFilterDialog implements LifecycleOwner {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public Disposable c;
    @Inject
    public InlineFiltersCalendarViewModel calendarViewModel;
    public BottomSheetDialog d;
    @Inject
    public DeviceMetrics deviceMetrics;
    public final LifecycleRegistry e = new LifecycleRegistry(this);
    public final Function0<Unit> f = new a(this);
    @Inject
    public Features features;
    public final Activity g;
    public final Function1<InlineFilterValue, Unit> h;
    public final Function0<Unit> i;
    @Inject
    public ItemBinder itemBinder;
    public final Filter j;
    public final Parcelable k;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InlineFiltersCalendarDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
            super(0);
            this.a = inlineFiltersCalendarDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i.invoke();
            this.a.dismiss();
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.remote.model.search.InlineFilterValue, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineFiltersCalendarDialog(@NotNull Activity activity, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Filter filter, @Nullable Parcelable parcelable) {
        super(activity, 0, 2, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "externalCloseListener");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.g = activity;
        this.h = function1;
        this.i = function0;
        this.j = filter;
        this.k = parcelable;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialog
    public void dismiss() {
        this.e.setCurrentState(Lifecycle.State.DESTROYED);
        this.c.dispose();
        BottomSheetDialog bottomSheetDialog = this.d;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
        this.d = null;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final InlineFiltersCalendarViewModel getCalendarViewModel() {
        InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel = this.calendarViewModel;
        if (inlineFiltersCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        return inlineFiltersCalendarViewModel;
    }

    @NotNull
    public final DeviceMetrics getDeviceMetrics() {
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        return deviceMetrics2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.e;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialog
    @Nullable
    public Parcelable onSaveState() {
        InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel = this.calendarViewModel;
        if (inlineFiltersCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        InlineFiltersCalendarViewModel.Dates currentDates = inlineFiltersCalendarViewModel.getCurrentDates();
        return new InlineFilterValue.InlineFilterDateRangeValue(currentDates.getFrom(), currentDates.getTo());
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCalendarViewModel(@NotNull InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel) {
        Intrinsics.checkNotNullParameter(inlineFiltersCalendarViewModel, "<set-?>");
        this.calendarViewModel = inlineFiltersCalendarViewModel;
    }

    public final void setDeviceMetrics(@NotNull DeviceMetrics deviceMetrics2) {
        Intrinsics.checkNotNullParameter(deviceMetrics2, "<set-?>");
        this.deviceMetrics = deviceMetrics2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialog
    public void show() {
        InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue = (InlineFilterValue.InlineFilterDateRangeValue) this.j.getValue();
        InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue2 = (InlineFilterValue.InlineFilterDateRangeValue) this.k;
        if (inlineFilterDateRangeValue2 != null) {
            inlineFilterDateRangeValue = inlineFilterDateRangeValue2;
        }
        Filter.Widget widget = this.j.getWidget();
        InlineFilterCalendarComponent.Builder builder = DaggerInlineFilterCalendarComponent.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "DaggerInlineFilterCalendarComponent.builder()");
        InlineFilterCalendarComponent.Builder bookingCalendarDependencies = builder.bookingCalendarDependencies((StrBookingCalendarDependencies) ComponentDependenciesKt.getDependencies(StrBookingCalendarDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this.g)));
        Resources resources = this.g.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        InlineFilterCalendarComponent.Builder bindWidget = bookingCalendarDependencies.resources(resources).checkInDate(inlineFilterDateRangeValue != null ? inlineFilterDateRangeValue.getFrom() : null).checkOutDate(inlineFilterDateRangeValue != null ? inlineFilterDateRangeValue.getTo() : null).bindValue(inlineFilterDateRangeValue).bindWidget(widget);
        String title = this.j.getTitle();
        if (title == null) {
            title = "";
        }
        bindWidget.bindTitle(title).build().inject(this);
        View inflate = LayoutInflater.from(this.g).inflate(R.layout.inline_filters_calendar_view, (ViewGroup) null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.g, 0, 2, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        bottomSheetDialog.setContentView(inflate, false);
        bottomSheetDialog.setSkipCollapsed(true);
        bottomSheetDialog.setForceExpandedState(true);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        Context context = bottomSheetDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setPeekHeight(Contexts.getDisplayHeight(context));
        View findViewById = bottomSheetDialog.findViewById(R.id.inline_filters_calendar_dialog_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        CalendarViewImpl calendarViewImpl = new CalendarViewImpl(analytics2, findViewById, adapterPresenter2, itemBinder2, this, deviceMetrics2, new InlineFiltersCalendarHeaderView(findViewById));
        InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel = this.calendarViewModel;
        if (inlineFiltersCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        calendarViewImpl.bindTo(inlineFiltersCalendarViewModel);
        InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel2 = this.calendarViewModel;
        if (inlineFiltersCalendarViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        AdapterPresenter adapterPresenter3 = this.adapterPresenter;
        if (adapterPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        inlineFiltersCalendarViewModel2.setAdapterPresenter(adapterPresenter3);
        InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel3 = this.calendarViewModel;
        if (inlineFiltersCalendarViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        inlineFiltersCalendarViewModel3.getDatesChosenChanges().observe(this, new a2.a.a.g1.e.b.a(this));
        InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel4 = this.calendarViewModel;
        if (inlineFiltersCalendarViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        inlineFiltersCalendarViewModel4.getEmptyDatesSelected().observe(this, new b(this));
        Disposable subscribe = calendarViewImpl.getCloseClicks().subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "calendarView.closeClicks…loseListener()\n        })");
        this.c = subscribe;
        bottomSheetDialog.setOnCancelListener(new e(this));
        bottomSheetDialog.setOnDismissListener(new f(this));
        this.e.setCurrentState(Lifecycle.State.RESUMED);
        bottomSheetDialog.show();
        this.d = bottomSheetDialog;
    }
}

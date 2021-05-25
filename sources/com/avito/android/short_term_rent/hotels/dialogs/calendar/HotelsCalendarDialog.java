package com.avito.android.short_term_rent.hotels.dialogs.calendar;

import a2.a.a.v2.b.i.a.b;
import a2.a.a.v2.b.i.a.c;
import a2.a.a.v2.b.i.a.d;
import a2.a.a.v2.b.i.a.e;
import a2.a.a.v2.b.i.a.f;
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
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.di.component.DaggerHotelsFilterCalendarComponent;
import com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent;
import com.avito.android.short_term_rent.hotels.data.HotelsCalendarRestrictions;
import com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModel;
import com.avito.android.str_calendar.booking.CalendarViewImpl;
import com.avito.android.str_calendar.di.component.StrBookingCalendarDependencies;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.util.Contexts;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B^\u0012\u0006\u0010&\u001a\u00020#\u0012#\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000102¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00030C\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030.\u0012\u0006\u00105\u001a\u000202\u0012\b\u0010P\u001a\u0004\u0018\u00010M\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b_\u0010`J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00100R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR3\u0010I\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000102¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00030C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006a"}, d2 = {"Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsCalendarDialog;", "Lcom/avito/android/short_term_rent/hotels/dialogs/HotelsFiltersDialog;", "Landroidx/lifecycle/LifecycleOwner;", "", "show", "()V", "dismiss", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "closeClicksSubscription", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "d", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "calendarDialog", "Landroid/app/Activity;", g.a, "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "closeListener", "Lcom/avito/android/str_calendar/utils/DateRange;", "j", "Lcom/avito/android/str_calendar/utils/DateRange;", "value", "i", "externalCloseListener", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Landroidx/lifecycle/LifecycleRegistry;", "e", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectedValue", "h", "Lkotlin/jvm/functions/Function1;", "selectedItemListener", "l", "Landroid/os/Parcelable;", "state", "Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "k", "Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;", "restrictions", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;", "calendarViewModel", "Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;", "getCalendarViewModel", "()Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;", "setCalendarViewModel", "(Lcom/avito/android/short_term_rent/hotels/dialogs/calendar/HotelsFiltersCalendarViewModel;)V", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/avito/android/str_calendar/utils/DateRange;Lcom/avito/android/short_term_rent/hotels/data/HotelsCalendarRestrictions;Landroid/os/Parcelable;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class HotelsCalendarDialog extends HotelsFiltersDialog implements LifecycleOwner {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public Disposable c;
    @Inject
    public HotelsFiltersCalendarViewModel calendarViewModel;
    public BottomSheetDialog d;
    @Inject
    public DeviceMetrics deviceMetrics;
    public final LifecycleRegistry e = new LifecycleRegistry(this);
    public final Function0<Unit> f = new a(this);
    @Inject
    public Features features;
    public final Activity g;
    public final Function1<DateRange, Unit> h;
    public final Function0<Unit> i;
    @Inject
    public ItemBinder itemBinder;
    public final DateRange j;
    public final HotelsCalendarRestrictions k;
    public final Parcelable l;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ HotelsCalendarDialog a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(HotelsCalendarDialog hotelsCalendarDialog) {
            super(0);
            this.a = hotelsCalendarDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.i.invoke();
            this.a.dismiss();
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.str_calendar.utils.DateRange, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotelsCalendarDialog(@NotNull Activity activity, @NotNull Function1<? super DateRange, Unit> function1, @NotNull Function0<Unit> function0, @NotNull DateRange dateRange, @Nullable HotelsCalendarRestrictions hotelsCalendarRestrictions, @Nullable Parcelable parcelable) {
        super(activity, 0, 2, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "externalCloseListener");
        Intrinsics.checkNotNullParameter(dateRange, "value");
        this.g = activity;
        this.h = function1;
        this.i = function0;
        this.j = dateRange;
        this.k = hotelsCalendarRestrictions;
        this.l = parcelable;
        Disposable empty = Disposables.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Disposables.empty()");
        this.c = empty;
    }

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog
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
    public final HotelsFiltersCalendarViewModel getCalendarViewModel() {
        HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel = this.calendarViewModel;
        if (hotelsFiltersCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        return hotelsFiltersCalendarViewModel;
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

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog
    @Nullable
    public Parcelable onSaveState() {
        HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel = this.calendarViewModel;
        if (hotelsFiltersCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        HotelsFiltersCalendarViewModel.Dates currentDates = hotelsFiltersCalendarViewModel.getCurrentDates();
        Date from = currentDates.getFrom();
        if (from == null) {
            from = new Date(0);
        }
        Date to = currentDates.getTo();
        if (to == null) {
            to = new Date(0);
        }
        return new DateRange(from, to);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCalendarViewModel(@NotNull HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel) {
        Intrinsics.checkNotNullParameter(hotelsFiltersCalendarViewModel, "<set-?>");
        this.calendarViewModel = hotelsFiltersCalendarViewModel;
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

    @Override // com.avito.android.short_term_rent.hotels.dialogs.HotelsFiltersDialog
    public void show() {
        DateRange dateRange = this.j;
        DateRange dateRange2 = (DateRange) this.l;
        if (dateRange2 != null) {
            dateRange = dateRange2;
        }
        HotelsFilterCalendarComponent.Builder builder = DaggerHotelsFilterCalendarComponent.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "DaggerHotelsFilterCalendarComponent.builder()");
        HotelsFilterCalendarComponent.Builder bookingCalendarDependencies = builder.bookingCalendarDependencies((StrBookingCalendarDependencies) ComponentDependenciesKt.getDependencies(StrBookingCalendarDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this.g)));
        Resources resources = this.g.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        HotelsFilterCalendarComponent.Builder bindRestrictions = bookingCalendarDependencies.resources(resources).checkInDate(dateRange.getStart()).checkOutDate(dateRange.getEndInclusive()).bindValue(dateRange).bindRestrictions(this.k);
        String string = this.g.getResources().getString(R.string.hotels_calendar_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt…ls_calendar_dialog_title)");
        bindRestrictions.bindTitle(string).build().inject(this);
        View inflate = LayoutInflater.from(this.g).inflate(R.layout.hotels_filters_calendar_view, (ViewGroup) null);
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
        CalendarViewImpl calendarViewImpl = new CalendarViewImpl(analytics2, findViewById, adapterPresenter2, itemBinder2, this, deviceMetrics2, new HotelsCalendarHeaderView(findViewById));
        HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel = this.calendarViewModel;
        if (hotelsFiltersCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        calendarViewImpl.bindTo(hotelsFiltersCalendarViewModel);
        HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel2 = this.calendarViewModel;
        if (hotelsFiltersCalendarViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        AdapterPresenter adapterPresenter3 = this.adapterPresenter;
        if (adapterPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        hotelsFiltersCalendarViewModel2.setAdapterPresenter(adapterPresenter3);
        HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel3 = this.calendarViewModel;
        if (hotelsFiltersCalendarViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        hotelsFiltersCalendarViewModel3.getDatesChosenChanges().observe(this, new a2.a.a.v2.b.i.a.a(this));
        HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel4 = this.calendarViewModel;
        if (hotelsFiltersCalendarViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        hotelsFiltersCalendarViewModel4.getEmptyDatesSelected().observe(this, new b(this));
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

package com.avito.android.str_calendar.booking;

import a2.a.a.b3.a.b;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.di.component.DaggerStrBookingCalendarComponent;
import com.avito.android.str_calendar.di.component.StrBookingCalendarComponent;
import com.avito.android.str_calendar.di.component.StrBookingCalendarDependencies;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Date;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b@\u0010AJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "calendarViewModel", "Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "getCalendarViewModel", "()Lcom/avito/android/str_calendar/booking/CalendarViewModel;", "setCalendarViewModel", "(Lcom/avito/android/str_calendar/booking/CalendarViewModel;)V", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "()V", "Factory", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarFragment extends BaseFragment {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public final CompositeDisposable c = new CompositeDisposable();
    @Inject
    public CalendarViewModel calendarViewModel;
    @Inject
    public DeviceMetrics deviceMetrics;
    @Inject
    public Features features;
    @Inject
    public ItemBinder itemBinder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Ljava/util/Date;", "checkInDate", "checkOutDate", "Lcom/avito/android/str_calendar/booking/CalendarFragment;", "createInstance", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)Lcom/avito/android/str_calendar/booking/CalendarFragment;", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final CalendarFragment createInstance(@Nullable String str, @Nullable Date date, @Nullable Date date2) {
            Bundle bundle = new Bundle(3);
            bundle.putString("advert_id", str);
            bundle.putSerializable(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE, date);
            bundle.putSerializable(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, date2);
            CalendarFragment calendarFragment = new CalendarFragment();
            calendarFragment.setArguments(bundle);
            return calendarFragment;
        }
    }

    public static final class a<T> implements Observer<DateRange> {
        public final /* synthetic */ CalendarFragment a;

        public a(CalendarFragment calendarFragment) {
            this.a = calendarFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DateRange dateRange) {
            DateRange dateRange2 = dateRange;
            if (dateRange2 != null) {
                CalendarFragment.access$closeWithSelectedDates(this.a, dateRange2);
            }
        }
    }

    public static final void access$closeWithSelectedDates(CalendarFragment calendarFragment, DateRange dateRange) {
        Objects.requireNonNull(calendarFragment);
        Intent putExtra = new Intent().putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE, dateRange.getStart()).putExtra(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, dateRange.getEndInclusive());
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n            .pu…lectedRange.endInclusive)");
        FragmentActivity activity = calendarFragment.getActivity();
        if (activity != null) {
            activity.setResult(-1, putExtra);
        }
        FragmentActivity activity2 = calendarFragment.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
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
    public final CalendarViewModel getCalendarViewModel() {
        CalendarViewModel calendarViewModel2 = this.calendarViewModel;
        if (calendarViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        return calendarViewModel2;
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

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.calendar_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        CalendarViewModel calendarViewModel2 = this.calendarViewModel;
        if (calendarViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        calendarViewModel2.getDatesChosenChanges().observe(getViewLifecycleOwner(), new a(this));
        CalendarViewModel calendarViewModel3 = this.calendarViewModel;
        if (calendarViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        calendarViewModel3.setAdapterPresenter(adapterPresenter2);
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        AdapterPresenter adapterPresenter3 = this.adapterPresenter;
        if (adapterPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner()");
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        CalendarViewImpl calendarViewImpl = new CalendarViewImpl(analytics2, view, adapterPresenter3, itemBinder2, viewLifecycleOwner, deviceMetrics2, new CalendarHeaderViewImpl(view));
        CalendarViewModel calendarViewModel4 = this.calendarViewModel;
        if (calendarViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("calendarViewModel");
        }
        calendarViewImpl.bindTo(calendarViewModel4);
        Disposable subscribe = calendarViewImpl.getCloseClicks().subscribe(new a2.a.a.b3.a.a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "calendarView.closeClicks…error(it) }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCalendarViewModel(@NotNull CalendarViewModel calendarViewModel2) {
        Intrinsics.checkNotNullParameter(calendarViewModel2, "<set-?>");
        this.calendarViewModel = calendarViewModel2;
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

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…tion(\"Arguments not set\")");
            String string = arguments.getString("advert_id");
            StrBookingCalendarComponent.Builder bookingCalendarDependencies = DaggerStrBookingCalendarComponent.builder().bookingCalendarDependencies((StrBookingCalendarDependencies) ComponentDependenciesKt.getDependencies(StrBookingCalendarDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            bookingCalendarDependencies.resources(resources).viewModelFragment(this).advertId(string).checkInDate((Date) arguments.getSerializable(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE)).checkOutDate((Date) arguments.getSerializable(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE)).build().inject(this);
            return true;
        }
        throw new IllegalStateException("Arguments not set");
    }
}

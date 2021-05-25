package com.avito.android.short_term_rent.start_booking;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.StrStartBookingDeepLinkKt;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingActivityKt;
import com.avito.android.short_term_rent.confirm_booking.event.ConfirmBookingEvent;
import com.avito.android.short_term_rent.di.component.DaggerStrStartBookingComponent;
import com.avito.android.short_term_rent.di.component.StrStartBookingComponent;
import com.avito.android.short_term_rent.di.component.StrStartBookingDependencies;
import com.avito.android.short_term_rent.start_booking.StrStartBookingView;
import com.avito.android.short_term_rent.utils.StrDateUtilsKt;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.str_calendar.booking.CalendarActivityKt;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\bB\u0010\u001eJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006D"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingView$Listener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "fragmentView", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onCloseClicked", "()V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "viewModel", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "getViewModel", "()Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;", "setViewModel", "(Lcom/avito/android/short_term_rent/start_booking/StrStartBookingViewModel;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "Factory", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrStartBookingFragment extends BaseFragment implements StrStartBookingView.Listener {
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public StrStartBookingViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJC\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/StrStartBookingFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "source", "checkInDate", "checkOutDate", "", "showCalendar", "workflow", "Lcom/avito/android/short_term_rent/start_booking/StrStartBookingFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/avito/android/short_term_rent/start_booking/StrStartBookingFragment;", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final StrStartBookingFragment createInstance(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, boolean z, @Nullable String str5) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(str2, "source");
            Bundle bundle = new Bundle(4);
            bundle.putString("advert_id", str);
            bundle.putString("source", str2);
            bundle.putBoolean("show_calendar", z);
            if (str3 != null) {
                bundle.putString(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE, str3);
            }
            if (str4 != null) {
                bundle.putString(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, str4);
            }
            if (str5 != null) {
                bundle.putString("workflow", str5);
            }
            StrStartBookingFragment strStartBookingFragment = new StrStartBookingFragment();
            strStartBookingFragment.setArguments(bundle);
            return strStartBookingFragment;
        }
    }

    public static final class a<T> implements Observer<ConfirmBookingEvent> {
        public final /* synthetic */ StrStartBookingFragment a;

        public a(StrStartBookingFragment strStartBookingFragment) {
            this.a = strStartBookingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(ConfirmBookingEvent confirmBookingEvent) {
            ConfirmBookingEvent confirmBookingEvent2 = confirmBookingEvent;
            if (confirmBookingEvent2 != null) {
                StrStartBookingFragment.access$openConfirmBookingActivity(this.a, confirmBookingEvent2);
            }
        }
    }

    public static final class b<T> implements Observer<Unit> {
        public final /* synthetic */ StrStartBookingFragment a;

        public b(StrStartBookingFragment strStartBookingFragment) {
            this.a = strStartBookingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            if (unit != null) {
                StrStartBookingFragment strStartBookingFragment = this.a;
                strStartBookingFragment.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(strStartBookingFragment.getIntentFactory(), null, "r", null, 5, null), 1);
            }
        }
    }

    public static final class c<T> implements Observer<Triple<? extends String, ? extends Date, ? extends Date>> {
        public final /* synthetic */ StrStartBookingFragment a;

        public c(StrStartBookingFragment strStartBookingFragment) {
            this.a = strStartBookingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Triple<? extends String, ? extends Date, ? extends Date> triple) {
            Context context;
            Triple<? extends String, ? extends Date, ? extends Date> triple2 = triple;
            if (triple2 != null && (context = this.a.getContext()) != null) {
                this.a.startActivityForResult(CalendarActivityKt.createBookingCalendarIntent(context, (String) triple2.getFirst(), (Date) triple2.getSecond(), (Date) triple2.getThird()), 2);
            }
        }
    }

    public static final void access$openConfirmBookingActivity(StrStartBookingFragment strStartBookingFragment, ConfirmBookingEvent confirmBookingEvent) {
        Context requireContext = strStartBookingFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        String advertId = confirmBookingEvent.getAdvertId();
        String checkInDate = confirmBookingEvent.getCheckInDate();
        String checkOutDate = confirmBookingEvent.getCheckOutDate();
        int guestsCount = confirmBookingEvent.getGuestsCount();
        Bundle arguments = strStartBookingFragment.getArguments();
        strStartBookingFragment.startActivity(StrConfirmBookingActivityKt.createConfirmBookingIntent(requireContext, advertId, checkInDate, checkOutDate, guestsCount, arguments != null ? arguments.getString("workflow") : null));
    }

    @NotNull
    public final DataAwareAdapterPresenter getAdapterPresenter() {
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return dataAwareAdapterPresenter;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final StrStartBookingViewModel getViewModel() {
        StrStartBookingViewModel strStartBookingViewModel = this.viewModel;
        if (strStartBookingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return strStartBookingViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                StrStartBookingViewModel strStartBookingViewModel = this.viewModel;
                if (strStartBookingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                if (i2 != -1) {
                    z = false;
                }
                strStartBookingViewModel.onDatesSelected(z, intent);
            }
        } else if (i2 == -1) {
            StrStartBookingViewModel strStartBookingViewModel2 = this.viewModel;
            if (strStartBookingViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            strStartBookingViewModel2.onAuthCompleted();
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Override // com.avito.android.short_term_rent.start_booking.StrStartBookingView.Listener
    public void onCloseClicked() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.start_booking_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        StrStartBookingViewModel strStartBookingViewModel = this.viewModel;
        if (strStartBookingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strStartBookingViewModel.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "fragmentView");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            StrStartBookingViewModel strStartBookingViewModel = this.viewModel;
            if (strStartBookingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            strStartBookingViewModel.onRestoreInstanceState(bundle);
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("workflow") : null;
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        StrStartBookingViewImpl strStartBookingViewImpl = new StrStartBookingViewImpl(view, simpleRecyclerAdapter, this, this, Intrinsics.areEqual(string, StrStartBookingDeepLinkKt.WORKFLOW_POST_PAID));
        StrStartBookingViewModel strStartBookingViewModel2 = this.viewModel;
        if (strStartBookingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strStartBookingViewImpl.bindTo(strStartBookingViewModel2);
        Unit unit = Unit.INSTANCE;
        StrStartBookingViewModel strStartBookingViewModel3 = this.viewModel;
        if (strStartBookingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        strStartBookingViewModel3.setAdapterPresenter(dataAwareAdapterPresenter);
        StrStartBookingViewModel strStartBookingViewModel4 = this.viewModel;
        if (strStartBookingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strStartBookingViewModel4.getNextButtonClicks().observe(getViewLifecycleOwner(), new a(this));
        StrStartBookingViewModel strStartBookingViewModel5 = this.viewModel;
        if (strStartBookingViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strStartBookingViewModel5.getAuthScreenChanges().observe(getViewLifecycleOwner(), new b(this));
        StrStartBookingViewModel strStartBookingViewModel6 = this.viewModel;
        if (strStartBookingViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strStartBookingViewModel6.getSelectDatesChanges().observe(getViewLifecycleOwner(), new c(this));
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…tion(\"Arguments not set\")");
            String string = arguments.getString("advert_id");
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "arguments.getString(EXTR…ption(\"advertId not set\")");
                String string2 = arguments.getString("source");
                if (string2 != null) {
                    Intrinsics.checkNotNullExpressionValue(string2, "arguments.getString(EXTR…ception(\"source not set\")");
                    String string3 = arguments.getString(StrCalendarActivityInteractionConstants.EXTRA_CHECK_IN_DATE);
                    Date date = null;
                    Date convertStrDateToDate = string3 != null ? StrDateUtilsKt.convertStrDateToDate(string3) : null;
                    String string4 = arguments.getString(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE);
                    if (string4 != null) {
                        date = StrDateUtilsKt.convertStrDateToDate(string4);
                    }
                    boolean z = arguments.getBoolean("show_calendar", false);
                    String string5 = arguments.getString("workflow");
                    StrStartBookingComponent.Builder startBookingDependencies = DaggerStrStartBookingComponent.builder().startBookingDependencies((StrStartBookingDependencies) ComponentDependenciesKt.getDependencies(StrStartBookingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
                    Resources resources = getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    startBookingDependencies.resources(resources).viewModelFragment(this).advertId(string).source(string2).checkInDate(convertStrDateToDate).checkOutDate(date).showCalendar(z).workflow(string5).build().inject(this);
                    return true;
                }
                throw new IllegalStateException("source not set");
            }
            throw new IllegalStateException("advertId not set");
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull StrStartBookingViewModel strStartBookingViewModel) {
        Intrinsics.checkNotNullParameter(strStartBookingViewModel, "<set-?>");
        this.viewModel = strStartBookingViewModel;
    }
}

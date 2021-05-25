package com.avito.android.str_calendar.seller.calendar;

import a2.a.a.b3.c.a.a;
import a2.a.a.b3.c.a.b;
import a2.a.a.b3.c.a.c;
import a2.a.a.b3.c.a.d;
import a2.a.a.b3.c.a.e;
import a2.a.a.b3.c.a.f;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.di.component.DaggerStrSellerCalendarComponent;
import com.avito.android.str_calendar.di.component.StrSellerCalendarComponent;
import com.avito.android.str_calendar.di.component.StrSellerCalendarDependencies;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\bK\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Lio/reactivex/disposables/CompositeDisposable;", "e", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "", "d", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "resourceProvider", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "getResourceProvider", "()Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;", "setResourceProvider", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarResourceProvider;)V", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "viewModel", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "getViewModel", "()Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;", "setViewModel", "(Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarViewModel;)V", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarView;", "c", "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarView;", "calendarView", "Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "router", "Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "getRouter", "()Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "setRouter", "(Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Factory", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarFragment extends BaseFragment {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public SellerCalendarView c;
    public String d;
    public final CompositeDisposable e = new CompositeDisposable();
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SellerCalendarResourceProvider resourceProvider;
    @Inject
    public SellerCalendarRouter router;
    @Inject
    public SellerCalendarViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarFragment;", "createInstance", "(Ljava/lang/String;)Lcom/avito/android/str_calendar/seller/calendar/SellerCalendarFragment;", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final SellerCalendarFragment createInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Bundle bundle = new Bundle(1);
            bundle.putString("advert_id", str);
            SellerCalendarFragment sellerCalendarFragment = new SellerCalendarFragment();
            sellerCalendarFragment.setArguments(bundle);
            return sellerCalendarFragment;
        }
    }

    public static final /* synthetic */ String access$getAdvertId$p(SellerCalendarFragment sellerCalendarFragment) {
        String str = sellerCalendarFragment.d;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
        }
        return str;
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final SellerCalendarResourceProvider getResourceProvider() {
        SellerCalendarResourceProvider sellerCalendarResourceProvider = this.resourceProvider;
        if (sellerCalendarResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return sellerCalendarResourceProvider;
    }

    @NotNull
    public final SellerCalendarRouter getRouter() {
        SellerCalendarRouter sellerCalendarRouter = this.router;
        if (sellerCalendarRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return sellerCalendarRouter;
    }

    @NotNull
    public final SellerCalendarViewModel getViewModel() {
        SellerCalendarViewModel sellerCalendarViewModel = this.viewModel;
        if (sellerCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return sellerCalendarViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.seller_calendar_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SellerCalendarRouter sellerCalendarRouter = this.router;
        if (sellerCalendarRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        Disposable subscribe = sellerCalendarRouter.getUpdateSellerCalendarObservable().filter(a.a).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "router.updateSellerCalen…error(it) }\n            )");
        DisposableKt.addTo(subscribe, this.e);
        SellerCalendarView sellerCalendarView = this.c;
        if (sellerCalendarView != null) {
            Disposable subscribe2 = sellerCalendarView.getCloseClicks().subscribe(new d(this), e.a);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "calendarView.closeClicks…error(it) }\n            )");
            DisposableKt.addTo(subscribe2, this.e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.e.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SellerCalendarViewModel sellerCalendarViewModel = this.viewModel;
        if (sellerCalendarViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        sellerCalendarViewModel.setAdapterPresenter(adapterPresenter2);
        SellerCalendarViewModel sellerCalendarViewModel2 = this.viewModel;
        if (sellerCalendarViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        sellerCalendarViewModel2.getOpenEditParametersScreen().observe(getViewLifecycleOwner(), new f(this));
        ViewGroup viewGroup = (ViewGroup) view;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
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
        SellerCalendarResourceProvider sellerCalendarResourceProvider = this.resourceProvider;
        if (sellerCalendarResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        SellerCalendarViewImpl sellerCalendarViewImpl = new SellerCalendarViewImpl(viewGroup, viewLifecycleOwner, analytics2, adapterPresenter3, itemBinder2, sellerCalendarResourceProvider);
        SellerCalendarViewModel sellerCalendarViewModel3 = this.viewModel;
        if (sellerCalendarViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        sellerCalendarViewImpl.bindTo(sellerCalendarViewModel3);
        this.c = sellerCalendarViewImpl;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setResourceProvider(@NotNull SellerCalendarResourceProvider sellerCalendarResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarResourceProvider, "<set-?>");
        this.resourceProvider = sellerCalendarResourceProvider;
    }

    public final void setRouter(@NotNull SellerCalendarRouter sellerCalendarRouter) {
        Intrinsics.checkNotNullParameter(sellerCalendarRouter, "<set-?>");
        this.router = sellerCalendarRouter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…tion(\"Arguments not set\")");
            String string = arguments.getString("advert_id");
            if (string != null) {
                this.d = string;
                StrSellerCalendarComponent.Builder sellerCalendarDependencies = DaggerStrSellerCalendarComponent.builder().sellerCalendarDependencies((StrSellerCalendarDependencies) ComponentDependenciesKt.getDependencies(StrSellerCalendarDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                StrSellerCalendarComponent.Builder viewModelFragment = sellerCalendarDependencies.resources(resources).viewModelFragment(this);
                String str = this.d;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
                }
                StrSellerCalendarComponent.Builder advertId = viewModelFragment.advertId(str);
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.str_calendar.seller.SellerCalendarRouter");
                advertId.router((SellerCalendarRouter) activity).build().inject(this);
                return true;
            }
            throw new IllegalStateException("advertId not set");
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull SellerCalendarViewModel sellerCalendarViewModel) {
        Intrinsics.checkNotNullParameter(sellerCalendarViewModel, "<set-?>");
        this.viewModel = sellerCalendarViewModel;
    }
}

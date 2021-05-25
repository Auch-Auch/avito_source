package com.avito.android.str_calendar.seller.edit;

import a2.a.a.b3.c.b.a;
import a2.a.a.b3.c.b.b;
import a2.g.r.g;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.str_calendar.R;
import com.avito.android.str_calendar.di.component.DaggerStrSellerCalendarParametersComponent;
import com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent;
import com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001cB\u0007¢\u0006\u0004\bb\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001aR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010;R\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR:\u0010]\u001a&\u0012\f\u0012\n Z*\u0004\u0018\u00010\u00040\u0004 Z*\u0012\u0012\f\u0012\n Z*\u0004\u0018\u00010\u00040\u0004\u0018\u00010Y0Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006d"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "transit", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "(IZI)Landroid/view/animation/Animation;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroyView", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "router", "Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "getRouter", "()Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;", "setRouter", "(Lcom/avito/android/str_calendar/seller/SellerCalendarRouter;)V", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "viewModel", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "getViewModel", "()Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;", "setViewModel", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersViewModel;)V", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "resourceProvider", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "getResourceProvider", "()Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;", "setResourceProvider", "(Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParamsResourceProvider;)V", "Ljava/util/Date;", "d", "Ljava/util/Date;", "startDate", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersView;", "f", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersView;", "parametersView", "e", "endDate", "", "c", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "kotlin.jvm.PlatformType", "i", "Lcom/jakewharton/rxrelay2/BehaviorRelay;", "keyboardVisibilityRelay", "Lio/reactivex/disposables/Disposable;", "h", "Lio/reactivex/disposables/Disposable;", "keyboardVisibilitySubscription", "<init>", "Factory", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCalendarParametersFragment extends BaseFragment {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public String c;
    public Date d;
    public Date e;
    public SellerCalendarParametersView f;
    public final CompositeDisposable g = new CompositeDisposable();
    public Disposable h;
    public final BehaviorRelay<Boolean> i = BehaviorRelay.createDefault(Boolean.FALSE);
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SellerCalendarParamsResourceProvider resourceProvider;
    @Inject
    public SellerCalendarRouter router;
    @Inject
    public SellerCalendarParametersViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "Ljava/util/Date;", "startDate", "endDate", "Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersFragment;", "createInstance", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)Lcom/avito/android/str_calendar/seller/edit/SellerCalendarParametersFragment;", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final SellerCalendarParametersFragment createInstance(@NotNull String str, @Nullable Date date, @Nullable Date date2) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Bundle bundle = new Bundle(3);
            bundle.putString("advert_id", str);
            bundle.putSerializable("extra_start_date", date);
            bundle.putSerializable("extra_end_date", date2);
            SellerCalendarParametersFragment sellerCalendarParametersFragment = new SellerCalendarParametersFragment();
            sellerCalendarParametersFragment.setArguments(bundle);
            return sellerCalendarParametersFragment;
        }
    }

    public static final void access$loadData(SellerCalendarParametersFragment sellerCalendarParametersFragment) {
        sellerCalendarParametersFragment.getViewModel().getGetDataConsumer().accept(Unit.INSTANCE);
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
    public final SellerCalendarParamsResourceProvider getResourceProvider() {
        SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider = this.resourceProvider;
        if (sellerCalendarParamsResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        return sellerCalendarParamsResourceProvider;
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
    public final SellerCalendarParametersViewModel getViewModel() {
        SellerCalendarParametersViewModel sellerCalendarParametersViewModel = this.viewModel;
        if (sellerCalendarParametersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return sellerCalendarParametersViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        Animation onCreateAnimation = super.onCreateAnimation(i2, z, i3);
        if (onCreateAnimation == null && i3 != 0) {
            onCreateAnimation = AnimationUtils.loadAnimation(getActivity(), i3);
        }
        if (onCreateAnimation != null) {
            onCreateAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment$onCreateAnimation$1
                public final /* synthetic */ SellerCalendarParametersFragment a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(@NotNull Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.a.getViewModel().getGetDataConsumer().accept(Unit.INSTANCE);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(@Nullable Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(@Nullable Animation animation) {
                }
            });
        } else {
            getViewModel().getGetDataConsumer().accept(Unit.INSTANCE);
        }
        return onCreateAnimation;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.seller_edit_base_calendar_parameters_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Disposable disposable = this.h;
        if (disposable != null) {
            disposable.dispose();
        }
        SellerCalendarParametersView sellerCalendarParametersView = this.f;
        if (sellerCalendarParametersView != null) {
            sellerCalendarParametersView.clearSubscriptions();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SellerCalendarParametersView sellerCalendarParametersView = this.f;
        if (sellerCalendarParametersView != null) {
            Disposable subscribe = sellerCalendarParametersView.getCloseClicks().subscribe(new a(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "parametersView.closeClic…lendar = false)\n        }");
            DisposableKt.addTo(subscribe, this.g);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.g.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SellerCalendarParametersViewModel sellerCalendarParametersViewModel = this.viewModel;
        if (sellerCalendarParametersViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        sellerCalendarParametersViewModel.setAdapterPresenter(adapterPresenter2);
        SellerCalendarParametersViewModel sellerCalendarParametersViewModel2 = this.viewModel;
        if (sellerCalendarParametersViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        sellerCalendarParametersViewModel2.getCloseScreenChanges().observe(getViewLifecycleOwner(), new b(this));
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
        SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider = this.resourceProvider;
        if (sellerCalendarParamsResourceProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resourceProvider");
        }
        boolean z = this.d == null && this.e == null;
        BehaviorRelay<Boolean> behaviorRelay = this.i;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "keyboardVisibilityRelay");
        SellerCalendarParametersViewImpl sellerCalendarParametersViewImpl = new SellerCalendarParametersViewImpl(viewGroup, viewLifecycleOwner, adapterPresenter3, itemBinder2, analytics2, sellerCalendarParamsResourceProvider, z, behaviorRelay);
        SellerCalendarParametersViewModel sellerCalendarParametersViewModel3 = this.viewModel;
        if (sellerCalendarParametersViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        sellerCalendarParametersViewImpl.bindTo(sellerCalendarParametersViewModel3);
        this.f = sellerCalendarParametersViewImpl;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intrinsics.checkNotNullExpressionValue(activity, "activity ?: return");
            this.h = Keyboards.keyboardVisibilityChanges(activity, false).debounce((long) getResources().getInteger(17694720), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(this.i);
        }
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

    public final void setResourceProvider(@NotNull SellerCalendarParamsResourceProvider sellerCalendarParamsResourceProvider) {
        Intrinsics.checkNotNullParameter(sellerCalendarParamsResourceProvider, "<set-?>");
        this.resourceProvider = sellerCalendarParamsResourceProvider;
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
                this.c = string;
                this.d = (Date) arguments.getSerializable("extra_start_date");
                this.e = (Date) arguments.getSerializable("extra_end_date");
                StrSellerCalendarParametersComponent.Builder sellerBaseCalendarParametersDependencies = DaggerStrSellerCalendarParametersComponent.builder().sellerBaseCalendarParametersDependencies((StrSellerCalendarParametersDependencies) ComponentDependenciesKt.getDependencies(StrSellerCalendarParametersDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.str_calendar.seller.SellerCalendarRouter");
                StrSellerCalendarParametersComponent.Builder router2 = sellerBaseCalendarParametersDependencies.router((SellerCalendarRouter) activity);
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                StrSellerCalendarParametersComponent.Builder viewModelFragment = router2.resources(resources).viewModelFragment(this);
                String str = this.c;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
                }
                viewModelFragment.advertId(str).startDate(this.d).endDate(this.e).build().inject(this);
                return true;
            }
            throw new IllegalStateException("advertId not set");
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull SellerCalendarParametersViewModel sellerCalendarParametersViewModel) {
        Intrinsics.checkNotNullParameter(sellerCalendarParametersViewModel, "<set-?>");
        this.viewModel = sellerCalendarParametersViewModel;
    }
}

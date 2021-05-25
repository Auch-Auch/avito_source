package com.avito.android.short_term_rent.confirm_booking;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.PaymentIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.StrStartBookingDeepLinkKt;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.short_term_rent.R;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingView;
import com.avito.android.short_term_rent.di.component.DaggerStrConfirmBookingComponent;
import com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies;
import com.avito.android.short_term_rent.di.component.StrConfirmBookingComponent;
import com.avito.android.str.StrCalendarActivityInteractionConstants;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB\u0007¢\u0006\u0004\bP\u0010\u001eJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingView$Listener;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "fragmentView", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onCloseClicked", "()V", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)V", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "viewModel", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "getViewModel", "()Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;", "setViewModel", "(Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingViewModel;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "<init>", "Factory", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrConfirmBookingFragment extends BaseFragment implements StrConfirmBookingView.Listener {
    @Inject
    public DataAwareAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;
    @Inject
    public StrConfirmBookingViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "checkInDate", "checkOutDate", "", "guestsCount", "workflow", "Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/avito/android/short_term_rent/confirm_booking/StrConfirmBookingFragment;", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final StrConfirmBookingFragment createInstance(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @Nullable String str4) {
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(str2, "checkInDate");
            Intrinsics.checkNotNullParameter(str3, "checkOutDate");
            Bundle bundle = new Bundle(4);
            bundle.putString("advert_id", str);
            bundle.putString("check_int_date", str2);
            bundle.putString(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE, str3);
            bundle.putInt("guests_count", i);
            bundle.putString("workflow", str4);
            StrConfirmBookingFragment strConfirmBookingFragment = new StrConfirmBookingFragment();
            strConfirmBookingFragment.setArguments(bundle);
            return strConfirmBookingFragment;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Observer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                if (str2 != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str2));
                    ((StrConfirmBookingFragment) this.b).startActivity(intent);
                }
            } else if (i == 1) {
                String str3 = str;
                if (str3 != null) {
                    StrConfirmBookingFragment strConfirmBookingFragment = (StrConfirmBookingFragment) this.b;
                    strConfirmBookingFragment.startActivityForResult(PaymentIntentFactory.DefaultImpls.webPaymentIntent$default(strConfirmBookingFragment.getIntentFactory(), str3, null, 2, null), 1);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Observer<DeepLink> {
        public final /* synthetic */ StrConfirmBookingFragment a;

        public b(StrConfirmBookingFragment strConfirmBookingFragment) {
            this.a = strConfirmBookingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            if (deepLink2 != null) {
                StrConfirmBookingFragment strConfirmBookingFragment = this.a;
                strConfirmBookingFragment.startActivity(strConfirmBookingFragment.getDeepLinkIntentFactory().getIntent(deepLink2));
            }
        }
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
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final StrConfirmBookingViewModel getViewModel() {
        StrConfirmBookingViewModel strConfirmBookingViewModel = this.viewModel;
        if (strConfirmBookingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return strConfirmBookingViewModel;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        boolean z = true;
        if (i == 1) {
            DeepLink deepLink = intent != null ? (DeepLink) intent.getParcelableExtra(PaymentProcessingConstants.EXTRA_FINAL_DEEPLINK) : null;
            StrConfirmBookingViewModel strConfirmBookingViewModel = this.viewModel;
            if (strConfirmBookingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (i2 != -1) {
                z = false;
            }
            strConfirmBookingViewModel.onCompletePaymentResult(z, deepLink);
        }
    }

    @Override // com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingView.Listener
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
        View inflate = layoutInflater.inflate(R.layout.confirm_booking_fragment, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…agment, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        StrConfirmBookingViewModel strConfirmBookingViewModel = this.viewModel;
        if (strConfirmBookingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strConfirmBookingViewModel.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "fragmentView");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            StrConfirmBookingViewModel strConfirmBookingViewModel = this.viewModel;
            if (strConfirmBookingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            strConfirmBookingViewModel.onRestoreInstanceState(bundle);
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("workflow") : null;
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        StrConfirmBookingViewImpl strConfirmBookingViewImpl = new StrConfirmBookingViewImpl(analytics2, view, simpleRecyclerAdapter, this, this, Intrinsics.areEqual(string, StrStartBookingDeepLinkKt.WORKFLOW_POST_PAID));
        StrConfirmBookingViewModel strConfirmBookingViewModel2 = this.viewModel;
        if (strConfirmBookingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strConfirmBookingViewImpl.bindTo(strConfirmBookingViewModel2);
        StrConfirmBookingViewModel strConfirmBookingViewModel3 = this.viewModel;
        if (strConfirmBookingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.adapterPresenter;
        if (dataAwareAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        strConfirmBookingViewModel3.setAdapterPresenter(dataAwareAdapterPresenter);
        StrConfirmBookingViewModel strConfirmBookingViewModel4 = this.viewModel;
        if (strConfirmBookingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strConfirmBookingViewModel4.getUrlClickChanges().observe(getViewLifecycleOwner(), new a(0, this));
        StrConfirmBookingViewModel strConfirmBookingViewModel5 = this.viewModel;
        if (strConfirmBookingViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strConfirmBookingViewModel5.getPayUrlChanges().observe(getViewLifecycleOwner(), new a(1, this));
        StrConfirmBookingViewModel strConfirmBookingViewModel6 = this.viewModel;
        if (strConfirmBookingViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        strConfirmBookingViewModel6.getDeepLinkChanges().observe(getViewLifecycleOwner(), new b(this));
    }

    public final void setAdapterPresenter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "<set-?>");
        this.adapterPresenter = dataAwareAdapterPresenter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
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
                String string2 = arguments.getString("check_int_date");
                if (string2 != null) {
                    Intrinsics.checkNotNullExpressionValue(string2, "arguments.getString(EXTR…on(\"checkInDate not set\")");
                    String string3 = arguments.getString(StrCalendarActivityInteractionConstants.EXTRA_CHECK_OUT_DATE);
                    if (string3 != null) {
                        Intrinsics.checkNotNullExpressionValue(string3, "arguments.getString(EXTR…n(\"checkOutDate not set\")");
                        int i = arguments.getInt("guests_count");
                        if (i > 0) {
                            String string4 = arguments.getString("workflow");
                            StrConfirmBookingComponent.Builder confirmBookingDependencies = DaggerStrConfirmBookingComponent.builder().confirmBookingDependencies((StrBookingCommonDependencies) ComponentDependenciesKt.getDependencies(StrBookingCommonDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
                            Resources resources = getResources();
                            Intrinsics.checkNotNullExpressionValue(resources, "resources");
                            confirmBookingDependencies.resources(resources).viewModelFragment(this).advertId(string).checkInDate(string2).checkOutDate(string3).guestsCount(i).workflow(string4).build().inject(this);
                            return true;
                        }
                        throw new IllegalStateException("guestsCount is not set");
                    }
                    throw new IllegalStateException("checkOutDate not set");
                }
                throw new IllegalStateException("checkInDate not set");
            }
            throw new IllegalStateException("advertId not set");
        }
        throw new IllegalStateException("Arguments not set");
    }

    public final void setViewModel(@NotNull StrConfirmBookingViewModel strConfirmBookingViewModel) {
        Intrinsics.checkNotNullParameter(strConfirmBookingViewModel, "<set-?>");
        this.viewModel = strConfirmBookingViewModel;
    }
}

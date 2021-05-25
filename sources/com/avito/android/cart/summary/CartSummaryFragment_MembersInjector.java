package com.avito.android.cart.summary;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import java.util.Set;
import javax.inject.Provider;
public final class CartSummaryFragment_MembersInjector implements MembersInjector<CartSummaryFragment> {
    public final Provider<DataAwareAdapterPresenter> a;
    public final Provider<SimpleRecyclerAdapter> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<DeepLinkIntentFactory> d;
    public final Provider<AttributedTextFormatter> e;
    public final Provider<CartSummaryAnalyticsTracker> f;
    public final Provider<Set<RecyclerView.ItemDecoration>> g;
    public final Provider<CartSummaryViewModel> h;
    public final Provider<BaseScreenPerformanceTracker> i;

    public CartSummaryFragment_MembersInjector(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<AttributedTextFormatter> provider5, Provider<CartSummaryAnalyticsTracker> provider6, Provider<Set<RecyclerView.ItemDecoration>> provider7, Provider<CartSummaryViewModel> provider8, Provider<BaseScreenPerformanceTracker> provider9) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
    }

    public static MembersInjector<CartSummaryFragment> create(Provider<DataAwareAdapterPresenter> provider, Provider<SimpleRecyclerAdapter> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeepLinkIntentFactory> provider4, Provider<AttributedTextFormatter> provider5, Provider<CartSummaryAnalyticsTracker> provider6, Provider<Set<RecyclerView.ItemDecoration>> provider7, Provider<CartSummaryViewModel> provider8, Provider<BaseScreenPerformanceTracker> provider9) {
        return new CartSummaryFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(CartSummaryFragment cartSummaryFragment, ActivityIntentFactory activityIntentFactory) {
        cartSummaryFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.adapterPresenter")
    public static void injectAdapterPresenter(CartSummaryFragment cartSummaryFragment, DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        cartSummaryFragment.adapterPresenter = dataAwareAdapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.analyticsTracker")
    public static void injectAnalyticsTracker(CartSummaryFragment cartSummaryFragment, CartSummaryAnalyticsTracker cartSummaryAnalyticsTracker) {
        cartSummaryFragment.analyticsTracker = cartSummaryAnalyticsTracker;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(CartSummaryFragment cartSummaryFragment, AttributedTextFormatter attributedTextFormatter) {
        cartSummaryFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.decorations")
    public static void injectDecorations(CartSummaryFragment cartSummaryFragment, Set<RecyclerView.ItemDecoration> set) {
        cartSummaryFragment.decorations = set;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(CartSummaryFragment cartSummaryFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        cartSummaryFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(CartSummaryFragment cartSummaryFragment, SimpleRecyclerAdapter simpleRecyclerAdapter) {
        cartSummaryFragment.recyclerAdapter = simpleRecyclerAdapter;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.tracker")
    public static void injectTracker(CartSummaryFragment cartSummaryFragment, BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        cartSummaryFragment.tracker = baseScreenPerformanceTracker;
    }

    @InjectedFieldSignature("com.avito.android.cart.summary.CartSummaryFragment.viewModel")
    public static void injectViewModel(CartSummaryFragment cartSummaryFragment, CartSummaryViewModel cartSummaryViewModel) {
        cartSummaryFragment.viewModel = cartSummaryViewModel;
    }

    public void injectMembers(CartSummaryFragment cartSummaryFragment) {
        injectAdapterPresenter(cartSummaryFragment, this.a.get());
        injectRecyclerAdapter(cartSummaryFragment, this.b.get());
        injectActivityIntentFactory(cartSummaryFragment, this.c.get());
        injectDeepLinkIntentFactory(cartSummaryFragment, this.d.get());
        injectAttributedTextFormatter(cartSummaryFragment, this.e.get());
        injectAnalyticsTracker(cartSummaryFragment, this.f.get());
        injectDecorations(cartSummaryFragment, this.g.get());
        injectViewModel(cartSummaryFragment, this.h.get());
        injectTracker(cartSummaryFragment, this.i.get());
    }
}

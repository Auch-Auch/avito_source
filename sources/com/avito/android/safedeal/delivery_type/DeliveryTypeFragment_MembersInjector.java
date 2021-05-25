package com.avito.android.safedeal.delivery_type;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class DeliveryTypeFragment_MembersInjector implements MembersInjector<DeliveryTypeFragment> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<ImplicitIntentFactory> b;
    public final Provider<ActivityIntentFactory> c;
    public final Provider<DeliveryTypePresenter> d;
    public final Provider<AdapterPresenter> e;
    public final Provider<SafeRecyclerAdapter> f;
    public final Provider<DestroyableViewHolderBuilder> g;
    public final Provider<AttributedTextFormatter> h;

    public DeliveryTypeFragment_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeliveryTypePresenter> provider4, Provider<AdapterPresenter> provider5, Provider<SafeRecyclerAdapter> provider6, Provider<DestroyableViewHolderBuilder> provider7, Provider<AttributedTextFormatter> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static MembersInjector<DeliveryTypeFragment> create(Provider<DeepLinkIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<ActivityIntentFactory> provider3, Provider<DeliveryTypePresenter> provider4, Provider<AdapterPresenter> provider5, Provider<SafeRecyclerAdapter> provider6, Provider<DestroyableViewHolderBuilder> provider7, Provider<AttributedTextFormatter> provider8) {
        return new DeliveryTypeFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(DeliveryTypeFragment deliveryTypeFragment, ActivityIntentFactory activityIntentFactory) {
        deliveryTypeFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.adapterPresenter")
    public static void injectAdapterPresenter(DeliveryTypeFragment deliveryTypeFragment, AdapterPresenter adapterPresenter) {
        deliveryTypeFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.attributedTextFormatter")
    public static void injectAttributedTextFormatter(DeliveryTypeFragment deliveryTypeFragment, AttributedTextFormatter attributedTextFormatter) {
        deliveryTypeFragment.attributedTextFormatter = attributedTextFormatter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(DeliveryTypeFragment deliveryTypeFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        deliveryTypeFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.destroyableViewHolderBuilder")
    public static void injectDestroyableViewHolderBuilder(DeliveryTypeFragment deliveryTypeFragment, DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        deliveryTypeFragment.destroyableViewHolderBuilder = destroyableViewHolderBuilder;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(DeliveryTypeFragment deliveryTypeFragment, ImplicitIntentFactory implicitIntentFactory) {
        deliveryTypeFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.presenter")
    public static void injectPresenter(DeliveryTypeFragment deliveryTypeFragment, DeliveryTypePresenter deliveryTypePresenter) {
        deliveryTypeFragment.presenter = deliveryTypePresenter;
    }

    @InjectedFieldSignature("com.avito.android.safedeal.delivery_type.DeliveryTypeFragment.recyclerAdapter")
    public static void injectRecyclerAdapter(DeliveryTypeFragment deliveryTypeFragment, SafeRecyclerAdapter safeRecyclerAdapter) {
        deliveryTypeFragment.recyclerAdapter = safeRecyclerAdapter;
    }

    public void injectMembers(DeliveryTypeFragment deliveryTypeFragment) {
        injectDeepLinkIntentFactory(deliveryTypeFragment, this.a.get());
        injectImplicitIntentFactory(deliveryTypeFragment, this.b.get());
        injectActivityIntentFactory(deliveryTypeFragment, this.c.get());
        injectPresenter(deliveryTypeFragment, this.d.get());
        injectAdapterPresenter(deliveryTypeFragment, this.e.get());
        injectRecyclerAdapter(deliveryTypeFragment, this.f.get());
        injectDestroyableViewHolderBuilder(deliveryTypeFragment, this.g.get());
        injectAttributedTextFormatter(deliveryTypeFragment, this.h.get());
    }
}

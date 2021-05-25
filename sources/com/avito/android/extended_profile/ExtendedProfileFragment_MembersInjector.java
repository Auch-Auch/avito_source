package com.avito.android.extended_profile;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InjectedFieldSignature;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Provider;
public final class ExtendedProfileFragment_MembersInjector implements MembersInjector<ExtendedProfileFragment> {
    public final Provider<ActivityIntentFactory> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<AdapterPresenter> d;
    public final Provider<CompositeSnackbarPresenter> e;
    public final Provider<ItemBinder> f;
    public final Provider<ExtendedProfileViewModel> g;
    public final Provider<Observable<ExtendedProfileItemAction>> h;
    public final Provider<Observable<TnsGalleryItemClickAction>> i;
    public final Provider<SubscriptionsPresenter> j;
    public final Provider<Features> k;
    public final Provider<Formatter<String>> l;
    public final Provider<DialogRouter> m;
    public final Provider<SchedulersFactory3> n;
    public final Provider<Boolean> o;
    public final Provider<Integer> p;
    public final Provider<ExtendedProfileSpanLookup> q;

    public ExtendedProfileFragment_MembersInjector(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<AdapterPresenter> provider4, Provider<CompositeSnackbarPresenter> provider5, Provider<ItemBinder> provider6, Provider<ExtendedProfileViewModel> provider7, Provider<Observable<ExtendedProfileItemAction>> provider8, Provider<Observable<TnsGalleryItemClickAction>> provider9, Provider<SubscriptionsPresenter> provider10, Provider<Features> provider11, Provider<Formatter<String>> provider12, Provider<DialogRouter> provider13, Provider<SchedulersFactory3> provider14, Provider<Boolean> provider15, Provider<Integer> provider16, Provider<ExtendedProfileSpanLookup> provider17) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
    }

    public static MembersInjector<ExtendedProfileFragment> create(Provider<ActivityIntentFactory> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<AdapterPresenter> provider4, Provider<CompositeSnackbarPresenter> provider5, Provider<ItemBinder> provider6, Provider<ExtendedProfileViewModel> provider7, Provider<Observable<ExtendedProfileItemAction>> provider8, Provider<Observable<TnsGalleryItemClickAction>> provider9, Provider<SubscriptionsPresenter> provider10, Provider<Features> provider11, Provider<Formatter<String>> provider12, Provider<DialogRouter> provider13, Provider<SchedulersFactory3> provider14, Provider<Boolean> provider15, Provider<Integer> provider16, Provider<ExtendedProfileSpanLookup> provider17) {
        return new ExtendedProfileFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.adapterPresenter")
    public static void injectAdapterPresenter(ExtendedProfileFragment extendedProfileFragment, AdapterPresenter adapterPresenter) {
        extendedProfileFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.clicks")
    public static void injectClicks(ExtendedProfileFragment extendedProfileFragment, Observable<ExtendedProfileItemAction> observable) {
        extendedProfileFragment.clicks = observable;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.columnCount")
    public static void injectColumnCount(ExtendedProfileFragment extendedProfileFragment, int i2) {
        extendedProfileFragment.columnCount = i2;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ExtendedProfileFragment extendedProfileFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        extendedProfileFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.dialogRouter")
    public static void injectDialogRouter(ExtendedProfileFragment extendedProfileFragment, DialogRouter dialogRouter) {
        extendedProfileFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.features")
    public static void injectFeatures(ExtendedProfileFragment extendedProfileFragment, Features features) {
        extendedProfileFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.galleryClicks")
    public static void injectGalleryClicks(ExtendedProfileFragment extendedProfileFragment, Observable<TnsGalleryItemClickAction> observable) {
        extendedProfileFragment.galleryClicks = observable;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ExtendedProfileFragment extendedProfileFragment, ImplicitIntentFactory implicitIntentFactory) {
        extendedProfileFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.intentFactory")
    public static void injectIntentFactory(ExtendedProfileFragment extendedProfileFragment, ActivityIntentFactory activityIntentFactory) {
        extendedProfileFragment.intentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.isTablet")
    public static void injectIsTablet(ExtendedProfileFragment extendedProfileFragment, boolean z) {
        extendedProfileFragment.isTablet = z;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.itemBinder")
    public static void injectItemBinder(ExtendedProfileFragment extendedProfileFragment, ItemBinder itemBinder) {
        extendedProfileFragment.itemBinder = itemBinder;
    }

    @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode
    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.phoneFormatter")
    public static void injectPhoneFormatter(ExtendedProfileFragment extendedProfileFragment, Formatter<String> formatter) {
        extendedProfileFragment.phoneFormatter = formatter;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.schedulersFactory3")
    public static void injectSchedulersFactory3(ExtendedProfileFragment extendedProfileFragment, SchedulersFactory3 schedulersFactory3) {
        extendedProfileFragment.schedulersFactory3 = schedulersFactory3;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.snackbarPresenter")
    public static void injectSnackbarPresenter(ExtendedProfileFragment extendedProfileFragment, CompositeSnackbarPresenter compositeSnackbarPresenter) {
        extendedProfileFragment.snackbarPresenter = compositeSnackbarPresenter;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.spanLookup")
    public static void injectSpanLookup(ExtendedProfileFragment extendedProfileFragment, Lazy<ExtendedProfileSpanLookup> lazy) {
        extendedProfileFragment.spanLookup = lazy;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.subscriptionsPresenter")
    public static void injectSubscriptionsPresenter(ExtendedProfileFragment extendedProfileFragment, SubscriptionsPresenter subscriptionsPresenter) {
        extendedProfileFragment.subscriptionsPresenter = subscriptionsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.extended_profile.ExtendedProfileFragment.viewModel")
    public static void injectViewModel(ExtendedProfileFragment extendedProfileFragment, ExtendedProfileViewModel extendedProfileViewModel) {
        extendedProfileFragment.viewModel = extendedProfileViewModel;
    }

    public void injectMembers(ExtendedProfileFragment extendedProfileFragment) {
        injectIntentFactory(extendedProfileFragment, this.a.get());
        injectDeepLinkIntentFactory(extendedProfileFragment, this.b.get());
        injectImplicitIntentFactory(extendedProfileFragment, this.c.get());
        injectAdapterPresenter(extendedProfileFragment, this.d.get());
        injectSnackbarPresenter(extendedProfileFragment, this.e.get());
        injectItemBinder(extendedProfileFragment, this.f.get());
        injectViewModel(extendedProfileFragment, this.g.get());
        injectClicks(extendedProfileFragment, this.h.get());
        injectGalleryClicks(extendedProfileFragment, this.i.get());
        injectSubscriptionsPresenter(extendedProfileFragment, this.j.get());
        injectFeatures(extendedProfileFragment, this.k.get());
        injectPhoneFormatter(extendedProfileFragment, this.l.get());
        injectDialogRouter(extendedProfileFragment, this.m.get());
        injectSchedulersFactory3(extendedProfileFragment, this.n.get());
        injectIsTablet(extendedProfileFragment, this.o.get().booleanValue());
        injectColumnCount(extendedProfileFragment, this.p.get().intValue());
        injectSpanLookup(extendedProfileFragment, DoubleCheck.lazy(this.q));
    }
}

package com.avito.android.messenger.channels.mvi.view;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.MessengerSearchIconTest;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.messenger.channels.analytics.ChannelsTracker;
import com.avito.android.messenger.channels.mvi.presenter.ChannelsHeaderPresenter;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
import ru.avito.android.persistence.messenger.MessengerDatabase;
public final class ChannelsFragment_MembersInjector implements MembersInjector<ChannelsFragment> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;
    public final Provider<ChannelsTracker> c;
    public final Provider<ChannelsHeaderPresenter> d;
    public final Provider<FoldersPresenter> e;
    public final Provider<ImplicitIntentFactory> f;
    public final Provider<ActivityIntentFactory> g;
    public final Provider<MessengerDatabase> h;
    public final Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> i;
    public final Provider<DeepLinkIntentFactory> j;
    public final Provider<SimpleTestGroup> k;
    public final Provider<CartFabViewModel> l;
    public final Provider<CartQuantityChangesHandler> m;

    public ChannelsFragment_MembersInjector(Provider<Analytics> provider, Provider<Features> provider2, Provider<ChannelsTracker> provider3, Provider<ChannelsHeaderPresenter> provider4, Provider<FoldersPresenter> provider5, Provider<ImplicitIntentFactory> provider6, Provider<ActivityIntentFactory> provider7, Provider<MessengerDatabase> provider8, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider9, Provider<DeepLinkIntentFactory> provider10, Provider<SimpleTestGroup> provider11, Provider<CartFabViewModel> provider12, Provider<CartQuantityChangesHandler> provider13) {
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
    }

    public static MembersInjector<ChannelsFragment> create(Provider<Analytics> provider, Provider<Features> provider2, Provider<ChannelsTracker> provider3, Provider<ChannelsHeaderPresenter> provider4, Provider<FoldersPresenter> provider5, Provider<ImplicitIntentFactory> provider6, Provider<ActivityIntentFactory> provider7, Provider<MessengerDatabase> provider8, Provider<ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup>> provider9, Provider<DeepLinkIntentFactory> provider10, Provider<SimpleTestGroup> provider11, Provider<CartFabViewModel> provider12, Provider<CartQuantityChangesHandler> provider13) {
        return new ChannelsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ChannelsFragment channelsFragment, ActivityIntentFactory activityIntentFactory) {
        channelsFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.analytics")
    public static void injectAnalytics(ChannelsFragment channelsFragment, Analytics analytics) {
        channelsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.cartFabViewModel")
    public static void injectCartFabViewModel(ChannelsFragment channelsFragment, CartFabViewModel cartFabViewModel) {
        channelsFragment.cartFabViewModel = cartFabViewModel;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.cartQuantityHandler")
    public static void injectCartQuantityHandler(ChannelsFragment channelsFragment, CartQuantityChangesHandler cartQuantityChangesHandler) {
        channelsFragment.cartQuantityHandler = cartQuantityChangesHandler;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.channelsHeaderPresenter")
    public static void injectChannelsHeaderPresenter(ChannelsFragment channelsFragment, ChannelsHeaderPresenter channelsHeaderPresenter) {
        channelsFragment.channelsHeaderPresenter = channelsHeaderPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.database")
    public static void injectDatabase(ChannelsFragment channelsFragment, MessengerDatabase messengerDatabase) {
        channelsFragment.database = messengerDatabase;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ChannelsFragment channelsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        channelsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.features")
    public static void injectFeatures(ChannelsFragment channelsFragment, Features features) {
        channelsFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.foldersPresenter")
    public static void injectFoldersPresenter(ChannelsFragment channelsFragment, FoldersPresenter foldersPresenter) {
        channelsFragment.foldersPresenter = foldersPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ChannelsFragment channelsFragment, ImplicitIntentFactory implicitIntentFactory) {
        channelsFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.messengerFolderTabsTestGroup")
    public static void injectMessengerFolderTabsTestGroup(ChannelsFragment channelsFragment, ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> manuallyExposedAbTestGroup) {
        channelsFragment.messengerFolderTabsTestGroup = manuallyExposedAbTestGroup;
    }

    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.perfTracker")
    public static void injectPerfTracker(ChannelsFragment channelsFragment, ChannelsTracker channelsTracker) {
        channelsFragment.perfTracker = channelsTracker;
    }

    @MessengerSearchIconTest
    @InjectedFieldSignature("com.avito.android.messenger.channels.mvi.view.ChannelsFragment.searchIconTest")
    public static void injectSearchIconTest(ChannelsFragment channelsFragment, SimpleTestGroup simpleTestGroup) {
        channelsFragment.searchIconTest = simpleTestGroup;
    }

    public void injectMembers(ChannelsFragment channelsFragment) {
        injectAnalytics(channelsFragment, this.a.get());
        injectFeatures(channelsFragment, this.b.get());
        injectPerfTracker(channelsFragment, this.c.get());
        injectChannelsHeaderPresenter(channelsFragment, this.d.get());
        injectFoldersPresenter(channelsFragment, this.e.get());
        injectImplicitIntentFactory(channelsFragment, this.f.get());
        injectActivityIntentFactory(channelsFragment, this.g.get());
        injectDatabase(channelsFragment, this.h.get());
        injectMessengerFolderTabsTestGroup(channelsFragment, this.i.get());
        injectDeepLinkIntentFactory(channelsFragment, this.j.get());
        injectSearchIconTest(channelsFragment, this.k.get());
        injectCartFabViewModel(channelsFragment, this.l.get());
        injectCartQuantityHandler(channelsFragment, this.m.get());
    }
}

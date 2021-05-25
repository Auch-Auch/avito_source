package com.avito.android.messenger.conversation;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.messenger.conversation.analytics.ChannelTracker;
import com.avito.android.messenger.conversation.mvi.context.ChannelContextPresenter;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuPresenter;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuCallbacks;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.messages.MessageListPresenter;
import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsCoordinator;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.ItemsListPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.item_list.di.ItemsList;
import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsPresenter;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenter;
import com.avito.android.messenger.di.MessageList;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class ChannelFragment_MembersInjector implements MembersInjector<ChannelFragment> {
    public final Provider<ChannelTracker> A;
    public final Provider<PermissionHelper> B;
    public final Provider<PermissionStorage> C;
    public final Provider<FpsStateSupplier> D;
    public final Provider<Analytics> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<ServiceIntentFactory> d;
    public final Provider<DeepLinkIntentFactory> e;
    public final Provider<AdapterPresenter> f;
    public final Provider<ItemBinder> g;
    public final Provider<Features> h;
    public final Provider<MessageListPresenter> i;
    public final Provider<LegacyPlatformActionsPresenter> j;
    public final Provider<PlatformActionsCoordinator> k;
    public final Provider<ContextActionsPresenter> l;
    public final Provider<AdapterPresenter> m;
    public final Provider<ItemBinder> n;
    public final Provider<ItemsListPresenter> o;
    public final Provider<SendMessagePresenter> p;
    public final Provider<ChannelContextPresenter> q;
    public final Provider<ChannelMenuPresenter> r;
    public final Provider<ChannelReplySuggestsPresenter> s;
    public final Provider<MessageMenuPresenter> t;
    public final Provider<MessageMenuCallbacks> u;
    public final Provider<NewMessagesPresenter> v;
    public final Provider<ConnectivityProvider> w;
    public final Provider<DeeplinkProcessor> x;
    public final Provider<DeeplinkProcessorListener> y;
    public final Provider<BuildInfo> z;

    public ChannelFragment_MembersInjector(Provider<Analytics> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<ServiceIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<AdapterPresenter> provider6, Provider<ItemBinder> provider7, Provider<Features> provider8, Provider<MessageListPresenter> provider9, Provider<LegacyPlatformActionsPresenter> provider10, Provider<PlatformActionsCoordinator> provider11, Provider<ContextActionsPresenter> provider12, Provider<AdapterPresenter> provider13, Provider<ItemBinder> provider14, Provider<ItemsListPresenter> provider15, Provider<SendMessagePresenter> provider16, Provider<ChannelContextPresenter> provider17, Provider<ChannelMenuPresenter> provider18, Provider<ChannelReplySuggestsPresenter> provider19, Provider<MessageMenuPresenter> provider20, Provider<MessageMenuCallbacks> provider21, Provider<NewMessagesPresenter> provider22, Provider<ConnectivityProvider> provider23, Provider<DeeplinkProcessor> provider24, Provider<DeeplinkProcessorListener> provider25, Provider<BuildInfo> provider26, Provider<ChannelTracker> provider27, Provider<PermissionHelper> provider28, Provider<PermissionStorage> provider29, Provider<FpsStateSupplier> provider30) {
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
        this.r = provider18;
        this.s = provider19;
        this.t = provider20;
        this.u = provider21;
        this.v = provider22;
        this.w = provider23;
        this.x = provider24;
        this.y = provider25;
        this.z = provider26;
        this.A = provider27;
        this.B = provider28;
        this.C = provider29;
        this.D = provider30;
    }

    public static MembersInjector<ChannelFragment> create(Provider<Analytics> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<ServiceIntentFactory> provider4, Provider<DeepLinkIntentFactory> provider5, Provider<AdapterPresenter> provider6, Provider<ItemBinder> provider7, Provider<Features> provider8, Provider<MessageListPresenter> provider9, Provider<LegacyPlatformActionsPresenter> provider10, Provider<PlatformActionsCoordinator> provider11, Provider<ContextActionsPresenter> provider12, Provider<AdapterPresenter> provider13, Provider<ItemBinder> provider14, Provider<ItemsListPresenter> provider15, Provider<SendMessagePresenter> provider16, Provider<ChannelContextPresenter> provider17, Provider<ChannelMenuPresenter> provider18, Provider<ChannelReplySuggestsPresenter> provider19, Provider<MessageMenuPresenter> provider20, Provider<MessageMenuCallbacks> provider21, Provider<NewMessagesPresenter> provider22, Provider<ConnectivityProvider> provider23, Provider<DeeplinkProcessor> provider24, Provider<DeeplinkProcessorListener> provider25, Provider<BuildInfo> provider26, Provider<ChannelTracker> provider27, Provider<PermissionHelper> provider28, Provider<PermissionStorage> provider29, Provider<FpsStateSupplier> provider30) {
        return new ChannelFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30);
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(ChannelFragment channelFragment, ActivityIntentFactory activityIntentFactory) {
        channelFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.analytics")
    public static void injectAnalytics(ChannelFragment channelFragment, Analytics analytics) {
        channelFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.buildInfo")
    public static void injectBuildInfo(ChannelFragment channelFragment, BuildInfo buildInfo) {
        channelFragment.buildInfo = buildInfo;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.channelContextPresenter")
    public static void injectChannelContextPresenter(ChannelFragment channelFragment, ChannelContextPresenter channelContextPresenter) {
        channelFragment.channelContextPresenter = channelContextPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.channelMenuPresenter")
    public static void injectChannelMenuPresenter(ChannelFragment channelFragment, ChannelMenuPresenter channelMenuPresenter) {
        channelFragment.channelMenuPresenter = channelMenuPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.channelReplySuggestsPresenter")
    public static void injectChannelReplySuggestsPresenter(ChannelFragment channelFragment, ChannelReplySuggestsPresenter channelReplySuggestsPresenter) {
        channelFragment.channelReplySuggestsPresenter = channelReplySuggestsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.connectivityProvider")
    public static void injectConnectivityProvider(ChannelFragment channelFragment, ConnectivityProvider connectivityProvider) {
        channelFragment.connectivityProvider = connectivityProvider;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.contextActionsPresenter")
    public static void injectContextActionsPresenter(ChannelFragment channelFragment, ContextActionsPresenter contextActionsPresenter) {
        channelFragment.contextActionsPresenter = contextActionsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(ChannelFragment channelFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        channelFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.deeplinkProcessor")
    public static void injectDeeplinkProcessor(ChannelFragment channelFragment, DeeplinkProcessor deeplinkProcessor) {
        channelFragment.deeplinkProcessor = deeplinkProcessor;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.deeplinkProcessorListener")
    public static void injectDeeplinkProcessorListener(ChannelFragment channelFragment, DeeplinkProcessorListener deeplinkProcessorListener) {
        channelFragment.deeplinkProcessorListener = deeplinkProcessorListener;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.features")
    public static void injectFeatures(ChannelFragment channelFragment, Features features) {
        channelFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.implicitIntentFactory")
    public static void injectImplicitIntentFactory(ChannelFragment channelFragment, ImplicitIntentFactory implicitIntentFactory) {
        channelFragment.implicitIntentFactory = implicitIntentFactory;
    }

    @ItemsList
    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.itemsListAdapterPresenter")
    public static void injectItemsListAdapterPresenter(ChannelFragment channelFragment, AdapterPresenter adapterPresenter) {
        channelFragment.itemsListAdapterPresenter = adapterPresenter;
    }

    @ItemsList
    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.itemsListItemBinder")
    public static void injectItemsListItemBinder(ChannelFragment channelFragment, ItemBinder itemBinder) {
        channelFragment.itemsListItemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.itemsListPresenter")
    public static void injectItemsListPresenter(ChannelFragment channelFragment, ItemsListPresenter itemsListPresenter) {
        channelFragment.itemsListPresenter = itemsListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.legacyPlatformActionsPresenter")
    public static void injectLegacyPlatformActionsPresenter(ChannelFragment channelFragment, LegacyPlatformActionsPresenter legacyPlatformActionsPresenter) {
        channelFragment.legacyPlatformActionsPresenter = legacyPlatformActionsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.messageListAdapterPresenter")
    @MessageList
    public static void injectMessageListAdapterPresenter(ChannelFragment channelFragment, AdapterPresenter adapterPresenter) {
        channelFragment.messageListAdapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.messageListItemBinder")
    @MessageList
    public static void injectMessageListItemBinder(ChannelFragment channelFragment, ItemBinder itemBinder) {
        channelFragment.messageListItemBinder = itemBinder;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.messageListPresenter")
    public static void injectMessageListPresenter(ChannelFragment channelFragment, MessageListPresenter messageListPresenter) {
        channelFragment.messageListPresenter = messageListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.messageMenuCallbacks")
    public static void injectMessageMenuCallbacks(ChannelFragment channelFragment, MessageMenuCallbacks messageMenuCallbacks) {
        channelFragment.messageMenuCallbacks = messageMenuCallbacks;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.messageMenuPresenter")
    public static void injectMessageMenuPresenter(ChannelFragment channelFragment, MessageMenuPresenter messageMenuPresenter) {
        channelFragment.messageMenuPresenter = messageMenuPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.newMessagesPresenter")
    public static void injectNewMessagesPresenter(ChannelFragment channelFragment, NewMessagesPresenter newMessagesPresenter) {
        channelFragment.newMessagesPresenter = newMessagesPresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.perfTracker")
    public static void injectPerfTracker(ChannelFragment channelFragment, ChannelTracker channelTracker) {
        channelFragment.perfTracker = channelTracker;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.permissionHelper")
    public static void injectPermissionHelper(ChannelFragment channelFragment, PermissionHelper permissionHelper) {
        channelFragment.permissionHelper = permissionHelper;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.permissionStorage")
    public static void injectPermissionStorage(ChannelFragment channelFragment, PermissionStorage permissionStorage) {
        channelFragment.permissionStorage = permissionStorage;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.platformActionsCoordinator")
    public static void injectPlatformActionsCoordinator(ChannelFragment channelFragment, PlatformActionsCoordinator platformActionsCoordinator) {
        channelFragment.platformActionsCoordinator = platformActionsCoordinator;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.sendMessagePresenter")
    public static void injectSendMessagePresenter(ChannelFragment channelFragment, SendMessagePresenter sendMessagePresenter) {
        channelFragment.sendMessagePresenter = sendMessagePresenter;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.serviceIntentFactory")
    public static void injectServiceIntentFactory(ChannelFragment channelFragment, ServiceIntentFactory serviceIntentFactory) {
        channelFragment.serviceIntentFactory = serviceIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.messenger.conversation.ChannelFragment.supplier")
    public static void injectSupplier(ChannelFragment channelFragment, FpsStateSupplier fpsStateSupplier) {
        channelFragment.supplier = fpsStateSupplier;
    }

    public void injectMembers(ChannelFragment channelFragment) {
        injectAnalytics(channelFragment, this.a.get());
        injectActivityIntentFactory(channelFragment, this.b.get());
        injectImplicitIntentFactory(channelFragment, this.c.get());
        injectServiceIntentFactory(channelFragment, this.d.get());
        injectDeepLinkIntentFactory(channelFragment, this.e.get());
        injectMessageListAdapterPresenter(channelFragment, this.f.get());
        injectMessageListItemBinder(channelFragment, this.g.get());
        injectFeatures(channelFragment, this.h.get());
        injectMessageListPresenter(channelFragment, this.i.get());
        injectLegacyPlatformActionsPresenter(channelFragment, this.j.get());
        injectPlatformActionsCoordinator(channelFragment, this.k.get());
        injectContextActionsPresenter(channelFragment, this.l.get());
        injectItemsListAdapterPresenter(channelFragment, this.m.get());
        injectItemsListItemBinder(channelFragment, this.n.get());
        injectItemsListPresenter(channelFragment, this.o.get());
        injectSendMessagePresenter(channelFragment, this.p.get());
        injectChannelContextPresenter(channelFragment, this.q.get());
        injectChannelMenuPresenter(channelFragment, this.r.get());
        injectChannelReplySuggestsPresenter(channelFragment, this.s.get());
        injectMessageMenuPresenter(channelFragment, this.t.get());
        injectMessageMenuCallbacks(channelFragment, this.u.get());
        injectNewMessagesPresenter(channelFragment, this.v.get());
        injectConnectivityProvider(channelFragment, this.w.get());
        injectDeeplinkProcessor(channelFragment, this.x.get());
        injectDeeplinkProcessorListener(channelFragment, this.y.get());
        injectBuildInfo(channelFragment, this.z.get());
        injectPerfTracker(channelFragment, this.A.get());
        injectPermissionHelper(channelFragment, this.B.get());
        injectPermissionStorage(channelFragment, this.C.get());
        injectSupplier(channelFragment, this.D.get());
    }
}

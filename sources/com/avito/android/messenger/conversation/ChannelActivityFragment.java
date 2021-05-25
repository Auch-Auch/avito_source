package com.avito.android.messenger.conversation;

import a2.a.a.o1.d.a;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.ScreenIdField;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.ChannelScreen;
import com.avito.android.app.di.HasComponent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.messenger.conversation.create.CreateChannelFragment;
import com.avito.android.messenger.conversation.create.CreateChannelRouter;
import com.avito.android.messenger.di.ChannelActivityComponent;
import com.avito.android.messenger.di.ChannelActivityDependencies;
import com.avito.android.messenger.di.DaggerChannelActivityComponent;
import com.avito.android.messenger.util.ServiceBindingHelper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.notification.NotificationProvider;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001{\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\nJ\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010%\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\nJ\u000f\u0010(\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010\nJ\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010\nJ\u001f\u00104\u001a\u00020\b2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\b2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b6\u00107J\u0019\u00108\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b8\u00107J%\u0010=\u001a\u00020\b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010<\u001a\u00020 H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\b2\u0006\u0010?\u001a\u000201H\u0016¢\u0006\u0004\b@\u00107J\u0017\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020 H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bE\u0010\u0018J\u000f\u0010B\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u0010\nJ\u000f\u0010F\u001a\u00020\u000bH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0007H\u0016¢\u0006\u0004\bH\u0010IR\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010S\u001a\u00020L8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00078\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010X\u001a\u00020W8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010_\u001a\u00020^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bm\u0010nR\"\u0010q\u001a\u00020p8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R)\u0010\u0001\u001a\u000208\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivityFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/messenger/conversation/ChannelRootRouter;", "Lcom/avito/android/messenger/conversation/create/CreateChannelRouter;", "Lcom/avito/android/remote/notification/NotificationProvider$Handler;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/app/di/HasComponent;", "Lcom/avito/android/messenger/di/ChannelActivityComponent;", "", "d", "()V", "", "ignoreInvalid", "c", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onStart", "onStop", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "handleMessage", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnBackPressedListener", "(Lcom/avito/android/ui/fragments/OnBackPressedListener;)V", "openAuthScreen", "", BookingInfoActivity.EXTRA_ITEM_ID, "fromRecommendations", "openAdvertScreen", "(Ljava/lang/String;Z)V", "openMyAdvertScreen", "(Ljava/lang/String;)V", "openAdvertSelectionScreen", "", "Lcom/avito/android/remote/model/Image;", "images", VKApiConst.POSITION, "openGallery", "(Ljava/util/List;I)V", "channelId", "loadChannel", "result", "close", "(I)V", "bundle", "onNewIntent", "onBackPressed", "()Z", "getComponent", "()Lcom/avito/android/messenger/di/ChannelActivityComponent;", "j", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "n", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/messenger/di/ChannelActivityComponent;", "channelActivityComponent", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "Lcom/avito/android/ServiceIntentFactory;", "getServiceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "setServiceIntentFactory", "(Lcom/avito/android/ServiceIntentFactory;)V", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "getTreeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "setTreeStateIdGenerator", "(Lcom/avito/android/analytics/provider/TreeStateIdGenerator;)V", "Lcom/avito/android/messenger/util/ServiceBindingHelper;", "l", "Lcom/avito/android/messenger/util/ServiceBindingHelper;", "notificationServiceHelper", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments;", "k", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments;", "channelArguments", "com/avito/android/messenger/conversation/ChannelActivityFragment$notificationServiceConnection$1", "o", "Lcom/avito/android/messenger/conversation/ChannelActivityFragment$notificationServiceConnection$1;", "notificationServiceConnection", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelActivityFragment extends TabBaseFragment implements ChannelRootRouter, CreateChannelRouter, NotificationProvider.Handler, OnBackPressedListener, HasComponent<ChannelActivityComponent> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    public OnBackPressedListener j;
    public ChannelActivityArguments k;
    public ServiceBindingHelper l;
    public ChannelActivityComponent m;
    @NotNull
    public NavigationState n = new NavigationState(false);
    public final ChannelActivityFragment$notificationServiceConnection$1 o = new ChannelActivityFragment$notificationServiceConnection$1(this);
    @Inject
    public ServiceIntentFactory serviceIntentFactory;
    @Inject
    public TreeStateIdGenerator treeStateIdGenerator;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivityFragment$Companion;", "", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments;", "arguments", "Lcom/avito/android/messenger/conversation/ChannelActivityFragment;", "newInstance", "(Lcom/avito/android/messenger/conversation/ChannelActivityArguments;)Lcom/avito/android/messenger/conversation/ChannelActivityFragment;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final ChannelActivityFragment newInstance(@NotNull ChannelActivityArguments channelActivityArguments) {
            Intrinsics.checkNotNullParameter(channelActivityArguments, "arguments");
            ChannelActivityFragment channelActivityFragment = new ChannelActivityFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arguments", channelActivityArguments);
            Unit unit = Unit.INSTANCE;
            channelActivityFragment.setArguments(bundle);
            return channelActivityFragment;
        }

        public Companion(j jVar) {
        }
    }

    @JvmStatic
    @NotNull
    public static final ChannelActivityFragment newInstance(@NotNull ChannelActivityArguments channelActivityArguments) {
        return Companion.newInstance(channelActivityArguments);
    }

    public final void c() {
        Bundle arguments = getArguments();
        ChannelActivityArguments channelActivityArguments = arguments != null ? (ChannelActivityArguments) arguments.getParcelable("arguments") : null;
        if (channelActivityArguments != null) {
            this.k = channelActivityArguments;
            return;
        }
        throw new IllegalArgumentException(("arguments was not passed to " + this).toString());
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter, com.avito.android.messenger.conversation.create.CreateChannelRouter
    public void close(int i) {
        if (!features().getChannelWithoutActivity().invoke().booleanValue() || (getActivity() instanceof ChannelActivity)) {
            requireActivity().setResult(i);
        } else {
            TabBaseFragment.setResult$default(this, i, null, 2, null);
        }
        close();
    }

    public final void d() {
        ChannelActivityArguments channelActivityArguments = this.k;
        if (channelActivityArguments == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelArguments");
        }
        if (channelActivityArguments instanceof ChannelActivityArguments.Open) {
            ChannelActivityArguments.Open open = (ChannelActivityArguments.Open) channelActivityArguments;
            getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, ChannelFragment.Companion.newInstance(open.getChannelId(), open.getNumberInList(), open.getMessageId(), open.getSearchQuery()), "ChannelFragment").commit();
        } else if (channelActivityArguments instanceof ChannelActivityArguments.Create) {
            getChildFragmentManager().beginTransaction().replace(R.id.fragment_container, CreateChannelFragment.Companion.createInstance((ChannelActivityArguments.Create) channelActivityArguments), "ChannelFragment").commit();
        }
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
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
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.n;
    }

    @NotNull
    public final ServiceIntentFactory getServiceIntentFactory() {
        ServiceIntentFactory serviceIntentFactory2 = this.serviceIntentFactory;
        if (serviceIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceIntentFactory");
        }
        return serviceIntentFactory2;
    }

    @NotNull
    public final TreeStateIdGenerator getTreeStateIdGenerator() {
        TreeStateIdGenerator treeStateIdGenerator2 = this.treeStateIdGenerator;
        if (treeStateIdGenerator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("treeStateIdGenerator");
        }
        return treeStateIdGenerator2;
    }

    @Override // com.avito.android.remote.notification.NotificationProvider.Handler
    public boolean handleMessage(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        ChannelFragment channelFragment = null;
        Logs.verbose$default("ChannelActivity", "handleMessage: " + deepLink, null, 4, null);
        if (!isResumed()) {
            return false;
        }
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("ChannelFragment");
        if (findFragmentByTag instanceof ChannelFragment) {
            channelFragment = findFragmentByTag;
        }
        ChannelFragment channelFragment2 = channelFragment;
        if (channelFragment2 == null || !channelFragment2.isAdded()) {
            return false;
        }
        return channelFragment2.handleMessage(deepLink);
    }

    @Override // com.avito.android.messenger.conversation.create.CreateChannelRouter
    public void loadChannel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Bundle bundle = new Bundle();
        bundle.putParcelable("arguments", new ChannelActivityArguments.Open(str, null, null, null, false, 16, null));
        setArguments(bundle);
        c();
        d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        FeedbackAdvertItem feedbackAdvertItem;
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (i == 1 && intent != null && (feedbackAdvertItem = (FeedbackAdvertItem) intent.getParcelableExtra("item")) != null) {
                Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("ChannelFragment");
                if (!(findFragmentByTag instanceof ChannelFragment)) {
                    findFragmentByTag = null;
                }
                ChannelFragment channelFragment = (ChannelFragment) findFragmentByTag;
                if (channelFragment != null && channelFragment.isAdded()) {
                    channelFragment.onFeedbackItemSelected(feedbackAdvertItem);
                }
            }
        } else if (i2 == -1) {
            d();
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        ChannelActivityComponent build = DaggerChannelActivityComponent.builder().channelActivityDependencies((ChannelActivityDependencies) ComponentDependenciesKt.getDependencies(ChannelActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screenAnalyticsDependencies((ScreenAnalyticsDependencies) ComponentDependenciesKt.getDependencies(ScreenAnalyticsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).screen(ChannelScreen.INSTANCE).build();
        this.m = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelActivityComponent");
        }
        build.inject(this);
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        OnBackPressedListener onBackPressedListener = this.j;
        return onBackPressedListener != null && onBackPressedListener.onBackPressed();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        c();
        if (bundle == null) {
            d();
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "this.requireContext()");
        ServiceIntentFactory serviceIntentFactory2 = this.serviceIntentFactory;
        if (serviceIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceIntentFactory");
        }
        this.l = new ServiceBindingHelper(requireContext, serviceIntentFactory2.notificationServiceIntent(), this.o, null, null, new a(this), 24, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_container, viewGroup, false);
    }

    public final void onNewIntent(@Nullable Bundle bundle) {
        setArguments(bundle);
        c();
        d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ServiceBindingHelper serviceBindingHelper = this.l;
        if (serviceBindingHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationServiceHelper");
        }
        serviceBindingHelper.bindService();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ServiceBindingHelper serviceBindingHelper = this.l;
        if (serviceBindingHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationServiceHelper");
        }
        serviceBindingHelper.unbindService();
        super.onStop();
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter
    public void openAdvertScreen(@NotNull String str, boolean z) {
        TreeClickStreamParent treeClickStreamParent;
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        if (z) {
            TreeStateIdGenerator treeStateIdGenerator2 = this.treeStateIdGenerator;
            if (treeStateIdGenerator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("treeStateIdGenerator");
            }
            treeClickStreamParent = new TreeClickStreamParent(treeStateIdGenerator2.nextStateId(), ScreenIdField.MESSENGER_RECOMMENDATIONS.getId(), null, null);
        } else {
            treeClickStreamParent = null;
        }
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory2, str, null, null, null, null, null, false, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), null, 2686, null));
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter
    public void openAdvertSelectionScreen(@Nullable String str) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.feedbackItemsIntent(str), 1);
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter
    public void openAuthScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.OPEN_CHANNEL, null, 5, null), 0);
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter
    public void openGallery(@NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.photoGalleryIntent(null, list, i));
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter
    public void openMyAdvertScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(activityIntentFactory2, str, null, null, false, 14, null));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.n = navigationState;
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter
    public void setOnBackPressedListener(@Nullable OnBackPressedListener onBackPressedListener) {
        this.j = onBackPressedListener;
    }

    public final void setServiceIntentFactory(@NotNull ServiceIntentFactory serviceIntentFactory2) {
        Intrinsics.checkNotNullParameter(serviceIntentFactory2, "<set-?>");
        this.serviceIntentFactory = serviceIntentFactory2;
    }

    public final void setTreeStateIdGenerator(@NotNull TreeStateIdGenerator treeStateIdGenerator2) {
        Intrinsics.checkNotNullParameter(treeStateIdGenerator2, "<set-?>");
        this.treeStateIdGenerator = treeStateIdGenerator2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        return false;
    }

    @Override // com.avito.android.app.di.HasComponent
    @NotNull
    public ChannelActivityComponent getComponent() {
        ChannelActivityComponent channelActivityComponent = this.m;
        if (channelActivityComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelActivityComponent");
        }
        return channelActivityComponent;
    }

    @Override // com.avito.android.messenger.conversation.ChannelRootRouter
    public void close() {
        if (!features().getChannelWithoutActivity().invoke().booleanValue() || (getActivity() instanceof ChannelActivity)) {
            FragmentActivity requireActivity = requireActivity();
            Objects.requireNonNull(requireActivity, "null cannot be cast to non-null type com.avito.android.ui.activity.BaseActivity");
            BaseActivity baseActivity = (BaseActivity) requireActivity;
            Intent upIntent = baseActivity.getUpIntent();
            if (upIntent != null) {
                try {
                    baseActivity.startActivity(IntentsKt.makeSafeForExternalApps(upIntent));
                } catch (Exception e) {
                    Logs.error("ChannelActivity", "Unable to start up intent", e);
                }
            }
            baseActivity.finish();
            return;
        }
        finish();
    }
}

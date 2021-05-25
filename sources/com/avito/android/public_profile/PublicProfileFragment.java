package com.avito.android.public_profile;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.PhotoGalleryIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ShowPublicProfileScreenEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.bottom_navigation.ui.fragment.factory.NavigationState;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.ChainedDeepLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneAddLink;
import com.avito.android.deep_linking.links.RefreshLink;
import com.avito.android.deep_linking.links.SellerSubscribeLink;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.analytics.event.AvatarPreviewEvent;
import com.avito.android.public_profile.di.DaggerPublicProfileFragmentComponent;
import com.avito.android.public_profile.di.PublicProfileFragmentComponent;
import com.avito.android.public_profile.di.PublicProfileFragmentDependencies;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.public_profile.ui.PublicProfilePresenter;
import com.avito.android.public_profile.ui.PublicProfileViewImpl;
import com.avito.android.public_profile.ui.SubscribeButtonsViewImpl;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile_stuff.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\b¢\u0006\u0005\bµ\u0001\u0010\u001cJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b \u0010\tJ)\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\u001cJ\u0017\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b/\u0010,J\u0017\u00102\u001a\u00020\u00072\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00072\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b4\u00103J\u000f\u00105\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u001f\u0010>\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0007H\u0016¢\u0006\u0004\b@\u0010\u001cJ\u000f\u0010A\u001a\u00020\u0007H\u0016¢\u0006\u0004\bA\u0010\u001cR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010f\u001a\u00020_8\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010h\u001a\u00020g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0018\u0010p\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\"\u0010r\u001a\u00020q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001c\u0010{\u001a\b\u0012\u0004\u0012\u0002000x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}R)\u0010\u0001\u001a\u000208\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R0\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020Q0\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u0018\u0010­\u0001\u001a\u00020;8\u0002@\u0002X.¢\u0006\u0007\n\u0005\b¬\u0001\u0010oR\u001c\u0010±\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001b\u0010´\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001¨\u0006¶\u0001"}, d2 = {"Lcom/avito/android/public_profile/PublicProfileFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "()V", "onStart", "onStop", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "leaveScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLinkFromSubscriptions", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;)V", "openFavoriteSellers", "Lcom/avito/android/public_profile/ui/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnBackPressedListener", "(Lcom/avito/android/public_profile/ui/OnBackPressedListener;)V", "removeOnBackPressedListener", "onBackPressed", "()Z", "Lcom/avito/android/remote/model/Image;", "image", "showPhotoGallery", "(Lcom/avito/android/remote/model/Image;)V", "", "title", "text", "openShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "openAuthScreen", "openNotificationsSettings", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "getSnackbarPresenter", "()Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "setSnackbarPresenter", "(Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;)V", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "pagerAdapter", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "getPagerAdapter", "()Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "setPagerAdapter", "(Lcom/avito/android/design/widget/tab/TabPagerAdapter;)V", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "tabLayoutAdapter", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "getTabLayoutAdapter", "()Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "setTabLayoutAdapter", "(Lcom/avito/android/design/widget/tab/TabLayoutAdapter;)V", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "tracker", "Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "getTracker", "()Lcom/avito/android/public_profile/tracker/PublicProfileTracker;", "setTracker", "(Lcom/avito/android/public_profile/tracker/PublicProfileTracker;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", VKApiConst.Q, "Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "getNavigationState", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;", "setNavigationState", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/NavigationState;)V", "navigationState", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "subscriptionsPresenter", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "getSubscriptionsPresenter", "()Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "setSubscriptionsPresenter", "(Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;)V", "l", "Ljava/lang/String;", "contextId", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "", "j", "Ljava/util/List;", "backPressedListener", "n", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter$Router;", "router", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "o", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter$Router;", "subscribeRouter", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabsDataProvider", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "getTabsDataProvider", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "setTabsDataProvider", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;)V", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "publicProfilePresenter", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "getPublicProfilePresenter", "()Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "setPublicProfilePresenter", "(Lcom/avito/android/public_profile/ui/PublicProfilePresenter;)V", "k", "userKey", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "p", "Lcom/avito/android/deep_linking/links/DeepLink;", "nextDeepLink", "<init>", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileFragment extends TabBaseFragment implements PublicProfilePresenter.Router, SubscriptionsPresenter.Router, OnBackPressedListener {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public final List<com.avito.android.public_profile.ui.OnBackPressedListener> j = new ArrayList();
    public String k;
    public String l;
    public TreeClickStreamParent m;
    public PublicProfilePresenter.Router n;
    public SubscriptionsPresenter.Router o;
    public DeepLink p;
    @Inject
    public TabPagerAdapter pagerAdapter;
    @Inject
    public PublicProfilePresenter publicProfilePresenter;
    @NotNull
    public NavigationState q = new NavigationState(false);
    @Inject
    public CompositeSnackbarPresenter snackbarPresenter;
    @Inject
    public SubscriptionsPresenter subscriptionsPresenter;
    @Inject
    public TabLayoutAdapter<BaseTabItem> tabLayoutAdapter;
    @Inject
    public TabsDataProvider<BaseTabItem> tabsDataProvider;
    @Inject
    public PublicProfileTracker tracker;

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Exception exc2 = exc;
            Intrinsics.checkNotNullParameter(exc2, "it");
            Logs.error(exc2);
            return Unit.INSTANCE;
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void addOnBackPressedListener(@NotNull com.avito.android.public_profile.ui.OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!this.j.contains(onBackPressedListener)) {
            this.j.add(onBackPressedListener);
        }
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        int i = 1;
        if (deepLink instanceof SellerSubscribeLink) {
            PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
            if (publicProfilePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
            }
            publicProfilePresenter2.reloadProfileAdverts();
            SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
            if (subscriptionsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
            }
            subscriptionsPresenter2.onSubscribeLinkFollow(true);
        } else if (deepLink instanceof RefreshLink) {
            PublicProfilePresenter publicProfilePresenter3 = this.publicProfilePresenter;
            if (publicProfilePresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
            }
            publicProfilePresenter3.reloadProfileAdverts();
        } else {
            if (num != null) {
                i = num.intValue();
            } else if (deepLink instanceof AuthenticateLink) {
                i = 2;
            } else if (deepLink instanceof PhoneAddLink) {
                i = 3;
            }
            if (deepLink instanceof ChainedDeepLink) {
                this.p = ((ChainedDeepLink) deepLink).getThen();
            }
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
            if (intent != null) {
                startActivityForResult(IntentsKt.withClearTopFlags(intent), i);
            }
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void followDeepLinkFromSubscriptions(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        followDeepLink(deepLink, null);
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
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    @NotNull
    public NavigationState getNavigationState() {
        return this.q;
    }

    @NotNull
    public final TabPagerAdapter getPagerAdapter() {
        TabPagerAdapter tabPagerAdapter = this.pagerAdapter;
        if (tabPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        return tabPagerAdapter;
    }

    @NotNull
    public final PublicProfilePresenter getPublicProfilePresenter() {
        PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
        if (publicProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
        }
        return publicProfilePresenter2;
    }

    @NotNull
    public final CompositeSnackbarPresenter getSnackbarPresenter() {
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        return compositeSnackbarPresenter;
    }

    @NotNull
    public final SubscriptionsPresenter getSubscriptionsPresenter() {
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        return subscriptionsPresenter2;
    }

    @NotNull
    public final TabLayoutAdapter<BaseTabItem> getTabLayoutAdapter() {
        TabLayoutAdapter<BaseTabItem> tabLayoutAdapter2 = this.tabLayoutAdapter;
        if (tabLayoutAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutAdapter");
        }
        return tabLayoutAdapter2;
    }

    @NotNull
    public final TabsDataProvider<BaseTabItem> getTabsDataProvider() {
        TabsDataProvider<BaseTabItem> tabsDataProvider2 = this.tabsDataProvider;
        if (tabsDataProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsDataProvider");
        }
        return tabsDataProvider2;
    }

    @NotNull
    public final PublicProfileTracker getTracker() {
        PublicProfileTracker publicProfileTracker = this.tracker;
        if (publicProfileTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return publicProfileTracker;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter.Router
    public void leaveScreen() {
        if (!features().getPublicProfileWithoutActivity().invoke().booleanValue() || (getActivity() instanceof PublicProfileActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String stringExtra;
        DeepLink deepLink = this.p;
        String str = null;
        if (deepLink != null) {
            if (i2 == -1) {
                PublicProfilePresenter.Router.DefaultImpls.followDeepLink$default(this, deepLink, null, 2, null);
            }
            this.p = null;
            return;
        }
        boolean z = true;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    super.onActivityResult(i, i2, intent);
                } else if (i2 == -1) {
                    PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
                    if (publicProfilePresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
                    }
                    publicProfilePresenter2.onAuthCompleted();
                }
            } else if (i2 == -1) {
                PublicProfilePresenter publicProfilePresenter3 = this.publicProfilePresenter;
                if (publicProfilePresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
                }
                publicProfilePresenter3.onAuthCompleted();
                SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
                if (subscriptionsPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
                }
                subscriptionsPresenter2.onAuthCompleted();
            } else {
                SubscriptionsPresenter subscriptionsPresenter3 = this.subscriptionsPresenter;
                if (subscriptionsPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
                }
                subscriptionsPresenter3.onAuthCanceled();
            }
        } else if (intent != null && (stringExtra = intent.getStringExtra("message")) != null) {
            if (stringExtra.length() <= 0) {
                z = false;
            }
            if (z) {
                str = stringExtra;
            }
            if (str != null) {
                PublicProfilePresenter publicProfilePresenter4 = this.publicProfilePresenter;
                if (publicProfilePresenter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
                }
                publicProfilePresenter4.showMessage(str);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.n = this;
        this.o = this;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        boolean z;
        List<com.avito.android.public_profile.ui.OnBackPressedListener> list = this.j;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().onBackPressed()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = true;
        return !z;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new ShowPublicProfileScreenEvent());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PublicProfileTracker publicProfileTracker = this.tracker;
        if (publicProfileTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publicProfileTracker.startInit();
        return layoutInflater.inflate(R.layout.public_profile, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.detachView();
        PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
        if (publicProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
        }
        publicProfilePresenter2.detachView();
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.clear();
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (features().getPublicProfileWithoutActivity().invoke().booleanValue()) {
            Bundle bundle2 = new Bundle();
            PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
            if (publicProfilePresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
            }
            Bundles.putKundle(bundle2, "presenter_state", publicProfilePresenter2.onSaveState());
            SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
            if (subscriptionsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
            }
            Bundles.putKundle(bundle2, "subscriptions_state", subscriptionsPresenter2.onSaveState());
            Unit unit = Unit.INSTANCE;
            saveInRetainStorage(bundle2);
            return;
        }
        PublicProfilePresenter publicProfilePresenter3 = this.publicProfilePresenter;
        if (publicProfilePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
        }
        Bundles.putKundle(bundle, "presenter_state", publicProfilePresenter3.onSaveState());
        SubscriptionsPresenter subscriptionsPresenter3 = this.subscriptionsPresenter;
        if (subscriptionsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        Bundles.putKundle(bundle, "subscriptions_state", subscriptionsPresenter3.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.attachRouter(this.o);
        PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
        if (publicProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
        }
        publicProfilePresenter2.attachRouter(this.n);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.detachRouter();
        PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
        if (publicProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
        }
        publicProfilePresenter2.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.subscribe_info);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        SubscribeButtonsViewImpl subscribeButtonsViewImpl = new SubscribeButtonsViewImpl(findViewById, null, 2, null);
        PublicProfilePresenter publicProfilePresenter2 = this.publicProfilePresenter;
        if (publicProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
        }
        TabLayoutAdapter<BaseTabItem> tabLayoutAdapter2 = this.tabLayoutAdapter;
        if (tabLayoutAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayoutAdapter");
        }
        TabPagerAdapter tabPagerAdapter = this.pagerAdapter;
        if (tabPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        PublicProfileViewImpl publicProfileViewImpl = new PublicProfileViewImpl(view, publicProfilePresenter2, tabLayoutAdapter2, tabPagerAdapter, subscribeButtonsViewImpl, analytics2);
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter2.attachContainerView(publicProfileViewImpl);
        SubscriptionsPresenter subscriptionsPresenter3 = this.subscriptionsPresenter;
        if (subscriptionsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter3.attachCounterView(publicProfileViewImpl);
        SubscriptionsPresenter subscriptionsPresenter4 = this.subscriptionsPresenter;
        if (subscriptionsPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        subscriptionsPresenter4.attachButtonsView(publicProfileViewImpl);
        PublicProfilePresenter publicProfilePresenter3 = this.publicProfilePresenter;
        if (publicProfilePresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicProfilePresenter");
        }
        publicProfilePresenter3.attachView(publicProfileViewImpl);
        CompositeSnackbarPresenter compositeSnackbarPresenter = this.snackbarPresenter;
        if (compositeSnackbarPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter.setDefaultElement(publicProfileViewImpl);
        CompositeSnackbarPresenter compositeSnackbarPresenter2 = this.snackbarPresenter;
        if (compositeSnackbarPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbarPresenter");
        }
        compositeSnackbarPresenter2.addOptionalElement(subscribeButtonsViewImpl);
        PublicProfileTracker publicProfileTracker = this.tracker;
        if (publicProfileTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publicProfileTracker.trackInit();
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openAuthScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        FragmentsKt.startActivityForResultSafely(this, IntentsKt.withClearTopFlags(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.SUBSCRIBE_SELLER, null, 5, null)), 2, a.a);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openFavoriteSellers(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void openNotificationsSettings() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter.Router
    public void openShareDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(Intent.createChooser(implicitIntentFactory2.shareItemIntent(str2, str), getString(R.string.menu_share)));
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsPresenter.Router
    public void removeOnBackPressedListener(@NotNull com.avito.android.public_profile.ui.OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.j.remove(onBackPressedListener);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment
    public void setNavigationState(@NotNull NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(navigationState, "<set-?>");
        this.q = navigationState;
    }

    public final void setPagerAdapter(@NotNull TabPagerAdapter tabPagerAdapter) {
        Intrinsics.checkNotNullParameter(tabPagerAdapter, "<set-?>");
        this.pagerAdapter = tabPagerAdapter;
    }

    public final void setPublicProfilePresenter(@NotNull PublicProfilePresenter publicProfilePresenter2) {
        Intrinsics.checkNotNullParameter(publicProfilePresenter2, "<set-?>");
        this.publicProfilePresenter = publicProfilePresenter2;
    }

    public final void setSnackbarPresenter(@NotNull CompositeSnackbarPresenter compositeSnackbarPresenter) {
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "<set-?>");
        this.snackbarPresenter = compositeSnackbarPresenter;
    }

    public final void setSubscriptionsPresenter(@NotNull SubscriptionsPresenter subscriptionsPresenter2) {
        Intrinsics.checkNotNullParameter(subscriptionsPresenter2, "<set-?>");
        this.subscriptionsPresenter = subscriptionsPresenter2;
    }

    public final void setTabLayoutAdapter(@NotNull TabLayoutAdapter<BaseTabItem> tabLayoutAdapter2) {
        Intrinsics.checkNotNullParameter(tabLayoutAdapter2, "<set-?>");
        this.tabLayoutAdapter = tabLayoutAdapter2;
    }

    public final void setTabsDataProvider(@NotNull TabsDataProvider<BaseTabItem> tabsDataProvider2) {
        Intrinsics.checkNotNullParameter(tabsDataProvider2, "<set-?>");
        this.tabsDataProvider = tabsDataProvider2;
    }

    public final void setTracker(@NotNull PublicProfileTracker publicProfileTracker) {
        Intrinsics.checkNotNullParameter(publicProfileTracker, "<set-?>");
        this.tracker = publicProfileTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        PublicProfileArguments publicProfileArguments;
        if (features().getPublicProfileWithoutActivity().invoke().booleanValue()) {
            bundle = retainStorage();
        }
        Bundle arguments = getArguments();
        if (arguments == null || (publicProfileArguments = (PublicProfileArguments) arguments.getParcelable("arguments")) == null) {
            throw new IllegalArgumentException("PublicProfileArguments must be specified");
        }
        this.k = publicProfileArguments.getUserKey();
        Screen screen = publicProfileArguments.getScreen();
        boolean isSubComponent = publicProfileArguments.isSubComponent();
        this.l = publicProfileArguments.getContextId();
        this.m = publicProfileArguments.getTreeParent();
        DefaultPublicUserProfile userProfile = publicProfileArguments.getUserProfile();
        Kundle kundle = null;
        Kundle kundle2 = bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null;
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "subscriptions_state");
        }
        Timer B1 = a2.b.a.a.a.B1();
        PublicProfileFragmentComponent.Builder publicProfileFragmentDependencies = DaggerPublicProfileFragmentComponent.builder().publicProfileFragmentDependencies((PublicProfileFragmentDependencies) ComponentDependenciesKt.getDependencies(PublicProfileFragmentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        PublicProfileFragmentComponent.Builder bindResources = publicProfileFragmentDependencies.bindResources(resources);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        PublicProfileFragmentComponent.Builder bindFragmentManager = bindResources.bindFragmentManager(childFragmentManager);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        PublicProfileFragmentComponent.Builder bindTreeParent = bindFragmentManager.bindActivity(requireActivity).bindContextId(this.l).bindTreeParent(this.m);
        String str = this.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userKey");
        }
        bindTreeParent.bindUserKey(str).withScreen(screen).withSubComponent(isSubComponent).bindPresenterState(kundle2).bindSubscriptionsState(kundle).bindPublicUserProfile(userProfile).build().inject(this);
        PublicProfileTracker publicProfileTracker = this.tracker;
        if (publicProfileTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publicProfileTracker.trackDiInject(B1.elapsed());
        if (bundle != null) {
            return true;
        }
        SubscriptionsPresenter subscriptionsPresenter2 = this.subscriptionsPresenter;
        if (subscriptionsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionsPresenter");
        }
        String str2 = this.k;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userKey");
        }
        subscriptionsPresenter2.setUserData(str2, this.l);
        ScreenTransfer screenTransfer = publicProfileArguments.getScreenTransfer();
        if (screenTransfer == null) {
            return true;
        }
        PublicProfileTracker publicProfileTracker2 = this.tracker;
        if (publicProfileTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publicProfileTracker2.recover(screenTransfer);
        return true;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfilePresenter.Router
    public void showPhotoGallery(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(IntentsKt.withClearTopFlags(PhotoGalleryIntentFactory.DefaultImpls.legacyPhotoGalleryIntent$default(activityIntentFactory2, null, d.listOf(image), 0, null, null, null, null, null, null, null, null, null, 4088, null)));
        String str = this.k;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userKey");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new AvatarPreviewEvent(str));
    }
}

package com.avito.android.profile;

import a2.b.a.a.a;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.PhoneManagementIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ShowProfileScreenEvent;
import com.avito.android.analytics.screen.UserProfileTracker;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.TabRootFragment;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFloatingActionButton;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.di.DaggerUserProfileComponent;
import com.avito.android.profile.di.UserProfileComponent;
import com.avito.android.profile.di.UserProfileDependencies;
import com.avito.android.profile.di.UserProfileModule;
import com.avito.android.public_profile_stuff.R;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentHandler;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.facebook.share.internal.ShareConstants;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\b¢\u0006\u0005\b¸\u0001\u0010\fJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\nH\u0016¢\u0006\u0004\b'\u0010\fJ\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\fJ\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\fJ\u0017\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u0010\fJ\u000f\u00100\u001a\u00020\nH\u0016¢\u0006\u0004\b0\u0010\fJ\u000f\u00101\u001a\u00020\nH\u0016¢\u0006\u0004\b1\u0010\fJ\u000f\u00102\u001a\u00020\nH\u0016¢\u0006\u0004\b2\u0010\fJ\u000f\u00103\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u0010\fJ\u000f\u00104\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u0010\fJ\u0017\u00107\u001a\u00020\n2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J'\u0010=\u001a\u00020\n2\u0006\u00106\u001a\u0002052\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020\n2\u0006\u0010C\u001a\u00020;H\u0016¢\u0006\u0004\bF\u0010EJ\u000f\u0010G\u001a\u00020\nH\u0016¢\u0006\u0004\bG\u0010\fJ\u001f\u0010J\u001a\u00020\n2\u0006\u0010H\u001a\u00020;2\u0006\u0010I\u001a\u00020;H\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\nH\u0016¢\u0006\u0004\bL\u0010\fJ\u000f\u0010M\u001a\u00020\nH\u0016¢\u0006\u0004\bM\u0010\fJ\u0019\u0010O\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bO\u0010EJ!\u0010R\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u00072\b\u0010Q\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\nH\u0016¢\u0006\u0004\bT\u0010\fJ\u0017\u0010W\u001a\u00020\u00072\u0006\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\"\u0010e\u001a\u00020d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010l\u001a\u00020k8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\"\u0010s\u001a\u00020r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010z\u001a\u00020y8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0000@\u0000X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R*\u0010¤\u0001\u001a\u00030£\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R*\u0010«\u0001\u001a\u00030ª\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R*\u0010²\u0001\u001a\u00030±\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001¨\u0006¹\u0001"}, d2 = {"Lcom/avito/android/profile/UserProfileFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/profile/UserProfilePresenter$Router;", "Lcom/avito/android/util/IntentHandler;", "Lcom/avito/android/bottom_navigation/ui/fragment/TabRootFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onResume", "()V", "onStart", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "handleIntent", "(Landroid/content/Intent;)V", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "showLoginScreen", "closeScreen", "openSubscriptionDetails", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "openPasswordActionDeeplink", "openEditProfileScreen", "openUserAdvertsScreen", "openSocialNetworksScreen", "openAttachPhone", "openAddPhone", "openPhonesList", "Lcom/avito/android/remote/model/user_profile/Phone;", "phone", "openRemovePhone", "(Lcom/avito/android/remote/model/user_profile/Phone;)V", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "codeInfo", "", "src", "openVerifyPhone", "(Lcom/avito/android/remote/model/user_profile/Phone;Lcom/avito/android/code_confirmation/model/CodeInfo;Ljava/lang/String;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openDeliverySettings", "(Landroid/net/Uri;)V", "url", "openHelpCenter", "(Ljava/lang/String;)V", "openWebViewScreen", "openWalletPage", "title", "text", "openShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "openSettings", "openNotificationCenter", "source", "openSessionsListScreen", "isEnabled", "warning", "openTfaSettings", "(ZLjava/lang/String;)V", "onBackPressed", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "isRoot", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Z", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$profile_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$profile_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/profile/UserProfileView;", "j", "Lcom/avito/android/profile/UserProfileView;", "profileView", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/profile/UserProfilePresenter;", "presenter", "Lcom/avito/android/profile/UserProfilePresenter;", "getPresenter", "()Lcom/avito/android/profile/UserProfilePresenter;", "setPresenter", "(Lcom/avito/android/profile/UserProfilePresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/screen/UserProfileTracker;", "tracker", "Lcom/avito/android/analytics/screen/UserProfileTracker;", "getTracker$profile_release", "()Lcom/avito/android/analytics/screen/UserProfileTracker;", "setTracker$profile_release", "(Lcom/avito/android/analytics/screen/UserProfileTracker;)V", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "tabTestGroup", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "getTabTestGroup$profile_release", "()Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "setTabTestGroup$profile_release", "(Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;)V", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "Lcom/avito/android/cart_fab/CartFabViewModel;", "getCartFabViewModel$profile_release", "()Lcom/avito/android/cart_fab/CartFabViewModel;", "setCartFabViewModel$profile_release", "(Lcom/avito/android/cart_fab/CartFabViewModel;)V", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "cartQuantityHandler", "Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "getCartQuantityHandler$profile_release", "()Lcom/avito/android/cart_fab/CartQuantityChangesHandler;", "setCartQuantityHandler$profile_release", "(Lcom/avito/android/cart_fab/CartQuantityChangesHandler;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/profile/UserProfileInteractor;", "interactor", "Lcom/avito/android/profile/UserProfileInteractor;", "getInteractor", "()Lcom/avito/android/profile/UserProfileInteractor;", "setInteractor", "(Lcom/avito/android/profile/UserProfileInteractor;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileFragment extends TabBaseFragment implements UserProfilePresenter.Router, IntentHandler, TabRootFragment {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public CartFabViewModel cartFabViewModel;
    @Inject
    public CartQuantityChangesHandler cartQuantityHandler;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public UserProfileInteractor interactor;
    @Inject
    public ItemBinder itemBinder;
    public UserProfileView j;
    @Inject
    public UserProfilePresenter presenter;
    @Inject
    public UserAdvertsTabTestGroup tabTestGroup;
    @Inject
    public UserProfileTracker tracker;

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void closeScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent addFlags = activityIntentFactory2.homeIntent().addFlags(268468224);
        Intrinsics.checkNotNullExpressionValue(addFlags, "activityIntentFactory.ho…FLAG_ACTIVITY_CLEAR_TASK)");
        startActivity(addFlags);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent == null) {
            return;
        }
        if (IntentsKt.getTabFragmentData(intent) == null) {
            startActivityForResult(com.avito.android.util.IntentsKt.withClearTopFlags(intent), 10);
        } else {
            startForResult(com.avito.android.util.IntentsKt.withClearTopFlags(intent), 10);
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
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics$profile_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final CartFabViewModel getCartFabViewModel$profile_release() {
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        return cartFabViewModel2;
    }

    @NotNull
    public final CartQuantityChangesHandler getCartQuantityHandler$profile_release() {
        CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
        if (cartQuantityChangesHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
        }
        return cartQuantityChangesHandler;
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

    @NotNull
    public final UserProfileInteractor getInteractor() {
        UserProfileInteractor userProfileInteractor = this.interactor;
        if (userProfileInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return userProfileInteractor;
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
    public final UserProfilePresenter getPresenter() {
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return userProfilePresenter;
    }

    @NotNull
    public final UserAdvertsTabTestGroup getTabTestGroup$profile_release() {
        UserAdvertsTabTestGroup userAdvertsTabTestGroup = this.tabTestGroup;
        if (userAdvertsTabTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
        }
        return userAdvertsTabTestGroup;
    }

    @NotNull
    public final UserProfileTracker getTracker$profile_release() {
        UserProfileTracker userProfileTracker = this.tracker;
        if (userProfileTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return userProfileTracker;
    }

    @Override // com.avito.android.util.IntentHandler
    public void handleIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userProfilePresenter.onStateInvalidated();
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.TabRootFragment
    public boolean isRoot(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return Intrinsics.areEqual(navigationTabSetItem, NavigationTab.PROFILE_SETTINGS.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        UserProfileView userProfileView;
        UserProfileView userProfileView2;
        super.onActivityResult(i, i2, intent);
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter = this.presenter;
                    if (userProfilePresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter.onAuthenticationSuccess();
                    return;
                }
                closeScreen();
                return;
            case 2:
            case 3:
            case 4:
            case 9:
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter2 = this.presenter;
                    if (userProfilePresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter2.onStateInvalidated();
                    return;
                }
                return;
            case 5:
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter3 = this.presenter;
                    if (userProfilePresenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter3.onStateInvalidated();
                    return;
                } else if (i2 == 0) {
                    if (intent != null) {
                        str = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT);
                    }
                    if (str != null && (userProfileView = this.j) != null) {
                        userProfileView.showSnackbar(str);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 6:
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter4 = this.presenter;
                    if (userProfilePresenter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter4.onPhoneAttached();
                    return;
                }
                return;
            case 7:
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter5 = this.presenter;
                    if (userProfilePresenter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter5.onPhoneVerified();
                    return;
                }
                return;
            case 8:
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter6 = this.presenter;
                    if (userProfilePresenter6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter6.onPhoneRemoved();
                    return;
                }
                return;
            case 10:
                if (intent != null) {
                    str = intent.getStringExtra("result_message");
                }
                UserProfilePresenter userProfilePresenter7 = this.presenter;
                if (userProfilePresenter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                userProfilePresenter7.onDeepLinkResult(str);
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter8 = this.presenter;
                    if (userProfilePresenter8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter8.onStateInvalidated();
                    return;
                }
                return;
            case 11:
                if (i2 == -1) {
                    if (intent != null) {
                        str = intent.getStringExtra(ProfileConstants.PASSWORD_CHANGE_RESULT);
                    }
                    if (!(str == null || (userProfileView2 = this.j) == null)) {
                        userProfileView2.showSnackbar(str);
                    }
                    boolean z = false;
                    if (intent != null) {
                        z = intent.getBooleanExtra(ProfileConstants.PASSWORD_CHANGE_UPDATE_PROFILE, false);
                    }
                    if (z) {
                        UserProfilePresenter userProfilePresenter9 = this.presenter;
                        if (userProfilePresenter9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("presenter");
                        }
                        userProfilePresenter9.onStateInvalidated();
                        return;
                    }
                    return;
                }
                return;
            case 12:
            default:
                return;
            case 13:
                if (i2 == -1) {
                    UserProfilePresenter userProfilePresenter10 = this.presenter;
                    if (userProfilePresenter10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter10.onStateInvalidated();
                    return;
                }
                return;
            case 14:
                if (i2 == -1) {
                    if (intent != null) {
                        str = intent.getStringExtra("result_message");
                    }
                    UserProfilePresenter userProfilePresenter11 = this.presenter;
                    if (userProfilePresenter11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    userProfilePresenter11.onPhoneAdded(str);
                    return;
                }
                return;
        }
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter.Router
    public void onBackPressed() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.user_profile, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userProfilePresenter.detachView();
        UserProfileView userProfileView = this.j;
        if (userProfileView != null) {
            userProfileView.destroy();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userProfilePresenter.onResume();
        CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
        if (cartFabViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
        }
        cartFabViewModel2.loadCartSize();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", userProfilePresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userProfilePresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userProfilePresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new ShowProfileScreenEvent());
            Unit unit = Unit.INSTANCE;
        }
        UserProfileTracker userProfileTracker = this.tracker;
        if (userProfileTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userProfileTracker.startInit();
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        UserProfilePresenter userProfilePresenter = this.presenter;
        if (userProfilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics3 = this.analytics;
        if (analytics3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        UserProfileViewImpl userProfileViewImpl = new UserProfileViewImpl(view, adapterPresenter2, itemBinder2, userProfilePresenter, analytics3, false, 32, null);
        UserProfilePresenter userProfilePresenter2 = this.presenter;
        if (userProfilePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userProfilePresenter2.attachView(userProfileViewImpl);
        this.j = userProfileViewImpl;
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getCartFloatingActionButton().invoke().booleanValue()) {
            UserAdvertsTabTestGroup userAdvertsTabTestGroup = this.tabTestGroup;
            if (userAdvertsTabTestGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabTestGroup");
            }
            if (userAdvertsTabTestGroup.isTest()) {
                View findViewById = view.findViewById(R.id.cart_fab_stub);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
                View inflate = ((ViewStub) findViewById).inflate();
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.cart_fab.CartFloatingActionButton");
                CartFloatingActionButton cartFloatingActionButton = (CartFloatingActionButton) inflate;
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                CartFabViewModel cartFabViewModel2 = this.cartFabViewModel;
                if (cartFabViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cartFabViewModel");
                }
                CartQuantityChangesHandler cartQuantityChangesHandler = this.cartQuantityHandler;
                if (cartQuantityChangesHandler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cartQuantityHandler");
                }
                DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
                if (deepLinkIntentFactory2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
                }
                new CartFabView(cartFloatingActionButton, viewLifecycleOwner, cartFabViewModel2, cartQuantityChangesHandler, deepLinkIntentFactory2);
            }
        }
        UserProfileTracker userProfileTracker2 = this.tracker;
        if (userProfileTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userProfileTracker2.trackInit();
        if (bundle != null ? bundle.getBoolean("edit_profile") : false) {
            openEditProfileScreen();
        }
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openAddPhone() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startForResult(activityIntentFactory2.addPhoneIntent(), 14);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openAttachPhone() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(PhoneManagementIntentFactory.DefaultImpls.phoneManagementIntent$default(activityIntentFactory2, null, false, 0, true, null, 23, null), 6);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openDeliverySettings(@NotNull Uri uri) {
        Intent intent;
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getProfileDeliverySettingsRedesign().invoke().booleanValue()) {
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            intent = activityIntentFactory2.profileRdsDeliverySettingsIntent();
        } else {
            ActivityIntentFactory activityIntentFactory3 = this.activityIntentFactory;
            if (activityIntentFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            intent = activityIntentFactory3.deliveryProfileSettingsIntent();
        }
        startActivityForResult(intent, 9);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openEditProfileScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.createEditProfileIntent(), 4);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openHelpCenter(@Nullable String str) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.helpCenterIntent(str));
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter.Router
    public void openNotificationCenter() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.notificationCenterIntent());
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openPasswordActionDeeplink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivityForResult(intent, 11);
        }
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openPhonesList() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startForResult(activityIntentFactory2.phonesListIntent(), 12);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openRemovePhone(@NotNull Phone phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        String phone2 = phone.getPhone();
        boolean verified = phone.getVerified();
        Integer itemsCount = phone.getItemsCount();
        startActivityForResult(PhoneManagementIntentFactory.DefaultImpls.phoneManagementIntent$default(activityIntentFactory2, phone2, verified, itemsCount != null ? itemsCount.intValue() : 0, true, null, 16, null), 8);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openSessionsListScreen(@Nullable String str) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.sessionsListIntent(str));
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter.Router
    public void openSettings() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.settingsIntent(currentTab()));
    }

    @Override // com.avito.android.profile.header.ProfileHeaderPresenter.Router
    public void openShareDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(Intent.createChooser(implicitIntentFactory2.shareItemIntent(str2, str), getString(R.string.menu_share)));
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openSocialNetworksScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.socialManagementIntent(), 3);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openSubscriptionDetails() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.serviceSubscriptionActivityIntent());
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openTfaSettings(boolean z, @Nullable String str) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.tfaSettingsIntent(z, str), 13);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openUserAdvertsScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(activityIntentFactory2, null, null, false, 7, null), 2);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openVerifyPhone(@NotNull Phone phone, @NotNull CodeInfo codeInfo, @NotNull String str) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(codeInfo, "codeInfo");
        Intrinsics.checkNotNullParameter(str, "src");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.codeConfirmationIntent(phone.getPhone(), null, codeInfo.getText(), codeInfo.getTimeout(), codeInfo.getLength(), str), 7);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openWalletPage() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.walletPageIntent(), 5);
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void openWebViewScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        Intent externalUriIntent = implicitIntentFactory2.externalUriIntent(parse, null);
        if (externalUriIntent != null) {
            startActivity(externalUriIntent);
        }
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics$profile_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setCartFabViewModel$profile_release(@NotNull CartFabViewModel cartFabViewModel2) {
        Intrinsics.checkNotNullParameter(cartFabViewModel2, "<set-?>");
        this.cartFabViewModel = cartFabViewModel2;
    }

    public final void setCartQuantityHandler$profile_release(@NotNull CartQuantityChangesHandler cartQuantityChangesHandler) {
        Intrinsics.checkNotNullParameter(cartQuantityChangesHandler, "<set-?>");
        this.cartQuantityHandler = cartQuantityChangesHandler;
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

    public final void setInteractor(@NotNull UserProfileInteractor userProfileInteractor) {
        Intrinsics.checkNotNullParameter(userProfileInteractor, "<set-?>");
        this.interactor = userProfileInteractor;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull UserProfilePresenter userProfilePresenter) {
        Intrinsics.checkNotNullParameter(userProfilePresenter, "<set-?>");
        this.presenter = userProfilePresenter;
    }

    public final void setTabTestGroup$profile_release(@NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup) {
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "<set-?>");
        this.tabTestGroup = userAdvertsTabTestGroup;
    }

    public final void setTracker$profile_release(@NotNull UserProfileTracker userProfileTracker) {
        Intrinsics.checkNotNullParameter(userProfileTracker, "<set-?>");
        this.tracker = userProfileTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null;
        Timer B1 = a.B1();
        UserProfileComponent.Builder dependencies = DaggerUserProfileComponent.builder().dependencies((UserProfileDependencies) ComponentDependenciesKt.getDependencies(UserProfileDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        UserProfileComponent.Builder with = dependencies.with(requireActivity);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        UserProfileComponent.Builder with2 = with.with(resources);
        Resources resources2 = getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "resources");
        with2.plus(new UserProfileModule(resources2, kundle)).withSrc("").withRetry(false).withViewModelStoreOwner(this).build().inject(this);
        UserProfileTracker userProfileTracker = this.tracker;
        if (userProfileTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        userProfileTracker.trackDiInject(B1.elapsed());
        return true;
    }

    @Override // com.avito.android.profile.UserProfilePresenter.Router
    public void showLoginScreen() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent authIntent$default = AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, "up", null, 5, null);
        authIntent$default.setFlags(603979776);
        startActivityForResult(authIntent$default, 1);
    }
}

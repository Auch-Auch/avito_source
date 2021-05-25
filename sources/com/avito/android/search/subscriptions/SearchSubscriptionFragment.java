package com.avito.android.search.subscriptions;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.SearchSubscriptionsViewEvent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.common.ConstantsKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.search.subscriptions.SearchSubscriptionPresenter;
import com.avito.android.search.subscriptions.di.DaggerSearchSubscriptionComponent;
import com.avito.android.search.subscriptions.di.SearchSubscriptionComponent;
import com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies;
import com.avito.android.tracker.SearchSubscriptionsTracker;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b|\u0010\u0012J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J!\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001c\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\u0012J)\u0010'\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010\u0012J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010\u0012R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010]\u001a\u00020\\8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bd\u0010eR\"\u0010h\u001a\u00020g8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010o\u001a\u00020n8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010v\u001a\u00020u8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{¨\u0006}"}, d2 = {"Lcom/avito/android/search/subscriptions/SearchSubscriptionFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter$Router;", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onResume", "()V", "onPause", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onAuthRequired", "", "id", "title", "openSearchSubscription", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "closeScreen", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "scrollToUp", "showNotificationSettingsScreen", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "savedSearchPresenter", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "getSavedSearchPresenter", "()Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "setSavedSearchPresenter", "(Lcom/avito/android/saved_searches/SavedSearchesPresenter;)V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "presenter", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "getPresenter", "()Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "setPresenter", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;)V", "Lcom/avito/android/tracker/SearchSubscriptionsTracker;", "tracker", "Lcom/avito/android/tracker/SearchSubscriptionsTracker;", "getTracker$subscriptions_release", "()Lcom/avito/android/tracker/SearchSubscriptionsTracker;", "setTracker$subscriptions_release", "(Lcom/avito/android/tracker/SearchSubscriptionsTracker;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$subscriptions_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$subscriptions_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/search/subscriptions/SearchSubscriptionView;", "c", "Lcom/avito/android/search/subscriptions/SearchSubscriptionView;", "searchSubscriptionView", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "getNotificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "setNotificationManagerProvider", "(Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "<init>", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionFragment extends BaseFragment implements SearchSubscriptionPresenter.Router, ScrollToUpHandler {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    public SearchSubscriptionView c;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public NotificationManagerProvider notificationManagerProvider;
    @Inject
    public SearchSubscriptionPresenter presenter;
    @Inject
    public SavedSearchesPresenter savedSearchPresenter;
    @Inject
    public SearchSubscriptionsTracker tracker;

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter.Router
    public void closeScreen() {
        requireActivity().finish();
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
    public final Analytics getAnalytics$subscriptions_release() {
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

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final NotificationManagerProvider getNotificationManagerProvider() {
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        return notificationManagerProvider2;
    }

    @NotNull
    public final SearchSubscriptionPresenter getPresenter() {
        SearchSubscriptionPresenter searchSubscriptionPresenter = this.presenter;
        if (searchSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return searchSubscriptionPresenter;
    }

    @NotNull
    public final SavedSearchesPresenter getSavedSearchPresenter() {
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        return savedSearchesPresenter;
    }

    @NotNull
    public final SearchSubscriptionsTracker getTracker$subscriptions_release() {
        SearchSubscriptionsTracker searchSubscriptionsTracker = this.tracker;
        if (searchSubscriptionsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return searchSubscriptionsTracker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = true;
        if (i == 1) {
            SearchSubscriptionPresenter searchSubscriptionPresenter = this.presenter;
            if (searchSubscriptionPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            if (i2 != -1) {
                z = false;
            }
            searchSubscriptionPresenter.onLoginResult(z);
        } else if (i != 2) {
            super.onActivityResult(i, i2, intent);
        } else {
            SearchSubscriptionPresenter searchSubscriptionPresenter2 = this.presenter;
            if (searchSubscriptionPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            searchSubscriptionPresenter2.onRefresh();
        }
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter.Router
    public void onAuthRequired() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent flags = AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.OPEN_SEARCH_SUBSCRIPTIONS, null, 5, null).setFlags(603979776);
        Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory\n  ….FLAG_ACTIVITY_CLEAR_TOP)");
        startActivityForResult(flags, 1);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        SearchSubscriptionsTracker searchSubscriptionsTracker = this.tracker;
        if (searchSubscriptionsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        searchSubscriptionsTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.saved_search, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        SearchSubscriptionPresenter searchSubscriptionPresenter = this.presenter;
        if (searchSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        Bundle arguments = getArguments();
        Integer num = null;
        if (arguments != null && arguments.containsKey(ConstantsKt.KEY_LIST_BOTTOM_PADDING)) {
            num = Integer.valueOf(arguments.getInt(ConstantsKt.KEY_LIST_BOTTOM_PADDING));
        }
        this.c = new SearchSubscriptionViewImpl(inflate, searchSubscriptionPresenter, adapterPresenter2, itemBinder2, analytics2, num);
        SearchSubscriptionPresenter searchSubscriptionPresenter2 = this.presenter;
        if (searchSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        SearchSubscriptionView searchSubscriptionView = this.c;
        if (searchSubscriptionView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSubscriptionView");
        }
        searchSubscriptionPresenter2.attachView(searchSubscriptionView);
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        SearchSubscriptionView searchSubscriptionView2 = this.c;
        if (searchSubscriptionView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSubscriptionView");
        }
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        savedSearchesPresenter.attachView(searchSubscriptionView2, notificationManagerProvider2.getAreNotificationsEnabled());
        SearchSubscriptionPresenter searchSubscriptionPresenter3 = this.presenter;
        if (searchSubscriptionPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        searchSubscriptionPresenter3.attachRouter(this);
        SearchSubscriptionsTracker searchSubscriptionsTracker2 = this.tracker;
        if (searchSubscriptionsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        searchSubscriptionsTracker2.trackInit();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SearchSubscriptionPresenter searchSubscriptionPresenter = this.presenter;
        if (searchSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        searchSubscriptionPresenter.detachRouter();
        SearchSubscriptionPresenter searchSubscriptionPresenter2 = this.presenter;
        if (searchSubscriptionPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        searchSubscriptionPresenter2.detachView();
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        savedSearchesPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SearchSubscriptionPresenter searchSubscriptionPresenter = this.presenter;
        if (searchSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        searchSubscriptionPresenter.onViewPaused();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SearchSubscriptionPresenter searchSubscriptionPresenter = this.presenter;
        if (searchSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        searchSubscriptionPresenter.onResume();
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        NotificationManagerProvider notificationManagerProvider2 = this.notificationManagerProvider;
        if (notificationManagerProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManagerProvider");
        }
        savedSearchesPresenter.setPushEnabled(notificationManagerProvider2.getAreNotificationsEnabled());
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new SearchSubscriptionsViewEvent());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        SearchSubscriptionPresenter searchSubscriptionPresenter = this.presenter;
        if (searchSubscriptionPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter_state", searchSubscriptionPresenter.onSaveState());
        SavedSearchesPresenter savedSearchesPresenter = this.savedSearchPresenter;
        if (savedSearchesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("savedSearchPresenter");
        }
        bundle.putBundle("saved_search_state", savedSearchesPresenter.onSaveState().toBundle());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter.Router
    public void openSearchSubscription(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.searchSubscriptionIntent(str), 2);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ScrollToUpHandler
    public void scrollToUp() {
        SearchSubscriptionView searchSubscriptionView = this.c;
        if (searchSubscriptionView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchSubscriptionView");
        }
        searchSubscriptionView.scrollToTop();
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics$subscriptions_release(@NotNull Analytics analytics2) {
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

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setNotificationManagerProvider(@NotNull NotificationManagerProvider notificationManagerProvider2) {
        Intrinsics.checkNotNullParameter(notificationManagerProvider2, "<set-?>");
        this.notificationManagerProvider = notificationManagerProvider2;
    }

    public final void setPresenter(@NotNull SearchSubscriptionPresenter searchSubscriptionPresenter) {
        Intrinsics.checkNotNullParameter(searchSubscriptionPresenter, "<set-?>");
        this.presenter = searchSubscriptionPresenter;
    }

    public final void setSavedSearchPresenter(@NotNull SavedSearchesPresenter savedSearchesPresenter) {
        Intrinsics.checkNotNullParameter(savedSearchesPresenter, "<set-?>");
        this.savedSearchPresenter = savedSearchesPresenter;
    }

    public final void setTracker$subscriptions_release(@NotNull SearchSubscriptionsTracker searchSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(searchSubscriptionsTracker, "<set-?>");
        this.tracker = searchSubscriptionsTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3 = bundle != null ? bundle.getBundle("presenter_state") : null;
        if (bundle == null || (bundle2 = bundle.getBundle("saved_search_state")) == null) {
            bundle2 = new Bundle();
        }
        Intrinsics.checkNotNullExpressionValue(bundle2, "savedInstanceState?.getB…SEARCH_STATE) ?: Bundle()");
        Timer timer = new TimerFactory().timer();
        timer.start();
        SearchSubscriptionComponent.Builder withPresenterState = DaggerSearchSubscriptionComponent.builder().dependentOn((SearchSubscriptionDependencies) ComponentDependenciesKt.getDependencies(SearchSubscriptionDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withPresenterState(bundle3);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        SearchSubscriptionComponent.Builder withContext = withPresenterState.withContext(requireContext);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        withContext.withResources(resources).withSavedSearchState(new Kundle(bundle2)).build().inject(this);
        SearchSubscriptionsTracker searchSubscriptionsTracker = this.tracker;
        if (searchSubscriptionsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        searchSubscriptionsTracker.trackDiInject(timer.elapsed());
        return true;
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter.Router
    public void showNotificationSettingsScreen() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.notificationsSettingsIntent());
    }

    @Override // com.avito.android.search.subscriptions.SearchSubscriptionPresenter.Router
    public void openSearchSubscription(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            IntentsKt.replaceTargetTabIfRequired(intent, NavigationTab.FAVORITES.INSTANCE);
        }
        if (intent != null) {
            startActivityForResult(intent, 2);
        }
    }
}

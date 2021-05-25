package com.avito.android.user_adverts.items_search;

import a2.a.a.i3.b.b;
import a2.a.a.i3.b.c;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.helpers.UserAdvertsHelpersKt;
import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker;
import com.avito.android.user_adverts.items_search.di.DaggerProfileItemsSearchComponent;
import com.avito.android.user_adverts.items_search.di.ProfileItemsSearchComponent;
import com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListView;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListViewImpl;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertsListAdapterModule;
import com.avito.android.user_adverts_common.safety.UserAdvertConstants;
import com.avito.android.util.Constants;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\\\u0010\u001aJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001aR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R,\u0010=\u001a\f\u0012\u0004\u0012\u00020;0:j\u0002`<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onResume", "()V", "onPause", "onDestroyView", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "emptyQuery", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "profileItemsViewModel", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "getProfileItemsViewModel", "()Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "setProfileItemsViewModel", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;)V", "Lcom/avito/android/user_adverts/items_search/SearchBar;", "k", "Lcom/avito/android/user_adverts/items_search/SearchBar;", "searchBar", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionObservable;", "itemActions", "Lio/reactivex/Observable;", "getItemActions", "()Lio/reactivex/Observable;", "setItemActions", "(Lio/reactivex/Observable;)V", "Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "tracker", "Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "getTracker", "()Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "setTracker", "(Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;)V", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "viewHolderBuilder", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "getViewHolderBuilder", "()Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "setViewHolderBuilder", "(Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "j", "Lcom/avito/android/user_adverts/tab_screens/UserAdvertsListView;", "advertsView", "<init>", "Companion", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsSearchFragment extends TabBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Observable<UserAdvertItemAction> itemActions;
    public UserAdvertsListView j;
    public SearchBar k;
    public TextView l;
    @Inject
    public ProfileItemsSearchViewModel profileItemsViewModel;
    @Inject
    public ProfileItemsSearchTracker tracker;
    @Inject
    public DestroyableViewHolderBuilder viewHolderBuilder;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragment$Companion;", "", "", "shortcut", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragment;", "newInstance", "(Ljava/lang/String;)Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragment;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.a = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                bundle2.putString("shortcut", this.a);
                return Unit.INSTANCE;
            }
        }

        public Companion() {
        }

        @NotNull
        public final ProfileItemsSearchFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "shortcut");
            return (ProfileItemsSearchFragment) FragmentsKt.arguments$default(new ProfileItemsSearchFragment(), 0, new a(str), 1, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Observer<DeepLink> {
        public final /* synthetic */ ProfileItemsSearchFragment a;

        public a(ProfileItemsSearchFragment profileItemsSearchFragment) {
            this.a = profileItemsSearchFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            DeepLinkIntentFactory deepLinkIntentFactory = this.a.getDeepLinkIntentFactory();
            Intrinsics.checkNotNullExpressionValue(deepLink2, "deepLink");
            Intent intent = deepLinkIntentFactory.getIntent(deepLink2);
            if (intent != null) {
                intent.removeExtra(Constants.UP_INTENT);
                this.a.startActivityForResult(intent, 1);
            }
        }
    }

    public static final /* synthetic */ UserAdvertsListView access$getAdvertsView$p(ProfileItemsSearchFragment profileItemsSearchFragment) {
        UserAdvertsListView userAdvertsListView = profileItemsSearchFragment.j;
        if (userAdvertsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsView");
        }
        return userAdvertsListView;
    }

    public static final /* synthetic */ TextView access$getEmptyQuery$p(ProfileItemsSearchFragment profileItemsSearchFragment) {
        TextView textView = profileItemsSearchFragment.l;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyQuery");
        }
        return textView;
    }

    public static final void access$renderEmptyResult(ProfileItemsSearchFragment profileItemsSearchFragment, String str) {
        TextView textView = profileItemsSearchFragment.l;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyQuery");
        }
        textView.setText(profileItemsSearchFragment.getString(R.string.my_advert_search_result_empty, str));
        TextView textView2 = profileItemsSearchFragment.l;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyQuery");
        }
        Views.show(textView2);
    }

    public static final void access$updateAdvertItems(ProfileItemsSearchFragment profileItemsSearchFragment, DataSource dataSource, List list) {
        UserAdvertsListView userAdvertsListView = profileItemsSearchFragment.j;
        if (userAdvertsListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertsView");
        }
        userAdvertsListView.updateSpaceDecoration(list);
        userAdvertsListView.showAdverts();
        ResponsiveAdapterPresenter responsiveAdapterPresenter = profileItemsSearchFragment.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        responsiveAdapterPresenter.onDataSourceChanged(dataSource);
        userAdvertsListView.onDataChanged();
    }

    @NotNull
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
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
    public final Observable<UserAdvertItemAction> getItemActions() {
        Observable<UserAdvertItemAction> observable = this.itemActions;
        if (observable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemActions");
        }
        return observable;
    }

    @NotNull
    public final ProfileItemsSearchViewModel getProfileItemsViewModel() {
        ProfileItemsSearchViewModel profileItemsSearchViewModel = this.profileItemsViewModel;
        if (profileItemsSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
        }
        return profileItemsSearchViewModel;
    }

    @NotNull
    public final ProfileItemsSearchTracker getTracker() {
        ProfileItemsSearchTracker profileItemsSearchTracker = this.tracker;
        if (profileItemsSearchTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return profileItemsSearchTracker;
    }

    @NotNull
    public final DestroyableViewHolderBuilder getViewHolderBuilder() {
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        return destroyableViewHolderBuilder;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str;
        View view;
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            AdvertActionTransferData advertActionTransferData = null;
            if (intent != null) {
                String stringExtra = intent.getStringExtra("status_message");
                if (stringExtra != null) {
                    intent.removeExtra("status_message");
                    str = stringExtra;
                } else {
                    str = null;
                }
                if (!(str == null || (view = getView()) == null)) {
                    View findViewById = view.findViewById(R.id.search_adverts_list_screen_root);
                    Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
                    Views.showSnackBar$default(findViewById, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
                }
            }
            ProfileItemsSearchViewModel profileItemsSearchViewModel = this.profileItemsViewModel;
            if (profileItemsSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
            }
            profileItemsSearchViewModel.refreshResults(false);
            if (intent != null) {
                Parcelable parcelableExtra = intent.getParcelableExtra(UserAdvertConstants.KEY_ADVERT_ACTION);
                if (parcelableExtra != null) {
                    intent.removeExtra(UserAdvertConstants.KEY_ADVERT_ACTION);
                    advertActionTransferData = parcelableExtra;
                }
                AdvertActionTransferData advertActionTransferData2 = advertActionTransferData;
                if (advertActionTransferData2 != null) {
                    UserAdvertsHelpersKt.putAdvertActionTransferData(intent, advertActionTransferData2);
                }
            }
            setResult(i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ProfileItemsSearchTracker profileItemsSearchTracker = this.tracker;
        if (profileItemsSearchTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        profileItemsSearchTracker.startInit();
        ProfileItemsSearchViewModel profileItemsSearchViewModel = this.profileItemsViewModel;
        if (profileItemsSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
        }
        Observable<UserAdvertItemAction> observable = this.itemActions;
        if (observable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemActions");
        }
        profileItemsSearchViewModel.subscribeToItemActions(observable);
        ProfileItemsSearchViewModel profileItemsSearchViewModel2 = this.profileItemsViewModel;
        if (profileItemsSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
        }
        profileItemsSearchViewModel2.advertClicks().observe(getViewLifecycleOwner(), new a(this));
        return layoutInflater.inflate(R.layout.profile_items_search_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProfileItemsSearchTracker profileItemsSearchTracker = this.tracker;
        if (profileItemsSearchTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        profileItemsSearchTracker.destroy();
        ProfileItemsSearchViewModel profileItemsSearchViewModel = this.profileItemsViewModel;
        if (profileItemsSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
        }
        profileItemsSearchViewModel.unsubscribeFromItemActions();
        SearchBar searchBar = this.k;
        if (searchBar != null) {
            searchBar.onDestroyView();
        }
        this.k = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        ProfileItemsSearchTracker profileItemsSearchTracker = this.tracker;
        if (profileItemsSearchTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        profileItemsSearchTracker.detach();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ProfileItemsSearchTracker profileItemsSearchTracker = this.tracker;
        if (profileItemsSearchTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        profileItemsSearchTracker.attach();
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.profile_adverts_search_toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        ((Toolbar) findViewById).setNavigationOnClickListener(new c(this));
        View findViewById2 = view.findViewById(R.id.empty_query);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById2;
        boolean z = bundle == null;
        ProfileItemsSearchViewModel profileItemsSearchViewModel = this.profileItemsViewModel;
        if (profileItemsSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.k = new SearchBarImpl(view, z, profileItemsSearchViewModel, analytics2);
        ProfileItemsSearchViewModel profileItemsSearchViewModel2 = this.profileItemsViewModel;
        if (profileItemsSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
        }
        profileItemsSearchViewModel2.suggestsState().observe(getViewLifecycleOwner(), new b(this));
        ProfileItemsSearchFragment$initAdvertList$router$1 profileItemsSearchFragment$initAdvertList$router$1 = new UserAdvertsListView.Router() { // from class: com.avito.android.user_adverts.items_search.ProfileItemsSearchFragment$initAdvertList$router$1
            @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView.Router
            public void onRefresh() {
                ProfileItemsSearchViewModel.DefaultImpls.refreshResults$default(ProfileItemsSearchFragment.this.getProfileItemsViewModel(), false, 1, null);
            }

            @Override // com.avito.android.user_adverts.tab_screens.UserAdvertsListView.Router
            public void onRetryClick() {
                ProfileItemsSearchFragment.this.getProfileItemsViewModel().retryOnError();
            }
        };
        int i = R.id.progress_overlay_container;
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        DestroyableViewHolderBuilder destroyableViewHolderBuilder = this.viewHolderBuilder;
        if (destroyableViewHolderBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewHolderBuilder");
        }
        Analytics analytics3 = this.analytics;
        if (analytics3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.j = new UserAdvertsListViewImpl(view, i, profileItemsSearchFragment$initAdvertList$router$1, responsiveAdapterPresenter, destroyableViewHolderBuilder, analytics3, null, null, 192, null);
        ProfileItemsSearchViewModel profileItemsSearchViewModel3 = this.profileItemsViewModel;
        if (profileItemsSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profileItemsViewModel");
        }
        profileItemsSearchViewModel3.itemsState().observe(getViewLifecycleOwner(), new a2.a.a.i3.b.a(this));
        ProfileItemsSearchTracker profileItemsSearchTracker = this.tracker;
        if (profileItemsSearchTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        profileItemsSearchTracker.trackInit();
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setItemActions(@NotNull Observable<UserAdvertItemAction> observable) {
        Intrinsics.checkNotNullParameter(observable, "<set-?>");
        this.itemActions = observable;
    }

    public final void setProfileItemsViewModel(@NotNull ProfileItemsSearchViewModel profileItemsSearchViewModel) {
        Intrinsics.checkNotNullParameter(profileItemsSearchViewModel, "<set-?>");
        this.profileItemsViewModel = profileItemsSearchViewModel;
    }

    public final void setTracker(@NotNull ProfileItemsSearchTracker profileItemsSearchTracker) {
        Intrinsics.checkNotNullParameter(profileItemsSearchTracker, "<set-?>");
        this.tracker = profileItemsSearchTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string = requireArguments().getString("shortcut");
        if (string != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            UserAdvertsListAdapterModule userAdvertsListAdapterModule = new UserAdvertsListAdapterModule(requireActivity, resources);
            Timer B1 = a2.b.a.a.a.B1();
            ProfileItemsSearchComponent.Builder fragment = DaggerProfileItemsSearchComponent.builder().userAdvertsListAdapterModule(userAdvertsListAdapterModule).fragment(this);
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            fragment.resources(resources2).bindShortcut(string).profileItemsSearchComponentDependencies((ProfileItemsSearchDependencies) ComponentDependenciesKt.getDependencies(ProfileItemsSearchDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).build().inject(this);
            ProfileItemsSearchTracker profileItemsSearchTracker = this.tracker;
            if (profileItemsSearchTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            profileItemsSearchTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setViewHolderBuilder(@NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder) {
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "<set-?>");
        this.viewHolderBuilder = destroyableViewHolderBuilder;
    }
}

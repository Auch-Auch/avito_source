package com.avito.android.messenger.search;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.Differ;
import com.avito.android.messenger.search.ChannelsSearchPresenter;
import com.avito.android.messenger.search.ChannelsSearchView;
import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies;
import com.avito.android.messenger.search.di.ChannelsSearchFragmentComponent;
import com.avito.android.messenger.search.di.DaggerChannelsSearchFragmentComponent;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.BuildInfo;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\b_\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\rJ-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\tJ\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\tJ\u000f\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006`"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "onDetach", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "onStart", "onStop", "onDestroyView", "onBackPressed", "()Z", "Lcom/avito/android/messenger/search/ChannelsSearchView;", "searchView", "Lcom/avito/android/messenger/search/ChannelsSearchView;", "getSearchView", "()Lcom/avito/android/messenger/search/ChannelsSearchView;", "setSearchView", "(Lcom/avito/android/messenger/search/ChannelsSearchView;)V", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "getBuildInfo", "()Lcom/avito/android/util/BuildInfo;", "setBuildInfo", "(Lcom/avito/android/util/BuildInfo;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/messenger/search/ChannelsSearchRouter;", "router", "Lcom/avito/android/messenger/search/ChannelsSearchRouter;", "getRouter", "()Lcom/avito/android/messenger/search/ChannelsSearchRouter;", "setRouter", "(Lcom/avito/android/messenger/search/ChannelsSearchRouter;)V", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "viewSubscriptions", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/messenger/search/BackPressAware;", "d", "Lcom/avito/android/messenger/search/BackPressAware;", "backPressAware", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "searchPresenter", "Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "getSearchPresenter", "()Lcom/avito/android/messenger/search/ChannelsSearchPresenter;", "setSearchPresenter", "(Lcom/avito/android/messenger/search/ChannelsSearchPresenter;)V", "<init>", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchFragment extends BaseFragment implements OnBackPressedListener {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public BuildInfo buildInfo;
    public final CompositeDisposable c = new CompositeDisposable();
    public BackPressAware d;
    @Inject
    public ItemBinder itemBinder;
    public ChannelsSearchRouter router;
    @Inject
    public ChannelsSearchPresenter searchPresenter;
    public ChannelsSearchView searchView;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((ChannelsSearchFragment) this.b).getSearchPresenter().retry();
            } else if (i == 1) {
                ((ChannelsSearchFragment) this.b).getSearchPresenter().requestNextPage();
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                ChannelsSearchPresenter searchPresenter = ((ChannelsSearchFragment) this.b).getSearchPresenter();
                Intrinsics.checkNotNullExpressionValue(str2, "query");
                ChannelsSearchPresenter.DefaultImpls.search$default(searchPresenter, str2, false, 2, null);
            } else if (i == 1) {
                String str3 = str;
                ChannelsSearchPresenter searchPresenter2 = ((ChannelsSearchFragment) this.b).getSearchPresenter();
                Intrinsics.checkNotNullExpressionValue(str3, "query");
                searchPresenter2.search(str3, true);
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Differ<ChannelsSearchView.State, ChannelsSearchListItem> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Differ
        public boolean areContentsTheSame(ChannelsSearchListItem channelsSearchListItem, ChannelsSearchListItem channelsSearchListItem2) {
            ChannelsSearchListItem channelsSearchListItem3 = channelsSearchListItem;
            ChannelsSearchListItem channelsSearchListItem4 = channelsSearchListItem2;
            Intrinsics.checkNotNullParameter(channelsSearchListItem3, "oldItem");
            Intrinsics.checkNotNullParameter(channelsSearchListItem4, "newItem");
            return Intrinsics.areEqual(channelsSearchListItem3, channelsSearchListItem4);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Differ
        public boolean areItemsTheSame(ChannelsSearchListItem channelsSearchListItem, ChannelsSearchListItem channelsSearchListItem2) {
            ChannelsSearchListItem channelsSearchListItem3 = channelsSearchListItem;
            ChannelsSearchListItem channelsSearchListItem4 = channelsSearchListItem2;
            Intrinsics.checkNotNullParameter(channelsSearchListItem3, "oldItem");
            Intrinsics.checkNotNullParameter(channelsSearchListItem4, "newItem");
            return Intrinsics.areEqual(channelsSearchListItem3.getStringId(), channelsSearchListItem4.getStringId());
        }

        /* Return type fixed from 'java.util.List' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.avito.android.messenger.channels.mvi.common.v2.Differ
        public List<ChannelsSearchListItem> getItems(ChannelsSearchView.State state) {
            ChannelsSearchView.State.SearchResults results;
            ChannelsSearchView.State state2 = state;
            if (state2 == null || (results = state2.getResults()) == null) {
                return null;
            }
            return results.getItems();
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
    public final BuildInfo getBuildInfo() {
        BuildInfo buildInfo2 = this.buildInfo;
        if (buildInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buildInfo");
        }
        return buildInfo2;
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
    public final ChannelsSearchRouter getRouter() {
        ChannelsSearchRouter channelsSearchRouter = this.router;
        if (channelsSearchRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return channelsSearchRouter;
    }

    @NotNull
    public final ChannelsSearchPresenter getSearchPresenter() {
        ChannelsSearchPresenter channelsSearchPresenter = this.searchPresenter;
        if (channelsSearchPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchPresenter");
        }
        return channelsSearchPresenter;
    }

    @NotNull
    public final ChannelsSearchView getSearchView() {
        ChannelsSearchView channelsSearchView = this.searchView;
        if (channelsSearchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        return channelsSearchView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof BackPressAware)) {
            context = null;
        }
        BackPressAware backPressAware = (BackPressAware) context;
        this.d = backPressAware;
        if (backPressAware != null) {
            backPressAware.addOnBackPressListener(this);
        }
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        ChannelsSearchView channelsSearchView = this.searchView;
        if (channelsSearchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        channelsSearchView.clearQuery();
        ChannelsSearchRouter channelsSearchRouter = this.router;
        if (channelsSearchRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return channelsSearchRouter.closeScreen();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.messenger_channels_search, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ChannelsSearchView channelsSearchView = this.searchView;
        if (channelsSearchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        channelsSearchView.destroy();
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        BackPressAware backPressAware = this.d;
        if (backPressAware != null) {
            backPressAware.removeOnBackPressListener(this);
        }
        this.d = null;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ChannelsSearchView channelsSearchView = this.searchView;
        if (channelsSearchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchView");
        }
        channelsSearchView.clearQuery();
        ChannelsSearchRouter channelsSearchRouter = this.router;
        if (channelsSearchRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        return channelsSearchRouter.closeScreen();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ChannelsSearchRouter channelsSearchRouter = this.router;
        if (channelsSearchRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("router");
        }
        channelsSearchRouter.saveState(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6, types: [a2.a.a.o1.f.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.fragment.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStart() {
        /*
        // Method dump skipped, instructions count: 343
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.search.ChannelsSearchFragment.onStart():void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.c.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
        ViewGroup viewGroup = (ViewGroup) view;
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        this.searchView = new ChannelsSearchViewImpl(viewGroup, adapterPresenter2, itemBinder2, bundle == null);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setBuildInfo(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "<set-?>");
        this.buildInfo = buildInfo2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setRouter(@NotNull ChannelsSearchRouter channelsSearchRouter) {
        Intrinsics.checkNotNullParameter(channelsSearchRouter, "<set-?>");
        this.router = channelsSearchRouter;
    }

    public final void setSearchPresenter(@NotNull ChannelsSearchPresenter channelsSearchPresenter) {
        Intrinsics.checkNotNullParameter(channelsSearchPresenter, "<set-?>");
        this.searchPresenter = channelsSearchPresenter;
    }

    public final void setSearchView(@NotNull ChannelsSearchView channelsSearchView) {
        Intrinsics.checkNotNullParameter(channelsSearchView, "<set-?>");
        this.searchView = channelsSearchView;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        ChannelsSearchFragmentComponent.Builder channelsSearchDependencies = DaggerChannelsSearchFragmentComponent.builder().channelsSearchDependencies((ChannelsSearchComponentDependencies) ComponentDependenciesKt.getDependencies(ChannelsSearchComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        channelsSearchDependencies.resources(resources).fragment(this).build().inject(this);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        this.router = new ChannelsSearchRouterImpl(this, activityIntentFactory2, bundle);
        return true;
    }
}

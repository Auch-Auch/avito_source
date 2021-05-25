package com.avito.android.viewed_items;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.favorites.R;
import com.avito.android.remote.model.Image;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import com.avito.android.viewed_items.ViewedItemsPresenter;
import com.avito.android.viewed_items.di.DaggerViewedItemsComponent;
import com.avito.android.viewed_items.di.ViewedItems;
import com.avito.android.viewed_items.di.ViewedItemsComponent;
import com.avito.android.viewed_items.di.ViewedItemsDependencies;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bF\u0010\u000eJ-\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0016\u0010\u0017JO\u0010\"\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R(\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0018\n\u0004\b,\u0010-\u0012\u0004\b2\u0010\u000e\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00104\u001a\u0002038\u0006@\u0006X.¢\u0006\u0018\n\u0004\b4\u00105\u0012\u0004\b:\u0010\u000e\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsFragment;", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "Lcom/avito/android/viewed_items/ViewedItemsPresenter$Router;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onStart", "()V", "onResume", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "itemId", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "openFastAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "Lcom/avito/android/viewed_items/ViewedItemsPresenter;", "presenter", "Lcom/avito/android/viewed_items/ViewedItemsPresenter;", "getPresenter", "()Lcom/avito/android/viewed_items/ViewedItemsPresenter;", "setPresenter", "(Lcom/avito/android/viewed_items/ViewedItemsPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "getAdapterPresenter$annotations", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "getItemBinder$annotations", "Lcom/avito/android/viewed_items/ViewedItemsView;", "j", "Lcom/avito/android/viewed_items/ViewedItemsView;", "viewedItemsView", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedItemsFragment extends TabBaseFragment implements ViewedItemsPresenter.Router {
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public ItemBinder itemBinder;
    public ViewedItemsView j;
    @Inject
    public ViewedItemsPresenter presenter;

    @ViewedItems
    public static /* synthetic */ void getAdapterPresenter$annotations() {
    }

    @ViewedItems
    public static /* synthetic */ void getItemBinder$annotations() {
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final ViewedItemsPresenter getPresenter() {
        ViewedItemsPresenter viewedItemsPresenter = this.presenter;
        if (viewedItemsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return viewedItemsPresenter;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_viewed_items, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        ViewedItemsPresenter viewedItemsPresenter = this.presenter;
        if (viewedItemsPresenter == null) {
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
        this.j = new ViewedItemsViewImpl(viewGroup2, viewedItemsPresenter, adapterPresenter2, itemBinder2);
        ViewedItemsPresenter viewedItemsPresenter2 = this.presenter;
        if (viewedItemsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ViewedItemsView viewedItemsView = this.j;
        if (viewedItemsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedItemsView");
        }
        viewedItemsPresenter2.attachView(viewedItemsView);
        return viewGroup2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ViewedItemsPresenter viewedItemsPresenter = this.presenter;
        if (viewedItemsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ViewedItemsView viewedItemsView = this.j;
        if (viewedItemsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedItemsView");
        }
        viewedItemsPresenter.detachView(viewedItemsView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewedItemsPresenter viewedItemsPresenter = this.presenter;
        if (viewedItemsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        viewedItemsPresenter.onResume();
    }

    @Override // com.avito.android.ui.fragments.TabBaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ViewedItemsPresenter viewedItemsPresenter = this.presenter;
        if (viewedItemsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter_state", viewedItemsPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ViewedItemsPresenter viewedItemsPresenter = this.presenter;
        if (viewedItemsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        viewedItemsPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ViewedItemsPresenter viewedItemsPresenter = this.presenter;
        if (viewedItemsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        viewedItemsPresenter.detachRouter();
    }

    @Override // com.avito.android.viewed_items.ViewedItemsPresenter.Router
    public void openFastAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @NotNull TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(activityIntentFactory2, str, str2, str3, str4, str5, image, false, treeClickStreamParent, SystemClock.elapsedRealtime(), null, currentTab(), null, 2624, null));
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull ViewedItemsPresenter viewedItemsPresenter) {
        Intrinsics.checkNotNullParameter(viewedItemsPresenter, "<set-?>");
        this.presenter = viewedItemsPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Kundle kundle = bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null;
        ViewedItemsComponent.Builder dependentOn = DaggerViewedItemsComponent.builder().dependentOn((ViewedItemsDependencies) ComponentDependenciesKt.getDependencies(ViewedItemsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        dependentOn.withResources(resources).withPresenterState(kundle).build().inject(this);
        return true;
    }
}

package com.avito.android.notification_center.landing.recommends;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.notification_center.R;
import com.avito.android.notification_center.landing.recommends.di.DaggerNotificationCenterLandingRecommendsFragmentComponent;
import com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies;
import com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsFragmentComponent;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010\u0010J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onStop", "onDestroyView", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;", "presenter", "Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;", "getPresenter", "()Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;", "setPresenter", "(Lcom/avito/android/notification_center/landing/recommends/NotificationCenterLandingRecommendsPresenter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "setViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;)V", "<init>", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsFragment extends BaseFragment {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public NotificationCenterLandingRecommendsPresenter presenter;
    @Inject
    public ViewedAdvertsPresenter viewedAdvertsPresenter;

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
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
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final NotificationCenterLandingRecommendsPresenter getPresenter() {
        NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter = this.presenter;
        if (notificationCenterLandingRecommendsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return notificationCenterLandingRecommendsPresenter;
    }

    @NotNull
    public final ViewedAdvertsPresenter getViewedAdvertsPresenter() {
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        return viewedAdvertsPresenter2;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.notification_center_landing_recommends, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…mmends, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter = this.presenter;
        if (notificationCenterLandingRecommendsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingRecommendsPresenter.detachView();
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter = this.presenter;
        if (notificationCenterLandingRecommendsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("key_state", notificationCenterLandingRecommendsPresenter.getState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter = this.presenter;
        if (notificationCenterLandingRecommendsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.avito.android.notification_center.landing.recommends.NotificationCenterLandingRecommendsRouter");
        notificationCenterLandingRecommendsPresenter.attachRouter((NotificationCenterLandingRecommendsRouter) activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter = this.presenter;
        if (notificationCenterLandingRecommendsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingRecommendsPresenter.detachRouter();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
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
        NotificationCenterLandingRecommendsViewImpl notificationCenterLandingRecommendsViewImpl = new NotificationCenterLandingRecommendsViewImpl(view, adapterPresenter2, itemBinder2, analytics2);
        NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter = this.presenter;
        if (notificationCenterLandingRecommendsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        notificationCenterLandingRecommendsPresenter.attachView(notificationCenterLandingRecommendsViewImpl);
        ViewedAdvertsPresenter viewedAdvertsPresenter2 = this.viewedAdvertsPresenter;
        if (viewedAdvertsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewedAdvertsPresenter");
        }
        viewedAdvertsPresenter2.attachView(notificationCenterLandingRecommendsViewImpl);
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull NotificationCenterLandingRecommendsPresenter notificationCenterLandingRecommendsPresenter) {
        Intrinsics.checkNotNullParameter(notificationCenterLandingRecommendsPresenter, "<set-?>");
        this.presenter = notificationCenterLandingRecommendsPresenter;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string = requireArguments().getString("key_id");
        if (string != null) {
            NotificationCenterLandingRecommendsFragmentComponent.Builder withPresenterState = DaggerNotificationCenterLandingRecommendsFragmentComponent.builder().dependencies((NotificationCenterLandingRecommendsDependencies) ComponentDependenciesKt.getDependencies(NotificationCenterLandingRecommendsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).withId(string).withPresenterState(bundle != null ? (Kundle) bundle.getParcelable("key_state") : null);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            NotificationCenterLandingRecommendsFragmentComponent.Builder withResources = withPresenterState.withResources(resources);
            PublishRelay create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            NotificationCenterLandingRecommendsFragmentComponent.Builder withItemAdvertFavoriteRelay = withResources.withItemAdvertFavoriteRelay(create);
            PublishRelay create2 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
            NotificationCenterLandingRecommendsFragmentComponent.Builder withItemAdvertRelay = withItemAdvertFavoriteRelay.withItemAdvertRelay(create2);
            PublishRelay create3 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
            NotificationCenterLandingRecommendsFragmentComponent.Builder withItemReviewRelay = withItemAdvertRelay.withItemReviewRelay(create3);
            PublishRelay create4 = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create4, "PublishRelay.create()");
            withItemReviewRelay.withItemTitleRelay(create4).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setViewedAdvertsPresenter(@NotNull ViewedAdvertsPresenter viewedAdvertsPresenter2) {
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter2, "<set-?>");
        this.viewedAdvertsPresenter = viewedAdvertsPresenter2;
    }
}

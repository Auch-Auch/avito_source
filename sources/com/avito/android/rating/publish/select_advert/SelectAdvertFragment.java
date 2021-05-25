package com.avito.android.rating.publish.select_advert;

import a2.b.a.a.a;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rating.R;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepHost;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_advert.SelectAdvertPresenter;
import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import com.avito.android.rating.publish.select_advert.di.DaggerSelectAdvertComponent;
import com.avito.android.rating.publish.select_advert.di.SelectAdvertComponent;
import com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies;
import com.avito.android.rating.publish.select_advert.tracker.SelectAdvertTracker;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.CompressedParcelable;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b_\u0010\u0012J-\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\"\u001a\u00020\u00102\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^¨\u0006`"}, d2 = {"Lcom/avito/android/rating/publish/select_advert/SelectAdvertFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter$Router;", "Lcom/avito/android/rating/publish/StepHost;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "closeScreen", "onBackPressed", "()Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "", "errors", "handleErrors", "(Ljava/util/Map;)V", "isLoading", "handleLoading", "(Z)V", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/rating/publish/StepListener;", "getStepListener", "()Lcom/avito/android/rating/publish/StepListener;", "setStepListener", "(Lcom/avito/android/rating/publish/StepListener;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;)V", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter;", "presenter", "Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter;", "getPresenter", "()Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter;", "setPresenter", "(Lcom/avito/android/rating/publish/select_advert/SelectAdvertPresenter;)V", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/ratings/RatingPublishData;", "getRatingData", "()Lcom/avito/android/ratings/RatingPublishData;", "setRatingData", "(Lcom/avito/android/ratings/RatingPublishData;)V", "Lcom/avito/android/rating/publish/select_advert/tracker/SelectAdvertTracker;", "tracker", "Lcom/avito/android/rating/publish/select_advert/tracker/SelectAdvertTracker;", "getTracker", "()Lcom/avito/android/rating/publish/select_advert/tracker/SelectAdvertTracker;", "setTracker", "(Lcom/avito/android/rating/publish/select_advert/tracker/SelectAdvertTracker;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class SelectAdvertFragment extends BaseFragment implements SelectAdvertPresenter.Router, StepHost {
    @Inject
    public ResponsiveAdapterPresenter adapterPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    @Inject
    public SelectAdvertPresenter presenter;
    @Inject
    public RatingPublishData ratingData;
    @Inject
    public StepListener stepListener;
    @Inject
    public SelectAdvertTracker tracker;

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter.Router
    public void closeScreen() {
        StepListener stepListener2 = this.stepListener;
        if (stepListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepListener");
        }
        stepListener2.onBackPressed();
    }

    @Override // com.avito.android.rating.publish.select_advert.SelectAdvertPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
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

    @NotNull
    public final ResponsiveAdapterPresenter getAdapterPresenter() {
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return responsiveAdapterPresenter;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
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
    public final SelectAdvertPresenter getPresenter() {
        SelectAdvertPresenter selectAdvertPresenter = this.presenter;
        if (selectAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return selectAdvertPresenter;
    }

    @NotNull
    public final RatingPublishData getRatingData() {
        RatingPublishData ratingPublishData = this.ratingData;
        if (ratingPublishData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingData");
        }
        return ratingPublishData;
    }

    @NotNull
    public final StepListener getStepListener() {
        StepListener stepListener2 = this.stepListener;
        if (stepListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepListener");
        }
        return stepListener2;
    }

    @NotNull
    public final SelectAdvertTracker getTracker() {
        SelectAdvertTracker selectAdvertTracker = this.tracker;
        if (selectAdvertTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return selectAdvertTracker;
    }

    @Override // com.avito.android.rating.publish.StepHost
    public void handleErrors(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
    }

    @Override // com.avito.android.rating.publish.StepHost
    public void handleLoading(boolean z) {
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        SelectAdvertPresenter selectAdvertPresenter = this.presenter;
        if (selectAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return selectAdvertPresenter.backPressHandled();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        SelectAdvertTracker selectAdvertTracker = this.tracker;
        if (selectAdvertTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        selectAdvertTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.select_advert, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        ResponsiveAdapterPresenter responsiveAdapterPresenter = this.adapterPresenter;
        if (responsiveAdapterPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        SelectAdvertViewImpl selectAdvertViewImpl = new SelectAdvertViewImpl(inflate, responsiveAdapterPresenter, itemBinder2);
        SelectAdvertPresenter selectAdvertPresenter = this.presenter;
        if (selectAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectAdvertPresenter.attachView(selectAdvertViewImpl);
        SelectAdvertTracker selectAdvertTracker2 = this.tracker;
        if (selectAdvertTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        selectAdvertTracker2.trackInit();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectAdvertPresenter selectAdvertPresenter = this.presenter;
        if (selectAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectAdvertPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectAdvertPresenter selectAdvertPresenter = this.presenter;
        if (selectAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("presenter_state", new CompressedParcelable(selectAdvertPresenter.onSaveState()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SelectAdvertPresenter selectAdvertPresenter = this.presenter;
        if (selectAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectAdvertPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        SelectAdvertPresenter selectAdvertPresenter = this.presenter;
        if (selectAdvertPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectAdvertPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapterPresenter(@NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter) {
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "<set-?>");
        this.adapterPresenter = responsiveAdapterPresenter;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull SelectAdvertPresenter selectAdvertPresenter) {
        Intrinsics.checkNotNullParameter(selectAdvertPresenter, "<set-?>");
        this.presenter = selectAdvertPresenter;
    }

    public final void setRatingData(@NotNull RatingPublishData ratingPublishData) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "<set-?>");
        this.ratingData = ratingPublishData;
    }

    public final void setStepListener(@NotNull StepListener stepListener2) {
        Intrinsics.checkNotNullParameter(stepListener2, "<set-?>");
        this.stepListener = stepListener2;
    }

    public final void setTracker(@NotNull SelectAdvertTracker selectAdvertTracker) {
        Intrinsics.checkNotNullParameter(selectAdvertTracker, "<set-?>");
        this.tracker = selectAdvertTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        RatingPublishData ratingPublishData;
        RatingPublishViewData ratingPublishViewData;
        Screen screen;
        Kundle kundle = null;
        CompressedParcelable compressedParcelable = bundle != null ? (CompressedParcelable) bundle.getParcelable("presenter_state") : null;
        if (compressedParcelable != null) {
            kundle = (Kundle) compressedParcelable.restore(Kundle.class);
        }
        Bundle arguments = getArguments();
        if (arguments == null || (ratingPublishData = (RatingPublishData) arguments.getParcelable("rating_data")) == null) {
            throw new IllegalArgumentException();
        }
        Intrinsics.checkNotNullExpressionValue(ratingPublishData, "arguments?.getParcelable…llegalArgumentException()");
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (ratingPublishViewData = (RatingPublishViewData) arguments2.getParcelable("rating_view_data")) == null) {
            throw new IllegalArgumentException();
        }
        Intrinsics.checkNotNullExpressionValue(ratingPublishViewData, "arguments?.getParcelable…llegalArgumentException()");
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (screen = (Screen) arguments3.getParcelable(VKApiUserFull.SCREEN_NAME)) == null) {
            throw new IllegalArgumentException();
        }
        Intrinsics.checkNotNullExpressionValue(screen, "arguments?.getParcelable…llegalArgumentException()");
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            boolean z = arguments4.getBoolean("sub_component", false);
            Timer B1 = a.B1();
            SelectAdvertComponent.Builder with = DaggerSelectAdvertComponent.builder().dependentOn((SelectAdvertDependencies) ComponentDependenciesKt.getDependencies(SelectAdvertDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).with(kundle);
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            SelectAdvertComponent.Builder with2 = with.with(requireActivity);
            FragmentActivity requireActivity2 = requireActivity();
            Objects.requireNonNull(requireActivity2, "null cannot be cast to non-null type com.avito.android.rating.publish.StepListener.Holder");
            SelectAdvertComponent.Builder with3 = with2.with(((StepListener.Holder) requireActivity2).getStepListener());
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            SelectAdvertComponent.Builder with4 = with3.with(resources);
            PublishRelay<SelectAdvertAction> create = PublishRelay.create();
            Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
            with4.with(create).with(ratingPublishData).with(ratingPublishViewData).with(ratingPublishData.getUserKey()).withScreen(screen).withSubComponent(z).build().inject(this);
            SelectAdvertTracker selectAdvertTracker = this.tracker;
            if (selectAdvertTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            selectAdvertTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException();
    }
}

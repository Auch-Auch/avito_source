package com.avito.android.rating.publish.select_rating;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rating.R;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepHost;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_rating.SelectRatingPresenter;
import com.avito.android.rating.publish.select_rating.di.DaggerSelectRatingComponent;
import com.avito.android.rating.publish.select_rating.di.SelectRatingComponent;
import com.avito.android.rating.publish.select_rating.di.SelectRatingDependencies;
import com.avito.android.rating.publish.select_rating.event.SelectRatingOpenEvent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bW\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010!\u001a\u00020\t2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lcom/avito/android/rating/publish/select_rating/SelectRatingFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter$Router;", "Lcom/avito/android/rating/publish/StepHost;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "onBackPressed", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "", "errors", "handleErrors", "(Ljava/util/Map;)V", "isLoading", "handleLoading", "(Z)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/rating/publish/StepListener;", "getStepListener", "()Lcom/avito/android/rating/publish/StepListener;", "setStepListener", "(Lcom/avito/android/rating/publish/StepListener;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/ratings/RatingPublishData;", "getRatingData", "()Lcom/avito/android/ratings/RatingPublishData;", "setRatingData", "(Lcom/avito/android/ratings/RatingPublishData;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "getRatingViewData", "()Lcom/avito/android/rating/publish/RatingPublishViewData;", "setRatingViewData", "(Lcom/avito/android/rating/publish/RatingPublishViewData;)V", "Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter;", "presenter", "Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter;", "getPresenter", "()Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter;", "setPresenter", "(Lcom/avito/android/rating/publish/select_rating/SelectRatingPresenter;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class SelectRatingFragment extends BaseFragment implements SelectRatingPresenter.Router, StepHost {
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public SelectRatingPresenter presenter;
    @Inject
    public RatingPublishData ratingData;
    @Inject
    public RatingPublishViewData ratingViewData;
    @Inject
    public StepListener stepListener;

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter.Router
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final SelectRatingPresenter getPresenter() {
        SelectRatingPresenter selectRatingPresenter = this.presenter;
        if (selectRatingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return selectRatingPresenter;
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
    public final RatingPublishViewData getRatingViewData() {
        RatingPublishViewData ratingPublishViewData = this.ratingViewData;
        if (ratingPublishViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ratingViewData");
        }
        return ratingPublishViewData;
    }

    @NotNull
    public final StepListener getStepListener() {
        StepListener stepListener2 = this.stepListener;
        if (stepListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepListener");
        }
        return stepListener2;
    }

    @Override // com.avito.android.rating.publish.StepHost
    public void handleErrors(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "errors");
    }

    @Override // com.avito.android.rating.publish.StepHost
    public void handleLoading(boolean z) {
        SelectRatingPresenter selectRatingPresenter = this.presenter;
        if (selectRatingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectRatingPresenter.handleLoading(z);
    }

    @Override // com.avito.android.rating.publish.select_rating.SelectRatingPresenter.Router
    public void onBackPressed() {
        StepListener stepListener2 = this.stepListener;
        if (stepListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepListener");
        }
        stepListener2.onBackPressed();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            RatingPublishViewData ratingPublishViewData = this.ratingViewData;
            if (ratingPublishViewData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingViewData");
            }
            Integer score = ratingPublishViewData.getScore();
            if (score != null) {
                int intValue = score.intValue();
                SelectRatingPresenter selectRatingPresenter = this.presenter;
                if (selectRatingPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                selectRatingPresenter.applyScore(intValue);
            }
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            RatingPublishData ratingPublishData = this.ratingData;
            if (ratingPublishData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            String userKey = ratingPublishData.getUserKey();
            RatingPublishData ratingPublishData2 = this.ratingData;
            if (ratingPublishData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            String itemId = ratingPublishData2.getItemId();
            RatingPublishData ratingPublishData3 = this.ratingData;
            if (ratingPublishData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            Integer score2 = ratingPublishData3.getScore();
            RatingPublishData ratingPublishData4 = this.ratingData;
            if (ratingPublishData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            analytics2.track(new SelectRatingOpenEvent(userKey, itemId, score2, ratingPublishData4.getStageId()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.select_rating, viewGroup, false);
        SelectRatingPresenter selectRatingPresenter = this.presenter;
        if (selectRatingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        selectRatingPresenter.attachView(new SelectRatingViewImpl(inflate));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectRatingPresenter selectRatingPresenter = this.presenter;
        if (selectRatingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectRatingPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        SelectRatingPresenter selectRatingPresenter = this.presenter;
        if (selectRatingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", selectRatingPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        SelectRatingPresenter selectRatingPresenter = this.presenter;
        if (selectRatingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectRatingPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        SelectRatingPresenter selectRatingPresenter = this.presenter;
        if (selectRatingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        selectRatingPresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull SelectRatingPresenter selectRatingPresenter) {
        Intrinsics.checkNotNullParameter(selectRatingPresenter, "<set-?>");
        this.presenter = selectRatingPresenter;
    }

    public final void setRatingData(@NotNull RatingPublishData ratingPublishData) {
        Intrinsics.checkNotNullParameter(ratingPublishData, "<set-?>");
        this.ratingData = ratingPublishData;
    }

    public final void setRatingViewData(@NotNull RatingPublishViewData ratingPublishViewData) {
        Intrinsics.checkNotNullParameter(ratingPublishViewData, "<set-?>");
        this.ratingViewData = ratingPublishViewData;
    }

    public final void setStepListener(@NotNull StepListener stepListener2) {
        Intrinsics.checkNotNullParameter(stepListener2, "<set-?>");
        this.stepListener = stepListener2;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        RatingPublishData ratingPublishData;
        RatingPublishViewData ratingPublishViewData;
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
        SelectRatingComponent.Builder with = DaggerSelectRatingComponent.builder().dependentOn((SelectRatingDependencies) ComponentDependenciesKt.getDependencies(SelectRatingDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).with(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        SelectRatingComponent.Builder with2 = with.with(requireActivity);
        FragmentActivity requireActivity2 = requireActivity();
        Objects.requireNonNull(requireActivity2, "null cannot be cast to non-null type com.avito.android.rating.publish.StepListener.Holder");
        with2.with(((StepListener.Holder) requireActivity2).getStepListener()).with(ratingPublishData).with(ratingPublishViewData).build().inject(this);
        return true;
    }
}

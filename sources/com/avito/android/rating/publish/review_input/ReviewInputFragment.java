package com.avito.android.rating.publish.review_input;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rating.R;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepHost;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.review_input.ReviewInputPresenter;
import com.avito.android.rating.publish.review_input.di.DaggerReviewInputComponent;
import com.avito.android.rating.publish.review_input.di.ReviewInputComponent;
import com.avito.android.rating.publish.review_input.di.ReviewInputDependencies;
import com.avito.android.rating.publish.review_input.event.ReviewInputOpenEvent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.Bundles;
import com.avito.android.util.Kundle;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\bL\u0010\u0014J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u0014J%\u0010\u001d\u001a\u00020\t2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010F\u001a\u00020E8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lcom/avito/android/rating/publish/review_input/ReviewInputFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter$Router;", "Lcom/avito/android/rating/publish/StepHost;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "()V", "onStop", "onDestroyView", "outState", "onSaveInstanceState", "onBackPressed", "", "", "errors", "handleErrors", "(Ljava/util/Map;)V", "isLoading", "handleLoading", "(Z)V", "Lcom/avito/android/ratings/RatingPublishData;", "ratingData", "Lcom/avito/android/ratings/RatingPublishData;", "getRatingData", "()Lcom/avito/android/ratings/RatingPublishData;", "setRatingData", "(Lcom/avito/android/ratings/RatingPublishData;)V", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "ratingViewData", "Lcom/avito/android/rating/publish/RatingPublishViewData;", "getRatingViewData", "()Lcom/avito/android/rating/publish/RatingPublishViewData;", "setRatingViewData", "(Lcom/avito/android/rating/publish/RatingPublishViewData;)V", "Lcom/avito/android/rating/publish/StepListener;", "stepListener", "Lcom/avito/android/rating/publish/StepListener;", "getStepListener", "()Lcom/avito/android/rating/publish/StepListener;", "setStepListener", "(Lcom/avito/android/rating/publish/StepListener;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter;", "presenter", "Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter;", "getPresenter", "()Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter;", "setPresenter", "(Lcom/avito/android/rating/publish/review_input/ReviewInputPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewInputFragment extends BaseFragment implements ReviewInputPresenter.Router, StepHost {
    @Inject
    public Analytics analytics;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ReviewInputPresenter presenter;
    @Inject
    public RatingPublishData ratingData;
    @Inject
    public RatingPublishViewData ratingViewData;
    @Inject
    public StepListener stepListener;

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
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
    public final ReviewInputPresenter getPresenter() {
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return reviewInputPresenter;
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
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewInputPresenter.handleErrors(map);
    }

    @Override // com.avito.android.rating.publish.StepHost
    public void handleLoading(boolean z) {
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewInputPresenter.handleLoading(z);
    }

    @Override // com.avito.android.rating.publish.review_input.ReviewInputPresenter.Router
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
            String comment = ratingPublishViewData.getComment();
            if (comment != null) {
                ReviewInputPresenter reviewInputPresenter = this.presenter;
                if (reviewInputPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                reviewInputPresenter.applyComment(comment);
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
            Integer score = ratingPublishData3.getScore();
            RatingPublishData ratingPublishData4 = this.ratingData;
            if (ratingPublishData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ratingData");
            }
            analytics2.track(new ReviewInputOpenEvent(userKey, itemId, score, ratingPublishData4.getStageId()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.review_input, viewGroup, false);
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        ReviewInputViewImpl reviewInputViewImpl = new ReviewInputViewImpl(inflate);
        reviewInputViewImpl.showKeyboard();
        Unit unit = Unit.INSTANCE;
        reviewInputPresenter.attachView(reviewInputViewImpl);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewInputPresenter.detachView();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", reviewInputPresenter.onSaveState());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewInputPresenter.attachRouter(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        ReviewInputPresenter reviewInputPresenter = this.presenter;
        if (reviewInputPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        reviewInputPresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull ReviewInputPresenter reviewInputPresenter) {
        Intrinsics.checkNotNullParameter(reviewInputPresenter, "<set-?>");
        this.presenter = reviewInputPresenter;
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
        Bundle arguments3 = getArguments();
        Kundle kundle = null;
        NextStagePayload nextStagePayload = arguments3 != null ? (NextStagePayload) arguments3.getParcelable("key_stage_comment_payload") : null;
        ReviewInputComponent.Builder dependentOn = DaggerReviewInputComponent.builder().dependentOn((ReviewInputDependencies) ComponentDependenciesKt.getDependencies(ReviewInputDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)));
        if (bundle != null) {
            kundle = Bundles.getKundle(bundle, "presenter_state");
        }
        ReviewInputComponent.Builder with = dependentOn.with(kundle);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        ReviewInputComponent.Builder with2 = with.with(resources);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ReviewInputComponent.Builder with3 = with2.with(requireActivity);
        FragmentActivity requireActivity2 = requireActivity();
        Objects.requireNonNull(requireActivity2, "null cannot be cast to non-null type com.avito.android.rating.publish.StepListener.Holder");
        with3.with(((StepListener.Holder) requireActivity2).getStepListener()).with(ratingPublishData).with(ratingPublishViewData).with(nextStagePayload).build().inject(this);
        return true;
    }
}

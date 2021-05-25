package com.avito.android.rating.user_review_details;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rating.R;
import com.avito.android.rating.RatingParamsKt;
import com.avito.android.rating.user_review_details.UserReviewDetailsPresenter;
import com.avito.android.rating.user_review_details.di.DaggerUserReviewDetailsComponent;
import com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent;
import com.avito.android.rating.user_review_details.di.UserReviewDetailsDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.Image;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.user_review.UserReviewData;
import com.avito.android.util.Bundles;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bE\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001b\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R(\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/avito/android/rating/user_review_details/UserReviewDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "", "isReviewRemoved", "leaveScreen", "(Z)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "openGallery", "(Ljava/util/List;I)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;", "presenter", "Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;", "getPresenter", "()Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;", "setPresenter", "(Lcom/avito/android/rating/user_review_details/UserReviewDetailsPresenter;)V", "Lcom/avito/android/user_review/UserReviewData;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/user_review/UserReviewData;", AvatarStatus.REVIEW, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Lio/reactivex/rxjava3/functions/Consumer;", "getImageClicks", "()Lio/reactivex/rxjava3/functions/Consumer;", "setImageClicks", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewDetailsActivity extends BaseActivity implements UserReviewDetailsPresenter.Router {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public Features features;
    @Inject
    public Consumer<TnsGalleryItemClickAction> imageClicks;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public UserReviewDetailsPresenter presenter;

    public final UserReviewData a() {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        UserReviewData review = RatingParamsKt.getReview(intent);
        if (review != null) {
            return review;
        }
        throw new IllegalArgumentException("Review must be specified!");
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter.Router
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
    public final Consumer<TnsGalleryItemClickAction> getImageClicks() {
        Consumer<TnsGalleryItemClickAction> consumer = this.imageClicks;
        if (consumer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageClicks");
        }
        return consumer;
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
    public final UserReviewDetailsPresenter getPresenter() {
        UserReviewDetailsPresenter userReviewDetailsPresenter = this.presenter;
        if (userReviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return userReviewDetailsPresenter;
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter.Router
    public void leaveScreen(boolean z) {
        if (z) {
            Intent intent = new Intent();
            RatingParamsKt.putReview(intent, a());
            setResult(42, intent);
        } else {
            setResult(-1);
        }
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        UserReviewDetailsComponent.Builder with = DaggerUserReviewDetailsComponent.builder().dependentOn((UserReviewDetailsDependencies) ComponentDependenciesKt.getDependencies(UserReviewDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).with(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).with(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        with.with(resources).with(a()).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_review_details);
        UserReviewDetailsPresenter userReviewDetailsPresenter = this.presenter;
        if (userReviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        Consumer<TnsGalleryItemClickAction> consumer = this.imageClicks;
        if (consumer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageClicks");
        }
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        userReviewDetailsPresenter.attachView(new UserReviewDetailsViewImpl(findViewById, consumer, this, features2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        UserReviewDetailsPresenter userReviewDetailsPresenter = this.presenter;
        if (userReviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userReviewDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        UserReviewDetailsPresenter userReviewDetailsPresenter = this.presenter;
        if (userReviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", userReviewDetailsPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        UserReviewDetailsPresenter userReviewDetailsPresenter = this.presenter;
        if (userReviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userReviewDetailsPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        UserReviewDetailsPresenter userReviewDetailsPresenter = this.presenter;
        if (userReviewDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        userReviewDetailsPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.rating.user_review_details.UserReviewDetailsPresenter.Router
    public void openGallery(@NotNull List<Image> list, int i) {
        Intrinsics.checkNotNullParameter(list, "images");
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        startActivity(activityIntentFactory.photoGalleryIntent(null, list, i));
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImageClicks(@NotNull Consumer<TnsGalleryItemClickAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "<set-?>");
        this.imageClicks = consumer;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull UserReviewDetailsPresenter userReviewDetailsPresenter) {
        Intrinsics.checkNotNullParameter(userReviewDetailsPresenter, "<set-?>");
        this.presenter = userReviewDetailsPresenter;
    }
}

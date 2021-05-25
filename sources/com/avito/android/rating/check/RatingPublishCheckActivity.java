package com.avito.android.rating.check;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.rating.R;
import com.avito.android.rating.check.RatingPublishCheckPresenter;
import com.avito.android.rating.check.di.DaggerRatingPublishCheckComponent;
import com.avito.android.rating.check.di.RatingPublishCheckComponent;
import com.avito.android.rating.check.di.RatingPublishCheckDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b>\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\tJ)\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0019\u0010(\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010*\u001a\u00020)8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/avito/android/rating/check/RatingPublishCheckActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/rating/check/RatingPublishCheckPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "leaveScreen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "openRatingPublish", "openAuth", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/analytics/screens/Timer;", "k", "Lcom/avito/android/analytics/screens/Timer;", "getDiTracker", "()Lcom/avito/android/analytics/screens/Timer;", "diTracker", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/rating/check/RatingPublishCheckPresenter;", "presenter", "Lcom/avito/android/rating/check/RatingPublishCheckPresenter;", "getPresenter", "()Lcom/avito/android/rating/check/RatingPublishCheckPresenter;", "setPresenter", "(Lcom/avito/android/rating/check/RatingPublishCheckPresenter;)V", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;)V", "<init>", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishCheckActivity extends BaseActivity implements RatingPublishCheckPresenter.Router {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @NotNull
    public final Timer k = a.B1();
    @Inject
    public RatingPublishCheckPresenter presenter;
    @Inject
    public UnknownScreenTracker tracker;

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            UnknownScreenTracker unknownScreenTracker = this.tracker;
            if (unknownScreenTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            startActivity(saturateIntentWithTrackingInfo(intent, unknownScreenTracker.toScreenTransfer()));
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
    public final Timer getDiTracker() {
        return this.k;
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
    public final RatingPublishCheckPresenter getPresenter() {
        RatingPublishCheckPresenter ratingPublishCheckPresenter = this.presenter;
        if (ratingPublishCheckPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return ratingPublishCheckPresenter;
    }

    @NotNull
    public final UnknownScreenTracker getTracker() {
        UnknownScreenTracker unknownScreenTracker = this.tracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return unknownScreenTracker;
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            setResult(i2, intent);
            leaveScreen();
        } else if (i == 1) {
            if (i2 == -1) {
                RatingPublishCheckPresenter ratingPublishCheckPresenter = this.presenter;
                if (ratingPublishCheckPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                ratingPublishCheckPresenter.onAuthSuccess();
                return;
            }
            leaveScreen();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        if (((Intent) getIntent().getParcelableExtra("target_intent")) != null) {
            String stringExtra = getIntent().getStringExtra("user_key");
            if (stringExtra != null) {
                RatingPublishCheckComponent.Builder dependentOn = DaggerRatingPublishCheckComponent.builder().dependentOn((RatingPublishCheckDependencies) ComponentDependenciesKt.getDependencies(RatingPublishCheckDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                dependentOn.with(resources).with(this).withUserKey(stringExtra).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).build().inject(this);
                UnknownScreenTracker unknownScreenTracker = this.tracker;
                if (unknownScreenTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tracker");
                }
                unknownScreenTracker.trackDiInject(this.k.elapsed());
                Timer timer = new TimerFactory().timer();
                timer.start();
                super.onCreate(bundle);
                setContentView(R.layout.rating_publish_check);
                RatingPublishCheckPresenter ratingPublishCheckPresenter = this.presenter;
                if (ratingPublishCheckPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                View findViewById = findViewById(16908290);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
                ratingPublishCheckPresenter.attachView(new RatingPublishCheckViewImpl(findViewById));
                UnknownScreenTracker unknownScreenTracker2 = this.tracker;
                if (unknownScreenTracker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tracker");
                }
                unknownScreenTracker2.trackInit(timer.elapsed());
                return;
            }
            throw new IllegalArgumentException("userKey must not be null");
        }
        throw new IllegalArgumentException("Intent must not be null");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        RatingPublishCheckPresenter ratingPublishCheckPresenter = this.presenter;
        if (ratingPublishCheckPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingPublishCheckPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        RatingPublishCheckPresenter ratingPublishCheckPresenter = this.presenter;
        if (ratingPublishCheckPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", ratingPublishCheckPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        RatingPublishCheckPresenter ratingPublishCheckPresenter = this.presenter;
        if (ratingPublishCheckPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingPublishCheckPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        RatingPublishCheckPresenter ratingPublishCheckPresenter = this.presenter;
        if (ratingPublishCheckPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ratingPublishCheckPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter.Router
    public void openAuth() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Intent authIntent$default = AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory, null, "rev", null, 5, null);
        UnknownScreenTracker unknownScreenTracker = this.tracker;
        if (unknownScreenTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        startActivityForResult(saturateIntentWithTrackingInfo(authIntent$default, unknownScreenTracker.toScreenTransfer()), 1);
    }

    @Override // com.avito.android.rating.check.RatingPublishCheckPresenter.Router
    public void openRatingPublish() {
        Intent intent = (Intent) getIntent().getParcelableExtra("target_intent");
        if (intent != null) {
            UnknownScreenTracker unknownScreenTracker = this.tracker;
            if (unknownScreenTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            saturateIntentWithTrackingInfo(intent, unknownScreenTracker.toScreenTransfer());
            startActivityForResult(intent, 0);
            return;
        }
        throw new IllegalArgumentException("Intent must not be null");
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPresenter(@NotNull RatingPublishCheckPresenter ratingPublishCheckPresenter) {
        Intrinsics.checkNotNullParameter(ratingPublishCheckPresenter, "<set-?>");
        this.presenter = ratingPublishCheckPresenter;
    }

    public final void setTracker(@NotNull UnknownScreenTracker unknownScreenTracker) {
        Intrinsics.checkNotNullParameter(unknownScreenTracker, "<set-?>");
        this.tracker = unknownScreenTracker;
    }
}

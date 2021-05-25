package com.avito.android.abuse.category;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.abuse.R;
import com.avito.android.abuse.category.AbuseCategoryPresenter;
import com.avito.android.abuse.category.di.AbuseCategoryComponent;
import com.avito.android.abuse.category.di.AbuseCategoryDependencies;
import com.avito.android.abuse.category.di.DaggerAbuseCategoryComponent;
import com.avito.android.abuse.event.AbuseCategoryEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Bundles;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.ArrayList;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bM\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0011\u0010\nJ)\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b \u0010!J\u0011\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b\"\u0010!R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010@\u001a\u00020?8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006N"}, d2 = {"Lcom/avito/android/abuse/category/AbuseCategoryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/abuse/category/AbuseCategoryPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDestroy", "onBackPressed", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "categoryId", "showAbuseDetailsScreen", "(I)V", "leaveScreen", "getContentLayoutId", "()I", "", AuthSource.SEND_ABUSE, "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "interactor", "Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "getInteractor", "()Lcom/avito/android/abuse/category/AbuseCategoryInteractor;", "setInteractor", "(Lcom/avito/android/abuse/category/AbuseCategoryInteractor;)V", "Lcom/avito/android/abuse/category/AbuseCategoryPresenter;", "presenter", "Lcom/avito/android/abuse/category/AbuseCategoryPresenter;", "getPresenter", "()Lcom/avito/android/abuse/category/AbuseCategoryPresenter;", "setPresenter", "(Lcom/avito/android/abuse/category/AbuseCategoryPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "recyclerAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getRecyclerAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setRecyclerAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategoryActivity extends BaseActivity implements AbuseCategoryPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public Features features;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public AbuseCategoryInteractor interactor;
    @Inject
    public AbuseCategoryPresenter presenter;
    @Inject
    public SimpleRecyclerAdapter recyclerAdapter;

    public final String a() {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.getString("advert_id_extra");
        }
        return null;
    }

    public final String b() {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.getString("src_extra");
        }
        return null;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.abuse_category;
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final AbuseCategoryInteractor getInteractor() {
        AbuseCategoryInteractor abuseCategoryInteractor = this.interactor;
        if (abuseCategoryInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return abuseCategoryInteractor;
    }

    @NotNull
    public final AbuseCategoryPresenter getPresenter() {
        AbuseCategoryPresenter abuseCategoryPresenter = this.presenter;
        if (abuseCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return abuseCategoryPresenter;
    }

    @NotNull
    public final SimpleRecyclerAdapter getRecyclerAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter.Router
    public void leaveScreen() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        boolean z = i2 == -1;
        if (i != 42) {
            super.onActivityResult(i, i2, intent);
        } else if (z) {
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AbuseCategoryPresenter abuseCategoryPresenter = this.presenter;
        if (abuseCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseCategoryPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String a;
        super.onCreate(bundle);
        AbuseCategoryPresenter abuseCategoryPresenter = this.presenter;
        if (abuseCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.recyclerAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerAdapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        abuseCategoryPresenter.attachView(new AbuseCategoryViewImpl(viewGroup, simpleRecyclerAdapter, analytics2));
        if (bundle == null && (a = a()) != null) {
            String b = b();
            if (b == null) {
                b = "";
            }
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics3.track(new AbuseCategoryEvent(a, b));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AbuseCategoryPresenter abuseCategoryPresenter = this.presenter;
        if (abuseCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseCategoryPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        AbuseCategoryPresenter abuseCategoryPresenter = this.presenter;
        if (abuseCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "abuse_category_presenter", abuseCategoryPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AbuseCategoryPresenter abuseCategoryPresenter = this.presenter;
        if (abuseCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseCategoryPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AbuseCategoryPresenter abuseCategoryPresenter = this.presenter;
        if (abuseCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        abuseCategoryPresenter.detachRouter();
        super.onStop();
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull AbuseCategoryInteractor abuseCategoryInteractor) {
        Intrinsics.checkNotNullParameter(abuseCategoryInteractor, "<set-?>");
        this.interactor = abuseCategoryInteractor;
    }

    public final void setPresenter(@NotNull AbuseCategoryPresenter abuseCategoryPresenter) {
        Intrinsics.checkNotNullParameter(abuseCategoryPresenter, "<set-?>");
        this.presenter = abuseCategoryPresenter;
    }

    public final void setRecyclerAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.recyclerAdapter = simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        String a = a();
        if (a != null) {
            AbuseCategoryComponent.Builder with = DaggerAbuseCategoryComponent.builder().dependentOn((AbuseCategoryDependencies) ComponentDependenciesKt.getDependencies(AbuseCategoryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).with(a);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            with.with(resources).with(bundle != null ? Bundles.getKundle(bundle, "abuse_category_presenter") : null).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException("advertId cannot be null");
    }

    @Override // com.avito.android.abuse.category.AbuseCategoryPresenter.Router
    public void showAbuseDetailsScreen(int i) {
        String a = a();
        if (a != null) {
            String b = b();
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Bundle extras = intent.getExtras();
            ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList("actions_extra") : null;
            ActivityIntentFactory activityIntentFactory = this.intentFactory;
            if (activityIntentFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
            }
            startActivityForResult(activityIntentFactory.abuseDetails(i, a, b, parcelableArrayList), 42);
            return;
        }
        throw new IllegalArgumentException("advertId cannot be null");
    }
}

package com.avito.android.category;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.category.CategoryPresenter;
import com.avito.android.category.di.CategoryComponent;
import com.avito.android.category.di.CategoryDependencies;
import com.avito.android.category.di.DaggerCategoryComponent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.remote.model.Location;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Intents;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\bG\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0007J\u001f\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010A\u001a\u00020@8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/avito/android/category/CategoryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/category/CategoryPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "", "getContentLayoutId", "()I", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "outState", "onSaveInstanceState", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "Lcom/avito/android/category/CategoryView;", "k", "Lcom/avito/android/category/CategoryView;", "view", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/util/DeviceMetrics;", "getDeviceMetrics", "()Lcom/avito/android/util/DeviceMetrics;", "setDeviceMetrics", "(Lcom/avito/android/util/DeviceMetrics;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/category/CategoryInteractor;", "interactor", "Lcom/avito/android/category/CategoryInteractor;", "getInteractor", "()Lcom/avito/android/category/CategoryInteractor;", "setInteractor", "(Lcom/avito/android/category/CategoryInteractor;)V", "Lcom/avito/android/util/BuildInfo;", "build", "Lcom/avito/android/util/BuildInfo;", "getBuild", "()Lcom/avito/android/util/BuildInfo;", "setBuild", "(Lcom/avito/android/util/BuildInfo;)V", "Lcom/avito/android/category/CategoryPresenter;", "presenter", "Lcom/avito/android/category/CategoryPresenter;", "getPresenter", "()Lcom/avito/android/category/CategoryPresenter;", "setPresenter", "(Lcom/avito/android/category/CategoryPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$category_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$category_release", "(Lcom/avito/android/analytics/Analytics;)V", "<init>", "Factory", "category_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryActivity extends BaseActivity implements CategoryPresenter.Router {
    @Inject
    public Analytics analytics;
    @Inject
    public BuildInfo build;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DeviceMetrics deviceMetrics;
    @Inject
    public CategoryInteractor interactor;
    public CategoryView k;
    @Inject
    public CategoryPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/category/CategoryActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/Location;", "location", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Lcom/avito/android/remote/model/Location;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "<init>", "()V", "category_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public static /* synthetic */ Intent create$default(Factory factory, Context context, Location location, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
            if ((i & 2) != 0) {
                location = null;
            }
            if ((i & 4) != 0) {
                treeClickStreamParent = null;
            }
            return factory.create(context, location, treeClickStreamParent);
        }

        @NotNull
        public final Intent create(@NotNull Context context, @Nullable Location location, @Nullable TreeClickStreamParent treeClickStreamParent) {
            Intent putExtra = a.X0(context, "context", context, CategoryActivity.class).putExtra("arguments", new CategoryArguments(location, treeClickStreamParent));
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…ts(location, treeParent))");
            return putExtra;
        }
    }

    @Override // com.avito.android.category.CategoryPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink, @NotNull TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        setIntent(deepLinkIntentFactory2.getIntent(deepLink));
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Intents.putTreeAnalyticsParent(intent, treeClickStreamParent);
        startActivity(getIntent());
    }

    @NotNull
    public final Analytics getAnalytics$category_release() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final BuildInfo getBuild() {
        BuildInfo buildInfo = this.build;
        if (buildInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("build");
        }
        return buildInfo;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.home_categories;
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
    public final DeviceMetrics getDeviceMetrics() {
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        return deviceMetrics2;
    }

    @NotNull
    public final CategoryInteractor getInteractor() {
        CategoryInteractor categoryInteractor = this.interactor;
        if (categoryInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return categoryInteractor;
    }

    @NotNull
    public final CategoryPresenter getPresenter() {
        CategoryPresenter categoryPresenter = this.presenter;
        if (categoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return categoryPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View containerView = getContainerView();
        Objects.requireNonNull(containerView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) containerView;
        DeviceMetrics deviceMetrics2 = this.deviceMetrics;
        if (deviceMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceMetrics");
        }
        BuildInfo buildInfo = this.build;
        if (buildInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("build");
        }
        CategoryPresenter categoryPresenter = this.presenter;
        if (categoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.k = new CategoryViewImpl(viewGroup, deviceMetrics2, buildInfo, categoryPresenter, analytics2);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        CategoryPresenter categoryPresenter = this.presenter;
        if (categoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putParcelable("CategoryPresenterState", categoryPresenter.getState());
        CategoryInteractor categoryInteractor = this.interactor;
        if (categoryInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putParcelable("LocationInteractorState", categoryInteractor.getState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        CategoryPresenter categoryPresenter = this.presenter;
        if (categoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        CategoryView categoryView = this.k;
        if (categoryView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        categoryPresenter.attachView(categoryView);
        CategoryPresenter categoryPresenter2 = this.presenter;
        if (categoryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        categoryPresenter2.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        CategoryPresenter categoryPresenter = this.presenter;
        if (categoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        categoryPresenter.detachView();
        CategoryPresenter categoryPresenter2 = this.presenter;
        if (categoryPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        categoryPresenter2.detachRouter();
        super.onStop();
    }

    public final void setAnalytics$category_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setBuild(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "<set-?>");
        this.build = buildInfo;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDeviceMetrics(@NotNull DeviceMetrics deviceMetrics2) {
        Intrinsics.checkNotNullParameter(deviceMetrics2, "<set-?>");
        this.deviceMetrics = deviceMetrics2;
    }

    public final void setInteractor(@NotNull CategoryInteractor categoryInteractor) {
        Intrinsics.checkNotNullParameter(categoryInteractor, "<set-?>");
        this.interactor = categoryInteractor;
    }

    public final void setPresenter(@NotNull CategoryPresenter categoryPresenter) {
        Intrinsics.checkNotNullParameter(categoryPresenter, "<set-?>");
        this.presenter = categoryPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        CategoryArguments categoryArguments = (CategoryArguments) getIntent().getParcelableExtra("arguments");
        if (categoryArguments != null) {
            categoryArguments.setFirstStart$category_release(bundle == null);
            CategoryComponent.Builder locationDependencies = DaggerCategoryComponent.builder().categoryDependencies((CategoryDependencies) ComponentDependenciesKt.getDependencies(CategoryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).locationDependencies((LocationDependencies) ComponentDependenciesKt.getDependencies(LocationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            CategoryComponent.Builder bindArguments = locationDependencies.bindResources(resources).bindArguments(categoryArguments);
            CategoryInteractorState categoryInteractorState = null;
            CategoryComponent.Builder bindCategoryPresenterState = bindArguments.bindCategoryPresenterState(bundle != null ? (CategoryPresenterState) bundle.getParcelable("CategoryPresenterState") : null);
            if (bundle != null) {
                categoryInteractorState = (CategoryInteractorState) bundle.getParcelable("LocationInteractorState");
            }
            bindCategoryPresenterState.bindCategoryInteractorState(categoryInteractorState).build().inject(this);
            return true;
        }
        throw new RuntimeException("arguments was not passed to " + this);
    }
}

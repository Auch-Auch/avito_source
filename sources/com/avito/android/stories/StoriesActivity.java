package com.avito.android.stories;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.component.DaggerStoriesComponent;
import com.avito.android.di.component.StoriesComponent;
import com.avito.android.di.component.StoriesDependencies;
import com.avito.android.serp.R;
import com.avito.android.stories.StoriesPresenter;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b<\u0010\u0018J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/avito/android/stories/StoriesActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/stories/StoriesPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "openUrl", "(Landroid/net/Uri;)V", "", "message", "close", "(Ljava/lang/String;)V", "onBackPressed", "()V", "onDestroy", "onStop", "onStart", "Landroid/content/res/Configuration;", "overrideConfiguration", "applyOverrideConfiguration", "(Landroid/content/res/Configuration;)V", "", "getContentLayoutId", "()I", "Lcom/avito/android/stories/StoriesPresenter;", "presenter", "Lcom/avito/android/stories/StoriesPresenter;", "getPresenter", "()Lcom/avito/android/stories/StoriesPresenter;", "setPresenter", "(Lcom/avito/android/stories/StoriesPresenter;)V", "Lcom/avito/android/stories/StoriesView;", "k", "Lcom/avito/android/stories/StoriesView;", "view", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "<init>", "Factory", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesActivity extends BaseActivity implements StoriesPresenter.Router {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public StoriesView k;
    @Inject
    public StoriesPresenter presenter;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/stories/StoriesActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/stories/StoriesArguments;", "arguments", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Lcom/avito/android/stories/StoriesArguments;)Landroid/content/Intent;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent create(@NotNull Context context, @NotNull StoriesArguments storiesArguments) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(storiesArguments, "arguments");
            Intent putExtra = new Intent(context, StoriesActivity.class).putExtra("arguments", storiesArguments);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…KEY_ARGUMENTS, arguments)");
            return IntentsKt.withClearTopFlags(putExtra);
        }
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "overrideConfiguration");
        if (22 < Build.VERSION.SDK_INT) {
            super.applyOverrideConfiguration(configuration);
        }
    }

    @Override // com.avito.android.stories.StoriesPresenter.Router
    public void close(@Nullable String str) {
        Intent intent = new Intent();
        StoriesPresenter storiesPresenter = this.presenter;
        if (storiesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        intent.putExtra(StoriesActivityKt.KEY_LAST_VIEWED_STORY_ID, storiesPresenter.getLastViewed());
        setResult(-1, intent);
        finish();
        overridePendingTransition(0, R.anim.fade_out_stories);
        if (str != null) {
            ToastsKt.showToast$default(this, str, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.stories_screen;
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
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final StoriesPresenter getPresenter() {
        StoriesPresenter storiesPresenter = this.presenter;
        if (storiesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return storiesPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        StoriesPresenter.Router.DefaultImpls.close$default(this, null, 1, null);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        overridePendingTransition(R.anim.fade_in_stories, 0);
        super.onCreate(bundle);
        View containerView = getContainerView();
        StoriesPresenter storiesPresenter = this.presenter;
        if (storiesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        this.k = new StoriesViewImpl(containerView, storiesPresenter);
        StoriesPresenter storiesPresenter2 = this.presenter;
        if (storiesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        StoriesView storiesView = this.k;
        if (storiesView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("view");
        }
        storiesPresenter2.attachView(storiesView);
        if (bundle == null) {
            StoriesView storiesView2 = this.k;
            if (storiesView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("view");
            }
            storiesView2.animateShow();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        StoriesPresenter storiesPresenter = this.presenter;
        if (storiesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        storiesPresenter.detachView();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        StoriesPresenter storiesPresenter = this.presenter;
        if (storiesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        storiesPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        StoriesPresenter storiesPresenter = this.presenter;
        if (storiesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        storiesPresenter.detachRouter();
    }

    @Override // com.avito.android.stories.StoriesPresenter.Router
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        startActivity(deepLinkIntentFactory2.getIntent(deepLink));
        finish();
    }

    @Override // com.avito.android.stories.StoriesPresenter.Router
    public void openUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Intent externalUriIntent = implicitIntentFactory2.externalUriIntent(uri, null);
        if (externalUriIntent != null) {
            try {
                startActivity(IntentsKt.makeSafeForExternalApps(externalUriIntent));
            } catch (Exception e) {
                Logs.error("StoriesActivity", "StartActivityError", e);
            }
        }
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPresenter(@NotNull StoriesPresenter storiesPresenter) {
        Intrinsics.checkNotNullParameter(storiesPresenter, "<set-?>");
        this.presenter = storiesPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        StoriesArguments storiesArguments;
        Intent intent = getIntent();
        if (intent == null || (storiesArguments = (StoriesArguments) intent.getParcelableExtra("arguments")) == null) {
            throw new RuntimeException("arguments was not passed to " + this);
        }
        StoriesComponent.Builder storiesDependencies = DaggerStoriesComponent.builder().storiesArguments(storiesArguments).storiesDependencies((StoriesDependencies) ComponentDependenciesKt.getDependencies(StoriesDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        storiesDependencies.resources(resources).build().inject(this);
        return true;
    }
}

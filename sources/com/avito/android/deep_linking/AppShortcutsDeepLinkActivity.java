package com.avito.android.deep_linking;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.avito.android.CalledFrom;
import com.avito.android.deep_linking.di.AppShortcutsDeepLinkDependencies;
import com.avito.android.deep_linking.di.DaggerAppShortcutsDeepLinkComponent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui_components.R;
import com.avito.android.util.Intents;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/deep_linking/AppShortcutsDeepLinkActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/deep_linking/AppShortcutsDeepLinkPresenter;", "presenter", "Lcom/avito/android/deep_linking/AppShortcutsDeepLinkPresenter;", "getPresenter", "()Lcom/avito/android/deep_linking/AppShortcutsDeepLinkPresenter;", "setPresenter", "(Lcom/avito/android/deep_linking/AppShortcutsDeepLinkPresenter;)V", "<init>", "()V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AppShortcutsDeepLinkActivity extends Activity {
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public AppShortcutsDeepLinkPresenter presenter;

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final AppShortcutsDeepLinkPresenter getPresenter() {
        AppShortcutsDeepLinkPresenter appShortcutsDeepLinkPresenter = this.presenter;
        if (appShortcutsDeepLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return appShortcutsDeepLinkPresenter;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerAppShortcutsDeepLinkComponent.builder().dependencies((AppShortcutsDeepLinkDependencies) ComponentDependenciesKt.getDependencies(AppShortcutsDeepLinkDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withRouter(new AppShortcutsDeepLinkRouter() { // from class: com.avito.android.deep_linking.AppShortcutsDeepLinkActivity$createRouter$1
            @Override // com.avito.android.deep_linking.AppShortcutsDeepLinkRouter
            public void closeScreen() {
                AppShortcutsDeepLinkActivity.this.finish();
            }

            @Override // com.avito.android.deep_linking.AppShortcutsDeepLinkRouter
            public boolean openDeepLink(@NotNull DeepLink deepLink, @NotNull CalledFrom.AndroidShortcuts androidShortcuts) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                Intrinsics.checkNotNullParameter(androidShortcuts, "calledFrom");
                Intent intent = AppShortcutsDeepLinkActivity.this.getDeepLinkIntentFactory().getIntent(deepLink);
                if (intent == null) {
                    return false;
                }
                Intents.setCalledFrom(intent, androidShortcuts);
                try {
                    AppShortcutsDeepLinkActivity.this.startActivity(IntentsKt.makeSafeForExternalApps(intent));
                    return true;
                } catch (Exception unused) {
                    ToastsKt.showToast$default(AppShortcutsDeepLinkActivity.this, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
                    return false;
                }
            }
        }).build().inject(this);
        AppShortcutsDeepLinkPresenter appShortcutsDeepLinkPresenter = this.presenter;
        if (appShortcutsDeepLinkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Uri data = intent.getData();
        Intrinsics.checkNotNull(data);
        Intrinsics.checkNotNullExpressionValue(data, "intent.data!!");
        appShortcutsDeepLinkPresenter.start(data);
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setPresenter(@NotNull AppShortcutsDeepLinkPresenter appShortcutsDeepLinkPresenter) {
        Intrinsics.checkNotNullParameter(appShortcutsDeepLinkPresenter, "<set-?>");
        this.presenter = appShortcutsDeepLinkPresenter;
    }
}

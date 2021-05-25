package com.avito.android.certificate_pinning;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.avito.android.certificate_pinning.UnsafeNetworkPresenter;
import com.avito.android.certificate_pinning.di.DaggerUnsafeNetworkComponent;
import com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Bundles;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Views;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\rR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/avito/android/certificate_pinning/UnsafeNetworkActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "url", "openBrowser", "(Ljava/lang/String;)V", "closeScreen", "()V", "outState", "onSaveInstanceState", "onDestroy", "onStart", "onStop", "onResume", "onBackPressed", "Lcom/avito/android/util/ImplicitIntentFactory;", "intentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;", "presenter", "Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;", "getPresenter", "()Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;", "setPresenter", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkPresenter;)V", "<init>", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public final class UnsafeNetworkActivity extends BaseActivity implements UnsafeNetworkPresenter.Router {
    @Inject
    public ImplicitIntentFactory intentFactory;
    @Inject
    public UnsafeNetworkPresenter presenter;

    public static final View access$getContainerRootView(UnsafeNetworkActivity unsafeNetworkActivity) {
        return unsafeNetworkActivity.findViewById(16908290);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter.Router
    public void closeScreen() {
        finish();
    }

    @NotNull
    public final ImplicitIntentFactory getIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return implicitIntentFactory;
    }

    @NotNull
    public final UnsafeNetworkPresenter getPresenter() {
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return unsafeNetworkPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        unsafeNetworkPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerUnsafeNetworkComponent.builder().dependentOn((UnsafeNetworkDependencies) ComponentDependenciesKt.getDependencies(UnsafeNetworkDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withPresenterState(bundle != null ? Bundles.getKundle(bundle, "presenter_state") : null).withShowErrorScreen(false).build().inject(this);
        setContentView(R.layout.unsafe_network_screen);
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "getContainerRootView()");
        unsafeNetworkPresenter.attachView(new UnsafeNetworkViewImpl(findViewById));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        unsafeNetworkPresenter.detachView();
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        unsafeNetworkPresenter.checkNetwork(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", unsafeNetworkPresenter.onSaveState());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        unsafeNetworkPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        UnsafeNetworkPresenter unsafeNetworkPresenter = this.presenter;
        if (unsafeNetworkPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        unsafeNetworkPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkPresenter.Router
    public void openBrowser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ImplicitIntentFactory implicitIntentFactory = this.intentFactory;
        if (implicitIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        try {
            startActivity(IntentsKt.makeSafeForExternalApps(implicitIntentFactory.uriIntent(parse)));
        } catch (Exception unused) {
            View access$getContainerRootView = access$getContainerRootView(this);
            Intrinsics.checkNotNullExpressionValue(access$getContainerRootView, "getContainerRootView()");
            Views.showSnackBar$default(access$getContainerRootView, R.string.no_application_installed_to_perform_this_action, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
        }
    }

    public final void setIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "<set-?>");
        this.intentFactory = implicitIntentFactory;
    }

    public final void setPresenter(@NotNull UnsafeNetworkPresenter unsafeNetworkPresenter) {
        Intrinsics.checkNotNullParameter(unsafeNetworkPresenter, "<set-?>");
        this.presenter = unsafeNetworkPresenter;
    }
}

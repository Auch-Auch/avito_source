package com.avito.android.update;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.update.UpdateApplicationPresenter;
import com.avito.android.update.di.DaggerUpdateApplicationComponent;
import com.avito.android.util.ImplicitIntentFactory;
import io.reactivex.Completable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\fR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/update/UpdateApplicationActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/update/UpdateApplicationPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lio/reactivex/Completable;", "openPlayStore", "()Lio/reactivex/Completable;", "onStart", "()V", "onStop", "onDestroy", "Lcom/avito/android/update/UpdateApplicationPresenter;", "presenter", "Lcom/avito/android/update/UpdateApplicationPresenter;", "getPresenter", "()Lcom/avito/android/update/UpdateApplicationPresenter;", "setPresenter", "(Lcom/avito/android/update/UpdateApplicationPresenter;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "intentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "<init>", "update_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateApplicationActivity extends BaseActivity implements UpdateApplicationPresenter.Router {
    @Inject
    public ImplicitIntentFactory intentFactory;
    @Inject
    public UpdateApplicationPresenter presenter;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ UpdateApplicationActivity a;

        public a(UpdateApplicationActivity updateApplicationActivity) {
            this.a = updateApplicationActivity;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.startActivity(this.a.getIntentFactory().marketIntent());
            return Unit.INSTANCE;
        }
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
    public final UpdateApplicationPresenter getPresenter() {
        UpdateApplicationPresenter updateApplicationPresenter = this.presenter;
        if (updateApplicationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return updateApplicationPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerUpdateApplicationComponent.builder().dependentOn((CoreComponentDependencies) ComponentDependenciesKt.getDependencies(CoreComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        setContentView(R.layout.update_application_screen);
        UpdateApplicationPresenter updateApplicationPresenter = this.presenter;
        if (updateApplicationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        updateApplicationPresenter.attachView(new UpdateApplicationViewImpl(findViewById));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        UpdateApplicationPresenter updateApplicationPresenter = this.presenter;
        if (updateApplicationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        updateApplicationPresenter.detachView();
        super.onDestroy();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        UpdateApplicationPresenter updateApplicationPresenter = this.presenter;
        if (updateApplicationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        updateApplicationPresenter.attachRouter(this);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        UpdateApplicationPresenter updateApplicationPresenter = this.presenter;
        if (updateApplicationPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        updateApplicationPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.update.UpdateApplicationPresenter.Router
    @NotNull
    public Completable openPlayStore() {
        Completable fromCallable = Completable.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…artActivity(intent)\n    }");
        return fromCallable;
    }

    public final void setIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "<set-?>");
        this.intentFactory = implicitIntentFactory;
    }

    public final void setPresenter(@NotNull UpdateApplicationPresenter updateApplicationPresenter) {
        Intrinsics.checkNotNullParameter(updateApplicationPresenter, "<set-?>");
        this.presenter = updateApplicationPresenter;
    }
}

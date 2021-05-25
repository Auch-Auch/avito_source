package com.avito.android.payment.top_up.form;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.ModalErrorView;
import com.avito.android.payment.R;
import com.avito.android.payment.di.component.DaggerTopUpFormComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.di.component.TopUpFormComponent;
import com.avito.android.payment.di.module.TopUpFormModule;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Kundle;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001>\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0019\u0010\bR\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "finish", "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onStart", "onStop", "onDestroy", "getContentLayoutId", "()I", "outState", "onSaveInstanceState", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;", "presenter", "Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;", "getPresenter", "()Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;", "setPresenter", "(Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;)V", "Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "interactor", "Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "getInteractor", "()Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "setInteractor", "(Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;)V", "Lcom/avito/android/payment/top_up/form/TopUpFormView;", "k", "Lcom/avito/android/payment/top_up/form/TopUpFormView;", "formView", "Lcom/avito/android/payment/ModalErrorView;", "l", "Lcom/avito/android/payment/ModalErrorView;", "modalErrorView", "com/avito/android/payment/top_up/form/TopUpFormActivity$router$1", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/payment/top_up/form/TopUpFormActivity$router$1;", "router", "<init>", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormActivity extends BaseActivity {
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public TopUpFormInteractor interactor;
    public TopUpFormView k;
    public ModalErrorView l;
    public final TopUpFormActivity$router$1 m = new TopUpFormActivity$router$1(this);
    @Inject
    public TopUpFormPresenter presenter;

    @Override // android.app.Activity
    public void finish() {
        Keyboards.hideKeyboard(this);
        super.finish();
    }

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.activity_top_up;
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
    public final TopUpFormInteractor getInteractor() {
        TopUpFormInteractor topUpFormInteractor = this.interactor;
        if (topUpFormInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return topUpFormInteractor;
    }

    @NotNull
    public final TopUpFormPresenter getPresenter() {
        TopUpFormPresenter topUpFormPresenter = this.presenter;
        if (topUpFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return topUpFormPresenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String stringExtra;
        ModalErrorView modalErrorView;
        if (i != 2) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == 0 && intent != null && (stringExtra = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT)) != null && (modalErrorView = this.l) != null) {
            modalErrorView.showModalError(stringExtra);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View containerView = getContainerView();
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        TopUpFormViewImpl topUpFormViewImpl = new TopUpFormViewImpl(containerView, simpleRecyclerAdapter);
        this.k = topUpFormViewImpl;
        this.l = topUpFormViewImpl;
        TopUpFormPresenter topUpFormPresenter = this.presenter;
        if (topUpFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        TopUpFormView topUpFormView = this.k;
        if (topUpFormView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("formView");
        }
        topUpFormPresenter.attachView(topUpFormView);
        setResult(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        TopUpFormPresenter topUpFormPresenter = this.presenter;
        if (topUpFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        topUpFormPresenter.detachView();
        TopUpFormPresenter topUpFormPresenter2 = this.presenter;
        if (topUpFormPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        topUpFormPresenter2.dispose();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        TopUpFormPresenter topUpFormPresenter = this.presenter;
        if (topUpFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("com.avito.android.payment.top_up.key_presenter_state", topUpFormPresenter.onSaveState().toBundle());
        TopUpFormInteractor topUpFormInteractor = this.interactor;
        if (topUpFormInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putBundle("com.avito.android.payment.top_up.key_interactor_state", topUpFormInteractor.onSaveState().toBundle());
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        TopUpFormPresenter topUpFormPresenter = this.presenter;
        if (topUpFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        topUpFormPresenter.attachRouter(this.m);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        TopUpFormPresenter topUpFormPresenter = this.presenter;
        if (topUpFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        topUpFormPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull TopUpFormInteractor topUpFormInteractor) {
        Intrinsics.checkNotNullParameter(topUpFormInteractor, "<set-?>");
        this.interactor = topUpFormInteractor;
    }

    public final void setPresenter(@NotNull TopUpFormPresenter topUpFormPresenter) {
        Intrinsics.checkNotNullParameter(topUpFormPresenter, "<set-?>");
        this.presenter = topUpFormPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Kundle kundle;
        Bundle bundle2;
        Bundle bundle3;
        Kundle kundle2 = null;
        if (bundle == null || (bundle3 = bundle.getBundle("com.avito.android.payment.top_up.key_presenter_state")) == null) {
            kundle = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(bundle3, "it");
            kundle = new Kundle(bundle3);
        }
        if (!(bundle == null || (bundle2 = bundle.getBundle("com.avito.android.payment.top_up.key_interactor_state")) == null)) {
            Intrinsics.checkNotNullExpressionValue(bundle2, "it");
            kundle2 = new Kundle(bundle2);
        }
        TopUpFormComponent.Builder paymentDependencies = DaggerTopUpFormComponent.builder().paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this)));
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        paymentDependencies.topUpFormModule(new TopUpFormModule(kundle2, kundle, resources, this)).build().inject(this);
        return true;
    }
}

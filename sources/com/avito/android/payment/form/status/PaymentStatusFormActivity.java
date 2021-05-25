package com.avito.android.payment.form.status;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.R;
import com.avito.android.payment.di.component.DaggerPaymentStatusFormComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.di.module.PaymentStatusFormModule;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.payment.processing.ProcessingResult;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001J\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\\\u0010\u0014J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0018\u0010\rR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006]"}, d2 = {"Lcom/avito/android/payment/form/status/PaymentStatusFormActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "getContentLayoutId", "()I", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "interactor", "Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "getInteractor", "()Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;", "setInteractor", "(Lcom/avito/android/payment/form/status/PaymentStatusFormInteractor;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "getDeepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "setDeepLinkFactory", "(Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "Lcom/avito/android/payment/form/status/PaymentStatusFormPresenter;", "presenter", "Lcom/avito/android/payment/form/status/PaymentStatusFormPresenter;", "getPresenter", "()Lcom/avito/android/payment/form/status/PaymentStatusFormPresenter;", "setPresenter", "(Lcom/avito/android/payment/form/status/PaymentStatusFormPresenter;)V", "com/avito/android/payment/form/status/PaymentStatusFormActivity$router$1", "k", "Lcom/avito/android/payment/form/status/PaymentStatusFormActivity$router$1;", "router", "Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;", "processingPresenter", "Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;", "getProcessingPresenter", "()Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;", "setProcessingPresenter", "(Lcom/avito/android/payment/form/status/StatusFormProcessingPresenter;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "<init>", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusFormActivity extends BaseActivity {
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkFactory deepLinkFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public PaymentStatusFormInteractor interactor;
    public final PaymentStatusFormActivity$router$1 k = new PaymentStatusFormActivity$router$1(this);
    @Inject
    public PaymentStatusFormPresenter presenter;
    @Inject
    public StatusFormProcessingPresenter processingPresenter;

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
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
        return R.layout.payment_generic_form;
    }

    @NotNull
    public final DeepLinkFactory getDeepLinkFactory() {
        DeepLinkFactory deepLinkFactory2 = this.deepLinkFactory;
        if (deepLinkFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkFactory");
        }
        return deepLinkFactory2;
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
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final PaymentStatusFormInteractor getInteractor() {
        PaymentStatusFormInteractor paymentStatusFormInteractor = this.interactor;
        if (paymentStatusFormInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return paymentStatusFormInteractor;
    }

    @NotNull
    public final PaymentStatusFormPresenter getPresenter() {
        PaymentStatusFormPresenter paymentStatusFormPresenter = this.presenter;
        if (paymentStatusFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return paymentStatusFormPresenter;
    }

    @NotNull
    public final StatusFormProcessingPresenter getProcessingPresenter() {
        StatusFormProcessingPresenter statusFormProcessingPresenter = this.processingPresenter;
        if (statusFormProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        return statusFormProcessingPresenter;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        ProcessingResult processingResult;
        ProcessingResult error;
        if (i != 4) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (intent == null) {
            processingResult = new ProcessingResult.Canceled();
        } else {
            if (intent.hasExtra(PaymentProcessingConstants.EXTRA_PAYMENT_STATUS_RESULT)) {
                Parcelable parcelableExtra = intent.getParcelableExtra(PaymentProcessingConstants.EXTRA_PAYMENT_STATUS_RESULT);
                Intrinsics.checkNotNullExpressionValue(parcelableExtra, "data.getParcelableExtra(…RA_PAYMENT_STATUS_RESULT)");
                error = new ProcessingResult.Finished((PaymentStatusResult.PaymentStatus) parcelableExtra);
            } else if (intent.hasExtra(PaymentProcessingConstants.EXTRA_PAYMENT_REDIRECT_RESULT)) {
                String stringExtra = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_REDIRECT_RESULT);
                Intrinsics.checkNotNullExpressionValue(stringExtra, "data.getStringExtra(Paym…_PAYMENT_REDIRECT_RESULT)");
                error = new ProcessingResult.Redirect(stringExtra);
            } else if (intent.hasExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT)) {
                String stringExtra2 = intent.getStringExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT);
                Intrinsics.checkNotNullExpressionValue(stringExtra2, "data.getStringExtra(\n   …                        )");
                error = new ProcessingResult.Error(stringExtra2);
            } else {
                processingResult = new ProcessingResult.Canceled();
            }
            processingResult = error;
        }
        StatusFormProcessingPresenter statusFormProcessingPresenter = this.processingPresenter;
        if (statusFormProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        statusFormProcessingPresenter.processPayment(processingResult);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View containerView = getContainerView();
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        PaymentStatusFormViewImpl paymentStatusFormViewImpl = new PaymentStatusFormViewImpl(containerView, simpleRecyclerAdapter, adapterPresenter2, analytics2, dialogRouter2);
        PaymentStatusFormPresenter paymentStatusFormPresenter = this.presenter;
        if (paymentStatusFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentStatusFormPresenter.attachView(paymentStatusFormViewImpl);
        StatusFormProcessingPresenter statusFormProcessingPresenter = this.processingPresenter;
        if (statusFormProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        statusFormProcessingPresenter.attachView(paymentStatusFormViewImpl);
        StatusFormProcessingPresenter statusFormProcessingPresenter2 = this.processingPresenter;
        if (statusFormProcessingPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        statusFormProcessingPresenter2.attachModalView(paymentStatusFormViewImpl);
        StatusFormProcessingPresenter statusFormProcessingPresenter3 = this.processingPresenter;
        if (statusFormProcessingPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        statusFormProcessingPresenter3.attachRouter(this.k);
        setResult(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PaymentStatusFormPresenter paymentStatusFormPresenter = this.presenter;
        if (paymentStatusFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentStatusFormPresenter.detachView();
        PaymentStatusFormPresenter paymentStatusFormPresenter2 = this.presenter;
        if (paymentStatusFormPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentStatusFormPresenter2.dispose();
        StatusFormProcessingPresenter statusFormProcessingPresenter = this.processingPresenter;
        if (statusFormProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        statusFormProcessingPresenter.detachRouter();
        StatusFormProcessingPresenter statusFormProcessingPresenter2 = this.processingPresenter;
        if (statusFormProcessingPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        statusFormProcessingPresenter2.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        PaymentStatusFormInteractor paymentStatusFormInteractor = this.interactor;
        if (paymentStatusFormInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putBundle("interactor_state", paymentStatusFormInteractor.onSaveState().toBundle());
        StatusFormProcessingPresenter statusFormProcessingPresenter = this.processingPresenter;
        if (statusFormProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        bundle.putBundle("processing_presenter_state", statusFormProcessingPresenter.onSaveState().toBundle());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PaymentStatusFormPresenter paymentStatusFormPresenter = this.presenter;
        if (paymentStatusFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentStatusFormPresenter.attachRouter(this.k);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        PaymentStatusFormPresenter paymentStatusFormPresenter = this.presenter;
        if (paymentStatusFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentStatusFormPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkFactory(@NotNull DeepLinkFactory deepLinkFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkFactory2, "<set-?>");
        this.deepLinkFactory = deepLinkFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setInteractor(@NotNull PaymentStatusFormInteractor paymentStatusFormInteractor) {
        Intrinsics.checkNotNullParameter(paymentStatusFormInteractor, "<set-?>");
        this.interactor = paymentStatusFormInteractor;
    }

    public final void setPresenter(@NotNull PaymentStatusFormPresenter paymentStatusFormPresenter) {
        Intrinsics.checkNotNullParameter(paymentStatusFormPresenter, "<set-?>");
        this.presenter = paymentStatusFormPresenter;
    }

    public final void setProcessingPresenter(@NotNull StatusFormProcessingPresenter statusFormProcessingPresenter) {
        Intrinsics.checkNotNullParameter(statusFormProcessingPresenter, "<set-?>");
        this.processingPresenter = statusFormProcessingPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Kundle kundle;
        Bundle bundle2;
        Bundle bundle3;
        Kundle kundle2 = null;
        if (bundle == null || (bundle3 = bundle.getBundle("interactor_state")) == null) {
            kundle = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(bundle3, "it");
            kundle = new Kundle(bundle3);
        }
        if (!(bundle == null || (bundle2 = bundle.getBundle("processing_presenter_state")) == null)) {
            Intrinsics.checkNotNullExpressionValue(bundle2, "it");
            kundle2 = new Kundle(bundle2);
        }
        String stringExtra = getIntent().getStringExtra("PaymentStatusFormActivity_order_id");
        if (stringExtra != null) {
            DaggerPaymentStatusFormComponent.builder().paymentStatusFormModule(new PaymentStatusFormModule(kundle, kundle2, stringExtra)).paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this).build().inject(this);
            return true;
        }
        throw new IllegalArgumentException("orderId must not be null");
    }
}

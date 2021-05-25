package com.avito.android.payment.form;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.R;
import com.avito.android.payment.di.component.DaggerPaymentGenericFormComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.di.component.PaymentGenericFormComponent;
import com.avito.android.payment.di.module.PaymentGenericFormModule;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.payment.processing.ProcessingResult;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.payment.remote.PaymentSessionTypeMarkerKt;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Kundle;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001<\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bU\u0010\u0014J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0018\u0010\rR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010A\u001a\u00020@8\u0000@\u0000X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010H\u001a\u00020G8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010O\u001a\u00020N8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006V"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "getContentLayoutId", "()I", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "onStart", "()V", "onStop", "onDestroy", "outState", "onSaveInstanceState", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "interactor", "Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "getInteractor", "()Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "setInteractor", "(Lcom/avito/android/payment/form/PaymentGenericFormInteractor;)V", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "processingPresenter", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "getProcessingPresenter", "()Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "setProcessingPresenter", "(Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;)V", "com/avito/android/payment/form/PaymentGenericFormActivity$router$1", "k", "Lcom/avito/android/payment/form/PaymentGenericFormActivity$router$1;", "router", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics$payment_release", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics$payment_release", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/payment/form/PaymentGenericFormPresenter;", "presenter", "Lcom/avito/android/payment/form/PaymentGenericFormPresenter;", "getPresenter", "()Lcom/avito/android/payment/form/PaymentGenericFormPresenter;", "setPresenter", "(Lcom/avito/android/payment/form/PaymentGenericFormPresenter;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "<init>", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFormActivity extends BaseActivity {
    @Inject
    public SimpleRecyclerAdapter adapter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public PaymentGenericFormInteractor interactor;
    @Inject
    public ItemBinder itemBinder;
    public final PaymentGenericFormActivity$router$1 k = new PaymentGenericFormActivity$router$1(this);
    @Inject
    public PaymentGenericFormPresenter presenter;
    @Inject
    public PaymentStatusProcessingPresenter processingPresenter;

    @NotNull
    public final SimpleRecyclerAdapter getAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return simpleRecyclerAdapter;
    }

    @NotNull
    public final Analytics getAnalytics$payment_release() {
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
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
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
    public final PaymentGenericFormInteractor getInteractor() {
        PaymentGenericFormInteractor paymentGenericFormInteractor = this.interactor;
        if (paymentGenericFormInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return paymentGenericFormInteractor;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final PaymentGenericFormPresenter getPresenter() {
        PaymentGenericFormPresenter paymentGenericFormPresenter = this.presenter;
        if (paymentGenericFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return paymentGenericFormPresenter;
    }

    @NotNull
    public final PaymentStatusProcessingPresenter getProcessingPresenter() {
        PaymentStatusProcessingPresenter paymentStatusProcessingPresenter = this.processingPresenter;
        if (paymentStatusProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        return paymentStatusProcessingPresenter;
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
        PaymentStatusProcessingPresenter paymentStatusProcessingPresenter = this.processingPresenter;
        if (paymentStatusProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        paymentStatusProcessingPresenter.processPayment(processingResult);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        View containerView = getContainerView();
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.adapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        PaymentGenericFormViewImpl paymentGenericFormViewImpl = new PaymentGenericFormViewImpl(containerView, simpleRecyclerAdapter, analytics2);
        PaymentGenericFormPresenter paymentGenericFormPresenter = this.presenter;
        if (paymentGenericFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentGenericFormPresenter.attachView(paymentGenericFormViewImpl);
        PaymentStatusProcessingPresenter paymentStatusProcessingPresenter = this.processingPresenter;
        if (paymentStatusProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        paymentStatusProcessingPresenter.attachView(paymentGenericFormViewImpl);
        PaymentStatusProcessingPresenter paymentStatusProcessingPresenter2 = this.processingPresenter;
        if (paymentStatusProcessingPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        paymentStatusProcessingPresenter2.attachRouter(this.k);
        setResult(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PaymentGenericFormPresenter paymentGenericFormPresenter = this.presenter;
        if (paymentGenericFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentGenericFormPresenter.detachView();
        PaymentGenericFormPresenter paymentGenericFormPresenter2 = this.presenter;
        if (paymentGenericFormPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentGenericFormPresenter2.dispose();
        PaymentStatusProcessingPresenter paymentStatusProcessingPresenter = this.processingPresenter;
        if (paymentStatusProcessingPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        paymentStatusProcessingPresenter.detachRouter();
        PaymentStatusProcessingPresenter paymentStatusProcessingPresenter2 = this.processingPresenter;
        if (paymentStatusProcessingPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processingPresenter");
        }
        paymentStatusProcessingPresenter2.detachView();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        PaymentGenericFormInteractor paymentGenericFormInteractor = this.interactor;
        if (paymentGenericFormInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putBundle("interactor_state", paymentGenericFormInteractor.onSaveState().toBundle());
        PaymentGenericFormPresenter paymentGenericFormPresenter = this.presenter;
        if (paymentGenericFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("presenter_state", paymentGenericFormPresenter.onSaveState().toBundle());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        PaymentGenericFormPresenter paymentGenericFormPresenter = this.presenter;
        if (paymentGenericFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentGenericFormPresenter.attachRouter(this.k);
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        PaymentGenericFormPresenter paymentGenericFormPresenter = this.presenter;
        if (paymentGenericFormPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        paymentGenericFormPresenter.detachRouter();
        super.onStop();
    }

    public final void setAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.adapter = simpleRecyclerAdapter;
    }

    public final void setAnalytics$payment_release(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setInteractor(@NotNull PaymentGenericFormInteractor paymentGenericFormInteractor) {
        Intrinsics.checkNotNullParameter(paymentGenericFormInteractor, "<set-?>");
        this.interactor = paymentGenericFormInteractor;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setPresenter(@NotNull PaymentGenericFormPresenter paymentGenericFormPresenter) {
        Intrinsics.checkNotNullParameter(paymentGenericFormPresenter, "<set-?>");
        this.presenter = paymentGenericFormPresenter;
    }

    public final void setProcessingPresenter(@NotNull PaymentStatusProcessingPresenter paymentStatusProcessingPresenter) {
        Intrinsics.checkNotNullParameter(paymentStatusProcessingPresenter, "<set-?>");
        this.processingPresenter = paymentStatusProcessingPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Kundle kundle;
        Kundle kundle2;
        Bundle bundle2;
        Bundle bundle3;
        Serializable serializable = null;
        if (bundle == null || (bundle3 = bundle.getBundle("presenter_state")) == null) {
            kundle = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(bundle3, "it");
            kundle = new Kundle(bundle3);
        }
        if (bundle == null || (bundle2 = bundle.getBundle("interactor_state")) == null) {
            kundle2 = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(bundle2, "it");
            kundle2 = new Kundle(bundle2);
        }
        String stringExtra = getIntent().getStringExtra("PaymentGenericFormActivity_session_id");
        if (stringExtra != null) {
            String stringExtra2 = getIntent().getStringExtra("PaymentGenericFormActivity_method_signature");
            if (stringExtra2 != null) {
                Intent intent = getIntent();
                if (intent != null) {
                    serializable = intent.getSerializableExtra(PaymentSessionTypeMarkerKt.EXTRA_PAYMENT_SESSION_TYPE_MARKER);
                }
                Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.avito.android.payment.remote.PaymentSessionTypeMarker");
                PaymentGenericFormComponent.Builder builder = DaggerPaymentGenericFormComponent.builder();
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                builder.paymentGenericFormModule(new PaymentGenericFormModule(kundle2, kundle, stringExtra, stringExtra2, resources, this)).paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).paymentSessionTypeMarker((PaymentSessionTypeMarker) serializable).build().inject(this);
                return true;
            }
            throw new IllegalArgumentException("serviceId must not ne null");
        }
        throw new IllegalArgumentException("itemId must not be null");
    }
}

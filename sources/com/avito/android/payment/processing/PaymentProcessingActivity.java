package com.avito.android.payment.processing;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.di.component.DaggerPaymentProcessingComponent;
import com.avito.android.payment.di.component.PaymentDependencies;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.payment.remote.PaymentSessionTypeMarkerKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ParameterTreesKt;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001-\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bG\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/avito/android/payment/processing/PaymentProcessingActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onDestroy", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/processing/PaymentGenericFactory;", "paymentPresenterFactory", "Lcom/avito/android/payment/processing/PaymentGenericFactory;", "getPaymentPresenterFactory", "()Lcom/avito/android/payment/processing/PaymentGenericFactory;", "setPaymentPresenterFactory", "(Lcom/avito/android/payment/processing/PaymentGenericFactory;)V", "Lcom/avito/android/payment/processing/PaymentGenericPresenter;", "k", "Lcom/avito/android/payment/processing/PaymentGenericPresenter;", "paymentPresenter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "getDeepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "setDeepLinkFactory", "(Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "com/avito/android/payment/processing/PaymentProcessingActivity$router$1", "n", "Lcom/avito/android/payment/processing/PaymentProcessingActivity$router$1;", "router", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Landroid/app/Dialog;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/app/Dialog;", "dialog", "Lcom/avito/android/payment/processing/PaymentStatusPresenter;", "l", "Lcom/avito/android/payment/processing/PaymentStatusPresenter;", "statusPresenter", "Lcom/avito/android/payment/processing/PaymentStatusFactory;", "statusPresenterFactory", "Lcom/avito/android/payment/processing/PaymentStatusFactory;", "getStatusPresenterFactory", "()Lcom/avito/android/payment/processing/PaymentStatusFactory;", "setStatusPresenterFactory", "(Lcom/avito/android/payment/processing/PaymentStatusFactory;)V", "<init>", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentProcessingActivity extends BaseActivity {
    @Inject
    public DeepLinkFactory deepLinkFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    public PaymentGenericPresenter k;
    public PaymentStatusPresenter l;
    public Dialog m;
    public final PaymentProcessingActivity$router$1 n = new PaymentProcessingActivity$router$1(this);
    @Inject
    public PaymentGenericFactory paymentPresenterFactory;
    @Inject
    public PaymentStatusFactory statusPresenterFactory;

    public final void a(Intent intent) {
        if (intent.hasExtra("PaymentProcessingActivity_order_id")) {
            String stringExtra = intent.getStringExtra("PaymentProcessingActivity_order_id");
            PaymentStatusPresenter paymentStatusPresenter = this.l;
            if (paymentStatusPresenter != null) {
                paymentStatusPresenter.detachRouter();
            }
            PaymentStatusPresenter paymentStatusPresenter2 = this.l;
            if (paymentStatusPresenter2 != null) {
                paymentStatusPresenter2.dispose();
            }
            PaymentStatusFactory paymentStatusFactory = this.statusPresenterFactory;
            if (paymentStatusFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusPresenterFactory");
            }
            Intrinsics.checkNotNullExpressionValue(stringExtra, AnalyticFieldsName.orderId);
            PaymentStatusPresenter createPresenter = paymentStatusFactory.createPresenter(stringExtra);
            this.l = createPresenter;
            if (createPresenter != null) {
                createPresenter.attachRouter(this.n);
            }
            PaymentStatusPresenter paymentStatusPresenter3 = this.l;
            if (paymentStatusPresenter3 != null) {
                paymentStatusPresenter3.getPaymentStatus();
                return;
            }
            return;
        }
        String stringExtra2 = intent.getStringExtra("PaymentProcessingActivity_session_id");
        String stringExtra3 = intent.getStringExtra("PaymentProcessingActivity_method_signature");
        ParametersTree parametersTree = (ParametersTree) intent.getParcelableExtra("PaymentProcessingActivity_parameters");
        PaymentGenericPresenter paymentGenericPresenter = this.k;
        if (paymentGenericPresenter != null) {
            paymentGenericPresenter.detachRouter();
        }
        PaymentGenericPresenter paymentGenericPresenter2 = this.k;
        if (paymentGenericPresenter2 != null) {
            paymentGenericPresenter2.dispose();
        }
        PaymentGenericFactory paymentGenericFactory = this.paymentPresenterFactory;
        if (paymentGenericFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentPresenterFactory");
        }
        Intrinsics.checkNotNullExpressionValue(stringExtra2, "paymentSessionId");
        Intrinsics.checkNotNullExpressionValue(stringExtra3, "methodSignature");
        Intrinsics.checkNotNullExpressionValue(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        PaymentGenericPresenter createPresenter2 = paymentGenericFactory.createPresenter(stringExtra2, stringExtra3, ParameterTreesKt.convertToMap(parametersTree));
        this.k = createPresenter2;
        if (createPresenter2 != null) {
            createPresenter2.attachRouter(this.n);
        }
        PaymentGenericPresenter paymentGenericPresenter3 = this.k;
        if (paymentGenericPresenter3 != null) {
            paymentGenericPresenter3.initPayment();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
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
    public final PaymentGenericFactory getPaymentPresenterFactory() {
        PaymentGenericFactory paymentGenericFactory = this.paymentPresenterFactory;
        if (paymentGenericFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentPresenterFactory");
        }
        return paymentGenericFactory;
    }

    @NotNull
    public final PaymentStatusFactory getStatusPresenterFactory() {
        PaymentStatusFactory paymentStatusFactory = this.statusPresenterFactory;
        if (paymentStatusFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusPresenterFactory");
        }
        return paymentStatusFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        Dialog showSimpleWaitingDialog = dialogRouter2.showSimpleWaitingDialog();
        showSimpleWaitingDialog.setCancelable(false);
        this.m = showSimpleWaitingDialog;
        setResult(0);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        a(intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PaymentGenericPresenter paymentGenericPresenter = this.k;
        if (paymentGenericPresenter != null) {
            paymentGenericPresenter.detachRouter();
        }
        PaymentGenericPresenter paymentGenericPresenter2 = this.k;
        if (paymentGenericPresenter2 != null) {
            paymentGenericPresenter2.dispose();
        }
        PaymentStatusPresenter paymentStatusPresenter = this.l;
        if (paymentStatusPresenter != null) {
            paymentStatusPresenter.detachRouter();
        }
        PaymentStatusPresenter paymentStatusPresenter2 = this.l;
        if (paymentStatusPresenter2 != null) {
            paymentStatusPresenter2.dispose();
        }
        Dialog dialog = this.m;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        a(intent);
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

    public final void setPaymentPresenterFactory(@NotNull PaymentGenericFactory paymentGenericFactory) {
        Intrinsics.checkNotNullParameter(paymentGenericFactory, "<set-?>");
        this.paymentPresenterFactory = paymentGenericFactory;
    }

    public final void setStatusPresenterFactory(@NotNull PaymentStatusFactory paymentStatusFactory) {
        Intrinsics.checkNotNullParameter(paymentStatusFactory, "<set-?>");
        this.statusPresenterFactory = paymentStatusFactory;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Intent intent = getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(PaymentSessionTypeMarkerKt.EXTRA_PAYMENT_SESSION_TYPE_MARKER) : null;
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.payment.remote.PaymentSessionTypeMarker");
        DaggerPaymentProcessingComponent.builder().paymentDependencies((PaymentDependencies) ComponentDependenciesKt.getDependencies(PaymentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).withActivity(this).paymentSessionTypeMarker((PaymentSessionTypeMarker) serializableExtra).build().inject(this);
        return true;
    }
}

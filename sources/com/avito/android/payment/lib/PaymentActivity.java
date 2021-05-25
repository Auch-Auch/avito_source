package com.avito.android.payment.lib;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.PaymentIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.GooglePayLink;
import com.avito.android.deep_linking.links.PaymentGenericLink;
import com.avito.android.deep_linking.links.SBOLPaymentLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.payment.lib.PaymentSessionType;
import com.avito.android.payment.lib.di.DaggerPaymentMethodsComponent;
import com.avito.android.payment.lib.di.PaymentLibraryDependencies;
import com.avito.android.payment.lib.di.PaymentMethodsModule;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.payment.processing.ProcessingResult;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.payment.remote.PaymentSessionTypeMarkerKt;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.IntentsKt;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0006@\u0006X.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0002088\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/avito/android/payment/lib/PaymentActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "getPaymentSessionTypeMarker", "()Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "setPaymentSessionTypeMarker", "(Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel;", "paymentMethodsViewModel", "Lcom/avito/android/payment/lib/PaymentMethodsViewModel;", "getPaymentMethodsViewModel", "()Lcom/avito/android/payment/lib/PaymentMethodsViewModel;", "setPaymentMethodsViewModel", "(Lcom/avito/android/payment/lib/PaymentMethodsViewModel;)V", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "simpleRecyclerViewAdapter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "getSimpleRecyclerViewAdapter", "()Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "setSimpleRecyclerViewAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "<init>", "()V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentActivity extends BaseActivity {
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public PaymentMethodsViewModel paymentMethodsViewModel;
    public PaymentSessionTypeMarker paymentSessionTypeMarker;
    @Inject
    public SimpleRecyclerAdapter simpleRecyclerViewAdapter;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ PaymentActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PaymentActivity paymentActivity) {
            super(1);
            this.a = paymentActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            this.a.getPaymentMethodsViewModel().onPaymentMethodClickListener(num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final void access$onClosePaymentScreen(PaymentActivity paymentActivity, PaymentResult paymentResult) {
        Objects.requireNonNull(paymentActivity);
        int i = (paymentResult == PaymentResult.SUCCESS || paymentResult == PaymentResult.ACTIVE) ? -1 : 0;
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_RESULT, paymentResult.getTitle());
        paymentActivity.setResult(i, intent);
        paymentActivity.finish();
    }

    public static final void access$onDeepLink(PaymentActivity paymentActivity, DeepLink deepLink) {
        Objects.requireNonNull(paymentActivity);
        if (deepLink instanceof SBOLPaymentLink) {
            DeepLinkIntentFactory deepLinkIntentFactory2 = paymentActivity.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
            Intrinsics.checkNotNull(intent);
            try {
                paymentActivity.startActivityForResult(IntentsKt.makeSafeForExternalApps(intent), 8);
            } catch (Exception unused) {
                paymentActivity.getPaymentMethodsViewModel().onSberbankOnlineLaunchFailed();
            }
        } else if (deepLink instanceof GooglePayLink) {
            PaymentMethodsViewModel paymentMethodsViewModel2 = paymentActivity.paymentMethodsViewModel;
            if (paymentMethodsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
            }
            paymentMethodsViewModel2.startGooglePay(paymentActivity, 16, ((GooglePayLink) deepLink).getAmount());
        } else if (deepLink instanceof PaymentGenericLink) {
            PaymentMethodsViewModel paymentMethodsViewModel3 = paymentActivity.paymentMethodsViewModel;
            if (paymentMethodsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
            }
            PaymentGenericLink paymentGenericLink = (PaymentGenericLink) deepLink;
            paymentMethodsViewModel3.sendGeneric(paymentGenericLink.getMethodSignature(), paymentGenericLink.getPaymentSessionId(), paymentGenericLink.getPaymentToken());
        } else {
            DeepLinkIntentFactory deepLinkIntentFactory3 = paymentActivity.deepLinkIntentFactory;
            if (deepLinkIntentFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            Intent intent2 = deepLinkIntentFactory3.getIntent(deepLink);
            if (intent2 != null) {
                PaymentSessionTypeMarker paymentSessionTypeMarker2 = paymentActivity.paymentSessionTypeMarker;
                if (paymentSessionTypeMarker2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentSessionTypeMarker");
                }
                intent2.putExtra(PaymentSessionTypeMarkerKt.EXTRA_PAYMENT_SESSION_TYPE_MARKER, paymentSessionTypeMarker2);
                paymentActivity.startActivityForResult(intent2, 4);
            }
        }
    }

    public static final void access$onUriRedirect(PaymentActivity paymentActivity, String str) {
        ActivityIntentFactory activityIntentFactory = paymentActivity.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        paymentActivity.startActivityForResult(PaymentIntentFactory.DefaultImpls.webPaymentIntent$default(activityIntentFactory, str, null, 2, null), 2);
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
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final PaymentMethodsViewModel getPaymentMethodsViewModel() {
        PaymentMethodsViewModel paymentMethodsViewModel2 = this.paymentMethodsViewModel;
        if (paymentMethodsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
        }
        return paymentMethodsViewModel2;
    }

    @NotNull
    public final PaymentSessionTypeMarker getPaymentSessionTypeMarker() {
        PaymentSessionTypeMarker paymentSessionTypeMarker2 = this.paymentSessionTypeMarker;
        if (paymentSessionTypeMarker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentSessionTypeMarker");
        }
        return paymentSessionTypeMarker2;
    }

    @NotNull
    public final SimpleRecyclerAdapter getSimpleRecyclerViewAdapter() {
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.simpleRecyclerViewAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simpleRecyclerViewAdapter");
        }
        return simpleRecyclerAdapter;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        DeepLink deepLink;
        ProcessingResult processingResult;
        ProcessingResult error;
        if (i != 2) {
            if (i == 4) {
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
                PaymentMethodsViewModel paymentMethodsViewModel2 = this.paymentMethodsViewModel;
                if (paymentMethodsViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
                }
                paymentMethodsViewModel2.handleProcessingResult(processingResult);
            } else if (i != 8) {
                if (i != 16) {
                    super.onActivityResult(i, i2, intent);
                } else if (i2 == -1) {
                    if (intent != null) {
                        PaymentMethodsViewModel paymentMethodsViewModel3 = this.paymentMethodsViewModel;
                        if (paymentMethodsViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
                        }
                        paymentMethodsViewModel3.handleGooglePayResponse(intent);
                        return;
                    }
                    throw new IllegalStateException("Payment data cannot be null");
                } else if (i2 != 1) {
                    PaymentMethodsViewModel paymentMethodsViewModel4 = this.paymentMethodsViewModel;
                    if (paymentMethodsViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
                    }
                    paymentMethodsViewModel4.handleGooglePayCanceled();
                } else if (intent != null) {
                    PaymentMethodsViewModel paymentMethodsViewModel5 = this.paymentMethodsViewModel;
                    if (paymentMethodsViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
                    }
                    paymentMethodsViewModel5.handleGooglePayError(intent);
                } else {
                    throw new IllegalStateException("Payment data cannot be null");
                }
            } else if (i2 == -1) {
                String sbolPaymentResult = intent != null ? SberbankOnlineKt.getSbolPaymentResult(intent) : null;
                PaymentMethodsViewModel paymentMethodsViewModel6 = this.paymentMethodsViewModel;
                if (paymentMethodsViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
                }
                paymentMethodsViewModel6.onSberbankOnlineAppResult(SberbankOnlineKt.isSuccess(sbolPaymentResult));
            }
        } else if (intent != null && (deepLink = (DeepLink) intent.getParcelableExtra(PaymentProcessingConstants.EXTRA_FINAL_DEEPLINK)) != null) {
            PaymentMethodsViewModel paymentMethodsViewModel7 = this.paymentMethodsViewModel;
            if (paymentMethodsViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
            }
            paymentMethodsViewModel7.onWebPaymentFinished(deepLink);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        PaymentSessionTypeMarker paymentSessionTypeMarker2;
        Parcelable parcelableExtra = getIntent().getParcelableExtra(PaymentActivityKt.access$getEXTRA_PAYMENT_SESSION_TYPE$p());
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtr…TRA_PAYMENT_SESSION_TYPE)");
        PaymentSessionType paymentSessionType = (PaymentSessionType) parcelableExtra;
        if (paymentSessionType instanceof PaymentSessionType.Services) {
            paymentSessionTypeMarker2 = PaymentSessionTypeMarker.SERVICE;
        } else if (paymentSessionType instanceof PaymentSessionType.LegacyServices) {
            paymentSessionTypeMarker2 = PaymentSessionTypeMarker.LEGACY_SERVICE;
        } else if (paymentSessionType instanceof PaymentSessionType.Wallet) {
            paymentSessionTypeMarker2 = PaymentSessionTypeMarker.WALLET;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.paymentSessionTypeMarker = paymentSessionTypeMarker2;
        DaggerPaymentMethodsComponent.builder().module(PaymentMethodsModule.INSTANCE).dependencies((PaymentLibraryDependencies) ComponentDependenciesKt.getDependencies(PaymentLibraryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).activity(this).paymentSessionType(paymentSessionType).onPaymentMethodClickListener(new arrow.core.Function1<>(new a(this))).build().inject(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_payment);
        View findViewById = findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        SimpleRecyclerAdapter simpleRecyclerAdapter = this.simpleRecyclerViewAdapter;
        if (simpleRecyclerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("simpleRecyclerViewAdapter");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        PaymentMethodsView paymentMethodsView = new PaymentMethodsView(findViewById, adapterPresenter2, simpleRecyclerAdapter, dialogRouter2, new Function1<DeepLink, Unit>(this) { // from class: com.avito.android.payment.lib.PaymentActivity.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(DeepLink deepLink) {
                DeepLink deepLink2 = deepLink;
                Intrinsics.checkNotNullParameter(deepLink2, "p1");
                PaymentActivity.access$onDeepLink((PaymentActivity) this.receiver, deepLink2);
                return Unit.INSTANCE;
            }
        }, new Function1<String, Unit>(this) { // from class: com.avito.android.payment.lib.PaymentActivity.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(String str) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "p1");
                PaymentActivity.access$onUriRedirect((PaymentActivity) this.receiver, str2);
                return Unit.INSTANCE;
            }
        }, new Function1<PaymentResult, Unit>(this) { // from class: com.avito.android.payment.lib.PaymentActivity.d
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(PaymentResult paymentResult) {
                PaymentResult paymentResult2 = paymentResult;
                Intrinsics.checkNotNullParameter(paymentResult2, "p1");
                PaymentActivity.access$onClosePaymentScreen((PaymentActivity) this.receiver, paymentResult2);
                return Unit.INSTANCE;
            }
        });
        PaymentMethodsViewModel paymentMethodsViewModel2 = this.paymentMethodsViewModel;
        if (paymentMethodsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
        }
        paymentMethodsView.bindTo(paymentMethodsViewModel2, this);
        if (bundle == null) {
            PaymentMethodsViewModel paymentMethodsViewModel3 = this.paymentMethodsViewModel;
            if (paymentMethodsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paymentMethodsViewModel");
            }
            paymentMethodsViewModel3.loadPaymentMethods();
        }
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setPaymentMethodsViewModel(@NotNull PaymentMethodsViewModel paymentMethodsViewModel2) {
        Intrinsics.checkNotNullParameter(paymentMethodsViewModel2, "<set-?>");
        this.paymentMethodsViewModel = paymentMethodsViewModel2;
    }

    public final void setPaymentSessionTypeMarker(@NotNull PaymentSessionTypeMarker paymentSessionTypeMarker2) {
        Intrinsics.checkNotNullParameter(paymentSessionTypeMarker2, "<set-?>");
        this.paymentSessionTypeMarker = paymentSessionTypeMarker2;
    }

    public final void setSimpleRecyclerViewAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "<set-?>");
        this.simpleRecyclerViewAdapter = simpleRecyclerAdapter;
    }
}

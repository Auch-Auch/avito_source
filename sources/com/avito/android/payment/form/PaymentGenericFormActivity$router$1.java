package com.avito.android.payment.form;

import android.content.Intent;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.payment.remote.PaymentSessionTypeMarkerKt;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.avito.android.util.Keyboards;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"com/avito/android/payment/form/PaymentGenericFormActivity$router$1", "Lcom/avito/android/payment/form/PaymentGenericFormRouter;", "Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;", "", "leaveScreen", "()V", "", "message", "leaveScreenWithError", "(Ljava/lang/String;)V", "paymentSessionId", "methodSignature", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "onSubmitForm", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "uriString", "onRedirect", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "paymentStatus", "onSuccess", "(Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFormActivity$router$1 implements PaymentGenericFormRouter, PaymentStatusProcessingRouter {
    public final /* synthetic */ PaymentGenericFormActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public PaymentGenericFormActivity$router$1(PaymentGenericFormActivity paymentGenericFormActivity) {
        this.a = paymentGenericFormActivity;
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormRouter
    public void leaveScreen() {
        Keyboards.hideKeyboard(this.a);
        this.a.setResult(0);
        this.a.finish();
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormRouter
    public void leaveScreenWithError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Keyboards.hideKeyboard(this.a);
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT, str);
        this.a.setResult(0, intent);
        this.a.finish();
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingRouter
    public void onRedirect(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uriString");
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_REDIRECT_RESULT, str);
        this.a.setResult(-1, intent);
        this.a.finish();
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormRouter
    public void onSubmitForm(@NotNull String str, @NotNull String str2, @NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(str, "paymentSessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(parametersTree, "parametersTree");
        Intent paymentGenericIntent = this.a.getIntentFactory().paymentGenericIntent(str, str2, parametersTree);
        Serializable serializableExtra = this.a.getIntent().getSerializableExtra(PaymentSessionTypeMarkerKt.EXTRA_PAYMENT_SESSION_TYPE_MARKER);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.payment.remote.PaymentSessionTypeMarker");
        paymentGenericIntent.putExtra(PaymentSessionTypeMarkerKt.EXTRA_PAYMENT_SESSION_TYPE_MARKER, (PaymentSessionTypeMarker) serializableExtra);
        this.a.startActivityForResult(paymentGenericIntent, 4);
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingRouter
    public void onSuccess(@NotNull PaymentStatusResult.PaymentStatus paymentStatus) {
        Intrinsics.checkNotNullParameter(paymentStatus, "paymentStatus");
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_STATUS_RESULT, paymentStatus);
        this.a.setResult(-1, intent);
        this.a.finish();
    }
}

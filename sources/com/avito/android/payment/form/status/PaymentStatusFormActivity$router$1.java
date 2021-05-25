package com.avito.android.payment.form.status;

import android.content.Intent;
import android.net.Uri;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.payment.form.PaymentStatusProcessingRouter;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.payment.remote.PaymentSessionTypeMarkerKt;
import com.avito.android.remote.model.payment.status.PaymentStatusResult;
import com.facebook.share.internal.ShareConstants;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/avito/android/payment/form/status/PaymentStatusFormActivity$router$1", "Lcom/avito/android/payment/form/status/PaymentStatusFormRouter;", "Lcom/avito/android/payment/form/PaymentStatusProcessingRouter;", "", "closeScreen", "()V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "followUri", "(Landroid/net/Uri;)V", "", "uriString", "onRedirect", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;", "paymentStatus", "onSuccess", "(Lcom/avito/android/remote/model/payment/status/PaymentStatusResult$PaymentStatus;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentStatusFormActivity$router$1 implements PaymentStatusFormRouter, PaymentStatusProcessingRouter {
    public final /* synthetic */ PaymentStatusFormActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public PaymentStatusFormActivity$router$1(PaymentStatusFormActivity paymentStatusFormActivity) {
        this.a = paymentStatusFormActivity;
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormRouter
    public void closeScreen() {
        this.a.setResult(0);
        this.a.finish();
    }

    @Override // com.avito.android.payment.form.status.PaymentStatusFormRouter
    public void followUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        DeepLink createFromUri = this.a.getDeepLinkFactory().createFromUri(uri);
        Intent intent = this.a.getDeepLinkIntentFactory().getIntent(createFromUri);
        if (intent == null) {
            Analytics analytics = this.a.getAnalytics();
            analytics.track(new NonFatalError("BILL_1058: crash on wrong deeplink", new IllegalArgumentException("Got null intent with deeplink {" + createFromUri + "} from Uri {" + uri + '}'), null, 4, null));
            return;
        }
        Serializable serializableExtra = this.a.getIntent().getSerializableExtra(PaymentSessionTypeMarkerKt.EXTRA_PAYMENT_SESSION_TYPE_MARKER);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.avito.android.payment.remote.PaymentSessionTypeMarker");
        intent.putExtra(PaymentSessionTypeMarkerKt.EXTRA_PAYMENT_SESSION_TYPE_MARKER, (PaymentSessionTypeMarker) serializableExtra);
        this.a.startActivityForResult(intent, 4);
    }

    @Override // com.avito.android.payment.form.PaymentStatusProcessingRouter
    public void onRedirect(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uriString");
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_REDIRECT_RESULT, str);
        this.a.setResult(-1, intent);
        this.a.finish();
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

package com.avito.android.payment.top_up.form;

import android.content.Intent;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.processing.PaymentProcessingConstants;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.Keyboards;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/avito/android/payment/top_up/form/TopUpFormActivity$router$1", "Lcom/avito/android/payment/top_up/form/TopUpFormRouter;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "submitTopUp", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "", "error", "closeScreenWithError", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormActivity$router$1 implements TopUpFormRouter {
    public final /* synthetic */ TopUpFormActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public TopUpFormActivity$router$1(TopUpFormActivity topUpFormActivity) {
        this.a = topUpFormActivity;
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormRouter
    public void closeScreenWithError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Intent intent = new Intent();
        intent.putExtra(PaymentProcessingConstants.EXTRA_PAYMENT_ERROR_RESULT, str);
        this.a.setResult(0, intent);
        this.a.finish();
    }

    @Override // com.avito.android.payment.top_up.form.TopUpFormRouter
    public void submitTopUp(@NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Keyboards.hideKeyboard(this.a);
        this.a.startActivityForResult(this.a.getIntentFactory().topUpPaymentIntent(parametersTree), 2);
    }
}

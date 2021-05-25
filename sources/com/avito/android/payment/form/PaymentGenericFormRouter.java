package com.avito.android.payment.form;

import com.avito.android.remote.model.category_parameters.ParametersTree;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormRouter;", "", "", "leaveScreen", "()V", "", "message", "leaveScreenWithError", "(Ljava/lang/String;)V", "paymentSessionId", "methodSignature", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "parametersTree", "onSubmitForm", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentGenericFormRouter {
    void leaveScreen();

    void leaveScreenWithError(@NotNull String str);

    void onSubmitForm(@NotNull String str, @NotNull String str2, @NotNull ParametersTree parametersTree);
}

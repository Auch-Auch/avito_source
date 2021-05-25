package com.avito.android.payment.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.form.ScreenState;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;", "", "Lcom/avito/android/payment/form/ContentModel;", "contentModel", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "forceKeyboard", "Lcom/avito/android/payment/form/ScreenState$Content;", "convert", "(Lcom/avito/android/payment/form/ContentModel;Lcom/avito/android/remote/model/category_parameters/ParametersTree;Z)Lcom/avito/android/payment/form/ScreenState$Content;", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentGenericFormItemConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ ScreenState.Content convert$default(PaymentGenericFormItemConverter paymentGenericFormItemConverter, ContentModel contentModel, ParametersTree parametersTree, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                return paymentGenericFormItemConverter.convert(contentModel, parametersTree, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }
    }

    @NotNull
    ScreenState.Content convert(@NotNull ContentModel contentModel, @NotNull ParametersTree parametersTree, boolean z);
}

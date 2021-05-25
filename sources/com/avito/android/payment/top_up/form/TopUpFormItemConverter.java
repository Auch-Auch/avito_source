package com.avito.android.payment.top_up.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.top_up.form.ScreenState;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;", "", "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "form", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "forceInputUpdate", "forceKeyboard", "Lcom/avito/android/payment/top_up/form/ScreenState$Content;", "convert", "(Lcom/avito/android/remote/model/payment/top_up/TopUpForm;Lcom/avito/android/remote/model/category_parameters/ParametersTree;ZZ)Lcom/avito/android/payment/top_up/form/ScreenState$Content;", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface TopUpFormItemConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ ScreenState.Content convert$default(TopUpFormItemConverter topUpFormItemConverter, TopUpForm topUpForm, ParametersTree parametersTree, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                if ((i & 8) != 0) {
                    z2 = false;
                }
                return topUpFormItemConverter.convert(topUpForm, parametersTree, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convert");
        }
    }

    @NotNull
    ScreenState.Content convert(@NotNull TopUpForm topUpForm, @NotNull ParametersTree parametersTree, boolean z, boolean z2);
}

package a2.a.a.t1.b;

import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.payment.form.ContentModel;
import com.avito.android.payment.form.PaymentGenericFormItemConverter;
import com.avito.android.payment.form.PaymentGenericFormPresenterImpl;
import com.avito.android.payment.form.ScreenState;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<PhoneInputItem, ScreenState.Content> {
    public final /* synthetic */ PaymentGenericFormPresenterImpl a;
    public final /* synthetic */ ContentModel b;
    public final /* synthetic */ ParametersTree c;

    public e(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl, ContentModel contentModel, ParametersTree parametersTree) {
        this.a = paymentGenericFormPresenterImpl;
        this.b = contentModel;
        this.c = parametersTree;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState.Content apply(PhoneInputItem phoneInputItem) {
        Intrinsics.checkNotNullParameter(phoneInputItem, "it");
        return PaymentGenericFormItemConverter.DefaultImpls.convert$default(this.a.q, this.b, this.c, false, 4, null);
    }
}

package a2.a.a.t1.b;

import com.avito.android.payment.form.ContentModel;
import com.avito.android.payment.form.PaymentGenericFormItemConverter;
import com.avito.android.payment.form.PaymentGenericFormPresenterImpl;
import com.avito.android.payment.form.ScreenState;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<PretendResult, ScreenState.Content> {
    public final /* synthetic */ PaymentGenericFormPresenterImpl a;
    public final /* synthetic */ ContentModel b;
    public final /* synthetic */ ParametersTree c;

    public g(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl, ContentModel contentModel, ParametersTree parametersTree) {
        this.a = paymentGenericFormPresenterImpl;
        this.b = contentModel;
        this.c = parametersTree;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState.Content apply(PretendResult pretendResult) {
        Intrinsics.checkNotNullParameter(pretendResult, "it");
        return PaymentGenericFormItemConverter.DefaultImpls.convert$default(this.a.q, this.b, this.c, false, 4, null);
    }
}

package a2.a.a.t1.e.a;

import com.avito.android.payment.top_up.form.ScreenState;
import com.avito.android.payment.top_up.form.TopUpFormItemConverter;
import com.avito.android.payment.top_up.form.TopUpFormPresenterImpl;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<PretendResult, ScreenState.Content> {
    public final /* synthetic */ TopUpFormPresenterImpl a;
    public final /* synthetic */ TopUpForm b;
    public final /* synthetic */ ParametersTree c;

    public e(TopUpFormPresenterImpl topUpFormPresenterImpl, TopUpForm topUpForm, ParametersTree parametersTree) {
        this.a = topUpFormPresenterImpl;
        this.b = topUpForm;
        this.c = parametersTree;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ScreenState.Content apply(PretendResult pretendResult) {
        Intrinsics.checkNotNullParameter(pretendResult, "it");
        return TopUpFormItemConverter.DefaultImpls.convert$default(this.a.p, this.b, this.c, false, false, 12, null);
    }
}

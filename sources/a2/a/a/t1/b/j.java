package a2.a.a.t1.b;

import com.avito.android.payment.form.PaymentGenericFormPresenterImpl;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class j<T, R> implements Function<Unit, ObservableSource<? extends PretendResult>> {
    public final /* synthetic */ PaymentGenericFormPresenterImpl a;
    public final /* synthetic */ ParametersTree b;

    public j(PaymentGenericFormPresenterImpl paymentGenericFormPresenterImpl, ParametersTree parametersTree) {
        this.a = paymentGenericFormPresenterImpl;
        this.b = parametersTree;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends PretendResult> apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return this.a.p.validateUserInput(this.b);
    }
}

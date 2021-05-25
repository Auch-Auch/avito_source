package a2.a.a.t1.e.a;

import com.avito.android.payment.top_up.form.TopUpFormPresenterImpl;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<TopUpInputItem, ObservableSource<? extends PretendResult>> {
    public final /* synthetic */ TopUpFormPresenterImpl a;
    public final /* synthetic */ ParametersTree b;

    public h(TopUpFormPresenterImpl topUpFormPresenterImpl, ParametersTree parametersTree) {
        this.a = topUpFormPresenterImpl;
        this.b = parametersTree;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends PretendResult> apply(TopUpInputItem topUpInputItem) {
        Intrinsics.checkNotNullParameter(topUpInputItem, "it");
        return this.a.m.validateUserInput(this.b);
    }
}

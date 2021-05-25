package a2.a.a.t1.b;

import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<PretendResult> {
    public final /* synthetic */ ParametersTree a;

    public f(ParametersTree parametersTree) {
        this.a = parametersTree;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(PretendResult pretendResult) {
        this.a.applyPretendResult(pretendResult.getErrors());
    }
}

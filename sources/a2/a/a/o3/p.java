package a2.a.a.o3;

import com.avito.android.items.RangeItem;
import com.avito.android.validation.ParametersListPresenterImpl;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class p<T, R> implements Function<RangeItem, CompletableSource> {
    public final /* synthetic */ ParametersListPresenterImpl a;

    public p(ParametersListPresenterImpl parametersListPresenterImpl) {
        this.a = parametersListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(RangeItem rangeItem) {
        RangeItem rangeItem2 = rangeItem;
        Intrinsics.checkNotNullParameter(rangeItem2, "it");
        if (this.a.f(rangeItem2)) {
            return ParametersListPresenterImpl.access$validateItemWithDependentEntities(this.a, rangeItem2);
        }
        return ParametersListPresenterImpl.access$replaceItem(this.a, rangeItem2);
    }
}

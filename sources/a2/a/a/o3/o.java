package a2.a.a.o3;

import com.avito.android.items.RangeItem;
import com.avito.android.validation.ParametersListInteractor;
import com.avito.android.validation.ParametersListPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class o<T> implements Consumer<RangeItem> {
    public final /* synthetic */ ParametersListPresenterImpl a;

    public o(ParametersListPresenterImpl parametersListPresenterImpl) {
        this.a = parametersListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(RangeItem rangeItem) {
        RangeItem rangeItem2 = rangeItem;
        ParametersListInteractor parametersListInteractor = this.a.i;
        String stringId = rangeItem2.getStringId();
        Intrinsics.checkNotNullExpressionValue(rangeItem2, "it");
        parametersListInteractor.applyRangeValue(stringId, rangeItem2);
    }
}

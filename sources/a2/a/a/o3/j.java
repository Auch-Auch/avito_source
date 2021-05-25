package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.BackpressureStrategy;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
public final class j<T, R> implements Function<List<? extends Item>, Publisher<? extends Unit>> {
    public final /* synthetic */ ParametersListPresenterImpl a;

    public j(ParametersListPresenterImpl parametersListPresenterImpl) {
        this.a = parametersListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Publisher<? extends Unit> apply(List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return this.a.i.getInitialValidationResults().toFlowable(BackpressureStrategy.DROP).map(new i(this));
    }
}

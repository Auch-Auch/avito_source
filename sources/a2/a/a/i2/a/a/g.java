package a2.a.a.i2.a.a;

import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateInteractorImpl;
import com.avito.android.util.Observables;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class g<T, R> implements Function<List<? extends ParametersTree>, ObservableSource<? extends PretendResult>> {
    public final /* synthetic */ DeliveryCourierOrderUpdateInteractorImpl a;

    public g(DeliveryCourierOrderUpdateInteractorImpl deliveryCourierOrderUpdateInteractorImpl) {
        this.a = deliveryCourierOrderUpdateInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends PretendResult> apply(List<? extends ParametersTree> list) {
        List<? extends ParametersTree> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(InteropKt.toV2(this.a.d.pretend(it.next())));
        }
        return Observables.merge(arrayList);
    }
}

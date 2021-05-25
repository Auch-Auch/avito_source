package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ ParametersListPresenterImpl a;

    public h(ParametersListPresenterImpl parametersListPresenterImpl) {
        this.a = parametersListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        ParametersListPresenterImpl parametersListPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        parametersListPresenterImpl.c = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
    }
}

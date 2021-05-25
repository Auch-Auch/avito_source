package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class g<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ ParametersListPresenterImpl a;

    public g(ParametersListPresenterImpl parametersListPresenterImpl) {
        this.a = parametersListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Item> list) {
        this.a.e.clear();
    }
}

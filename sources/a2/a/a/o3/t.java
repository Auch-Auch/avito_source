package a2.a.a.o3;

import com.avito.android.validation.ParametersListPresenterImpl;
import com.avito.android.validation.ValidationResult;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class t<T> implements Consumer<List<? extends ValidationResult>> {
    public final /* synthetic */ ParametersListPresenterImpl a;
    public final /* synthetic */ Item b;

    public t(ParametersListPresenterImpl parametersListPresenterImpl, Item item) {
        this.a = parametersListPresenterImpl;
        this.b = item;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends ValidationResult> list) {
        ParametersListPresenterImpl.access$commitDataChange(this.a, new s(this, list));
    }
}

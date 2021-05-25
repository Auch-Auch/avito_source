package a2.a.a.n2.w.d.a;

import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterData;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.functions.Function0;
public final class b<T> implements Consumer<VerticalFilterData> {
    public final /* synthetic */ VerticalFilterPresenterImpl a;
    public final /* synthetic */ Function0 b;

    public b(VerticalFilterPresenterImpl verticalFilterPresenterImpl, Function0 function0) {
        this.a = verticalFilterPresenterImpl;
        this.b = function0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(VerticalFilterData verticalFilterData) {
        this.a.g = verticalFilterData;
        this.a.d();
        this.b.invoke();
    }
}

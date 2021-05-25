package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import com.avito.android.util.ActionMenu;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
public final class m<T, R> implements Function<List<? extends ActionMenu>, ObservableSource<? extends Integer>> {
    public final /* synthetic */ MyAdvertDetailsView a;

    public m(MyAdvertDetailsView myAdvertDetailsView) {
        this.a = myAdvertDetailsView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends Integer> apply(List<? extends ActionMenu> list) {
        return this.a.menuClicks();
    }
}

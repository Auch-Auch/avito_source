package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsView;
import com.avito.android.util.ActionMenu;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class k<T> implements Consumer<List<? extends ActionMenu>> {
    public final /* synthetic */ MyAdvertDetailsView a;

    public k(MyAdvertDetailsView myAdvertDetailsView) {
        this.a = myAdvertDetailsView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_advert.advert.MyAdvertDetailsView */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends ActionMenu> list) {
        List<? extends ActionMenu> list2 = list;
        MyAdvertDetailsView myAdvertDetailsView = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        myAdvertDetailsView.setUpToolbar(list2);
    }
}

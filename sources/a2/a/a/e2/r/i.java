package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.view.ItemDetailsView;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<List<Map.Entry<? extends String, ? extends String>>> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public i(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<Map.Entry<? extends String, ? extends String>> list) {
        String str;
        ItemDetailsView itemDetailsView;
        List<Map.Entry<? extends String, ? extends String>> list2 = list;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        for (T t : list2) {
            if (!(t == null || (str = (String) t.getValue()) == null || (itemDetailsView = this.a.c) == null)) {
                itemDetailsView.showError(str);
            }
        }
    }
}

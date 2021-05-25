package a2.a.a.h3.a;

import com.avito.android.remote.model.Action;
import com.avito.android.user_advert.advert.MyAdvertDetailsActionMenuConverter;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.util.ActionMenu;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class j<T, R> implements Function<List<? extends Action>, List<? extends ActionMenu>> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ boolean b;

    public j(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, boolean z) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.user_advert.advert.MyAdvertDetailsActionMenuConverter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends ActionMenu> apply(List<? extends Action> list) {
        List<? extends Action> list2 = list;
        MyAdvertDetailsActionMenuConverter myAdvertDetailsActionMenuConverter = this.a.v;
        boolean z = this.b;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        return myAdvertDetailsActionMenuConverter.convert(z, list2);
    }
}

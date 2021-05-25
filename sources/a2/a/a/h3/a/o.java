package a2.a.a.h3.a;

import com.avito.android.remote.model.Action;
import com.avito.android.user_advert.advert.MyAdvertDetailsItem;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.reactivestreams.Publisher;
public final class o<T, R> implements Function<Integer, Publisher<? extends Unit>> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ MyAdvertDetailsItem c;
    public final /* synthetic */ List d;

    public o(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, boolean z, MyAdvertDetailsItem myAdvertDetailsItem, List list) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = z;
        this.c = myAdvertDetailsItem;
        this.d = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Publisher<? extends Unit> apply(Integer num) {
        Integer num2 = num;
        if (num2 != null && num2.intValue() == 0 && this.b) {
            return Flowable.fromCallable(new n(this));
        }
        List list = this.d;
        MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(num2, VKApiConst.POSITION);
        return MyAdvertDetailsPresenterImpl.f(this.a, ((Action) list.get(MyAdvertDetailsPresenterImpl.access$getSelectedActionPosition(myAdvertDetailsPresenterImpl, num2.intValue(), this.b))).getDeepLink(), false, 2);
    }
}

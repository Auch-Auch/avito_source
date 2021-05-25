package a2.a.a.t3;

import com.avito.android.remote.model.ViewedItemsCountResponse;
import io.reactivex.rxjava3.functions.Function;
public final class a<T, R> implements Function<ViewedItemsCountResponse, Integer> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Integer apply(ViewedItemsCountResponse viewedItemsCountResponse) {
        return Integer.valueOf(viewedItemsCountResponse.getCounter());
    }
}

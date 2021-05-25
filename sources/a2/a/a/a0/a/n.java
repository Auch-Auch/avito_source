package a2.a.a.a0.a;

import com.avito.android.remote.cart.model.DeleteItemResponse;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
public final class n<T, R> implements Function<DeleteItemResponse, Pair<? extends String, ? extends DeleteItemResponse>> {
    public final /* synthetic */ String a;

    public n(String str) {
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Pair<? extends String, ? extends DeleteItemResponse> apply(DeleteItemResponse deleteItemResponse) {
        return TuplesKt.to(this.a, deleteItemResponse);
    }
}

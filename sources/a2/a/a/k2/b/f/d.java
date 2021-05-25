package a2.a.a.k2.b.f;

import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.search.map.interactor.SerpKey;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
public final class d<T, R> implements Function<SerpElementResult, Pair<? extends SerpKey, ? extends SerpElementResult>> {
    public final /* synthetic */ SerpKey a;

    public d(SerpKey serpKey) {
        this.a = serpKey;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Pair<? extends SerpKey, ? extends SerpElementResult> apply(SerpElementResult serpElementResult) {
        return TuplesKt.to(this.a, serpElementResult);
    }
}

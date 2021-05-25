package a2.a.a.n1;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import io.reactivex.rxjava3.functions.Function;
public final class l0<T, R> implements Function<Long, AvitoMapBounds> {
    public static final l0 a = new l0();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public AvitoMapBounds apply(Long l) {
        double d = (double) 0;
        return new AvitoMapBounds(new AvitoMapPoint(d, d), new AvitoMapPoint(d, d));
    }
}

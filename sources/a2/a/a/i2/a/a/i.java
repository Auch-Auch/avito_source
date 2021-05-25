package a2.a.a.i2.a.a;

import com.avito.android.remote.error.ErrorResult;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<Map<String, ? extends String>, ObservableSource<? extends LoadingState<? super Map<String, ? extends String>>>> {
    public static final i a = new i();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends LoadingState<? super Map<String, ? extends String>>> apply(Map<String, ? extends String> map) {
        Map<String, ? extends String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "it");
        if (map2.isEmpty()) {
            return Observable.empty();
        }
        return Observable.just(new LoadingState.Error(new ErrorResult.IncorrectData(map2)));
    }
}

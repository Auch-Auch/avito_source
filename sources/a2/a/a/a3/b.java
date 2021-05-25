package a2.a.a.a3;

import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.util.LoadingState;
import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class b<T, R> implements Function<PowerWebViewStateChangeEvent, LoadingState<? super Unit>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super Unit> apply(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
        PowerWebViewStateChangeEvent powerWebViewStateChangeEvent2 = powerWebViewStateChangeEvent;
        int ordinal = powerWebViewStateChangeEvent2.getState().ordinal();
        if (ordinal == 1) {
            return new LoadingState.Loaded(Unit.INSTANCE);
        }
        if (ordinal == 3) {
            String description = powerWebViewStateChangeEvent2.getDescription();
            if (description == null) {
                description = "";
            }
            return new LoadingState.Error(new ErrorWithMessage.NetworkError(description));
        }
        throw new IllegalStateException();
    }
}

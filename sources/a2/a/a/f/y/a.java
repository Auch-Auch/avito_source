package a2.a.a.f.y;

import com.avito.android.advert.notes.UpdateAdvertNoteResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class a<T, R> implements Function<Unit, LoadingState<? super UpdateAdvertNoteResult>> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super UpdateAdvertNoteResult> apply(Unit unit) {
        return new LoadingState.Loaded(UpdateAdvertNoteResult.CREATED);
    }
}

package a2.a.a.f.y;

import com.avito.android.advert.notes.UpdateAdvertNoteResult;
import com.avito.android.remote.model.UpdateAdvertNoteResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
public final class c<T, R> implements Function<UpdateAdvertNoteResponse, LoadingState<? super UpdateAdvertNoteResult>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super UpdateAdvertNoteResult> apply(UpdateAdvertNoteResponse updateAdvertNoteResponse) {
        if (updateAdvertNoteResponse.isDeleted()) {
            return new LoadingState.Loaded(UpdateAdvertNoteResult.DELETED);
        }
        return new LoadingState.Loaded(UpdateAdvertNoteResult.UPDATED);
    }
}

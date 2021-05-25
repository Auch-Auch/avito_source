package a2.a.a.f.y;

import com.avito.android.advert.notes.EditAdvertNoteInteractorImpl;
import com.avito.android.advert.notes.UpdateAdvertNoteResult;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, LoadingState<? super UpdateAdvertNoteResult>> {
    public final /* synthetic */ EditAdvertNoteInteractorImpl a;

    public d(EditAdvertNoteInteractorImpl editAdvertNoteInteractorImpl) {
        this.a = editAdvertNoteInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super UpdateAdvertNoteResult> apply(Throwable th) {
        Throwable th2 = th;
        TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.c;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
    }
}

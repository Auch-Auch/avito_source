package a2.a.a.e2.t;

import com.avito.android.publish.drafts.PublishDraftRepositoryImpl;
import com.avito.android.publish.drafts.PublishInfoMessage;
import com.avito.android.publish.drafts.PublishInfoMessageKt;
import com.avito.android.remote.model.SaveDraftResponse;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<TypedResult<SaveDraftResponse>, MaybeSource<? extends PublishInfoMessage>> {
    public final /* synthetic */ PublishDraftRepositoryImpl.e a;

    public a(PublishDraftRepositoryImpl.e eVar) {
        this.a = eVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MaybeSource<? extends PublishInfoMessage> apply(TypedResult<SaveDraftResponse> typedResult) {
        TypedResult<SaveDraftResponse> typedResult2 = typedResult;
        Intrinsics.checkNotNullParameter(typedResult2, "it");
        if (typedResult2 instanceof TypedResult.OfResult) {
            return Maybe.just(PublishInfoMessageKt.getInfoMessage((SaveDraftResponse) ((TypedResult.OfResult) typedResult2).getResult()));
        }
        this.a.a.g.enqueue();
        return Maybe.empty();
    }
}

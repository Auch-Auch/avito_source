package a2.a.a.i3.a;

import com.avito.android.remote.model.CountResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<TypedResult<CountResult>> {
    public final /* synthetic */ UserAdvertsInfoInteractorImpl a;

    public a(UserAdvertsInfoInteractorImpl userAdvertsInfoInteractorImpl) {
        this.a = userAdvertsInfoInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(TypedResult<CountResult> typedResult) {
        TypedResult<CountResult> typedResult2 = typedResult;
        UserAdvertsInfoInteractorImpl userAdvertsInfoInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
        UserAdvertsInfoInteractorImpl.access$handleResult(userAdvertsInfoInteractorImpl, typedResult2);
    }
}

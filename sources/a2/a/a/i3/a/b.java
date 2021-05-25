package a2.a.a.i3.a;

import com.avito.android.user_adverts.expired_count.UserAdvertsInfoInteractorImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ UserAdvertsInfoInteractorImpl a;

    public b(UserAdvertsInfoInteractorImpl userAdvertsInfoInteractorImpl) {
        this.a = userAdvertsInfoInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        UserAdvertsInfoInteractorImpl userAdvertsInfoInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        UserAdvertsInfoInteractorImpl.access$handleFailure(userAdvertsInfoInteractorImpl, th2);
    }
}

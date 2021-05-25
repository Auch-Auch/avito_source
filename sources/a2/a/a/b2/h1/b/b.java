package a2.a.a.b2.h1.b;

import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenterImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<LoadingState<? super Unit>> {
    public final /* synthetic */ SessionsSocialLogoutPresenterImpl a;

    public b(SessionsSocialLogoutPresenterImpl sessionsSocialLogoutPresenterImpl) {
        this.a = sessionsSocialLogoutPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Unit> loadingState) {
        LoadingState<? super Unit> loadingState2 = loadingState;
        SessionsSocialLogoutPresenterImpl sessionsSocialLogoutPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        SessionsSocialLogoutPresenterImpl.access$handleLoadingResult(sessionsSocialLogoutPresenterImpl, loadingState2);
    }
}

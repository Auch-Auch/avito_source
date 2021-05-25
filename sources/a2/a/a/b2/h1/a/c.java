package a2.a.a.b2.h1.a;

import com.avito.android.deep_linking.links.SessionDeleteLink;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.profile.sessions.list.SessionsListPresenterImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<LoadingState<? super Unit>> {
    public final /* synthetic */ SessionsListPresenterImpl a;
    public final /* synthetic */ SessionDeleteLink b;
    public final /* synthetic */ SessionItem c;

    public c(SessionsListPresenterImpl sessionsListPresenterImpl, SessionDeleteLink sessionDeleteLink, SessionItem sessionItem) {
        this.a = sessionsListPresenterImpl;
        this.b = sessionDeleteLink;
        this.c = sessionItem;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Unit> loadingState) {
        LoadingState<? super Unit> loadingState2 = loadingState;
        SessionsListPresenterImpl sessionsListPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        SessionsListPresenterImpl.access$handleDeleteSessionResult(sessionsListPresenterImpl, loadingState2, this.b, this.c);
    }
}

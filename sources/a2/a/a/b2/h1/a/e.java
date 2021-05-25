package a2.a.a.b2.h1.a;

import com.avito.android.profile.sessions.adapter.SessionsListItem;
import com.avito.android.profile.sessions.list.SessionsListPresenterImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Consumer<LoadingState<? super List<? extends SessionsListItem>>> {
    public final /* synthetic */ SessionsListPresenterImpl a;
    public final /* synthetic */ long b;

    public e(SessionsListPresenterImpl sessionsListPresenterImpl, long j) {
        this.a = sessionsListPresenterImpl;
        this.b = j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super List<? extends SessionsListItem>> loadingState) {
        LoadingState<? super List<? extends SessionsListItem>> loadingState2 = loadingState;
        SessionsListPresenterImpl sessionsListPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "items");
        SessionsListPresenterImpl.access$onNextPageLoaded(sessionsListPresenterImpl, loadingState2, this.b);
    }
}

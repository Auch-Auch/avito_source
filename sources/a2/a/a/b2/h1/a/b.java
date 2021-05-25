package a2.a.a.b2.h1.a;

import com.avito.android.deep_linking.links.SessionDeleteLink;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import com.avito.android.profile.sessions.list.SessionsListPresenterImpl;
import com.avito.android.profile.sessions.list.SessionsListView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Disposable> {
    public final /* synthetic */ SessionsListPresenterImpl a;
    public final /* synthetic */ SessionDeleteLink b;

    public b(SessionsListPresenterImpl sessionsListPresenterImpl, SessionDeleteLink sessionDeleteLink) {
        this.a = sessionsListPresenterImpl;
        this.b = sessionDeleteLink;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        SessionsListView sessionsListView = this.a.a;
        if (sessionsListView != null) {
            sessionsListView.showLogoutInProgress(true);
        }
        SessionItem.Action action = this.a.b(this.b);
        if (action != null) {
            action.setLoading(true);
        }
    }
}

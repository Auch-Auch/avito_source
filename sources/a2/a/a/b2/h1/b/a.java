package a2.a.a.b2.h1.b;

import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutPresenterImpl;
import com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutView;
import io.reactivex.rxjava3.functions.Action;
public final class a implements Action {
    public final /* synthetic */ SessionsSocialLogoutPresenterImpl a;

    public a(SessionsSocialLogoutPresenterImpl sessionsSocialLogoutPresenterImpl) {
        this.a = sessionsSocialLogoutPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        SessionsSocialLogoutView sessionsSocialLogoutView = this.a.a;
        if (sessionsSocialLogoutView != null) {
            sessionsSocialLogoutView.hideButtonProgress();
        }
    }
}

package a2.a.a.m3;

import com.avito.android.user_subscribers.UserSubscribersPresenterImpl;
import io.reactivex.functions.Action;
public final class a implements Action {
    public final /* synthetic */ UserSubscribersPresenterImpl a;

    public a(UserSubscribersPresenterImpl userSubscribersPresenterImpl) {
        this.a = userSubscribersPresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.a.f = null;
    }
}

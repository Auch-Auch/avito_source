package a2.a.a.d2.c;

import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class j extends Lambda implements Function0<Unit> {
    public final /* synthetic */ SubscriptionsPresenterImpl a;
    public final /* synthetic */ ErrorResult.ErrorDialog b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(SubscriptionsPresenterImpl subscriptionsPresenterImpl, ErrorResult.ErrorDialog errorDialog) {
        super(0);
        this.a = subscriptionsPresenterImpl;
        this.b = errorDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Action action;
        SubscriptionsPresenter.Router router;
        List<Action> actions = this.b.getUserDialog().getActions();
        if (!(actions == null || (action = actions.get(0)) == null || (router = this.a.d) == null)) {
            router.followDeepLinkFromSubscriptions(action.getDeepLink());
        }
        return Unit.INSTANCE;
    }
}

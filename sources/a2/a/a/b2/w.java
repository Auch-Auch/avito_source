package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import io.reactivex.functions.Consumer;
public final class w<T> implements Consumer<CardItem.HelpCenterCardItem> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public w(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CardItem.HelpCenterCardItem helpCenterCardItem) {
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            UserProfilePresenter.Router.DefaultImpls.openHelpCenter$default(router, null, 1, null);
        }
    }
}

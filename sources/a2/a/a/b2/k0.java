package a2.a.a.b2;

import com.avito.android.analytics.event.AddPhoneClickedEvent;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import io.reactivex.functions.Consumer;
public final class k0<T> implements Consumer<CardItem.PhonesEmptyCardItem> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public k0(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CardItem.PhonesEmptyCardItem phonesEmptyCardItem) {
        this.a.M.track(new AddPhoneClickedEvent());
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            router.openAddPhone();
        }
    }
}

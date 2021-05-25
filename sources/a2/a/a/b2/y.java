package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import io.reactivex.functions.Consumer;
public final class y<T> implements Consumer<CardItem.IncomeSettingsCardItem> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public y(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CardItem.IncomeSettingsCardItem incomeSettingsCardItem) {
        CardItem.IncomeSettingsCardItem incomeSettingsCardItem2 = incomeSettingsCardItem;
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            router.followDeepLink(incomeSettingsCardItem2.getUri());
        }
    }
}

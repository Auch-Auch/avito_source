package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import io.reactivex.functions.Consumer;
public final class w0<T> implements Consumer<CardItem.TfaSettingsCardItem> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public w0(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CardItem.TfaSettingsCardItem tfaSettingsCardItem) {
        CardItem.TfaSettingsCardItem tfaSettingsCardItem2 = tfaSettingsCardItem;
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            router.openTfaSettings(tfaSettingsCardItem2.isEnabled(), tfaSettingsCardItem2.getWarning());
        }
    }
}

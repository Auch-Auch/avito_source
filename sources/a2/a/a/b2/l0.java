package a2.a.a.b2;

import com.avito.android.analytics.event.PhoneActionClickedEvent;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenterOld;
import io.reactivex.functions.Consumer;
public final class l0<T> implements Consumer<PhonesCardItemPresenterOld.Action> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public l0(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(PhonesCardItemPresenterOld.Action action) {
        PhonesCardItemPresenterOld.Action action2 = action;
        this.a.M.track(new PhoneActionClickedEvent(action2.getPhone(), action2.getAction()));
        int action3 = action2.getAction();
        if (action3 == 0) {
            UserProfilePresenterImpl.access$removePhone(this.a, action2.getPhone());
        } else if (action3 == 1) {
            UserProfilePresenterImpl.access$verifyPhone(this.a, action2.getPhone());
        } else if (action3 == 2) {
            UserProfilePresenterImpl.access$setPhoneForAllAdverts(this.a, action2.getPhone());
        }
    }
}

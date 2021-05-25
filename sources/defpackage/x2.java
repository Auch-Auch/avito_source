package defpackage;

import com.avito.android.analytics.event.AddPhoneClickedEvent;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: x2  reason: default package */
public final class x2<T> implements Consumer<CardItem.PhonesCardItem> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public x2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(CardItem.PhonesCardItem phonesCardItem) {
        int i = this.a;
        if (i == 0) {
            UserProfilePresenter.Router router = ((UserProfilePresenterImpl) this.b).b;
            if (router != null) {
                router.openPhonesList();
            }
        } else if (i == 1) {
            ((UserProfilePresenterImpl) this.b).M.track(new AddPhoneClickedEvent());
            UserProfilePresenter.Router router2 = ((UserProfilePresenterImpl) this.b).b;
            if (router2 != null) {
                router2.openAttachPhone();
            }
        } else {
            throw null;
        }
    }
}

package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class m<T> implements Consumer<Unit> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public m(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        UserProfilePresenterImpl.access$onPhoneSetForAll(this.a);
    }
}

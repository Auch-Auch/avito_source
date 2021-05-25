package a2.a.a.i3.c.a;

import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class f<T> implements Consumer<Unit> {
    public final /* synthetic */ UserAdvertsHostFragment a;

    public f(UserAdvertsHostFragment userAdvertsHostFragment) {
        this.a = userAdvertsHostFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        UserAdvertsHostFragment.access$getHeaderViewModel$p(this.a).onSoaUpdateAnimationFinished();
    }
}

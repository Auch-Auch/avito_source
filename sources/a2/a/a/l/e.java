package a2.a.a.l;

import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
import ru.avito.component.serp.PhoneLoadingState;
public final class e<T> implements Consumer<Unit> {
    public final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        AsyncPhonePresenterImpl.access$updateState(this.a.a.a, PhoneLoadingState.BLOCKED);
    }
}

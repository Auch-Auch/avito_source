package a2.a.a.e2.d0.d;

import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Pair;
public final class n<T> implements Consumer<Pair<? extends String, ? extends Object>> {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;

    public n(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper) {
        this.a = anonymousNumberSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Pair<? extends String, ? extends Object> pair) {
        if (this.a.c.contains((String) pair.component1())) {
            AnonymousNumberSlotWrapper.a(this.a, null, 1);
        }
    }
}

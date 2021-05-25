package a2.a.a.e2.d0.d;

import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;

    public e(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper) {
        this.a = anonymousNumberSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.p.trackAnonymousNumberSlotLoadError();
        Logs.error("Failed to initialize anonymous number slot", th);
    }
}

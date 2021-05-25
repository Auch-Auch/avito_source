package a2.a.a.f.x.t.j;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ String a;

    public e(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Logs.error(this.a, th);
    }
}

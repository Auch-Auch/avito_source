package a2.a.a.o1.d.a0.f;

import io.reactivex.rxjava3.functions.Consumer;
import java.io.File;
public final class i<T> implements Consumer<Throwable> {
    public final /* synthetic */ File a;

    public i(File file) {
        this.a = file;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.delete();
    }
}

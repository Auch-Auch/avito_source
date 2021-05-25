package a2.a.a.o1.d.a0.n;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class j<T> implements Consumer<Disposable> {
    public final /* synthetic */ String a;

    public j(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        StringBuilder sb = new StringBuilder();
        a.f1("Thread.currentThread()", a.I('['), ']', sb, " Subscribed to ChatEvent stream (");
        Logs.verbose$default("MessageSyncAgent", a.s(sb, this.a, ')'), null, 4, null);
    }
}

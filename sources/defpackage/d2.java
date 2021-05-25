package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: d2  reason: default package */
public final class d2<T> implements Consumer<Throwable> {
    public static final d2 b = new d2(0);
    public static final d2 c = new d2(1);
    public static final d2 d = new d2(2);
    public final /* synthetic */ int a;

    public d2(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to handle vas action clicks", th);
        } else if (i == 1) {
            Logs.error("Failed to handle primary action clicks", th);
        } else if (i == 2) {
            Logs.error("Failed to handle secondary action clicks", th);
        } else {
            throw null;
        }
    }
}

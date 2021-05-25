package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: t2  reason: default package */
public final class t2<T> implements Consumer<Throwable> {
    public static final t2 b = new t2(0);
    public static final t2 c = new t2(1);
    public final /* synthetic */ int a;

    public t2(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to observe parametersValueChanges", th);
        } else if (i == 1) {
            Logs.error("Failed to observe parametersValueChanges for PhoneParameter", th);
        } else {
            throw null;
        }
    }
}

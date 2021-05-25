package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: q2  reason: default package */
public final class q2<T> implements Consumer<Throwable> {
    public static final q2 b = new q2(0);
    public static final q2 c = new q2(1);
    public final /* synthetic */ int a;

    public q2(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("HomePresenter", "Error locationNotificationClickObservable", th);
        } else if (i == 1) {
            Logs.error("HomePresenter", "Error locationNotificationVisibilityObservable", th);
        } else {
            throw null;
        }
    }
}

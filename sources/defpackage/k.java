package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: k  reason: default package */
public final class k<T> implements Consumer<Throwable> {
    public static final k b = new k(0);
    public static final k c = new k(1);
    public static final k d = new k(2);
    public static final k e = new k(3);
    public final /* synthetic */ int a;

    public k(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to observe phonesCardManageStream", th);
        } else if (i == 1) {
            Logs.error("Failed to observe phonesEmptyCardStream", th);
        } else if (i == 2) {
            Logs.error("Failed to observe phonesCardItemStream", th);
        } else if (i == 3) {
            Logs.error("Failed to observe phonesCardActionsStream", th);
        } else {
            throw null;
        }
    }
}

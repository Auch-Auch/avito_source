package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: m0  reason: default package */
public final class m0<T> implements Consumer<Throwable> {
    public static final m0 b = new m0(0);
    public static final m0 c = new m0(1);
    public final /* synthetic */ int a;

    public m0(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed on publishViewModel.parametersValueChanges for TextParameter", th);
        } else if (i == 1) {
            Logs.error("Failed on publishViewModel.parametersValueChanges for not TextParameter", th);
        } else {
            throw null;
        }
    }
}

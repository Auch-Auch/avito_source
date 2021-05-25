package defpackage;

import com.avito.android.lib.expected.stepper.Stepper;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: m3  reason: default package */
public final class m3<T> implements Predicate<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public m3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public final boolean test(Unit unit) {
        int i = this.a;
        if (i == 0) {
            return !((Boolean) ((Stepper) this.b).y.invoke()).booleanValue();
        }
        if (i == 1) {
            return !((Boolean) ((Stepper) this.b).z.invoke()).booleanValue();
        }
        throw null;
    }
}

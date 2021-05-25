package defpackage;

import com.avito.android.lib.expected.stepper.Stepper;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: v2  reason: default package */
public final class v2<T> implements Consumer<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public v2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Unit unit) {
        int i = this.a;
        if (i == 0) {
            Stepper stepper = (Stepper) this.b;
            stepper.setValue(stepper.getValue() - 1);
        } else if (i == 1) {
            Stepper stepper2 = (Stepper) this.b;
            stepper2.setValue(stepper2.getValue() + 1);
        } else if (i == 2) {
            ((Stepper) this.b).x.invoke();
        } else {
            throw null;
        }
    }
}

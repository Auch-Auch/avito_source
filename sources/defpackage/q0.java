package defpackage;

import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.TextParameter;
import io.reactivex.rxjava3.functions.Predicate;
/* compiled from: java-style lambda group */
/* renamed from: q0  reason: default package */
public final class q0<T> implements Predicate<EditableParameter<?>> {
    public static final q0 b = new q0(0);
    public static final q0 c = new q0(1);
    public final /* synthetic */ int a;

    public q0(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public final boolean test(EditableParameter<?> editableParameter) {
        int i = this.a;
        if (i == 0) {
            return editableParameter instanceof TextParameter;
        }
        if (i == 1) {
            return !(editableParameter instanceof TextParameter);
        }
        throw null;
    }
}

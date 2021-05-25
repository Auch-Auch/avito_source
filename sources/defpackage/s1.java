package defpackage;

import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.TextParameter;
import io.reactivex.rxjava3.functions.Predicate;
/* compiled from: java-style lambda group */
/* renamed from: s1  reason: default package */
public final class s1<T> implements Predicate<EditableParameter<?>> {
    public static final s1 b = new s1(0);
    public static final s1 c = new s1(1);
    public final /* synthetic */ int a;

    public s1(int i) {
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

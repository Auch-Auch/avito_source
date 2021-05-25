package a2.a.a.e2.d0.d;

import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import io.reactivex.rxjava3.functions.Predicate;
public final class k<T> implements Predicate<EditableParameter<?>> {
    public static final k a = new k();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(EditableParameter<?> editableParameter) {
        return !(editableParameter instanceof PhoneParameter);
    }
}

package a2.a.a.e2.d0.d;

import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import io.reactivex.rxjava3.functions.Predicate;
public final class g<T> implements Predicate<EditableParameter<?>> {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;

    public g(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper) {
        this.a = anonymousNumberSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(EditableParameter<?> editableParameter) {
        EditableParameter<?> editableParameter2 = editableParameter;
        return (editableParameter2 instanceof PhoneParameter) && this.a.c.contains(editableParameter2.getId());
    }
}

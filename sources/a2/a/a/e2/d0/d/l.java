package a2.a.a.e2.d0.d;

import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
public final class l<T, R> implements Function<EditableParameter<?>, Pair<? extends String, ? extends Object>> {
    public static final l a = new l();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Pair<? extends String, ? extends Object> apply(EditableParameter<?> editableParameter) {
        EditableParameter<?> editableParameter2 = editableParameter;
        return TuplesKt.to(editableParameter2.getId(), editableParameter2.getValue());
    }
}

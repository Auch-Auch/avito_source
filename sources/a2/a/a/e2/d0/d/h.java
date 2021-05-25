package a2.a.a.e2.d0.d;

import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Pair;
import kotlin.TuplesKt;
public final class h<T, R> implements Function<EditableParameter<?>, Pair<? extends String, ? extends String>> {
    public static final h a = new h();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Pair<? extends String, ? extends String> apply(EditableParameter<?> editableParameter) {
        EditableParameter<?> editableParameter2 = editableParameter;
        Objects.requireNonNull(editableParameter2, "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.PhoneParameter");
        PhoneParameter phoneParameter = (PhoneParameter) editableParameter2;
        return TuplesKt.to(phoneParameter.getId(), phoneParameter.getValue());
    }
}

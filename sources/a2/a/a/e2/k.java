package a2.a.a.e2;

import com.avito.android.publish.PublishViewModel;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class k<T, R> implements Function<EditableParameter<?>, String> {
    public final /* synthetic */ PublishViewModel a;

    public k(PublishViewModel publishViewModel) {
        this.a = publishViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public String apply(EditableParameter<?> editableParameter) {
        EditableParameter<?> editableParameter2 = editableParameter;
        Intrinsics.checkNotNullParameter(editableParameter2, "it");
        return PublishViewModel.access$getParameterId(this.a, editableParameter2);
    }
}

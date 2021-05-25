package a2.a.a.e2;

import com.avito.android.publish.PublishViewModel;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
public final class m<T> implements Consumer<EditableParameter<?>> {
    public final /* synthetic */ PublishViewModel a;

    public m(PublishViewModel publishViewModel) {
        this.a = publishViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(EditableParameter<?> editableParameter) {
        EditableParameter<?> editableParameter2 = editableParameter;
        Set<String> changedFieldIds = this.a.getState().getChangedFieldIds();
        PublishViewModel publishViewModel = this.a;
        Intrinsics.checkNotNullExpressionValue(editableParameter2, "it");
        changedFieldIds.add(PublishViewModel.access$getParameterId(publishViewModel, editableParameter2));
    }
}

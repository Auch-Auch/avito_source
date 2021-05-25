package a2.a.a.e2.d0;

import com.avito.android.publish.slots.AutoPublishSlotWrapper;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<EditableParameter<?>, Unit> {
    public final /* synthetic */ AutoPublishSlotWrapper a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(AutoPublishSlotWrapper autoPublishSlotWrapper) {
        super(1);
        this.a = autoPublishSlotWrapper;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(EditableParameter<?> editableParameter) {
        EditableParameter<?> editableParameter2 = editableParameter;
        Intrinsics.checkNotNullParameter(editableParameter2, "parameter");
        if (this.a.b.contains(editableParameter2.getId())) {
            this.a.a();
        }
        return Unit.INSTANCE;
    }
}

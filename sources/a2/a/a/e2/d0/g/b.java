package a2.a.a.e2.d0.g;

import com.avito.android.publish.slots.parameters_suggest.ParametersSuggestByAddressSlotWrapper;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.slot.parameters_suggest.ParametersSuggestByAddressSlotConfig;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<EditableParameter<?>> {
    public final /* synthetic */ ParametersSuggestByAddressSlotWrapper a;

    public b(ParametersSuggestByAddressSlotWrapper parametersSuggestByAddressSlotWrapper) {
        this.a = parametersSuggestByAddressSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(EditableParameter<?> editableParameter) {
        if (Intrinsics.areEqual(editableParameter.getId(), ((ParametersSuggestByAddressSlotConfig) this.a.getSlot().getWidget().getConfig()).getAddressFieldId())) {
            ParametersSuggestByAddressSlotWrapper.access$performSuggestRequest(this.a);
        }
    }
}

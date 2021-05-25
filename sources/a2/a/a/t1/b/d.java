package a2.a.a.t1.b;

import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<PhoneInputItem> {
    public final /* synthetic */ ParametersTree a;

    public d(ParametersTree parametersTree) {
        this.a = parametersTree;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.avito.android.remote.model.category_parameters.base.EditableParameter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(PhoneInputItem phoneInputItem) {
        PhoneInputItem phoneInputItem2 = phoneInputItem;
        ParameterSlot findParameter = this.a.findParameter(phoneInputItem2.getStringId());
        if (findParameter != null && (findParameter instanceof PhoneParameter)) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            String value = phoneInputItem2.getValue();
            if (!Intrinsics.areEqual(editableParameter.getValue(), value)) {
                editableParameter.setValue(value);
                editableParameter.setError(null);
            }
            ((PhoneParameter) findParameter).setError(null);
        }
    }
}

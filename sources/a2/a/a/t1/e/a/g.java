package a2.a.a.t1.e.a;

import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<TopUpInputItem> {
    public final /* synthetic */ ParametersTree a;

    public g(ParametersTree parametersTree) {
        this.a = parametersTree;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.remote.model.category_parameters.base.EditableParameter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(TopUpInputItem topUpInputItem) {
        TopUpInputItem topUpInputItem2 = topUpInputItem;
        ParameterSlot findParameter = this.a.findParameter(topUpInputItem2.getStringId());
        if (findParameter != null && (findParameter instanceof IntParameter)) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            Long valueOf = Long.valueOf(Long.parseLong(topUpInputItem2.getValue()));
            if (!Intrinsics.areEqual(editableParameter.getValue(), valueOf)) {
                editableParameter.setValue(valueOf);
                editableParameter.setError(null);
            }
        }
    }
}

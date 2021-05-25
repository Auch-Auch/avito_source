package a2.a.a.t1.e.a;

import com.avito.android.payment.top_up.form.items.bubble.BubbleItem;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<BubbleItem> {
    public final /* synthetic */ ParametersTree a;

    public b(ParametersTree parametersTree) {
        this.a = parametersTree;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.remote.model.category_parameters.base.EditableParameter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(BubbleItem bubbleItem) {
        BubbleItem bubbleItem2 = bubbleItem;
        ParameterSlot findParameter = this.a.findParameter(bubbleItem2.getStringId());
        if (findParameter != null && (findParameter instanceof IntParameter)) {
            EditableParameter editableParameter = (EditableParameter) findParameter;
            Long valueOf = Long.valueOf(Long.parseLong(bubbleItem2.getRawValue()));
            if (!Intrinsics.areEqual(editableParameter.getValue(), valueOf)) {
                editableParameter.setValue(valueOf);
                editableParameter.setError(null);
            }
        }
    }
}

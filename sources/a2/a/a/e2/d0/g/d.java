package a2.a.a.e2.d0.g;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.parameters_suggest.ParametersSuggestByAddressSlotWrapper;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<TypedResult<CategoryParameters>> {
    public final /* synthetic */ ParametersSuggestByAddressSlotWrapper a;

    public d(ParametersSuggestByAddressSlotWrapper parametersSuggestByAddressSlotWrapper) {
        this.a = parametersSuggestByAddressSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.jakewharton.rxrelay2.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TypedResult<CategoryParameters> typedResult) {
        TypedResult<CategoryParameters> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            CategoryParameters categoryParameters = this.a.f.getCategoryParameters();
            if (categoryParameters != null) {
                TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
                CategoryParameters cloneWithNewParameters = categoryParameters.cloneWithNewParameters(((CategoryParameters) ofResult.getResult()).getParameters(), ((CategoryParameters) ofResult.getResult()).getChangedIds());
                if (cloneWithNewParameters != null) {
                    this.a.f.setCategoryParametersAndInitSteps(cloneWithNewParameters);
                }
            }
            this.a.b.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.PARAMETERS_SUGGEST_BY_ADDRESS));
        } else if (typedResult2 instanceof TypedResult.OfError) {
            Logs.error$default(((TypedResult.OfError) typedResult2).getError().getMessage(), null, 2, null);
        }
    }
}

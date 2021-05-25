package a2.a.a.e2.d0.f;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.market_price.MarketPriceSlotWrapper;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import com.avito.android.remote.model.category_parameters.slot.market_price.MarketPriceSlotConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<EditableParameter<?>, Unit> {
    public final /* synthetic */ MarketPriceSlotWrapper a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(MarketPriceSlotWrapper marketPriceSlotWrapper) {
        super(1);
        this.a = marketPriceSlotWrapper;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(EditableParameter<?> editableParameter) {
        EditableParameter<?> editableParameter2 = editableParameter;
        Intrinsics.checkNotNullParameter(editableParameter2, "parameter");
        String id = editableParameter2.getId();
        if (Intrinsics.areEqual(id, ((MarketPriceSlotConfig) this.a.getSlot().getWidget().getConfig()).getPriceId())) {
            MarketPriceSlotWrapper.access$trackSlotData(this.a);
            this.a.f.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.MARKET_PRICE));
        } else if (this.a.a.contains(id)) {
            this.a.f();
        }
        return Unit.INSTANCE;
    }
}

package a2.a.a.e2.d0.d;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import io.reactivex.rxjava3.functions.Action;
public final class f implements Action {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;

    public f(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper) {
        this.a = anonymousNumberSlotWrapper;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.h.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.ANONYMOUS_NUMBER));
    }
}

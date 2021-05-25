package a2.a.a.e2.d0.d;

import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.remote.model.PublishAnonymousNumber;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.slot.SlotType;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<TypedResult<PublishAnonymousNumber>> {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;

    public a(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper) {
        this.a = anonymousNumberSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: com.jakewharton.rxrelay2.PublishRelay */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TypedResult<PublishAnonymousNumber> typedResult) {
        AnonymousNumberSlotWrapper.access$updateAnonymousNumberServiceAvailability(this.a, typedResult);
        this.a.h.accept(new ConsumeValueChangeResult.NeedViewUpdate(SlotType.ANONYMOUS_NUMBER));
    }
}

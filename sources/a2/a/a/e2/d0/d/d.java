package a2.a.a.e2.d0.d;

import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.remote.model.PublishAnonymousNumber;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<TypedResult<PublishAnonymousNumber>> {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;

    public d(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper) {
        this.a = anonymousNumberSlotWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TypedResult<PublishAnonymousNumber> typedResult) {
        this.a.p.trackAnonymousNumberSlotLoaded();
        AnonymousNumberSlotWrapper.access$updateAnonymousNumberServiceAvailability(this.a, typedResult);
    }
}

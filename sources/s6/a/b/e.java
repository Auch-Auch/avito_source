package s6.a.b;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscription;
public final class e extends c<Subscription> {
    private static final long serialVersionUID = -707001650852963139L;

    public e(Subscription subscription) {
        super(subscription);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // s6.a.b.c
    public void a(@NonNull Subscription subscription) {
        subscription.cancel();
    }
}

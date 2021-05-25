package a2.a.a.o1.f;

import com.avito.android.messenger.search.ChannelsSearchInteractorImpl;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Predicate<Long> {
    public final /* synthetic */ ChannelsSearchInteractorImpl.e a;

    public g(ChannelsSearchInteractorImpl.e eVar) {
        this.a = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Long l) {
        Long l2 = l;
        Intrinsics.checkNotNullParameter(l2, "it");
        return l2.longValue() != this.a.c.getId();
    }
}

package s6.a.c.b.b;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
public abstract class a<T, R> extends Maybe<R> implements HasUpstreamMaybeSource<T> {
    public final MaybeSource<T> source;

    public a(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public final MaybeSource<T> source() {
        return this.source;
    }
}

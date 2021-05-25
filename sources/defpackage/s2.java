package defpackage;

import com.avito.android.messenger.search.ChannelsSearchInteractor;
import com.avito.android.messenger.util.ThrowablesKt;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: s2  reason: default package */
public final class s2<T, R> implements Function<Throwable, ChannelsSearchInteractor.State> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public s2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public final ChannelsSearchInteractor.State apply(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "error");
            return ChannelsSearchInteractor.State.Loaded.copy$default((ChannelsSearchInteractor.State.Loaded) ((ChannelsSearchInteractor.State) this.b), null, null, null, new ChannelsSearchInteractor.State.PaginationState.Error(ThrowablesKt.toAvitoException(th2)), 7, null);
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(th, "it");
            return (ChannelsSearchInteractor.State) this.b;
        } else {
            throw null;
        }
    }
}

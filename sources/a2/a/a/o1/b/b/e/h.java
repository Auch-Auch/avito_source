package a2.a.a.o1.b.b.e;

import com.avito.android.messenger.channels.mvi.view.ChannelsListViewImpl;
import io.reactivex.functions.Predicate;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Predicate<Unit> {
    public final /* synthetic */ ChannelsListViewImpl.b a;

    public h(ChannelsListViewImpl.b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return (this.a.a.j) && this.a.a.c.findLastVisibleItemPosition() == ChannelsListViewImpl.access$getAdapter$p(this.a.a).getItemCount() - 1;
    }
}

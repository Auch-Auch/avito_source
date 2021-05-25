package a2.a.a.h;

import com.avito.android.advert_stats.AdvertStatsActivity;
import io.reactivex.functions.Consumer;
public final class g<T> implements Consumer<Throwable> {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        AdvertStatsActivity.access$getRecyclerView$p(this.a.a).addItemDecoration(AdvertStatsActivity.access$getLastItemDecoration$p(this.a.a));
    }
}

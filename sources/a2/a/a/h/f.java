package a2.a.a.h;

import android.content.res.Resources;
import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.advert_stats.recycler.LastItemDecoration;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<Integer> {
    public final /* synthetic */ h a;

    public f(h hVar) {
        this.a = hVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        AdvertStatsActivity advertStatsActivity = this.a.a;
        Intrinsics.checkNotNullExpressionValue(num2, "it");
        int intValue = num2.intValue();
        Resources resources = this.a.a.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        advertStatsActivity.r = new LastItemDecoration(intValue, resources);
        AdvertStatsActivity.access$getRecyclerView$p(this.a.a).addItemDecoration(AdvertStatsActivity.access$getLastItemDecoration$p(this.a.a));
    }
}

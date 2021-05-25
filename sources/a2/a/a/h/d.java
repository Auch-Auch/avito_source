package a2.a.a.h;

import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.util.Views;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Unit, Integer> {
    public final /* synthetic */ h a;

    public d(h hVar) {
        this.a = hVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Integer apply(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return Integer.valueOf(Views.heightWithMargins(AdvertStatsActivity.access$getButton$p(this.a.a)));
    }
}

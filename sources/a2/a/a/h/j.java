package a2.a.a.h;

import com.avito.android.advert_stats.AdvertStatsActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class j extends Lambda implements Function0<Unit> {
    public final /* synthetic */ AdvertStatsActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(AdvertStatsActivity advertStatsActivity) {
        super(0);
        this.a = advertStatsActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.getViewModel().onRetryClicked();
        return Unit.INSTANCE;
    }
}

package a2.a.a.l3.c;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.user_stats.events.UserStatsChangeSelectedChartBarEvent;
import com.avito.android.user_stats.tab.UserStatsTabViewModel;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ UserStatsTabViewModel a;
    public final /* synthetic */ int b;

    public c(UserStatsTabViewModel userStatsTabViewModel, int i) {
        this.a = userStatsTabViewModel;
        this.b = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        MutableLiveData mutableLiveData = this.a.c;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        mutableLiveData.setValue(new UserStatsTabViewModel.TabState.Content(list2, this.b));
        this.a.k.track(new UserStatsChangeSelectedChartBarEvent());
    }
}

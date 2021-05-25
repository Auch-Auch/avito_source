package a2.a.a.h;

import androidx.lifecycle.Observer;
import com.avito.android.advert_stats.AdvertStatsActivity;
import com.avito.android.remote.model.Action;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
public final class h<T> implements Observer<Action> {
    public final /* synthetic */ AdvertStatsActivity a;

    public h(AdvertStatsActivity advertStatsActivity) {
        this.a = advertStatsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Action action) {
        Action action2 = action;
        if (action2 != null) {
            AdvertStatsActivity.access$getButton$p(this.a).setText(action2.getTitle());
            AdvertStatsActivity.access$getButton$p(this.a).setOnClickListener(new c(this, action2));
            Views.show(AdvertStatsActivity.access$getButton$p(this.a));
            AdvertStatsActivity.access$getRecyclerView$p(this.a).removeItemDecoration(AdvertStatsActivity.access$getLastItemDecoration$p(this.a));
            AdvertStatsActivity advertStatsActivity = this.a;
            Disposable subscribe = RxView.layoutChanges(AdvertStatsActivity.access$getButton$p(advertStatsActivity)).map(new d(this)).filter(e.a).firstElement().subscribe(new f(this), new g(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "button.layoutChanges()\n …tion) }\n                )");
            advertStatsActivity.q = subscribe;
        }
    }
}

package a2.a.a.l3.c;

import androidx.lifecycle.Observer;
import com.avito.android.user_stats.tab.UserStatsTabFragment;
import com.avito.android.user_stats.tab.UserStatsTabViewModel;
public final class b<T> implements Observer<UserStatsTabViewModel.RouterEvent> {
    public final /* synthetic */ UserStatsTabFragment a;

    public b(UserStatsTabFragment userStatsTabFragment) {
        this.a = userStatsTabFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(UserStatsTabViewModel.RouterEvent routerEvent) {
        UserStatsTabViewModel.RouterEvent routerEvent2 = routerEvent;
        if (routerEvent2 instanceof UserStatsTabViewModel.RouterEvent.OpenDeepLink) {
            UserStatsTabFragment userStatsTabFragment = this.a;
            userStatsTabFragment.startActivity(userStatsTabFragment.getDeepLinkIntentFactory$user_stats_release().getIntent(((UserStatsTabViewModel.RouterEvent.OpenDeepLink) routerEvent2).getDeeplink()));
        }
    }
}

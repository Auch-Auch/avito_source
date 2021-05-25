package a2.a.a.o1.b.b.e;

import com.avito.android.analytics.event.BannerEvent;
import com.avito.android.messenger.channels.mvi.view.ChannelsListFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ChannelsListFragment.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ChannelsListFragment.a aVar) {
        super(0);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.getAnalytics().track(new BannerEvent.Action("notifications", "messenger", "top", "click"));
        this.a.a.getRouter().showSystemNotificationSettings();
        return Unit.INSTANCE;
    }
}

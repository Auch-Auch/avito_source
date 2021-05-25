package a2.a.a.d2.c;

import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
public final class g<T, R> implements Function<Boolean, SingleSource<? extends SubscribeInfo>> {
    public final /* synthetic */ SubscriptionsPresenterImpl a;
    public final /* synthetic */ SubscribeInfo b;

    public g(SubscriptionsPresenterImpl subscriptionsPresenterImpl, SubscribeInfo subscribeInfo) {
        this.a = subscriptionsPresenterImpl;
        this.b = subscribeInfo;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends SubscribeInfo> apply(Boolean bool) {
        SubscribeInfo copy$default = SubscribeInfo.copy$default(this.b, null, bool, null, null, 13, null);
        return this.a.l.updateSeller(this.a.h, copy$default.isSubscribed(), copy$default.isNotificationsActivated()).andThen(Singles.toSingle(copy$default)).observeOn(this.a.r.mainThread());
    }
}

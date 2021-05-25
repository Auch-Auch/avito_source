package a2.a.a.m3;

import com.avito.android.user_subscribers.SubscriberList;
import com.avito.android.user_subscribers.UserSubscribersPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<SubscriberList> {
    public final /* synthetic */ UserSubscribersPresenterImpl a;

    public b(UserSubscribersPresenterImpl userSubscribersPresenterImpl) {
        this.a = userSubscribersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(SubscriberList subscriberList) {
        SubscriberList subscriberList2 = subscriberList;
        UserSubscribersPresenterImpl userSubscribersPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(subscriberList2, "it");
        UserSubscribersPresenterImpl userSubscribersPresenterImpl2 = this.a;
        UserSubscribersPresenterImpl.access$handleLoadSuccess(userSubscribersPresenterImpl, subscriberList2, userSubscribersPresenterImpl2.e(userSubscribersPresenterImpl2.a));
    }
}

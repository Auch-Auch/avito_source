package a2.a.a.m3;

import android.net.Uri;
import com.avito.android.user_subscribers.UserSubscribersPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ UserSubscribersPresenterImpl a;
    public final /* synthetic */ Uri b;

    public c(UserSubscribersPresenterImpl userSubscribersPresenterImpl, Uri uri) {
        this.a = userSubscribersPresenterImpl;
        this.b = uri;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        UserSubscribersPresenterImpl userSubscribersPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        userSubscribersPresenterImpl.a(th2, this.b);
    }
}

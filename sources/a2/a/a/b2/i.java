package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class i<T> implements Consumer<Throwable> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public i(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        UserProfilePresenterImpl userProfilePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "error");
        UserProfilePresenterImpl.access$handleError(userProfilePresenterImpl, th2);
    }
}

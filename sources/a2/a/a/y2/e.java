package a2.a.a.y2;

import com.avito.android.social_management.SocialManagementPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ SocialManagementPresenterImpl a;

    public e(SocialManagementPresenterImpl socialManagementPresenterImpl) {
        this.a = socialManagementPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        SocialManagementPresenterImpl socialManagementPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        SocialManagementPresenterImpl.access$handleError(socialManagementPresenterImpl, th2);
    }
}

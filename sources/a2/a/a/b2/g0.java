package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class g0<T> implements Consumer<String> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public g0(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        UserProfilePresenterImpl userProfilePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        UserProfilePresenterImpl.access$handleUrl(userProfilePresenterImpl, str2);
    }
}

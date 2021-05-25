package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class w<T> implements Consumer<String> {
    public final /* synthetic */ HomePresenterImpl a;

    public w(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        HomePresenterImpl homePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        HomePresenterImpl.access$onQuerySubmitted(homePresenterImpl, str2);
    }
}

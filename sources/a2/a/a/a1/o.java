package a2.a.a.a1;

import com.avito.android.home.HomePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
public final class o<T> implements Consumer<Option<? extends Boolean>> {
    public final /* synthetic */ HomePresenterImpl a;

    public o(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Option<? extends Boolean> option) {
        Option<? extends Boolean> option2 = option;
        HomePresenterImpl homePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(option2, "it");
        HomePresenterImpl.access$onNotificationDefaultLocationChanged(homePresenterImpl, option2);
    }
}

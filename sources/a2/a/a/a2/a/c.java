package a2.a.a.a2.a;

import com.avito.android.player.presenter.PlayerPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<Float> {
    public final /* synthetic */ PlayerPresenterImpl a;

    public c(PlayerPresenterImpl playerPresenterImpl) {
        this.a = playerPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Float f) {
        Float f2 = f;
        PlayerPresenterImpl playerPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(f2, "progress");
        PlayerPresenterImpl.access$onMediaProgressChanged(playerPresenterImpl, f2.floatValue());
    }
}

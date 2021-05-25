package a2.a.a.a2.a;

import com.avito.android.player.presenter.PlayerPresenterImpl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import io.reactivex.rxjava3.functions.Function;
public final class a<T, R> implements Function<Long, Float> {
    public final /* synthetic */ PlayerPresenterImpl a;

    public a(PlayerPresenterImpl playerPresenterImpl) {
        this.a = playerPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Float apply(Long l) {
        SimpleExoPlayer simpleExoPlayer = this.a.a;
        Float f = null;
        Float valueOf = simpleExoPlayer != null ? Float.valueOf((float) simpleExoPlayer.getCurrentPosition()) : null;
        SimpleExoPlayer simpleExoPlayer2 = this.a.a;
        if (simpleExoPlayer2 != null) {
            f = Float.valueOf((float) simpleExoPlayer2.getDuration());
        }
        return Float.valueOf((valueOf == null || valueOf.floatValue() < 0.0f || f == null || f.floatValue() < 0.0f) ? -1.0f : valueOf.floatValue() / f.floatValue());
    }
}

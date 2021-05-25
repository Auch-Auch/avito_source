package a2.a.a.a3;

import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.rxjava3.functions.Predicate;
public final class a<T> implements Predicate<PowerWebViewStateChangeEvent> {
    public static final a a = new a();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
        PowerWebViewStateChangeEvent powerWebViewStateChangeEvent2 = powerWebViewStateChangeEvent;
        return powerWebViewStateChangeEvent2.getState() == PowerWebViewStateChangeEvent.State.ERROR || powerWebViewStateChangeEvent2.getState() == PowerWebViewStateChangeEvent.State.FINISHED;
    }
}

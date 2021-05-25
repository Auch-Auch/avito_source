package defpackage;

import com.yatatsu.powerwebview.rx.PowerWebViewStateChangeEvent;
import io.reactivex.functions.Predicate;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: j1  reason: default package */
public final class j1<T> implements Predicate<PowerWebViewStateChangeEvent> {
    public static final j1 b = new j1(0);
    public static final j1 c = new j1(1);
    public static final j1 d = new j1(2);
    public static final j1 e = new j1(3);
    public final /* synthetic */ int a;

    public j1(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public final boolean test(PowerWebViewStateChangeEvent powerWebViewStateChangeEvent) {
        int i = this.a;
        if (i == 0) {
            PowerWebViewStateChangeEvent powerWebViewStateChangeEvent2 = powerWebViewStateChangeEvent;
            Intrinsics.checkNotNullParameter(powerWebViewStateChangeEvent2, "it");
            if (powerWebViewStateChangeEvent2.getState() == PowerWebViewStateChangeEvent.State.ERROR) {
                return true;
            }
            return false;
        } else if (i == 1) {
            PowerWebViewStateChangeEvent powerWebViewStateChangeEvent3 = powerWebViewStateChangeEvent;
            Intrinsics.checkNotNullParameter(powerWebViewStateChangeEvent3, "it");
            return CollectionsKt__CollectionsKt.listOf((Object[]) new PowerWebViewStateChangeEvent.State[]{PowerWebViewStateChangeEvent.State.STARTED, PowerWebViewStateChangeEvent.State.FINISHED}).contains(powerWebViewStateChangeEvent3.getState());
        } else if (i == 2) {
            PowerWebViewStateChangeEvent powerWebViewStateChangeEvent4 = powerWebViewStateChangeEvent;
            Intrinsics.checkNotNullParameter(powerWebViewStateChangeEvent4, "it");
            if (powerWebViewStateChangeEvent4.getState() == PowerWebViewStateChangeEvent.State.FINISHED) {
                return true;
            }
            return false;
        } else if (i == 3) {
            PowerWebViewStateChangeEvent powerWebViewStateChangeEvent5 = powerWebViewStateChangeEvent;
            Intrinsics.checkNotNullParameter(powerWebViewStateChangeEvent5, "it");
            if (powerWebViewStateChangeEvent5.getState() == PowerWebViewStateChangeEvent.State.STARTED) {
                return true;
            }
            return false;
        } else {
            throw null;
        }
    }
}

package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.core.Eval;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0001\u0010\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"arrow/core/Eval$Companion$collapse$1", "Larrow/core/Eval$FlatMap;", ExifInterface.LATITUDE_SOUTH, "Larrow/core/Eval;", Tracker.Events.CREATIVE_START, "()Larrow/core/Eval;", "s", "run", "(Ljava/lang/Object;)Larrow/core/Eval;", "<init>", "(Larrow/core/Eval;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Eval$Companion$collapse$1 extends Eval.FlatMap<A> {
    public final /* synthetic */ Eval f;

    public Eval$Companion$collapse$1(Eval eval) {
        this.f = eval;
    }

    @Override // arrow.core.Eval.FlatMap
    @NotNull
    public <S> Eval<A> run(S s) {
        return Eval.Companion.access$collapse(Eval.Companion, ((Eval.FlatMap) this.f).run(s));
    }

    @Override // arrow.core.Eval.FlatMap
    @NotNull
    public <S> Eval<S> start() {
        return ((Eval.FlatMap) this.f).start();
    }
}

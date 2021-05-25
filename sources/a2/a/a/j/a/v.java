package a2.a.a.j.a;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
public final class v<T, R> implements Function<Option<? extends LocalMessage>, Option<? extends Pair<? extends String, ? extends Long>>> {
    public static final v a = new v();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Option<? extends Pair<? extends String, ? extends Long>> apply(Option<? extends LocalMessage> option) {
        Option<? extends LocalMessage> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "message");
        if (option2 instanceof None) {
            return None.INSTANCE;
        }
        if (option2 instanceof Some) {
            LocalMessage localMessage = (LocalMessage) ((Some) option2).getT();
            return new Some(TuplesKt.to(localMessage.localId, Long.valueOf(localMessage.created)));
        }
        throw new NoWhenBranchMatchedException();
    }
}

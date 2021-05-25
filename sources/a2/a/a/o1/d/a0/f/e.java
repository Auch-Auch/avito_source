package a2.a.a.o1.d.a0.f;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.android.persistence.messenger.TransferStatus;
public final class e<T, R> implements Function<Option<? extends MessageMetaInfo>, ObservableSource<? extends TransferStatus>> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends TransferStatus> apply(Option<? extends MessageMetaInfo> option) {
        Option<? extends MessageMetaInfo> option2 = option;
        if (option2 instanceof None) {
            return Observable.error(new IllegalArgumentException("No such metainfo entry found in db"));
        }
        if (option2 instanceof Some) {
            return Observable.just(((MessageMetaInfo) ((Some) option2).getT()).getTransferStatus());
        }
        throw new NoWhenBranchMatchedException();
    }
}

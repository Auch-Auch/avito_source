package a2.a.a.o1.d.a0.f;

import io.reactivex.rxjava3.functions.Predicate;
import ru.avito.android.persistence.messenger.TransferStatus;
public final class g<T> implements Predicate<TransferStatus> {
    public static final g a = new g();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(TransferStatus transferStatus) {
        TransferStatus transferStatus2 = transferStatus;
        return transferStatus2 == TransferStatus.SUCCESS || transferStatus2 == TransferStatus.ERROR;
    }
}

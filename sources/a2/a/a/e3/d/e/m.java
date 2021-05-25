package a2.a.a.e3.d.e;

import com.avito.android.tariff.edit_info.item.prolongation.TariffProlongationItem;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class m<T, R> implements Function<TariffProlongationItem, Boolean> {
    public static final m a = new m();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Boolean apply(TariffProlongationItem tariffProlongationItem) {
        TariffProlongationItem tariffProlongationItem2 = tariffProlongationItem;
        Intrinsics.checkNotNullParameter(tariffProlongationItem2, "it");
        return Boolean.valueOf(tariffProlongationItem2.isSwitchOn());
    }
}

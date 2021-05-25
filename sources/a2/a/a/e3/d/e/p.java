package a2.a.a.e3.d.e;

import com.avito.android.tariff.edit_info.item.TariffEditInfo;
import com.avito.android.tariff.edit_info.item.tabs.PeriodTab;
import com.avito.android.tariff.edit_info.item.tabs.TariffEditConvertInfo;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class p<T> implements Consumer<PeriodTab> {
    public final /* synthetic */ EditInfoViewModelImpl a;

    public p(EditInfoViewModelImpl editInfoViewModelImpl) {
        this.a = editInfoViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(PeriodTab periodTab) {
        TariffEditInfo tariffEditInfo;
        PeriodTab periodTab2 = periodTab;
        TariffEditConvertInfo tariffEditConvertInfo = this.a.q;
        if (tariffEditConvertInfo != null && (tariffEditInfo = tariffEditConvertInfo.getTariffEditInfo()) != null) {
            Intrinsics.checkNotNullExpressionValue(periodTab2, "period");
            tariffEditInfo.setSelectedTab(periodTab2);
            EditInfoViewModelImpl.access$publishNewItems(this.a, tariffEditInfo.getItemsForTab(periodTab2));
        }
    }
}

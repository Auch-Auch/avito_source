package a2.a.a.h3.b;

import androidx.lifecycle.Observer;
import com.avito.android.user_advert.soa_with_price.CloseReasonItem;
import com.avito.android.user_advert.soa_with_price.CloseReasonsSheetDialogViewImpl;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragment;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.DataSource;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Observer<DataSource<CloseReasonItem>> {
    public final /* synthetic */ SoaWithPriceSheetDialogFragment a;
    public final /* synthetic */ CloseReasonsSheetDialogViewImpl b;

    public a(SoaWithPriceSheetDialogFragment soaWithPriceSheetDialogFragment, CloseReasonsSheetDialogViewImpl closeReasonsSheetDialogViewImpl) {
        this.a = soaWithPriceSheetDialogFragment;
        this.b = closeReasonsSheetDialogViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DataSource<CloseReasonItem> dataSource) {
        DataSource<CloseReasonItem> dataSource2 = dataSource;
        AdapterPresenter adapterPresenter = this.a.getAdapterPresenter();
        Intrinsics.checkNotNullExpressionValue(dataSource2, "it");
        adapterPresenter.onDataSourceChanged(dataSource2);
        this.b.onDataChanged();
    }
}

package com.avito.android.delivery.suggest;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestViewWithRedesignedInputImpl;
import com.avito.android.util.Views;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "query", "", "accept", "(Ljava/lang/String;)V", "com/avito/android/delivery/suggest/DeliveryLocationSuggestViewWithRedesignedInputImpl$bindTo$1$$special$$inlined$doOnLastQuery$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class DeliveryLocationSuggestViewWithRedesignedInputImpl$bindTo$1$$special$$inlined$let$lambda$1<T> implements Consumer<String> {
    public final /* synthetic */ DataSource a;
    public final /* synthetic */ DeliveryLocationSuggestViewWithRedesignedInputImpl.a b;

    public DeliveryLocationSuggestViewWithRedesignedInputImpl$bindTo$1$$special$$inlined$let$lambda$1(DataSource dataSource, DeliveryLocationSuggestViewWithRedesignedInputImpl.a aVar) {
        this.a = dataSource;
        this.b = aVar;
    }

    public final void accept(String str) {
        Intrinsics.checkNotNullExpressionValue(str, "query");
        RecyclerView recyclerView = this.b.a.b;
        boolean z = false;
        if (this.a.isEmpty()) {
            if (str.length() == 0) {
                z = true;
            }
        }
        Views.setVisible(recyclerView, !z);
    }
}

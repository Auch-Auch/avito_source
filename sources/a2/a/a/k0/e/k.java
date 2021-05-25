package a2.a.a.k0.e;

import android.view.View;
import com.avito.android.delivery.summary.DeliveryRdsSummaryViewImpl;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.picker.Picker;
import com.avito.android.lib.design.picker.WheelData;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class k implements View.OnClickListener {
    public final /* synthetic */ BottomSheetDialog a;
    public final /* synthetic */ Picker b;
    public final /* synthetic */ DeliveryRdsSummaryViewImpl c;
    public final /* synthetic */ Function1 d;

    public k(BottomSheetDialog bottomSheetDialog, Picker picker, DeliveryRdsSummaryViewImpl deliveryRdsSummaryViewImpl, int i, int i2, int i3, Function1 function1) {
        this.a = bottomSheetDialog;
        this.b = picker;
        this.c = deliveryRdsSummaryViewImpl;
        this.d = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.d;
        WheelData<?> firstWheelValue = this.b.getFirstWheelValue();
        Intrinsics.checkNotNull(firstWheelValue);
        Object key = firstWheelValue.getKey();
        Objects.requireNonNull(key, "null cannot be cast to non-null type kotlin.Int");
        function1.invoke((Integer) key);
        this.a.close();
        this.c.f = null;
    }
}

package a2.a.a.z2.b;

import android.view.ViewGroup;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Float, Unit> {
    public final /* synthetic */ SparePartsBottomSheetViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(SparePartsBottomSheetViewImpl sparePartsBottomSheetViewImpl) {
        super(1);
        this.a = sparePartsBottomSheetViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Float f) {
        float floatValue = f.floatValue();
        ViewGroup.LayoutParams layoutParams = this.a.b.getLayoutParams();
        layoutParams.height = (int) floatValue;
        this.a.b.setLayoutParams(layoutParams);
        return Unit.INSTANCE;
    }
}

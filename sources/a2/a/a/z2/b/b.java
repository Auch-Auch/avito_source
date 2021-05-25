package a2.a.a.z2.b;

import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetViewImpl;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<Integer, CompletableSource> {
    public final /* synthetic */ SparePartsBottomSheetViewImpl a;

    public b(SparePartsBottomSheetViewImpl sparePartsBottomSheetViewImpl) {
        this.a = sparePartsBottomSheetViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Integer num) {
        Integer num2 = num;
        int i = this.a.e.K;
        this.a.e.J = false;
        SparePartsBottomSheetViewImpl sparePartsBottomSheetViewImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(num2, "it");
        return SparePartsBottomSheetViewImpl.access$buildHeightAnimationCompletable(sparePartsBottomSheetViewImpl, i, num2.intValue());
    }
}

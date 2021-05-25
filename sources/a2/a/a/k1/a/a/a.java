package a2.a.a.k1.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.ModalBottomSheetView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function2<View, Integer, Unit> {
    public final /* synthetic */ ModalBottomSheetView a;
    public final /* synthetic */ BottomSheetDialog b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ Function1 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ModalBottomSheetView modalBottomSheetView, BottomSheetDialog bottomSheetDialog, int i, View view, ViewGroup.LayoutParams layoutParams, int i2, Function1 function1, Function1 function12) {
        super(2);
        this.a = modalBottomSheetView;
        this.b = bottomSheetDialog;
        this.c = view;
        this.d = function1;
        this.e = function12;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(View view, Integer num) {
        Function0<Unit> onCloseListener;
        View view2 = view;
        int intValue = num.intValue();
        Intrinsics.checkNotNullParameter(view2, "bottomSheet");
        Function2<View, Integer, Unit> onBottomSheetStateChangedListener = this.b.getOnBottomSheetStateChangedListener();
        if (onBottomSheetStateChangedListener != null) {
            onBottomSheetStateChangedListener.invoke(view2, Integer.valueOf(intValue));
        }
        if (intValue == 5) {
            if ((this.b.n) && (onCloseListener = this.a.getOnCloseListener()) != null) {
                onCloseListener.invoke();
            }
            BottomSheetDialog.access$dismissSafely(this.b);
        }
        return Unit.INSTANCE;
    }
}

package a2.a.a.k1.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ BottomSheetDialog a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function1 d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(BottomSheetDialog bottomSheetDialog, int i, View view, ViewGroup.LayoutParams layoutParams, int i2, Function1 function1, Function1 function12) {
        super(0);
        this.a = bottomSheetDialog;
        this.b = view;
        this.c = function1;
        this.d = function12;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Boolean invoke() {
        return Boolean.valueOf((this.a.c) && this.a.isShowing() && BottomSheetDialog.access$shouldWindowCloseOnTouchOutside(this.a));
    }
}

package defpackage;

import android.view.View;
import com.avito.android.inline_filters.dialog.select.SelectFilterDialog;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.util.Keyboards;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: b4  reason: default package */
public final class b4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b4(int i2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        super(0);
        this.a = i2;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
        this.f = obj5;
        this.g = obj6;
        this.h = obj7;
        this.i = obj8;
        this.j = obj9;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i2 = this.a;
        if (i2 == 0) {
            ((Function0) this.d).invoke();
            View view = (View) this.e;
            if (view != null) {
                Keyboards.hideKeyboardWithAttempt$default(view, 0, 0, 3, null);
            }
            ((SelectFilterDialog) this.b).performDismiss();
            return Unit.INSTANCE;
        } else if (i2 == 1) {
            ((Function1) this.f).invoke(new InlineFilterValue.InlineFilterSelectValue(null));
            ((Function0) this.g).invoke();
            ((SelectFilterDialog) this.b).performDismiss();
            return Unit.INSTANCE;
        } else if (i2 == 2) {
            ((Function0) this.i).invoke();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

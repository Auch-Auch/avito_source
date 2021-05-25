package defpackage;

import android.view.View;
import com.avito.android.advert_core.call_methods.AdvertCallMethodsDialogFragment;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: o4  reason: default package */
public final class o4 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o4(int i, Object obj, Object obj2) {
        super(1);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(view, "it");
            AdvertCallMethodsDialogFragment.Callback callback = ((AdvertCallMethodsDialogFragment.a) this.b).a.getCallback();
            if (callback != null) {
                callback.onInAppCallSelected(((AdvertCallMethodsDialogFragment.a) this.b).c);
            }
            ((BottomSheetMenuDialog) this.c).close();
            return Unit.INSTANCE;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(view, "it");
            AdvertCallMethodsDialogFragment.Callback callback2 = ((AdvertCallMethodsDialogFragment.a) this.b).a.getCallback();
            if (callback2 != null) {
                callback2.onPhoneCallSelected(((AdvertCallMethodsDialogFragment.a) this.b).c);
            }
            ((BottomSheetMenuDialog) this.c).close();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

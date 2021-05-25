package defpackage;

import android.content.DialogInterface;
import com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl;
import com.avito.android.user_advert.event.CallPermissionDialogSuccessEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: n5  reason: default package */
public final class n5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n5(int i, Object obj, Object obj2) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            ((MyAdvertDetailsViewImpl.o) this.b).a.a.startActivity(((MyAdvertDetailsViewImpl.o) this.b).a.g0.createAppSettingsIntent());
            ((MyAdvertDetailsViewImpl.o) this.b).a.h0.track(new CallPermissionDialogSuccessEvent(((MyAdvertDetailsViewImpl.o) this.b).c));
            ((DialogInterface) this.c).dismiss();
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((MyAdvertDetailsViewImpl.o) this.b).a.k0.requestPermissions(10000, "android.permission.RECORD_AUDIO");
            ((MyAdvertDetailsViewImpl.o) this.b).a.h0.track(new CallPermissionDialogSuccessEvent(((MyAdvertDetailsViewImpl.o) this.b).c));
            ((DialogInterface) this.c).dismiss();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

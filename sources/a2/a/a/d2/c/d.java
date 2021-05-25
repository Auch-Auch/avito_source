package a2.a.a.d2.c;

import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.public_profile.ui.PublicProfileViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PublicProfileViewImpl.g a;
    public final /* synthetic */ DialogInterface b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(PublicProfileViewImpl.g gVar, Dialog.Config config, DialogInterface dialogInterface) {
        super(0);
        this.a = gVar;
        this.b = dialogInterface;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.dismiss();
        this.a.b.invoke();
        return Unit.INSTANCE;
    }
}

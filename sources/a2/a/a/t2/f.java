package a2.a.a.t2;

import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.model.ShopSettingsConfirmation;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
    public final /* synthetic */ ShopSettingsConfirmation a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(ShopSettingsConfirmation shopSettingsConfirmation) {
        super(2);
        this.a = shopSettingsConfirmation;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
        Dialog.Config config2 = config;
        DialogInterface dialogInterface2 = dialogInterface;
        Intrinsics.checkNotNullParameter(config2, "$receiver");
        Intrinsics.checkNotNullParameter(dialogInterface2, "dialog");
        config2.setTitle(this.a.getTitle());
        config2.setSubtitle(this.a.getSubtitle());
        config2.setButtonsOrientation(1);
        config2.addDefaultButton(this.a.getDismissActionText(), new e(dialogInterface2));
        return Unit.INSTANCE;
    }
}

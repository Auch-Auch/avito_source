package a2.a.a.h3.a.f1;

import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
    public final /* synthetic */ AutoBookingBlockViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(AutoBookingBlockViewModel autoBookingBlockViewModel) {
        super(2);
        this.a = autoBookingBlockViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
        Dialog.Config config2 = config;
        DialogInterface dialogInterface2 = dialogInterface;
        Intrinsics.checkNotNullParameter(config2, "$receiver");
        Intrinsics.checkNotNullParameter(dialogInterface2, "it");
        config2.setTitle(AutoBookingBlockViewModel.access$getResourceProvider$p(this.a).getTurningOffWarningTitle());
        config2.setSubtitle(AutoBookingBlockViewModel.access$getResourceProvider$p(this.a).getTurningOffWarningMessage());
        config2.setButtonsOrientation(1);
        config2.addPrimaryButton(AutoBookingBlockViewModel.access$getResourceProvider$p(this.a).getTurningOffWarningCancelButtonTitle(), new a(dialogInterface2));
        config2.addDefaultButton(AutoBookingBlockViewModel.access$getResourceProvider$p(this.a).getTurningOffWarningConfirmButtonTitle(), new b(this, dialogInterface2));
        config2.enableCancelable(new c(this));
        return Unit.INSTANCE;
    }
}

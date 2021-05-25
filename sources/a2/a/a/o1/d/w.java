package a2.a.a.o1.d;

import android.content.Context;
import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class w extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
    public final /* synthetic */ ChannelFragment a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Context c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(ChannelFragment channelFragment, boolean z, Context context) {
        super(2);
        this.a = channelFragment;
        this.b = z;
        this.c = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
        Dialog.Config config2 = config;
        DialogInterface dialogInterface2 = dialogInterface;
        Intrinsics.checkNotNullParameter(config2, "$receiver");
        Intrinsics.checkNotNullParameter(dialogInterface2, "dialog");
        config2.setTitle(R.string.messenger_file_download_permission_dialog_title);
        config2.setSubtitle(R.string.messenger_file_download_permission_dialog_subtitle);
        config2.setButtonsOrientation(1);
        if (this.b) {
            config2.addPrimaryButton(R.string.messenger_file_download_permission_dialog_settings_button, new t5(0, this, dialogInterface2));
        } else {
            config2.addPrimaryButton(R.string.messenger_file_download_permission_dialog_grant_button, new t5(1, this, dialogInterface2));
        }
        config2.addSecondaryButton(R.string.messenger_file_download_permission_dialog_deny_button, new v(dialogInterface2));
        return Unit.INSTANCE;
    }
}

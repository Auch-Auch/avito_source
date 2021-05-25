package a2.a.a.c2.f;

import android.content.DialogInterface;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.profile_phones.R;
import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
    public final /* synthetic */ PhonesListFragment a;
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(PhonesListFragment phonesListFragment, String str) {
        super(2);
        this.a = phonesListFragment;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
        Dialog.Config config2 = config;
        DialogInterface dialogInterface2 = dialogInterface;
        Intrinsics.checkNotNullParameter(config2, "$receiver");
        Intrinsics.checkNotNullParameter(dialogInterface2, "it");
        config2.setTitle(this.a.getString(R.string.verification_status_stub_title, this.b));
        config2.setSubtitle(this.a.getString(R.string.verification_status_stub_text));
        config2.addPrimaryButton(R.string.verification_stub_button_text, new g(dialogInterface2));
        return Unit.INSTANCE;
    }
}

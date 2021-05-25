package a2.a.a.g1.e.d;

import android.content.DialogInterface;
import com.avito.android.inline_filters.dialog.select.MultiselectFilterDialog;
import kotlin.jvm.functions.Function0;
public final class e implements DialogInterface.OnCancelListener {
    public final /* synthetic */ Function0 a;

    public e(MultiselectFilterDialog multiselectFilterDialog, Function0 function0) {
        this.a = function0;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.invoke();
    }
}

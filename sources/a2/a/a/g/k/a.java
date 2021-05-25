package a2.a.a.g.k;

import android.content.DialogInterface;
import android.view.View;
import com.avito.android.lib.design.dialog.Dialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
    public final /* synthetic */ View a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(2);
        this.a = view;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
        Dialog.Config config2 = config;
        Intrinsics.checkNotNullParameter(config2, "$receiver");
        Intrinsics.checkNotNullParameter(dialogInterface, "it");
        View view = this.a;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        config2.setCustomView(view);
        config2.setCloseButtonVisible(true);
        return Unit.INSTANCE;
    }
}

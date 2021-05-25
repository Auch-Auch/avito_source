package a2.a.a.o1.d.a0.h;

import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ MenuElement a;
    public final /* synthetic */ d b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(MenuElement menuElement, d dVar, BottomSheetMenuDialog bottomSheetMenuDialog) {
        super(1);
        this.a = menuElement;
        this.b = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.b.a.getActionClickStream().accept(((MenuElement.Action) this.a).getId());
        return Unit.INSTANCE;
    }
}

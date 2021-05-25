package a2.a.a.o1.d.a0.g;

import android.app.Dialog;
import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ ChannelMenuView.MenuAction a;
    public final /* synthetic */ int b;
    public final /* synthetic */ e c;
    public final /* synthetic */ BottomSheetMenuDialog d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ChannelMenuView.MenuAction menuAction, int i, e eVar, BottomSheetMenuDialog bottomSheetMenuDialog) {
        super(1);
        this.a = menuAction;
        this.b = i;
        this.c = eVar;
        this.d = bottomSheetMenuDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        this.d.close();
        if (this.a.getAnalyticEvent() != null) {
            ChannelMenuViewImpl.access$getAnalytics$p(this.c.a).track(this.a.getAnalyticEvent());
        }
        if (this.a.getConfirmation() != null) {
            Dialog access$getDialog$p = ChannelMenuViewImpl.access$getDialog$p(this.c.a);
            if (access$getDialog$p != null) {
                access$getDialog$p.dismiss();
            }
            ChannelMenuViewImpl.access$getConfirmationDialog$p(this.c.a).show(this.a.getConfirmation(), new a(this));
        } else {
            this.c.b.getMenu().getListener().invoke(Integer.valueOf(this.b));
        }
        return Unit.INSTANCE;
    }
}

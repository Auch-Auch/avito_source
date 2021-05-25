package a2.a.a.o1.d.a0.h;

import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.conversation.mvi.message_menu.MenuElement;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuPresenter;
import com.avito.android.messenger.conversation.mvi.message_menu.MessageMenuViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<BottomSheetMenuDialog, Unit> {
    public final /* synthetic */ MessageMenuViewImpl a;
    public final /* synthetic */ MessageMenuPresenter.State.Shown.Menu b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(MessageMenuViewImpl messageMenuViewImpl, MessageMenuPresenter.State.Shown.Menu menu) {
        super(1);
        this.a = messageMenuViewImpl;
        this.b = menu;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(BottomSheetMenuDialog bottomSheetMenuDialog) {
        BottomSheetMenuDialog bottomSheetMenuDialog2 = bottomSheetMenuDialog;
        Intrinsics.checkNotNullParameter(bottomSheetMenuDialog2, "$receiver");
        bottomSheetMenuDialog2.setPeekHeight(MessageMenuViewImpl.access$getBottomSheetPeekHeight$p(this.a));
        for (T t : this.b.getMenuItems()) {
            if (t instanceof MenuElement.Hint) {
                bottomSheetMenuDialog2.addHint(new g5(0, t));
            } else if (t instanceof MenuElement.Header) {
                BottomSheetMenuDialog.addHeader$default(bottomSheetMenuDialog2, false, new g5(1, t), 1, null);
            } else if (t instanceof MenuElement.Text) {
                bottomSheetMenuDialog2.addText(new g5(2, t));
            } else if (t instanceof MenuElement.Action) {
                T t2 = t;
                String string = bottomSheetMenuDialog2.getContext().getString(t2.getTitle());
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(menuElement.title)");
                BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string, Integer.valueOf(t2.getIcon()), null, null, null, new a(t, this, bottomSheetMenuDialog2), 28, null);
            }
        }
        bottomSheetMenuDialog2.setOnCloseListener(new b(this));
        bottomSheetMenuDialog2.setOnCancelListener(new c(this));
        bottomSheetMenuDialog2.show();
        return Unit.INSTANCE;
    }
}

package a2.a.a.o1.d.a0.g;

import android.content.Context;
import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView;
import com.avito.android.util.ToastsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ e a;
    public final /* synthetic */ BottomSheetMenuDialog b;
    public final /* synthetic */ ChannelMenuView.Profile c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(e eVar, BottomSheetMenuDialog bottomSheetMenuDialog, ChannelMenuView.Profile profile) {
        super(1);
        this.a = eVar;
        this.b = bottomSheetMenuDialog;
        this.c = profile;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        if (this.c.getAction() != null) {
            this.b.close();
            this.a.a.getProfileClicks().accept(Unit.INSTANCE);
        } else {
            Context context = this.b.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ToastsKt.showToast$default(context, R.string.messenger_profile_is_not_available, 0, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }
}

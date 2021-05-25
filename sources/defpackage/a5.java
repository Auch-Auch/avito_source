package defpackage;

import a2.a.a.t0.z0.b.a;
import android.view.View;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: a5  reason: default package */
public final class a5 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a5(int i, Object obj, Object obj2) {
        super(1);
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(View view) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(view, "it");
            ((TestFavoriteAdvertItemPresenter.Listener) ((a) this.b).b.a.get()).onAskSellerAboutItem(((a) this.b).c.getStringId());
            ((BottomSheetMenuDialog) this.c).close();
            return Unit.INSTANCE;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(view, "it");
            ((TestFavoriteAdvertItemPresenter.Listener) ((a) this.b).b.a.get()).onRemoveItemClicked(((a) this.b).c);
            ((BottomSheetMenuDialog) this.c).close();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}

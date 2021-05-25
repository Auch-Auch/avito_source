package a2.a.a.t0.z0.a;

import android.view.View;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenterImpl;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ b a;
    public final /* synthetic */ BottomSheetMenuDialog b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar, BottomSheetMenuDialog bottomSheetMenuDialog) {
        super(1);
        this.a = bVar;
        this.b = bottomSheetMenuDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        ((FavoriteAdvertItemPresenter.Listener) FavoriteAdvertItemPresenterImpl.access$getListener$p(this.a.b).get()).onRemoveItemClicked(this.a.c);
        this.b.close();
        return Unit.INSTANCE;
    }
}

package a2.a.a.t0.z0.b;

import android.content.Context;
import com.avito.android.favorites.R;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.util.Contexts;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<BottomSheetMenuDialog, Unit> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ TestFavoriteAdvertItemPresenterImpl b;
    public final /* synthetic */ FavoriteAdvertItem c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, TestFavoriteAdvertItemPresenterImpl testFavoriteAdvertItemPresenterImpl, FavoriteAdvertItem favoriteAdvertItem) {
        super(1);
        this.a = context;
        this.b = testFavoriteAdvertItemPresenterImpl;
        this.c = favoriteAdvertItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(BottomSheetMenuDialog bottomSheetMenuDialog) {
        BottomSheetMenuDialog bottomSheetMenuDialog2 = bottomSheetMenuDialog;
        Intrinsics.checkNotNullParameter(bottomSheetMenuDialog2, "$receiver");
        if (this.c.getStatus() != null && this.c.getStatus() == FavoriteAdvertItem.Status.EXPIRED) {
            String string = this.a.getString(R.string.ask_seller_about_item);
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(R.string.ask_seller_about_item)");
            Integer valueOf = Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_help_black_24);
            Context context = bottomSheetMenuDialog2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string, valueOf, Integer.valueOf(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black)), null, null, new a5(0, this, bottomSheetMenuDialog2), 24, null);
        }
        String string2 = this.a.getString(R.string.remove_from_favorite);
        Intrinsics.checkNotNullExpressionValue(string2, "it.getString(R.string.remove_from_favorite)");
        Integer valueOf2 = Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_trash_black_24);
        Context context2 = bottomSheetMenuDialog2.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string2, valueOf2, Integer.valueOf(Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.black)), null, null, new a5(1, this, bottomSheetMenuDialog2), 24, null);
        return Unit.INSTANCE;
    }
}

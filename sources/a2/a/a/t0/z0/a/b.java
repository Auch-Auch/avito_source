package a2.a.a.t0.z0.a;

import android.content.Context;
import com.avito.android.favorites.R;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenterImpl;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.util.Contexts;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<BottomSheetMenuDialog, Unit> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ FavoriteAdvertItemPresenterImpl b;
    public final /* synthetic */ FavoriteAdvertItem c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, FavoriteAdvertItemPresenterImpl favoriteAdvertItemPresenterImpl, FavoriteAdvertItem favoriteAdvertItem) {
        super(1);
        this.a = context;
        this.b = favoriteAdvertItemPresenterImpl;
        this.c = favoriteAdvertItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(BottomSheetMenuDialog bottomSheetMenuDialog) {
        BottomSheetMenuDialog bottomSheetMenuDialog2 = bottomSheetMenuDialog;
        Intrinsics.checkNotNullParameter(bottomSheetMenuDialog2, "$receiver");
        String string = this.a.getString(R.string.remove_from_favorite);
        Intrinsics.checkNotNullExpressionValue(string, "it.getString(fav_R.string.remove_from_favorite)");
        Integer valueOf = Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_trash_black_24);
        Context context = bottomSheetMenuDialog2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string, valueOf, Integer.valueOf(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black)), null, null, new a(this, bottomSheetMenuDialog2), 24, null);
        return Unit.INSTANCE;
    }
}

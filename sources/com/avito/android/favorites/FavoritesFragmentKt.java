package com.avito.android.favorites;

import android.os.Bundle;
import com.avito.android.common.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "listBottomPaddingPx", "Lcom/avito/android/favorites/FavoritesFragment;", "createFavoritesFragment", "(Ljava/lang/Integer;)Lcom/avito/android/favorites/FavoritesFragment;", "favorites_release"}, k = 2, mv = {1, 4, 2})
public final class FavoritesFragmentKt {
    @NotNull
    public static final FavoritesFragment createFavoritesFragment(@Nullable Integer num) {
        FavoritesFragment favoritesFragment = new FavoritesFragment();
        Bundle bundle = new Bundle();
        if (num != null) {
            bundle.putInt(ConstantsKt.KEY_LIST_BOTTOM_PADDING, num.intValue());
        }
        Unit unit = Unit.INSTANCE;
        favoritesFragment.setArguments(bundle);
        return favoritesFragment;
    }

    public static /* synthetic */ FavoritesFragment createFavoritesFragment$default(Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return createFavoritesFragment(num);
    }
}

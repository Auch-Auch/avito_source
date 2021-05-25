package com.avito.android.favorite_sellers;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.common.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u00058\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"", "editable", "", "userKey", "dataType", "", "listBottomPaddingPx", "Landroidx/fragment/app/Fragment;", "createFavoriteSellersFragmentIntent", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroidx/fragment/app/Fragment;", "REQ_DEEPLINK", "I", "REQ_ADD_PHONE_TO_SUBSCRIBE_RECOMMENDED", "favorite-sellers_release"}, k = 2, mv = {1, 4, 2})
public final class FavoriteSellersFragmentKt {
    public static final int REQ_ADD_PHONE_TO_SUBSCRIBE_RECOMMENDED = 3;
    public static final int REQ_DEEPLINK = 1;

    @NotNull
    public static final Fragment createFavoriteSellersFragmentIntent(boolean z, @Nullable String str, @Nullable String str2, @Nullable Integer num) {
        FavoriteSellersFragment favoriteSellersFragment = new FavoriteSellersFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("editable", z);
        bundle.putString("user_key", str);
        bundle.putString("data_type", str2);
        if (num != null) {
            bundle.putInt(ConstantsKt.KEY_LIST_BOTTOM_PADDING, num.intValue());
        }
        Unit unit = Unit.INSTANCE;
        favoriteSellersFragment.setArguments(bundle);
        return favoriteSellersFragment;
    }

    public static /* synthetic */ Fragment createFavoriteSellersFragmentIntent$default(boolean z, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        return createFavoriteSellersFragmentIntent(z, str, str2, num);
    }
}

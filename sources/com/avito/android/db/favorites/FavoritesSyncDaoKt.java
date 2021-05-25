package com.avito.android.db.favorites;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/db/favorites/FavoritesSyncContract;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/favorites/FavoritesSyncContract;", "CONTRACT", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "WHERE_ENTITY_EQ", "favorite_release"}, k = 2, mv = {1, 4, 2})
public final class FavoritesSyncDaoKt {
    public static final FavoritesSyncContract a;
    public static final String b;

    static {
        FavoritesSyncContract favoritesSyncContract = new FavoritesSyncContract();
        a = favoritesSyncContract;
        b = favoritesSyncContract.getENTITY_ID() + " = ?";
    }
}

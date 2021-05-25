package com.avito.android.di.module;

import com.avito.android.analytics.Analytics;
import com.avito.android.db.DbHelper;
import com.avito.android.db.DbLock;
import com.avito.android.db.FavoriteDao;
import com.avito.android.db.FavoriteDaoImpl;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.db.favorites.FavoriteItemsDaoImpl;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.favorites.FavoritesSyncDaoImpl;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DeviceMetrics;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/di/module/FavoriteModule;", "", "Lcom/avito/android/db/DbHelper;", "dbHelper", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/analytics/Analytics;", "analytics", "Ljava/util/Locale;", "locale", "Lcom/avito/android/db/FavoriteDao;", "provideFavoriteDao", "(Lcom/avito/android/db/DbHelper;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/analytics/Analytics;Ljava/util/Locale;)Lcom/avito/android/db/FavoriteDao;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "provideFavoritesSyncDao", "(Lcom/avito/android/db/DbHelper;)Lcom/avito/android/db/favorites/FavoritesSyncDao;", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/db/favorites/FavoriteItemsDao;", "provideFavoriteItemsDao", "(Lcom/avito/android/db/DbHelper;Lcom/google/gson/Gson;Lcom/avito/android/deep_linking/DeepLinkFactory;)Lcom/avito/android/db/favorites/FavoriteItemsDao;", "Lcom/avito/android/db/DbLock;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/DbLock;", "lock", "<init>", "()V", "favorite_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FavoriteModule {
    @NotNull
    public static final FavoriteModule INSTANCE = new FavoriteModule();
    public static final DbLock a = new DbLock();

    @Provides
    @JvmStatic
    @NotNull
    public static final FavoriteDao provideFavoriteDao(@NotNull DbHelper dbHelper, @NotNull DeviceMetrics deviceMetrics, @NotNull Analytics analytics, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new FavoriteDaoImpl(dbHelper, deviceMetrics, analytics, locale);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final FavoriteItemsDao provideFavoriteItemsDao(@NotNull DbHelper dbHelper, @NotNull Gson gson, @NotNull DeepLinkFactory deepLinkFactory) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        return new FavoriteItemsDaoImpl(dbHelper, gson, a, deepLinkFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final FavoritesSyncDao provideFavoritesSyncDao(@NotNull DbHelper dbHelper) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        return new FavoritesSyncDaoImpl(dbHelper, a);
    }
}

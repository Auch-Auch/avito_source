package com.avito.android.app.task;

import android.app.Application;
import android.database.Cursor;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.db.AdvertsContract;
import com.avito.android.db.CachingCursor;
import com.avito.android.db.FavoriteDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.favorites.FavoriteMigrationStorage;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/app/task/FavoritesMigrationTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/favorites/FavoriteMigrationStorage;", "favoritesMigrationStorage", "Lcom/avito/android/favorites/FavoriteMigrationStorage;", "Lcom/avito/android/db/FavoriteDao;", "favoriteDao", "Lcom/avito/android/db/FavoriteDao;", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "<init>", "(Lcom/avito/android/db/FavoriteDao;Lcom/avito/android/db/favorites/FavoritesSyncDao;Lcom/avito/android/favorites/FavoriteMigrationStorage;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesMigrationTask implements ApplicationBlockingStartupTask {
    public final FavoriteDao favoriteDao;
    public final FavoriteMigrationStorage favoritesMigrationStorage;
    public final FavoritesSyncDao favoritesSyncDao;

    public FavoritesMigrationTask(@NotNull FavoriteDao favoriteDao2, @NotNull FavoritesSyncDao favoritesSyncDao2, @NotNull FavoriteMigrationStorage favoriteMigrationStorage) {
        Intrinsics.checkNotNullParameter(favoriteDao2, "favoriteDao");
        Intrinsics.checkNotNullParameter(favoritesSyncDao2, "favoritesSyncDao");
        Intrinsics.checkNotNullParameter(favoriteMigrationStorage, "favoritesMigrationStorage");
        this.favoriteDao = favoriteDao2;
        this.favoritesSyncDao = favoritesSyncDao2;
        this.favoritesMigrationStorage = favoriteMigrationStorage;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        CachingCursor cachingCursor;
        boolean z;
        Throwable th;
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        if (!this.favoritesMigrationStorage.isFavoritesMigrated()) {
            if (this.favoriteDao.getFavoritesCount() > 0) {
                Cursor selectActiveItems = this.favoriteDao.selectActiveItems();
                if (selectActiveItems instanceof CachingCursor) {
                    cachingCursor = (CachingCursor) selectActiveItems;
                } else {
                    cachingCursor = new CachingCursor(selectActiveItems);
                }
                z = false;
                try {
                    ArrayList arrayList = new ArrayList(cachingCursor.getCount());
                    while (cachingCursor.moveToNext()) {
                        arrayList.add(cachingCursor.getString(AdvertsContract.AdvertColumns.SERVER_ID));
                    }
                    cachingCursor.close();
                    FavoritesSyncDao.DefaultImpls.save$default(this.favoritesSyncDao, i.asReversed(arrayList), false, 2, (Object) null);
                } catch (Exception e) {
                    try {
                        cachingCursor.close();
                    } catch (Exception unused) {
                    }
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
            this.favoritesMigrationStorage.setFavoritesMigrated();
        }
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}

package com.avito.android.db;

import a2.a.a.i0.a;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.VisibleForTesting;
import com.avito.android.db.favorites.FavoriteAdvertsContract;
import com.avito.android.db.favorites.FavoritesSyncContract;
import com.avito.android.db.login_suggests.LoginSuggestsContract;
import com.avito.android.db.messenger.pending.ImageSendMessageRequestPayloadTable;
import com.avito.android.db.messenger.pending.SendMessageRequestTable;
import com.avito.android.db.photo.PhotoContract;
import com.avito.android.db.preferences.SharedPreferencesTable;
import com.avito.android.db.viewed.ViewedAdvertsContract;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.facebook.appevents.UserDataStore;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cB;\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ'\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019¨\u0006#"}, d2 = {"Lcom/avito/android/db/DbHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteDatabase;", UserDataStore.DATE_OF_BIRTH, "", "onConfigure", "(Landroid/database/sqlite/SQLiteDatabase;)V", "onCreate", "getWritableDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "getReadableDatabase", "", "oldVersion", "newVersion", "onUpgrade", "(Landroid/database/sqlite/SQLiteDatabase;II)V", "onDowngrade", "close", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/BuildInfo;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/BuildInfo;)V", "", "name", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "factory", "version", "(Landroid/content/Context;Lcom/avito/android/util/BuildInfo;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class DbHelper extends SQLiteOpenHelper {
    public final Context a;
    public final BuildInfo b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DbHelper(@NotNull Context context, @NotNull BuildInfo buildInfo) {
        super(context, "avito_data.db", (SQLiteDatabase.CursorFactory) null, 39);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = context;
        this.b = buildInfo;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (this.b.isDebug() && !new DbMigrationHelper(this.a, sQLiteDatabase).isCorrect(39)) {
            throw new IllegalStateException("You forgot to upgrade db correctly: probably you need to add migration script!".toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @NotNull
    public SQLiteDatabase getReadableDatabase() {
        try {
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            Intrinsics.checkNotNullExpressionValue(readableDatabase, "super.getReadableDatabase()");
            return readableDatabase;
        } catch (a e) {
            Logs.error("Downgrade is not support", e);
            File databasePath = this.a.getDatabasePath(getDatabaseName());
            Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(databaseName)");
            DbHelperKt.access$deleteSafely(databasePath);
            SQLiteDatabase readableDatabase2 = super.getReadableDatabase();
            Intrinsics.checkNotNullExpressionValue(readableDatabase2, "super.getReadableDatabase()");
            return readableDatabase2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @NotNull
    public SQLiteDatabase getWritableDatabase() {
        try {
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(writableDatabase, "super.getWritableDatabase()");
            return writableDatabase;
        } catch (a e) {
            Logs.error("Downgrade is not support", e);
            File databasePath = this.a.getDatabasePath(getDatabaseName());
            Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(databaseName)");
            DbHelperKt.access$deleteSafely(databasePath);
            SQLiteDatabase writableDatabase2 = super.getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(writableDatabase2, "super.getWritableDatabase()");
            return writableDatabase2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        Logs.info$default("DbHelper", "Creating database", null, 4, null);
        a(sQLiteDatabase);
        sQLiteDatabase.execSQL(FavoritesContract.getCreateSql());
        sQLiteDatabase.execSQL(MyAdvertsContract.getCreateSql());
        sQLiteDatabase.execSQL(SavedSearchesContract.getCreateSql());
        sQLiteDatabase.execSQL(SearchSubscriptionsContract.getCreateSql());
        sQLiteDatabase.execSQL(new FavoritesSyncContract().createSql());
        sQLiteDatabase.execSQL(new FavoriteAdvertsContract().createSql());
        sQLiteDatabase.execSQL(new PhotoContract().createSql());
        sQLiteDatabase.execSQL(new SendMessageRequestTable().createSql());
        sQLiteDatabase.execSQL(new ImageSendMessageRequestPayloadTable().createSql());
        sQLiteDatabase.execSQL(new SharedPreferencesTable().getCREATE_TABLE());
        sQLiteDatabase.execSQL(new ViewedAdvertsContract().createSql());
        sQLiteDatabase.execSQL(new LoginSuggestsContract().createSql());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        throw new a(a2.b.a.a.a.R2("Database downgrade is not supported. Requested downgrade from ", i, " to ", i2));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        Logs.info$default("DbHelper", "Upgrading from version " + i + " to " + i2, null, 4, null);
        a(sQLiteDatabase);
        new DbMigrationHelper(this.a, sQLiteDatabase).migrate(i, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DbHelper(Context context, BuildInfo buildInfo, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, int i2, j jVar) {
        this(context, buildInfo, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : cursorFactory, (i2 & 16) != 0 ? 39 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting(otherwise = 2)
    public DbHelper(@NotNull Context context, @NotNull BuildInfo buildInfo, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = context;
        this.b = buildInfo;
    }
}

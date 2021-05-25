package com.avito.android.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import com.avito.android.db.AdvertsContract;
import com.avito.android.db.SavedSearchesContract;
import com.avito.android.db.SearchSubscriptionsContract;
import com.avito.android.db.favorites.FavoriteAdvertsContract;
import com.avito.android.db.favorites.FavoritesSyncContract;
import com.avito.android.db.login_suggests.LoginSuggestsContract;
import com.avito.android.db.messenger.pending.ImageSendMessageRequestPayloadTable;
import com.avito.android.db.messenger.pending.SendMessageRequestTable;
import com.avito.android.db.photo.PhotoContract;
import com.avito.android.db.preferences.SharedPreferencesTable;
import com.avito.android.db.viewed.ViewedAdvertsContract;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SQLiteDatabasesKt;
import com.avito.android.util.preferences.DbPreferencesMigrator;
import com.avito.android.util.preferences.PreferenceFactoryImpl;
import com.avito.android.util.preferences.SharedPreferencesMigrator;
import com.facebook.appevents.UserDataStore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/db/DbMigrationHelper;", "", "", "oldVersion", "newVersion", "", "migrate", "(II)V", "dbVersion", "", "isCorrect", "(I)Z", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "", "Lkotlin/Function0;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "tasks", "Landroid/database/sqlite/SQLiteDatabase;", "c", "Landroid/database/sqlite/SQLiteDatabase;", UserDataStore.DATE_OF_BIRTH, "<init>", "(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class DbMigrationHelper {
    public final Map<Integer, Function0<Unit>> a = r.mapOf(TuplesKt.to(1, a.e), TuplesKt.to(2, new b(13, this)), TuplesKt.to(3, new b(19, this)), TuplesKt.to(4, new b(20, this)), TuplesKt.to(5, a.n), TuplesKt.to(6, new b(21, this)), TuplesKt.to(7, new b(22, this)), TuplesKt.to(8, new b(23, this)), TuplesKt.to(9, new b(24, this)), TuplesKt.to(10, new b(0, this)), TuplesKt.to(11, new b(1, this)), TuplesKt.to(12, new b(2, this)), TuplesKt.to(13, new b(3, this)), TuplesKt.to(14, a.b), TuplesKt.to(15, a.c), TuplesKt.to(16, new b(4, this)), TuplesKt.to(17, new b(5, this)), TuplesKt.to(18, new b(6, this)), TuplesKt.to(19, a.d), TuplesKt.to(20, new b(7, this)), TuplesKt.to(21, new b(8, this)), TuplesKt.to(22, new b(9, this)), TuplesKt.to(23, a.f), TuplesKt.to(24, new b(10, this)), TuplesKt.to(25, new b(11, this)), TuplesKt.to(26, a.g), TuplesKt.to(27, a.h), TuplesKt.to(28, new b(12, this)), TuplesKt.to(29, a.i), TuplesKt.to(30, a.j), TuplesKt.to(31, new b(14, this)), TuplesKt.to(32, new b(15, this)), TuplesKt.to(33, a.k), TuplesKt.to(34, new b(16, this)), TuplesKt.to(35, new b(17, this)), TuplesKt.to(36, a.l), TuplesKt.to(37, a.m), TuplesKt.to(38, new b(18, this)));
    public final Context b;
    public final SQLiteDatabase c;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public static final a f = new a(4);
        public static final a g = new a(5);
        public static final a h = new a(6);
        public static final a i = new a(7);
        public static final a j = new a(8);
        public static final a k = new a(9);
        public static final a l = new a(10);
        public static final a m = new a(11);
        public static final a n = new a(12);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(0);
            this.a = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            switch (this.a) {
                case 0:
                    return Unit.INSTANCE;
                case 1:
                    return Unit.INSTANCE;
                case 2:
                    return Unit.INSTANCE;
                case 3:
                    return Unit.INSTANCE;
                case 4:
                    return Unit.INSTANCE;
                case 5:
                    return Unit.INSTANCE;
                case 6:
                    return Unit.INSTANCE;
                case 7:
                    return Unit.INSTANCE;
                case 8:
                    return Unit.INSTANCE;
                case 9:
                    return Unit.INSTANCE;
                case 10:
                    return Unit.INSTANCE;
                case 11:
                    return Unit.INSTANCE;
                case 12:
                    return Unit.INSTANCE;
                default:
                    throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            switch (this.a) {
                case 0:
                    DbMigrationHelper.access$createSharedPreferencesTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 1:
                    DbMigrationHelper.access$createViewedAdvertsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 2:
                    DbMigrationHelper.access$migrateSharedPreferences((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 3:
                    DbMigrationHelper.access$deleteOldPhotoTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 4:
                    DbMigrationHelper.access$createNoteColumnToFavoritesAdvertsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 5:
                    DbMigrationHelper.access$createShopNameColumnInFavoritesAdvertsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 6:
                    DbMigrationHelper.access$createLoginSuggestsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 7:
                    DbMigrationHelper.access$addSsidColumnInSearchSubscriptions((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 8:
                    DbMigrationHelper.access$migrateDbSharedPreferences((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 9:
                    DbMigrationHelper.access$removeSuggestsSharedPreferences((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 10:
                    DbMigrationHelper.access$addDeepLinkToFavorites((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 11:
                    DbMigrationHelper.access$addSourceUriToPhotoTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 12:
                    DbMigrationHelper.access$addStatusToFavorites((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 13:
                    DbMigrationHelper.access$migrateFavoritesFrom2to3((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 14:
                    DbMigrationHelper.access$addFieldsForRedesignToFavorites((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 15:
                    DbMigrationHelper.access$addSocialIdToLoginSuggests((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 16:
                    DbMigrationHelper.access$addPriceWithoutDiscountToFavorites((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 17:
                    DbMigrationHelper.access$deleteLocalDraftsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 18:
                    DbMigrationHelper.access$deleteLocalRecentSearchTableIfExists((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 19:
                    DbMigrationHelper.access$migrateSavedSearchesFrom3to4((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 20:
                    DbMigrationHelper.access$createSearchSubscriptionsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 21:
                    DbMigrationHelper.access$createFavoritesSyncTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 22:
                    DbMigrationHelper.access$createFavoritesAdvertsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 23:
                    DbMigrationHelper.access$createPhotosTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                case 24:
                    DbMigrationHelper.access$createSendMessageRequestsTable((DbMigrationHelper) this.b);
                    return Unit.INSTANCE;
                default:
                    throw null;
            }
        }
    }

    public DbMigrationHelper(@NotNull Context context, @NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.b = context;
        this.c = sQLiteDatabase;
    }

    public static final void access$addDeepLinkToFavorites(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        FavoriteAdvertsContract favoriteAdvertsContract = new FavoriteAdvertsContract();
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, favoriteAdvertsContract.getTABLE_NAME(), favoriteAdvertsContract.getDEEP_LINK())) {
            SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
            StringBuilder L = a2.b.a.a.a.L("ALTER TABLE ");
            L.append(favoriteAdvertsContract.getTABLE_NAME());
            L.append(" ADD COLUMN ");
            L.append(favoriteAdvertsContract.getDEEP_LINK());
            L.append(" TEXT");
            sQLiteDatabase.execSQL(L.toString());
            SQLiteDatabase sQLiteDatabase2 = dbMigrationHelper.c;
            StringBuilder L2 = a2.b.a.a.a.L("UPDATE ");
            L2.append(favoriteAdvertsContract.getTABLE_NAME());
            L2.append(" SET ");
            L2.append(favoriteAdvertsContract.getDEEP_LINK());
            L2.append(" = 'ru.avito://1/item/show?itemId=' || ");
            L2.append(favoriteAdvertsContract.getADVERT_ID());
            sQLiteDatabase2.execSQL(L2.toString());
        }
    }

    public static final void access$addFieldsForRedesignToFavorites(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        FavoriteAdvertsContract favoriteAdvertsContract = new FavoriteAdvertsContract();
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, favoriteAdvertsContract.getTABLE_NAME(), favoriteAdvertsContract.getPREVIOUS_PRICE())) {
            SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
            StringBuilder L = a2.b.a.a.a.L("ALTER TABLE ");
            L.append(favoriteAdvertsContract.getTABLE_NAME());
            L.append(" ADD COLUMN ");
            L.append(favoriteAdvertsContract.getPREVIOUS_PRICE());
            L.append(" TEXT");
            sQLiteDatabase.execSQL(L.toString());
            SQLiteDatabase sQLiteDatabase2 = dbMigrationHelper.c;
            StringBuilder L2 = a2.b.a.a.a.L("ALTER TABLE ");
            L2.append(favoriteAdvertsContract.getTABLE_NAME());
            L2.append(" ADD COLUMN ");
            L2.append(favoriteAdvertsContract.getADDRESS());
            L2.append(" TEXT");
            sQLiteDatabase2.execSQL(L2.toString());
            SQLiteDatabase sQLiteDatabase3 = dbMigrationHelper.c;
            StringBuilder L3 = a2.b.a.a.a.L("ALTER TABLE ");
            L3.append(favoriteAdvertsContract.getTABLE_NAME());
            L3.append(" ADD COLUMN ");
            L3.append(favoriteAdvertsContract.getNEW_LOCATION());
            L3.append(" TEXT");
            sQLiteDatabase3.execSQL(L3.toString());
            SQLiteDatabase sQLiteDatabase4 = dbMigrationHelper.c;
            StringBuilder L4 = a2.b.a.a.a.L("ALTER TABLE ");
            L4.append(favoriteAdvertsContract.getTABLE_NAME());
            L4.append(" ADD COLUMN ");
            L4.append(favoriteAdvertsContract.getIS_DELIVERABLE());
            L4.append(" INTEGER");
            sQLiteDatabase4.execSQL(L4.toString());
            SQLiteDatabase sQLiteDatabase5 = dbMigrationHelper.c;
            StringBuilder L5 = a2.b.a.a.a.L("ALTER TABLE ");
            L5.append(favoriteAdvertsContract.getTABLE_NAME());
            L5.append(" ADD COLUMN ");
            L5.append(favoriteAdvertsContract.getSTATUS_DESCRIPTION());
            L5.append(" TEXT");
            sQLiteDatabase5.execSQL(L5.toString());
        }
    }

    public static final void access$addPriceWithoutDiscountToFavorites(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        FavoriteAdvertsContract favoriteAdvertsContract = new FavoriteAdvertsContract();
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, favoriteAdvertsContract.getTABLE_NAME(), favoriteAdvertsContract.getPRICE_WITHOUT_DISCOUNT())) {
            SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
            StringBuilder L = a2.b.a.a.a.L("ALTER TABLE ");
            L.append(favoriteAdvertsContract.getTABLE_NAME());
            L.append(" ADD COLUMN ");
            L.append(favoriteAdvertsContract.getPRICE_WITHOUT_DISCOUNT());
            L.append(" TEXT");
            sQLiteDatabase.execSQL(L.toString());
        }
    }

    public static final void access$addSocialIdToLoginSuggests(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        LoginSuggestsContract loginSuggestsContract = new LoginSuggestsContract();
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, loginSuggestsContract.getTABLE_NAME(), loginSuggestsContract.getSOCIAL_ID())) {
            SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
            StringBuilder L = a2.b.a.a.a.L("ALTER TABLE ");
            L.append(loginSuggestsContract.getTABLE_NAME());
            L.append(" ADD COLUMN ");
            L.append(loginSuggestsContract.getSOCIAL_ID());
            L.append(" TEXT");
            sQLiteDatabase.execSQL(L.toString());
        }
    }

    public static final void access$addSourceUriToPhotoTable(DbMigrationHelper dbMigrationHelper) {
        SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
        String str = PhotoContract.TABLE_NAME;
        String str2 = PhotoContract.SOURCE_URI;
        if (!SQLiteDatabasesKt.hasColumn(sQLiteDatabase, str, str2)) {
            dbMigrationHelper.c.execSQL(a2.b.a.a.a.f("ALTER TABLE ", str, " ADD COLUMN ", str2, " TEXT"));
        }
    }

    public static final void access$addSsidColumnInSearchSubscriptions(DbMigrationHelper dbMigrationHelper) {
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, SearchSubscriptionsContract.TABLE_NAME, SearchSubscriptionsContract.Columns.SSID)) {
            dbMigrationHelper.c.execSQL("ALTER TABLE search_subscriptions ADD COLUMN ssid TEXT");
        }
    }

    public static final void access$addStatusToFavorites(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        FavoriteAdvertsContract favoriteAdvertsContract = new FavoriteAdvertsContract();
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, favoriteAdvertsContract.getTABLE_NAME(), favoriteAdvertsContract.getSTATUS())) {
            SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
            StringBuilder L = a2.b.a.a.a.L("ALTER TABLE ");
            L.append(favoriteAdvertsContract.getTABLE_NAME());
            L.append(" ADD COLUMN ");
            L.append(favoriteAdvertsContract.getSTATUS());
            L.append(" TEXT");
            sQLiteDatabase.execSQL(L.toString());
        }
    }

    public static final void access$createFavoritesAdvertsTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(new FavoriteAdvertsContract().createSql());
    }

    public static final void access$createFavoritesSyncTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(new FavoritesSyncContract().createSql());
    }

    public static final void access$createLoginSuggestsTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(new LoginSuggestsContract().createSql());
    }

    public static final void access$createNoteColumnToFavoritesAdvertsTable(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        FavoriteAdvertsContract favoriteAdvertsContract = new FavoriteAdvertsContract();
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, favoriteAdvertsContract.getTABLE_NAME(), favoriteAdvertsContract.getNOTE())) {
            SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
            StringBuilder L = a2.b.a.a.a.L("ALTER TABLE ");
            L.append(favoriteAdvertsContract.getTABLE_NAME());
            L.append(" ADD COLUMN ");
            L.append(favoriteAdvertsContract.getNOTE());
            L.append(" TEXT");
            sQLiteDatabase.execSQL(L.toString());
        }
    }

    public static final void access$createPhotosTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(new PhotoContract().createSql());
    }

    public static final void access$createSearchSubscriptionsTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(SearchSubscriptionsContract.getCreateSql());
    }

    public static final void access$createSendMessageRequestsTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(new SendMessageRequestTable().createSql());
        dbMigrationHelper.c.execSQL(new ImageSendMessageRequestPayloadTable().createSql());
    }

    public static final void access$createSharedPreferencesTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(new SharedPreferencesTable().getCREATE_TABLE());
    }

    public static final void access$createShopNameColumnInFavoritesAdvertsTable(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        FavoriteAdvertsContract favoriteAdvertsContract = new FavoriteAdvertsContract();
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, favoriteAdvertsContract.getTABLE_NAME(), favoriteAdvertsContract.getSHOP_NAME())) {
            SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
            StringBuilder L = a2.b.a.a.a.L("ALTER TABLE ");
            L.append(favoriteAdvertsContract.getTABLE_NAME());
            L.append(" ADD COLUMN ");
            L.append(favoriteAdvertsContract.getSHOP_NAME());
            L.append(" TEXT");
            sQLiteDatabase.execSQL(L.toString());
        }
    }

    public static final void access$createViewedAdvertsTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL(new ViewedAdvertsContract().createSql());
    }

    public static final void access$deleteLocalDraftsTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL("DROP TABLE IF EXISTS publish_drafts");
        dbMigrationHelper.c.execSQL("DROP TABLE IF EXISTS publish_drafts_values");
    }

    public static final void access$deleteLocalRecentSearchTableIfExists(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL("DROP TABLE IF EXISTS recentSearch");
    }

    public static final void access$deleteOldPhotoTable(DbMigrationHelper dbMigrationHelper) {
        dbMigrationHelper.c.execSQL("DROP TABLE IF EXISTS photo");
    }

    public static final void access$migrateDbSharedPreferences(DbMigrationHelper dbMigrationHelper) {
        Context context = dbMigrationHelper.b;
        SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().create()");
        new SharedPreferencesMigrator(context, sQLiteDatabase, create, new PreferenceFactoryImpl()).migrate();
    }

    public static final void access$migrateFavoritesFrom2to3(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        ArrayList arrayList = new ArrayList();
        Cursor query = dbMigrationHelper.c.query(FavoritesContract.TABLE_NAME, null, null, null, null, null, AdvertsContract.TIMESTAMP_DESC);
        while (query.moveToNext()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("timestamp", Integer.valueOf(query.getColumnIndex("timestamp")));
            contentValues.put(AdvertsContract.AdvertColumns.SERVER_ID, query.getString(query.getColumnIndex(AdvertsContract.AdvertColumns.SERVER_ID)));
            contentValues.put("category_id", query.getString(query.getColumnIndex("category_id")));
            contentValues.put("title", query.getString(query.getColumnIndex("title")));
            String string = query.getString(query.getColumnIndex("price"));
            if (!TextUtils.isEmpty(string)) {
                contentValues.put("price", string);
            }
            contentValues.put("location_name", query.getString(query.getColumnIndex("location_name")));
            contentValues.put(AdvertsContract.AdvertColumns.METRO_NAME, query.getString(query.getColumnIndex(AdvertsContract.AdvertColumns.METRO_NAME)));
            contentValues.put("image_url", query.getString(query.getColumnIndex("image_url")));
            contentValues.put("status", query.getString(query.getColumnIndex("status")));
            contentValues.put("time", Long.valueOf(query.getLong(query.getColumnIndex("time"))));
            arrayList.add(contentValues);
        }
        query.close();
        DbUtils.dropTable(dbMigrationHelper.c, FavoritesContract.TABLE_NAME);
        dbMigrationHelper.c.execSQL("CREATE TABLE IF NOT EXISTS favorites (_id INTEGER PRIMARY KEY AUTOINCREMENT,timestamp INTEGER,server_id TEXT,category_id TEXT,title TEXT,price TEXT,location_name TEXT,metro_name TEXT,image_url TEXT,status TEXT,time INTEGER,page INTEGER DEFAULT 0,sync_flag INTEGER DEFAULT 0,marked_for_remove INTEGER DEFAULT 0)");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            dbMigrationHelper.c.insert(FavoritesContract.TABLE_NAME, null, (ContentValues) it.next());
        }
    }

    public static final void access$migrateSavedSearchesFrom3to4(DbMigrationHelper dbMigrationHelper) {
        if (!SQLiteDatabasesKt.hasColumn(dbMigrationHelper.c, SavedSearchesContract.TABLE_NAME, SavedSearchesContract.Columns.HAS_UNREAD_CHANGES)) {
            dbMigrationHelper.c.execSQL("ALTER TABLE saved_searches ADD COLUMN has_unread_changes INTEGER DEFAULT 0");
        }
    }

    public static final void access$migrateSharedPreferences(DbMigrationHelper dbMigrationHelper) {
        Context context = dbMigrationHelper.b;
        SQLiteDatabase sQLiteDatabase = dbMigrationHelper.c;
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().create()");
        new DbPreferencesMigrator(context, sQLiteDatabase, create, new PreferenceFactoryImpl()).migrate();
    }

    public static final void access$removeSuggestsSharedPreferences(DbMigrationHelper dbMigrationHelper) {
        Objects.requireNonNull(dbMigrationHelper);
        PreferenceFactoryImpl preferenceFactoryImpl = new PreferenceFactoryImpl();
        if (Build.VERSION.SDK_INT >= 24) {
            Context context = dbMigrationHelper.b;
            context.deleteSharedPreferences(preferenceFactoryImpl.getCustomPreferencesName(context, "suggests"));
            return;
        }
        preferenceFactoryImpl.getCustomPreferences(dbMigrationHelper.b, "suggests").getSharedPreferences().edit().clear().apply();
    }

    public final boolean isCorrect(int i) {
        int i2 = i - 1;
        return this.a.size() == i2 && this.a.get(Integer.valueOf(i2)) != null;
    }

    public final void migrate(int i, int i2) {
        while (i < i2) {
            Function0<Unit> function0 = this.a.get(Integer.valueOf(i));
            if (function0 != null) {
                function0.invoke();
            }
            i++;
        }
    }
}

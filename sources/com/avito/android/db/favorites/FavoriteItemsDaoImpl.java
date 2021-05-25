package com.avito.android.db.favorites;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.avito.android.db.BaseDao;
import com.avito.android.db.CachingCursor;
import com.avito.android.db.DbHelper;
import com.avito.android.db.DbLock;
import com.avito.android.db.DbUtils;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite.FavoriteModel;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseableDataSource;
import com.avito.android.remote.model.CursorDataSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.GsonsKt;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.gson.Gson;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB'\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b*\u0010+J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\r\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/db/favorites/FavoriteItemsDaoImpl;", "Lcom/avito/android/db/favorites/FavoriteItemsDao;", "Lcom/avito/android/db/BaseDao;", "", "Lcom/avito/android/favorite/FavoriteModel;", "items", "", "save", "(Ljava/util/List;)V", "item", "(Lcom/avito/android/favorite/FavoriteModel;)V", "", "id", ProductAction.ACTION_REMOVE, "(Ljava/lang/String;)V", "ids", "wipe", "()V", "wipeAndSave", "getInactiveIds", "()Ljava/util/List;", "Lcom/avito/android/remote/model/CloseableDataSource;", "getAdvertsDataSource", "()Lcom/avito/android/remote/model/CloseableDataSource;", "Landroid/content/ContentValues;", "contentValues", AuthSource.SEND_ABUSE, "(Lcom/avito/android/favorite/FavoriteModel;Landroid/content/ContentValues;)Landroid/content/ContentValues;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "d", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/db/DbLock;", "c", "Lcom/avito/android/db/DbLock;", "lock", "Lcom/google/gson/Gson;", AuthSource.BOOKING_ORDER, "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/db/DbHelper;", "dbHelper", "<init>", "(Lcom/avito/android/db/DbHelper;Lcom/google/gson/Gson;Lcom/avito/android/db/DbLock;Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "favorite_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteItemsDaoImpl extends BaseDao implements FavoriteItemsDao {
    public final Gson b;
    public final DbLock c;
    public final DeepLinkFactory d;

    public static final class a implements CursorDataSource.CursorDataRetriever<FavoriteModel> {
        public final Gson a;
        public final DeepLinkFactory b;

        public a(@NotNull Gson gson, @NotNull DeepLinkFactory deepLinkFactory) {
            Intrinsics.checkNotNullParameter(gson, "gson");
            Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
            this.a = gson;
            this.b = deepLinkFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.avito.android.remote.model.CursorDataSource.CursorDataRetriever
        public FavoriteModel retrieve(Cursor cursor) {
            CachingCursor cachingCursor;
            Image image;
            Type type;
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            if (cursor instanceof CachingCursor) {
                cachingCursor = (CachingCursor) cursor;
            } else {
                cachingCursor = new CachingCursor(cursor);
            }
            String string = cachingCursor.getString(FavoriteItemsDaoKt.a.getADVERT_ID());
            String stringOrNull = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getTITLE());
            if (stringOrNull == null) {
                stringOrNull = "";
            }
            String stringOrNull2 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getPRICE());
            String stringOrNull3 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getPRICE_WITHOUT_DISCOUNT());
            String stringOrNull4 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getLOCATION());
            String stringOrNull5 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getSUBLOCATION());
            String stringOrNull6 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getCATEGORY());
            long j = cachingCursor.getLong(FavoriteItemsDaoKt.a.getTIME());
            boolean z = cachingCursor.getBoolean(FavoriteItemsDaoKt.a.getACTIVE());
            String stringOrNull7 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getIMAGE());
            if (stringOrNull7 != null) {
                Gson gson = this.a;
                Type type2 = new FavoriteItemsDaoImpl$FavoriteItemDataRetriever$$special$$inlined$fromJson$1().getType();
                Intrinsics.checkNotNullExpressionValue(type2, "object : TypeToken<T>() {}.type");
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    if (GsonsKt.isWildcard(parameterizedType)) {
                        type = parameterizedType.getRawType();
                        Intrinsics.checkNotNullExpressionValue(type, "type.rawType");
                        Object fromJson = gson.fromJson(stringOrNull7, type);
                        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                        image = (Image) fromJson;
                    }
                }
                type = GsonsKt.removeTypeWildcards(type2);
                Object fromJson = gson.fromJson(stringOrNull7, type);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(json, typeToken<T>())");
                image = (Image) fromJson;
            } else {
                image = null;
            }
            boolean z2 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.c.getADDED_TIME()) != null;
            String stringOrNull8 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getSHOP_NAME());
            String stringOrNull9 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getNOTE());
            String stringOrNull10 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getDEEP_LINK());
            DeepLink createFromUri = stringOrNull10 != null ? this.b.createFromUri(stringOrNull10) : null;
            String stringOrNull11 = cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getSTATUS());
            return new FavoriteModel(string, stringOrNull, stringOrNull2, stringOrNull3, stringOrNull4, stringOrNull5, j, z, image, stringOrNull6, stringOrNull9, stringOrNull8, createFromUri, z2, stringOrNull11 != null ? FavoriteModel.Status.valueOf(stringOrNull11) : null, cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getPREVIOUS_PRICE()), cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getADDRESS()), cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getNEW_LOCATION()), cachingCursor.getInt(FavoriteItemsDaoKt.a.getIS_DELIVERABLE()) == 1, cachingCursor.getStringOrNull(FavoriteItemsDaoKt.a.getSTATUS_DESCRIPTION()));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavoriteItemsDaoImpl(@NotNull DbHelper dbHelper, @NotNull Gson gson, @NotNull DbLock dbLock, @NotNull DeepLinkFactory deepLinkFactory) {
        super(dbHelper);
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(dbLock, "lock");
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        this.b = gson;
        this.c = dbLock;
        this.d = deepLinkFactory;
    }

    public static final void access$saveInternal(FavoriteItemsDaoImpl favoriteItemsDaoImpl, SQLiteDatabase sQLiteDatabase, List list) {
        Objects.requireNonNull(favoriteItemsDaoImpl);
        ContentValues contentValues = new ContentValues();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            contentValues.clear();
            favoriteItemsDaoImpl.a((FavoriteModel) it.next(), contentValues);
            sQLiteDatabase.insert(FavoriteItemsDaoKt.a.getTABLE_NAME(), null, contentValues);
        }
    }

    public static final void access$wipeInternal(FavoriteItemsDaoImpl favoriteItemsDaoImpl, SQLiteDatabase sQLiteDatabase) {
        Objects.requireNonNull(favoriteItemsDaoImpl);
        DbUtils.deleteTable(sQLiteDatabase, FavoriteItemsDaoKt.a.getTABLE_NAME());
    }

    public final ContentValues a(FavoriteModel favoriteModel, ContentValues contentValues) {
        contentValues.put(FavoriteItemsDaoKt.a.getADVERT_ID(), favoriteModel.getAdvertId());
        contentValues.put(FavoriteItemsDaoKt.a.getTITLE(), favoriteModel.getTitle());
        contentValues.put(FavoriteItemsDaoKt.a.getPRICE(), favoriteModel.getPrice());
        contentValues.put(FavoriteItemsDaoKt.a.getLOCATION(), favoriteModel.getOldLocation());
        contentValues.put(FavoriteItemsDaoKt.a.getSUBLOCATION(), favoriteModel.getSublocation());
        contentValues.put(FavoriteItemsDaoKt.a.getTIME(), Long.valueOf(favoriteModel.getTime()));
        contentValues.put(FavoriteItemsDaoKt.a.getCATEGORY(), favoriteModel.getCategoryName());
        contentValues.put(FavoriteItemsDaoKt.a.getACTIVE(), Boolean.valueOf(favoriteModel.getActive()));
        String image = FavoriteItemsDaoKt.a.getIMAGE();
        Image image2 = favoriteModel.getImage();
        String str = null;
        contentValues.put(image, image2 != null ? this.b.toJson(image2) : null);
        contentValues.put(FavoriteItemsDaoKt.a.getNOTE(), favoriteModel.getNote());
        contentValues.put(FavoriteItemsDaoKt.a.getSHOP_NAME(), favoriteModel.getShopName());
        String deep_link = FavoriteItemsDaoKt.a.getDEEP_LINK();
        DeepLink deepLink = favoriteModel.getDeepLink();
        if (!(deepLink instanceof AdvertDetailsLink)) {
            deepLink = null;
        }
        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
        contentValues.put(deep_link, advertDetailsLink != null ? advertDetailsLink.toString() : null);
        String status = FavoriteItemsDaoKt.a.getSTATUS();
        FavoriteModel.Status status2 = favoriteModel.getStatus();
        if (status2 != null) {
            str = status2.toString();
        }
        contentValues.put(status, str);
        contentValues.put(FavoriteItemsDaoKt.a.getPREVIOUS_PRICE(), favoriteModel.getPreviousPrice());
        contentValues.put(FavoriteItemsDaoKt.a.getADDRESS(), favoriteModel.getAddress());
        contentValues.put(FavoriteItemsDaoKt.a.getNEW_LOCATION(), favoriteModel.getLocation());
        contentValues.put(FavoriteItemsDaoKt.a.getIS_DELIVERABLE(), Integer.valueOf(favoriteModel.isDeliverable() ? 1 : 0));
        contentValues.put(FavoriteItemsDaoKt.a.getSTATUS_DESCRIPTION(), favoriteModel.getStatusDescription());
        contentValues.put(FavoriteItemsDaoKt.a.getPRICE_WITHOUT_DISCOUNT(), favoriteModel.getPriceWithoutDiscount());
        return contentValues;
    }

    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    @NotNull
    public CloseableDataSource<FavoriteModel> getAdvertsDataSource() {
        CursorDataSource cursorDataSource;
        synchronized (this.c) {
            Cursor query = getReadableDatabase().query("\n                " + FavoriteItemsDaoKt.a.getTABLE_NAME() + "\n                INNER JOIN " + FavoriteItemsDaoKt.b.getTABLE_NAME() + "\n                    ON " + FavoriteItemsDaoKt.a.getTABLE_NAME() + FormatterType.defaultDecimalSeparator + FavoriteItemsDaoKt.a.getADVERT_ID() + " == " + FavoriteItemsDaoKt.b.getTABLE_NAME() + FormatterType.defaultDecimalSeparator + FavoriteItemsDaoKt.b.getENTITY_ID() + "\n                LEFT JOIN " + FavoriteItemsDaoKt.c.getTABLE_NAME() + "\n                    ON " + FavoriteItemsDaoKt.a.getTABLE_NAME() + FormatterType.defaultDecimalSeparator + FavoriteItemsDaoKt.a.getADVERT_ID() + " == " + FavoriteItemsDaoKt.c.getTABLE_NAME() + FormatterType.defaultDecimalSeparator + FavoriteItemsDaoKt.c.getADVERT_ID() + "\n                ", new String[]{FavoriteItemsDaoKt.a.getTABLE_NAME() + FormatterType.defaultDecimalSeparator + FavoriteItemsDaoKt.a.getADVERT_ID(), FavoriteItemsDaoKt.a.getTITLE(), FavoriteItemsDaoKt.a.getCATEGORY(), FavoriteItemsDaoKt.a.getIMAGE(), FavoriteItemsDaoKt.a.getTIME(), FavoriteItemsDaoKt.a.getACTIVE(), FavoriteItemsDaoKt.a.getLOCATION(), FavoriteItemsDaoKt.a.getSUBLOCATION(), FavoriteItemsDaoKt.a.getPRICE(), FavoriteItemsDaoKt.a.getPRICE_WITHOUT_DISCOUNT(), FavoriteItemsDaoKt.c.getADDED_TIME(), FavoriteItemsDaoKt.a.getNOTE(), FavoriteItemsDaoKt.a.getSHOP_NAME(), FavoriteItemsDaoKt.a.getDEEP_LINK(), FavoriteItemsDaoKt.a.getSTATUS(), FavoriteItemsDaoKt.a.getPREVIOUS_PRICE(), FavoriteItemsDaoKt.a.getADDRESS(), FavoriteItemsDaoKt.a.getNEW_LOCATION(), FavoriteItemsDaoKt.a.getIS_DELIVERABLE(), FavoriteItemsDaoKt.a.getSTATUS_DESCRIPTION()}, FavoriteItemsDaoKt.b.getTABLE_NAME() + FormatterType.defaultDecimalSeparator + FavoriteItemsDaoKt.b.getMARKED_FOR_REMOVE() + " <> ?", new String[]{"1"}, null, null, FavoriteItemsDaoKt.a.getTABLE_NAME() + FormatterType.defaultDecimalSeparator + FavoriteItemsDaoKt.a.getID() + " DESC");
            Intrinsics.checkNotNullExpressionValue(query, "cursor");
            cursorDataSource = new CursorDataSource(query, new a(this.b, this.d));
        }
        return cursorDataSource;
    }

    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    @NotNull
    public List<String> getInactiveIds() {
        boolean z;
        CachingCursor cachingCursor;
        Throwable th;
        ArrayList arrayList;
        synchronized (this.c) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String table_name = FavoriteItemsDaoKt.a.getTABLE_NAME();
            z = true;
            String[] strArr = {FavoriteItemsDaoKt.a.getADVERT_ID()};
            Cursor query = readableDatabase.query(table_name, strArr, FavoriteItemsDaoKt.a.getACTIVE() + " = ?", new String[]{"0"}, null, null, null);
            Intrinsics.checkNotNullExpressionValue(query, "it.query(\n              …       null\n            )");
            if (query instanceof CachingCursor) {
                cachingCursor = (CachingCursor) query;
            } else {
                cachingCursor = new CachingCursor(query);
            }
            try {
                arrayList = new ArrayList(cachingCursor.getCount());
                while (cachingCursor.moveToNext()) {
                    arrayList.add(cachingCursor.getString(FavoriteItemsDaoKt.a.getADVERT_ID()));
                }
                cachingCursor.close();
            } catch (Exception e) {
                try {
                    cachingCursor.close();
                } catch (Exception unused) {
                }
                throw e;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return arrayList;
        if (!z) {
            cachingCursor.close();
        }
        throw th;
    }

    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    public void remove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        synchronized (this.c) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String table_name = FavoriteItemsDaoKt.a.getTABLE_NAME();
            writableDatabase.delete(table_name, FavoriteItemsDaoKt.a.getADVERT_ID() + " = ?", new String[]{str});
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    public void save(@NotNull List<FavoriteModel> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        synchronized (this.c) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                access$saveInternal(this, writableDatabase, list);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    public void wipe() {
        synchronized (this.c) {
            DbUtils.deleteTable(getWritableDatabase(), FavoriteItemsDaoKt.a.getTABLE_NAME());
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    public void wipeAndSave(@NotNull List<FavoriteModel> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        synchronized (this.c) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                access$wipeInternal(this, writableDatabase);
                access$saveInternal(this, writableDatabase, list);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    public void remove(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        synchronized (this.c) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    remove((String) it.next());
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
    }

    @Override // com.avito.android.db.favorites.FavoriteItemsDao
    public void save(@NotNull FavoriteModel favoriteModel) {
        Intrinsics.checkNotNullParameter(favoriteModel, "item");
        synchronized (this.c) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String table_name = FavoriteItemsDaoKt.a.getTABLE_NAME();
            ContentValues contentValues = new ContentValues();
            a(favoriteModel, contentValues);
            writableDatabase.insert(table_name, null, contentValues);
        }
    }
}

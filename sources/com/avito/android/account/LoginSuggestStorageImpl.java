package com.avito.android.account;

import android.content.ContentValues;
import android.database.Cursor;
import com.avito.android.db.CachingCursor;
import com.avito.android.db.login_suggests.LoginSuggestsContract;
import com.avito.android.db.sqlbrite.Database;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fJ\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/account/LoginSuggestStorageImpl;", "Lcom/avito/android/account/LoginSuggestStorage;", "Lcom/avito/android/account/LoginSuggest;", "loginSuggest", "", "put", "(Lcom/avito/android/account/LoginSuggest;)V", "", "get", "()Ljava/util/List;", "", "limit", "(I)Ljava/util/List;", "Landroid/database/Cursor;", "cursor", "(Landroid/database/Cursor;)Ljava/util/List;", "Lcom/avito/android/db/sqlbrite/Database;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/db/sqlbrite/Database;", "getDatabase", "()Lcom/avito/android/db/sqlbrite/Database;", "database", "Lcom/avito/android/db/login_suggests/LoginSuggestsContract;", AuthSource.SEND_ABUSE, "Lcom/avito/android/db/login_suggests/LoginSuggestsContract;", "CONTRACT", "<init>", "(Lcom/avito/android/db/sqlbrite/Database;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class LoginSuggestStorageImpl implements LoginSuggestStorage {
    public final LoginSuggestsContract a = new LoginSuggestsContract();
    @NotNull
    public final Database b;

    public LoginSuggestStorageImpl(@NotNull Database database) {
        Intrinsics.checkNotNullParameter(database, "database");
        this.b = database;
    }

    @Override // com.avito.android.account.LoginSuggestStorage
    @NotNull
    public List<LoginSuggest> get() {
        Cursor cursor = null;
        try {
            cursor = this.b.query(this.a.getSUGGESTS_QUERY(), new String[0]);
            return get(cursor);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @NotNull
    public final Database getDatabase() {
        return this.b;
    }

    @Override // com.avito.android.account.LoginSuggestStorage
    public void put(@NotNull LoginSuggest loginSuggest) {
        Intrinsics.checkNotNullParameter(loginSuggest, "loginSuggest");
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.a.getUSER_HASH_ID(), loginSuggest.getUserHashId());
        contentValues.put(this.a.getLOGIN(), loginSuggest.getLogin());
        contentValues.put(this.a.getSOCIAL(), loginSuggest.getSocial());
        contentValues.put(this.a.getSOCIAL_ID(), loginSuggest.getSocialId());
        this.b.insert(this.a.getTABLE_NAME(), contentValues);
    }

    @Override // com.avito.android.account.LoginSuggestStorage
    @NotNull
    public List<LoginSuggest> get(int i) {
        Cursor cursor = null;
        try {
            cursor = this.b.query(this.a.getSUGGESTS_QUERY_WITH_LIMIT(), String.valueOf(i));
            return get(cursor);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @NotNull
    public final List<LoginSuggest> get(@NotNull Cursor cursor) {
        CachingCursor cachingCursor;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        if (cursor.getCount() <= 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (cursor instanceof CachingCursor) {
            cachingCursor = (CachingCursor) cursor;
        } else {
            cachingCursor = new CachingCursor(cursor);
        }
        cachingCursor.moveToFirst();
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(new LoginSuggest(cachingCursor.getString(this.a.getUSER_HASH_ID()), cachingCursor.getStringOrNull(this.a.getLOGIN()), cachingCursor.getStringOrNull(this.a.getSOCIAL()), cachingCursor.getStringOrNull(this.a.getSOCIAL_ID())));
        } while (cachingCursor.moveToNext());
        return arrayList;
    }
}

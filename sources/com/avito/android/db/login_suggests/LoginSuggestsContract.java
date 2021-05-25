package com.avito.android.db.login_suggests;

import a2.b.a.a.a;
import a2.g.r.g;
import android.provider.BaseColumns;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/db/login_suggests/LoginSuggestsContract;", "Landroid/provider/BaseColumns;", "", "createSql", "()Ljava/lang/String;", g.a, "Ljava/lang/String;", "getSUGGESTS_QUERY", "SUGGESTS_QUERY", "f", "getSOCIAL_ID", "SOCIAL_ID", "c", "getUSER_HASH_ID", "USER_HASH_ID", "e", "getSOCIAL", "SOCIAL", AuthSource.BOOKING_ORDER, "getID", "ID", AuthSource.SEND_ABUSE, "getTABLE_NAME", "TABLE_NAME", "d", "getLOGIN", "LOGIN", "h", "getSUGGESTS_QUERY_WITH_LIMIT", "SUGGESTS_QUERY_WITH_LIMIT", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class LoginSuggestsContract implements BaseColumns {
    @NotNull
    public final String a = "login_suggests";
    @NotNull
    public final String b = "_id";
    @NotNull
    public final String c = "user_hash_id";
    @NotNull
    public final String d = "login";
    @NotNull
    public final String e = "social";
    @NotNull
    public final String f = AuthParamsKt.KEY_SOCIAL_ID;
    @NotNull
    public final String g = a.f("SELECT * FROM ", "login_suggests", " ORDER BY ", "_id", " DESC");
    @NotNull
    public final String h = a.f("SELECT * FROM ", "login_suggests", " ORDER BY ", "_id", " DESC LIMIT ?");

    @NotNull
    public final String createSql() {
        StringBuilder L = a.L("\n            CREATE TABLE IF NOT EXISTS ");
        L.append(this.a);
        L.append("(\n                ");
        L.append(this.b);
        L.append(" INTEGER PRIMARY KEY AUTOINCREMENT,\n                ");
        L.append(this.c);
        L.append(" TEXT NOT NULL UNIQUE ON CONFLICT REPLACE,\n                ");
        L.append(this.d);
        L.append(" TEXT,\n                ");
        L.append(this.e);
        L.append(" TEXT,\n                ");
        return a.t(L, this.f, " TEXT\n            );\n        ");
    }

    @NotNull
    public final String getID() {
        return this.b;
    }

    @NotNull
    public final String getLOGIN() {
        return this.d;
    }

    @NotNull
    public final String getSOCIAL() {
        return this.e;
    }

    @NotNull
    public final String getSOCIAL_ID() {
        return this.f;
    }

    @NotNull
    public final String getSUGGESTS_QUERY() {
        return this.g;
    }

    @NotNull
    public final String getSUGGESTS_QUERY_WITH_LIMIT() {
        return this.h;
    }

    @NotNull
    public final String getTABLE_NAME() {
        return this.a;
    }

    @NotNull
    public final String getUSER_HASH_ID() {
        return this.c;
    }
}

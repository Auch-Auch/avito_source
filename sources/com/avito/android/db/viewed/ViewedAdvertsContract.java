package com.avito.android.db.viewed;

import a2.b.a.a.a;
import android.provider.BaseColumns;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/avito/android/db/viewed/ViewedAdvertsContract;", "Landroid/provider/BaseColumns;", "", "createSql", "()Ljava/lang/String;", "c", "Ljava/lang/String;", "getADVERT_ID", "ADVERT_ID", "d", "getADDED_TIME", "ADDED_TIME", AuthSource.SEND_ABUSE, "getTABLE_NAME", "TABLE_NAME", AuthSource.BOOKING_ORDER, "getID", "ID", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedAdvertsContract implements BaseColumns {
    @NotNull
    public final String a = "viewed_adverts";
    @NotNull
    public final String b = "_id";
    @NotNull
    public final String c = "advert_id";
    @NotNull
    public final String d = "added_time";

    @NotNull
    public final String createSql() {
        StringBuilder L = a.L("\n            CREATE TABLE IF NOT EXISTS ");
        L.append(this.a);
        L.append("(\n                ");
        L.append(this.b);
        L.append(" INTEGER PRIMARY KEY AUTOINCREMENT,\n                ");
        L.append(this.c);
        L.append(" TEXT NOT NULL UNIQUE ON CONFLICT REPLACE,\n                ");
        return a.t(L, this.d, " INTEGER NOT NULL\n            );\n        ");
    }

    @NotNull
    public final String getADDED_TIME() {
        return this.d;
    }

    @NotNull
    public final String getADVERT_ID() {
        return this.c;
    }

    @NotNull
    public final String getID() {
        return this.b;
    }

    @NotNull
    public final String getTABLE_NAME() {
        return this.a;
    }
}

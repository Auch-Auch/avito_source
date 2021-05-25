package com.avito.android.db.favorites;

import a2.b.a.a.a;
import android.provider.BaseColumns;
import com.avito.android.db.FavoritesContract;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/db/favorites/FavoritesSyncContract;", "Landroid/provider/BaseColumns;", "", "createSql", "()Ljava/lang/String;", "c", "Ljava/lang/String;", "getENTITY_ID", "ENTITY_ID", "d", "getSYNC_STATUS", "SYNC_STATUS", "e", "getMARKED_FOR_REMOVE", "MARKED_FOR_REMOVE", "", "SYNC_PENDING", "I", "getSYNC_PENDING", "()I", AuthSource.SEND_ABUSE, "getTABLE_NAME", "TABLE_NAME", "f", "getSYNC_DONE", "SYNC_DONE", AuthSource.BOOKING_ORDER, "getID", "ID", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoritesSyncContract implements BaseColumns {
    @NotNull
    public final String a = "favorites_sync";
    @NotNull
    public final String b = "_id";
    @NotNull
    public final String c = "entity_id";
    @NotNull
    public final String d = "sync_status";
    @NotNull
    public final String e = FavoritesContract.FavoriteAdvertColumns.MARKED_FOR_REMOVE_FLAG;
    public final int f = 1;

    @NotNull
    public final String createSql() {
        StringBuilder L = a.L("\n                CREATE TABLE IF NOT EXISTS ");
        L.append(this.a);
        L.append("(\n                    ");
        L.append(this.b);
        L.append(" INTEGER PRIMARY KEY AUTOINCREMENT,\n                    ");
        L.append(this.c);
        L.append(" TEXT NOT NULL UNIQUE ON CONFLICT REPLACE,\n                    ");
        L.append(this.d);
        L.append(" INTEGER NOT NULL DEFAULT 0,\n                    ");
        return a.t(L, this.e, " INTEGER NOT NULL DEFAULT 0\n                );\n               ");
    }

    @NotNull
    public final String getENTITY_ID() {
        return this.c;
    }

    @NotNull
    public final String getID() {
        return this.b;
    }

    @NotNull
    public final String getMARKED_FOR_REMOVE() {
        return this.e;
    }

    public final int getSYNC_DONE() {
        return this.f;
    }

    public final int getSYNC_PENDING() {
        return 0;
    }

    @NotNull
    public final String getSYNC_STATUS() {
        return this.d;
    }

    @NotNull
    public final String getTABLE_NAME() {
        return this.a;
    }
}

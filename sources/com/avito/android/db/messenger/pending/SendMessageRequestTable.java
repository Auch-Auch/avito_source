package com.avito.android.db.messenger.pending;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b%\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010!\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010\u0004R\u001c\u0010$\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b#\u0010\u0004¨\u0006'"}, d2 = {"Lcom/avito/android/db/messenger/pending/SendMessageRequestTable;", "", "", "createSql", "()Ljava/lang/String;", "selectById", "selectByChannelIdWithinTimeRange", "selectAllSuccessfulRequests", "selectAllRequests", "e", "Ljava/lang/String;", "getLOCAL_ID", "LOCAL_ID", "i", "getERROR_CODE", "ERROR_CODE", "f", "getREMOTE_ID", "REMOTE_ID", "d", "getMESSAGE_TYPE", "MESSAGE_TYPE", g.a, "getCREATED", DebugCoroutineInfoImplKt.CREATED, "h", "getTEXT", "TEXT", "c", "getCHANNEL_ID", "CHANNEL_ID", AuthSource.SEND_ABUSE, "getTABLE", "TABLE", AuthSource.BOOKING_ORDER, "getID", "ID", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SendMessageRequestTable {
    @NotNull
    public final String a = "send_message_requests";
    @NotNull
    public final String b = "_id";
    @NotNull
    public final String c = "channel_id";
    @NotNull
    public final String d = Constants.MessagePayloadKeys.MESSAGE_TYPE;
    @NotNull
    public final String e = MessageEntity.COLUMN_LOCAL_ID;
    @NotNull
    public final String f = MessageEntity.COLUMN_REMOTE_ID;
    @NotNull
    public final String g = "created";
    @NotNull
    public final String h = "text";
    @NotNull
    public final String i = "error_code";

    @NotNull
    public final String createSql() {
        StringBuilder L = a.L("CREATE TABLE IF NOT EXISTS ");
        L.append(this.a);
        L.append(" (");
        L.append(this.b);
        L.append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        L.append(this.c);
        L.append(" TEXT NOT NULL, ");
        L.append(this.d);
        L.append(" TEXT NOT NULL, ");
        L.append(this.e);
        L.append(" TEXT UNIQUE NOT NULL, ");
        L.append(this.f);
        L.append(" TEXT, ");
        L.append(this.g);
        L.append(" INTEGER NOT NULL, ");
        L.append(this.h);
        L.append(" TEXT, ");
        return a.u(L, this.i, " INTEGER NOT NULL DEFAULT 0", ")");
    }

    @NotNull
    public final String getCHANNEL_ID() {
        return this.c;
    }

    @NotNull
    public final String getCREATED() {
        return this.g;
    }

    @NotNull
    public final String getERROR_CODE() {
        return this.i;
    }

    @NotNull
    public final String getID() {
        return this.b;
    }

    @NotNull
    public final String getLOCAL_ID() {
        return this.e;
    }

    @NotNull
    public final String getMESSAGE_TYPE() {
        return this.d;
    }

    @NotNull
    public final String getREMOTE_ID() {
        return this.f;
    }

    @NotNull
    public final String getTABLE() {
        return this.a;
    }

    @NotNull
    public final String getTEXT() {
        return this.h;
    }

    @NotNull
    public final String selectAllRequests() {
        StringBuilder L = a.L("SELECT * FROM ");
        a.k1(L, this.a, ' ', "ORDER BY ");
        return a.t(L, this.g, " ASC");
    }

    @NotNull
    public final String selectAllSuccessfulRequests() {
        StringBuilder L = a.L("SELECT * FROM ");
        a.k1(L, this.a, ' ', "WHERE ");
        a.m1(L, this.f, " IS NOT NULL ", "ORDER BY ");
        return a.t(L, this.g, " ASC");
    }

    @NotNull
    public final String selectByChannelIdWithinTimeRange() {
        StringBuilder L = a.L("SELECT * FROM ");
        a.k1(L, this.a, ' ', "WHERE ");
        L.append(this.c);
        L.append(" = ? AND ");
        L.append(this.g);
        L.append(" >= ? AND ");
        a.m1(L, this.g, " < ? ", "ORDER BY ");
        return a.t(L, this.g, " ASC");
    }

    @NotNull
    public final String selectById() {
        StringBuilder L = a.L("SELECT * FROM ");
        L.append(this.a);
        L.append(" WHERE ");
        return a.t(L, this.b, " = ?");
    }
}

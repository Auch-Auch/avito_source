package com.avito.android.db.preferences;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b)\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001f\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\"\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010%\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010(\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006¨\u0006+"}, d2 = {"Lcom/avito/android/db/preferences/SharedPreferencesTable;", "", "", "c", "Ljava/lang/String;", "getFILE", "()Ljava/lang/String;", "FILE", "e", "getVALUE", "VALUE", AuthSource.SEND_ABUSE, "getTABLE", "TABLE", "h", "getDROP_TABLE_IF_EXISTS", "DROP_TABLE_IF_EXISTS", "j", "getVALUE_QUERY", "VALUE_QUERY", "d", "getKEY", "KEY", "l", "getDELETE_FILE", "DELETE_FILE", g.a, "getCREATE_TABLE", "CREATE_TABLE", AuthSource.BOOKING_ORDER, "getID", "ID", "f", "getTYPE", "TYPE", "k", "getFILE_QUERY", "FILE_QUERY", "i", "getDELETE_KEY", "DELETE_KEY", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SharedPreferencesTable {
    @NotNull
    public final String a = Names.DEFAULT;
    @NotNull
    public final String b = "_id";
    @NotNull
    public final String c = "file";
    @NotNull
    public final String d = "key";
    @NotNull
    public final String e = "value";
    @NotNull
    public final String f = "type";
    @NotNull
    public final String g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    @NotNull
    public final String j;
    @NotNull
    public final String k;
    @NotNull
    public final String l;

    public SharedPreferencesTable() {
        StringBuilder W = a.W("CREATE TABLE IF NOT EXISTS ", Names.DEFAULT, " (", "_id", " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        a.n1(W, "file", " TEXT NOT NULL, ", "key", " TEXT NOT NULL, ");
        a.n1(W, "value", " TEXT, ", "type", " TEXT NOT NULL, ");
        a.n1(W, "UNIQUE (", "key", ", ", "file");
        W.append(')');
        W.append(")");
        this.g = W.toString();
        this.h = a.c3("DROP TABLE IF EXISTS ", Names.DEFAULT);
        this.i = a.d("key", " = ? AND ", "file", " = ?");
        this.j = a.v(a.W("SELECT ", "value", " FROM ", Names.DEFAULT, " WHERE "), "key", " = ? AND ", "file", " = ?");
        this.k = a.f("SELECT * FROM ", Names.DEFAULT, " WHERE ", "file", " = ?");
        this.l = a.c3("file", " = ?");
    }

    @NotNull
    public final String getCREATE_TABLE() {
        return this.g;
    }

    @NotNull
    public final String getDELETE_FILE() {
        return this.l;
    }

    @NotNull
    public final String getDELETE_KEY() {
        return this.i;
    }

    @NotNull
    public final String getDROP_TABLE_IF_EXISTS() {
        return this.h;
    }

    @NotNull
    public final String getFILE() {
        return this.c;
    }

    @NotNull
    public final String getFILE_QUERY() {
        return this.k;
    }

    @NotNull
    public final String getID() {
        return this.b;
    }

    @NotNull
    public final String getKEY() {
        return this.d;
    }

    @NotNull
    public final String getTABLE() {
        return this.a;
    }

    @NotNull
    public final String getTYPE() {
        return this.f;
    }

    @NotNull
    public final String getVALUE() {
        return this.e;
    }

    @NotNull
    public final String getVALUE_QUERY() {
        return this.j;
    }
}

package com.avito.android.db.favorites;

import a2.b.a.a.a;
import a2.g.r.g;
import android.provider.BaseColumns;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.stats.CodePackage;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\bE\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bE\u0010FJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010 \u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010#\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\u0004R\u001c\u0010&\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010\u0004R\u001c\u0010)\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\u0004R\u001c\u0010,\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\u0004R\u001c\u0010/\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\u0004R\u001c\u00102\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b0\u0010\u0006\u001a\u0004\b1\u0010\u0004R\u001c\u00105\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b3\u0010\u0006\u001a\u0004\b4\u0010\u0004R\u001c\u00108\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b6\u0010\u0006\u001a\u0004\b7\u0010\u0004R\u001c\u0010;\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b9\u0010\u0006\u001a\u0004\b:\u0010\u0004R\u001c\u0010>\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b<\u0010\u0006\u001a\u0004\b=\u0010\u0004R\u001c\u0010A\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b?\u0010\u0006\u001a\u0004\b@\u0010\u0004R\u001c\u0010D\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\bB\u0010\u0006\u001a\u0004\bC\u0010\u0004¨\u0006G"}, d2 = {"Lcom/avito/android/db/favorites/FavoriteAdvertsContract;", "Landroid/provider/BaseColumns;", "", "createSql", "()Ljava/lang/String;", "i", "Ljava/lang/String;", "getTIME", "TIME", "l", "getCATEGORY", "CATEGORY", AuthSource.OPEN_CHANNEL_LIST, "getNOTE", "NOTE", "d", "getTITLE", ShareConstants.TITLE, "f", "getPRICE_WITHOUT_DISCOUNT", "PRICE_WITHOUT_DISCOUNT", "n", "getSHOP_NAME", "SHOP_NAME", "c", "getADVERT_ID", "ADVERT_ID", "p", "getSTATUS", "STATUS", "s", "getNEW_LOCATION", "NEW_LOCATION", "e", "getPRICE", "PRICE", "h", "getSUBLOCATION", "SUBLOCATION", "o", "getDEEP_LINK", "DEEP_LINK", VKApiConst.Q, "getPREVIOUS_PRICE", "PREVIOUS_PRICE", AuthSource.SEND_ABUSE, "getTABLE_NAME", "TABLE_NAME", AuthSource.BOOKING_ORDER, "getID", "ID", "u", "getSTATUS_DESCRIPTION", "STATUS_DESCRIPTION", "t", "getIS_DELIVERABLE", "IS_DELIVERABLE", "r", "getADDRESS", "ADDRESS", g.a, "getLOCATION", CodePackage.LOCATION, "k", "getIMAGE", ShareConstants.IMAGE_URL, "j", "getACTIVE", "ACTIVE", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertsContract implements BaseColumns {
    @NotNull
    public final String a = "favorite_adverts";
    @NotNull
    public final String b = "_id";
    @NotNull
    public final String c = "advert_id";
    @NotNull
    public final String d = "title";
    @NotNull
    public final String e = "price";
    @NotNull
    public final String f = "priceWithoutDiscount";
    @NotNull
    public final String g = "location";
    @NotNull
    public final String h = "sublocation";
    @NotNull
    public final String i = "time";
    @NotNull
    public final String j = "active";
    @NotNull
    public final String k = "image";
    @NotNull
    public final String l = "category";
    @NotNull
    public final String m = VKAttachments.TYPE_NOTE;
    @NotNull
    public final String n = "shop_name";
    @NotNull
    public final String o = "deep_link";
    @NotNull
    public final String p = "status";
    @NotNull
    public final String q = "previous_price";
    @NotNull
    public final String r = IntegrityManager.INTEGRITY_TYPE_ADDRESS;
    @NotNull
    public final String s = "new_location";
    @NotNull
    public final String t = "is_deliverable";
    @NotNull
    public final String u = "status_description";

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
        L.append(" TEXT,\n                    ");
        L.append(this.e);
        L.append(" TEXT,\n                    ");
        L.append(this.g);
        L.append(" TEXT,\n                    ");
        L.append(this.h);
        L.append(" TEXT,\n                    ");
        L.append(this.k);
        L.append(" TEXT,\n                    ");
        L.append(this.l);
        L.append(" TEXT,\n                    ");
        L.append(this.i);
        L.append(" INTEGER NOT NULL,\n                    ");
        L.append(this.j);
        L.append(" INTEGER NOT NULL,\n                    ");
        L.append(this.m);
        L.append(" TEXT,\n                    ");
        L.append(this.n);
        L.append(" TEXT,\n                    ");
        L.append(this.o);
        L.append(" TEXT,\n                    ");
        L.append(this.p);
        L.append(" TEXT,\n                    ");
        L.append(this.q);
        L.append(" TEXT,\n                    ");
        L.append(this.r);
        L.append(" TEXT,\n                    ");
        L.append(this.s);
        L.append(" TEXT,\n                    ");
        L.append(this.t);
        L.append(" INTEGER,\n                    ");
        L.append(this.u);
        L.append(" TEXT,\n                    ");
        return a.t(L, this.f, " TEXT\n                );\n        ");
    }

    @NotNull
    public final String getACTIVE() {
        return this.j;
    }

    @NotNull
    public final String getADDRESS() {
        return this.r;
    }

    @NotNull
    public final String getADVERT_ID() {
        return this.c;
    }

    @NotNull
    public final String getCATEGORY() {
        return this.l;
    }

    @NotNull
    public final String getDEEP_LINK() {
        return this.o;
    }

    @NotNull
    public final String getID() {
        return this.b;
    }

    @NotNull
    public final String getIMAGE() {
        return this.k;
    }

    @NotNull
    public final String getIS_DELIVERABLE() {
        return this.t;
    }

    @NotNull
    public final String getLOCATION() {
        return this.g;
    }

    @NotNull
    public final String getNEW_LOCATION() {
        return this.s;
    }

    @NotNull
    public final String getNOTE() {
        return this.m;
    }

    @NotNull
    public final String getPREVIOUS_PRICE() {
        return this.q;
    }

    @NotNull
    public final String getPRICE() {
        return this.e;
    }

    @NotNull
    public final String getPRICE_WITHOUT_DISCOUNT() {
        return this.f;
    }

    @NotNull
    public final String getSHOP_NAME() {
        return this.n;
    }

    @NotNull
    public final String getSTATUS() {
        return this.p;
    }

    @NotNull
    public final String getSTATUS_DESCRIPTION() {
        return this.u;
    }

    @NotNull
    public final String getSUBLOCATION() {
        return this.h;
    }

    @NotNull
    public final String getTABLE_NAME() {
        return this.a;
    }

    @NotNull
    public final String getTIME() {
        return this.i;
    }

    @NotNull
    public final String getTITLE() {
        return this.d;
    }
}

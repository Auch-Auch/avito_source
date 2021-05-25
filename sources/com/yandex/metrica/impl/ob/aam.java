package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONArray;
import org.json.JSONObject;
public class aam {
    @NonNull
    public final String m;
    @NonNull
    public final String n;
    @Nullable
    public final c o;
    public final int p;
    public final boolean q;
    @NonNull
    public final d r;
    @NonNull
    public final a s;

    public enum a {
        LIST("LIST"),
        LABEL("LABEL"),
        BUTTON("BUTTON"),
        CONTAINER("CONTAINER"),
        TOOLBAR("TOOLBAR"),
        INPUT("INPUT"),
        IMAGE(ShareConstants.IMAGE_URL),
        WEBVIEW("WEBVIEW"),
        OTHER("OTHER");
        
        @NonNull
        private final String j;

        private a(String str) {
            this.j = str;
        }
    }

    public enum b {
        TEXT("TEXT"),
        HTML("HTML");
        
        @NonNull
        public final String c;

        private b(String str) {
            this.c = str;
        }
    }

    public enum c {
        TEXT_TOO_LONG("TEXT_TOO_LONG"),
        REGEXP_NOT_MATCHED("REGEXP_NOT_MATCHED"),
        IRRELEVANT_CLASS("IRRELEVANT_CLASS");
        
        @NonNull
        private final String d;

        private c(String str) {
            this.d = str;
        }
    }

    public enum d {
        VIEW_CONTAINER("VIEW_CONTAINER"),
        VIEW("VIEW");
        
        @NonNull
        private final String c;

        private d(String str) {
            this.c = str;
        }
    }

    public aam(@NonNull String str, @NonNull String str2, @Nullable c cVar, int i, boolean z, @NonNull d dVar, @NonNull a aVar) {
        this.m = str;
        this.n = str2;
        this.o = cVar;
        this.p = i;
        this.q = z;
        this.r = dVar;
        this.s = aVar;
    }

    @Nullable
    public JSONArray a(@NonNull aah aah) {
        return null;
    }

    public boolean a() {
        return false;
    }

    @Nullable
    public c b(@NonNull aah aah) {
        return this.o;
    }

    @NonNull
    public JSONObject c(@NonNull aah aah) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.r.c);
            c b2 = b(aah);
            if (b2 == null) {
                jSONObject.put("cnt", a(aah));
            }
            if (aah.e) {
                JSONObject put = new JSONObject().put(UserDataStore.CITY, this.s.j).put("cn", this.m).put("rid", this.n).put("d", this.p).put("lc", this.q).put("if", b2 != null);
                if (b2 != null) {
                    put.put("fr", b2.d);
                }
                jSONObject.put("i", put);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("UiElement{mClassName='");
        a2.b.a.a.a.k1(L, this.m, '\'', ", mId='");
        a2.b.a.a.a.k1(L, this.n, '\'', ", mFilterReason=");
        L.append(this.o);
        L.append(", mDepth=");
        L.append(this.p);
        L.append(", mListItem=");
        L.append(this.q);
        L.append(", mViewType=");
        L.append(this.r);
        L.append(", mClassType=");
        L.append(this.s);
        L.append('}');
        return L.toString();
    }
}

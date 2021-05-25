package com.avito.android.util.preferences;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlParams;
import com.facebook.share.internal.ShareConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010\u000bR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u0012\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001b\u0010\u0006R\"\u0010!\u001a\u00020\u00028\u0006@\u0007XD¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u0012\u0004\b \u0010\u000b\u001a\u0004\b\u001f\u0010\u0006¨\u0006#"}, d2 = {"Lcom/avito/android/util/preferences/ProfileContract;", "", "", "c", "Ljava/lang/String;", "getEMAIL", "()Ljava/lang/String;", "EMAIL", "h", "getDISTRICT_ID", "getDISTRICT_ID$annotations", "()V", "DISTRICT_ID", AuthSource.SEND_ABUSE, "getID", "ID", "e", "getPHONE", "getPHONE$annotations", "PHONE", "d", "getIMAGE", ShareConstants.IMAGE_URL, AuthSource.BOOKING_ORDER, "getNAME", "NAME", "f", "getLOCATION_ID", "getLOCATION_ID$annotations", "LOCATION_ID", g.a, "getMETRO_ID", "getMETRO_ID$annotations", "METRO_ID", "<init>", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileContract {
    @NotNull
    public static final ProfileContract INSTANCE = new ProfileContract();
    @NotNull
    public static final String a = a.c3("profile_", "id");
    @NotNull
    public static final String b = a.c3("profile_", "name");
    @NotNull
    public static final String c = a.c3("profile_", "email");
    @NotNull
    public static final String d = a.c3("profile_", "image");
    @NotNull
    public static final String e = a.c3("profile_", "phone");
    @NotNull
    public static final String f = a.c3("profile_", "locationId");
    @NotNull
    public static final String g = a.c3("profile_", UrlParams.METRO_ID);
    @NotNull
    public static final String h = a.c3("profile_", UrlParams.DISTRICT_ID);

    @Deprecated(message = "since v3.5.3")
    public static /* synthetic */ void getDISTRICT_ID$annotations() {
    }

    @Deprecated(message = "since v3.5.3")
    public static /* synthetic */ void getLOCATION_ID$annotations() {
    }

    @Deprecated(message = "since v3.5.3")
    public static /* synthetic */ void getMETRO_ID$annotations() {
    }

    @Deprecated(message = "since v3.5.3")
    public static /* synthetic */ void getPHONE$annotations() {
    }

    @NotNull
    public final String getDISTRICT_ID() {
        return h;
    }

    @NotNull
    public final String getEMAIL() {
        return c;
    }

    @NotNull
    public final String getID() {
        return a;
    }

    @NotNull
    public final String getIMAGE() {
        return d;
    }

    @NotNull
    public final String getLOCATION_ID() {
        return f;
    }

    @NotNull
    public final String getMETRO_ID() {
        return g;
    }

    @NotNull
    public final String getNAME() {
        return b;
    }

    @NotNull
    public final String getPHONE() {
        return e;
    }
}

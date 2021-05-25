package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.avito.android.BuildConfig;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.social.AppleSignInManagerKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class AccessToken implements Parcelable {
    public static final String ACCESS_TOKEN_KEY = "access_token";
    public static final Parcelable.Creator<AccessToken> CREATOR = new b();
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
    public static final String EXPIRES_IN_KEY = "expires_in";
    public static final String USER_ID_KEY = "user_id";
    public static final Date l;
    public static final Date m;
    public static final Date n = new Date();
    public static final AccessTokenSource o = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    public final Date a;
    public final Set<String> b;
    public final Set<String> c;
    public final Set<String> d;
    public final String e;
    public final AccessTokenSource f;
    public final Date g;
    public final String h;
    public final String i;
    public final Date j;
    public final String k;

    public interface AccessTokenCreationCallback {
        void onError(FacebookException facebookException);

        void onSuccess(AccessToken accessToken);
    }

    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(FacebookException facebookException);

        void OnTokenRefreshed(AccessToken accessToken);
    }

    public static class a implements Utility.GraphMeRequestWithCacheCallback {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ AccessTokenCreationCallback b;
        public final /* synthetic */ String c;

        public a(Bundle bundle, AccessTokenCreationCallback accessTokenCreationCallback, String str) {
            this.a = bundle;
            this.b = accessTokenCreationCallback;
            this.c = str;
        }

        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
        public void onFailure(FacebookException facebookException) {
            this.b.onError(facebookException);
        }

        @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
        public void onSuccess(JSONObject jSONObject) {
            try {
                this.a.putString("user_id", jSONObject.getString("id"));
                this.b.onSuccess(AccessToken.a(null, this.a, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), this.c));
            } catch (JSONException unused) {
                this.b.onError(new FacebookException("Unable to generate access token due to missing user id"));
            }
        }
    }

    public static class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new AccessToken(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new AccessToken[i];
        }
    }

    static {
        Date date = new Date(Long.MAX_VALUE);
        l = date;
        m = date;
    }

    public AccessToken(String str, String str2, String str3, @Nullable Collection<String> collection, @Nullable Collection<String> collection2, @Nullable Collection<String> collection3, @Nullable AccessTokenSource accessTokenSource, @Nullable Date date, @Nullable Date date2, @Nullable Date date3) {
        this(str, str2, str3, collection, collection2, collection3, accessTokenSource, date, date2, date3, null);
    }

    public static AccessToken a(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
        String string = bundle.getString("access_token");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", date);
        String string2 = bundle.getString("user_id");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string) || bundleLongAsDate == null) {
            return null;
        }
        return new AccessToken(string, str, string2, list, null, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
    }

    public static AccessToken b(JSONObject jSONObject) throws JSONException {
        Collection collection;
        if (jSONObject.getInt("version") <= 1) {
            String string = jSONObject.getString(AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            Date date = new Date(jSONObject.getLong("expires_at"));
            JSONArray jSONArray = jSONObject.getJSONArray("permissions");
            JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
            JSONArray optJSONArray = jSONObject.optJSONArray("expired_permissions");
            Date date2 = new Date(jSONObject.getLong("last_refresh"));
            AccessTokenSource valueOf = AccessTokenSource.valueOf(jSONObject.getString("source"));
            String string2 = jSONObject.getString("application_id");
            String string3 = jSONObject.getString("user_id");
            Date date3 = new Date(jSONObject.optLong(DATA_ACCESS_EXPIRATION_TIME, 0));
            String optString = jSONObject.optString(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN, null);
            List<String> jsonArrayToStringList = Utility.jsonArrayToStringList(jSONArray);
            List<String> jsonArrayToStringList2 = Utility.jsonArrayToStringList(jSONArray2);
            if (optJSONArray == null) {
                collection = new ArrayList();
            } else {
                collection = Utility.jsonArrayToStringList(optJSONArray);
            }
            return new AccessToken(string, string2, string3, jsonArrayToStringList, jsonArrayToStringList2, collection, valueOf, date, date2, date3, optString);
        }
        throw new FacebookException("Unknown AccessToken serialization format.");
    }

    public static List<String> c(Bundle bundle, String str) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(stringArrayList));
    }

    public static void createFromNativeLinkingIntent(Intent intent, String str, AccessTokenCreationCallback accessTokenCreationCallback) {
        Validate.notNull(intent, "intent");
        if (intent.getExtras() == null) {
            accessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
            return;
        }
        Bundle bundle = new Bundle(intent.getExtras());
        String string = bundle.getString("access_token");
        if (string == null || string.isEmpty()) {
            accessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
            return;
        }
        String string2 = bundle.getString("user_id");
        if (string2 == null || string2.isEmpty()) {
            Utility.getGraphMeRequestWithCacheAsync(string, new a(bundle, accessTokenCreationCallback, str));
        } else {
            accessTokenCreationCallback.onSuccess(a(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
        }
    }

    public static AccessToken getCurrentAccessToken() {
        return AccessTokenManager.a().c;
    }

    public static boolean isCurrentAccessTokenActive() {
        AccessToken accessToken = AccessTokenManager.a().c;
        return accessToken != null && !accessToken.isExpired();
    }

    public static boolean isDataAccessActive() {
        AccessToken accessToken = AccessTokenManager.a().c;
        return accessToken != null && !accessToken.isDataAccessExpired();
    }

    public static void refreshCurrentAccessTokenAsync() {
        AccessTokenManager.a().b(null);
    }

    public static void setCurrentAccessToken(AccessToken accessToken) {
        AccessTokenManager.a().e(accessToken, true);
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put(AppleSignInManagerKt.EXTRA_APPLE_TOKEN, this.e);
        jSONObject.put("expires_at", this.a.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.b));
        jSONObject.put("declined_permissions", new JSONArray((Collection) this.c));
        jSONObject.put("expired_permissions", new JSONArray((Collection) this.d));
        jSONObject.put("last_refresh", this.g.getTime());
        jSONObject.put("source", this.f.name());
        jSONObject.put("application_id", this.h);
        jSONObject.put("user_id", this.i);
        jSONObject.put(DATA_ACCESS_EXPIRATION_TIME, this.j.getTime());
        String str = this.k;
        if (str != null) {
            jSONObject.put(NativeProtocol.RESULT_ARGS_GRAPH_DOMAIN, str);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (this.a.equals(accessToken.a) && this.b.equals(accessToken.b) && this.c.equals(accessToken.c) && this.d.equals(accessToken.d) && this.e.equals(accessToken.e) && this.f == accessToken.f && this.g.equals(accessToken.g) && ((str = this.h) != null ? str.equals(accessToken.h) : accessToken.h == null) && this.i.equals(accessToken.i) && this.j.equals(accessToken.j)) {
            String str2 = this.k;
            String str3 = accessToken.k;
            if (str2 == null) {
                if (str3 == null) {
                    return true;
                }
            } else if (str2.equals(str3)) {
                return true;
            }
        }
        return false;
    }

    public String getApplicationId() {
        return this.h;
    }

    public Date getDataAccessExpirationTime() {
        return this.j;
    }

    public Set<String> getDeclinedPermissions() {
        return this.c;
    }

    public Set<String> getExpiredPermissions() {
        return this.d;
    }

    public Date getExpires() {
        return this.a;
    }

    public String getGraphDomain() {
        return this.k;
    }

    public Date getLastRefresh() {
        return this.g;
    }

    public Set<String> getPermissions() {
        return this.b;
    }

    public AccessTokenSource getSource() {
        return this.f;
    }

    public String getToken() {
        return this.e;
    }

    public String getUserId() {
        return this.i;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = (this.g.hashCode() + ((this.f.hashCode() + a2.b.a.a.a.B0(this.e, (this.d.hashCode() + ((hashCode2 + ((hashCode + ((this.a.hashCode() + 527) * 31)) * 31)) * 31)) * 31, 31)) * 31)) * 31;
        String str = this.h;
        int i2 = 0;
        int hashCode4 = (this.j.hashCode() + a2.b.a.a.a.B0(this.i, (hashCode3 + (str == null ? 0 : str.hashCode())) * 31, 31)) * 31;
        String str2 = this.k;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode4 + i2;
    }

    public boolean isDataAccessExpired() {
        return new Date().after(this.j);
    }

    public boolean isExpired() {
        return new Date().after(this.a);
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        StringBuilder Q = a2.b.a.a.a.Q("{AccessToken", " token:");
        if (this.e == null) {
            str = BuildConfig.ADJUST_DEFAULT_TRACKER;
        } else {
            str = FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS) ? this.e : "ACCESS_TOKEN_REMOVED";
        }
        Q.append(str);
        Q.append(" permissions:");
        if (this.b == null) {
            Q.append(BuildConfig.ADJUST_DEFAULT_TRACKER);
        } else {
            Q.append("[");
            Q.append(TextUtils.join(", ", this.b));
            Q.append("]");
        }
        Q.append("}");
        return Q.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a.getTime());
        parcel.writeStringList(new ArrayList(this.b));
        parcel.writeStringList(new ArrayList(this.c));
        parcel.writeStringList(new ArrayList(this.d));
        parcel.writeString(this.e);
        parcel.writeString(this.f.name());
        parcel.writeLong(this.g.getTime());
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeLong(this.j.getTime());
        parcel.writeString(this.k);
    }

    public AccessToken(String str, String str2, String str3, @Nullable Collection<String> collection, @Nullable Collection<String> collection2, @Nullable Collection<String> collection3, @Nullable AccessTokenSource accessTokenSource, @Nullable Date date, @Nullable Date date2, @Nullable Date date3, @Nullable String str4) {
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        Validate.notNullOrEmpty(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Validate.notNullOrEmpty(str2, "applicationId");
        Validate.notNullOrEmpty(str3, ChannelContext.Item.USER_ID);
        this.a = date == null ? m : date;
        if (collection == null) {
            hashSet = new HashSet();
        }
        this.b = Collections.unmodifiableSet(hashSet);
        if (collection2 == null) {
            hashSet2 = new HashSet();
        }
        this.c = Collections.unmodifiableSet(hashSet2);
        if (collection3 == null) {
            hashSet3 = new HashSet();
        }
        this.d = Collections.unmodifiableSet(hashSet3);
        this.e = str;
        this.f = accessTokenSource == null ? o : accessTokenSource;
        this.g = date2 == null ? n : date2;
        this.h = str2;
        this.i = str3;
        this.j = (date3 == null || date3.getTime() == 0) ? m : date3;
        this.k = str4;
    }

    public static void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AccessTokenManager.a().b(accessTokenRefreshCallback);
    }

    public AccessToken(Parcel parcel) {
        this.a = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.b = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.c = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.d = Collections.unmodifiableSet(new HashSet(arrayList));
        this.e = parcel.readString();
        this.f = AccessTokenSource.valueOf(parcel.readString());
        this.g = new Date(parcel.readLong());
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = new Date(parcel.readLong());
        this.k = parcel.readString();
    }
}

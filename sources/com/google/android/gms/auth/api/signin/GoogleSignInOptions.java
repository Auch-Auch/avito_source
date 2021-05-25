package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.ok.android.sdk.Shared;
@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zad();
    @RecentlyNonNull
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    @RecentlyNonNull
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zaa = new Scope("profile");
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zab = new Scope("email");
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zac = new Scope(Scopes.OPEN_ID);
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zad;
    @RecentlyNonNull
    @VisibleForTesting
    public static final Scope zae = new Scope(Scopes.GAMES);
    private static Comparator<Scope> zaq = new zac();
    @SafeParcelable.VersionField(id = 1)
    private final int zaf;
    @SafeParcelable.Field(getter = "getScopes", id = 2)
    private final ArrayList<Scope> zag;
    @Nullable
    @SafeParcelable.Field(getter = "getAccount", id = 3)
    private Account zah;
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    private boolean zai;
    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean zaj;
    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean zak;
    @Nullable
    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    private String zal;
    @Nullable
    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)
    private String zam;
    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    private ArrayList<GoogleSignInOptionsExtensionParcelable> zan;
    @Nullable
    @SafeParcelable.Field(getter = "getLogSessionId", id = 10)
    private String zao;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zap;

    public static final class Builder {
        private Set<Scope> zaa = new HashSet();
        private boolean zab;
        private boolean zac;
        private boolean zad;
        @Nullable
        private String zae;
        @Nullable
        private Account zaf;
        @Nullable
        private String zag;
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> zah = new HashMap();
        @Nullable
        private String zai;

        public Builder() {
        }

        private final String zaa(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.zae;
            Preconditions.checkArgument(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }

        @RecentlyNonNull
        public final Builder addExtension(@RecentlyNonNull GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (!this.zah.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                List<Scope> impliedScopes = googleSignInOptionsExtension.getImpliedScopes();
                if (impliedScopes != null) {
                    this.zaa.addAll(impliedScopes);
                }
                this.zah.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        @RecentlyNonNull
        public final GoogleSignInOptions build() {
            if (this.zaa.contains(GoogleSignInOptions.zae)) {
                Set<Scope> set = this.zaa;
                Scope scope = GoogleSignInOptions.zad;
                if (set.contains(scope)) {
                    this.zaa.remove(scope);
                }
            }
            if (this.zad && (this.zaf == null || !this.zaa.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, null);
        }

        @RecentlyNonNull
        public final Builder requestEmail() {
            this.zaa.add(GoogleSignInOptions.zab);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestId() {
            this.zaa.add(GoogleSignInOptions.zac);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestIdToken(@RecentlyNonNull String str) {
            this.zad = true;
            this.zae = zaa(str);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestProfile() {
            this.zaa.add(GoogleSignInOptions.zaa);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestScopes(@RecentlyNonNull Scope scope, @RecentlyNonNull Scope... scopeArr) {
            this.zaa.add(scope);
            this.zaa.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @RecentlyNonNull
        public final Builder requestServerAuthCode(@RecentlyNonNull String str) {
            return requestServerAuthCode(str, false);
        }

        @RecentlyNonNull
        public final Builder setAccountName(@RecentlyNonNull String str) {
            this.zaf = new Account(Preconditions.checkNotEmpty(str), "com.google");
            return this;
        }

        @RecentlyNonNull
        public final Builder setHostedDomain(@RecentlyNonNull String str) {
            this.zag = Preconditions.checkNotEmpty(str);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public final Builder setLogSessionId(@RecentlyNonNull String str) {
            this.zai = str;
            return this;
        }

        @RecentlyNonNull
        public final Builder requestServerAuthCode(@RecentlyNonNull String str, @RecentlyNonNull boolean z) {
            this.zab = true;
            this.zae = zaa(str);
            this.zac = z;
            return this;
        }

        public Builder(@RecentlyNonNull GoogleSignInOptions googleSignInOptions) {
            Preconditions.checkNotNull(googleSignInOptions);
            this.zaa = new HashSet(googleSignInOptions.zag);
            this.zab = googleSignInOptions.zaj;
            this.zac = googleSignInOptions.zak;
            this.zad = googleSignInOptions.zai;
            this.zae = googleSignInOptions.zal;
            this.zaf = googleSignInOptions.zah;
            this.zag = googleSignInOptions.zam;
            this.zah = GoogleSignInOptions.zab(googleSignInOptions.zan);
            this.zai = googleSignInOptions.zao;
        }
    }

    static {
        Scope scope = new Scope(Scopes.GAMES_LITE);
        zad = scope;
        DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(scope, new Scope[0]).build();
    }

    @SafeParcelable.Constructor
    public GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @Nullable @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @Nullable @SafeParcelable.Param(id = 7) String str, @Nullable @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, @Nullable @SafeParcelable.Param(id = 10) String str3) {
        this(i, arrayList, account, z, z2, z3, str, str2, zab(arrayList2), str3);
    }

    @RecentlyNullable
    public static GoogleSignInOptions zaa(@Nullable String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray(Shared.PARAM_SCOPES);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        Account account = !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null;
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        String optString2 = jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null;
        if (jSONObject.has("hostedDomain")) {
            str2 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z, z2, z3, optString2, str2, new HashMap(), (String) null);
    }

    /* access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> zab(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1.equals(r4.getAccount()) != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        if (r3.zal.equals(r4.getServerClientId()) != false) goto L_0x0069;
     */
    @Override // java.lang.Object
    @androidx.annotation.RecentlyNonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x008f }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.zan     // Catch:{ ClassCastException -> 0x008f }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x008f }
            if (r1 > 0) goto L_0x008f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.zan     // Catch:{ ClassCastException -> 0x008f }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x008f }
            if (r1 <= 0) goto L_0x0018
            goto L_0x008f
        L_0x0018:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zag     // Catch:{ ClassCastException -> 0x008f }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x008f }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x008f }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x008f }
            if (r1 != r2) goto L_0x008f
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zag     // Catch:{ ClassCastException -> 0x008f }
            java.util.ArrayList r2 = r4.getScopes()     // Catch:{ ClassCastException -> 0x008f }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x008f }
            if (r1 != 0) goto L_0x0035
            goto L_0x008f
        L_0x0035:
            android.accounts.Account r1 = r3.zah     // Catch:{ ClassCastException -> 0x008f }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.getAccount()     // Catch:{ ClassCastException -> 0x008f }
            if (r1 != 0) goto L_0x008f
            goto L_0x004a
        L_0x0040:
            android.accounts.Account r2 = r4.getAccount()     // Catch:{ ClassCastException -> 0x008f }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x008f }
            if (r1 == 0) goto L_0x008f
        L_0x004a:
            java.lang.String r1 = r3.zal     // Catch:{ ClassCastException -> 0x008f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x008f }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.getServerClientId()     // Catch:{ ClassCastException -> 0x008f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x008f }
            if (r1 == 0) goto L_0x008f
            goto L_0x0069
        L_0x005d:
            java.lang.String r1 = r3.zal     // Catch:{ ClassCastException -> 0x008f }
            java.lang.String r2 = r4.getServerClientId()     // Catch:{ ClassCastException -> 0x008f }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x008f }
            if (r1 == 0) goto L_0x008f
        L_0x0069:
            boolean r1 = r3.zak     // Catch:{ ClassCastException -> 0x008f }
            boolean r2 = r4.isForceCodeForRefreshToken()     // Catch:{ ClassCastException -> 0x008f }
            if (r1 != r2) goto L_0x008f
            boolean r1 = r3.zai     // Catch:{ ClassCastException -> 0x008f }
            boolean r2 = r4.isIdTokenRequested()     // Catch:{ ClassCastException -> 0x008f }
            if (r1 != r2) goto L_0x008f
            boolean r1 = r3.zaj     // Catch:{ ClassCastException -> 0x008f }
            boolean r2 = r4.isServerAuthCodeRequested()     // Catch:{ ClassCastException -> 0x008f }
            if (r1 != r2) goto L_0x008f
            java.lang.String r1 = r3.zao     // Catch:{ ClassCastException -> 0x008f }
            java.lang.String r4 = r4.getLogSessionId()     // Catch:{ ClassCastException -> 0x008f }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x008f }
            if (r4 == 0) goto L_0x008f
            r4 = 1
            return r4
        L_0x008f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @RecentlyNullable
    @KeepForSdk
    public Account getAccount() {
        return this.zah;
    }

    @RecentlyNonNull
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zan;
    }

    @RecentlyNullable
    @KeepForSdk
    public String getLogSessionId() {
        return this.zao;
    }

    @RecentlyNonNull
    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.zag;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @RecentlyNonNull
    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zag);
    }

    @RecentlyNullable
    @KeepForSdk
    public String getServerClientId() {
        return this.zal;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zag;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.getScopeUri());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().addObject(arrayList).addObject(this.zah).addObject(this.zal).zaa(this.zak).zaa(this.zai).zaa(this.zaj).addObject(this.zao).hash();
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.zak;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.zai;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.zaj;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaf);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zam, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, @Nullable Account account, boolean z, boolean z2, boolean z3, @Nullable String str, @Nullable String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @Nullable String str3) {
        this.zaf = i;
        this.zag = arrayList;
        this.zah = account;
        this.zai = z;
        this.zaj = z2;
        this.zak = z3;
        this.zal = str;
        this.zam = str2;
        this.zan = new ArrayList<>(map.values());
        this.zap = map;
        this.zao = str3;
    }

    private final JSONObject zab() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zag, zaq);
            ArrayList<Scope> arrayList = this.zag;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put(Shared.PARAM_SCOPES, jSONArray);
            Account account = this.zah;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.zai);
            jSONObject.put("forceCodeForRefreshToken", this.zak);
            jSONObject.put("serverAuthRequested", this.zaj);
            if (!TextUtils.isEmpty(this.zal)) {
                jSONObject.put("serverClientId", this.zal);
            }
            if (!TextUtils.isEmpty(this.zam)) {
                jSONObject.put("hostedDomain", this.zam);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, zac zac2) {
        this(3, arrayList, account, z, z2, z3, str, str2, map, str3);
    }

    @RecentlyNonNull
    public final String zaa() {
        return zab().toString();
    }
}

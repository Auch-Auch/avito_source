package com.google.firebase.dynamiclinks;

import a2.j.e.f.b;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.internal.zze;
public final class DynamicLink {
    public final Bundle a;

    public static final class GoogleAnalyticsParameters {
        public Bundle a;

        public GoogleAnalyticsParameters(Bundle bundle, b bVar) {
            this.a = bundle;
        }

        public static final class Builder {
            public final Bundle a;

            public Builder() {
                this.a = new Bundle();
            }

            @NonNull
            public final GoogleAnalyticsParameters build() {
                return new GoogleAnalyticsParameters(this.a, null);
            }

            @NonNull
            public final String getCampaign() {
                return this.a.getString("utm_campaign", "");
            }

            @NonNull
            public final String getContent() {
                return this.a.getString("utm_content", "");
            }

            @NonNull
            public final String getMedium() {
                return this.a.getString("utm_medium", "");
            }

            @NonNull
            public final String getSource() {
                return this.a.getString("utm_source", "");
            }

            @NonNull
            public final String getTerm() {
                return this.a.getString("utm_term", "");
            }

            @NonNull
            public final Builder setCampaign(@NonNull String str) {
                this.a.putString("utm_campaign", str);
                return this;
            }

            @NonNull
            public final Builder setContent(@NonNull String str) {
                this.a.putString("utm_content", str);
                return this;
            }

            @NonNull
            public final Builder setMedium(@NonNull String str) {
                this.a.putString("utm_medium", str);
                return this;
            }

            @NonNull
            public final Builder setSource(@NonNull String str) {
                this.a.putString("utm_source", str);
                return this;
            }

            @NonNull
            public final Builder setTerm(@NonNull String str) {
                this.a.putString("utm_term", str);
                return this;
            }

            public Builder(@NonNull String str, @NonNull String str2, @NonNull String str3) {
                Bundle bundle = new Bundle();
                this.a = bundle;
                bundle.putString("utm_source", str);
                bundle.putString("utm_medium", str2);
                bundle.putString("utm_campaign", str3);
            }
        }
    }

    public static final class IosParameters {
        public final Bundle a;

        public static final class Builder {
            public final Bundle a;

            public Builder(@NonNull String str) {
                Bundle bundle = new Bundle();
                this.a = bundle;
                bundle.putString("ibi", str);
            }

            @NonNull
            public final IosParameters build() {
                return new IosParameters(this.a, null);
            }

            @NonNull
            public final String getAppStoreId() {
                return this.a.getString("isi", "");
            }

            @NonNull
            public final String getCustomScheme() {
                return this.a.getString("ius", "");
            }

            @NonNull
            public final String getIpadBundleId() {
                return this.a.getString("ipbi", "");
            }

            @NonNull
            public final Uri getIpadFallbackUrl() {
                Uri uri = (Uri) this.a.getParcelable("ipfl");
                return uri == null ? Uri.EMPTY : uri;
            }

            @NonNull
            public final String getMinimumVersion() {
                return this.a.getString("imv", "");
            }

            @NonNull
            public final Builder setAppStoreId(@NonNull String str) {
                this.a.putString("isi", str);
                return this;
            }

            @NonNull
            public final Builder setCustomScheme(@NonNull String str) {
                this.a.putString("ius", str);
                return this;
            }

            @NonNull
            public final Builder setFallbackUrl(@NonNull Uri uri) {
                this.a.putParcelable("ifl", uri);
                return this;
            }

            @NonNull
            public final Builder setIpadBundleId(@NonNull String str) {
                this.a.putString("ipbi", str);
                return this;
            }

            @NonNull
            public final Builder setIpadFallbackUrl(@NonNull Uri uri) {
                this.a.putParcelable("ipfl", uri);
                return this;
            }

            @NonNull
            public final Builder setMinimumVersion(@NonNull String str) {
                this.a.putString("imv", str);
                return this;
            }
        }

        public IosParameters(Bundle bundle, b bVar) {
            this.a = bundle;
        }
    }

    public static final class ItunesConnectAnalyticsParameters {
        public final Bundle a;

        public static final class Builder {
            public final Bundle a = new Bundle();

            @NonNull
            public final ItunesConnectAnalyticsParameters build() {
                return new ItunesConnectAnalyticsParameters(this.a, null);
            }

            @NonNull
            public final String getAffiliateToken() {
                return this.a.getString("at", "");
            }

            @NonNull
            public final String getCampaignToken() {
                return this.a.getString(UserDataStore.CITY, "");
            }

            @NonNull
            public final String getProviderToken() {
                return this.a.getString("pt", "");
            }

            @NonNull
            public final Builder setAffiliateToken(@NonNull String str) {
                this.a.putString("at", str);
                return this;
            }

            @NonNull
            public final Builder setCampaignToken(@NonNull String str) {
                this.a.putString(UserDataStore.CITY, str);
                return this;
            }

            @NonNull
            public final Builder setProviderToken(@NonNull String str) {
                this.a.putString("pt", str);
                return this;
            }
        }

        public ItunesConnectAnalyticsParameters(Bundle bundle, b bVar) {
            this.a = bundle;
        }
    }

    public static final class NavigationInfoParameters {
        public final Bundle a;

        public static final class Builder {
            public final Bundle a = new Bundle();

            @NonNull
            public final NavigationInfoParameters build() {
                return new NavigationInfoParameters(this.a, null);
            }

            public final boolean getForcedRedirectEnabled() {
                return this.a.getInt("efr") == 1;
            }

            @NonNull
            public final Builder setForcedRedirectEnabled(boolean z) {
                this.a.putInt("efr", z ? 1 : 0);
                return this;
            }
        }

        public NavigationInfoParameters(Bundle bundle, b bVar) {
            this.a = bundle;
        }
    }

    public static final class SocialMetaTagParameters {
        public final Bundle a;

        public static final class Builder {
            public final Bundle a = new Bundle();

            @NonNull
            public final SocialMetaTagParameters build() {
                return new SocialMetaTagParameters(this.a, null);
            }

            @NonNull
            public final String getDescription() {
                return this.a.getString("sd", "");
            }

            @NonNull
            public final Uri getImageUrl() {
                Uri uri = (Uri) this.a.getParcelable("si");
                return uri == null ? Uri.EMPTY : uri;
            }

            @NonNull
            public final String getTitle() {
                return this.a.getString(UserDataStore.STATE, "");
            }

            @NonNull
            public final Builder setDescription(@NonNull String str) {
                this.a.putString("sd", str);
                return this;
            }

            @NonNull
            public final Builder setImageUrl(@NonNull Uri uri) {
                this.a.putParcelable("si", uri);
                return this;
            }

            @NonNull
            public final Builder setTitle(@NonNull String str) {
                this.a.putString(UserDataStore.STATE, str);
                return this;
            }
        }

        public SocialMetaTagParameters(Bundle bundle, b bVar) {
            this.a = bundle;
        }
    }

    public DynamicLink(Bundle bundle) {
        this.a = bundle;
    }

    @NonNull
    public final Uri getUri() {
        Bundle bundle = this.a;
        zze.zzb(bundle);
        Uri uri = (Uri) bundle.getParcelable("dynamicLink");
        if (uri != null) {
            return uri;
        }
        Uri.Builder builder = new Uri.Builder();
        Uri parse = Uri.parse(bundle.getString("domainUriPrefix"));
        builder.scheme(parse.getScheme());
        builder.authority(parse.getAuthority());
        builder.path(parse.getPath());
        Bundle bundle2 = bundle.getBundle(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj != null) {
                builder.appendQueryParameter(str, obj.toString());
            }
        }
        return builder.build();
    }

    public static final class Builder {
        public final zze a;
        public final Bundle b;
        public final Bundle c;

        public Builder(zze zze) {
            this.a = zze;
            Bundle bundle = new Bundle();
            this.b = bundle;
            if (FirebaseApp.getInstance() != null) {
                bundle.putString("apiKey", FirebaseApp.getInstance().getOptions().getApiKey());
            }
            Bundle bundle2 = new Bundle();
            this.c = bundle2;
            bundle.putBundle(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, bundle2);
        }

        @NonNull
        public final DynamicLink buildDynamicLink() {
            zze.zzb(this.b);
            return new DynamicLink(this.b);
        }

        @NonNull
        public final Task<ShortDynamicLink> buildShortDynamicLink() {
            if (this.b.getString("apiKey") != null) {
                return this.a.zza(this.b);
            }
            throw new IllegalArgumentException("Missing API key. Set with setApiKey().");
        }

        @NonNull
        public final String getDomainUriPrefix() {
            return this.b.getString("domainUriPrefix", "");
        }

        @NonNull
        public final Uri getLink() {
            Uri uri = (Uri) this.c.getParcelable("link");
            return uri == null ? Uri.EMPTY : uri;
        }

        @NonNull
        public final Uri getLongLink() {
            Uri uri = (Uri) this.c.getParcelable("dynamicLink");
            return uri == null ? Uri.EMPTY : uri;
        }

        @NonNull
        public final Builder setAndroidParameters(@NonNull AndroidParameters androidParameters) {
            this.c.putAll(androidParameters.a);
            return this;
        }

        @NonNull
        public final Builder setDomainUriPrefix(@NonNull String str) {
            if (str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$") || str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$")) {
                this.b.putString("domain", str.replace("https://", ""));
            }
            this.b.putString("domainUriPrefix", str);
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder setDynamicLinkDomain(@NonNull String str) {
            if (str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.app\\.goo\\.gl$") || str.matches("(https:\\/\\/)?[a-z0-9]{3,}\\.page\\.link$")) {
                this.b.putString("domain", str);
                this.b.putString("domainUriPrefix", str.length() != 0 ? "https://".concat(str) : new String("https://"));
                return this;
            }
            throw new IllegalArgumentException("Use setDomainUriPrefix() instead, setDynamicLinkDomain() is only applicable for *.page.link and *.app.goo.gl domains.");
        }

        @NonNull
        public final Builder setGoogleAnalyticsParameters(@NonNull GoogleAnalyticsParameters googleAnalyticsParameters) {
            this.c.putAll(googleAnalyticsParameters.a);
            return this;
        }

        @NonNull
        public final Builder setIosParameters(@NonNull IosParameters iosParameters) {
            this.c.putAll(iosParameters.a);
            return this;
        }

        @NonNull
        public final Builder setItunesConnectAnalyticsParameters(@NonNull ItunesConnectAnalyticsParameters itunesConnectAnalyticsParameters) {
            this.c.putAll(itunesConnectAnalyticsParameters.a);
            return this;
        }

        @NonNull
        public final Builder setLink(@NonNull Uri uri) {
            this.c.putParcelable("link", uri);
            return this;
        }

        @NonNull
        public final Builder setLongLink(@NonNull Uri uri) {
            this.b.putParcelable("dynamicLink", uri);
            return this;
        }

        @NonNull
        public final Builder setNavigationInfoParameters(@NonNull NavigationInfoParameters navigationInfoParameters) {
            this.c.putAll(navigationInfoParameters.a);
            return this;
        }

        @NonNull
        public final Builder setSocialMetaTagParameters(@NonNull SocialMetaTagParameters socialMetaTagParameters) {
            this.c.putAll(socialMetaTagParameters.a);
            return this;
        }

        @NonNull
        public final Task<ShortDynamicLink> buildShortDynamicLink(int i) {
            if (this.b.getString("apiKey") != null) {
                this.b.putInt("suffix", i);
                return this.a.zza(this.b);
            }
            throw new IllegalArgumentException("Missing API key. Set with setApiKey().");
        }
    }

    public static final class AndroidParameters {
        public final Bundle a;

        public AndroidParameters(Bundle bundle, b bVar) {
            this.a = bundle;
        }

        public static final class Builder {
            public final Bundle a;

            public Builder() {
                if (FirebaseApp.getInstance() != null) {
                    Bundle bundle = new Bundle();
                    this.a = bundle;
                    bundle.putString("apn", FirebaseApp.getInstance().getApplicationContext().getPackageName());
                    return;
                }
                throw new IllegalStateException("FirebaseApp not initialized.");
            }

            @NonNull
            public final AndroidParameters build() {
                return new AndroidParameters(this.a, null);
            }

            @NonNull
            public final Uri getFallbackUrl() {
                Uri uri = (Uri) this.a.getParcelable("afl");
                return uri == null ? Uri.EMPTY : uri;
            }

            public final int getMinimumVersion() {
                return this.a.getInt("amv");
            }

            @NonNull
            public final Builder setFallbackUrl(@NonNull Uri uri) {
                this.a.putParcelable("afl", uri);
                return this;
            }

            @NonNull
            public final Builder setMinimumVersion(int i) {
                this.a.putInt("amv", i);
                return this;
            }

            public Builder(@NonNull String str) {
                Bundle bundle = new Bundle();
                this.a = bundle;
                bundle.putString("apn", str);
            }
        }
    }
}

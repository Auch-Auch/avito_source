package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.TrustedWebUtils;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import androidx.browser.trusted.sharing.ShareData;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class TrustedWebActivityIntentBuilder {
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ADDITIONAL_TRUSTED_ORIGINS = "android.support.customtabs.extra.ADDITIONAL_TRUSTED_ORIGINS";
    public static final String EXTRA_DISPLAY_MODE = "androidx.browser.trusted.extra.DISPLAY_MODE";
    public static final String EXTRA_SHARE_DATA = "androidx.browser.trusted.extra.SHARE_DATA";
    public static final String EXTRA_SHARE_TARGET = "androidx.browser.trusted.extra.SHARE_TARGET";
    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SPLASH_SCREEN_PARAMS = "androidx.browser.trusted.EXTRA_SPLASH_SCREEN_PARAMS";
    @NonNull
    public final Uri a;
    @NonNull
    public final CustomTabsIntent.Builder b = new CustomTabsIntent.Builder();
    @Nullable
    public List<String> c;
    @Nullable
    public Bundle d;
    @Nullable
    public ShareData e;
    @Nullable
    public ShareTarget f;
    @NonNull
    public TrustedWebActivityDisplayMode g = new TrustedWebActivityDisplayMode.DefaultMode();

    public TrustedWebActivityIntentBuilder(@NonNull Uri uri) {
        this.a = uri;
    }

    @NonNull
    public TrustedWebActivityIntent build(@NonNull CustomTabsSession customTabsSession) {
        Objects.requireNonNull(customTabsSession, "CustomTabsSession is required for launching a TWA");
        this.b.setSession(customTabsSession);
        Intent intent = this.b.build().intent;
        intent.setData(this.a);
        intent.putExtra(TrustedWebUtils.EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY, true);
        if (this.c != null) {
            intent.putExtra(EXTRA_ADDITIONAL_TRUSTED_ORIGINS, new ArrayList(this.c));
        }
        Bundle bundle = this.d;
        if (bundle != null) {
            intent.putExtra(EXTRA_SPLASH_SCREEN_PARAMS, bundle);
        }
        List<Uri> emptyList = Collections.emptyList();
        ShareTarget shareTarget = this.f;
        if (!(shareTarget == null || this.e == null)) {
            intent.putExtra(EXTRA_SHARE_TARGET, shareTarget.toBundle());
            intent.putExtra(EXTRA_SHARE_DATA, this.e.toBundle());
            List<Uri> list = this.e.uris;
            if (list != null) {
                emptyList = list;
            }
        }
        intent.putExtra(EXTRA_DISPLAY_MODE, this.g.toBundle());
        return new TrustedWebActivityIntent(intent, emptyList);
    }

    @NonNull
    public CustomTabsIntent buildCustomTabsIntent() {
        return this.b.build();
    }

    @Nullable
    public TrustedWebActivityDisplayMode getDisplayMode() {
        return this.g;
    }

    @NonNull
    public Uri getUri() {
        return this.a;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setAdditionalTrustedOrigins(@NonNull List<String> list) {
        this.c = list;
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setColorScheme(int i) {
        this.b.setColorScheme(i);
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setColorSchemeParams(int i, @NonNull CustomTabColorSchemeParams customTabColorSchemeParams) {
        this.b.setColorSchemeParams(i, customTabColorSchemeParams);
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setDisplayMode(@NonNull TrustedWebActivityDisplayMode trustedWebActivityDisplayMode) {
        this.g = trustedWebActivityDisplayMode;
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setNavigationBarColor(@ColorInt int i) {
        this.b.setNavigationBarColor(i);
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setShareParams(@NonNull ShareTarget shareTarget, @NonNull ShareData shareData) {
        this.f = shareTarget;
        this.e = shareData;
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setSplashScreenParams(@NonNull Bundle bundle) {
        this.d = bundle;
        return this;
    }

    @NonNull
    public TrustedWebActivityIntentBuilder setToolbarColor(@ColorInt int i) {
        this.b.setToolbarColor(i);
        return this;
    }
}

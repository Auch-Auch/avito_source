package com.google.androidbrowserhelper.trusted;

import android.content.Intent;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.core.content.ContextCompat;
import com.google.androidbrowserhelper.trusted.LauncherActivity;
import com.google.androidbrowserhelper.trusted.TwaLauncher;
import com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy;
import java.util.List;
public class LauncherActivity extends AppCompatActivity {
    public static boolean g;
    public LauncherActivityMetadata c;
    public boolean d;
    @Nullable
    public PwaWrapperSplashScreenStrategy e;
    @Nullable
    public TwaLauncher f;

    public TrustedWebActivityDisplayMode getDisplayMode() {
        return this.c.displayMode;
    }

    public TwaLauncher.FallbackStrategy getFallbackStrategy() {
        if ("webview".equalsIgnoreCase(this.c.fallbackStrategyType)) {
            return TwaLauncher.WEBVIEW_FALLBACK_STRATEGY;
        }
        return TwaLauncher.CCT_FALLBACK_STRATEGY;
    }

    public Uri getLaunchingUrl() {
        Uri data = getIntent().getData();
        if (data != null) {
            String str = "Using URL from Intent (" + data + ").";
            return data;
        }
        String str2 = this.c.defaultUrl;
        if (str2 != null) {
            return Uri.parse(str2);
        }
        return Uri.parse("https://www.example.com/");
    }

    @NonNull
    public ImageView.ScaleType getSplashImageScaleType() {
        return ImageView.ScaleType.CENTER;
    }

    @Nullable
    public Matrix getSplashImageTransformationMatrix() {
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z;
        boolean z2;
        super.onCreate(bundle);
        boolean z3 = (getIntent().getFlags() & 268435456) != 0;
        boolean z4 = (getIntent().getFlags() & 524288) != 0;
        if (!z3 || z4) {
            Intent intent = new Intent(getIntent());
            intent.setFlags((268435456 | getIntent().getFlags()) & -524289);
            startActivity(intent);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            finish();
        } else if (bundle == null || !bundle.getBoolean("android.support.customtabs.trusted.BROWSER_WAS_LAUNCHED_KEY")) {
            LauncherActivityMetadata parse = LauncherActivityMetadata.parse(this);
            this.c = parse;
            if (parse.splashImageDrawableId == 0) {
                z2 = false;
            } else {
                z2 = isTaskRoot();
            }
            if (z2) {
                LauncherActivityMetadata launcherActivityMetadata = this.c;
                int i = launcherActivityMetadata.splashImageDrawableId;
                int color = ContextCompat.getColor(this, launcherActivityMetadata.splashScreenBackgroundColorId);
                ImageView.ScaleType splashImageScaleType = getSplashImageScaleType();
                Matrix splashImageTransformationMatrix = getSplashImageTransformationMatrix();
                LauncherActivityMetadata launcherActivityMetadata2 = this.c;
                this.e = new PwaWrapperSplashScreenStrategy(this, i, color, splashImageScaleType, splashImageTransformationMatrix, launcherActivityMetadata2.splashScreenFadeOutDurationMillis, launcherActivityMetadata2.fileProviderAuthority);
            }
            TrustedWebActivityIntentBuilder displayMode = new TrustedWebActivityIntentBuilder(getLaunchingUrl()).setToolbarColor(ContextCompat.getColor(this, this.c.statusBarColorId)).setNavigationBarColor(ContextCompat.getColor(this, this.c.navigationBarColorId)).setColorScheme(0).setColorSchemeParams(2, new CustomTabColorSchemeParams.Builder().setToolbarColor(ContextCompat.getColor(this, this.c.statusBarColorDarkId)).setNavigationBarColor(ContextCompat.getColor(this, this.c.navigationBarColorDarkId)).build()).setDisplayMode(getDisplayMode());
            List<String> list = this.c.additionalTrustedOrigins;
            if (list != null) {
                displayMode.setAdditionalTrustedOrigins(list);
            }
            TwaLauncher twaLauncher = new TwaLauncher(this);
            this.f = twaLauncher;
            twaLauncher.launch(displayMode, this.e, new Runnable() { // from class: a2.j.c.a.a
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherActivity.this.d = true;
                }
            }, getFallbackStrategy());
            if (!g) {
                ChromeUpdatePrompt.promptIfNeeded(this, this.f.getProviderPackage());
                g = true;
            }
            new TwaSharedPreferencesManager(this).writeLastLaunchedProviderPackageName(this.f.getProviderPackage());
        } else {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TwaLauncher twaLauncher = this.f;
        if (twaLauncher != null) {
            twaLauncher.destroy();
        }
        PwaWrapperSplashScreenStrategy pwaWrapperSplashScreenStrategy = this.e;
        if (pwaWrapperSplashScreenStrategy != null) {
            pwaWrapperSplashScreenStrategy.destroy();
        }
    }

    @Override // android.app.Activity
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        PwaWrapperSplashScreenStrategy pwaWrapperSplashScreenStrategy = this.e;
        if (pwaWrapperSplashScreenStrategy != null) {
            pwaWrapperSplashScreenStrategy.onActivityEnterAnimationComplete();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (this.d) {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("android.support.customtabs.trusted.BROWSER_WAS_LAUNCHED_KEY", this.d);
    }
}

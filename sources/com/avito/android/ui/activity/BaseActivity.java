package com.avito.android.ui.activity;

import a2.g.r.g;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.analytics.screens.tracker.ScreenTransferKt;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lastclick.LastClick;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.text_view.AvitoTextView;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.lib.util.inflater.AvitoLayoutInflater;
import com.avito.android.util.ActionBarUtils;
import com.avito.android.util.Constants;
import com.avito.android.util.Contexts;
import com.facebook.share.internal.MessengerShareContentUtility;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001iB\u0007¢\u0006\u0004\bh\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\u000bH\u0014¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010!\u001a\u00020\u000bH\u0014¢\u0006\u0004\b!\u0010\u000fJ\u0017\u0010$\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u000bH\u0004¢\u0006\u0004\b&\u0010\u000fJ\u000f\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\u000bH\u0004¢\u0006\u0004\b*\u0010\u000fJ\u0019\u0010*\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010+H\u0004¢\u0006\u0004\b*\u0010-J#\u0010*\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010+H\u0004¢\u0006\u0004\b*\u0010/J\u000f\u00100\u001a\u00020\u000bH\u0017¢\u0006\u0004\b0\u0010\u000fJ\u0017\u00103\u001a\u00020\u00132\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0013H\u0014¢\u0006\u0004\b5\u0010(J\u0017\u00108\u001a\u00020\u00132\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010>\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0004¢\u0006\u0004\b>\u0010?J\u0011\u0010@\u001a\u0004\u0018\u00010<H\u0004¢\u0006\u0004\b@\u0010AR$\u0010H\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR$\u0010W\u001a\u00020Q2\u0006\u0010R\u001a\u00020Q8\u0006@BX\u000e¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R$\u0010a\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00138\u0004@BX\u000e¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010(R(\u0010g\u001a\u0004\u0018\u00010b2\b\u0010R\u001a\u0004\u0018\u00010b8\u0004@BX\u000e¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f¨\u0006j"}, d2 = {"Lcom/avito/android/ui/activity/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "getContentLayoutId", "()I", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "getContainerViewId", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "applyNewImagesIfNecessary", "()V", "applyStatusBarColor", "applyNavigationBarColor", "setContentView", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater$Factory2;", "onThemizeActivity", "(Landroid/os/Bundle;)Landroid/view/LayoutInflater$Factory2;", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onResume", "onPause", "onStop", "onStart", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "navigateToUpIntent", "onSupportNavigateUp", "()Z", "onBackPressed", "showDefaultActionBar", "", "title", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "restoreActionBar", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "setUpCustomToolbar", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/content/Intent;", "intentForSend", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "saturateIntentWithTrackingInfo", "(Landroid/content/Intent;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Landroid/content/Intent;", "rescueScreenTransfer", "()Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "d", "Landroid/content/Intent;", "getUpIntent", "()Landroid/content/Intent;", "setUpIntent", "(Landroid/content/Intent;)V", "upIntent", "Landroid/os/PowerManager;", "j", "Landroid/os/PowerManager;", "powerManager", "Lcom/avito/android/ui/activity/BaseActivity$Holder;", "h", "Lcom/avito/android/ui/activity/BaseActivity$Holder;", "holder", "", "<set-?>", "f", "J", "getActivityStartupTime", "()J", "activityStartupTime", "Lcom/avito/android/analytics/screens/Timer;", g.a, "Lcom/avito/android/analytics/screens/Timer;", "timer", "i", "I", "lastNightMode", "c", "Z", "isActivityRunning", "Landroidx/appcompat/widget/Toolbar;", "e", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar", "<init>", "Holder", "core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseActivity extends AppCompatActivity {
    public boolean c;
    @Nullable
    public Intent d;
    @Nullable
    public Toolbar e;
    public long f;
    public final Timer g = new TimerFactory().timer();
    public final Holder h = new Holder();
    public int i;
    public PowerManager j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/ui/activity/BaseActivity$Holder;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "prefix", "Lcom/avito/android/analytics/grafana/GraphitePrefix;", "getPrefix", "()Lcom/avito/android/analytics/grafana/GraphitePrefix;", "setPrefix", "(Lcom/avito/android/analytics/grafana/GraphitePrefix;)V", "Lcom/avito/android/lib/util/DarkThemeConfig;", "darkThemeConfig", "Lcom/avito/android/lib/util/DarkThemeConfig;", "getDarkThemeConfig", "()Lcom/avito/android/lib/util/DarkThemeConfig;", "setDarkThemeConfig", "(Lcom/avito/android/lib/util/DarkThemeConfig;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Holder {
        @Inject
        public Analytics analytics;
        @Inject
        public DarkThemeConfig darkThemeConfig;
        @Inject
        public Features features;
        @Inject
        public GraphitePrefix prefix;

        @NotNull
        public final Analytics getAnalytics() {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            return analytics2;
        }

        @NotNull
        public final DarkThemeConfig getDarkThemeConfig() {
            DarkThemeConfig darkThemeConfig2 = this.darkThemeConfig;
            if (darkThemeConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("darkThemeConfig");
            }
            return darkThemeConfig2;
        }

        @NotNull
        public final Features getFeatures() {
            Features features2 = this.features;
            if (features2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("features");
            }
            return features2;
        }

        @NotNull
        public final GraphitePrefix getPrefix() {
            GraphitePrefix graphitePrefix = this.prefix;
            if (graphitePrefix == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefix");
            }
            return graphitePrefix;
        }

        public final void setAnalytics(@NotNull Analytics analytics2) {
            Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
            this.analytics = analytics2;
        }

        public final void setDarkThemeConfig(@NotNull DarkThemeConfig darkThemeConfig2) {
            Intrinsics.checkNotNullParameter(darkThemeConfig2, "<set-?>");
            this.darkThemeConfig = darkThemeConfig2;
        }

        public final void setFeatures(@NotNull Features features2) {
            Intrinsics.checkNotNullParameter(features2, "<set-?>");
            this.features = features2;
        }

        public final void setPrefix(@NotNull GraphitePrefix graphitePrefix) {
            Intrinsics.checkNotNullParameter(graphitePrefix, "<set-?>");
            this.prefix = graphitePrefix;
        }
    }

    public final void applyNavigationBarColor() {
        if (Build.VERSION.SDK_INT >= 27) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            window.setNavigationBarColor(Contexts.getColorByAttr(this, 16843857));
            Window window2 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "window");
            View decorView = window2.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            Window window3 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window3, "window");
            View decorView2 = window3.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "window.decorView");
            int systemUiVisibility = decorView2.getSystemUiVisibility();
            decorView.setSystemUiVisibility(Contexts.getBoolByAttr(this, 16844140, DarkThemeManagerKt.isDarkTheme(this) ^ true) ? systemUiVisibility | 16 : systemUiVisibility & -17);
        }
    }

    public final void applyNewImagesIfNecessary() {
        if (this.h.getDarkThemeConfig().isEnabled()) {
            getTheme().applyStyle(R.style.Resources_NewImages, true);
        }
    }

    public final void applyStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "window");
            window.setStatusBarColor(Contexts.getColorByAttr(this, 16843857));
            Window window2 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window2, "window");
            View decorView = window2.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            Window window3 = getWindow();
            Intrinsics.checkNotNullExpressionValue(window3, "window");
            View decorView2 = window3.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "window.decorView");
            int systemUiVisibility = decorView2.getSystemUiVisibility();
            decorView.setSystemUiVisibility(Contexts.getBoolByAttr(this, 16844000, DarkThemeManagerKt.isDarkTheme(this) ^ true) ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 1) {
            LastClick.Updater.update();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final long getActivityStartupTime() {
        return this.f;
    }

    @NotNull
    public final View getContainerView() {
        View findViewById = findViewById(getContainerViewId());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(getContainerViewId())");
        return findViewById;
    }

    public int getContainerViewId() {
        return 16908290;
    }

    public int getContentLayoutId() {
        return -1;
    }

    @Nullable
    public final Toolbar getToolbar() {
        return this.e;
    }

    @Nullable
    public final Intent getUpIntent() {
        return this.d;
    }

    public final boolean isActivityRunning() {
        return this.c;
    }

    public final void navigateToUpIntent() {
        Intent intent = this.d;
        if (intent != null) {
            intent.setFlags(603979776);
            startActivity(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            LastClick.Updater.update();
            super.onBackPressed();
        } catch (IllegalStateException unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this\n            .resources");
        this.i = resources.getConfiguration().uiMode & 48;
        this.g.start();
        setUpActivityComponent(bundle);
        DaggerBaseActivityComponent.builder().dependentOn((BaseActivityComponentDependencies) ComponentDependenciesKt.getDependencies(BaseActivityComponentDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this.h);
        if (this.h.getFeatures().getScreenActivityOpenings().invoke().booleanValue()) {
            Analytics analytics = this.h.getAnalytics();
            analytics.track(new StatsdEvent.CountEvent(this.h.getPrefix().getVersionsPrefix() + ".performance.screens-distribution." + getClass().getSimpleName(), 0, 2, null));
        }
        applyNewImagesIfNecessary();
        if (this.h.getFeatures().getNewTextStyles().invoke().booleanValue()) {
            getTheme().applyStyle(R.style.Resources_NewTextStyles, true);
        } else {
            getTheme().applyStyle(R.style.Resources_LegacyTextStyles, true);
        }
        applyStatusBarColor();
        applyNavigationBarColor();
        AvitoLayoutInflater.INSTANCE.attachLayoutInflaterFactory(this, onThemizeActivity(bundle));
        super.onCreate(bundle);
        this.j = (PowerManager) getSystemService("power");
        this.d = (Intent) getIntent().getParcelableExtra(Constants.UP_INTENT);
        setContentView();
        if (!setUpCustomToolbar()) {
            Toolbar toolbar = (Toolbar) findViewById(com.avito.android.app.core.R.id.toolbar);
            this.e = toolbar;
            ActionBarUtils actionBarUtils = ActionBarUtils.INSTANCE;
            actionBarUtils.setSupportActionBar(this, toolbar);
            actionBarUtils.setActionBarTitle(getSupportActionBar(), (CharSequence) null);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        restoreActionBar();
        return super.onCreateOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (i2 == 82) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.d == null) {
            return super.onOptionsItemSelected(menuItem);
        }
        navigateToUpIntent();
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.c = false;
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.c = true;
        if (this.f == 0) {
            this.f = this.g.elapsed();
        }
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        int i2;
        AppCompatDelegate delegate = getDelegate();
        Intrinsics.checkNotNullExpressionValue(delegate, "delegate");
        Integer valueOf = Integer.valueOf(delegate.getLocalNightMode());
        if (!(valueOf.intValue() != -100)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        } else {
            i2 = AppCompatDelegate.getDefaultNightMode();
        }
        if (this.i != Contexts.calculateTargetNightMode(this, i2, this.j)) {
            recreate();
        }
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this\n            .resources");
        this.i = resources.getConfiguration().uiMode & 48;
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        if (super.onSupportNavigateUp()) {
            return true;
        }
        onBackPressed();
        return true;
    }

    @Nullable
    public LayoutInflater.Factory2 onThemizeActivity(@Nullable Bundle bundle) {
        return new AvitoLayoutInflater.CompositeFactory().registerFactoryIf(AvitoTextView.Companion.getFactory(), this.h.getFeatures().getNewTextStyles().invoke().booleanValue());
    }

    @Nullable
    public final ScreenTransfer rescueScreenTransfer() {
        Intent intent = getIntent();
        if (intent != null) {
            return (ScreenTransfer) intent.getParcelableExtra(ScreenTransferKt.SCREEN_TRANSFER_KEY);
        }
        return null;
    }

    @Deprecated(message = "Add toolbar to your layout instead")
    public void restoreActionBar() {
    }

    @NotNull
    public final Intent saturateIntentWithTrackingInfo(@NotNull Intent intent, @NotNull ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(intent, "intentForSend");
        Intrinsics.checkNotNullParameter(screenTransfer, "transfer");
        if (!getIntent().getBooleanExtra(ScreenTransferKt.SCREEN_TRANSFER_DONE, false)) {
            intent.setExtrasClassLoader(getClassLoader());
            intent.putExtra(ScreenTransferKt.SCREEN_TRANSFER_KEY, screenTransfer);
            getIntent().putExtra(ScreenTransferKt.SCREEN_TRANSFER_DONE, true);
        }
        return intent;
    }

    public void setContentView() {
        int contentLayoutId = getContentLayoutId();
        if (contentLayoutId != -1) {
            setContentView(contentLayoutId);
        }
    }

    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        return false;
    }

    public boolean setUpCustomToolbar() {
        return false;
    }

    public final void setUpIntent(@Nullable Intent intent) {
        this.d = intent;
    }

    public final void showDefaultActionBar() {
        ActionBarUtils.showDefaultActionBar$default(ActionBarUtils.INSTANCE, getSupportActionBar(), null, null, 6, null);
    }

    public final void showDefaultActionBar(@Nullable CharSequence charSequence) {
        ActionBarUtils.INSTANCE.showDefaultActionBar(getSupportActionBar(), charSequence, null);
    }

    public final void showDefaultActionBar(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        ActionBarUtils.INSTANCE.showDefaultActionBar(getSupportActionBar(), charSequence, charSequence2);
    }
}

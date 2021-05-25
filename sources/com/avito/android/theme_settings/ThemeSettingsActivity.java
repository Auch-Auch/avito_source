package com.avito.android.theme_settings;

import a2.b.a.a.a;
import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.settings.R;
import com.avito.android.ui.activity.BaseActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/avito/android/theme_settings/ThemeSettingsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroidx/fragment/app/Fragment;", AuthSource.SEND_ABUSE, "()Landroidx/fragment/app/Fragment;", "l", "Landroid/view/MotionEvent;", "lastTouchEvent", "Landroid/widget/ImageView;", "k", "Landroid/widget/ImageView;", "backgroundImage", "<init>", "()V", "Companion", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ThemeSettingsActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String IS_AFTER_ONBOARDING = "is_after_onboarding";
    public ImageView k;
    public MotionEvent l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/theme_settings/ThemeSettingsActivity$Companion;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "createIntent$settings_release", "(Landroid/content/Context;)Landroid/content/Intent;", "createIntent", "", "IS_AFTER_ONBOARDING", "Ljava/lang/String;", "TAG", "<init>", "()V", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static final Bitmap access$createBitmap(Companion companion, View view) {
            Objects.requireNonNull(companion);
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            view.draw(canvas);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
            return createBitmap;
        }

        @NotNull
        public final Intent createIntent$settings_release(@NotNull Context context) {
            return a.X0(context, "context", context, ThemeSettingsActivity.class);
        }

        public Companion(j jVar) {
        }
    }

    public final Fragment a() {
        ThemeSettingsFragment newInstance = ThemeSettingsFragment.Companion.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, newInstance, "com.avito.android.ThemeSettingsFragment").commitNow();
        return newInstance;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        this.l = motionEvent;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        View view;
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("com.avito.android.ThemeSettingsFragment");
        if (findFragmentByTag != null && (view = findFragmentByTag.getView()) != null) {
            Intrinsics.checkNotNullExpressionValue(view, "supportFragmentManager.f…yTag(TAG)?.view ?: return");
            ImageView imageView = this.k;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundImage");
            }
            imageView.setImageBitmap(Companion.access$createBitmap(Companion, view));
            float hypot = (float) Math.hypot((double) ((float) view.getWidth()), (double) ((float) view.getHeight()));
            View view2 = a().getView();
            if (view2 != null) {
                Intrinsics.checkNotNullExpressionValue(view2, "recreateFragment().view ?: return");
                applyStatusBarColor();
                applyNavigationBarColor();
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                MotionEvent motionEvent = this.l;
                int max = Math.max((motionEvent != null ? (int) motionEvent.getRawX() : 0) - i, 0);
                MotionEvent motionEvent2 = this.l;
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, max, Math.max((motionEvent2 != null ? (int) motionEvent2.getRawY() : 0) - i2, 0), 0.0f, hypot);
                createCircularReveal.setDuration(300);
                createCircularReveal.start();
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.theme_settings_activity);
        if (getSupportFragmentManager().findFragmentByTag("com.avito.android.ThemeSettingsFragment") == null) {
            a();
        }
        View findViewById = findViewById(R.id.background);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.background)");
        this.k = (ImageView) findViewById;
    }
}

package com.avito.android.serp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.bottom_navigation.UpNavigationHandler;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.SerpFragment;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import com.avito.android.util.Intents;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/avito/android/serp/SerpActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/bottom_navigation/UpNavigationHandler;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onBackPressed", "()V", "handleUpNavigation", "", "getContentLayoutId", "()I", AuthSource.SEND_ABUSE, "<init>", "Factory", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SerpActivity extends BaseActivity implements UpNavigationHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/serp/SerpActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/serp/SerpArguments;", "arguments", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Lcom/avito/android/serp/SerpArguments;)Landroid/content/Intent;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent create(@NotNull Context context, @NotNull SerpArguments serpArguments) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(serpArguments, "arguments");
            Intent putExtra = new Intent(context, SerpActivity.class).putExtra("arguments", serpArguments);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…KEY_ARGUMENTS, arguments)");
            return putExtra;
        }
    }

    public final void a() {
        SerpArguments serpArguments;
        Intent intent = getIntent();
        if (intent == null || (serpArguments = (SerpArguments) intent.getParcelableExtra("arguments")) == null) {
            throw new RuntimeException("arguments was not passed to " + this);
        }
        Intent intent2 = getIntent();
        TreeClickStreamParent treeAnalyticsParent = intent2 != null ? Intents.getTreeAnalyticsParent(intent2) : null;
        if (serpArguments.getTreeParent() == null && treeAnalyticsParent != null) {
            serpArguments = SerpArguments.copy$default(serpArguments, null, null, null, treeAnalyticsParent, null, false, 55, null);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SerpFragment.Factory.createFragment$default(new SerpFragment.Factory(), serpArguments, false, 2, null)).commitNowAllowingStateLoss();
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.overlay_fragment_container;
    }

    @Override // com.avito.android.bottom_navigation.UpNavigationHandler
    public void handleUpNavigation() {
        finish();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z;
        T t;
        T t2;
        boolean z2;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            z = true;
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            Intrinsics.checkNotNullExpressionValue(t3, "it");
            if (!t3.isVisible() || !(t3 instanceof OnBackPressedListener)) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (t2 instanceof OnBackPressedListener) {
            t = t2;
        }
        T t4 = t;
        if (t4 == null || !t4.onBackPressed()) {
            z = false;
        }
        if (!z) {
            super.onBackPressed();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            a();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        a();
    }
}

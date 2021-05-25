package com.avito.android.player.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.player.di.DaggerPlayerActivityComponent;
import com.avito.android.player.di.PlayerActivityDependencies;
import com.avito.android.player.router.PlayerArguments;
import com.avito.android.player.view.PlayerFragment;
import com.avito.android.rec.ScreenSource;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui_components.R;
import com.avito.android.util.Intents;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/player/view/PlayerActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "getContentLayoutId", "()I", "<init>", "()V", "Factory", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerActivity extends BaseActivity {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/player/view/PlayerActivity$Factory;", "", "Landroid/content/Context;", "context", "", "url", "slug", "blockType", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "Landroid/content/Intent;", "create", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/rec/ScreenSource;)Landroid/content/Intent;", "<init>", "()V", "player_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        @NotNull
        public final Intent create(@NotNull Context context, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull ScreenSource screenSource) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(screenSource, "screenSource");
            Intent putExtra = new Intent(context, PlayerActivity.class).putExtra("player_url", str).putExtra("player_slug", str2).putExtra("player_block_type", str3).putExtra("player_screen_source", screenSource);
            Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…EEN_SOURCE, screenSource)");
            if (treeClickStreamParent != null) {
                Intents.putTreeAnalyticsParent(putExtra, treeClickStreamParent);
            }
            return putExtra;
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        if (bundle == null) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(PlayerFragment.TAG);
            String str = null;
            if (!(findFragmentByTag instanceof PlayerFragment)) {
                findFragmentByTag = null;
            }
            if (((PlayerFragment) findFragmentByTag) == null) {
                Intent intent = getIntent();
                if (intent == null || (stringExtra = intent.getStringExtra("player_url")) == null) {
                    throw new IllegalStateException("");
                }
                Intent intent2 = getIntent();
                TreeClickStreamParent treeAnalyticsParent = intent2 != null ? Intents.getTreeAnalyticsParent(intent2) : null;
                Intent intent3 = getIntent();
                ScreenSource screenSource = intent3 != null ? (ScreenSource) intent3.getParcelableExtra("player_screen_source") : null;
                Objects.requireNonNull(screenSource, "null cannot be cast to non-null type com.avito.android.rec.ScreenSource");
                PlayerFragment.Companion companion = PlayerFragment.Companion;
                Intent intent4 = getIntent();
                String stringExtra2 = intent4 != null ? intent4.getStringExtra("player_slug") : null;
                Intent intent5 = getIntent();
                if (intent5 != null) {
                    str = intent5.getStringExtra("player_block_type");
                }
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, companion.newInstance(new PlayerArguments(stringExtra, stringExtra2, str, treeAnalyticsParent, screenSource)), PlayerFragment.TAG).commitAllowingStateLoss();
            }
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        DaggerPlayerActivityComponent.builder().dependencies((PlayerActivityDependencies) ComponentDependenciesKt.getDependencies(PlayerActivityDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        return true;
    }
}

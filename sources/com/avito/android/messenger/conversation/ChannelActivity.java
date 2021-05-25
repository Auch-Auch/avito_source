package com.avito.android.messenger.conversation;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "", "setUpCustomToolbar", "()Z", "Landroid/content/Intent;", "intent", "", "onNewIntent", "(Landroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "getContentLayoutId", "()I", "onBackPressed", "()V", "k", "Z", "backWorksAsUp", "<init>", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelActivity extends BaseActivity {
    public boolean k;

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("ChannelActivityFragment");
        ChannelActivityFragment channelActivityFragment = null;
        if (!(findFragmentByTag instanceof ChannelActivityFragment)) {
            findFragmentByTag = null;
        }
        ChannelActivityFragment channelActivityFragment2 = (ChannelActivityFragment) findFragmentByTag;
        if (channelActivityFragment2 instanceof OnBackPressedListener) {
            channelActivityFragment = channelActivityFragment2;
        }
        if (channelActivityFragment != null && channelActivityFragment.onBackPressed()) {
            return;
        }
        if (!this.k || getUpIntent() == null) {
            super.onBackPressed();
        } else {
            navigateToUpIntent();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Bundle extras = intent.getExtras();
            ChannelActivityArguments.Open open = null;
            ChannelActivityArguments channelActivityArguments = extras != null ? (ChannelActivityArguments) extras.getParcelable("arguments") : null;
            if (channelActivityArguments != null) {
                if (channelActivityArguments instanceof ChannelActivityArguments.Open) {
                    open = channelActivityArguments;
                }
                ChannelActivityArguments.Open open2 = open;
                boolean z = true;
                if (open2 == null || !open2.getBackWorksAsUp()) {
                    z = false;
                }
                this.k = z;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ChannelActivityFragment.Companion.newInstance(channelActivityArguments), "ChannelActivityFragment").commit();
                return;
            }
            throw new IllegalArgumentException(("arguments was not passed to " + this).toString());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("ChannelActivityFragment");
        if (!(findFragmentByTag instanceof ChannelActivityFragment)) {
            findFragmentByTag = null;
        }
        ChannelActivityFragment channelActivityFragment = (ChannelActivityFragment) findFragmentByTag;
        if (channelActivityFragment != null) {
            channelActivityFragment.onNewIntent(intent.getExtras());
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }
}

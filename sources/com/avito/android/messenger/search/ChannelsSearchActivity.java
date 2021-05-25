package com.avito.android.messenger.search;

import android.os.Bundle;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/search/ChannelsSearchActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/messenger/search/BackPressAware;", "", "getContentLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnBackPressListener", "(Lcom/avito/android/ui/fragments/OnBackPressedListener;)V", "removeOnBackPressListener", "", "k", "Ljava/util/List;", "backPressListeners", "<init>", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsSearchActivity extends BaseActivity implements BackPressAware {
    public final List<OnBackPressedListener> k = new ArrayList();

    @Override // com.avito.android.messenger.search.BackPressAware
    public void addOnBackPressListener(@NotNull OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.k.add(onBackPressedListener);
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.fragment_container;
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        for (OnBackPressedListener onBackPressedListener : CollectionsKt___CollectionsKt.toList(this.k)) {
            if (onBackPressedListener.onBackPressed()) {
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new ChannelsSearchFragment(), "search_fragment").commit();
        }
    }

    @Override // com.avito.android.messenger.search.BackPressAware
    public void removeOnBackPressListener(@NotNull OnBackPressedListener onBackPressedListener) {
        Intrinsics.checkNotNullParameter(onBackPressedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.k.remove(onBackPressedListener);
    }
}

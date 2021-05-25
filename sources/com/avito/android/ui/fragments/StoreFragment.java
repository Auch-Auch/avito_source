package com.avito.android.ui.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/ui/fragments/StoreFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", AuthSource.SEND_ABUSE, "Landroid/os/Bundle;", "getBundle$core_release", "()Landroid/os/Bundle;", "setBundle$core_release", "bundle", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class StoreFragment extends Fragment {
    @Nullable
    public Bundle a;

    @Nullable
    public final Bundle getBundle$core_release() {
        return this.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public final void setBundle$core_release(@Nullable Bundle bundle) {
        this.a = bundle;
    }
}

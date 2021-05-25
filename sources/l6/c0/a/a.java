package l6.c0.a;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class a extends FragmentManager.FragmentLifecycleCallbacks {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ FrameLayout b;
    public final /* synthetic */ FragmentStateAdapter c;

    public a(FragmentStateAdapter fragmentStateAdapter, Fragment fragment, FrameLayout frameLayout) {
        this.c = fragmentStateAdapter;
        this.a = fragment;
        this.b = frameLayout;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        if (fragment == this.a) {
            fragmentManager.unregisterFragmentLifecycleCallbacks(this);
            this.c.a(view, this.b);
        }
    }
}

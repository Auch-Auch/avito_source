package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
public final class NavAction {
    @IdRes
    public final int a;
    public NavOptions b;
    public Bundle c;

    public NavAction(@IdRes int i) {
        this(i, null);
    }

    @Nullable
    public Bundle getDefaultArguments() {
        return this.c;
    }

    public int getDestinationId() {
        return this.a;
    }

    @Nullable
    public NavOptions getNavOptions() {
        return this.b;
    }

    public void setDefaultArguments(@Nullable Bundle bundle) {
        this.c = bundle;
    }

    public void setNavOptions(@Nullable NavOptions navOptions) {
        this.b = navOptions;
    }

    public NavAction(@IdRes int i, @Nullable NavOptions navOptions) {
        this(i, navOptions, null);
    }

    public NavAction(@IdRes int i, @Nullable NavOptions navOptions, @Nullable Bundle bundle) {
        this.a = i;
        this.b = navOptions;
        this.c = bundle;
    }
}

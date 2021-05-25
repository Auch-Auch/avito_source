package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
public final class NavOptions {
    public boolean a;
    @IdRes
    public int b;
    public boolean c;
    @AnimRes
    @AnimatorRes
    public int d;
    @AnimRes
    @AnimatorRes
    public int e;
    @AnimRes
    @AnimatorRes
    public int f;
    @AnimRes
    @AnimatorRes
    public int g;

    public static final class Builder {
        public boolean a;
        @IdRes
        public int b = -1;
        public boolean c;
        @AnimRes
        @AnimatorRes
        public int d = -1;
        @AnimRes
        @AnimatorRes
        public int e = -1;
        @AnimRes
        @AnimatorRes
        public int f = -1;
        @AnimRes
        @AnimatorRes
        public int g = -1;

        @NonNull
        public NavOptions build() {
            return new NavOptions(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }

        @NonNull
        public Builder setEnterAnim(@AnimRes @AnimatorRes int i) {
            this.d = i;
            return this;
        }

        @NonNull
        public Builder setExitAnim(@AnimRes @AnimatorRes int i) {
            this.e = i;
            return this;
        }

        @NonNull
        public Builder setLaunchSingleTop(boolean z) {
            this.a = z;
            return this;
        }

        @NonNull
        public Builder setPopEnterAnim(@AnimRes @AnimatorRes int i) {
            this.f = i;
            return this;
        }

        @NonNull
        public Builder setPopExitAnim(@AnimRes @AnimatorRes int i) {
            this.g = i;
            return this;
        }

        @NonNull
        public Builder setPopUpTo(@IdRes int i, boolean z) {
            this.b = i;
            this.c = z;
            return this;
        }
    }

    public NavOptions(boolean z, @IdRes int i, boolean z2, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        this.a = z;
        this.b = i;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
    }

    @AnimRes
    @AnimatorRes
    public int getEnterAnim() {
        return this.d;
    }

    @AnimRes
    @AnimatorRes
    public int getExitAnim() {
        return this.e;
    }

    @AnimRes
    @AnimatorRes
    public int getPopEnterAnim() {
        return this.f;
    }

    @AnimRes
    @AnimatorRes
    public int getPopExitAnim() {
        return this.g;
    }

    @IdRes
    public int getPopUpTo() {
        return this.b;
    }

    public boolean isPopUpToInclusive() {
        return this.c;
    }

    public boolean shouldLaunchSingleTop() {
        return this.a;
    }
}

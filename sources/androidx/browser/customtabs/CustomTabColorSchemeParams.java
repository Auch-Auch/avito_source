package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
public final class CustomTabColorSchemeParams {
    @Nullable
    @ColorInt
    public final Integer navigationBarColor;
    @Nullable
    @ColorInt
    public final Integer secondaryToolbarColor;
    @Nullable
    @ColorInt
    public final Integer toolbarColor;

    public static final class Builder {
        @Nullable
        @ColorInt
        public Integer a;
        @Nullable
        @ColorInt
        public Integer b;
        @Nullable
        @ColorInt
        public Integer c;

        @NonNull
        public CustomTabColorSchemeParams build() {
            return new CustomTabColorSchemeParams(this.a, this.b, this.c);
        }

        @NonNull
        public Builder setNavigationBarColor(@ColorInt int i) {
            this.c = Integer.valueOf(i | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }

        @NonNull
        public Builder setSecondaryToolbarColor(@ColorInt int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder setToolbarColor(@ColorInt int i) {
            this.a = Integer.valueOf(i | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }
    }

    public CustomTabColorSchemeParams(@Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2, @Nullable @ColorInt Integer num3) {
        this.toolbarColor = num;
        this.secondaryToolbarColor = num2;
        this.navigationBarColor = num3;
    }

    @NonNull
    public static CustomTabColorSchemeParams a(@Nullable Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle(0);
        }
        return new CustomTabColorSchemeParams((Integer) bundle.get(CustomTabsIntent.EXTRA_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR), (Integer) bundle.get(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR));
    }

    @NonNull
    public Bundle b() {
        Bundle bundle = new Bundle();
        Integer num = this.toolbarColor;
        if (num != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, num.intValue());
        }
        Integer num2 = this.secondaryToolbarColor;
        if (num2 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR, num2.intValue());
        }
        Integer num3 = this.navigationBarColor;
        if (num3 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR, num3.intValue());
        }
        return bundle;
    }
}

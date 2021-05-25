package androidx.browser.trusted;

import android.os.Bundle;
import androidx.annotation.NonNull;
public interface TrustedWebActivityDisplayMode {
    public static final String KEY_ID = "androidx.browser.trusted.displaymode.KEY_ID";

    public static class DefaultMode implements TrustedWebActivityDisplayMode {
        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        @NonNull
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 0);
            return bundle;
        }
    }

    public static class ImmersiveMode implements TrustedWebActivityDisplayMode {
        public static final String KEY_CUTOUT_MODE = "androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE";
        public static final String KEY_STICKY = "androidx.browser.trusted.displaymode.KEY_STICKY";
        public final boolean a;
        public final int b;

        public ImmersiveMode(boolean z, int i) {
            this.a = z;
            this.b = i;
        }

        public boolean isSticky() {
            return this.a;
        }

        public int layoutInDisplayCutoutMode() {
            return this.b;
        }

        @Override // androidx.browser.trusted.TrustedWebActivityDisplayMode
        @NonNull
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt(TrustedWebActivityDisplayMode.KEY_ID, 1);
            bundle.putBoolean(KEY_STICKY, this.a);
            bundle.putInt(KEY_CUTOUT_MODE, this.b);
            return bundle;
        }
    }

    @NonNull
    Bundle toBundle();
}

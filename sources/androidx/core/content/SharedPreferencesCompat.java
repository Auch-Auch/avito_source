package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.util.Objects;
@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {
        public static EditorCompat b;
        public final a a = new a();

        public static class a {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (b == null) {
                b = new EditorCompat();
            }
            return b;
        }

        @Deprecated
        public void apply(@NonNull SharedPreferences.Editor editor) {
            Objects.requireNonNull(this.a);
            try {
                editor.apply();
            } catch (AbstractMethodError unused) {
                editor.commit();
            }
        }
    }
}

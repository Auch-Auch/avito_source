package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {
        public final Context a;
        public final LayoutInflater b;
        public LayoutInflater c;

        public Helper(@NonNull Context context) {
            this.a = context;
            this.b = LayoutInflater.from(context);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.c;
            return layoutInflater != null ? layoutInflater : this.b;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
            if (theme == null) {
                this.c = null;
            } else if (theme == this.a.getTheme()) {
                this.c = this.b;
            } else {
                this.c = LayoutInflater.from(new ContextThemeWrapper(this.a, theme));
            }
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);
}

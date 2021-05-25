package l6.h.f;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;
@RequiresApi(24)
public final class c implements b {
    public final LocaleList a;

    public c(LocaleList localeList) {
        this.a = localeList;
    }

    @Override // l6.h.f.b
    public String a() {
        return this.a.toLanguageTags();
    }

    @Override // l6.h.f.b
    public Object b() {
        return this.a;
    }

    @Override // l6.h.f.b
    @Nullable
    public Locale c(@NonNull String[] strArr) {
        return this.a.getFirstMatch(strArr);
    }

    @Override // l6.h.f.b
    public int d(Locale locale) {
        return this.a.indexOf(locale);
    }

    public boolean equals(Object obj) {
        return this.a.equals(((b) obj).b());
    }

    @Override // l6.h.f.b
    public Locale get(int i) {
        return this.a.get(i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // l6.h.f.b
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // l6.h.f.b
    public int size() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }
}

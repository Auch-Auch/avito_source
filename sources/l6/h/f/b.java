package l6.h.f;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
public interface b {
    String a();

    Object b();

    @Nullable
    Locale c(@NonNull String[] strArr);

    @IntRange(from = -1)
    int d(Locale locale);

    Locale get(int i);

    boolean isEmpty();

    @IntRange(from = 0)
    int size();
}

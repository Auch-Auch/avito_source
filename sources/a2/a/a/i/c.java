package a2.a.a.i;

import com.avito.android.analytics.ErrorEvent;
import com.avito.android.analytics.ErrorSummary;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class c implements ErrorEvent {
    @NotNull
    public final ErrorSummary a;

    public c(@Nullable Throwable th) {
        this.a = new ErrorSummary(2, th, null, 4, null);
    }

    @Override // com.avito.android.analytics.ErrorEvent
    @NotNull
    public ErrorSummary getSummary() {
        return this.a;
    }
}

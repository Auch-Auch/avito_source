package a2.a.a.x1.q;

import com.avito.android.util.Rotation;
import io.reactivex.Observable;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
public interface c {
    void a(@NotNull Rotation rotation);

    void b(boolean z);

    @NotNull
    Observable<Unit> getClickObservable();

    void setEnabled(boolean z);

    void setVisibility(boolean z);
}

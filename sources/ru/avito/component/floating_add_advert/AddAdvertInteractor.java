package ru.avito.component.floating_add_advert;

import com.avito.android.util.loading_state.LoadingProgress;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/loading_state/LoadingProgress;", "", "Lru/avito/component/floating_add_advert/AdvertShortcut;", "getAdvertShortcutsLoadingProgress", "()Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/core/Single;", "getAdvertShortcuts", "()Lio/reactivex/rxjava3/core/Single;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AddAdvertInteractor {
    @NotNull
    Single<List<AdvertShortcut>> getAdvertShortcuts();

    @NotNull
    Observable<LoadingProgress<List<AdvertShortcut>>> getAdvertShortcutsLoadingProgress();
}

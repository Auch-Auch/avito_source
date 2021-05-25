package a2.a.a.j.a;

import com.avito.android.util.loading_state.LoadingProgress;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import ru.avito.component.floating_add_advert.AdvertShortcut;
public final class c<T> implements Predicate<LoadingProgress<? super List<? extends AdvertShortcut>>> {
    public static final c a = new c();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(LoadingProgress<? super List<? extends AdvertShortcut>> loadingProgress) {
        LoadingProgress<? super List<? extends AdvertShortcut>> loadingProgress2 = loadingProgress;
        return (loadingProgress2 instanceof LoadingProgress.Loaded) || (loadingProgress2 instanceof LoadingProgress.Error);
    }
}

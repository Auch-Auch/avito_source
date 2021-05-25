package a2.a.a.f1.g;

import com.avito.android.in_app_calls.task.InitCallClientTask;
import com.avito.android.permissions.PermissionState;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Pair;
public final class a<T, R> implements Function<Pair<? extends PermissionState, ? extends String>, CompletableSource> {
    public final /* synthetic */ InitCallClientTask.c a;

    public a(InitCallClientTask.c cVar) {
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(Pair<? extends PermissionState, ? extends String> pair) {
        return this.a.a.callAvailabilityUpdater.updateAvailability(false);
    }
}

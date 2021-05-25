package a2.a.a.q1;

import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.avito.android.notifications_settings.NotificationsSettingsPresenterImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class b<T> implements Consumer<LoadingState<? super Unit>> {
    public final /* synthetic */ NotificationsSettingsPresenterImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public b(NotificationsSettingsPresenterImpl notificationsSettingsPresenterImpl, String str, String str2) {
        this.a = notificationsSettingsPresenterImpl;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super Unit> loadingState) {
        LoadingState<? super Unit> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Error) {
            NotificationsSettingsPresenterImpl.access$bindSaveError(this.a, ((LoadingState.Error) loadingState2).getError());
        } else {
            this.a.n.accept(new NotificationSettingsChangeEvent(this.b, this.c));
        }
    }
}

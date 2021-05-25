package ru.avito.messenger;

import com.avito.android.util.preferences.SessionContract;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lru/avito/messenger/SessionProvider;", "", "Lio/reactivex/Single;", "", SessionContract.SESSION, "()Lio/reactivex/Single;", "Lio/reactivex/Observable;", "getSessionObservable", "()Lio/reactivex/Observable;", "sessionObservable", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SessionProvider {
    @NotNull
    Observable<String> getSessionObservable();

    @NotNull
    Single<String> session();
}

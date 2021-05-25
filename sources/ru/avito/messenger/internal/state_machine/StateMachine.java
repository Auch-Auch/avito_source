package ru.avito.messenger.internal.state_machine;

import androidx.exifinterface.media.ExifInterface;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u0005R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lru/avito/messenger/internal/state_machine/StateMachine;", ExifInterface.LATITUDE_SOUTH, "", "", Tracker.Events.CREATIVE_START, "()V", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "mutator", "enqueue", "(Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;)V", "shutdown", "Lio/reactivex/Observable;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "Mutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface StateMachine<S> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", ExifInterface.LATITUDE_SOUTH, "", "oldState", "Lio/reactivex/Single;", "apply", "(Ljava/lang/Object;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface Mutator<S> {
        @NotNull
        Single<S> apply(S s);
    }

    void enqueue(@NotNull Mutator<S> mutator);

    @NotNull
    Observable<S> getStateObservable();

    void shutdown();

    void start();
}

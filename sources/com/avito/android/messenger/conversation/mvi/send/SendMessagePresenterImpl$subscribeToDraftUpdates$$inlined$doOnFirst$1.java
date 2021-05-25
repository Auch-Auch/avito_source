package com.avito.android.messenger.conversation.mvi.send;

import arrow.core.Option;
import com.avito.android.messenger.analytics.ShowChatWithDraftEvent;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u00002\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u00000\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "obs", "Lio/reactivex/ObservableSource;", "apply", "(Lio/reactivex/Observable;)Lio/reactivex/ObservableSource;", "com/avito/android/util/Observables$doOnFirst$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SendMessagePresenterImpl$subscribeToDraftUpdates$$inlined$doOnFirst$1<T, R> implements Function<Observable<T>, ObservableSource<T>> {
    public final /* synthetic */ SendMessagePresenterImpl a;

    public SendMessagePresenterImpl$subscribeToDraftUpdates$$inlined$doOnFirst$1(SendMessagePresenterImpl sendMessagePresenterImpl) {
        this.a = sendMessagePresenterImpl;
    }

    public final ObservableSource<T> apply(@NotNull Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "obs");
        return Observable.merge(observable.skip(1), observable.take(1).doOnNext(new Consumer<T>(this) { // from class: com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl$subscribeToDraftUpdates$$inlined$doOnFirst$1.1
            public final /* synthetic */ SendMessagePresenterImpl$subscribeToDraftUpdates$$inlined$doOnFirst$1 a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(T t) {
                T t2 = t;
                String str = (String) t2.component2();
                DraftEntity draftEntity = (DraftEntity) ((Option) t2.component1()).orNull();
                String text = draftEntity != null ? draftEntity.getText() : null;
                if (!(text == null || m.isBlank(text))) {
                    this.a.a.A.track(new ShowChatWithDraftEvent(str));
                }
            }
        }));
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Observable) ((Observable) obj));
    }
}

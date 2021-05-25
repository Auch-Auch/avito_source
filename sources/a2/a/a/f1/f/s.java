package a2.a.a.f1.f;

import android.content.IntentFilter;
import com.avito.android.in_app_calls.service.RingtoneDelegateImpl;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
public final class s<T> implements ObservableOnSubscribe<Integer> {
    public final /* synthetic */ RingtoneDelegateImpl a;

    public static final class a implements Cancellable {
        public final /* synthetic */ s a;
        public final /* synthetic */ RingtoneDelegateImpl.c b;

        public a(s sVar, RingtoneDelegateImpl.c cVar) {
            this.a = sVar;
            this.b = cVar;
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            this.a.a.h.unregisterReceiver(this.b);
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ ObservableEmitter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ObservableEmitter observableEmitter) {
            super(1);
            this.a = observableEmitter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.ObservableEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            ObservableEmitter observableEmitter = this.a;
            Intrinsics.checkNotNullExpressionValue(observableEmitter, "emitter");
            if (!observableEmitter.isDisposed()) {
                this.a.onNext(Integer.valueOf(intValue));
            }
            return Unit.INSTANCE;
        }
    }

    public s(RingtoneDelegateImpl ringtoneDelegateImpl) {
        this.a = ringtoneDelegateImpl;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(@NotNull ObservableEmitter<Integer> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        RingtoneDelegateImpl.c cVar = new RingtoneDelegateImpl.c(this.a, new b(observableEmitter));
        this.a.h.registerReceiver(cVar, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        observableEmitter.setCancellable(new a(this, cVar));
    }
}

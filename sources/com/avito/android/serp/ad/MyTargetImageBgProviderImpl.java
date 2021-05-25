package com.avito.android.serp.ad;

import android.graphics.Bitmap;
import androidx.palette.graphics.Palette;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.BehaviorRelay;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R>\u0010\u0016\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u0013j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f`\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/serp/ad/MyTargetImageBgProviderImpl;", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "Landroid/graphics/Bitmap;", "bitmap", "", "key", "Lio/reactivex/rxjava3/core/Single;", "", "calculateBgColor", "(Landroid/graphics/Bitmap;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "observe", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Lcom/jakewharton/rxrelay3/BehaviorRelay;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "scheduler", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "relays", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MyTargetImageBgProviderImpl implements MyTargetImageBgProvider {
    public final HashMap<String, BehaviorRelay<Integer>> a = new HashMap<>();
    public final SchedulersFactory3 b;

    public static final class a<T> implements SingleOnSubscribe<Integer> {
        public final /* synthetic */ Bitmap a;

        public a(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // io.reactivex.rxjava3.core.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Integer> singleEmitter) {
            if (this.a.getWidth() == 0 || this.a.getHeight() == 0) {
                singleEmitter.onError(new IllegalArgumentException());
                return;
            }
            Palette generate = Palette.from(this.a).generate();
            Intrinsics.checkNotNullExpressionValue(generate, "Palette.from(bitmap).generate()");
            singleEmitter.onSuccess(Integer.valueOf(generate.getDominantColor(-1)));
        }
    }

    public static final class b<T> implements Consumer<Integer> {
        public final /* synthetic */ BehaviorRelay a;

        public b(BehaviorRelay behaviorRelay) {
            this.a = behaviorRelay;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.jakewharton.rxrelay3.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.a.accept(num);
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ MyTargetImageBgProviderImpl a;
        public final /* synthetic */ String b;

        public c(MyTargetImageBgProviderImpl myTargetImageBgProviderImpl, String str) {
            this.a = myTargetImageBgProviderImpl;
            this.b = str;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.a.remove(this.b);
        }
    }

    @Inject
    public MyTargetImageBgProviderImpl(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "scheduler");
        this.b = schedulersFactory3;
    }

    public final BehaviorRelay<Integer> a(String str) {
        BehaviorRelay<Integer> behaviorRelay = this.a.get(str);
        if (behaviorRelay != null) {
            return behaviorRelay;
        }
        BehaviorRelay<Integer> create = BehaviorRelay.create();
        HashMap<String, BehaviorRelay<Integer>> hashMap = this.a;
        Intrinsics.checkNotNullExpressionValue(create, "subject");
        hashMap.put(str, create);
        return create;
    }

    @Override // com.avito.android.serp.ad.MyTargetImageBgProvider
    @NotNull
    public Single<Integer> calculateBgColor(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "key");
        Single<Integer> doFinally = Single.create(new a(bitmap)).onErrorReturnItem(-1).subscribeOn(this.b.computation()).observeOn(this.b.mainThread()).doOnSuccess(new b(a(str))).doFinally(new c(this, str));
        Intrinsics.checkNotNullExpressionValue(doFinally, "Single.create<Int> { emi…remove(key)\n            }");
        return doFinally;
    }

    @Override // com.avito.android.serp.ad.MyTargetImageBgProvider
    @NotNull
    public Single<Integer> observe(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Single<Integer> firstOrError = a(str).firstOrError();
        Intrinsics.checkNotNullExpressionValue(firstOrError, "obtainRelay(key).firstOrError()");
        return firstOrError;
    }
}

package com.avito.android.in_app_calls.ui.call;

import androidx.lifecycle.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class CallFragment$bindCallView$$inlined$observeNotNull$1<T> implements Observer<T> {
    public final /* synthetic */ CallFragment a;

    public static final class a<T> implements Consumer<Long> {
        public final /* synthetic */ CallFragment$bindCallView$$inlined$observeNotNull$1 a;

        public a(CallFragment$bindCallView$$inlined$observeNotNull$1 callFragment$bindCallView$$inlined$observeNotNull$1) {
            this.a = callFragment$bindCallView$$inlined$observeNotNull$1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Long l) {
            CallFragment.access$finish(this.a.a);
        }
    }

    public CallFragment$bindCallView$$inlined$observeNotNull$1(CallFragment callFragment) {
        this.a = callFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t == null) {
            return;
        }
        if (t.booleanValue()) {
            this.a.f = Single.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
            return;
        }
        CallFragment.access$finish(this.a);
    }
}

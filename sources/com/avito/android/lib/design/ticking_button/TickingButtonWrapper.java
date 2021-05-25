package com.avito.android.lib.design.ticking_button;

import android.os.Bundle;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\b\b\u0002\u0010&\u001a\u00020#\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007J#\u0010\u0014\u001a\u00020\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0007J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010(R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010!¨\u0006."}, d2 = {"Lcom/avito/android/lib/design/ticking_button/TickingButtonWrapper;", "", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "", "dispose", "()V", "", "isLoading", "setLoading", "(Z)V", "", "timeSeconds", "startTicking", "(J)V", "stopTicking", "Lkotlin/Function1;", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "e", "Ljava/lang/String;", "initialText", "Lcom/avito/android/lib/design/button/Button;", "d", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "c", "J", "initialTime", "Lcom/avito/android/lib/design/ticking_button/TickingTimeFormatter;", "f", "Lcom/avito/android/lib/design/ticking_button/TickingTimeFormatter;", "timeFormatter", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "currentTime", "state", "<init>", "(Lcom/avito/android/lib/design/button/Button;Ljava/lang/String;Lcom/avito/android/lib/design/ticking_button/TickingTimeFormatter;Landroid/os/Bundle;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class TickingButtonWrapper {
    public Disposable a;
    public long b;
    public long c;
    public final Button d;
    public final String e;
    public final TickingTimeFormatter f;

    public static final class a<T> implements Consumer<Long> {
        public final /* synthetic */ TickingButtonWrapper a;

        public a(TickingButtonWrapper tickingButtonWrapper) {
            this.a = tickingButtonWrapper;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Long l) {
            TickingButtonWrapper tickingButtonWrapper = this.a;
            tickingButtonWrapper.b--;
            if (this.a.b <= 0) {
                Disposable disposable = this.a.a;
                if (disposable != null) {
                    disposable.dispose();
                }
                TickingButtonWrapper.access$applyInitialState(this.a);
                return;
            }
            this.a.b();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Ticking failed", th);
        }
    }

    public TickingButtonWrapper(@NotNull Button button, @NotNull String str, @NotNull TickingTimeFormatter tickingTimeFormatter, @Nullable Bundle bundle) {
        Disposable disposable;
        Intrinsics.checkNotNullParameter(button, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        Intrinsics.checkNotNullParameter(str, "initialText");
        Intrinsics.checkNotNullParameter(tickingTimeFormatter, "timeFormatter");
        this.d = button;
        this.e = str;
        this.f = tickingTimeFormatter;
        if (bundle != null) {
            this.b = bundle.getLong("key_current_time");
            this.c = bundle.getLong("key_initial_time");
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - bundle.getLong("key_timestamp_sec");
            long j = this.b;
            if (seconds >= j) {
                this.b = this.c;
            } else {
                this.b = j - seconds;
            }
        }
        if (this.b >= this.c || ((disposable = this.a) != null && !disposable.isDisposed())) {
            button.setText(str);
            return;
        }
        b();
        a();
    }

    public static final void access$applyInitialState(TickingButtonWrapper tickingButtonWrapper) {
        tickingButtonWrapper.b = tickingButtonWrapper.c;
        tickingButtonWrapper.d.setEnabled(true);
        tickingButtonWrapper.d.setText(tickingButtonWrapper.e);
    }

    public final void a() {
        this.d.setEnabled(false);
        b();
        this.a = Observable.interval(1, TimeUnit.SECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a);
    }

    public final void b() {
        this.d.setText(this.f.formatSeconds(this.b));
    }

    public final void dispose() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @NotNull
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putLong("key_current_time", this.b);
        bundle.putLong("key_initial_time", this.c);
        bundle.putLong("key_timestamp_sec", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        return bundle;
    }

    public final void setLoading(boolean z) {
        this.d.setLoading(z);
        this.d.setEnabled(!z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.a.a.k1.a.k.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setOnClickListener(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super android.view.View, kotlin.Unit> r3) {
        /*
            r2 = this;
            com.avito.android.lib.design.button.Button r0 = r2.d
            if (r3 == 0) goto L_0x000a
            a2.a.a.k1.a.k.a r1 = new a2.a.a.k1.a.k.a
            r1.<init>(r3)
            r3 = r1
        L_0x000a:
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r0.setOnClickListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.ticking_button.TickingButtonWrapper.setOnClickListener(kotlin.jvm.functions.Function1):void");
    }

    public final void startTicking(long j) {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = j;
        this.b = j;
        a();
    }

    public final void stopTicking() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = this.c;
        this.d.setEnabled(true);
        this.d.setText(this.e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TickingButtonWrapper(Button button, String str, TickingTimeFormatter tickingTimeFormatter, Bundle bundle, int i, j jVar) {
        this(button, str, (i & 4) != 0 ? new DefaultTickingTimeFormatter() : tickingTimeFormatter, bundle);
    }
}

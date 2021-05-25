package com.avito.android.verification.verification_status.actions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.verification.VerificationResourceProvider;
import com.avito.android.verification.di.VerificationType;
import com.avito.android.verification.verification_status.VerificationStatusInteractor;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB)\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCancelRequest", "()V", "", "f", "Ljava/lang/String;", "verificationType", "Lcom/avito/android/verification/VerificationResourceProvider;", "e", "Lcom/avito/android/verification/VerificationResourceProvider;", "resourceProvider", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction;", "d", "Landroidx/lifecycle/LiveData;", "getRouterAction", "()Landroidx/lifecycle/LiveData;", "routerAction", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "c", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "routerActionLiveData", "Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/verification/verification_status/VerificationStatusInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/verification/VerificationResourceProvider;Ljava/lang/String;)V", "RouterAction", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationActionViewModel extends ViewModel {
    public final SingleLiveEvent<RouterAction> c;
    @NotNull
    public final LiveData<RouterAction> d;
    public final VerificationResourceProvider e;
    public final String f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction;", "", "<init>", "()V", "Cancel", "Close", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction$Close;", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction$Cancel;", "verification_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class RouterAction {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction$Cancel;", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction;", "<init>", "()V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Cancel extends RouterAction {
            @NotNull
            public static final Cancel INSTANCE = new Cancel();

            public Cancel() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction$Close;", "Lcom/avito/android/verification/verification_status/actions/VerificationActionViewModel$RouterAction;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", AuthSource.BOOKING_ORDER, "Z", "getStatus", "()Z", "status", "<init>", "(Ljava/lang/String;Z)V", "verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class Close extends RouterAction {
            @NotNull
            public final String a;
            public final boolean b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Close(@NotNull String str, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "message");
                this.a = str;
                this.b = z;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }

            public final boolean getStatus() {
                return this.b;
            }
        }

        public RouterAction() {
        }

        public RouterAction(j jVar) {
        }
    }

    public static final class a<T> implements Consumer<SimpleMessageResult> {
        public final /* synthetic */ VerificationActionViewModel a;

        public a(VerificationActionViewModel verificationActionViewModel) {
            this.a = verificationActionViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SimpleMessageResult simpleMessageResult) {
            String message = simpleMessageResult.getMessage();
            if (message != null) {
                this.a.c.setValue(new RouterAction.Close(message, true));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ VerificationActionViewModel a;

        public b(VerificationActionViewModel verificationActionViewModel) {
            this.a = verificationActionViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            SingleLiveEvent singleLiveEvent = this.a.c;
            String message = th.getMessage();
            if (message == null) {
                message = this.a.e.getRemoveActionDefaultErrorMessage();
            }
            singleLiveEvent.setValue(new RouterAction.Close(message, false));
        }
    }

    public VerificationActionViewModel(@NotNull VerificationStatusInteractor verificationStatusInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull VerificationResourceProvider verificationResourceProvider, @VerificationType @NotNull String str) {
        Intrinsics.checkNotNullParameter(verificationStatusInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(verificationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(str, "verificationType");
        this.e = verificationResourceProvider;
        this.f = str;
        SingleLiveEvent<RouterAction> singleLiveEvent = new SingleLiveEvent<>();
        this.c = singleLiveEvent;
        this.d = singleLiveEvent;
        verificationStatusInteractor.removeVerification(str).observeOn(schedulersFactory3.mainThread()).subscribe(new a(this), new b(this));
    }

    @NotNull
    public final LiveData<RouterAction> getRouterAction() {
        return this.d;
    }

    public final void onCancelRequest() {
        this.c.setValue(RouterAction.Cancel.INSTANCE);
    }
}

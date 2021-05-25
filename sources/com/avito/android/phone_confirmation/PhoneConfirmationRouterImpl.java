package com.avito.android.phone_confirmation;

import android.app.Activity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/phone_confirmation/PhoneConfirmationRouterImpl;", "Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;", "Lio/reactivex/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "getFinish", "()Lio/reactivex/functions/Consumer;", "finish", "Landroid/app/Activity;", AuthSource.BOOKING_ORDER, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationRouterImpl implements PhoneConfirmationRouter {
    @NotNull
    public final Consumer<Boolean> a = new a(this);
    @NotNull
    public final Activity b;

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ PhoneConfirmationRouterImpl a;

        public a(PhoneConfirmationRouterImpl phoneConfirmationRouterImpl) {
            this.a = phoneConfirmationRouterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Activity activity = this.a.getActivity();
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            activity.setResult(bool2.booleanValue() ? -1 : 0);
            Keyboards.hideKeyboard(this.a.getActivity());
            this.a.getActivity().finish();
        }
    }

    @Inject
    public PhoneConfirmationRouterImpl(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
    }

    @NotNull
    public final Activity getActivity() {
        return this.b;
    }

    @Override // com.avito.android.phone_confirmation.PhoneConfirmationRouter
    @NotNull
    public Consumer<Boolean> getFinish() {
        return this.a;
    }
}

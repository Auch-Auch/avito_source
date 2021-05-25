package com.avito.android.rating.review_details.reply;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\nR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/rating/review_details/reply/ReviewReplyViewImpl;", "Lcom/avito/android/rating/review_details/reply/ReviewReplyView;", "Lio/reactivex/rxjava3/core/Observable;", "", "textChanges", "()Lio/reactivex/rxjava3/core/Observable;", "", "buttonClicks", "reply", "setReplyText", "(Ljava/lang/String;)V", "", "isLoading", "setLoading", "(Z)V", "message", "showErrorMessage", "hideErrorMessage", "()V", "showSnackbar", "Lcom/avito/android/lib/design/button/Button;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/button/Button;", "sendButton", "Lcom/avito/android/lib/design/input/Input;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/input/Input;", "replyInput", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "d", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinator", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "c", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "componentContainer", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class ReviewReplyViewImpl implements ReviewReplyView {
    public final Input a;
    public final Button b;
    public final ComponentContainer c;
    public final CoordinatorLayout d;

    public ReviewReplyViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.reply_input);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById;
        this.a = input;
        View findViewById2 = view.findViewById(R.id.send_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById2;
        this.b = button;
        View findViewById3 = view.findViewById(R.id.component_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.c = (ComponentContainer) findViewById3;
        View findViewById4 = view.findViewById(R.id.coordinator);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        this.d = (CoordinatorLayout) findViewById4;
        button.setText(R.string.send_button_title);
        setLoading(false);
        hideErrorMessage();
        input.requestFocus();
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyView
    @NotNull
    public Observable<Unit> buttonClicks() {
        return RxView.clicks(this.b);
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyView
    public void hideErrorMessage() {
        ComponentContainer.showError$default(this.c, new int[]{R.id.reply_input}, null, null, 4, null);
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyView
    public void setLoading(boolean z) {
        this.b.setLoading(z);
        this.b.setClickable(!z);
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyView
    public void setReplyText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "reply");
        Input.setText$default(this.a, str, false, 2, null);
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyView
    public void showErrorMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        ComponentContainer.showError$default(this.c, new int[]{R.id.reply_input}, str, null, 4, null);
    }

    @Override // com.avito.android.rating.review_details.reply.ReviewReplyView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.d, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.g2.c.b.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.rating.review_details.reply.ReviewReplyView
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<java.lang.String> textChanges() {
        /*
            r3 = this;
            com.avito.android.lib.design.input.Input r0 = r3.a
            com.jakewharton.rxbinding3.InitialValueObservable r0 = com.avito.android.lib.design.input.InputExtensionsKt.textChanges(r0)
            io.reactivex.Observable r0 = r0.skipInitialValue()
            com.avito.android.rating.review_details.reply.ReviewReplyViewImpl$a r1 = com.avito.android.rating.review_details.reply.ReviewReplyViewImpl.a.a
            if (r1 == 0) goto L_0x0014
            a2.a.a.g2.c.b.b r2 = new a2.a.a.g2.c.b.b
            r2.<init>(r1)
            r1 = r2
        L_0x0014:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Observable r0 = r0.map(r1)
            java.lang.String r1 = "replyInput.textChanges()…p(CharSequence::toString)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            io.reactivex.rxjava3.core.Observable r0 = com.avito.android.util.rx3.InteropKt.toV3(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.review_details.reply.ReviewReplyViewImpl.textChanges():io.reactivex.rxjava3.core.Observable");
    }
}

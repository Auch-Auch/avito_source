package com.avito.android.extended_profile.adapter.error;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.extended_profile.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/avito/android/extended_profile/adapter/error/ErrorItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/error/ErrorItemView;", "", "message", "", "showMessage", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lio/reactivex/rxjava3/core/Observable;", VKApiConst.VERSION, "Lio/reactivex/rxjava3/core/Observable;", "getClicks", "()Lio/reactivex/rxjava3/core/Observable;", "clicks", "u", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "messageView", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorItemViewImpl extends BaseViewHolder implements ErrorItemView {
    public final TextView s;
    public final Button t;
    public Function0<Unit> u;
    @NotNull
    public final Observable<Unit> v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById2;
        this.t = button;
        this.v = RxView.clicks(button);
    }

    @Override // com.avito.android.extended_profile.adapter.error.ErrorItemView
    @NotNull
    public Observable<Unit> getClicks() {
        return this.v;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.u;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.extended_profile.adapter.error.ErrorItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }

    @Override // com.avito.android.extended_profile.adapter.error.ErrorItemView
    public void showMessage(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
    }
}

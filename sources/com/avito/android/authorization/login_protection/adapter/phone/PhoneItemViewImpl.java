package com.avito.android.authorization.login_protection.adapter.phone;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.avito.android.authorization.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItemView;", "", "phoneNumber", "", "showPhoneNumber", "(Ljava/lang/String;)V", "", "highlightStart", "highlightEnd", "showPhoneNumberWithHighlight", "(Ljava/lang/String;II)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Lio/reactivex/rxjava3/core/Observable;", "u", "Lio/reactivex/rxjava3/core/Observable;", "getItemClicks", "()Lio/reactivex/rxjava3/core/Observable;", "itemClicks", "t", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneItemViewImpl extends BaseViewHolder implements PhoneItemView {
    public final TextView s;
    public Function0<Unit> t;
    @NotNull
    public final Observable<Unit> u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.s = textView;
        this.u = RxView.clicks(textView);
    }

    @Override // com.avito.android.authorization.login_protection.adapter.phone.PhoneItemView
    @NotNull
    public Observable<Unit> getItemClicks() {
        return this.u;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.t;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.authorization.login_protection.adapter.phone.PhoneItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.t = function0;
    }

    @Override // com.avito.android.authorization.login_protection.adapter.phone.PhoneItemView
    public void showPhoneNumber(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.authorization.login_protection.adapter.phone.PhoneItemView
    public void showPhoneNumberWithHighlight(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), i, i2 + 1, 33);
        TextViews.bindText$default(this.s, spannableString, false, 2, null);
    }
}

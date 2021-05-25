package com.avito.android.extended_profile.adapter.info;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import com.avito.android.extended_profile.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/avito/android/extended_profile/adapter/info/InfoItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/info/InfoItemView;", "", "text", "", "isCollapsed", "", "showText", "(Ljava/lang/CharSequence;Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "expandLabel", "s", "textView", "Lio/reactivex/rxjava3/core/Observable;", "w", "Lio/reactivex/rxjava3/core/Observable;", "getExpandClicks", "()Lio/reactivex/rxjava3/core/Observable;", "expandClicks", "", VKApiConst.VERSION, "I", "maxLines", "u", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "rootView", "isTablet", "<init>", "(Landroid/view/View;Z)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class InfoItemViewImpl extends BaseViewHolder implements InfoItemView {
    public final TextView s;
    public final TextView t;
    public Function0<Unit> u;
    public final int v;
    @NotNull
    public final Observable<Unit> w;

    public static final class a implements Runnable {
        public final /* synthetic */ InfoItemViewImpl a;

        public a(InfoItemViewImpl infoItemViewImpl) {
            this.a = infoItemViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Layout layout = this.a.s.getLayout();
            if (layout != null) {
                int lineCount = layout.getLineCount();
                if (lineCount <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
                    Views.hide(this.a.t);
                } else {
                    Views.show(this.a.t);
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoItemViewImpl(@NotNull View view, boolean z) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.extended_info_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.expand_label);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        this.t = textView;
        this.v = z ? 2 : 6;
        this.w = RxView.clicks(textView);
    }

    @Override // com.avito.android.extended_profile.adapter.info.InfoItemView
    @NotNull
    public Observable<Unit> getExpandClicks() {
        return this.w;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.u;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.extended_profile.adapter.info.InfoItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }

    @Override // com.avito.android.extended_profile.adapter.info.InfoItemView
    public void showText(@NotNull CharSequence charSequence, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        if (z) {
            this.s.setMaxLines(this.v);
        } else {
            this.s.setMaxLines(Integer.MAX_VALUE);
        }
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
        this.s.post(new a(this));
    }
}

package com.avito.android.user_advert.advert;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\nR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001d¨\u0006#"}, d2 = {"Lcom/avito/android/user_advert/advert/AdvertActionsViewImpl;", "Lcom/avito/android/user_advert/advert/AdvertActionsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "primaryActionClicks", "()Lio/reactivex/rxjava3/core/Observable;", "secondaryActionClicks", "", "isVisible", "setActionsVisibility", "(Z)V", "", "text", "bindActionsHintText", "(Ljava/lang/String;)V", "bindPrimaryAction", "bindSecondaryAction", "setPrimaryActionVisibility", "setSecondaryActionVisibility", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "hintView", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Lru/avito/component/button/ButtonImpl;", AuthSource.BOOKING_ORDER, "Lru/avito/component/button/ButtonImpl;", "primaryButton", "c", "secondaryButton", "<init>", "(Landroid/view/View;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertActionsViewImpl implements AdvertActionsView {
    public final TextView a;
    public final ButtonImpl b;
    public final ButtonImpl c;
    public final View d;

    public AdvertActionsViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = view.findViewById(R.id.actions_hint);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.action_primary);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = new ButtonImpl(findViewById2);
        View findViewById3 = view.findViewById(R.id.action_secondary);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = new ButtonImpl(findViewById3);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void bindActionsHintText(@Nullable String str) {
        TextViews.bindText$default(this.a, str, false, 2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if ((r4.length() > 0) != false) goto L_0x0018;
     */
    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindPrimaryAction(@org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r3 = this;
            ru.avito.component.button.ButtonImpl r0 = r3.b
            r0.setText(r4)
            ru.avito.component.button.ButtonImpl r0 = r3.b
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L_0x0017
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0013
            r4 = 1
            goto L_0x0014
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r0.setVisible(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.AdvertActionsViewImpl.bindPrimaryAction(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if ((r4.length() > 0) != false) goto L_0x0018;
     */
    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindSecondaryAction(@org.jetbrains.annotations.Nullable java.lang.String r4) {
        /*
            r3 = this;
            ru.avito.component.button.ButtonImpl r0 = r3.c
            r0.setText(r4)
            ru.avito.component.button.ButtonImpl r0 = r3.c
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L_0x0017
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0013
            r4 = 1
            goto L_0x0014
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r0.setVisible(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.AdvertActionsViewImpl.bindSecondaryAction(java.lang.String):void");
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    @NotNull
    public Observable<Unit> primaryActionClicks() {
        return ButtonsKt.clicks(this.b);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    @NotNull
    public Observable<Unit> secondaryActionClicks() {
        return ButtonsKt.clicks(this.c);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void setActionsVisibility(boolean z) {
        Views.setVisible(this.d, z);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void setPrimaryActionVisibility(boolean z) {
        this.b.setVisible(z);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void setSecondaryActionVisibility(boolean z) {
        this.c.setVisible(z);
    }
}

package ru.avito.component.payments.method.list.button;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.ui_components.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.button.ButtonViewHolder;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0011\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0017\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/avito/component/payments/method/list/button/ButtonPaymentMethodViewHolder;", "Lru/avito/component/button/ButtonViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/button/Button;", "", "isEnabled", "()Z", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "enabled", "setEnabled", "(Z)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "visible", "setVisible", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonPaymentMethodViewHolder extends BaseViewHolder implements ButtonViewHolder, Button {
    public final View s;
    public final /* synthetic */ ButtonImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonPaymentMethodViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.button_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.t = new ButtonImpl(findViewById);
        this.s = view;
    }

    @Override // ru.avito.component.button.Button
    public boolean isEnabled() {
        return this.t.isEnabled();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ButtonViewHolder.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.button.Button
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.t.setClickListener(function0);
    }

    @Override // ru.avito.component.button.Button
    public void setEnabled(boolean z) {
        this.t.setEnabled(z);
    }

    @Override // ru.avito.component.button.Button
    public void setText(@StringRes int i) {
        this.t.setText(i);
    }

    @Override // ru.avito.component.button.Button
    public void setText(@Nullable CharSequence charSequence) {
        this.t.setText(charSequence);
    }

    @Override // ru.avito.component.button.Button
    public void setVisible(boolean z) {
        this.t.setVisible(z);
    }
}

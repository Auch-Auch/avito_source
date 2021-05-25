package com.avito.android.abuse.details.adapter;

import android.view.View;
import com.avito.android.abuse.R;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/avito/android/abuse/details/adapter/ButtonItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/abuse/details/adapter/ButtonItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "Lru/avito/component/button/ButtonImpl;", "s", "Lru/avito/component/button/ButtonImpl;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItemViewImpl extends BaseViewHolder implements ButtonItemView {
    public final ButtonImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = new ButtonImpl(findViewById);
    }

    @Override // com.avito.android.abuse.details.adapter.ButtonItemView
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.s.setClickListener(function0);
    }

    @Override // com.avito.android.abuse.details.adapter.ButtonItemView
    public void setText(@Nullable CharSequence charSequence) {
        this.s.setText(charSequence);
    }
}

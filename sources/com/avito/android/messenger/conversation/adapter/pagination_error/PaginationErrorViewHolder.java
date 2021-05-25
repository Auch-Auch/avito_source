package com.avito.android.messenger.conversation.adapter.pagination_error;

import android.view.View;
import com.avito.android.messenger.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/messenger/conversation/adapter/pagination_error/PaginationErrorView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRetryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lru/avito/component/button/ButtonImpl;", "s", "Lru/avito/component/button/ButtonImpl;", "getRetryButton", "()Lru/avito/component/button/ButtonImpl;", "retryButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PaginationErrorViewHolder extends BaseViewHolder implements PaginationErrorView {
    @NotNull
    public final ButtonImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaginationErrorViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.retry_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.retry_button)");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById);
        this.s = buttonImpl;
        buttonImpl.setText(R.string.retry);
    }

    @NotNull
    public final ButtonImpl getRetryButton() {
        return this.s;
    }

    @Override // com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorView
    public void setRetryClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setClickListener(function0);
    }
}

package com.avito.android.conveyor_shared_item.notification;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import com.avito.android.lib.design.R;
import com.avito.android.util.Contexts;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/avito/android/conveyor_shared_item/notification/NotificationItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/conveyor_shared_item/notification/NotificationItemView;", "", "showAsHint", "()V", "showAsWarning", "showAsError", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "info", "Landroid/view/View;", "s", "Landroid/view/View;", "divider", "view", "", "sidePaddingRes", "<init>", "(Landroid/view/View;Ljava/lang/Integer;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationItemViewHolder extends BaseViewHolder implements NotificationItemView {
    public final View s;
    public final TextView t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotificationItemViewHolder(View view, Integer num, int i, j jVar) {
        this(view, (i & 2) != 0 ? null : num);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.t.setOnClickListener(null);
    }

    @Override // com.avito.android.conveyor_shared_item.notification.NotificationItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.conveyor_shared_item.notification.NotificationItemView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.t.setText(charSequence);
        this.t.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.avito.android.conveyor_shared_item.notification.NotificationItemView
    public void showAsError() {
        View view = this.s;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "divider.context");
        view.setBackgroundColor(Contexts.getColorByAttr(context, R.attr.red));
    }

    @Override // com.avito.android.conveyor_shared_item.notification.NotificationItemView
    public void showAsHint() {
        View view = this.s;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "divider.context");
        view.setBackgroundColor(Contexts.getColorByAttr(context, R.attr.blue));
    }

    @Override // com.avito.android.conveyor_shared_item.notification.NotificationItemView
    public void showAsWarning() {
        View view = this.s;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "divider.context");
        view.setBackgroundColor(Contexts.getColorByAttr(context, R.attr.orange));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationItemViewHolder(@NotNull View view, @DimenRes @Nullable Integer num) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (num != null) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(num.intValue());
            view.setPadding(dimensionPixelSize, view.getPaddingTop(), dimensionPixelSize, view.getPaddingBottom());
        }
        View findViewById = view.findViewById(com.avito.android.conveyor_shared_item.R.id.divider);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById;
        View findViewById2 = view.findViewById(com.avito.android.conveyor_shared_item.R.id.info_text);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
    }
}

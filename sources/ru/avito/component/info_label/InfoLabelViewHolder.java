package ru.avito.component.info_label;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.animator.AnimatorViewHolder;
import ru.avito.component.info_label.InfoLabelItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u000e\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lru/avito/component/info_label/InfoLabelViewHolder;", "Lru/avito/component/info_label/InfoLabelItemView;", "Lru/avito/component/animator/AnimatorViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "Lru/avito/component/info_label/InfoLevel;", "infoLevel", "", "setValues", "(Ljava/lang/CharSequence;Lru/avito/component/info_label/InfoLevel;)V", "", "getShouldAnimateError", "()Z", "shouldAnimateError", "Lru/avito/component/info_label/InfoLabel;", "s", "Lru/avito/component/info_label/InfoLabel;", "labelView", "Lru/avito/component/info_label/InfoLabelAnimatorStrategy;", "u", "Lru/avito/component/info_label/InfoLabelAnimatorStrategy;", "getAnimatorStrategy", "()Lru/avito/component/info_label/InfoLabelAnimatorStrategy;", "animatorStrategy", "t", "Lru/avito/component/info_label/InfoLevel;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InfoLabelViewHolder extends BaseViewHolder implements InfoLabelItemView, AnimatorViewHolder {
    public final InfoLabel s;
    public InfoLevel t;
    @NotNull
    public final InfoLabelAnimatorStrategy u = InfoLabelAnimatorStrategy.INSTANCE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoLabelViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new InfoLabel(view);
    }

    public final boolean getShouldAnimateError() {
        return this.t == InfoLevel.ERROR;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        InfoLabelItemView.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.info_label.InfoLabelItemView
    public void setValues(@NotNull CharSequence charSequence, @NotNull InfoLevel infoLevel) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(infoLevel, "infoLevel");
        this.s.setValues(charSequence, infoLevel);
        this.t = infoLevel;
    }

    @Override // ru.avito.component.animator.AnimatorViewHolder
    @NotNull
    public InfoLabelAnimatorStrategy getAnimatorStrategy() {
        return this.u;
    }
}

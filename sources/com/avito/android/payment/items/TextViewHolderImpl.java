package com.avito.android.payment.items;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.payment.R;
import com.avito.android.payment.items.TextViewHolder;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\t\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u0006R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/payment/items/TextViewHolderImpl;", "Lcom/avito/android/payment/items/TextViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/text/Text;", "", "hide", "()V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "show", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TextViewHolderImpl extends BaseViewHolder implements TextViewHolder, Text {
    public final View s;
    public final /* synthetic */ TextImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.text_include);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.text_include)");
        this.t = new TextImpl(findViewById);
        this.s = view;
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        this.t.hide();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        TextViewHolder.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.t.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.t.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.t.show();
    }
}

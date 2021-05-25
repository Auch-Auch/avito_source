package com.avito.android.component.unselectable_single_line;

import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/component/unselectable_single_line/UnselectableSingleLineImpl;", "Lcom/avito/android/component/unselectable_single_line/UnselectableSingleLine;", "", "value", "", "setValue", "(Ljava/lang/String;)V", "", "hint", "setHint", "(Ljava/lang/CharSequence;)V", "", "hintRes", "(I)V", "show", "()V", "hide", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "valueView", AuthSource.SEND_ABUSE, "hintView", "Landroid/view/View;", "c", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class UnselectableSingleLineImpl implements UnselectableSingleLine {
    public final TextView a;
    public final TextView b;
    public final View c;

    public UnselectableSingleLineImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.c = view;
        View findViewById = view.findViewById(R.id.hint);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.value);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
    }

    @Override // com.avito.android.component.unselectable_single_line.UnselectableSingleLine
    public void hide() {
        Views.hide(this.c);
    }

    @Override // com.avito.android.component.unselectable_single_line.UnselectableSingleLine
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "hint");
        this.a.setText(charSequence);
    }

    @Override // com.avito.android.component.unselectable_single_line.UnselectableSingleLine
    public void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.b.setText(str);
    }

    @Override // com.avito.android.component.unselectable_single_line.UnselectableSingleLine
    public void show() {
        Views.show(this.c);
    }

    @Override // com.avito.android.component.unselectable_single_line.UnselectableSingleLine
    public void setHint(int i) {
        this.a.setText(i);
    }
}

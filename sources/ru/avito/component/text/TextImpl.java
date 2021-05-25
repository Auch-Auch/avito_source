package ru.avito.component.text;

import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lru/avito/component/text/TextImpl;", "Lru/avito/component/text/Text;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "show", "()V", "hide", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public final class TextImpl implements Text {
    public final TextView a;

    public TextImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (TextView) view;
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        Views.hide(this.a);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        Views.show(this.a);
    }

    @Override // ru.avito.component.text.Text
    public void setText(int i) {
        this.a.setText(i);
    }
}

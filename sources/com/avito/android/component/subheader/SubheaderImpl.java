package com.avito.android.component.subheader;

import android.view.View;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\r\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/avito/android/component/subheader/SubheaderImpl;", "Lcom/avito/android/component/subheader/Subheader;", "Lru/avito/component/text/Text;", "", "hide", "()V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "show", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SubheaderImpl implements Subheader, Text {
    public final /* synthetic */ TextImpl a;

    public SubheaderImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = new TextImpl(view);
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        this.a.hide();
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.a.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        this.a.show();
    }
}

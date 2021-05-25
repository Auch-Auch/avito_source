package ru.avito.component.button;

import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Deprecated(message = "Используй Button вместо этого")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lru/avito/component/button/ButtonImpl;", "Lru/avito/component/button/Button;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "", "enabled", "setEnabled", "(Z)V", "isEnabled", "()Z", "visible", "setVisible", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public class ButtonImpl implements Button {
    public final TextView a;

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

    public ButtonImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (TextView) view;
    }

    @Override // ru.avito.component.button.Button
    public boolean isEnabled() {
        return this.a.isEnabled();
    }

    @Override // ru.avito.component.button.Button
    public void setClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.a.setOnClickListener(null);
        } else {
            this.a.setOnClickListener(new a(function0));
        }
    }

    @Override // ru.avito.component.button.Button
    public void setEnabled(boolean z) {
        this.a.setEnabled(z);
    }

    @Override // ru.avito.component.button.Button
    public void setText(@Nullable CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.button.Button
    public void setVisible(boolean z) {
        Views.setVisible(this.a, z);
    }

    @Override // ru.avito.component.button.Button
    public void setText(int i) {
        this.a.setText(i);
    }
}

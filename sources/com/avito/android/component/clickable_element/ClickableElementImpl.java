package com.avito.android.component.clickable_element;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0011\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0019\u0010\u0012J\u001a\u0010\u0019\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/component/clickable_element/ClickableElementImpl;", "Lcom/avito/android/component/clickable_element/ClickableElement;", "Lru/avito/component/text/Text;", "", "enabled", "", "setEnabled", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setDescription", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "show", "()V", "hide", "setText", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "descriptionView", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ClickableElementImpl implements ClickableElement, Text {
    public final TextView a;
    public final View b;
    public final /* synthetic */ TextImpl c;

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

    public ClickableElementImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.c = new TextImpl(findViewById);
        this.b = view;
        View findViewById2 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById2;
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.b);
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        Views.hide(this.b);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.a, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.b.setOnClickListener(null);
        } else {
            this.b.setOnClickListener(new a(function0));
        }
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.c.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        Views.show(this.b);
    }

    @Override // com.avito.android.component.clickable_element.ClickableElement
    public void setDescription(@StringRes int i) {
        Views.show(this.a);
        this.a.setText(i);
    }
}

package ru.avito.component.dialog;

import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button_panel.ButtonPanel;
import ru.avito.component.button_panel.ButtonPanelImpl;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0019\u0010\u0015\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0007J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u001d\u0010\u0011J\u001a\u0010\u001d\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u001d\u0010\u0007J \u0010 \u001a\u00020\u00052\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001eH\u0001¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\"\u0010\u001cJ\u001a\u0010#\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b#\u0010\u0011J\u001a\u0010#\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u0003H\u0001¢\u0006\u0004\b#\u0010\u0007J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0019H\u0001¢\u0006\u0004\b%\u0010\u001cJ \u0010&\u001a\u00020\u00052\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001eH\u0001¢\u0006\u0004\b&\u0010!R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00069"}, d2 = {"Lru/avito/component/dialog/SimpleDialogImpl;", "Lru/avito/component/dialog/SimpleDialog;", "Lru/avito/component/button_panel/ButtonPanel;", "", "imageId", "", "setImage", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "showImage", "()V", "hideImage", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "textId", "showTitle", "hideTitle", "setBody", "showBody", "hideBody", "setEmbeddedLink", "", "enabled", "setPrimaryButtonEnabled", "(Z)V", "setPrimaryButtonText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPrimaryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setSecondaryButtonEnabled", "setSecondaryButtonText", "visible", "setSecondaryButtonVisible", "setSecondaryClickListener", "Lru/avito/component/text/TextImpl;", "d", "Lru/avito/component/text/TextImpl;", "embeddedLink", "Lru/avito/component/text/Text;", AuthSource.BOOKING_ORDER, "Lru/avito/component/text/Text;", "titleText", "c", "bodyText", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "image", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleDialogImpl implements SimpleDialog, ButtonPanel {
    public final ImageView a;
    public final Text b;
    public final Text c;
    public final TextImpl d;
    public final /* synthetic */ ButtonPanelImpl e;

    public SimpleDialogImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.button_panel);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.e = new ButtonPanelImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.a = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.b = new TextImpl(findViewById3);
        View findViewById4 = view.findViewById(R.id.body);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.c = new TextImpl(findViewById4);
        View findViewById5 = view.findViewById(R.id.embedded_link);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById5;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Unit unit = Unit.INSTANCE;
        this.d = new TextImpl(textView);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void hideBody() {
        this.c.hide();
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void hideImage() {
        Views.setVisible(this.a, false);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void hideTitle() {
        this.b.hide();
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void setBody(@Nullable CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void setEmbeddedLink(@Nullable CharSequence charSequence) {
        if (charSequence != null) {
            this.d.show();
            this.d.setText(charSequence);
            return;
        }
        this.d.hide();
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void setImage(int i) {
        this.a.setImageResource(i);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonEnabled(boolean z) {
        this.e.setPrimaryButtonEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(@StringRes int i) {
        this.e.setPrimaryButtonText(i);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(@Nullable CharSequence charSequence) {
        this.e.setPrimaryButtonText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryClickListener(@Nullable Function0<Unit> function0) {
        this.e.setPrimaryClickListener(function0);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonEnabled(boolean z) {
        this.e.setSecondaryButtonEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(@StringRes int i) {
        this.e.setSecondaryButtonText(i);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(@Nullable CharSequence charSequence) {
        this.e.setSecondaryButtonText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonVisible(boolean z) {
        this.e.setSecondaryButtonVisible(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryClickListener(@Nullable Function0<Unit> function0) {
        this.e.setSecondaryClickListener(function0);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void setTitle(@Nullable CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void showBody() {
        this.c.show();
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void showImage() {
        Views.setVisible(this.a, true);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void showTitle() {
        this.b.show();
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void setBody(@StringRes int i) {
        this.c.setText(i);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void setImage(@Nullable Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    @Override // ru.avito.component.dialog.SimpleDialog
    public void setTitle(@StringRes int i) {
        this.b.setText(i);
    }
}

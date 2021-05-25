package ru.avito.component.button_panel;

import android.view.View;
import com.avito.android.deprecated_design.R;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006!"}, d2 = {"Lru/avito/component/button_panel/ButtonPanelImpl;", "Lru/avito/component/button_panel/ButtonPanel;", "", "text", "", "setPrimaryButtonText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "setSecondaryButtonText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPrimaryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setSecondaryClickListener", "", "enabled", "setPrimaryButtonEnabled", "(Z)V", "setSecondaryButtonEnabled", "visible", "setSecondaryButtonVisible", "Lru/avito/component/button/ButtonImpl;", AuthSource.SEND_ABUSE, "Lru/avito/component/button/ButtonImpl;", "primaryButton", AuthSource.BOOKING_ORDER, "secondaryButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonPanelImpl implements ButtonPanel {
    public final ButtonImpl a;
    public final ButtonImpl b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            LastClick.Updater.update();
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            LastClick.Updater.update();
            Function0 function0 = this.a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    public ButtonPanelImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.primary_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = new ButtonImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.secondary_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = new ButtonImpl(findViewById2);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonEnabled(boolean z) {
        this.a.setEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(@Nullable CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryClickListener(@Nullable Function0<Unit> function0) {
        this.a.setClickListener(new a(function0));
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonEnabled(boolean z) {
        this.b.setEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(@Nullable CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonVisible(boolean z) {
        this.b.setVisible(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryClickListener(@Nullable Function0<Unit> function0) {
        this.b.setClickListener(new b(function0));
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(int i) {
        this.a.setText(i);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(int i) {
        this.b.setText(i);
    }
}

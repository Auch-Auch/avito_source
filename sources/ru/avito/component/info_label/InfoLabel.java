package ru.avito.component.info_label;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lru/avito/component/info_label/InfoLabel;", "", "", "text", "Lru/avito/component/info_label/InfoLevel;", "infoLevel", "", "setValues", "(Ljava/lang/CharSequence;Lru/avito/component/info_label/InfoLevel;)V", "", "visible", "setVisible", "(Z)V", "show", "()V", "hide", "clear", "Landroid/view/View;", "c", "Landroid/view/View;", "view", AuthSource.SEND_ABUSE, "indicator", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "textView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InfoLabel {
    public final View a;
    public final TextView b;
    public final View c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            InfoLevel.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    public InfoLabel(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.c = view;
        View findViewById = view.findViewById(R.id.info_label_indicator);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.info_label_text);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
    }

    public static /* synthetic */ void setValues$default(InfoLabel infoLabel, CharSequence charSequence, InfoLevel infoLevel, int i, Object obj) {
        if ((i & 2) != 0) {
            infoLevel = InfoLevel.INFO;
        }
        infoLabel.setValues(charSequence, infoLevel);
    }

    public final void clear() {
        this.b.setText("");
        View view = this.a;
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        view.setBackgroundColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.transparentBlack));
        this.c.setAlpha(0.0f);
    }

    public final void hide() {
        setVisible(false);
    }

    public final void setValues(@NotNull CharSequence charSequence, @NotNull InfoLevel infoLevel) {
        int i;
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(infoLevel, "infoLevel");
        this.b.setText(charSequence);
        View view = this.a;
        int ordinal = infoLevel.ordinal();
        if (ordinal == 0) {
            Context context = this.c.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            i = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue);
        } else if (ordinal == 1) {
            Context context2 = this.c.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            i = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.orange);
        } else if (ordinal == 2) {
            Context context3 = this.c.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            i = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.red);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        view.setBackgroundColor(i);
    }

    public final void setVisible(boolean z) {
        Views.setVisible(this.c, z);
    }

    public final void show() {
        setVisible(true);
    }
}

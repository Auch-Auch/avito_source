package ru.avito.component.switcher;

import a2.g.r.g;
import a7.a.a.h.a;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import com.avito.android.design.widget.ColoredProgressBar;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.switcher.Switcher;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0019\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010\u0016J\u0017\u0010!\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010%R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u00100R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010%¨\u0006@"}, d2 = {"Lru/avito/component/switcher/SwitcherImpl;", "Lru/avito/component/switcher/Switcher;", "", "text", "Lru/avito/component/switcher/SwitcherTitleSize;", "size", "", "bindTitle", "(Ljava/lang/String;Lru/avito/component/switcher/SwitcherTitleSize;)V", "bindSubtitle", "(Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", "clickListener", "bindLink", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "", "imageResourceId", "bindIcon", "(Ljava/lang/Integer;)V", "", "enabled", "setEnabled", "(Z)V", "isEnabled", "()Z", "checked", "setChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "checkedChangeListener", "setOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "loading", "setLoading", AuthSource.SEND_ABUSE, "(Lru/avito/component/switcher/SwitcherTitleSize;)I", "Landroid/widget/TextView;", g.a, "Landroid/widget/TextView;", "subtitleView", "Landroidx/appcompat/widget/SwitchCompat;", "d", "Landroidx/appcompat/widget/SwitchCompat;", "toggle", "Landroidx/appcompat/widget/AppCompatImageView;", "i", "Landroidx/appcompat/widget/AppCompatImageView;", "iconView", AuthSource.BOOKING_ORDER, "I", "titleSizeSmall", "Landroid/view/View;", "c", "Landroid/view/View;", "view", "f", "titleView", "titleSizeNormal", "Lcom/avito/android/design/widget/ColoredProgressBar;", "e", "Lcom/avito/android/design/widget/ColoredProgressBar;", "loader", "h", "linkView", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherImpl implements Switcher {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a = R.style.TextAppearance_Avito_Body_Dense;
    public final int b = R.style.TextAppearance_Avito_Body_Small_Dense;
    public final View c;
    public final SwitchCompat d;
    public final ColoredProgressBar e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final AppCompatImageView i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/avito/component/switcher/SwitcherImpl$Companion;", "", "Landroid/view/View;", "view", "Lru/avito/component/switcher/Switcher;", "createFromContainerView", "(Landroid/view/View;)Lru/avito/component/switcher/Switcher;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Switcher createFromContainerView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(com.avito.android.ui_components.R.id.toggle);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
            SwitchCompat switchCompat = (SwitchCompat) findViewById;
            View findViewById2 = view.findViewById(com.avito.android.ui_components.R.id.loader);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.design.widget.ColoredProgressBar");
            ColoredProgressBar coloredProgressBar = (ColoredProgressBar) findViewById2;
            View findViewById3 = view.findViewById(com.avito.android.ui_components.R.id.title);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById3;
            TextView textView2 = (TextView) view.findViewById(com.avito.android.ui_components.R.id.subtitle);
            TextView textView3 = (TextView) view.findViewById(com.avito.android.ui_components.R.id.link);
            View findViewById4 = view.findViewById(com.avito.android.ui_components.R.id.icon);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            return new SwitcherImpl(view, switchCompat, coloredProgressBar, textView, textView2, textView3, (AppCompatImageView) findViewById4, null);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SwitcherTitleSize.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public SwitcherImpl(View view, SwitchCompat switchCompat, ColoredProgressBar coloredProgressBar, TextView textView, TextView textView2, TextView textView3, AppCompatImageView appCompatImageView, j jVar) {
        this.c = view;
        this.d = switchCompat;
        this.e = coloredProgressBar;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = appCompatImageView;
        Switcher.DefaultImpls.bindTitle$default(this, null, null, 2, null);
        bindSubtitle(null);
        bindLink(null, null);
        bindIcon(null);
        view.setOnClickListener(new a(this));
    }

    public final int a(SwitcherTitleSize switcherTitleSize) {
        int ordinal = switcherTitleSize.ordinal();
        if (ordinal == 0) {
            return this.a;
        }
        if (ordinal == 1) {
            return this.b;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ru.avito.component.switcher.Switcher
    public void bindIcon(@Nullable Integer num) {
        if (num != null) {
            this.i.setVisibility(0);
            this.i.setImageResource(num.intValue());
            return;
        }
        this.i.setVisibility(8);
    }

    @Override // ru.avito.component.switcher.Switcher
    public void bindLink(@Nullable String str, @Nullable View.OnClickListener onClickListener) {
        TextView textView = this.h;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
    }

    @Override // ru.avito.component.switcher.Switcher
    public void bindSubtitle(@Nullable String str) {
        TextView textView = this.g;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // ru.avito.component.switcher.Switcher
    public void bindTitle(@Nullable String str, @NotNull SwitcherTitleSize switcherTitleSize) {
        Intrinsics.checkNotNullParameter(switcherTitleSize, "size");
        TextViews.bindText$default(this.f, str, false, 2, null);
        TextView textView = this.f;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "titleView.context");
        textView.setTextColor(Contexts.getColorCompat(context, com.avito.android.ui_components.R.color.switcher_title_text_color));
        if (Build.VERSION.SDK_INT < 23) {
            TextView textView2 = this.f;
            textView2.setTextAppearance(textView2.getContext(), a(switcherTitleSize));
            return;
        }
        this.f.setTextAppearance(a(switcherTitleSize));
    }

    @Override // ru.avito.component.switcher.Switcher
    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    @Override // ru.avito.component.switcher.Switcher
    public void setChecked(boolean z) {
        this.d.setChecked(z);
    }

    @Override // ru.avito.component.switcher.Switcher
    public void setEnabled(boolean z) {
        this.c.setEnabled(z);
        this.f.setEnabled(z);
        TextView textView = this.g;
        if (textView != null) {
            textView.setEnabled(z);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setEnabled(z);
        }
        this.d.setEnabled(z);
    }

    @Override // ru.avito.component.switcher.Switcher
    public void setLoading(boolean z) {
        if (z) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            return;
        }
        this.d.setVisibility(0);
        this.e.setVisibility(8);
    }

    @Override // ru.avito.component.switcher.Switcher
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.d.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}

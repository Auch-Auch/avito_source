package ru.avito.component.toolbar;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.ui_components.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", "Lru/avito/component/toolbar/CollapsingTitleAppBarLayout;", "Landroid/util/AttributeSet;", "attrs", "", g.a, "(Landroid/util/AttributeSet;)V", "", "actionTitle", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "action", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AppBarLayoutWithTextAction extends CollapsingTitleAppBarLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarLayoutWithTextAction(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        g(null);
    }

    @Override // ru.avito.component.toolbar.CollapsingTitleAppBarLayout
    private final void g(AttributeSet attributeSet) {
        Object systemService = getContext().getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        setActionView(((LayoutInflater) systemService).inflate(R.layout.collapsing_title_appbar_text_action, (ViewGroup) getActionViewContainer(), false));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AppBarLayoutWithTextAction, 0, 0);
        setAction(obtainStyledAttributes.getString(R.styleable.AppBarLayoutWithTextAction_action_title));
        obtainStyledAttributes.recycle();
    }

    @Nullable
    public final String getAction() {
        View actionView = getActionView();
        Objects.requireNonNull(actionView, "null cannot be cast to non-null type android.widget.TextView");
        return ((TextView) actionView).getText().toString();
    }

    public final void setAction(@Nullable String str) {
        View actionView = getActionView();
        Objects.requireNonNull(actionView, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) actionView;
        if (!(str == null || str.length() == 0)) {
            textView.setText(str);
            getActionViewContainer().setVisibility(0);
        } else {
            textView.setText("");
            getActionViewContainer().setVisibility(4);
        }
        refreshShortTitleWidth();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarLayoutWithTextAction(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        g(attributeSet);
    }
}

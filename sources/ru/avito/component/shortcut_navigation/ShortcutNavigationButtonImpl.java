package ru.avito.component.shortcut_navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/avito/component/shortcut_navigation/ShortcutNavigationButtonImpl;", "Lru/avito/component/shortcut_navigation/ShortcutNavigationButton;", "", "text", "", "setText", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutNavigationButtonImpl implements ShortcutNavigationButton {
    public final View a;

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

    public ShortcutNavigationButtonImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view;
    }

    @Override // ru.avito.component.shortcut_navigation.ShortcutNavigationButton
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setOnClickListener(new a(function0));
    }

    @Override // ru.avito.component.shortcut_navigation.ShortcutNavigationButton
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        View view = this.a;
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setContentDescription(str);
        }
    }
}

package ru.avito.component.shortcut_navigation_bar.adapter;

import android.view.View;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation.ShortcutNavigationButton;
import ru.avito.component.shortcut_navigation.ShortcutNavigationButtonImpl;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItemViewImpl;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/shortcut_navigation/ShortcutNavigationButton;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setText", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutNavigationItemViewImpl extends BaseViewHolder implements ShortcutNavigationItemView, ShortcutNavigationButton {
    public final /* synthetic */ ShortcutNavigationButtonImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortcutNavigationItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new ShortcutNavigationButtonImpl(view);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ShortcutNavigationItemView.DefaultImpls.onUnbind(this);
    }

    @Override // ru.avito.component.shortcut_navigation.ShortcutNavigationButton
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setClickListener(function0);
    }

    @Override // ru.avito.component.shortcut_navigation.ShortcutNavigationButton
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }
}

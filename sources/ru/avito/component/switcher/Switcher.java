package ru.avito.component.switcher;

import android.view.View;
import android.widget.CompoundButton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0013H&¢\u0006\u0004\b\u0018\u0010\u0016J\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0013H&¢\u0006\u0004\b \u0010\u0016¨\u0006!"}, d2 = {"Lru/avito/component/switcher/Switcher;", "", "", "text", "Lru/avito/component/switcher/SwitcherTitleSize;", "size", "", "bindTitle", "(Ljava/lang/String;Lru/avito/component/switcher/SwitcherTitleSize;)V", "bindSubtitle", "(Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", "clickListener", "bindLink", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "", "imageResourceId", "bindIcon", "(Ljava/lang/Integer;)V", "", "enabled", "setEnabled", "(Z)V", "checked", "setChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "checkedChangeListener", "setOnCheckedChangeListener", "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "isEnabled", "()Z", "loading", "setLoading", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface Switcher {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void bindTitle$default(Switcher switcher, String str, SwitcherTitleSize switcherTitleSize, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    switcherTitleSize = SwitcherTitleSize.NORMAL;
                }
                switcher.bindTitle(str, switcherTitleSize);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindTitle");
        }
    }

    void bindIcon(@Nullable Integer num);

    void bindLink(@Nullable String str, @Nullable View.OnClickListener onClickListener);

    void bindSubtitle(@Nullable String str);

    void bindTitle(@Nullable String str, @NotNull SwitcherTitleSize switcherTitleSize);

    boolean isEnabled();

    void setChecked(boolean z);

    void setEnabled(boolean z);

    void setLoading(boolean z);

    void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener);
}

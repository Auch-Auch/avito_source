package com.avito.android.design.widget.search_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0017B!\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/avito/android/design/widget/search_view/SearchEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/avito/android/design/widget/search_view/ToolbarSearchView;", "searchView", "", "setSearchView$ui_components_release", "(Lcom/avito/android/design/widget/search_view/ToolbarSearchView;)V", "setSearchView", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyPreIme", "(ILandroid/view/KeyEvent;)Z", "d", "Lcom/avito/android/design/widget/search_view/ToolbarSearchView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SearchEditText extends AppCompatEditText {
    public ToolbarSearchView d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchEditText(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, @NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        ToolbarSearchView toolbarSearchView = this.d;
        if (i != 4 || keyEvent.getAction() != 1 || toolbarSearchView == null || !toolbarSearchView.isSearchOpen()) {
            return super.onKeyPreIme(i, keyEvent);
        }
        clearFocus();
        return true;
    }

    public final void setSearchView$ui_components_release(@NotNull ToolbarSearchView toolbarSearchView) {
        Intrinsics.checkNotNullParameter(toolbarSearchView, "searchView");
        this.d = toolbarSearchView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchEditText(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchEditText(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }
}

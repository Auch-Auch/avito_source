package ru.avito.component.appbar.floating_toolbar;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/avito/component/appbar/floating_toolbar/FloatingToolbar;", "", "", "showToolbar", "()V", "adjustToolbarVisibility", "", "scrollY", "offsetY", "onContentScroll", "(II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface FloatingToolbar {
    void adjustToolbarVisibility();

    void onContentScroll(int i, int i2);

    void showToolbar();
}

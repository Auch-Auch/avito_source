package com.avito.android.category;

import androidx.annotation.AttrRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/category/CategoryViewHolder;", "Lcom/avito/android/category/BaseViewHolder;", "", "isVisible", "", "setDividerVisibility", "(Z)V", "", "colorAttr", "setTextColor", "(I)V", "isCollapsed", "setArrowCollapsed", "", "text", "setText", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "func", "setCategoryClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setArrowVisibility", "category_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryViewHolder extends BaseViewHolder {
    void setArrowCollapsed(boolean z);

    void setArrowVisibility(boolean z);

    void setCategoryClickListener(@NotNull Function0<Unit> function0);

    void setDividerVisibility(boolean z);

    void setText(@Nullable String str);

    void setTextColor(@AttrRes int i);
}

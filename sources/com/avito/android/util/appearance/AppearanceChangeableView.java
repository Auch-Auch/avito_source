package com.avito.android.util.appearance;

import android.content.Context;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.avito.android.util.Contexts;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/util/appearance/AppearanceChangeableView;", "", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "setAppearance", "(I)V", "themeAttr", "setAppearanceFromAttr", "android_release"}, k = 1, mv = {1, 4, 2})
public interface AppearanceChangeableView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setAppearanceFromAttr(@NotNull AppearanceChangeableView appearanceChangeableView, @AttrRes int i) {
            appearanceChangeableView.setAppearance(Contexts.getResourceIdByAttr(appearanceChangeableView.getContext(), i));
        }
    }

    @NotNull
    Context getContext();

    void setAppearance(@StyleRes int i);

    void setAppearanceFromAttr(@AttrRes int i);
}

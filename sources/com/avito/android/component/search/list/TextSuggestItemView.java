package com.avito.android.component.search.list;

import androidx.annotation.DrawableRes;
import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0018\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\rH&¢\u0006\u0004\b\u0018\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/component/search/list/TextSuggestItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", "func", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setMinimalHeight", "(Ljava/lang/Integer;)V", "paddingTop", "paddingBottom", "setPadding", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setIcon", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/Integer;Ljava/lang/Integer;)V", "pictureRes", "(I)V", "clearIcon", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface TextSuggestItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TextSuggestItemView textSuggestItemView) {
            ItemView.DefaultImpls.onUnbind(textSuggestItemView);
        }
    }

    void clearIcon();

    void setClickListener(@NotNull Function0<Unit> function0);

    void setDescription(@Nullable String str);

    void setIcon(@DrawableRes int i);

    void setIcon(@NotNull Picture picture, @Nullable Integer num, @Nullable Integer num2);

    void setMinimalHeight(@Nullable Integer num);

    void setPadding(@Nullable Integer num, @Nullable Integer num2);

    void setTitle(@NotNull String str);
}

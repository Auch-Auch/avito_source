package com.avito.android.ui.widget.tagged_input;

import androidx.lifecycle.LifecycleOwner;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagsListView;", "", "", "itemId", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "tagsViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "tagListImmutable", "", "bindTagsListTo", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;Landroidx/lifecycle/LifecycleOwner;Z)V", "singleLined", "setTagListStyle", "(Z)V", "unbindTagsList", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", "Lio/reactivex/Observable;", "getTagsVisible", "()Lio/reactivex/Observable;", "tagsVisible", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface TagsListView {
    void bindTagsListTo(@NotNull String str, @NotNull TagsViewModel tagsViewModel, @NotNull LifecycleOwner lifecycleOwner, boolean z);

    @NotNull
    Observable<Boolean> getTagsVisible();

    void setTagListStyle(boolean z);

    void unbindTagsList(@NotNull String str, @NotNull LifecycleOwner lifecycleOwner);
}

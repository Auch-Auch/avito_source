package com.avito.android.ui.widget.tagged_input;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView;", "", "", "itemId", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "tagsViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "bindTo", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "unbind", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;", "textInserter", "attachTextInserter", "(Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;)V", "detachTextInserter", "()V", "TextInserter", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface TagsConsumerView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;", "", "", "text", "", "setText", "(Ljava/lang/String;)V", "insertText", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public interface TextInserter {
        void insertText(@NotNull String str);

        void setText(@NotNull String str);
    }

    void attachTextInserter(@NotNull TextInserter textInserter);

    void bindTo(@NotNull String str, @NotNull TagsViewModel tagsViewModel, @NotNull LifecycleOwner lifecycleOwner);

    void detachTextInserter();

    void unbind(@NotNull String str, @NotNull LifecycleOwner lifecycleOwner);
}

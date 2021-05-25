package com.avito.android.ui.widget.tagged_input;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.widget.tagged_input.TagItem;
import com.avito.android.ui.widget.tagged_input.TagsConsumerView;
import com.avito.android.ui.widget.tagged_input.analytics.TagSelectionTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/ui/widget/tagged_input/TagsConsumerViewImpl;", "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView;", "", "itemId", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "tagsViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "bindTo", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "unbind", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;", "textInserter", "attachTextInserter", "(Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;)V", "detachTextInserter", "()V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;", "Lcom/avito/android/ui/widget/tagged_input/analytics/TagSelectionTracker;", "c", "Lcom/avito/android/ui/widget/tagged_input/analytics/TagSelectionTracker;", "tagSelectionTracker", AuthSource.SEND_ABUSE, "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "<init>", "(Lcom/avito/android/ui/widget/tagged_input/analytics/TagSelectionTracker;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class TagsConsumerViewImpl implements TagsConsumerView {
    public TagsViewModel a;
    public TagsConsumerView.TextInserter b;
    public final TagSelectionTracker c;

    public TagsConsumerViewImpl(@NotNull TagSelectionTracker tagSelectionTracker) {
        Intrinsics.checkNotNullParameter(tagSelectionTracker, "tagSelectionTracker");
        this.c = tagSelectionTracker;
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void attachTextInserter(@NotNull TagsConsumerView.TextInserter textInserter) {
        Intrinsics.checkNotNullParameter(textInserter, "textInserter");
        this.b = textInserter;
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void bindTo(@NotNull String str, @NotNull TagsViewModel tagsViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(tagsViewModel, "tagsViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.a = tagsViewModel;
        tagsViewModel.tagSelected(str).observe(lifecycleOwner, new Observer<T>(this) { // from class: com.avito.android.ui.widget.tagged_input.TagsConsumerViewImpl$bindTo$$inlined$observeNotNull$1
            public final /* synthetic */ TagsConsumerViewImpl a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    T t2 = t;
                    TagItem.Value value = t2.getValue();
                    if (value.isFullReplace()) {
                        TagsConsumerView.TextInserter textInserter = this.a.b;
                        if (textInserter != null) {
                            textInserter.setText(value.getText());
                        }
                    } else {
                        TagsConsumerView.TextInserter textInserter2 = this.a.b;
                        if (textInserter2 != null) {
                            textInserter2.insertText(value.getText());
                        }
                    }
                    this.a.c.trackTagSelection(t2);
                }
            }
        });
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void detachTextInserter() {
        this.b = null;
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void unbind(@NotNull String str, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        TagsViewModel tagsViewModel = this.a;
        if (tagsViewModel != null) {
            tagsViewModel.tagSelected(str).removeObservers(lifecycleOwner);
        }
    }
}

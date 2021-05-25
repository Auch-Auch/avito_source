package com.avito.android.photo_picker.legacy;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/photo_picker/legacy/PhotoDragAndDropImpl;", "Lcom/avito/android/photo_picker/legacy/PhotoDragAndDrop;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/android/photo_picker/legacy/PhotoMover;", "photoMover", "", "attachTo", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/avito/android/photo_picker/legacy/PhotoMover;)V", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoDragAndDropImpl implements PhotoDragAndDrop {
    @Override // com.avito.android.photo_picker.legacy.PhotoDragAndDrop
    public void attachTo(@NotNull RecyclerView recyclerView, @NotNull PhotoMover photoMover) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(photoMover, "photoMover");
        new ItemTouchHelper(new ItemTouchHelperCallback(photoMover)).attachToRecyclerView(recyclerView);
    }
}

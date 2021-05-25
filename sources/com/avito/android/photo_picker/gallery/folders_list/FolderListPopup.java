package com.avito.android.photo_picker.gallery.folders_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.gallery.data.Folder;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/photo_picker/gallery/folders_list/FolderListPopup;", "Landroid/widget/PopupWindow;", "Lcom/avito/android/photo_picker/gallery/folders_list/FolderSelectedListener;", "folderSelectedListener", "", "setFolderSelectedListener", "(Lcom/avito/android/photo_picker/gallery/folders_list/FolderSelectedListener;)V", "", "Lcom/avito/android/photo_picker/gallery/data/Folder;", "folders", "setFolders", "(Ljava/util/List;)V", "Lcom/avito/android/photo_picker/gallery/folders_list/FoldersAdapter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/gallery/folders_list/FoldersAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "folderList", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class FolderListPopup extends PopupWindow {
    public RecyclerView a;
    public FoldersAdapter b;
    public final Context c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FolderListPopup(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.popup_gallery_folders, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler);
        this.a = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(context, 1, false));
        }
        setContentView(inflate);
    }

    public final void setFolderSelectedListener(@NotNull FolderSelectedListener folderSelectedListener) {
        Intrinsics.checkNotNullParameter(folderSelectedListener, "folderSelectedListener");
        FoldersAdapter foldersAdapter = this.b;
        if (foldersAdapter != null) {
            foldersAdapter.setFolderSelectedListener(folderSelectedListener);
        }
    }

    public final void setFolders(@NotNull List<Folder> list) {
        Intrinsics.checkNotNullParameter(list, "folders");
        FoldersAdapter foldersAdapter = new FoldersAdapter(list);
        this.b = foldersAdapter;
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            recyclerView.setAdapter(foldersAdapter);
        }
    }
}

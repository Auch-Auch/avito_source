package com.avito.android.photo_picker.gallery.folders_list;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.gallery.data.Folder;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/photo_picker/gallery/folders_list/FoldersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/photo_picker/gallery/folders_list/FolderViewHolder;", "Lcom/avito/android/photo_picker/gallery/folders_list/FolderSelectedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setFolderSelectedListener", "(Lcom/avito/android/photo_picker/gallery/folders_list/FolderSelectedListener;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/photo_picker/gallery/folders_list/FolderViewHolder;", "holder", VKApiConst.POSITION, "onBindViewHolder", "(Lcom/avito/android/photo_picker/gallery/folders_list/FolderViewHolder;I)V", "getItemCount", "()I", "", "Lcom/avito/android/photo_picker/gallery/data/Folder;", "d", "Ljava/util/List;", "folders", "c", "Lcom/avito/android/photo_picker/gallery/folders_list/FolderSelectedListener;", "<init>", "(Ljava/util/List;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class FoldersAdapter extends RecyclerView.Adapter<FolderViewHolder> {
    public FolderSelectedListener c;
    public final List<Folder> d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FoldersAdapter a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Folder c;

        public a(FoldersAdapter foldersAdapter, int i, Folder folder) {
            this.a = foldersAdapter;
            this.b = i;
            this.c = folder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FolderSelectedListener folderSelectedListener = this.a.c;
            if (folderSelectedListener != null) {
                folderSelectedListener.onFolderSelected(this.b, this.c);
            }
        }
    }

    public FoldersAdapter(@NotNull List<Folder> list) {
        Intrinsics.checkNotNullParameter(list, "folders");
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.d.size();
    }

    public final void setFolderSelectedListener(@NotNull FolderSelectedListener folderSelectedListener) {
        Intrinsics.checkNotNullParameter(folderSelectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = folderSelectedListener;
    }

    public void onBindViewHolder(@NotNull FolderViewHolder folderViewHolder, int i) {
        Intrinsics.checkNotNullParameter(folderViewHolder, "holder");
        Folder folder = this.d.get(i);
        ImageRequest.Builder requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(folderViewHolder.getFolderImage());
        Uri photoUri = folder.getPhotoUri();
        if (photoUri != null) {
            requestBuilder.uri(photoUri).load();
        } else {
            requestBuilder.clear();
        }
        folderViewHolder.getFolderName().setText(folder.getFolderName());
        folderViewHolder.itemView.setOnClickListener(new a(this, i, folder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public FolderViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gallery_folder, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(pare…      false\n            )");
        return new FolderViewHolder(inflate);
    }
}

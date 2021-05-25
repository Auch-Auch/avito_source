package com.avito.android.photo_picker.gallery.folders_list;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.photo_picker.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/photo_picker/gallery/folders_list/FolderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getFolderImage", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setFolderImage", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "folderImage", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "getFolderName", "()Landroid/widget/TextView;", "setFolderName", "(Landroid/widget/TextView;)V", "folderName", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class FolderViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public TextView s;
    @NotNull
    public SimpleDraweeView t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FolderViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.folder_name);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.folder_name)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.photo_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.photo_view)");
        this.t = (SimpleDraweeView) findViewById2;
    }

    @NotNull
    public final SimpleDraweeView getFolderImage() {
        return this.t;
    }

    @NotNull
    public final TextView getFolderName() {
        return this.s;
    }

    public final void setFolderImage(@NotNull SimpleDraweeView simpleDraweeView) {
        Intrinsics.checkNotNullParameter(simpleDraweeView, "<set-?>");
        this.t = simpleDraweeView;
    }

    public final void setFolderName(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.s = textView;
    }
}

package com.avito.android.photo_picker.legacy.thumbnail_list;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import com.avito.android.photo_picker.R;
import com.avito.android.util.Rotation;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b4\u00105J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u001d\u0010\u001e\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u000fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\"R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010.¨\u00066"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemView;", "", "isDraggable", "()Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "showImage", "(Landroid/net/Uri;)V", "", "resId", "(I)V", "hideImage", "()V", "selected", "setSelected", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/util/Rotation;", "rotation", "animate", "setRotation", "(Lcom/avito/android/util/Rotation;Z)V", "isVisible", "setProgressVisibility", "setUnbindListener", "onUnbind", "Landroid/view/View;", "t", "Landroid/view/View;", "progressOverlay", "y", "rootView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "photoView", "x", "Z", "isCamera", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function0;", "clickListener", "u", "selectionOverlay", "w", "unbindListener", "<init>", "(Landroid/view/View;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ThumbnailItemViewImpl extends BaseViewHolder implements ThumbnailItemView {
    public final SimpleDraweeView s;
    public final View t;
    public final View u;
    public Function0<Unit> v;
    public Function0<Unit> w;
    public boolean x;
    public final View y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ThumbnailItemViewImpl a;

        public a(ThumbnailItemViewImpl thumbnailItemViewImpl) {
            this.a = thumbnailItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.v;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThumbnailItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.y = view;
        View findViewById = view.findViewById(R.id.photo_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.progress_overlay);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById2;
        View findViewById3 = view.findViewById(R.id.selection_overlay);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.u = findViewById3;
        findViewById3.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    public void hideImage() {
        Views.conceal(this.s);
    }

    @Override // com.avito.android.photo_picker.legacy.DraggablePhotoViewHolder
    public boolean isDraggable() {
        return !this.x;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.w;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v = function0;
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    public void setProgressVisibility(boolean z) {
        Views.setVisible(this.t, z);
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    public void setRotation(@NotNull Rotation rotation, boolean z) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        if (z) {
            Views.rotateByShortestPath(this.y, rotation.getDegree());
            return;
        }
        this.y.clearAnimation();
        this.y.setRotation((float) rotation.getDegree());
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    public void setSelected(boolean z) {
        this.u.setSelected(z);
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    public void setUnbindListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = function0;
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    public void showImage(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.x = false;
        Views.show(this.s);
        SimpleDraweeViewsKt.getRequestBuilder(this.s).uri(uri).load();
    }

    @Override // com.avito.android.photo_picker.legacy.thumbnail_list.ThumbnailItemView
    @SuppressLint({"ResourceType"})
    public void showImage(int i) {
        this.x = true;
        Views.show(this.s);
        this.s.setImageResource(i);
    }
}

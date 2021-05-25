package com.avito.android.photo_picker.gallery.gallery_list;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.avito.android.photo_picker.R;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemView;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "showImage", "(Landroid/net/Uri;)V", "", "selected", "setSelected", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "onUnbind", "()V", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "photoView", "", "w", "Z", "isSelected", "u", "clickListener", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "selectedNumber", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryItemViewImpl extends BaseViewHolder implements GalleryItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public Function0<Unit> u;
    public Function0<Unit> v;
    public boolean w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GalleryItemViewImpl a;

        public a(GalleryItemViewImpl galleryItemViewImpl) {
            this.a = galleryItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.u;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.photo_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById;
        this.s = simpleDraweeView;
        View findViewById2 = view.findViewById(R.id.number);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        simpleDraweeView.setOnClickListener(new a(this));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.v;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.photo_picker.gallery.gallery_list.GalleryItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u = function0;
    }

    @Override // com.avito.android.photo_picker.gallery.gallery_list.GalleryItemView
    public void setSelected(int i) {
        if (i > 0) {
            this.t.setText(String.valueOf(i));
            Views.setVisible(this.t, true);
            if (!this.w) {
                this.s.animate().scaleX(0.9f).scaleY(0.9f).setDuration(200).start();
            }
            this.w = true;
            return;
        }
        Views.setVisible(this.t, false);
        if (this.w) {
            this.s.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
        }
        this.w = false;
    }

    @Override // com.avito.android.photo_picker.gallery.gallery_list.GalleryItemView
    public void setUnbindListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v = function0;
    }

    @Override // com.avito.android.photo_picker.gallery.gallery_list.GalleryItemView
    public void showImage(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        SimpleDraweeViewsKt.getRequestBuilder(this.s).uri(uri).load();
    }
}

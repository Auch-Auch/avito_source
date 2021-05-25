package com.avito.android.photo_gallery.autoteka_teaser;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaTeaserView;", "Landroid/widget/LinearLayout;", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;", "clickListener", "", "setListener", "(Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;)V", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "teaser", "setData", "(Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "", "isShow", "showOpenTeaserButton", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public abstract class AutotekaTeaserView extends LinearLayout {
    @JvmOverloads
    public AutotekaTeaserView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public AutotekaTeaserView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutotekaTeaserView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public abstract void setData(@Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel);

    public abstract void setListener(@Nullable AutotekaListener autotekaListener);

    public abstract void showOpenTeaserButton(boolean z);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutotekaTeaserView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

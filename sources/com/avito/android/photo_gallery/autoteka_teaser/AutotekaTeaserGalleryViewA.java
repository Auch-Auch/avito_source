package com.avito.android.photo_gallery.autoteka_teaser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.lib.design.button.Button;
import com.avito.android.photo_gallery.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006!"}, d2 = {"Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaTeaserGalleryViewA;", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaTeaserView;", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "teaser", "", "setData", "(Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;", "clickListener", "setListener", "(Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;)V", "", "isShow", "showOpenTeaserButton", "(Z)V", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "teaserButton", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "teaserSubtitle", AuthSource.SEND_ABUSE, "teaserTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserGalleryViewA extends AutotekaTeaserView {
    public final TextView a;
    public final TextView b;
    public final Button c;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((AutotekaListener) this.b).onButtonClick(FromBlock.FROM_GALLERY_TEASER_A);
            } else if (i == 1) {
                ((AutotekaListener) this.b).onEmptyClick();
            } else {
                throw null;
            }
        }
    }

    @JvmOverloads
    public AutotekaTeaserGalleryViewA(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public AutotekaTeaserGalleryViewA(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutotekaTeaserGalleryViewA(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaTeaserView
    public void setData(@Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        String str = null;
        this.a.setText(autotekaTeaserGalleryModel != null ? autotekaTeaserGalleryModel.getPhotosInReportTitle() : null);
        TextView textView = this.b;
        if (autotekaTeaserGalleryModel != null) {
            str = autotekaTeaserGalleryModel.getPhotosInReportSubtitle();
        }
        textView.setText(str);
    }

    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaTeaserView
    public void setListener(@Nullable AutotekaListener autotekaListener) {
        if (autotekaListener != null) {
            this.c.setOnClickListener(new a(0, autotekaListener));
            setOnClickListener(new a(1, autotekaListener));
            return;
        }
        this.c.setOnClickListener(null);
        setOnClickListener(null);
    }

    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaTeaserView
    public void showOpenTeaserButton(boolean z) {
        this.c.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutotekaTeaserGalleryViewA(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.gallery_item_autoteka_teaser_view_a, this);
        View findViewById = findViewById(R.id.gallery_teaser_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.gallery_teaser_title)");
        this.a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.gallery_teaser_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.gallery_teaser_subtitle)");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.gallery_teaser_button_show);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.gallery_teaser_button_show)");
        this.c = (Button) findViewById3;
    }
}

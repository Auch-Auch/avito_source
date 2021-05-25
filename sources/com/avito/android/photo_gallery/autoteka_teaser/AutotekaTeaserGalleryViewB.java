package com.avito.android.photo_gallery.autoteka_teaser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.lib.design.button.Button;
import com.avito.android.photo_gallery.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.avito.android.remote.model.teaser.TeaserStatus;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaTeaserGalleryViewB;", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaTeaserView;", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "teaser", "", "setData", "(Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;", "clickListener", "setListener", "(Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;)V", "", "isShow", "showOpenTeaserButton", "(Z)V", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "teaserTitle", AuthSource.BOOKING_ORDER, "teaserSubtitle", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "insightsContainer", "Lcom/avito/android/lib/design/button/Button;", "d", "Lcom/avito/android/lib/design/button/Button;", "teaserButton", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserGalleryViewB extends AutotekaTeaserView {
    public final TextView a;
    public final TextView b;
    public final LinearLayout c;
    public final Button d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            TeaserStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            TeaserStatus teaserStatus = TeaserStatus.None;
            iArr[0] = 1;
            TeaserStatus teaserStatus2 = TeaserStatus.Ok;
            iArr[1] = 2;
            TeaserStatus teaserStatus3 = TeaserStatus.Caution;
            iArr[2] = 3;
            TeaserStatus teaserStatus4 = TeaserStatus.Warning;
            iArr[3] = 4;
            TeaserStatus teaserStatus5 = TeaserStatus.Locked;
            iArr[4] = 5;
        }
    }

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
                ((AutotekaListener) this.b).onButtonClick(FromBlock.FROM_GALLERY_TEASER_B);
            } else if (i == 1) {
                ((AutotekaListener) this.b).onEmptyClick();
            } else if (i == 2) {
                ((AutotekaListener) this.b).onEmptyClick();
            } else {
                throw null;
            }
        }
    }

    @JvmOverloads
    public AutotekaTeaserGalleryViewB(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public AutotekaTeaserGalleryViewB(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutotekaTeaserGalleryViewB(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaTeaserView
    public void setData(@Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        List<TeaserInsight> list;
        Drawable drawable;
        this.a.setText(autotekaTeaserGalleryModel != null ? autotekaTeaserGalleryModel.getTitle() : null);
        this.b.setText(autotekaTeaserGalleryModel != null ? autotekaTeaserGalleryModel.getReportInfoSubtitle() : null);
        if (autotekaTeaserGalleryModel == null || (list = autotekaTeaserGalleryModel.getInsights()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        this.c.removeAllViews();
        for (TeaserInsight teaserInsight : list) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.advert_details_autoteka_teaser_in_gallery_insight, (ViewGroup) this.c, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "insightView");
            View findViewById = inflate.findViewById(R.id.text);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(teaserInsight.getText());
            View findViewById2 = inflate.findViewById(R.id.icon);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) findViewById2;
            int ordinal = teaserInsight.getStatus().ordinal();
            if (ordinal == 0) {
                drawable = null;
            } else if (ordinal == 1) {
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_status_ok_gallery);
            } else if (ordinal == 2) {
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_status_caution_gallery);
            } else if (ordinal == 3) {
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_status_warning_gallery);
            } else if (ordinal == 4) {
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_status_lock_gallery);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            imageView.setImageDrawable(drawable);
            this.c.addView(inflate);
        }
    }

    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaTeaserView
    public void setListener(@Nullable AutotekaListener autotekaListener) {
        if (autotekaListener != null) {
            this.d.setOnClickListener(new a(0, autotekaListener));
            this.c.setOnClickListener(new a(1, autotekaListener));
            setOnClickListener(new a(2, autotekaListener));
            return;
        }
        this.d.setOnClickListener(null);
        this.c.setOnClickListener(null);
        setOnClickListener(null);
    }

    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaTeaserView
    public void showOpenTeaserButton(boolean z) {
        this.d.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutotekaTeaserGalleryViewB(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.gallery_item_autoteka_teaser_view_b, this);
        View findViewById = findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.sub_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.insights_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.c = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.gallery_teaser_button_show);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.d = (Button) findViewById4;
    }
}

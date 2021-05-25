package com.avito.android.brandspace.items.news;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.news.NewsItemView;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurer;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b!\u0010\"JI\u0010\u000e\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/avito/android/brandspace/items/news/NewsItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/news/NewsItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "title", "description", "action", "", "precalculatedTextHeight", "Landroid/view/View$OnClickListener;", "clickListener", "", "bind", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "u", "Landroid/view/View;", "x", "Landroid/view/View;", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "t", "Landroid/view/ViewGroup;", "w", "Landroid/view/ViewGroup;", "textContainer", "<init>", "(Landroid/view/View;)V", "MeasurerImpl", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class NewsItemViewImpl extends BaseViewHolder implements NewsItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final ViewGroup w;
    public final View x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006!"}, d2 = {"Lcom/avito/android/brandspace/items/news/NewsItemViewImpl$MeasurerImpl;", "Lcom/avito/android/brandspace/items/news/NewsItemView$Measurer;", "", "title", "description", "action", "Lcom/avito/android/brandspace/items/news/NewsItemView$Layout;", "measure", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/items/news/NewsItemView$Layout;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "d", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "textMeasurer", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "titleParams", AuthSource.BOOKING_ORDER, "descriptionParams", "c", "actionParams", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class MeasurerImpl implements NewsItemView.Measurer {
        public final TextMeasurer.TextParams a;
        public final TextMeasurer.TextParams b;
        public final TextMeasurer.TextParams c;
        public final TextMeasurer d;

        public MeasurerImpl(@NotNull View view, @NotNull TextMeasurer textMeasurer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
            this.d = textMeasurer;
            NewsItemViewImpl newsItemViewImpl = new NewsItemViewImpl(view);
            int paddingLeft = (view.getLayoutParams().width - view.getPaddingLeft()) - view.getPaddingRight();
            this.a = textMeasurer.createTextParams(newsItemViewImpl.t, paddingLeft);
            this.b = textMeasurer.createTextParams(newsItemViewImpl.u, paddingLeft);
            this.c = textMeasurer.createTextParams(newsItemViewImpl.v, paddingLeft);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(MeasurerImpl.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.brandspace.items.news.NewsItemViewImpl.MeasurerImpl");
            MeasurerImpl measurerImpl = (MeasurerImpl) obj;
            return !(Intrinsics.areEqual(this.a, measurerImpl.a) ^ true) && !(Intrinsics.areEqual(this.b, measurerImpl.b) ^ true) && !(Intrinsics.areEqual(this.c, measurerImpl.c) ^ true);
        }

        public int hashCode() {
            int hashCode = this.b.hashCode();
            return this.c.hashCode() + ((hashCode + (this.a.hashCode() * 31)) * 31);
        }

        @Override // com.avito.android.brandspace.items.news.NewsItemView.Measurer
        @NotNull
        public NewsItemView.Layout measure(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            return new NewsItemView.Layout(this.d.measure(str, this.a), this.d.measure(str2, this.b), this.d.measure(str3, this.c));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        View findViewById = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image)");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.description)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.action);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.action)");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.text_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.text_container)");
        this.w = (ViewGroup) findViewById5;
    }

    @Override // com.avito.android.brandspace.items.news.NewsItemView
    public void bind(@Nullable Image image, @Nullable String str, @Nullable String str2, @Nullable String str3, int i, @Nullable View.OnClickListener onClickListener) {
        TextViews.bindText$default(this.t, str, false, 2, null);
        TextViews.bindText$default(this.u, str2, false, 2, null);
        TextViews.bindText$default(this.v, str3, false, 2, null);
        this.w.getLayoutParams().height = i;
        if (onClickListener != null) {
            this.x.setOnClickListener(onClickListener);
        } else {
            this.x.setClickable(false);
        }
        this.s.setAspectRatio(Images.aspectRatio(image, 1.76f));
        if (image != null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.s).picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).cancelOnDetach(false).load();
        } else {
            this.s.setController(null);
        }
    }
}

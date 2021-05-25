package com.avito.android.advert_core.georeference;

import a2.b.a.a.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.StringUtils;
import com.avito.android.util.Views;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0005\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/advert_core/georeference/GeoReferenceViewBinderImpl;", "Lcom/avito/android/advert_core/georeference/GeoReferenceViewBinder;", "Lcom/avito/android/remote/model/GeoReference;", "geoReference", "", "bindData", "(Lcom/avito/android/remote/model/GeoReference;)V", "", "", "colors", "content", "after", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", AuthSource.BOOKING_ORDER, "I", "contextPaddingLeft", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "rootView", "<init>", "(Landroid/view/ViewGroup;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class GeoReferenceViewBinderImpl implements GeoReferenceViewBinder {
    public final LayoutInflater a;
    public final int b;
    public final ViewGroup c;

    public GeoReferenceViewBinderImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.c = viewGroup;
        this.a = LayoutInflater.from(viewGroup.getContext());
        this.b = viewGroup.getResources().getDimensionPixelSize(R.dimen.advert_geo_reference_text_padding);
    }

    @Override // com.avito.android.advert_core.georeference.GeoReferenceViewBinder
    public void bindData(@NotNull GeoReference geoReference) {
        Intrinsics.checkNotNullParameter(geoReference, "geoReference");
        List<String> colors = geoReference.getColors();
        if (colors == null) {
            colors = CollectionsKt__CollectionsKt.emptyList();
        }
        bindData(colors, geoReference.getContent(), geoReference.getAfter());
    }

    @Override // com.avito.android.advert_core.georeference.GeoReferenceViewBinder
    public void bindData(@NotNull List<String> list, @Nullable String str, @Nullable String str2) {
        boolean z;
        Drawable mutate;
        Intrinsics.checkNotNullParameter(list, "colors");
        Iterator<T> it = list.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            Integer parseColorOrNull = StringUtils.parseColorOrNull(it.next());
            if (parseColorOrNull != null) {
                int intValue = parseColorOrNull.intValue();
                View inflate = this.a.inflate(R.layout.advert_details_geo_circle, this.c, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.View");
                Drawable drawable = inflate.getContext().getDrawable(R.drawable.advert_details_metro_reference);
                Views.setBackgroundCompat(inflate, (drawable == null || (mutate = drawable.mutate()) == null) ? null : DrawablesKt.wrapForTinting(mutate, intValue));
                this.c.addView(inflate);
            }
        }
        if (str != null) {
            View inflate2 = this.a.inflate(R.layout.advert_details_geo_text, this.c, false);
            Objects.requireNonNull(inflate2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate2;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                String c3 = a.c3(str, str2);
                SpannableString spannableString = new SpannableString(c3);
                Context context = this.c.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                spannableString.setSpan(new ForegroundColorSpan(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48)), str.length(), c3.length(), 34);
                textView.setText(spannableString);
            } else {
                textView.setText(str);
            }
            if (!list.isEmpty()) {
                Views.changePadding$default(textView, this.b, 0, 0, 0, 14, null);
            } else {
                Views.changePadding$default(textView, 0, 0, 0, 0, 14, null);
            }
            this.c.addView(textView);
        }
    }
}

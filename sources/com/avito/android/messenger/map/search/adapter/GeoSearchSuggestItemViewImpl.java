package com.avito.android.messenger.map.search.adapter;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemViewImpl;", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "name", "description", "", "setText", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "t", "Landroid/view/LayoutInflater;", "layoutInflater", "", "w", "I", "verticalMarginTitleOnly", VKApiConst.VERSION, "verticalMarginTitleAndDescr", "Landroid/widget/LinearLayout;", "s", "Landroid/widget/LinearLayout;", "layout", "", "Landroid/widget/TextView;", "u", "Ljava/util/List;", "textViews", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class GeoSearchSuggestItemViewImpl extends BaseViewHolder implements GeoSearchSuggestItemView {
    public final LinearLayout s;
    public final LayoutInflater t;
    public final List<TextView> u = new ArrayList();
    public final int v;
    public final int w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GeoSearchSuggestItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.messenger_geo_search_suggest_item_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…arch_suggest_item_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.s = linearLayout;
        this.t = LayoutInflater.from(linearLayout.getContext());
        Resources resources = linearLayout.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "layout.resources");
        this.v = (int) TypedValue.applyDimension(1, 12.0f, resources.getDisplayMetrics());
        Resources resources2 = linearLayout.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "layout.resources");
        this.w = (int) TypedValue.applyDimension(1, 19.0f, resources2.getDisplayMetrics());
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        GeoSearchSuggestItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemView
    public void setClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.s.setOnClickListener(onClickListener);
    }

    @Override // com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemView
    public void setText(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "name");
        List<TextView> list = this.u;
        LinearLayout linearLayout = this.s;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            linearLayout.removeView(it.next());
        }
        this.u.clear();
        if (charSequence2 == null || m.isBlank(charSequence2)) {
            View inflate = this.t.inflate(R.layout.messenger_geo_search_suggest_item_name, (ViewGroup) this.s, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setId(View.generateViewId());
            textView.setText(charSequence);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.w;
            layoutParams.bottomMargin = this.w;
            textView.setLayoutParams(layoutParams);
            textView.setTag("messenger_geo_search_suggest_item_name");
            this.s.addView(textView);
            this.u.add(textView);
            return;
        }
        View inflate2 = this.t.inflate(R.layout.messenger_geo_search_suggest_item_name, (ViewGroup) this.s, false);
        Objects.requireNonNull(inflate2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) inflate2;
        textView2.setId(View.generateViewId());
        textView2.setText(charSequence);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = this.v;
        textView2.setLayoutParams(layoutParams2);
        textView2.setTag("messenger_geo_search_suggest_item_name");
        this.s.addView(textView2);
        this.u.add(textView2);
        View inflate3 = this.t.inflate(R.layout.messenger_geo_search_suggest_item_description, (ViewGroup) this.s, false);
        Objects.requireNonNull(inflate3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) inflate3;
        textView3.setId(View.generateViewId());
        textView3.setText(charSequence2);
        textView3.setTag("messenger_geo_search_suggest_item_description");
        this.s.addView(textView3);
        this.u.add(textView3);
    }
}

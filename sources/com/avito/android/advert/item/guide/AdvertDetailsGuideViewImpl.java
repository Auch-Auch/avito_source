package com.avito.android.advert.item.guide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.guide.GuideLink;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010)\u001a\u00020\u001d\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006."}, d2 = {"Lcom/avito/android/advert/item/guide/AdvertDetailsGuideViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/guide/AdvertDetailsGuideView;", "", "title", "", "showTitle", "(Ljava/lang/String;)V", "hideTitle", "()V", "Lcom/avito/android/remote/model/guide/GuideLink;", "link", "Lkotlin/Function0;", "onClick", "showLink", "(Lcom/avito/android/remote/model/guide/GuideLink;Lkotlin/jvm/functions/Function0;)V", "hideLink", "hideTopDivider", "showTopDivider", "Landroidx/recyclerview/widget/RecyclerView;", "w", "Landroidx/recyclerview/widget/RecyclerView;", "sectionsRv", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "linkTv", "u", "titleTv", "Landroid/view/View;", "t", "Landroid/view/View;", "topDivider", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "container", "view", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "sectionsAdapter", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGuideViewImpl extends BaseViewHolder implements AdvertDetailsGuideView {
    public final ViewGroup s;
    public final View t;
    public final TextView u;
    public final TextView v;
    public final RecyclerView w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsGuideViewImpl(@NotNull View view, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "sectionsAdapter");
        View findViewById = view.findViewById(R.id.guide_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guide_container)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.s = viewGroup;
        View findViewById2 = view.findViewById(R.id.divider);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.divider)");
        this.t = findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "container.findViewById(R.id.title)");
        this.u = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.link);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "container.findViewById(R.id.link)");
        this.v = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.sections);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "container.findViewById(R.id.sections)");
        RecyclerView recyclerView = (RecyclerView) findViewById5;
        this.w = recyclerView;
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.addItemDecoration(new MarginBetweenItemsDecoration(getContext().getResources().getDimensionPixelOffset(R.dimen.guide_section_gap) / 2));
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuideView
    @NotNull
    public Context getContext() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuideView
    public void hideLink() {
        Views.setVisible(this.v, false);
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuideView
    public void hideTitle() {
        Views.setVisible(this.u, false);
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuideView
    public void hideTopDivider() {
        Views.hide(this.t);
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuideView
    public void showLink(@NotNull GuideLink guideLink, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(guideLink, "link");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Views.setVisible(this.v, true);
        this.v.setText(guideLink.getTitle());
        this.v.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuideView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        Views.setVisible(this.u, true);
        this.u.setText(str);
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuideView
    public void showTopDivider() {
        Views.show(this.t);
    }
}

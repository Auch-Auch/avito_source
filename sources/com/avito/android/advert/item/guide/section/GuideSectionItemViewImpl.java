package com.avito.android.advert.item.guide.section;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.avito.android.advert_details.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020\u0013¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/advert/item/guide/section/GuideSectionItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/guide/section/GuideSectionItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "backgroundColor", "setBackgroundColor", "(I)V", "Landroid/view/ViewGroup$LayoutParams;", "layoutParams", "setLayoutParams", "(Landroid/view/ViewGroup$LayoutParams;)V", "Lkotlin/Function1;", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleTv", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "u", "descriptionTv", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "container", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class GuideSectionItemViewImpl extends BaseViewHolder implements GuideSectionItemView {
    public final ViewGroup s;
    public final TextView t;
    public final TextView u;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ GuideSectionItemViewImpl a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GuideSectionItemViewImpl guideSectionItemViewImpl, String str) {
            super(0);
            this.a = guideSectionItemViewImpl;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.a.t.getPaint().measureText(this.b) >= ((float) this.a.t.getMeasuredWidth())) {
                this.a.u.setMaxLines(3);
                this.a.u.setLines(3);
            } else {
                this.a.u.setMaxLines(4);
                this.a.u.setLines(4);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuideSectionItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.section_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.section_container)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.s = viewGroup;
        View findViewById2 = viewGroup.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "container.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "container.findViewById(R.id.description)");
        this.u = (TextView) findViewById3;
    }

    @Override // com.avito.android.advert.item.guide.section.GuideSectionItemView
    @NotNull
    public Context getContext() {
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        return context;
    }

    @Override // com.avito.android.advert.item.guide.section.GuideSectionItemView
    public void setBackgroundColor(@ColorInt int i) {
        RoundStateDrawable.Companion companion = RoundStateDrawable.Companion;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        ColorStateList colorStateListCompat = Contexts.getColorStateListCompat(getContext(), R.color.bg_guide_section_item_ripple);
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        this.s.setBackground(RoundStateDrawable.Companion.invoke$default(companion, valueOf, colorStateListCompat, view.getResources().getDimensionPixelSize(R.dimen.guide_section_corner_radius), null, 0, 0, 0, 120, null));
    }

    @Override // com.avito.android.advert.item.guide.section.GuideSectionItemView
    public void setDescription(@Nullable String str) {
        this.u.setText(str);
    }

    @Override // com.avito.android.advert.item.guide.section.GuideSectionItemView
    public void setLayoutParams(@NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.s.setLayoutParams(layoutParams);
    }

    @Override // com.avito.android.advert.item.guide.section.GuideSectionItemView
    public void setOnClickListener(@NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a2.a.a.f.x.v.a.a(function1));
    }

    @Override // com.avito.android.advert.item.guide.section.GuideSectionItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
        Views.ensureMeasured$default(this.t, false, new a(this, str), 1, null);
    }
}

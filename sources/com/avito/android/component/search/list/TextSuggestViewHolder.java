package com.avito.android.component.search.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b9\u0010:J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0019\u001a\u00020\u00042\b\b\u0001\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010 \u001a\u00020\u0004*\u00020\u001f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u000e*\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010,R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u001e\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010*¨\u0006;"}, d2 = {"Lcom/avito/android/component/search/list/TextSuggestViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/search/list/TextSuggestItemView;", "Lkotlin/Function0;", "", "func", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setMinimalHeight", "(Ljava/lang/Integer;)V", "paddingTop", "paddingBottom", "setPadding", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setIcon", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/Integer;Ljava/lang/Integer;)V", "pictureRes", "(I)V", "clearIcon", "()V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "(Lcom/facebook/drawee/view/SimpleDraweeView;Ljava/lang/Integer;Ljava/lang/Integer;)V", "u", "(I)I", "Landroid/view/View;", "y", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleTextView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconView", "w", "I", "defaultImageSize", "x", "defaultVerticalPadding", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", VKApiConst.VERSION, "Landroid/content/res/Resources;", "resources", "descriptionTextView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TextSuggestViewHolder extends BaseViewHolder implements TextSuggestItemView {
    public final TextView s;
    public final TextView t;
    public final SimpleDraweeView u;
    public final Resources v;
    public final int w;
    public final int x;
    public final View y;

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
    public TextSuggestViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.y = view;
        View findViewById = view.findViewById(R.id.suggest_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.suggest_description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.icon);
        this.u = simpleDraweeView;
        Resources resources = view.getResources();
        this.v = resources;
        this.w = resources.getDimensionPixelSize(R.dimen.text_suggest_icon_default_size);
        this.x = resources.getDimensionPixelSize(R.dimen.suggest_item_default_vertical_padding);
        if (simpleDraweeView != null) {
            Context context = simpleDraweeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            simpleDraweeView.setColorFilter(new PorterDuffColorFilter(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black), PorterDuff.Mode.SRC_IN));
        }
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void clearIcon() {
        SimpleDraweeView simpleDraweeView = this.u;
        if (simpleDraweeView != null) {
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).clear();
            Views.hide(simpleDraweeView);
        }
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "func");
        this.y.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void setIcon(@NotNull Picture picture, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        SimpleDraweeView simpleDraweeView = this.u;
        if (simpleDraweeView != null) {
            t(simpleDraweeView, num, num2);
            SimpleDraweeViewsKt.loadPicture$default(simpleDraweeView, picture, null, null, 6, null);
        }
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void setMinimalHeight(@Nullable Integer num) {
        this.y.setMinimumHeight(num != null ? u(num.intValue()) : 0);
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void setPadding(@Nullable Integer num, @Nullable Integer num2) {
        Views.changePadding$default(this.y, 0, num != null ? u(num.intValue()) : this.x, 0, num2 != null ? u(num2.intValue()) : this.x, 5, null);
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    public final void t(SimpleDraweeView simpleDraweeView, Integer num, Integer num2) {
        Views.show(simpleDraweeView);
        simpleDraweeView.getLayoutParams().width = num != null ? u(num.intValue()) : this.w;
        simpleDraweeView.getLayoutParams().height = num2 != null ? u(num2.intValue()) : this.w;
        simpleDraweeView.requestLayout();
    }

    public final int u(int i) {
        return Views.dpToPx(this.y, i);
    }

    @Override // com.avito.android.component.search.list.TextSuggestItemView
    public void setIcon(@DrawableRes int i) {
        SimpleDraweeView simpleDraweeView = this.u;
        if (simpleDraweeView != null) {
            SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).clear();
            t(simpleDraweeView, null, null);
            Drawable drawable = this.y.getContext().getDrawable(i);
            if (drawable != null) {
                ImageRequest.Builder requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView);
                Intrinsics.checkNotNullExpressionValue(drawable, "it");
                requestBuilder.drawable(drawable).load();
            }
        }
    }
}

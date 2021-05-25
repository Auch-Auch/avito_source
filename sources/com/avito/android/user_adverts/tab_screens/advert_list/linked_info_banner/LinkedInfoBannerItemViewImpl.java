package com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.remote.model.LinkedInfoBannerIcon;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.serp.BaseSerpViewHolder;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView;
import com.avito.android.util.Contexts;
import com.avito.android.util.color.ContextsKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b5\u00106J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b!\u0010\u0007J'\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItemViewImpl;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "setMessage", "Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "clickListener", "setDetailsLink", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackground", "(Lcom/avito/android/remote/model/UniversalColor;)V", "setDefaultBackground", "()V", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "linkedInfoBannerIcon", "setIcon", "(Lcom/avito/android/remote/model/LinkedInfoBannerIcon;)V", "hideIcon", "", "visible", "showCloseButton", "(Z)V", "setCloseButtonListener", "title", "setButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "s", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "container", "Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "t", "Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "content", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class LinkedInfoBannerItemViewImpl extends BaseSerpViewHolder implements LinkedInfoBannerItemView {
    public final AlertBanner s;
    public final AlertBannerContent t;
    public final View u;
    public final AttributedTextFormatter v;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LinkedInfoBannerIcon.Type.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            LinkedInfoBannerIcon.Type type = LinkedInfoBannerIcon.Type.ATTENTION;
            iArr[0] = 1;
            LinkedInfoBannerIcon.Type type2 = LinkedInfoBannerIcon.Type.ARROW_TOP_RIGHT;
            iArr[1] = 2;
            LinkedInfoBannerIcon.Type type3 = LinkedInfoBannerIcon.Type.ARROW_BOTTOM_RIGHT;
            iArr[2] = 3;
            LinkedInfoBannerIcon.Type type4 = LinkedInfoBannerIcon.Type.WALLET;
            iArr[3] = 4;
        }
    }

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

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkedInfoBannerItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.u = view;
        this.v = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.linked_info_banner_item);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.alert_banner.AlertBanner");
        AlertBanner alertBanner = (AlertBanner) findViewById;
        this.s = alertBanner;
        this.t = alertBanner.getContent();
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void hideIcon() {
        this.t.setImageDrawable(null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        LinkedInfoBannerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setBackground(@NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        AlertBanner alertBanner = this.s;
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        AlertBanner.setBackground$default(alertBanner, ContextsKt.createColorStateList(context, universalColor), null, 2, null);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setButton(@Nullable String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        this.s.getContent().setButton(str, new a(function0));
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setCloseButtonListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setCloseButtonListener(new c(function0));
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setDefaultBackground() {
        AlertBanner alertBanner = this.s;
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ColorStateList valueOf = ColorStateList.valueOf(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white));
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(v…ttr(design_R.attr.white))");
        AlertBanner.setBackground$default(alertBanner, valueOf, null, 2, null);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setDetailsLink(@Nullable AttributedText attributedText, @NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "clickListener");
        if (attributedText != null) {
            attributedText.setOnDeepLinkClickListener(onDeepLinkClickListener);
        }
        AlertBannerContent alertBannerContent = this.t;
        AttributedTextFormatter attributedTextFormatter = this.v;
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        AlertBannerContent.setLink$default(alertBannerContent, attributedTextFormatter.format(context, attributedText), null, 2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setIcon(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.LinkedInfoBannerIcon r5) {
        /*
            r4 = this;
            java.lang.String r0 = "linkedInfoBannerIcon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.avito.android.remote.model.LinkedInfoBannerIcon$Type r0 = r5.getType()
            if (r0 != 0) goto L_0x000c
            goto L_0x001b
        L_0x000c:
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x0044
            r1 = 1
            if (r0 == r1) goto L_0x0037
            r1 = 2
            if (r0 == r1) goto L_0x002a
            r1 = 3
            if (r0 == r1) goto L_0x001d
        L_0x001b:
            r0 = 0
            goto L_0x0050
        L_0x001d:
            android.view.View r0 = r4.u
            android.content.Context r0 = r0.getContext()
            int r1 = com.avito.android.user_adverts.R.drawable.ic_wallet
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r1)
            goto L_0x0050
        L_0x002a:
            android.view.View r0 = r4.u
            android.content.Context r0 = r0.getContext()
            int r1 = com.avito.android.user_adverts.R.drawable.ic_arrow_bottom_right
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r1)
            goto L_0x0050
        L_0x0037:
            android.view.View r0 = r4.u
            android.content.Context r0 = r0.getContext()
            int r1 = com.avito.android.user_adverts.R.drawable.ic_arrow_top_right
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r1)
            goto L_0x0050
        L_0x0044:
            android.view.View r0 = r4.u
            android.content.Context r0 = r0.getContext()
            int r1 = com.avito.android.user_adverts.R.drawable.ic_status_error
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r1)
        L_0x0050:
            if (r0 == 0) goto L_0x006f
            com.avito.android.lib.design.alert_banner.AlertBannerContent r1 = r4.t
            android.view.View r2 = r4.u
            android.content.Context r2 = r2.getContext()
            java.lang.String r3 = "view.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.avito.android.remote.model.UniversalColor r5 = r5.getColor()
            int r5 = com.avito.android.util.color.ContextsKt.getColorFrom(r2, r5)
            r1.setImageTint(r5)
            com.avito.android.lib.design.alert_banner.AlertBannerContent r5 = r4.t
            r5.setImageDrawable(r0)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemViewImpl.setIcon(com.avito.android.remote.model.LinkedInfoBannerIcon):void");
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setMessage(@Nullable String str) {
        this.t.setBody(str);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void setTitle(@Nullable String str) {
        this.t.setTitle(str);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItemView
    public void showCloseButton(boolean z) {
        this.s.setCloseButtonVisible(z);
    }
}

package com.avito.android.advert_core.feature_teasers.common;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010<\u001a\u00020\u001f\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b=\u0010>J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u001d\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010 \u001a\u00020\u0006*\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\"R\u0016\u0010$\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010-\u001a\n **\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010\"R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/CommonFeatureTeaserView;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "", "text", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "icon", "", "setTitle", "(Ljava/lang/String;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;)V", "setSubtitle", "(Ljava/lang/String;)V", "", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserOption;", "options", "setFeatures", "(Ljava/util/List;)V", "setLinkText", "test", "setButtonText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setLinkTextClickListener", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;", "dialogInfo", "showDialog", "(Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogInfo;)V", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "()Landroid/widget/TextView;", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "(Landroid/view/View;)V", "Landroid/widget/TextView;", "subtitleTextView", "titleTextView", "Lcom/avito/android/lib/design/button/Button;", "e", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "f", "Landroid/content/Context;", "context", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "h", "Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;", "dialogFactory", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "optionsContainer", "d", "link", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", g.a, "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "resourceProvider", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;Lcom/avito/android/advert_core/feature_teasers/common/dialog/FeatureTeaserDialogFactory;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public class CommonFeatureTeaserView implements FeatureTeaserView {
    public final TextView a;
    public final TextView b;
    public final ViewGroup c;
    public final TextView d;
    public final Button e;
    public final Context f;
    public final FeatureTeaserResourceProvider g;
    public final FeatureTeaserDialogFactory h;

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

    public CommonFeatureTeaserView(@NotNull View view, @NotNull FeatureTeaserResourceProvider featureTeaserResourceProvider, @NotNull FeatureTeaserDialogFactory featureTeaserDialogFactory) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(featureTeaserResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(featureTeaserDialogFactory, "dialogFactory");
        this.g = featureTeaserResourceProvider;
        this.h = featureTeaserDialogFactory;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.options_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = (ViewGroup) findViewById3;
        View findViewById4 = view.findViewById(R.id.link);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.e = (Button) findViewById5;
        this.f = view.getContext();
    }

    public final TextView a() {
        TextView textView = new TextView(this.f);
        TextViewCompat.setTextAppearance(textView, com.avito.android.lib.design.R.style.TextAppearance_Avito_Body);
        textView.setPadding(0, textView.getResources().getDimensionPixelSize(R.dimen.advert_details_feature_teaser_option_top_padding), 0, 0);
        return textView;
    }

    public final void b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        layoutParams2.weight = 1.0f;
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setButtonText(@Nullable String str) {
        ButtonsKt.bindText$default(this.e, str, false, 2, null);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setFeatures(@NotNull List<AdvertDetailsFeatureTeaserOption> list) {
        TextView textView;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(list, "options");
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            int childCount = this.c.getChildCount() - 1;
            if (this.g.isTablet()) {
                int i3 = i / 2;
                int i4 = i % 2;
                if (i3 > childCount) {
                    textView = a();
                } else {
                    View childAt = this.c.getChildAt(i3);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    if (viewGroup.getChildCount() - 1 < i4) {
                        textView = a();
                    } else {
                        View childAt2 = viewGroup.getChildAt(i4);
                        Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
                        textView = (TextView) childAt2;
                    }
                }
            } else if (i > childCount) {
                textView = a();
            } else {
                View childAt3 = this.c.getChildAt(i);
                Objects.requireNonNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
                textView = (TextView) childAt3;
            }
            String name = t2.getName();
            AdvertDetailsFeatureTeaserItem.Icon icon = t2.getIcon();
            Context context = this.f;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Drawable drawable = AdvertDetailsFeatureTeaserItemKt.drawable(icon, context);
            Context context2 = this.f;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            textView.setText(AdvertDetailsFeatureTeaserItemKt.textWithLeftIcon(name, drawable, context2.getResources().getDimensionPixelSize(R.dimen.advert_details_feature_teaser_option_icon_padding)));
            if (textView.getParent() == null) {
                if (this.g.isTablet()) {
                    int i5 = i / 2;
                    if (i5 > childCount) {
                        LinearLayout linearLayout2 = new LinearLayout(this.f);
                        linearLayout2.setOrientation(0);
                        this.c.addView(linearLayout2);
                        b(linearLayout2);
                        linearLayout = linearLayout2;
                    } else {
                        View childAt4 = this.c.getChildAt(i5);
                        Objects.requireNonNull(childAt4, "null cannot be cast to non-null type android.view.ViewGroup");
                        linearLayout = (ViewGroup) childAt4;
                    }
                    linearLayout.addView(textView);
                } else {
                    this.c.addView(textView);
                }
                b(textView);
            }
            i = i2;
        }
        if (this.g.isTablet()) {
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list) / 2;
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list) % 2;
            while (this.c.getChildCount() - 1 > lastIndex) {
                ViewGroup viewGroup2 = this.c;
                viewGroup2.removeViewAt(viewGroup2.getChildCount() - 1);
            }
            View childAt5 = this.c.getChildAt(lastIndex);
            Objects.requireNonNull(childAt5, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup3 = (ViewGroup) childAt5;
            int childCount2 = viewGroup3.getChildCount() - 1;
            if (childCount2 > lastIndex2) {
                View childAt6 = viewGroup3.getChildAt(childCount2);
                Objects.requireNonNull(childAt6, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView2 = (TextView) childAt6;
                textView2.setText((CharSequence) null);
                textView2.setCompoundDrawables(null, null, null, null);
            }
        } else {
            int lastIndex3 = CollectionsKt__CollectionsKt.getLastIndex(list);
            while (this.c.getChildCount() - 1 > lastIndex3) {
                ViewGroup viewGroup4 = this.c;
                viewGroup4.removeViewAt(viewGroup4.getChildCount() - 1);
            }
        }
        if (this.g.isTablet() && this.c.getChildCount() != 0) {
            ViewGroup viewGroup5 = this.c;
            View childAt7 = viewGroup5.getChildAt(viewGroup5.getChildCount() - 1);
            if (childAt7 instanceof ViewGroup) {
                ViewGroup viewGroup6 = (ViewGroup) childAt7;
                if (viewGroup6.getChildCount() <= 1) {
                    TextView a3 = a();
                    viewGroup6.addView(a3);
                    b(a3);
                }
            }
        }
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setLinkText(@Nullable String str) {
        TextViews.bindText$default(this.d, str, false, 2, null);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setLinkTextClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.setOnClickListener(new b(function0));
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setSubtitle(@Nullable String str) {
        boolean z = false;
        TextViews.bindText$default(this.b, str, false, 2, null);
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            }
        }
        if (z) {
            TextViewCompat.setTextAppearance(this.b, com.avito.android.lib.design.R.style.TextAppearance_Avito_Body);
            if (this.g.isTablet() || this.g.isLandscape()) {
                TextView textView = this.b;
                Context context = this.f;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                textView.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray44));
            }
        }
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void setTitle(@Nullable String str, @Nullable AdvertDetailsFeatureTeaserItem.Icon icon) {
        TextViews.bindText$default(this.a, str, false, 2, null);
        TextView textView = this.a;
        Context context = this.f;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TextViews.setCompoundDrawables$default(textView, (Drawable) null, (Drawable) null, AdvertDetailsFeatureTeaserItemKt.drawable(icon, context), (Drawable) null, 11, (Object) null);
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView
    public void showDialog(@NotNull AdvertDetailsFeatureTeaserDialogInfo advertDetailsFeatureTeaserDialogInfo) {
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserDialogInfo, "dialogInfo");
        FeatureTeaserDialogFactory featureTeaserDialogFactory = this.h;
        Context context = this.f;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        featureTeaserDialogFactory.create(context, advertDetailsFeatureTeaserDialogInfo).show();
    }
}

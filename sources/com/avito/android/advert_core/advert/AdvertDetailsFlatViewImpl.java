package com.avito.android.advert_core.advert;

import a2.a.a.g.a.a;
import a2.g.r.g;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.avito.android.advert_core.KeyValue;
import com.avito.android.advert_core.R;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.marketplace.SpecificationItem;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B;\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u00105\u001a\u00020/\u0012\b\b\u0002\u00102\u001a\u00020/¢\u0006\u0004\b6\u00107J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J!\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010&\u001a\n \u0019*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00068"}, d2 = {"Lcom/avito/android/advert_core/advert/AdvertDetailsFlatViewImpl;", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "bind", "(Ljava/util/List;)V", "", "color", "forceColors", "(I)V", "Lcom/avito/android/remote/marketplace/SpecificationItem;", "specs", "bindOneColumn", "Landroid/widget/TextView;", "textView", "Lcom/avito/android/remote/model/text/AttributedText;", "text", AuthSource.SEND_ABUSE, "(Landroid/widget/TextView;Lcom/avito/android/remote/model/text/AttributedText;)V", "d", "I", "redesignOrNotkeyValueId", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "container", "e", "Ljava/lang/Integer;", "forcedColor", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/util/text/AttributedTextFormatter;", "f", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", g.a, "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "h", "Z", "isUnlimitedHeight", "Landroid/view/View;", "view", "isRedesign", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;ZZ)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFlatViewImpl implements AdvertDetailsFlatView {
    public final Context a;
    public final LayoutInflater b;
    public ViewGroup c;
    public final int d;
    @ColorInt
    public Integer e;
    public final AttributedTextFormatter f;
    public final AdvertDetailsFlatsListener g;
    public final boolean h;

    public AdvertDetailsFlatViewImpl(@NotNull View view, @Nullable AttributedTextFormatter attributedTextFormatter, @Nullable AdvertDetailsFlatsListener advertDetailsFlatsListener, boolean z, boolean z2) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "view");
        this.f = attributedTextFormatter;
        this.g = advertDetailsFlatsListener;
        this.h = z2;
        Context context = view.getContext();
        this.a = context;
        this.b = LayoutInflater.from(context);
        this.d = z ? R.layout.rds_key_value : R.layout.key_value;
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.flat_stub);
        if (viewStub != null) {
            viewStub.setInflatedId(com.avito.android.ui_components.R.id.flat_container);
            View inflate = viewStub.inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            viewGroup = (ViewGroup) inflate;
        } else {
            viewGroup = (ViewGroup) view.findViewById(com.avito.android.ui_components.R.id.flat_container);
        }
        this.c = viewGroup;
    }

    public final void a(TextView textView, AttributedText attributedText) {
        CharSequence charSequence;
        AttributedTextFormatter attributedTextFormatter = this.f;
        if (attributedTextFormatter != null) {
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            charSequence = attributedTextFormatter.format(context, attributedText);
        } else {
            charSequence = null;
        }
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }

    @Override // com.avito.android.advert_core.advert.AdvertDetailsFlatView
    public void bind(@Nullable List<AdvertParameters.Parameter> list) {
        if (list == null || list.isEmpty()) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                Views.hide(viewGroup);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.c;
        if (viewGroup2 != null) {
            Views.show(viewGroup2);
            int i = 0;
            for (AdvertParameters.Parameter parameter : list) {
                String description = parameter.getDescription();
                if (description != null) {
                    View childAt = viewGroup2.getChildAt(i);
                    if (!(childAt instanceof KeyValue)) {
                        childAt = null;
                    }
                    KeyValue keyValue = (KeyValue) childAt;
                    if (keyValue != null) {
                        String title = parameter.getTitle();
                        DeepLink deepLink = parameter.getDeepLink();
                        if (deepLink != null) {
                            keyValue.setTextAsLink(description);
                        } else {
                            keyValue.setText(description);
                        }
                        keyValue.setTitle(title);
                        keyValue.setOnClickListener(new a(this, deepLink, description, title));
                    } else {
                        String title2 = parameter.getTitle();
                        DeepLink deepLink2 = parameter.getDeepLink();
                        View inflate = this.b.inflate(this.d, viewGroup2, false);
                        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.advert_core.KeyValue");
                        KeyValue keyValue2 = (KeyValue) inflate;
                        if (this.h) {
                            keyValue2.setUnlimitedHeight();
                        }
                        if (deepLink2 != null) {
                            keyValue2.setTextAsLink(description);
                        } else {
                            keyValue2.setText(description);
                        }
                        keyValue2.setTitle(title2);
                        keyValue2.setOnClickListener(new a(this, deepLink2, description, title2));
                        Integer num = this.e;
                        if (num != null) {
                            int intValue = num.intValue();
                            keyValue2.setTextColors(intValue, intValue);
                        }
                        viewGroup2.addView(keyValue2);
                    }
                    i++;
                }
            }
            if (i < viewGroup2.getChildCount()) {
                viewGroup2.removeViews(i, viewGroup2.getChildCount() - i);
            }
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertDetailsFlatView
    public void bindOneColumn(@NotNull List<SpecificationItem> list) {
        Intrinsics.checkNotNullParameter(list, "specs");
        if (list.isEmpty()) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null) {
                Views.hide(viewGroup);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.c;
        if (viewGroup2 != null) {
            Views.show(viewGroup2);
            int i = 0;
            for (SpecificationItem specificationItem : list) {
                View childAt = viewGroup2.getChildAt(i);
                if (!(childAt instanceof TextView)) {
                    childAt = null;
                }
                TextView textView = (TextView) childAt;
                if (textView != null) {
                    a(textView, specificationItem.getAttributedText());
                } else {
                    AttributedText attributedText = specificationItem.getAttributedText();
                    View inflate = this.b.inflate(R.layout.one_column_key_value, viewGroup2, false);
                    Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                    TextView textView2 = (TextView) inflate;
                    a(textView2, attributedText);
                    viewGroup2.addView(textView2);
                }
                i++;
            }
            if (i < viewGroup2.getChildCount()) {
                viewGroup2.removeViews(i, viewGroup2.getChildCount() - i);
            }
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertDetailsFlatView
    public void forceColors(@ColorInt int i) {
        this.e = Integer.valueOf(i);
        ViewGroup viewGroup = this.c;
        if (viewGroup != null) {
            int i2 = 0;
            int childCount = viewGroup.getChildCount() - 1;
            if (childCount >= 0) {
                while (true) {
                    View childAt = viewGroup.getChildAt(i2);
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    if (childAt instanceof KeyValue) {
                        KeyValue keyValue = (KeyValue) childAt;
                        Integer num = this.e;
                        if (num != null) {
                            int intValue = num.intValue();
                            keyValue.setTextColors(intValue, intValue);
                        }
                    }
                    if (i2 != childCount) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsFlatViewImpl(View view, AttributedTextFormatter attributedTextFormatter, AdvertDetailsFlatsListener advertDetailsFlatsListener, boolean z, boolean z2, int i, j jVar) {
        this(view, (i & 2) != 0 ? null : attributedTextFormatter, (i & 4) != 0 ? null : advertDetailsFlatsListener, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }
}

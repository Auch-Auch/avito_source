package com.avito.android.publish_limits_info.history.tab.info;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.publish_limits_info.R;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemViewImpl;", "Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setDescription", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "setExtra", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "description", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "t", "extraInfo", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class InfoItemViewImpl extends BaseViewHolder implements InfoItemView {
    public final TextView s;
    public final TextView t;
    public final AttributedTextFormatter u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.u = attributedTextFormatter;
        this.s = (TextView) view.findViewById(R.id.description);
        TextView textView = (TextView) view.findViewById(R.id.extra_info);
        this.t = textView;
        Intrinsics.checkNotNullExpressionValue(textView, "extraInfo");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        InfoItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.info.InfoItemView
    public void setDescription(@Nullable String str) {
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "description");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.info.InfoItemView
    public void setExtra(@Nullable AttributedText attributedText) {
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "extraInfo");
        TextViewsKt.bindAttributedText(textView, attributedText, this.u);
    }
}

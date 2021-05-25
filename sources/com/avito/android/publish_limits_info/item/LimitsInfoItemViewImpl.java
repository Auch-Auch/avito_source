package com.avito.android.publish_limits_info.item;

import android.content.Context;
import android.view.View;
import com.avito.android.publish_limits_info.PublishLimitsInfoView;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/publish_limits_info/item/LimitsInfoItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemView;", "Lcom/avito/android/remote/model/LimitsInfo;", "info", "", "showTitle", "", "setLimitsInfo", "(Lcom/avito/android/remote/model/LimitsInfo;Z)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "t", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Lcom/avito/android/publish_limits_info/PublishLimitsInfoView;", "s", "Lcom/avito/android/publish_limits_info/PublishLimitsInfoView;", "infoView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoItemViewImpl extends BaseViewHolder implements LimitsInfoItemView {
    public final PublishLimitsInfoView s;
    public final AttributedTextFormatter t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LimitsInfoItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.t = attributedTextFormatter;
        this.s = (PublishLimitsInfoView) view;
    }

    @Override // com.avito.android.publish_limits_info.item.LimitsInfoItemView
    public void setLimitsInfo(@NotNull LimitsInfo limitsInfo, boolean z) {
        Intrinsics.checkNotNullParameter(limitsInfo, "info");
        PublishLimitsInfoView publishLimitsInfoView = this.s;
        String title = limitsInfo.getTitle();
        String str = null;
        if (!z) {
            title = null;
        }
        publishLimitsInfoView.setTitle(title);
        this.s.setDescription(limitsInfo.getDescription());
        LimitsInfo.Progress progress = limitsInfo.getProgress();
        if (progress != null) {
            this.s.setProgress(progress.getValue(), progress.getStyle());
        } else {
            this.s.hideProgress();
        }
        PublishLimitsInfoView publishLimitsInfoView2 = this.s;
        LimitsInfo.Progress progress2 = limitsInfo.getProgress();
        if (progress2 != null) {
            str = progress2.getProgressHint();
        }
        publishLimitsInfoView2.setProgressHint(str);
        this.s.setLocation(limitsInfo.getLocation());
        this.s.setCategory(limitsInfo.getCategory());
        PublishLimitsInfoView publishLimitsInfoView3 = this.s;
        AttributedTextFormatter attributedTextFormatter = this.t;
        Context context = publishLimitsInfoView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "infoView.context");
        publishLimitsInfoView3.setExtraInfo(attributedTextFormatter.format(context, limitsInfo.getExtraInfo()));
    }
}

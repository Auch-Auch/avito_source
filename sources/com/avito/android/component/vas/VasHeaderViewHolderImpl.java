package com.avito.android.component.vas;

import android.view.View;
import com.avito.android.component.vas.VasHeaderViewHolder;
import com.avito.android.image_loader.Picture;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0001¢\u0006\u0004\b\u0012\u0010\fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/component/vas/VasHeaderViewHolderImpl;", "Lcom/avito/android/component/vas/VasHeaderViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/vas/VasHeader;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "(Ljava/lang/CharSequence;)V", "", "isVisible", "setSubtitleVisible", "(Z)V", "title", "setTitle", "Landroid/view/View;", "s", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class VasHeaderViewHolderImpl extends BaseViewHolder implements VasHeaderViewHolder, VasHeader {
    public final View s;
    public final /* synthetic */ VasHeaderImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VasHeaderViewHolderImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new VasHeaderImpl(view);
        this.s = view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VasHeaderViewHolder.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.t.setPicture(picture);
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setSubtitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, MessengerShareContentUtility.SUBTITLE);
        this.t.setSubtitle(charSequence);
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setSubtitleVisible(boolean z) {
        this.t.setSubtitleVisible(z);
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.t.setTitle(charSequence);
    }
}

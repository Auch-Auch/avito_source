package com.avito.android.component.vas;

import a2.b.a.a.a;
import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/component/vas/VasHeaderImpl;", "Lcom/avito/android/component/vas/VasHeader;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "", "isVisible", "setSubtitleVisible", "(Z)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iconView", "Lru/avito/component/text/TextImpl;", AuthSource.BOOKING_ORDER, "Lru/avito/component/text/TextImpl;", "subtitleView", AuthSource.SEND_ABUSE, "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class VasHeaderImpl implements VasHeader {
    public final TextImpl a;
    public final TextImpl b;
    public final SimpleDraweeView c;

    public VasHeaderImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = new TextImpl(Views.findById(view, R.id.vas_header_title));
        this.b = new TextImpl(Views.findById(view, R.id.vas_header_subtitle));
        this.c = (SimpleDraweeView) Views.findById(view, R.id.vas_header_icon);
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a.L0(this.c, picture);
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setSubtitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, MessengerShareContentUtility.SUBTITLE);
        this.b.setText(charSequence);
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setSubtitleVisible(boolean z) {
        TextImpl textImpl = this.b;
        if (z) {
            textImpl.show();
        } else {
            textImpl.hide();
        }
    }

    @Override // com.avito.android.component.vas.VasHeader
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.a.setText(charSequence);
    }
}

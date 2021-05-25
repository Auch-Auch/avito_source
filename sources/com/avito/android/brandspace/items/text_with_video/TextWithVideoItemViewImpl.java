package com.avito.android.brandspace.items.text_with_video;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.brandspace.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010!\u001a\u00020\u001c¢\u0006\u0004\b1\u00102J]\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010\t\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0018\u0010$\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0016\u0010\b\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u000b\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/text_with_video/TextWithVideoItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "isImageRightAligned", "", "title", "description", "additionalDescription", "action", "Landroid/view/View$OnClickListener;", "actionClickListener", "imageClickListener", "", "bind", "(Lcom/avito/android/remote/model/Image;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)V", "isVisible", "setPlayVideoImageVisible", "(Z)V", "Landroid/widget/TextView;", "w", "Landroid/widget/TextView;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "titleBottomMargin", "Landroid/view/View;", "y", "Landroid/view/View;", "textContainer", "B", "view", VKApiConst.VERSION, "z", "imageContainer", "u", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "playImage", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Lcom/avito/android/lib/design/button/Button;", "x", "Lcom/avito/android/lib/design/button/Button;", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class TextWithVideoItemViewImpl extends BaseViewHolder implements TextWithVideoItemView {
    public final int A;
    public final View B;
    public final SimpleDraweeView s;
    public final ImageView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final Button x;
    public final View y;
    public final View z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextWithVideoItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.B = view;
        View findViewById = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image)");
        this.s = (SimpleDraweeView) findViewById;
        this.t = (ImageView) view.findViewById(R.id.play_image);
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        TextView textView = (TextView) findViewById2;
        this.u = textView;
        View findViewById3 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.description)");
        this.v = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.additionalDescription);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.additionalDescription)");
        this.w = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.action);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.action)");
        this.x = (Button) findViewById5;
        this.y = view.findViewById(R.id.text_container);
        this.z = view.findViewById(R.id.image_container);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (!(layoutParams instanceof ViewGroup.MarginLayoutParams) ? null : layoutParams);
        this.A = marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        if ((r17.length() > 0) != false) goto L_0x0017;
     */
    @Override // com.avito.android.brandspace.items.text_with_video.TextWithVideoItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(@org.jetbrains.annotations.Nullable com.avito.android.remote.model.Image r15, boolean r16, @org.jetbrains.annotations.Nullable java.lang.String r17, @org.jetbrains.annotations.Nullable java.lang.String r18, @org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.Nullable java.lang.String r20, @org.jetbrains.annotations.Nullable android.view.View.OnClickListener r21, @org.jetbrains.annotations.Nullable android.view.View.OnClickListener r22) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.text_with_video.TextWithVideoItemViewImpl.bind(com.avito.android.remote.model.Image, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.view.View$OnClickListener, android.view.View$OnClickListener):void");
    }

    public final void setPlayVideoImageVisible(boolean z2) {
        Views.setVisible(this.t, z2);
    }
}

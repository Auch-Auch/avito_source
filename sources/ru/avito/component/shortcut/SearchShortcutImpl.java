package ru.avito.component.shortcut;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.annotation.ColorInt;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.SimplePictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.LookupHyphenator;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.IDocumentLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0001\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lru/avito/component/shortcut/SearchShortcutImpl;", "Lru/avito/component/shortcut/SearchShortcut;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "", "placeholderColor", "setPicture", "(Lcom/avito/android/image_loader/Picture;I)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "widthPx", "setWidth", "(I)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Lcom/avito/android/util/LookupHyphenator;", "c", "Lcom/avito/android/util/LookupHyphenator;", "hyphenator", "Lcom/bluejamesbond/text/DocumentView;", AuthSource.BOOKING_ORDER, "Lcom/bluejamesbond/text/DocumentView;", "titleView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SearchShortcutImpl implements SearchShortcut {
    public final SimpleDraweeView a;
    public final DocumentView b;
    public final LookupHyphenator c;
    public final View d;

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

    public SearchShortcutImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.a = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.bluejamesbond.text.DocumentView");
        DocumentView documentView = (DocumentView) findViewById2;
        this.b = documentView;
        LookupHyphenator lookupHyphenator = new LookupHyphenator();
        this.c = lookupHyphenator;
        documentView.setDisallowInterceptTouch(true);
        IDocumentLayout.LayoutParams documentLayoutParams = documentView.getDocumentLayoutParams();
        Intrinsics.checkNotNullExpressionValue(documentLayoutParams, "titleView.documentLayoutParams");
        documentLayoutParams.setHyphenator(lookupHyphenator);
        IDocumentLayout.LayoutParams documentLayoutParams2 = documentView.getDocumentLayoutParams();
        Intrinsics.checkNotNullExpressionValue(documentLayoutParams2, "titleView.documentLayoutParams");
        documentLayoutParams2.setHyphenated(true);
    }

    @Override // ru.avito.component.shortcut.SearchShortcut
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.setOnClickListener(new a(function0));
    }

    @Override // ru.avito.component.shortcut.SearchShortcut
    public void setPicture(@Nullable Picture picture, @ColorInt int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.a.getHierarchy();
        Intrinsics.checkNotNullExpressionValue(genericDraweeHierarchy, "imageView.hierarchy");
        RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
        gradientDrawable.setCornerRadii(roundingParams != null ? roundingParams.getCornersRadii() : null);
        SimpleDraweeViewsKt.getRequestBuilder(this.a).placeholder(gradientDrawable).picture(SimplePictureKt.orEmpty(picture)).load();
    }

    @Override // ru.avito.component.shortcut.SearchShortcut
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.c.setLookup(str);
        DocumentView documentView = this.b;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!(charAt == 173)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
        documentView.setText(sb2);
    }

    @Override // ru.avito.component.shortcut.SearchShortcut
    public void setWidth(int i) {
        this.d.getLayoutParams().width = i;
        this.d.requestLayout();
    }
}

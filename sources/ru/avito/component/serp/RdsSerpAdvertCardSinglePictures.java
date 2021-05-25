package ru.avito.component.serp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.image_loader.ForegroundConverter;
import com.avito.android.image_loader.ForegroundConverterImpl;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b&\u0010'J/\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lru/avito/component/serp/RdsSerpAdvertCardSinglePictures;", "Lru/avito/component/serp/RdsSerpAdvertCardImpl;", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "", "cancelOnDetach", "", BookingInfoActivity.EXTRA_ITEM_ID, "", "setPictures", "(Ljava/util/List;ZLjava/lang/String;)V", "", "alpha", "setActive", "(F)V", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "I", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/image_loader/ForegroundConverter;", "G", "Lcom/avito/android/image_loader/ForegroundConverter;", "foregroundImageConverter", "Lcom/facebook/drawee/view/SimpleDraweeView;", "H", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "view", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "<init>", "(Landroid/view/View;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RdsSerpAdvertCardSinglePictures extends RdsSerpAdvertCardImpl {
    public final ForegroundConverter G = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
    public final SimpleDraweeView H;
    public final ConnectivityProvider I;

    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ RdsSerpAdvertCardSinglePictures a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RdsSerpAdvertCardSinglePictures rdsSerpAdvertCardSinglePictures) {
            super(0);
            this.a = rdsSerpAdvertCardSinglePictures;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(this.a.I.isConnectionAvailable());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RdsSerpAdvertCardSinglePictures(@NotNull View view, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull ConnectivityProvider connectivityProvider) {
        super(view, timeSource, locale);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
        this.I = connectivityProvider;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.H = (SimpleDraweeView) findViewById;
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return picture.getUri(this.H);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCardImpl
    public void setActive(float f) {
        super.setActive(f);
        this.H.setAlpha(f);
    }

    @Override // ru.avito.component.serp.RdsSerpAdvertCard
    public void setPictures(@NotNull List<? extends Picture> list, boolean z, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        Picture picture = (Picture) CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        ForegroundConverter foregroundConverter = this.G;
        Context context = this.H.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
        Drawable convert$default = ForegroundConverter.DefaultImpls.convert$default(foregroundConverter, context, picture, null, 4, null);
        if (Intrinsics.areEqual(picture.getUri(this.H), Uri.EMPTY)) {
            Drawable drawable = Views.getDrawable(this.H, R.drawable.ic_rds_stub);
            SimpleDraweeViewsKt.getRequestBuilder(this.H).placeholder(drawable).drawable(drawable).foreground(convert$default).sourcePlace(ImageRequest.SourcePlace.SNIPPET).advertId(str).isConnectionAvailable(new a(this)).load();
            return;
        }
        SimpleDraweeViewsKt.getRequestBuilder(this.H).picture(picture).cancelOnDetach(z).foreground(convert$default).load();
    }
}

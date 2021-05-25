package ru.avito.component.serp.cyclic_gallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.image_loader.ForegroundConverter;
import com.avito.android.image_loader.ForegroundConverterImpl;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0001\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010$J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/GalleryPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/View;", "view", "", "item", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "", "getCount", "()I", "Landroid/view/ViewGroup;", "container", VKApiConst.POSITION, "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "getItemPosition", "(Ljava/lang/Object;)I", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;", "dataProvider", "setDataProvider", "(Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;)V", "d", "Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;", "Lcom/avito/android/image_loader/ForegroundConverter;", "c", "Lcom/avito/android/image_loader/ForegroundConverter;", "foregroundImageConverter", "e", "I", "pageId", "<init>", "(Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryPagerAdapter extends PagerAdapter {
    public final ForegroundConverter c = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
    public GalleryDataProvider d;
    public final int e;

    public GalleryPagerAdapter(@NotNull GalleryDataProvider galleryDataProvider, @LayoutRes int i) {
        Intrinsics.checkNotNullParameter(galleryDataProvider, "dataProvider");
        this.d = galleryDataProvider;
        this.e = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "view");
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.d.getPagesCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.e, viewGroup, false);
        Picture pictureForPage = this.d.getPictureForPage(i);
        ForegroundConverter foregroundConverter = this.c;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        Drawable convert$default = ForegroundConverter.DefaultImpls.convert$default(foregroundConverter, context, pictureForPage, null, 4, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        View findViewById = inflate.findViewById(R.id.image_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeViewsKt.getRequestBuilder((SimpleDraweeView) findViewById).picture(pictureForPage).foreground(convert$default).sourcePlace(ImageRequest.SourcePlace.SNIPPET).load();
        ((ViewPager) viewGroup).addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "item");
        return Intrinsics.areEqual(view, obj);
    }

    public final void setDataProvider(@NotNull GalleryDataProvider galleryDataProvider) {
        Intrinsics.checkNotNullParameter(galleryDataProvider, "dataProvider");
        this.d = galleryDataProvider;
        notifyDataSetChanged();
    }
}

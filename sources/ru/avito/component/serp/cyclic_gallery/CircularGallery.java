package ru.avito.component.serp.cyclic_gallery;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010+\u001a\u00020(\u0012\b\b\u0001\u00104\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u00020\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00067"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/CircularGallery;", "", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "setupSize", "(II)V", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", VKApiConst.POSITION, "", "smoothScroll", "setCurrentPicture", "(IZ)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPictureChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lru/avito/component/serp/cyclic_gallery/GalleryPagerAdapter;", "d", "Lru/avito/component/serp/cyclic_gallery/GalleryPagerAdapter;", "adapter", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "e", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "pageIndicatingListener", "Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;", "c", "Lru/avito/component/serp/cyclic_gallery/GalleryDataProvider;", "dataProvider", "f", "Lkotlin/jvm/functions/Function1;", "pictureChangeListener", "Landroid/view/View;", g.a, "Landroid/view/View;", "view", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "pagerIndicator", "Landroidx/viewpager/widget/ViewPager;", AuthSource.SEND_ABUSE, "Landroidx/viewpager/widget/ViewPager;", "pager", "pageId", "<init>", "(Landroid/view/View;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CircularGallery {
    public final ViewPager a;
    public TextView b;
    public GalleryDataProvider c;
    public GalleryPagerAdapter d;
    public ViewPager.OnPageChangeListener e;
    public Function1<? super Integer, Unit> f;
    public final View g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(CircularGallery circularGallery, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public CircularGallery(@NotNull View view, @LayoutRes int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        View findViewById = view.findViewById(R.id.image_pager);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        ViewPager viewPager = (ViewPager) findViewById;
        this.a = viewPager;
        View findViewById2 = view.findViewById(R.id.page_indicator);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        SinglePageDataProvider singlePageDataProvider = new SinglePageDataProvider(AvitoPictureKt.pictureOf$default(null, false, 0.0f, 0.0f, null, 28, null));
        this.c = singlePageDataProvider;
        GalleryPagerAdapter galleryPagerAdapter = new GalleryPagerAdapter(singlePageDataProvider, i);
        this.d = galleryPagerAdapter;
        viewPager.setAdapter(galleryPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(this) { // from class: ru.avito.component.serp.cyclic_gallery.CircularGallery.1
            public final /* synthetic */ CircularGallery a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                Function1 function1 = this.a.f;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(Integer.valueOf(this.a.c.getPicturePositionByPage(i2)));
                }
            }
        });
    }

    public final void setCurrentPicture(int i, boolean z) {
        this.a.setCurrentItem(this.c.getPageByPicturePosition(i), z);
    }

    public final void setOnClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.a.setOnClickListener(new a(this, function0));
        } else {
            this.a.setOnClickListener(null);
        }
    }

    public final void setPictureChangeListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.f = function1;
    }

    public final void setPictures(@NotNull List<? extends Picture> list) {
        Picture picture;
        Intrinsics.checkNotNullParameter(list, "pictures");
        ViewPager.OnPageChangeListener onPageChangeListener = this.e;
        if (onPageChangeListener != null) {
            this.a.removeOnPageChangeListener(onPageChangeListener);
        }
        if (list.size() > 1) {
            CircularDataProvider circularDataProvider = new CircularDataProvider(list);
            this.d.setDataProvider(circularDataProvider);
            CircularGallery$setupPageIndicator$1 circularGallery$setupPageIndicator$1 = new ViewPager.SimpleOnPageChangeListener(circularDataProvider) { // from class: ru.avito.component.serp.cyclic_gallery.CircularGallery$setupPageIndicator$1
                public final /* synthetic */ CircularDataProvider b;

                {
                    this.b = r2;
                }

                @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i) {
                    CircularGallery.this.b.setText(this.b.getIndicatorForPosition(i));
                }
            };
            this.e = circularGallery$setupPageIndicator$1;
            this.a.addOnPageChangeListener(circularGallery$setupPageIndicator$1);
            Views.setVisible(this.b, true);
            this.c = circularDataProvider;
            this.a.setCurrentItem(circularDataProvider.getPageByPicturePosition(0), false);
            return;
        }
        if (list.isEmpty()) {
            picture = AvitoPictureKt.pictureOf$default(null, false, 0.0f, 0.0f, null, 28, null);
        } else {
            picture = (Picture) CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        }
        this.e = null;
        Views.setVisible(this.b, false);
        SinglePageDataProvider singlePageDataProvider = new SinglePageDataProvider(picture);
        this.d.setDataProvider(singlePageDataProvider);
        this.c = singlePageDataProvider;
    }

    public final void setupSize(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.g.setLayoutParams(layoutParams);
    }
}

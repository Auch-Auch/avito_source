package com.avito.android.photo_gallery;

import a2.b.a.a.a;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.util.Constants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/photo_gallery/PhotoGalleryActivity$simpleOnPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", VKApiConst.POSITION, "", "onPageSelected", "(I)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryActivity$simpleOnPageChangeListener$1 extends ViewPager.SimpleOnPageChangeListener {
    public final /* synthetic */ PhotoGalleryActivity a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public PhotoGalleryActivity$simpleOnPageChangeListener$1(PhotoGalleryActivity photoGalleryActivity) {
        this.a = photoGalleryActivity;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.a.getIntent().putExtra(Constants.IMAGE_POSITION, i);
        PhotoGalleryActivity.access$resetZoomForZoomableFragments(this.a);
        PhotoGalleryActivity photoGalleryActivity = this.a;
        int i2 = photoGalleryActivity.n;
        StringBuilder L = a.L("Фото ");
        L.append(i + 1);
        L.append(" из ");
        L.append(i2);
        photoGalleryActivity.setTitle(L.toString());
    }
}

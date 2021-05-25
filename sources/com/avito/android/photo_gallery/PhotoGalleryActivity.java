package com.avito.android.photo_gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.photo_gallery.adapter.FullscreenGalleryAdapter;
import com.avito.android.photo_gallery.adapter.GalleryAdapterKt;
import com.avito.android.photo_gallery.common.ImageLoadListener;
import com.avito.android.photo_gallery.common.ToastsKt;
import com.avito.android.photo_gallery.di.DaggerPhotoGalleryApplicationComponent;
import com.avito.android.photo_gallery.di.PhotoGalleryDependencies;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.ui.SafeViewPager;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Constants;
import com.avito.android.util.ImplicitIntentFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001d\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bD\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010>\u001a\u00020=8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/avito/android/photo_gallery/PhotoGalleryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onImageLoadFailed", "onImageLoadSuccess", "outState", "onSaveInstanceState", "Lcom/avito/android/ui/SafeViewPager;", "k", "Lcom/avito/android/ui/SafeViewPager;", "viewPager", "Landroid/widget/Toast;", "l", "Landroid/widget/Toast;", "imageProblemToast", "com/avito/android/photo_gallery/PhotoGalleryActivity$simpleOnPageChangeListener$1", "o", "Lcom/avito/android/photo_gallery/PhotoGalleryActivity$simpleOnPageChangeListener$1;", "simpleOnPageChangeListener", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "", AuthSource.OPEN_CHANNEL_LIST, "Z", "toolbarIsShown", "n", "I", "imageCount", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "Landroidx/appcompat/widget/Toolbar;", "photoToolbar", "Landroidx/appcompat/widget/Toolbar;", "getPhotoToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setPhotoToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "<init>", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryActivity extends BaseActivity implements ImageLoadListener {
    @Inject
    public Analytics analytics;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public SafeViewPager k;
    public Toast l;
    public boolean m = true;
    public int n;
    public final PhotoGalleryActivity$simpleOnPageChangeListener$1 o = new PhotoGalleryActivity$simpleOnPageChangeListener$1(this);
    public Toolbar photoToolbar;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PhotoGalleryActivity a;

        public a(PhotoGalleryActivity photoGalleryActivity) {
            this.a = photoGalleryActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onBackPressed();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PhotoGalleryActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PhotoGalleryActivity photoGalleryActivity) {
            super(0);
            this.a = photoGalleryActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (this.a.m) {
                PhotoGalleryActivity photoGalleryActivity = this.a;
                Toolbar photoToolbar = photoGalleryActivity.getPhotoToolbar();
                photoToolbar.animate().translationY(-((float) photoToolbar.getHeight())).alpha(0.0f).setInterpolator(new LinearInterpolator()).start();
                photoGalleryActivity.m = false;
            } else {
                PhotoGalleryActivity photoGalleryActivity2 = this.a;
                photoGalleryActivity2.getPhotoToolbar().animate().translationY(0.0f).alpha(1.0f).setInterpolator(new LinearInterpolator()).start();
                photoGalleryActivity2.m = true;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void access$hideToolbarAnimated(PhotoGalleryActivity photoGalleryActivity) {
        Toolbar photoToolbar2 = photoGalleryActivity.getPhotoToolbar();
        photoToolbar2.animate().translationY(-((float) photoToolbar2.getHeight())).alpha(0.0f).setInterpolator(new LinearInterpolator()).start();
        photoGalleryActivity.m = false;
    }

    public static final void access$resetZoomForZoomableFragments(PhotoGalleryActivity photoGalleryActivity) {
        FragmentManager supportFragmentManager = photoGalleryActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<Fragment> fragments = supportFragmentManager.getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Sequence<ZoomableFragment> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(fragments), PhotoGalleryActivity$resetZoomForZoomableFragments$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        for (ZoomableFragment zoomableFragment : filter) {
            zoomableFragment.resetZoom();
        }
    }

    public static final void access$showToolbarAnimated(PhotoGalleryActivity photoGalleryActivity) {
        photoGalleryActivity.getPhotoToolbar().animate().translationY(0.0f).alpha(1.0f).setInterpolator(new LinearInterpolator()).start();
        photoGalleryActivity.m = true;
    }

    public static final void access$updateCounterInTitle(PhotoGalleryActivity photoGalleryActivity, int i, int i2) {
        Objects.requireNonNull(photoGalleryActivity);
        photoGalleryActivity.setTitle("Фото " + (i + 1) + " из " + i2);
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final Toolbar getPhotoToolbar() {
        Toolbar toolbar = this.photoToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoToolbar");
        }
        return toolbar;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 11) {
            return;
        }
        if (i2 == -1) {
            SafeViewPager safeViewPager = this.k;
            if (safeViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            PagerAdapter adapter = safeViewPager.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else if (i2 == 0) {
            SafeViewPager safeViewPager2 = this.k;
            if (safeViewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            if (safeViewPager2.getCurrentItem() > 0) {
                SafeViewPager safeViewPager3 = this.k;
                if (safeViewPager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                }
                SafeViewPager safeViewPager4 = this.k;
                if (safeViewPager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                }
                safeViewPager3.setCurrentItem(safeViewPager4.getCurrentItem() - 1);
                return;
            }
            finish();
        } else {
            finish();
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1, getIntent());
        supportFinishAfterTransition();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerPhotoGalleryApplicationComponent.builder().photoGalleryDependencies((PhotoGalleryDependencies) ComponentDependenciesKt.getDependencies(PhotoGalleryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        setContentView(R.layout.ac_photogallery);
        View findViewById = findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById;
        this.photoToolbar = toolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoToolbar");
        }
        setSupportActionBar(toolbar);
        Toolbar toolbar2 = this.photoToolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoToolbar");
        }
        toolbar2.setNavigationOnClickListener(new a(this));
        AutotekaTeaserGalleryModel autotekaTeaserGalleryModel = (AutotekaTeaserGalleryModel) getIntent().getParcelableExtra("teaser");
        Video video = (Video) getIntent().getParcelableExtra("video");
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("images");
        List photoGalleryCollectItems$default = GalleryAdapterKt.photoGalleryCollectItems$default(video, parcelableArrayListExtra, null, null, 12, null);
        View findViewById2 = findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.view_pager)");
        SafeViewPager safeViewPager = (SafeViewPager) findViewById2;
        this.k = safeViewPager;
        if (safeViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        safeViewPager.setOffscreenPageLimit(1);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        FullscreenGalleryAdapter fullscreenGalleryAdapter = new FullscreenGalleryAdapter(this, supportFragmentManager, photoGalleryCollectItems$default, null, this, implicitIntentFactory2, analytics2, new b(this), null, null, null, 1800, null);
        SafeViewPager safeViewPager2 = this.k;
        if (safeViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        safeViewPager2.setAdapter(fullscreenGalleryAdapter);
        int intExtra = getIntent().getIntExtra(Constants.IMAGE_POSITION, 0);
        SafeViewPager safeViewPager3 = this.k;
        if (safeViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        safeViewPager3.setCurrentItem(intExtra);
        int size = parcelableArrayListExtra.size();
        this.n = size;
        StringBuilder L = a2.b.a.a.a.L("Фото ");
        L.append(intExtra + 1);
        L.append(" из ");
        L.append(size);
        setTitle(L.toString());
        SafeViewPager safeViewPager4 = this.k;
        if (safeViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        safeViewPager4.addOnPageChangeListener(this.o);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        }
        boolean z = bundle != null ? bundle.getBoolean("TOOLBAR_IS_SHOWN_KEY") : true;
        this.m = z;
        if (!z) {
            Toolbar photoToolbar2 = getPhotoToolbar();
            photoToolbar2.setAlpha(0.0f);
            photoToolbar2.setTranslationY(-((float) photoToolbar2.getHeight()));
        }
    }

    @Override // com.avito.android.photo_gallery.common.ImageLoadListener
    public void onImageLoadFailed() {
        if (!ToastsKt.isShowing(this.l)) {
            Toast toast = this.l;
            if (toast != null) {
                toast.cancel();
            }
            this.l = com.avito.android.util.ToastsKt.showToast$default(this, R.string.photo_load_error, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.photo_gallery.common.ImageLoadListener
    public void onImageLoadSuccess() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        bundle.putBoolean("TOOLBAR_IS_SHOWN_KEY", this.m);
        super.onSaveInstanceState(bundle);
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPhotoToolbar(@NotNull Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "<set-?>");
        this.photoToolbar = toolbar;
    }
}

package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import com.my.target.fq;
import com.my.target.is;
@SuppressLint({"ViewConstructor"})
public class gv extends ViewGroup implements fq.a {
    @NonNull
    public final gc a;
    @NonNull
    public final io b;
    public final boolean c;
    @NonNull
    public final fx d;
    @NonNull
    public final c e;
    @NonNull
    public final fq f;
    @NonNull
    public final FrameLayout g;
    @NonNull
    public final ProgressBar h;
    public final boolean i;
    @Nullable
    public is j;
    @Nullable
    public VideoData k;
    @Nullable
    public a l;
    public int m;
    public int n;
    @Nullable
    public Bitmap o;
    public boolean p = true;

    public interface a extends AudioManager.OnAudioFocusChangeListener, is.a {
        void de();

        void dg();

        void dh();

        void di();
    }

    public class c implements View.OnClickListener {
        public c(b bVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gv gvVar = gv.this;
            if (gvVar.l != null) {
                if (!gvVar.isPlaying() && !gv.this.isPaused()) {
                    gv.this.l.de();
                } else if (!gv.this.isPaused()) {
                    gv.this.l.dg();
                } else {
                    gv.this.l.dh();
                }
            }
        }
    }

    public gv(@NonNull Context context, @NonNull io ioVar, boolean z, boolean z2) {
        super(context);
        this.b = ioVar;
        this.c = z;
        this.i = z2;
        this.a = new gc(context);
        this.d = new fx(context);
        this.h = new ProgressBar(context, null, 16842874);
        FrameLayout frameLayout = new FrameLayout(context);
        this.g = frameLayout;
        io.a(frameLayout, 0, 868608760);
        fq fqVar = new fq(context);
        this.f = fqVar;
        fqVar.setAdVideoViewListener(this);
        this.e = new c(null);
    }

    public void D(int i2) {
        is isVar = this.j;
        if (isVar == null) {
            return;
        }
        if (i2 == 0) {
            isVar.N();
        } else if (i2 != 1) {
            isVar.da();
        } else {
            isVar.M();
        }
    }

    @Override // com.my.target.fq.a
    public void J() {
        a aVar;
        if (this.j instanceof iu) {
            this.f.setViewMode(1);
            VideoData videoData = this.k;
            if (videoData != null) {
                this.f.d(videoData.getWidth(), this.k.getHeight());
            }
            this.j.a(this.f);
            if (this.j.isPlaying() && (aVar = this.l) != null) {
                aVar.di();
                return;
            }
            return;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.e("Playback within no hardware accelerated view is available only with ExoPlayer");
        }
    }

    public void a(ce ceVar) {
        destroy();
        c(ceVar);
    }

    public void a(@NonNull ce ceVar, int i2) {
        int i3;
        io ioVar;
        if (ceVar.getVideoBanner() != null) {
            this.g.setVisibility(8);
            cf<VideoData> videoBanner = ceVar.getVideoBanner();
            if (videoBanner != null) {
                VideoData mediaData = videoBanner.getMediaData();
                this.k = mediaData;
                if (mediaData != null) {
                    is fm = (!this.i || !id.eF()) ? it.fm() : iu.ah(getContext());
                    this.j = fm;
                    fm.a(this.l);
                    if (videoBanner.isAutoMute()) {
                        this.j.setVolume(0.0f);
                    }
                    this.n = this.k.getWidth();
                    this.m = this.k.getHeight();
                    ImageData preview = videoBanner.getPreview();
                    if (preview != null) {
                        this.o = preview.getData();
                        if (this.n <= 0 || this.m <= 0) {
                            this.n = preview.getWidth();
                            this.m = preview.getHeight();
                        }
                        this.a.setImageBitmap(this.o);
                    } else {
                        ImageData image = ceVar.getImage();
                        if (image != null) {
                            if (this.n <= 0 || this.m <= 0) {
                                this.n = image.getWidth();
                                this.m = image.getHeight();
                            }
                            Bitmap data = image.getData();
                            this.o = data;
                            this.a.setImageBitmap(data);
                        }
                    }
                    if (i2 != 1) {
                        if (this.c) {
                            ioVar = this.b;
                            i3 = 140;
                        } else {
                            ioVar = this.b;
                            i3 = 96;
                        }
                        this.d.a(fi.C(ioVar.L(i3)), false);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        c(ceVar);
    }

    public void a(boolean z) {
        is isVar = this.j;
        if (isVar != null) {
            isVar.stop();
        }
        this.h.setVisibility(8);
        this.a.setVisibility(0);
        this.a.setImageBitmap(this.o);
        this.p = z;
        if (z) {
            this.d.setVisibility(0);
            return;
        }
        this.a.setOnClickListener(null);
        this.d.setOnClickListener(null);
        setOnClickListener(null);
    }

    public void b(boolean z) {
        is isVar;
        is isVar2;
        this.d.setVisibility(8);
        this.h.setVisibility(0);
        if (this.k != null && (isVar = this.j) != null) {
            isVar.a(this.l);
            this.j.a(this.f);
            this.f.d(this.k.getWidth(), this.k.getHeight());
            String str = (String) this.k.getData();
            if (!z || str == null) {
                isVar2 = this.j;
                str = this.k.getUrl();
            } else {
                isVar2 = this.j;
            }
            isVar2.a(Uri.parse(str), this.f.getContext());
        }
    }

    public final void c(@NonNull ce ceVar) {
        this.g.setVisibility(0);
        setOnClickListener(null);
        this.d.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setVisibility(8);
        this.a.setVisibility(0);
        ImageData image = ceVar.getImage();
        if (image != null && image.getData() != null) {
            this.n = image.getWidth();
            int height = image.getHeight();
            this.m = height;
            if (this.n == 0 || height == 0) {
                this.n = image.getData().getWidth();
                this.m = image.getData().getHeight();
            }
            this.a.setImageBitmap(image.getData());
            this.a.setClickable(false);
        }
    }

    public void destroy() {
        is isVar = this.j;
        if (isVar != null) {
            isVar.destroy();
        }
        this.j = null;
    }

    public void ej() {
        this.a.setVisibility(8);
        this.h.setVisibility(8);
    }

    public void el() {
        this.a.setOnClickListener(this.e);
        this.d.setOnClickListener(this.e);
        setOnClickListener(this.e);
    }

    @NonNull
    public FrameLayout getClickableLayout() {
        return this.g;
    }

    @Nullable
    public is getVideoPlayer() {
        return this.j;
    }

    public void initView() {
        io.a(this.d, "play_button");
        io.a(this.a, "media_image");
        io.a(this.f, "video_texture");
        this.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.a.setAdjustViewBounds(true);
        addView(this.f);
        this.h.setVisibility(8);
        addView(this.a);
        addView(this.h);
        addView(this.d);
        addView(this.g);
    }

    public boolean isPaused() {
        is isVar = this.j;
        return isVar != null && isVar.isPaused();
    }

    public boolean isPlaying() {
        is isVar = this.j;
        return isVar != null && isVar.isPlaying();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((i4 - i2) - measuredWidth) / 2;
                int i8 = ((i5 - i3) - measuredHeight) / 2;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int i5 = this.m;
        if (i5 == 0 || (i4 = this.n) == 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
            return;
        }
        if (mode2 == 0 && size2 == 0) {
            size2 = i5;
            size = i4;
            mode = Integer.MIN_VALUE;
            mode2 = Integer.MIN_VALUE;
        }
        if (size2 == 0 || mode2 == 0) {
            size2 = (int) ((((float) size) / ((float) i4)) * ((float) i5));
        }
        if (size == 0 || mode == 0) {
            size = (int) ((((float) size2) / ((float) i5)) * ((float) i4));
        }
        float f2 = ((float) i4) / ((float) i5);
        float f3 = ((float) size) / f2;
        float f4 = (float) size2;
        if (f3 > f4) {
            size = (int) (f2 * f4);
        } else {
            size2 = (int) f3;
        }
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int i7 = (childAt == this.a || childAt == this.g || childAt == this.f) ? 1073741824 : Integer.MIN_VALUE;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(size, i7), View.MeasureSpec.makeMeasureSpec(size2, i7));
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void pause() {
        is isVar = this.j;
        if (isVar != null) {
            isVar.pause();
            this.a.setVisibility(0);
            Bitmap screenShot = this.f.getScreenShot();
            if (screenShot != null && this.j.isStarted()) {
                this.a.setImageBitmap(screenShot);
            }
            if (this.p) {
                this.d.setVisibility(0);
            }
        }
    }

    public void resume() {
        is isVar = this.j;
        if (isVar != null) {
            if (this.k != null) {
                isVar.resume();
                this.a.setVisibility(8);
            }
            this.d.setVisibility(8);
        }
    }

    public void setInterstitialPromoViewListener(@Nullable a aVar) {
        this.l = aVar;
        is isVar = this.j;
        if (isVar != null) {
            isVar.a(aVar);
        }
    }
}

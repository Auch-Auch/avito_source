package com.my.target.ads;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.R;
import com.my.target.ab;
import com.my.target.ae;
import com.my.target.bj;
import com.my.target.cn;
import com.my.target.common.CustomParams;
import com.my.target.cu;
import com.my.target.fv;
import com.my.target.io;
import java.util.concurrent.atomic.AtomicBoolean;
public final class MyTargetView extends FrameLayout {
    @NonNull
    public final com.my.target.a a;
    @NonNull
    public final AtomicBoolean b;
    @Nullable
    public MyTargetViewListener c;
    @Nullable
    public bj d;
    @NonNull
    public AdSize e;
    public boolean f;
    public boolean g;

    public static final class AdSize {
        public static final AdSize ADSIZE_300x250 = new AdSize(300, 250, 1);
        public static final AdSize ADSIZE_320x50 = new AdSize(320, 50, 0);
        public static final AdSize ADSIZE_728x90 = new AdSize(728, 90, 2);
        public static final int BANNER_300x250 = 1;
        public static final int BANNER_320x50 = 0;
        public static final int BANNER_728x90 = 2;
        public static final int BANNER_ADAPTIVE = 3;
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public AdSize(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            float f = Resources.getSystem().getDisplayMetrics().density;
            this.c = (int) (((float) i) * f);
            this.d = (int) (((float) i2) * f);
            this.e = i3;
        }

        public AdSize(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        public static boolean a(AdSize adSize, AdSize adSize2) {
            return adSize.b == adSize2.b && adSize.a == adSize2.a && adSize.e == adSize2.e;
        }

        public static AdSize b(int i, Context context) {
            if (i == 1) {
                return ADSIZE_300x250;
            }
            if (i != 2) {
                return i != 3 ? ADSIZE_320x50 : getAdSizeForCurrentOrientation(context);
            }
            return ADSIZE_728x90;
        }

        @NonNull
        public static AdSize c(float f, float f2) {
            float f3 = Resources.getSystem().getDisplayMetrics().density;
            float max = Math.max(Math.min(f > 524.0f ? (f / 728.0f) * 90.0f : (f / 320.0f) * 50.0f, f2), 50.0f * f3);
            return new AdSize((int) (f / f3), (int) (max / f3), (int) f, (int) max, 3);
        }

        @NonNull
        public static AdSize getAdSizeForCurrentOrientation(int i, int i2, @NonNull Context context) {
            Point G = io.G(context);
            float f = Resources.getSystem().getDisplayMetrics().density;
            return c(((float) i) * f, Math.min(((float) i2) * f, ((float) G.y) * 0.15f));
        }

        @NonNull
        public static AdSize getAdSizeForCurrentOrientation(int i, @NonNull Context context) {
            return c(((float) i) * Resources.getSystem().getDisplayMetrics().density, ((float) io.G(context).y) * 0.15f);
        }

        @NonNull
        public static AdSize getAdSizeForCurrentOrientation(@NonNull Context context) {
            Point G = io.G(context);
            return c((float) G.x, ((float) G.y) * 0.15f);
        }

        public int getHeight() {
            return this.b;
        }

        public int getHeightPixels() {
            return this.d;
        }

        public int getType() {
            return this.e;
        }

        public int getWidth() {
            return this.a;
        }

        public int getWidthPixels() {
            return this.c;
        }
    }

    public interface MyTargetViewListener {
        void onClick(@NonNull MyTargetView myTargetView);

        void onLoad(@NonNull MyTargetView myTargetView);

        void onNoAd(@NonNull String str, @NonNull MyTargetView myTargetView);

        void onShow(@NonNull MyTargetView myTargetView);
    }

    public class a implements ab.a {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            MyTargetView.a(MyTargetView.this, (cu) cnVar, str);
        }
    }

    public class b implements ab.a {
        public b() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            MyTargetView.a(MyTargetView.this, (cu) cnVar, str);
        }
    }

    public MyTargetView(@NonNull Context context) {
        this(context, null);
    }

    public MyTargetView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyTargetView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new AtomicBoolean();
        this.f = false;
        ae.c("MyTargetView created. Version: 5.12.2");
        this.a = com.my.target.a.newConfig(0, "");
        this.e = AdSize.getAdSizeForCurrentOrientation(context);
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyTargetView);
            } catch (Throwable th) {
                a2.b.a.a.a.q1(th, a2.b.a.a.a.L("unable to get view attributes: "));
            }
            if (typedArray != null) {
                this.a.setSlotId(typedArray.getInt(R.styleable.MyTargetView_myTarget_slotId, 0));
                this.a.setRefreshAd(typedArray.getBoolean(R.styleable.MyTargetView_myTarget_isRefreshAd, true));
                int i2 = typedArray.getInt(R.styleable.MyTargetView_myTarget_adSize, -1);
                if (i2 >= 0) {
                    if (i2 != 3) {
                        this.f = true;
                    }
                    this.e = AdSize.b(i2, context);
                }
                typedArray.recycle();
            }
        }
    }

    public static void a(MyTargetView myTargetView, cu cuVar, String str) {
        MyTargetViewListener myTargetViewListener = myTargetView.c;
        if (myTargetViewListener != null) {
            if (cuVar == null) {
                if (str == null) {
                    str = "no ad";
                }
                myTargetViewListener.onNoAd(str, myTargetView);
                return;
            }
            bj bjVar = myTargetView.d;
            if (bjVar != null) {
                bjVar.destroy();
            }
            bj a3 = bj.a(myTargetView, myTargetView.a);
            myTargetView.d = a3;
            a3.j(myTargetView.g);
            myTargetView.d.a(cuVar);
            myTargetView.a.setBidId(null);
        }
    }

    public final void b() {
        com.my.target.a aVar;
        String str;
        AdSize adSize = this.e;
        if (adSize == AdSize.ADSIZE_320x50) {
            aVar = this.a;
            str = "standard_320x50";
        } else if (adSize == AdSize.ADSIZE_300x250) {
            aVar = this.a;
            str = "standard_300x250";
        } else if (adSize == AdSize.ADSIZE_728x90) {
            aVar = this.a;
            str = "standard_728x90";
        } else {
            aVar = this.a;
            str = "standard";
        }
        aVar.setFormat(str);
    }

    public void destroy() {
        bj bjVar = this.d;
        if (bjVar != null) {
            bjVar.destroy();
            this.d = null;
        }
        this.c = null;
    }

    @Nullable
    public String getAdSource() {
        bj bjVar = this.d;
        if (bjVar != null) {
            return bjVar.ad();
        }
        return null;
    }

    public float getAdSourcePriority() {
        bj bjVar = this.d;
        if (bjVar != null) {
            return bjVar.ae();
        }
        return 0.0f;
    }

    @NonNull
    public CustomParams getCustomParams() {
        return this.a.getCustomParams();
    }

    @Nullable
    public MyTargetViewListener getListener() {
        return this.c;
    }

    @NonNull
    public AdSize getSize() {
        return this.e;
    }

    public final void handleSection(@NonNull cu cuVar, @NonNull AdSize adSize) {
        ab.a(cuVar, this.a).a(new b()).a(getContext());
    }

    @Deprecated
    public void init(int i) {
        init(i, true);
    }

    @Deprecated
    public void init(int i, int i2) {
        init(i, i2, true);
    }

    @Deprecated
    public void init(int i, int i2, boolean z) {
        setAdSize(AdSize.b(i2, getContext()));
        this.a.setSlotId(i);
        this.a.setRefreshAd(z);
        ae.a("MyTargetView initialized");
    }

    @Deprecated
    public void init(int i, boolean z) {
        init(i, 0, z);
    }

    public boolean isMediationEnabled() {
        return this.a.isMediationEnabled();
    }

    public final void load() {
        if (!this.b.compareAndSet(false, true)) {
            ae.a("MyTargetView doesn't support multiple load");
            return;
        }
        ae.a("MyTargetView load");
        b();
        ab.a(this.a).a(new a()).a(getContext());
    }

    public void loadFromBid(@NonNull String str) {
        this.a.setBidId(str);
        this.a.setRefreshAd(false);
        load();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g = true;
        bj bjVar = this.d;
        if (bjVar != null) {
            bjVar.j(true);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
        bj bjVar = this.d;
        if (bjVar != null) {
            bjVar.j(false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.f) {
            Context context = getContext();
            Point G = io.G(context);
            int i3 = G.x;
            float f2 = (float) G.y;
            AdSize adSize = this.e;
            if (i3 != adSize.a || ((float) adSize.b) > f2 * 0.15f) {
                AdSize adSizeForCurrentOrientation = AdSize.getAdSizeForCurrentOrientation(context);
                this.e = adSizeForCurrentOrientation;
                bj bjVar = this.d;
                if (bjVar != null) {
                    bjVar.a(adSizeForCurrentOrientation);
                }
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        bj bjVar = this.d;
        if (bjVar != null) {
            bjVar.onWindowFocusChanged(z);
        }
    }

    public void setAdSize(@NonNull AdSize adSize) {
        if (adSize == null) {
            ae.a("AdSize cannot be null");
        } else if (!this.f || !AdSize.a(this.e, adSize)) {
            this.f = true;
            if (this.b.get()) {
                AdSize adSize2 = this.e;
                AdSize adSize3 = AdSize.ADSIZE_300x250;
                if (AdSize.a(adSize2, adSize3) || AdSize.a(adSize, adSize3)) {
                    ae.a("unable to switch size to/from 300x250");
                    return;
                }
            }
            bj bjVar = this.d;
            if (bjVar != null) {
                bjVar.a(adSize);
                View childAt = getChildAt(0);
                if (childAt instanceof fv) {
                    childAt.requestLayout();
                }
            }
            this.e = adSize;
            b();
        }
    }

    public void setListener(@Nullable MyTargetViewListener myTargetViewListener) {
        this.c = myTargetViewListener;
    }

    public void setMediationEnabled(boolean z) {
        this.a.setMediationEnabled(z);
    }

    public void setRefreshAd(boolean z) {
        this.a.setRefreshAd(z);
    }

    public void setSlotId(int i) {
        this.a.setSlotId(i);
    }
}

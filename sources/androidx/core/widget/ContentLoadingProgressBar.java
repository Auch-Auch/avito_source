package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class ContentLoadingProgressBar extends ProgressBar {
    public long a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final Runnable e;
    public final Runnable f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.b = false;
            contentLoadingProgressBar.a = -1;
            contentLoadingProgressBar.setVisibility(8);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentLoadingProgressBar contentLoadingProgressBar = ContentLoadingProgressBar.this;
            contentLoadingProgressBar.c = false;
            if (!contentLoadingProgressBar.d) {
                contentLoadingProgressBar.a = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    }

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public synchronized void hide() {
        this.d = true;
        removeCallbacks(this.f);
        this.c = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.a;
        long j2 = currentTimeMillis - j;
        if (j2 < 500) {
            if (j != -1) {
                if (!this.b) {
                    postDelayed(this.e, 500 - j2);
                    this.b = true;
                }
            }
        }
        setVisibility(8);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    public synchronized void show() {
        this.a = -1;
        this.d = false;
        removeCallbacks(this.e);
        this.b = false;
        if (!this.c) {
            postDelayed(this.f, 500);
            this.c = true;
        }
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.a = -1;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new a();
        this.f = new b();
    }
}

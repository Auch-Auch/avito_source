package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.R;
import java.lang.ref.WeakReference;
@AutoHandleExceptions
public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    public final String a;
    public final WeakReference<View> b;
    public final Context c;
    public d d;
    public PopupWindow e;
    public Style f = Style.BLUE;
    public long g = DEFAULT_POPUP_DISPLAY_TIME;
    public final ViewTreeObserver.OnScrollChangedListener h = new a();

    public enum Style {
        BLUE,
        BLACK
    }

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            PopupWindow popupWindow;
            if (ToolTipPopup.this.b.get() != null && (popupWindow = ToolTipPopup.this.e) != null && popupWindow.isShowing()) {
                if (ToolTipPopup.this.e.isAboveAnchor()) {
                    d dVar = ToolTipPopup.this.d;
                    dVar.a.setVisibility(4);
                    dVar.b.setVisibility(0);
                    return;
                }
                d dVar2 = ToolTipPopup.this.d;
                dVar2.a.setVisibility(0);
                dVar2.b.setVisibility(4);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToolTipPopup.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ToolTipPopup.this.dismiss();
        }
    }

    public class d extends FrameLayout {
        public ImageView a = ((ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer));
        public ImageView b = ((ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer));
        public View c = findViewById(R.id.com_facebook_body_frame);
        public ImageView d = ((ImageView) findViewById(R.id.com_facebook_button_xout));

        public d(ToolTipPopup toolTipPopup, Context context) {
            super(context);
            LayoutInflater.from(getContext()).inflate(R.layout.com_facebook_tooltip_bubble, this);
        }
    }

    public ToolTipPopup(String str, View view) {
        this.a = str;
        this.b = new WeakReference<>(view);
        this.c = view.getContext();
    }

    public final void a() {
        if (this.b.get() != null) {
            this.b.get().getViewTreeObserver().removeOnScrollChangedListener(this.h);
        }
    }

    public void dismiss() {
        a();
        PopupWindow popupWindow = this.e;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void setNuxDisplayTime(long j) {
        this.g = j;
    }

    public void setStyle(Style style) {
        this.f = style;
    }

    public void show() {
        if (this.b.get() != null) {
            d dVar = new d(this, this.c);
            this.d = dVar;
            ((TextView) dVar.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body)).setText(this.a);
            if (this.f == Style.BLUE) {
                this.d.c.setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
                this.d.b.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                this.d.a.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                this.d.d.setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
            } else {
                this.d.c.setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
                this.d.b.setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
                this.d.a.setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
                this.d.d.setImageResource(R.drawable.com_facebook_tooltip_black_xout);
            }
            View decorView = ((Activity) this.c).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            a();
            if (this.b.get() != null) {
                this.b.get().getViewTreeObserver().addOnScrollChangedListener(this.h);
            }
            this.d.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            d dVar2 = this.d;
            PopupWindow popupWindow = new PopupWindow(dVar2, dVar2.getMeasuredWidth(), this.d.getMeasuredHeight());
            this.e = popupWindow;
            popupWindow.showAsDropDown(this.b.get());
            PopupWindow popupWindow2 = this.e;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                if (this.e.isAboveAnchor()) {
                    d dVar3 = this.d;
                    dVar3.a.setVisibility(4);
                    dVar3.b.setVisibility(0);
                } else {
                    d dVar4 = this.d;
                    dVar4.a.setVisibility(0);
                    dVar4.b.setVisibility(4);
                }
            }
            long j = this.g;
            if (j > 0) {
                this.d.postDelayed(new b(), j);
            }
            this.e.setTouchable(true);
            this.d.setOnClickListener(new c());
        }
    }
}

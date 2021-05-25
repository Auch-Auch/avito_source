package com.my.target;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.my.target.bo;
import java.util.List;
public class fn extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public final int a;
    public final int b;
    @NonNull
    public final View iA;
    @NonNull
    public final ImageButton iz;
    @NonNull
    public final ListView listView;

    public interface a {
        void a(@NonNull bo.a aVar, @NonNull Context context);

        void p();
    }

    public static class b implements View.OnClickListener {
        @NonNull
        public final a a;

        public b(@NonNull a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.p();
        }
    }

    public static class c implements AdapterView.OnItemClickListener {
        @NonNull
        public final a a;
        @NonNull
        public final List<bo.a> b;

        public c(@NonNull a aVar, @NonNull List<bo.a> list) {
            this.a = aVar;
            this.b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 0 && i < this.b.size()) {
                this.a.a(this.b.get(i), view.getContext());
            }
        }
    }

    public static class d extends BaseAdapter {
        @NonNull
        public final List<bo.a> a;

        public d(@NonNull List<bo.a> list) {
            this.a = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Button button = new Button(viewGroup.getContext());
            button.setFocusable(false);
            button.setFocusableInTouchMode(false);
            button.setClickable(false);
            io af = io.af(viewGroup.getContext());
            int L = af.L(24);
            button.setPadding(L, button.getPaddingTop(), L, button.getPaddingBottom());
            button.setAllCaps(false);
            button.setStateListAnimator(null);
            button.setLines(1);
            button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            button.setEllipsize(TextUtils.TruncateAt.END);
            button.setTypeface(null, 0);
            button.setGravity(8388627);
            button.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            boolean z = i == 0;
            int i2 = fn.c;
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-3158065, -3158065});
            if (z) {
                float L2 = (float) af.L(8);
                float[] fArr = {L2, L2, L2, L2, 0.0f, 0.0f, 0.0f, 0.0f};
                gradientDrawable.setCornerRadii(fArr);
                gradientDrawable2.setCornerRadii(fArr);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
            stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
            button.setBackground(new RippleDrawable(new ColorStateList(new int[][]{new int[]{16842919}, StateSet.WILD_CARD}, new int[]{io.K(-3158065), io.K(-1)}), stateListDrawable, null));
            if (i >= 0 && i < this.a.size()) {
                button.setText(this.a.get(i).name);
            }
            return button;
        }
    }

    public fn(@NonNull Context context) {
        super(context);
        ListView listView2 = new ListView(context);
        this.listView = listView2;
        io af = io.af(context);
        this.a = af.L(500);
        this.b = af.o(0.5f);
        ImageButton imageButton = new ImageButton(context);
        this.iz = imageButton;
        imageButton.setImageBitmap(fh.Q(context));
        io.a(imageButton, -1, -3158065);
        View view = new View(context);
        this.iA = view;
        view.setBackgroundColor(-5131855);
        addView(listView2);
        addView(view);
        addView(imageButton);
    }

    public void a(@Nullable List<bo.a> list, @NonNull a aVar) {
        if (list != null) {
            this.listView.setAdapter((ListAdapter) new d(list));
            this.listView.setOnItemClickListener(new c(aVar, list));
            b bVar = new b(aVar);
            this.iz.setOnClickListener(bVar);
            setOnClickListener(bVar);
        }
    }

    public void dR() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 512.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        this.listView.startAnimation(translateAnimation);
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max = Math.max((i3 - this.listView.getMeasuredWidth()) / 2, getPaddingLeft());
        this.iz.layout(max, (i4 - getPaddingBottom()) - this.iz.getMeasuredHeight(), this.iz.getMeasuredWidth() + max, i4 - getPaddingBottom());
        this.iA.layout(max, this.iz.getTop() - this.iA.getMeasuredHeight(), this.iA.getMeasuredWidth() + max, this.iz.getTop());
        this.listView.layout(max, this.iA.getTop() - this.listView.getMeasuredHeight(), this.listView.getMeasuredWidth() + max, this.iA.getTop());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int min = (Math.min(size, this.a) - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        this.iz.measure(makeMeasureSpec, paddingTop);
        this.iA.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
        this.listView.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec((paddingTop - this.b) - this.iz.getMeasuredHeight(), Integer.MIN_VALUE));
        setMeasuredDimension(size, size2);
    }
}

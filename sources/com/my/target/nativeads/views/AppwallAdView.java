package com.my.target.nativeads.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.io;
import com.my.target.nativeads.NativeAppwallAd;
import com.my.target.nativeads.banners.NativeAppwallBanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class AppwallAdView extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    @NonNull
    public final ListView a;
    @NonNull
    public final io b;
    @NonNull
    public final HashMap<NativeAppwallBanner, Boolean> c = new HashMap<>();
    @Nullable
    public AppwallAdViewListener d;

    public interface AppwallAdViewListener {
        void onBannerClick(@NonNull NativeAppwallBanner nativeAppwallBanner);

        void onBannersShow(@NonNull List<NativeAppwallBanner> list);
    }

    public static class AppwallAdapter extends ArrayAdapter<NativeAppwallBanner> {
        public AppwallAdapter(@NonNull Context context, @NonNull List<NativeAppwallBanner> list) {
            super(context, 0, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i, View view, @NonNull ViewGroup viewGroup) {
            NativeAppwallBanner nativeAppwallBanner = (NativeAppwallBanner) getItem(i);
            if (view == null) {
                view = new AppwallCardPlaceholder(new AppwallAdTeaserView(getContext()), getContext());
            }
            if (nativeAppwallBanner != null) {
                ((AppwallCardPlaceholder) view).getView().setNativeAppwallBanner(nativeAppwallBanner);
            }
            return view;
        }
    }

    @SuppressLint({"ViewConstructor"})
    public static class AppwallCardPlaceholder extends FrameLayout {
        @NonNull
        public final AppwallAdTeaserView a;
        @NonNull
        public final LinearLayout b;

        public AppwallCardPlaceholder(@NonNull AppwallAdTeaserView appwallAdTeaserView, Context context) {
            super(context);
            io af = io.af(context);
            this.a = appwallAdTeaserView;
            int L = af.L(9);
            int L2 = af.L(4);
            int L3 = af.L(2);
            LinearLayout linearLayout = new LinearLayout(context);
            this.b = linearLayout;
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(L, L2, L, L2);
            appwallAdTeaserView.setLayoutParams(layoutParams);
            linearLayout.addView(appwallAdTeaserView);
            appwallAdTeaserView.setElevation((float) L3);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{MediaAdView.COLOR_PLACEHOLDER_GRAY, MediaAdView.COLOR_PLACEHOLDER_GRAY});
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
            stateListDrawable.addState(StateSet.WILD_CARD, gradientDrawable);
            appwallAdTeaserView.setBackground(stateListDrawable);
            addView(linearLayout, -2, -2);
        }

        @NonNull
        public AppwallAdTeaserView getView() {
            return this.a;
        }
    }

    public AppwallAdView(@NonNull Context context) {
        super(context);
        setVerticalFadingEdgeEnabled(false);
        setBackgroundColor(-1);
        io af = io.af(context);
        this.b = af;
        ListView listView = new ListView(context);
        this.a = listView;
        int L = af.L(4);
        int L2 = af.L(4);
        listView.setDividerHeight(0);
        listView.setVerticalFadingEdgeEnabled(false);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
        listView.setPadding(0, L, 0, L2);
        listView.setClipToPadding(false);
        addView(listView, -1, -1);
        listView.setBackgroundColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
    }

    public final void a() {
        AppwallAdViewListener appwallAdViewListener;
        if (this.a.getAdapter() != null) {
            int lastVisiblePosition = this.a.getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            for (int firstVisiblePosition = this.a.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                NativeAppwallBanner nativeAppwallBanner = (NativeAppwallBanner) this.a.getAdapter().getItem(firstVisiblePosition);
                if (this.c.get(nativeAppwallBanner) == null) {
                    arrayList.add(nativeAppwallBanner);
                    this.c.put(nativeAppwallBanner, Boolean.TRUE);
                }
            }
            if (arrayList.size() > 0 && (appwallAdViewListener = this.d) != null) {
                appwallAdViewListener.onBannersShow(arrayList);
            }
        }
    }

    public void notifyDataSetChanged() {
        ((AppwallAdapter) this.a.getAdapter()).notifyDataSetChanged();
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NativeAppwallBanner nativeAppwallBanner = (NativeAppwallBanner) this.a.getAdapter().getItem(i);
        AppwallAdViewListener appwallAdViewListener = this.d;
        if (appwallAdViewListener != null) {
            appwallAdViewListener.onBannerClick(nativeAppwallBanner);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        a();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void setAppwallAdViewListener(@Nullable AppwallAdViewListener appwallAdViewListener) {
        this.d = appwallAdViewListener;
    }

    public void setupView(@NonNull NativeAppwallAd nativeAppwallAd) {
        this.a.setAdapter((ListAdapter) new AppwallAdapter(getContext(), nativeAppwallAd.getBanners()));
    }
}

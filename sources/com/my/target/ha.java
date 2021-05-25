package com.my.target;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.my.target.common.models.ImageData;
import com.my.target.common.views.StarsRatingView;
import com.my.target.gz;
import com.my.target.hb;
import java.util.ArrayList;
import java.util.List;
public class ha extends RecyclerView {
    public final View.OnClickListener E0;
    @NonNull
    public final gz F0;
    @NonNull
    public final View.OnClickListener G0;
    @NonNull
    public final LinearSnapHelper H0;
    @Nullable
    public List<cb> I0;
    @Nullable
    public hb.a J0;
    public boolean K0;
    public boolean L0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View findContainingItemView;
            ha haVar;
            hb.a aVar;
            List<cb> list;
            ha haVar2 = ha.this;
            if (!haVar2.K0 && (findContainingItemView = haVar2.getCardLayoutManager().findContainingItemView(view)) != null) {
                gz cardLayoutManager = ha.this.getCardLayoutManager();
                int findFirstCompletelyVisibleItemPosition = cardLayoutManager.findFirstCompletelyVisibleItemPosition();
                int position = cardLayoutManager.getPosition(findContainingItemView);
                if (!(findFirstCompletelyVisibleItemPosition <= position && position <= cardLayoutManager.findLastCompletelyVisibleItemPosition())) {
                    ha haVar3 = ha.this;
                    if (!haVar3.L0) {
                        haVar3.g(findContainingItemView);
                        return;
                    }
                }
                if (view.isClickable() && (aVar = (haVar = ha.this).J0) != null && (list = haVar.I0) != null) {
                    aVar.a(list.get(haVar.getCardLayoutManager().getPosition(findContainingItemView)));
                }
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<cb> list;
            ViewParent parent = view.getParent();
            while (parent != null && !(parent instanceof gy)) {
                parent = parent.getParent();
            }
            ha haVar = ha.this;
            hb.a aVar = haVar.J0;
            if (aVar != null && (list = haVar.I0) != null && parent != null) {
                aVar.a(list.get(haVar.getCardLayoutManager().getPosition((View) parent)));
            }
        }
    }

    public class c implements gz.a {
        public c() {
        }

        @Override // com.my.target.gz.a
        public void ei() {
            ha.b0(ha.this);
        }
    }

    public static class d extends RecyclerView.Adapter<e> {
        @NonNull
        public final Context c;
        @NonNull
        public final List<cb> d;
        @NonNull
        public final List<cb> e = new ArrayList();
        public final boolean f;
        @Nullable
        public View.OnClickListener g;
        public View.OnClickListener h;

        public d(@NonNull List<cb> list, @NonNull Context context) {
            this.d = list;
            this.c = context;
            this.f = (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            return i == getItemCount() - 1 ? 2 : 0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull e eVar, int i) {
            e eVar2 = eVar;
            gy gyVar = eVar2.s;
            cb cbVar = this.d.get(i);
            if (!this.e.contains(cbVar)) {
                this.e.add(cbVar);
                im.a(cbVar.getStatHolder().K("render"), eVar2.itemView.getContext());
            }
            ImageData image = cbVar.getImage();
            if (image != null) {
                gc smartImageView = gyVar.getSmartImageView();
                smartImageView.setPlaceholderDimensions(image.getWidth(), image.getHeight());
                ia.a(image, smartImageView);
            }
            gyVar.getTitleTextView().setText(cbVar.getTitle());
            gyVar.getDescriptionTextView().setText(cbVar.getDescription());
            gyVar.getCtaButtonView().setText(cbVar.getCtaText());
            TextView domainTextView = gyVar.getDomainTextView();
            String domain = cbVar.getDomain();
            StarsRatingView ratingView = gyVar.getRatingView();
            if ("web".equals(cbVar.getNavigationType())) {
                ratingView.setVisibility(8);
                domainTextView.setVisibility(0);
                domainTextView.setText(domain);
            } else {
                domainTextView.setVisibility(8);
                float rating = cbVar.getRating();
                if (rating > 0.0f) {
                    ratingView.setVisibility(0);
                    ratingView.setRating(rating);
                } else {
                    ratingView.setVisibility(8);
                }
            }
            gyVar.a(this.g, cbVar.getClickArea());
            gyVar.getCtaButtonView().setOnClickListener(this.h);
        }

        /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new e(new gy(this.f, this.c));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(@NonNull e eVar) {
            gy gyVar = eVar.s;
            gyVar.a(null, null);
            gyVar.getCtaButtonView().setOnClickListener(null);
        }
    }

    public static class e extends RecyclerView.ViewHolder {
        public final gy s;

        public e(gy gyVar) {
            super(gyVar);
            this.s = gyVar;
        }
    }

    public ha(Context context) {
        this(context, null);
    }

    public ha(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ha(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E0 = new a();
        this.G0 = new b();
        setOverScrollMode(2);
        this.F0 = new gz(context);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.H0 = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this);
    }

    public static void b0(ha haVar) {
        hb.a aVar = haVar.J0;
        if (aVar != null) {
            aVar.d(haVar.getVisibleCards());
        }
    }

    @NonNull
    private List<cb> getVisibleCards() {
        int findFirstCompletelyVisibleItemPosition;
        int findLastCompletelyVisibleItemPosition;
        ArrayList arrayList = new ArrayList();
        if (this.I0 != null && (findFirstCompletelyVisibleItemPosition = getCardLayoutManager().findFirstCompletelyVisibleItemPosition()) <= (findLastCompletelyVisibleItemPosition = getCardLayoutManager().findLastCompletelyVisibleItemPosition()) && findFirstCompletelyVisibleItemPosition >= 0 && findLastCompletelyVisibleItemPosition < this.I0.size()) {
            while (findFirstCompletelyVisibleItemPosition <= findLastCompletelyVisibleItemPosition) {
                arrayList.add(this.I0.get(findFirstCompletelyVisibleItemPosition));
                findFirstCompletelyVisibleItemPosition++;
            }
        }
        return arrayList;
    }

    private void setCardLayoutManager(@NonNull gz gzVar) {
        gzVar.K = new c();
        super.setLayoutManager(gzVar);
    }

    public void K(boolean z) {
        if (z) {
            this.H0.attachToRecyclerView(this);
        } else {
            this.H0.attachToRecyclerView(null);
        }
    }

    public void e(List<cb> list) {
        d dVar = new d(list, getContext());
        this.I0 = list;
        dVar.g = this.E0;
        dVar.h = this.G0;
        setCardLayoutManager(this.F0);
        setAdapter(dVar);
    }

    public void g(@NonNull View view) {
        int[] calculateDistanceToFinalSnap = this.H0.calculateDistanceToFinalSnap(getCardLayoutManager(), view);
        if (calculateDistanceToFinalSnap != null) {
            smoothScrollBy(calculateDistanceToFinalSnap[0], 0);
        }
    }

    @VisibleForTesting(otherwise = 3)
    public gz getCardLayoutManager() {
        return this.F0;
    }

    @NonNull
    @VisibleForTesting
    public LinearSnapHelper getSnapHelper() {
        return this.H0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (i3 > i4) {
            this.L0 = true;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        hb.a aVar;
        super.onScrollStateChanged(i);
        boolean z = i != 0;
        this.K0 = z;
        if (!z && (aVar = this.J0) != null) {
            aVar.d(getVisibleCards());
        }
    }

    public void setCarouselListener(@Nullable hb.a aVar) {
        this.J0 = aVar;
    }

    public void setSideSlidesMargins(int i) {
        getCardLayoutManager().J = i;
    }
}

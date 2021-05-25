package com.my.target.nativeads.views;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.my.target.ae;
import com.my.target.common.models.ImageData;
import com.my.target.gc;
import com.my.target.gj;
import com.my.target.gn;
import com.my.target.ia;
import com.my.target.iq;
import com.my.target.nativeads.banners.NativePromoCard;
import java.util.ArrayList;
import java.util.List;
public class PromoCardRecyclerView extends RecyclerView implements gn {
    public static final float MIN_CARD_VISIBILITY = 50.0f;
    @NonNull
    public final gj E0 = new gj(getContext());
    @NonNull
    public final b F0 = new a();
    @NonNull
    public final PagerSnapHelper G0;
    @Nullable
    public gn.a H0;
    public boolean I0;
    public int J0 = -1;
    @Nullable
    public PromoCardAdapter K0;

    public static abstract class PromoCardAdapter extends RecyclerView.Adapter<c> {
        @NonNull
        public final List<NativePromoCard> c = new ArrayList();
        @Nullable
        public b d;

        public void dispose() {
            this.d = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.c.size();
        }

        @NonNull
        public List<NativePromoCard> getNativePromoCards() {
            return this.c;
        }

        @NonNull
        public abstract PromoCardView getPromoCardView();

        public void onBindViewHolder(@NonNull c cVar, int i) {
            NativePromoCard nativePromoCard;
            PromoCardRecyclerView promoCardRecyclerView;
            gn.a aVar;
            if (i < this.c.size() && (nativePromoCard = this.c.get(i)) != null) {
                PromoCardView promoCardView = cVar.s;
                if (nativePromoCard.getImage() != null) {
                    promoCardView.getMediaAdView().setPlaceHolderDimension(nativePromoCard.getImage().getWidth(), nativePromoCard.getImage().getHeight());
                    if (nativePromoCard.getImage().getData() != null) {
                        promoCardView.getMediaAdView().getImageView().setImageBitmap(nativePromoCard.getImage().getData());
                    } else {
                        ia.a(nativePromoCard.getImage(), promoCardView.getMediaAdView().getImageView());
                    }
                }
                promoCardView.getTitleTextView().setText(nativePromoCard.getTitle());
                promoCardView.getDescriptionTextView().setText(nativePromoCard.getDescription());
                String ctaText = nativePromoCard.getCtaText();
                promoCardView.getCtaButtonView().setText(ctaText);
                promoCardView.getCtaButtonView().setContentDescription(ctaText);
                b bVar = this.d;
                if (!(bVar == null || (aVar = (promoCardRecyclerView = PromoCardRecyclerView.this).H0) == null)) {
                    aVar.b(i, promoCardRecyclerView.getContext());
                }
            }
            View view = cVar.s.getView();
            view.setContentDescription("card_" + i);
            cVar.s.getView().setOnClickListener(this.d);
            cVar.s.getCtaButtonView().setOnClickListener(this.d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new c(getPromoCardView());
        }

        public void onViewRecycled(@NonNull c cVar) {
            NativePromoCard nativePromoCard;
            ImageData image;
            int layoutPosition = cVar.getLayoutPosition();
            gc gcVar = (gc) cVar.s.getMediaAdView().getImageView();
            gcVar.setImageData(null);
            if (layoutPosition > 0 && layoutPosition < this.c.size() && (nativePromoCard = this.c.get(layoutPosition)) != null && (image = nativePromoCard.getImage()) != null) {
                ia.b(image, gcVar);
            }
            cVar.s.getView().setOnClickListener(null);
            cVar.s.getCtaButtonView().setOnClickListener(null);
            super.onViewRecycled((PromoCardAdapter) cVar);
        }

        public void setCards(@NonNull List<NativePromoCard> list) {
            this.c.clear();
            this.c.addAll(list);
            notifyDataSetChanged();
        }

        public void setClickListener(@Nullable b bVar) {
            this.d = bVar;
        }
    }

    public class a implements b {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View findContainingItemView;
            PromoCardRecyclerView promoCardRecyclerView = PromoCardRecyclerView.this;
            if (promoCardRecyclerView.I0 || (findContainingItemView = promoCardRecyclerView.E0.findContainingItemView(view)) == null) {
                return;
            }
            if (promoCardRecyclerView.E0.f(findContainingItemView)) {
                int position = promoCardRecyclerView.E0.getPosition(findContainingItemView);
                gn.a aVar = promoCardRecyclerView.H0;
                if (aVar != null && position >= 0) {
                    aVar.b(findContainingItemView, position);
                    return;
                }
                return;
            }
            int[] calculateDistanceToFinalSnap = promoCardRecyclerView.G0.calculateDistanceToFinalSnap(promoCardRecyclerView.E0, findContainingItemView);
            if (calculateDistanceToFinalSnap != null) {
                promoCardRecyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], 0);
            }
        }
    }

    public interface b extends View.OnClickListener {
    }

    public static class c extends RecyclerView.ViewHolder {
        @NonNull
        public final PromoCardView s;

        public c(@NonNull PromoCardView promoCardView) {
            super(promoCardView.getView());
            promoCardView.getView().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            this.s = promoCardView;
        }
    }

    public PromoCardRecyclerView(Context context) {
        super(context);
        setHasFixedSize(true);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.G0 = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this);
    }

    public PromoCardRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setHasFixedSize(true);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.G0 = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this);
    }

    public PromoCardRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setHasFixedSize(true);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        this.G0 = pagerSnapHelper;
        pagerSnapHelper.attachToRecyclerView(this);
    }

    @Override // com.my.target.gn
    public void dispose() {
        PromoCardAdapter promoCardAdapter = this.K0;
        if (promoCardAdapter != null) {
            promoCardAdapter.dispose();
        }
    }

    @Override // com.my.target.gn
    @Nullable
    public Parcelable getState() {
        return this.E0.onSaveInstanceState();
    }

    @Override // com.my.target.gn
    @NonNull
    public int[] getVisibleCardNumbers() {
        int findFirstVisibleItemPosition = this.E0.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.E0.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
            return new int[0];
        }
        if (iq.l(this.E0.findViewByPosition(findFirstVisibleItemPosition)) < 50.0d) {
            findFirstVisibleItemPosition++;
        }
        if (iq.l(this.E0.findViewByPosition(findLastVisibleItemPosition)) < 50.0d) {
            findLastVisibleItemPosition--;
        }
        if (findFirstVisibleItemPosition > findLastVisibleItemPosition) {
            return new int[0];
        }
        if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
            return new int[]{findFirstVisibleItemPosition};
        }
        int i = (findLastVisibleItemPosition - findFirstVisibleItemPosition) + 1;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = findFirstVisibleItemPosition;
            findFirstVisibleItemPosition++;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        int findFirstCompletelyVisibleItemPosition;
        super.onScrollStateChanged(i);
        boolean z = i != 0;
        this.I0 = z;
        if (!z && (findFirstCompletelyVisibleItemPosition = this.E0.findFirstCompletelyVisibleItemPosition()) >= 0 && this.J0 != findFirstCompletelyVisibleItemPosition) {
            this.J0 = findFirstCompletelyVisibleItemPosition;
            if (this.H0 != null && this.E0.findViewByPosition(findFirstCompletelyVisibleItemPosition) != null) {
                this.H0.b(new int[]{this.J0}, getContext());
            }
        }
    }

    @Override // com.my.target.gn
    public void restoreState(@NonNull Parcelable parcelable) {
        this.E0.onRestoreInstanceState(parcelable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof PromoCardAdapter) {
            setPromoCardAdapter((PromoCardAdapter) adapter);
        } else {
            ae.a("You must use setPromoCardAdapter(PromoCardAdapter) method with custom CardRecyclerView");
        }
    }

    public void setPromoCardAdapter(@Nullable PromoCardAdapter promoCardAdapter) {
        if (promoCardAdapter != null) {
            this.K0 = promoCardAdapter;
            promoCardAdapter.setClickListener(this.F0);
            setLayoutManager(this.E0);
            super.swapAdapter(this.K0, true);
        }
    }

    @Override // com.my.target.gn
    public void setPromoCardSliderListener(@Nullable gn.a aVar) {
        this.H0 = aVar;
    }
}

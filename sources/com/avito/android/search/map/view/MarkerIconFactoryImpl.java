package com.avito.android.search.map.view;

import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.map.Form;
import com.avito.android.search.map.R;
import com.avito.android.search.map.view.MarkerItem;
import com.avito.android.search.map.view.marker.MarkerPinView;
import com.avito.android.search.map.view.marker.MarkerPinWithPriceView;
import com.avito.android.search.map.view.marker.MarkerRashViewImpl;
import com.avito.android.search.map.view.marker.MarkerSpecialPinViewImpl;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0004\b\r\u000f\u0012B\u0011\b\u0007\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u0004*\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R2\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0004`\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010&\u001a\n #*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010+¨\u00061"}, d2 = {"Lcom/avito/android/search/map/view/MarkerIconFactoryImpl;", "Lcom/avito/android/search/map/view/MarkerIconFactory;", "Lcom/avito/android/search/map/view/MarkerItem;", "item", "Landroid/graphics/Bitmap;", "getIcon", "(Lcom/avito/android/search/map/view/MarkerItem;)Landroid/graphics/Bitmap;", "Lcom/avito/android/search/map/view/PartialMarker;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/search/map/view/PartialMarker;)Landroid/graphics/Bitmap;", "", "layout", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "(I)Landroid/view/View;", "c", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$b;", "d", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$b;", "pinWithPriceView", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", g.a, "Ljava/util/HashMap;", "markerCache", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$d;", "e", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$d;", "specialPin", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "f", "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$a;", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$a;", "pinView", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$c;", "Lcom/avito/android/search/map/view/MarkerIconFactoryImpl$c;", "rashView", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MarkerIconFactoryImpl implements MarkerIconFactory {
    public final Context a;
    public a b;
    public c c;
    public b d;
    public d e;
    public final LayoutInflater f;
    public final HashMap<String, Bitmap> g = new HashMap<>();

    public static final class a {
        public final MarkerPinView a;
        @NotNull
        public final View b;

        public a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = view;
            this.a = (MarkerPinView) view;
        }
    }

    public static final class b {
        public final MarkerPinWithPriceView a;
        @NotNull
        public final View b;

        public b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = view;
            this.a = (MarkerPinWithPriceView) view;
        }
    }

    public static final class c {
        public final MarkerRashViewImpl a;
        @NotNull
        public final View b;

        public c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = view;
            this.a = (MarkerRashViewImpl) view;
        }
    }

    public static final class d {
        public final MarkerSpecialPinViewImpl a;
        @NotNull
        public final View b;

        public d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.b = view;
            this.a = (MarkerSpecialPinViewImpl) view;
        }
    }

    @Inject
    public MarkerIconFactoryImpl(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.f = LayoutInflater.from(activity);
    }

    public final Bitmap a(PartialMarker partialMarker) {
        String str;
        if (partialMarker instanceof MarkerWithPrice) {
            str = a2.b.a.a.a.H(new Object[]{Integer.valueOf(partialMarker.getCount()), Boolean.valueOf(partialMarker.getSelected()), Boolean.valueOf(partialMarker.isViewed()), ((MarkerWithPrice) partialMarker).getPrice(), Boolean.valueOf(partialMarker.isFavorite()), partialMarker.getHighlight(), partialMarker.getForm()}, 7, "%s%s%s%s%s%s%s", "java.lang.String.format(this, *args)");
        } else {
            str = a2.b.a.a.a.H(new Object[]{Integer.valueOf(partialMarker.getCount()), Boolean.valueOf(partialMarker.getSelected()), Boolean.valueOf(partialMarker.isViewed()), Boolean.valueOf(partialMarker.isFavorite()), partialMarker.getHighlight(), partialMarker.getForm()}, 6, MarkerIconFactoryKt.SELECTED_RASH_KEY, "java.lang.String.format(this, *args)");
        }
        Bitmap bitmap = this.g.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        a aVar = this.b;
        if (aVar == null) {
            aVar = new a(b(R.layout.search_map_pin_marker));
            this.b = aVar;
        }
        Intrinsics.checkNotNullParameter(partialMarker, "item");
        aVar.a.setTextAndFavorite(partialMarker);
        Intrinsics.checkNotNullParameter(partialMarker, "item");
        aVar.a.setPinView(partialMarker);
        Bitmap c2 = c(aVar.b);
        this.g.put(str, c2);
        return c2;
    }

    public final View b(@LayoutRes int i) {
        View inflate = this.f.inflate(i, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "it");
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(layout,…s.WRAP_CONTENT)\n        }");
        return inflate;
    }

    public final Bitmap c(View view) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(makeMeasureSpec, makeMeasureSpec);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        view.draw(new Canvas(createBitmap));
        Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(meas…raw(Canvas(it))\n        }");
        return createBitmap;
    }

    @Override // com.avito.android.search.map.view.MarkerIconFactory
    @Nullable
    public Bitmap getIcon(@NotNull MarkerItem markerItem) {
        Bitmap bitmap;
        Bitmap c2;
        Intrinsics.checkNotNullParameter(markerItem, "item");
        if (markerItem instanceof MarkerItem.MyLocation) {
            Drawable drawable = this.a.getDrawable(com.avito.android.util.map.R.drawable.ic_explore_item_map_my_pin_red);
            if (drawable == null) {
                return null;
            }
            c2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(c2);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        } else {
            if (markerItem instanceof MarkerItem.Rash) {
                MarkerItem.Rash rash = (MarkerItem.Rash) markerItem;
                if (rash.getSelected()) {
                    return a((PartialMarker) markerItem);
                }
                String H = a2.b.a.a.a.H(new Object[]{Integer.valueOf(rash.getCount()), Boolean.valueOf(rash.getSelected()), Boolean.valueOf(rash.isViewed()), Boolean.valueOf(rash.isFavorite()), rash.getHighlight(), rash.getForm()}, 6, "%s%s%s%s%s%s", "java.lang.String.format(this, *args)");
                bitmap = this.g.get(H);
                if (bitmap == null) {
                    c cVar = this.c;
                    if (cVar == null) {
                        cVar = new c(b(R.layout.search_map_rash_marker));
                        this.c = cVar;
                    }
                    Intrinsics.checkNotNullParameter(rash, "item");
                    cVar.a.setStyleByItemParams(rash);
                    c2 = c(cVar.b);
                    this.g.put(H, c2);
                }
            } else if (markerItem instanceof MarkerItem.Pin) {
                MarkerItem.Pin pin = (MarkerItem.Pin) markerItem;
                if (pin.getPrice() == null || pin.getForm() != Form.Priced) {
                    return a((PartialMarker) markerItem);
                }
                b bVar = this.d;
                if (bVar == null) {
                    bVar = new b(b(R.layout.search_map_with_price_pin_marker));
                    this.d = bVar;
                }
                Intrinsics.checkNotNullParameter(pin, "item");
                bVar.a.setTextAndFavorite(pin);
                Intrinsics.checkNotNullParameter(pin, "item");
                bVar.a.setView(pin);
                return c(bVar.b);
            } else if (markerItem instanceof MarkerItem.SpecialPin) {
                String H2 = a2.b.a.a.a.H(new Object[]{markerItem.getCoordinates()}, 1, "special_pin_%s", "java.lang.String.format(this, *args)");
                bitmap = this.g.get(H2);
                if (bitmap == null) {
                    d dVar = this.e;
                    if (dVar == null) {
                        dVar = new d(b(R.layout.search_map_special_pin_marker));
                        this.e = dVar;
                    }
                    MarkerItem.SpecialPin specialPin = (MarkerItem.SpecialPin) markerItem;
                    Intrinsics.checkNotNullParameter(specialPin, "item");
                    dVar.a.setSpecialItem(specialPin);
                    Bitmap c3 = c(dVar.b);
                    this.g.put(H2, c3);
                    return c3;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return bitmap;
        }
        return c2;
    }
}

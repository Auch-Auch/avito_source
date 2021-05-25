package com.avito.android.item_map.view;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.item_map.R;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.Views;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010|\u001a\u00020:\u0012\u0006\u0010i\u001a\u00020f\u0012\u0006\u0010o\u001a\u00020l¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001c\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u001eH\u0016¢\u0006\u0004\b&\u0010'J\u0019\u0010)\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010,J!\u0010/\u001a\u00020\u00072\b\b\u0001\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001aH\u0016¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\u00072\b\b\u0001\u0010-\u001a\u00020\u001aH\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u0010,J\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u0010,J\u000f\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010,J\u000f\u00106\u001a\u00020\u001aH\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\b8\u0010,J\u000f\u00109\u001a\u00020\u0007H\u0016¢\u0006\u0004\b9\u0010,J\u0017\u0010<\u001a\n ;*\u0004\u0018\u00010:0:H\u0016¢\u0006\u0004\b<\u0010=R\u001e\u0010A\u001a\n ;*\u0004\u0018\u00010>0>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010E\u001a\n ;*\u0004\u0018\u00010B0B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010P\u001a\n ;*\u0004\u0018\u00010M0M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001e\u0010W\u001a\n ;*\u0004\u0018\u00010T0T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u001e\u0010]\u001a\n ;*\u0004\u0018\u00010T0T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010VR\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u001e\u0010s\u001a\n ;*\u0004\u0018\u00010p0p8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00070I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010KR\u0018\u0010w\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bv\u0010GR\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00020\f0I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010KR\u0016\u0010|\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001f\u0010\u0001\u001a\n ;*\u0004\u0018\u00010}0}8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010R¨\u0006\u0001"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapViewImpl;", "Lcom/avito/android/item_map/view/ItemMapView;", "Lcom/avito/android/avito_map/AvitoMapAttachHelper$MapAttachListener;", "Lio/reactivex/rxjava3/core/Observable;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "bottomSheetCallback", "()Lio/reactivex/rxjava3/core/Observable;", "", "backButtonCallback", "findMeButtonCallback", "osmDisclaimerCallback", "osmTooltipCallback", "Lcom/avito/android/avito_map/AvitoMapTarget;", "mapTargetUpdateCallback", "markerClickCallback", "Lcom/avito/android/avito_map/AvitoMapPoint;", "createRouteClicks", "Lcom/avito/android/avito_map/AvitoMap;", "map", "onMapAttach", "(Lcom/avito/android/avito_map/AvitoMap;)V", "point", "addItemMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "", "zoomToBounds", "", "boundsOffset", "addUserMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;ZI)V", "", "points", "Landroid/graphics/Bitmap;", "bitmap", "Lcom/avito/android/avito_map/AvitoMapMarker;", "addAmenityMarkers", "(Ljava/util/List;Landroid/graphics/Bitmap;)Ljava/util/List;", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "removeAmenityMarkers", "(Ljava/util/List;)V", "target", "moveToTarget", "(Lcom/avito/android/avito_map/AvitoMapTarget;)V", "showFindLocationError", "()V", "stringId", "duration", "showError", "(II)V", "showSnackBarWarning", "(I)V", "onStartMap", "onStopMap", "onDestroyMap", "getWhiteColor", "()I", "calculateBottomSheetPeekHeight", "showOsmPopUp", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getView", "()Landroid/view/View;", "Landroid/widget/ImageView;", "n", "Landroid/widget/ImageView;", "backButton", "Landroidx/appcompat/widget/Toolbar;", "k", "Landroidx/appcompat/widget/Toolbar;", "toolbar", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapMarker;", "userMarker", "Lcom/jakewharton/rxrelay3/PublishRelay;", g.a, "Lcom/jakewharton/rxrelay3/PublishRelay;", "markerClickRelay", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/recyclerview/widget/RecyclerView;", "bottomSheetRecycler", "d", "Lcom/avito/android/avito_map/AvitoMapPoint;", "userPoint", "Landroid/widget/TextView;", "o", "Landroid/widget/TextView;", "toolbarTitle", "Landroid/view/View$OnLayoutChangeListener;", "j", "Landroid/view/View$OnLayoutChangeListener;", "layoutChangeListener", "p", "osmDisclaimer", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "r", "Lcom/avito/android/lib/design/tooltip/Tooltip;", "tooltip", "Lru/avito/component/bottom_sheet/BottomSheet;", "i", "Lru/avito/component/bottom_sheet/BottomSheet;", "bottomSheet", "Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter;", "t", "Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter;", "mapItemsAdapter", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMap;", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "u", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "mapState", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "l", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "findMeButton", "h", "tooltipButtonClickRelay", "c", "itemMarker", "f", "mapTargetUpdateRelay", "s", "Landroid/view/View;", "rootView", "Landroid/content/Context;", VKApiConst.Q, "Landroid/content/Context;", "context", "e", "itemPoint", "<init>", "(Landroid/view/View;Lcom/avito/android/item_map/view/ItemMapViewBottomSheetAdapter;Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class ItemMapViewImpl implements ItemMapView, AvitoMapAttachHelper.MapAttachListener {
    public AvitoMap a;
    public AvitoMapMarker b;
    public AvitoMapMarker c;
    public AvitoMapPoint d;
    public AvitoMapPoint e;
    public final PublishRelay<AvitoMapTarget> f;
    public final PublishRelay<AvitoMapTarget> g;
    public final PublishRelay<Unit> h;
    public BottomSheet i;
    public final View.OnLayoutChangeListener j;
    public Toolbar k;
    public FloatingActionButton l;
    public RecyclerView m;
    public ImageView n = ((ImageView) this.k.findViewById(R.id.back));
    public TextView o = ((TextView) this.k.findViewById(R.id.title));
    public final TextView p;
    public final Context q;
    public Tooltip r;
    public final View s;
    public final ItemMapViewBottomSheetAdapter t;
    public final ItemMapView.ItemMapState u;

    public static final class a<T, R> implements Function<Unit, AvitoMapPoint> {
        public final /* synthetic */ ItemMapViewImpl a;

        public a(ItemMapViewImpl itemMapViewImpl) {
            this.a = itemMapViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public AvitoMapPoint apply(Unit unit) {
            return this.a.u.getItemCoordinates();
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ ItemMapViewImpl a;

        public b(ItemMapViewImpl itemMapViewImpl) {
            this.a = itemMapViewImpl;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.calculateBottomSheetPeekHeight();
        }
    }

    public static final class c extends Lambda implements Function1<TooltipContent, Unit> {
        public final /* synthetic */ ItemMapViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ItemMapViewImpl itemMapViewImpl) {
            super(1);
            this.a = itemMapViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TooltipContent tooltipContent) {
            TooltipContent tooltipContent2 = tooltipContent;
            Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
            tooltipContent2.setBody(this.a.q.getString(R.string.osm_tooltip_body));
            tooltipContent2.setButtonText(this.a.q.getString(R.string.osm_tooltip_button));
            tooltipContent2.setButtonClickListener(new a2.a.a.h1.a.a(this));
            return Unit.INSTANCE;
        }
    }

    public ItemMapViewImpl(@NotNull View view, @NotNull ItemMapViewBottomSheetAdapter itemMapViewBottomSheetAdapter, @NotNull ItemMapView.ItemMapState itemMapState) {
        List<AmenityButton> amenityButtons;
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(itemMapViewBottomSheetAdapter, "mapItemsAdapter");
        Intrinsics.checkNotNullParameter(itemMapState, "mapState");
        this.s = view;
        this.t = itemMapViewBottomSheetAdapter;
        this.u = itemMapState;
        PublishRelay<AvitoMapTarget> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.f = create;
        PublishRelay<AvitoMapTarget> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.g = create2;
        PublishRelay<Unit> create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.h = create3;
        BottomSheet.Companion companion = BottomSheet.Companion;
        View findViewById = view.findViewById(R.id.bottom_sheet);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.bottom_sheet)");
        BottomSheet create4 = companion.create(findViewById);
        create4.setContentView(R.layout.item_map_address);
        create4.setHideable(false);
        create4.setNotchVisibility(BottomSheet.NotchVisibility.ALWAYS_SHOWN);
        this.i = create4;
        b bVar = new b(this);
        this.j = bVar;
        this.k = (Toolbar) view.findViewById(R.id.toolbar);
        this.l = (FloatingActionButton) view.findViewById(R.id.find_me);
        this.m = (RecyclerView) view.findViewById(R.id.rvData);
        TextView textView = (TextView) view.findViewById(R.id.osm_disclaimer);
        this.p = textView;
        this.q = view.getContext();
        Toolbar toolbar = this.k;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        List<AmenityButton> list = null;
        toolbar.setNavigationIcon((Drawable) null);
        TextView textView2 = this.o;
        Intrinsics.checkNotNullExpressionValue(textView2, "toolbarTitle");
        textView2.setText(itemMapState.getTitle());
        Views.setVisible(this.l, itemMapState.getHasFindMeButton());
        ItemMapView.AmenityButtonsState amenityButtonsState = itemMapState.getAmenityButtonsState();
        Views.setVisible(textView, (amenityButtonsState != null ? amenityButtonsState.getAmenityButtons() : list) != null);
        ItemMapView.BottomSheetState bottomSheetState = itemMapState.getBottomSheetState();
        if (bottomSheetState != null) {
            RecyclerView recyclerView = this.m;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "this");
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(itemMapViewBottomSheetAdapter);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(bottomSheetState.getGeoReferences());
            arrayList.add(new ItemAddress(bottomSheetState.getAddress()));
            ItemMapView.AmenityButtonsState amenityButtonsState2 = itemMapState.getAmenityButtonsState();
            if (!(amenityButtonsState2 == null || (amenityButtons = amenityButtonsState2.getAmenityButtons()) == null || !(!amenityButtons.isEmpty()))) {
                arrayList.add(new AmenityButtonsItem(itemMapState.getAmenityButtonsState().getAmenityButtons()));
            }
            if (itemMapState.getHasCreateRouteButton()) {
                arrayList.add(new CreateRouteItem());
                this.i.expand();
            }
            itemMapViewBottomSheetAdapter.updateData(arrayList);
            if (bottomSheetState.getBottomSheetVisibility() != 3) {
                this.i.collapse();
            } else {
                this.i.expand();
            }
            this.m.addOnLayoutChangeListener(bVar);
            return;
        }
        this.i.close();
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @Nullable
    public List<AvitoMapMarker> addAmenityMarkers(@NotNull List<AvitoMapPoint> list, @NotNull Bitmap bitmap) {
        List<AvitoMapPoint> list2;
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        AvitoMapPoint itemCoordinates = this.u.getItemCoordinates();
        if (itemCoordinates != null) {
            list2 = CollectionsKt__CollectionsKt.mutableListOf(itemCoordinates);
            list2.addAll(list);
        } else {
            list2 = list;
        }
        AvitoMap avitoMap = this.a;
        if (avitoMap != null) {
            avitoMap.moveToPointsWithPadding(list2, 200, true);
        }
        AvitoMap avitoMap2 = this.a;
        if (avitoMap2 != null) {
            return AvitoMap.DefaultImpls.addSameMarkers$default(avitoMap2, list, bitmap, null, null, false, 28, null);
        }
        return null;
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void addItemMarker(@Nullable AvitoMapPoint avitoMapPoint) {
        AvitoMap avitoMap;
        if (avitoMapPoint != null) {
            this.e = avitoMapPoint;
            AvitoMapMarker avitoMapMarker = this.c;
            AvitoMapMarker avitoMapMarker2 = null;
            if (!(avitoMapMarker == null || (avitoMap = this.a) == null)) {
                AvitoMap.DefaultImpls.removeMarker$default(avitoMap, avitoMapMarker, false, 2, null);
            }
            AvitoMap avitoMap2 = this.a;
            if (avitoMap2 != null) {
                avitoMapMarker2 = AvitoMap.DefaultImpls.addMarker$default(avitoMap2, avitoMapPoint, AvitoMapMarker.Type.MARKER_PIN_DEFAULT_RED, AvitoMapMarker.Anchor.BOTTOM_CENTER, (Float) null, 8, (Object) null);
            }
            AvitoMapPoint avitoMapPoint2 = this.e;
            if (!(avitoMapPoint2 == null || avitoMapMarker2 == null)) {
                avitoMapMarker2.setData(avitoMapPoint2);
            }
            Unit unit = Unit.INSTANCE;
            this.c = avitoMapMarker2;
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void addUserMarker(@Nullable AvitoMapPoint avitoMapPoint, boolean z, int i2) {
        AvitoMapPoint avitoMapPoint2;
        AvitoMap avitoMap;
        AvitoMap avitoMap2;
        if (avitoMapPoint != null) {
            this.d = avitoMapPoint;
            AvitoMapMarker avitoMapMarker = this.b;
            AvitoMapMarker avitoMapMarker2 = null;
            if (!(avitoMapMarker == null || (avitoMap2 = this.a) == null)) {
                AvitoMap.DefaultImpls.removeMarker$default(avitoMap2, avitoMapMarker, false, 2, null);
            }
            AvitoMap avitoMap3 = this.a;
            if (avitoMap3 != null) {
                avitoMapMarker2 = AvitoMap.DefaultImpls.addMarker$default(avitoMap3, avitoMapPoint, AvitoMapMarker.Type.MARKER_MY_LOCATION, AvitoMapMarker.Anchor.BOTTOM_CENTER, (Float) null, 8, (Object) null);
            }
            AvitoMapPoint avitoMapPoint3 = this.d;
            if (!(avitoMapPoint3 == null || avitoMapMarker2 == null)) {
                avitoMapMarker2.setData(avitoMapPoint3);
            }
            Unit unit = Unit.INSTANCE;
            this.b = avitoMapMarker2;
            if (z && (avitoMapPoint2 = this.e) != null && (avitoMap = this.a) != null) {
                AvitoMap.DefaultImpls.moveToPointsWithPadding$default(avitoMap, CollectionsKt__CollectionsKt.listOf((Object[]) new AvitoMapPoint[]{avitoMapPoint, avitoMapPoint2}), Integer.valueOf(i2), false, 4, null);
            }
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<Unit> backButtonCallback() {
        ImageView imageView = this.n;
        Intrinsics.checkNotNullExpressionValue(imageView, "backButton");
        return RxView.clicks(imageView);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<BottomSheet.Visibility> bottomSheetCallback() {
        return this.i.getVisibilityObservable();
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void calculateBottomSheetPeekHeight() {
        View childAt = this.m.getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "view");
        this.i.setPeekHeight(new BottomSheet.PeekHeight.Absolute(childAt.getHeight() + childAt.getResources().getDimensionPixelSize(R.dimen.map_address_bottom_sheet_all_top_margins)));
        this.m.removeOnLayoutChangeListener(this.j);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<AvitoMapPoint> createRouteClicks() {
        Observable<R> map = this.t.getCreateRouteClicks().map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "mapItemsAdapter.createRo…ate.itemCoordinates\n    }");
        return map;
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<Unit> findMeButtonCallback() {
        FloatingActionButton floatingActionButton = this.l;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "findMeButton");
        return RxView.clicks(floatingActionButton);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public View getView() {
        return this.s.findViewById(R.id.coordinator);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public int getWhiteColor() {
        return Views.getColor(this.s, com.avito.android.lib.design.avito.R.color.avito_white);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<AvitoMapTarget> mapTargetUpdateCallback() {
        return this.f;
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<AvitoMapTarget> markerClickCallback() {
        return this.g;
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void moveToTarget(@Nullable AvitoMapTarget avitoMapTarget) {
        AvitoMap avitoMap;
        if (avitoMapTarget != null && (avitoMap = this.a) != null) {
            avitoMap.moveTo(avitoMapTarget.getPoint(), true, Float.valueOf(avitoMapTarget.getZoomLevel()));
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void onDestroyMap() {
        this.a = null;
    }

    @Override // com.avito.android.avito_map.AvitoMapAttachHelper.MapAttachListener
    public void onMapAttach(@NotNull AvitoMap avitoMap) {
        Intrinsics.checkNotNullParameter(avitoMap, "map");
        this.a = avitoMap;
        AvitoMapUiSettings uiSettings = avitoMap.getUiSettings();
        uiSettings.isZoomGesturesEnabled(true);
        uiSettings.isFastTapEnabled(true);
        uiSettings.isMapToolbarEnabled(false);
        uiSettings.isZoomControlsEnabled(false);
        uiSettings.isRotateGesturesEnabled(false);
        avitoMap.addMoveEndListener(new AvitoMap.MapMoveEndListener(this) { // from class: com.avito.android.item_map.view.ItemMapViewImpl$onMapAttach$2
            public final /* synthetic */ ItemMapViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MapMoveEndListener
            public void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
                Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "mapCameraPosition");
                this.a.f.accept(new AvitoMapTarget(avitoMapCameraPosition.getMapPoint(), avitoMapCameraPosition.getZoomLevel()));
            }
        });
        avitoMap.addMarkerClickListener(new AvitoMap.MarkerClickListener(this, avitoMap) { // from class: com.avito.android.item_map.view.ItemMapViewImpl$onMapAttach$3
            public final /* synthetic */ ItemMapViewImpl a;
            public final /* synthetic */ AvitoMap b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.avito_map.AvitoMap.MarkerClickListener
            public void onMarkerClicked(@Nullable Object obj) {
                if (!(obj instanceof AvitoMapPoint)) {
                    obj = null;
                }
                AvitoMapPoint avitoMapPoint = (AvitoMapPoint) obj;
                if (avitoMapPoint != null) {
                    this.a.g.accept(new AvitoMapTarget(avitoMapPoint, this.b.getMapTarget().getZoomLevel()));
                }
            }
        });
        ItemMapView.ItemMapState itemMapState = this.u;
        addItemMarker(itemMapState.getItemCoordinates());
        ItemMapView.DefaultImpls.addUserMarker$default(this, itemMapState.getMyCoordinates(), false, 0, 6, null);
        if (itemMapState.getMapTargetPoint() != null) {
            avitoMap.moveTo(itemMapState.getMapTargetPoint(), false, Float.valueOf(itemMapState.getMapZoomLevel()));
        } else if (itemMapState.getItemCoordinates() != null) {
            avitoMap.moveTo(itemMapState.getItemCoordinates(), false, Float.valueOf(15.0f));
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void onStartMap() {
        AvitoMap avitoMap = this.a;
        if (avitoMap != null) {
            avitoMap.onStart();
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void onStopMap() {
        AvitoMap avitoMap = this.a;
        if (avitoMap != null) {
            avitoMap.onStop();
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<Unit> osmDisclaimerCallback() {
        TextView textView = this.p;
        Intrinsics.checkNotNullExpressionValue(textView, "osmDisclaimer");
        return RxView.clicks(textView);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    @NotNull
    public Observable<Unit> osmTooltipCallback() {
        return this.h;
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void removeAmenityMarkers(@NotNull List<? extends AvitoMapMarker> list) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
        for (T t2 : list) {
            AvitoMap avitoMap = this.a;
            if (avitoMap != null) {
                AvitoMap.DefaultImpls.removeMarker$default(avitoMap, t2, false, 2, null);
            }
        }
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void showError(@StringRes int i2, int i3) {
        Toast.makeText(this.q, i2, i3).show();
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void showFindLocationError() {
        ItemMapView.DefaultImpls.showError$default(this, com.avito.android.geo.R.string.location_not_found, 0, 2, null);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void showOsmPopUp() {
        Tooltip tooltip = this.r;
        if (tooltip != null) {
            tooltip.dismiss();
        }
        Context context = this.q;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Tooltip content = TooltipContentKt.content(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Top(new TailPositions.End(new AnchorPositions.End()))), new c(this));
        TextView textView = this.p;
        Intrinsics.checkNotNullExpressionValue(textView, "osmDisclaimer");
        this.r = content.show(textView);
    }

    @Override // com.avito.android.item_map.view.ItemMapView
    public void showSnackBarWarning(@StringRes int i2) {
        AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.s, i2, -1, null, 0, null, null, 0, 0, 504, null).show();
    }
}

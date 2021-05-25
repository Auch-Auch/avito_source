package com.avito.android.spare_parts.bottom_sheet;

import a2.a.a.z2.b.c;
import a2.a.a.z2.b.d;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.subjects.SingleSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J-\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0011R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\u00020#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetViewImpl;", "Lcom/avito/android/spare_parts/bottom_sheet/SparePartsBottomSheetView;", "", "title", "", "closeButtonIconRes", "Lkotlin/Function0;", "", "closeListener", "setDialogHeaderParams", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "", "shouldAnimate", "reversed", "onDataChanged", "(ZZ)V", "onDetach", "()V", "", "from", "to", "Lio/reactivex/rxjava3/core/Completable;", AuthSource.BOOKING_ORDER, "(FF)Lio/reactivex/rxjava3/core/Completable;", "", "duration", "Lkotlin/Function1;", "updateCallback", AuthSource.SEND_ABUSE, "(FFJLkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Completable;", "c", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "f", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Z", "isDetached", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "La2/a/a/z2/b/d;", "e", "La2/a/a/z2/b/d;", "layoutManager", "Lio/reactivex/rxjava3/subjects/SingleSubject;", "d", "Lio/reactivex/rxjava3/subjects/SingleSubject;", "layoutUpdatedHeightEvent", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "<init>", "(Landroid/view/View;Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsBottomSheetViewImpl implements SparePartsBottomSheetView {
    @NotNull
    public final Context a;
    public final RecyclerView b;
    public boolean c;
    public SingleSubject<Integer> d;
    public d e;
    public final BottomSheetDialog f;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ SparePartsBottomSheetViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SparePartsBottomSheetViewImpl sparePartsBottomSheetViewImpl) {
            super(1);
            this.a = sparePartsBottomSheetViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            SingleSubject singleSubject = this.a.d;
            if (singleSubject != null) {
                singleSubject.onSuccess(Integer.valueOf(intValue));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Float, Unit> {
        public final /* synthetic */ SparePartsBottomSheetViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SparePartsBottomSheetViewImpl sparePartsBottomSheetViewImpl) {
            super(1);
            this.a = sparePartsBottomSheetViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Float f) {
            this.a.b.setTranslationX(f.floatValue());
            return Unit.INSTANCE;
        }
    }

    public SparePartsBottomSheetViewImpl(@NotNull View view, @NotNull BottomSheetDialog bottomSheetDialog, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "dialog");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        this.f = bottomSheetDialog;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.a = context;
        RecyclerView recyclerView = (RecyclerView) view;
        this.b = recyclerView;
        d dVar = new d(getContext());
        this.e = dVar;
        dVar.L = new a(this);
        recyclerView.setLayoutManager(this.e);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setItemAnimator(null);
    }

    public static final Completable access$buildHeightAnimationCompletable(SparePartsBottomSheetViewImpl sparePartsBottomSheetViewImpl, int i, int i2) {
        if (!sparePartsBottomSheetViewImpl.c) {
            return sparePartsBottomSheetViewImpl.a((float) i, (float) i2, 150, new c(sparePartsBottomSheetViewImpl));
        }
        Completable error = Completable.error(new IllegalStateException());
        Intrinsics.checkNotNullExpressionValue(error, "Completable.error(IllegalStateException())");
        return error;
    }

    public final Completable a(float f2, float f3, long j, Function1<? super Float, Unit> function1) {
        Completable create = Completable.create(new SparePartsBottomSheetViewImpl$buildAnimationCompletable$1(f2, f3, j, function1));
        Intrinsics.checkNotNullExpressionValue(create, "Completable.create {\n   …)\n            }\n        }");
        return create;
    }

    public final Completable b(float f2, float f3) {
        if (!this.c) {
            return a(f2, f3, 120, new b(this));
        }
        Completable error = Completable.error(new IllegalStateException());
        Intrinsics.checkNotNullExpressionValue(error, "Completable.error(IllegalStateException())");
        return error;
    }

    public final void c() {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.height = -2;
        this.b.setLayoutParams(layoutParams);
        this.b.setTranslationX(0.0f);
        this.e.J = false;
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetView
    @NotNull
    public Context getContext() {
        return this.a;
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetView
    public void onDataChanged(boolean z, boolean z2) {
        float f2;
        float f3;
        if (z) {
            this.d = SingleSubject.create();
            if (z2) {
                f2 = ((float) this.b.getWidth()) * 1.0f;
            } else {
                f2 = ((float) this.b.getWidth()) * -1.0f;
            }
            b(0.0f, f2).subscribe(new y3(0, this), new v1(0, this));
            if (z2) {
                f3 = ((float) this.b.getWidth()) * -1.0f;
            } else {
                f3 = 1.0f * ((float) this.b.getWidth());
            }
            SingleSubject<Integer> singleSubject = this.d;
            Intrinsics.checkNotNull(singleSubject);
            singleSubject.flatMapCompletable(new a2.a.a.z2.b.b(this)).andThen(b(f3, 0.0f)).subscribe(new y3(1, this), new v1(1, this));
            return;
        }
        RecyclerView.Adapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetView
    public void onDetach() {
        this.c = true;
        c();
    }

    @Override // com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetView
    public void setDialogHeaderParams(@NotNull String str, int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(function0, "closeListener");
        this.f.setCloseButtonIcon(i);
        BottomSheetDialog.setHeaderParams$default(this.f, str, null, true, true, 2, null);
        this.f.setOnCloseListener(function0);
        this.f.setManualDismissOnCancelClick(true);
    }
}

package a2.a.a.s0;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.favorite_sellers.BottomSheetMenu;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.util.Contexts;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends BottomSheetDialog implements BottomSheetMenu {
    public final LayoutInflater s;
    public final ViewGroup t;
    @NotNull
    public final Observable<Unit> u;

    /* renamed from: a2.a.a.s0.a$a  reason: collision with other inner class name */
    public static final class C0007a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ a a;

        /* renamed from: a2.a.a.s0.a$a$a  reason: collision with other inner class name */
        public static final class DialogInterface$OnDismissListenerC0008a implements DialogInterface.OnDismissListener {
            public final /* synthetic */ ObservableEmitter a;

            public DialogInterface$OnDismissListenerC0008a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        /* renamed from: a2.a.a.s0.a$a$b */
        public static final class b implements Cancellable {
            public final /* synthetic */ C0007a a;

            public b(C0007a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.setOnDismissListener(null);
            }
        }

        public C0007a(a aVar) {
            this.a = aVar;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            this.a.setOnDismissListener(new DialogInterface$OnDismissListenerC0008a(observableEmitter));
            observableEmitter.setCancellable(new b(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.s = LayoutInflater.from(context);
        setContentView(R.layout.subscription_settings_menu_dialog_content);
        View findViewById = findViewById(R.id.bottom_sheet_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.t = (ViewGroup) findViewById;
        Observable<Unit> create = Observable.create(new C0007a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…issListener(null) }\n    }");
        this.u = create;
    }

    @Override // com.avito.android.favorite_sellers.BottomSheetMenu
    @NotNull
    public BottomSheetMenu.MenuItem addItem() {
        View inflate = this.s.inflate(R.layout.subscription_settings_menu_item, this.t, false);
        this.t.addView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        BottomSheetMenu.MenuItem menuItem = new BottomSheetMenu.MenuItem(inflate);
        inflate.setTag(menuItem);
        return menuItem;
    }

    @Override // com.avito.android.favorite_sellers.BottomSheetMenu
    @NotNull
    public Observable<Unit> getDismissEvents() {
        return this.u;
    }

    @Override // com.avito.android.favorite_sellers.BottomSheetMenu
    public boolean isShown() {
        return isShowing();
    }

    @Override // com.avito.android.favorite_sellers.BottomSheetMenu
    public void setItemsEnabled(boolean z) {
        ViewGroup viewGroup = this.t;
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                BottomSheetMenu.MenuItem menuItem = (BottomSheetMenu.MenuItem) childAt.getTag();
                if (menuItem != null) {
                    menuItem.setEnabled(z);
                }
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.app.Dialog, com.avito.android.favorite_sellers.BottomSheetMenu
    public void show() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ViewGroup viewGroup = this.t;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        viewGroup.measure(View.MeasureSpec.makeMeasureSpec(Contexts.getRealDisplayWidth(context2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(Contexts.getRealDisplayHeight(context) / 2, Integer.MIN_VALUE));
        setPeekHeight(this.t.getMeasuredHeight());
        super.show();
    }

    @Override // com.avito.android.favorite_sellers.BottomSheetMenu
    @NotNull
    public BottomSheetMenu.MenuItem addItem(@NotNull Function1<? super BottomSheetMenu.MenuItem, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        View inflate = this.s.inflate(R.layout.subscription_settings_menu_item, this.t, false);
        this.t.addView(inflate);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        BottomSheetMenu.MenuItem menuItem = new BottomSheetMenu.MenuItem(inflate);
        inflate.setTag(menuItem);
        function1.invoke(menuItem);
        return menuItem;
    }
}

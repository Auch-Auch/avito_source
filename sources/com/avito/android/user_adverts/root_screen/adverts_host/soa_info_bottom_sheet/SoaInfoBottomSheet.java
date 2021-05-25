package com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.Image;
import com.avito.android.user_adverts.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/soa_info_bottom_sheet/SoaInfoBottomSheet;", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "Lcom/avito/android/remote/model/Image;", VKApiConst.VERSION, "Lcom/avito/android/remote/model/Image;", "image", "", "t", "Ljava/lang/CharSequence;", "text", "", "u", "Ljava/lang/String;", "confirmButtonText", "s", "title", "Lkotlin/Function0;", "", "w", "Lkotlin/jvm/functions/Function0;", "onCloseCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lkotlin/jvm/functions/Function0;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class SoaInfoBottomSheet extends BottomSheetDialog {
    public final String s;
    public final CharSequence t;
    public final String u;
    public final Image v;
    public final Function0<Unit> w;

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SoaInfoBottomSheet a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SoaInfoBottomSheet soaInfoBottomSheet) {
            super(0);
            this.a = soaInfoBottomSheet;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.w.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SoaInfoBottomSheet(@NotNull Context context, @NotNull String str, @Nullable CharSequence charSequence, @NotNull String str2, @NotNull Image image, @NotNull Function0<Unit> function0) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "confirmButtonText");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(function0, "onCloseCallback");
        this.s = str;
        this.t = charSequence;
        this.u = str2;
        this.v = image;
        this.w = function0;
        BottomSheetDialog.setContentView$default(this, R.layout.soa_info_dialog, R.layout.soa_info_confirm_button, new Function1<View, Unit>(this) { // from class: com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoBottomSheet.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                SoaInfoBottomSheet.access$setupContentView((SoaInfoBottomSheet) this.receiver, view2);
                return Unit.INSTANCE;
            }
        }, new Function1<View, Unit>(this) { // from class: com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoBottomSheet.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(View view) {
                View view2 = view;
                Intrinsics.checkNotNullParameter(view2, "p1");
                SoaInfoBottomSheet.access$setupFooterView((SoaInfoBottomSheet) this.receiver, view2);
                return Unit.INSTANCE;
            }
        }, false, 16, null);
        BottomSheetDialog.setHeaderParams$default(this, null, null, false, false, 10, null);
        setCancelable(true);
        setSkipCollapsed(true);
        setCanceledOnTouchOutside(true);
        setShowOnStart(false);
        setOnCloseListener(new c(this));
    }

    public static final void access$setupContentView(SoaInfoBottomSheet soaInfoBottomSheet, View view) {
        Objects.requireNonNull(soaInfoBottomSheet);
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        View findViewById2 = view.findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.text)");
        View findViewById3 = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.image)");
        ((TextView) findViewById).setText(soaInfoBottomSheet.s);
        ((TextView) findViewById2).setText(soaInfoBottomSheet.t);
        SimpleDraweeViewsKt.getRequestBuilder((SimpleDraweeView) findViewById3).picture(AvitoPictureKt.pictureOf$default(soaInfoBottomSheet.v, false, 0.0f, 0.0f, null, 28, null)).load();
    }

    public static final void access$setupFooterView(SoaInfoBottomSheet soaInfoBottomSheet, View view) {
        Objects.requireNonNull(soaInfoBottomSheet);
        View findViewById = view.findViewById(R.id.confirm_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.confirm_button)");
        Button button = (Button) findViewById;
        button.setText(soaInfoBottomSheet.u);
        button.setOnClickListener(new a2.a.a.i3.c.a.j.a(soaInfoBottomSheet));
    }
}

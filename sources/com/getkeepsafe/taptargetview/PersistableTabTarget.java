package com.getkeepsafe.taptargetview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/getkeepsafe/taptargetview/PersistableTabTarget;", "Lcom/getkeepsafe/taptargetview/TapTarget;", "Ljava/lang/Runnable;", "runnable", "", "onReady", "(Ljava/lang/Runnable;)V", "Landroid/view/View;", "C", "Landroid/view/View;", "view", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "supplyView", "", "title", "description", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PersistableTabTarget extends TapTarget {
    public View C;
    public final Function0<View> D;

    public static final class a implements Runnable {
        public final /* synthetic */ PersistableTabTarget a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Runnable c;

        public a(PersistableTabTarget persistableTabTarget, View view, Runnable runnable) {
            this.a = persistableTabTarget;
            this.b = view;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            this.a.e = new Rect(iArr[0], iArr[1], this.b.getWidth() + iArr[0], this.b.getHeight() + iArr[1]);
            if (this.a.f == null && this.b.getWidth() > 0 && this.b.getHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                this.b.draw(new Canvas(createBitmap));
                this.a.f = new BitmapDrawable(a2.b.a.a.a.u1(this.b, "targetView.context"), createBitmap);
                Drawable drawable = this.a.f;
                Intrinsics.checkNotNullExpressionValue(drawable, "icon");
                int intrinsicWidth = drawable.getIntrinsicWidth();
                Drawable drawable2 = this.a.f;
                Intrinsics.checkNotNullExpressionValue(drawable2, "icon");
                drawable.setBounds(0, 0, intrinsicWidth, drawable2.getIntrinsicHeight());
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends android.view.View> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersistableTabTarget(@NotNull Function0<? extends View> function0, @NotNull CharSequence charSequence, @Nullable CharSequence charSequence2) {
        super(charSequence, charSequence2);
        Intrinsics.checkNotNullParameter(function0, "supplyView");
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.D = function0;
        this.C = (View) function0.invoke();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if ((r0 != null ? r0.getParent() : null) == null) goto L_0x000e;
     */
    @Override // com.getkeepsafe.taptargetview.TapTarget
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReady(@org.jetbrains.annotations.Nullable java.lang.Runnable r3) {
        /*
            r2 = this;
            android.view.View r0 = r2.C
            if (r0 == 0) goto L_0x000e
            if (r0 == 0) goto L_0x000b
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x0018
        L_0x000e:
            kotlin.jvm.functions.Function0<android.view.View> r0 = r2.D
            java.lang.Object r0 = r0.invoke()
            android.view.View r0 = (android.view.View) r0
            r2.C = r0
        L_0x0018:
            android.view.View r0 = r2.C
            if (r0 != 0) goto L_0x0025
            android.graphics.Rect r3 = new android.graphics.Rect
            r0 = 0
            r3.<init>(r0, r0, r0, r0)
            r2.e = r3
            return
        L_0x0025:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.getkeepsafe.taptargetview.PersistableTabTarget$a r1 = new com.getkeepsafe.taptargetview.PersistableTabTarget$a
            r1.<init>(r2, r0, r3)
            androidx.appcompat.app.AppCompatDelegateImpl.i.q1(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getkeepsafe.taptargetview.PersistableTabTarget.onReady(java.lang.Runnable):void");
    }
}

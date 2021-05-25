package com.avito.android.advert.item;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ToastsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J#\u0010\r\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegateImpl;", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "Landroidx/fragment/app/Fragment;", "fragment", "()Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function1;", "Landroid/content/Context;", "", "block", "runBlockWithContext", "(Lkotlin/jvm/functions/Function1;)V", "", "e", "", "showToast", "handleError", "(Ljava/lang/Throwable;Z)V", "Lcom/avito/android/util/ErrorFormatterImpl;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/ErrorFormatterImpl;", "errorFormatter", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "c", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFragmentDelegateImpl implements AdvertDetailsFragmentDelegate {
    public final Context a;
    public final ErrorFormatterImpl b;
    public final Fragment c;

    public AdvertDetailsFragmentDelegateImpl(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.c = fragment;
        this.a = fragment.getContext();
        fragment.getActivity();
        Resources resources = fragment.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "fragment.resources");
        this.b = new ErrorFormatterImpl(resources);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsFragmentDelegate
    @NotNull
    public FragmentManager childFragmentManager() {
        FragmentManager childFragmentManager = this.c.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        return childFragmentManager;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsFragmentDelegate
    @NotNull
    public Fragment fragment() {
        return this.c;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsFragmentDelegate
    @Nullable
    public FragmentManager fragmentManager() {
        return this.c.getFragmentManager();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsFragmentDelegate
    public void handleError(@Nullable Throwable th, boolean z) {
        Context context;
        if (z && this.c.isVisible() && (context = this.a) != null) {
            ToastsKt.showToast$default(context, this.b.format(th), 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsFragmentDelegate
    public void runBlockWithContext(@NotNull Function1<? super Context, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Context context = this.a;
        if (context != null) {
            function1.invoke(context);
        }
    }
}

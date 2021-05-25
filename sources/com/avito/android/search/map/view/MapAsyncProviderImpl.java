package com.avito.android.search.map.view;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/search/map/view/MapAsyncProviderImpl;", "Lcom/avito/android/search/map/view/MapAsyncProvider;", "Lkotlin/Function1;", "Lcom/avito/android/avito_map/AvitoMap;", "", "callback", "provideMap", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/view/View;", "c", "Landroid/view/View;", "container", "", AuthSource.BOOKING_ORDER, "I", "viewId", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "avitoMapAttachHelper", "Landroidx/fragment/app/FragmentManager;", "d", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper;ILandroid/view/View;Landroidx/fragment/app/FragmentManager;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class MapAsyncProviderImpl implements MapAsyncProvider {
    public final AvitoMapAttachHelper a;
    public final int b;
    public final View c;
    public final FragmentManager d;

    public MapAsyncProviderImpl(@NotNull AvitoMapAttachHelper avitoMapAttachHelper, int i, @NotNull View view, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper, "avitoMapAttachHelper");
        Intrinsics.checkNotNullParameter(view, "container");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.a = avitoMapAttachHelper;
        this.b = i;
        this.c = view;
        this.d = fragmentManager;
    }

    @Override // com.avito.android.search.map.view.MapAsyncProvider
    public void provideMap(@NotNull Function1<? super AvitoMap, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.a.setMapAttachedListener(new AvitoMapAttachHelper.MapAttachListener(function1) { // from class: com.avito.android.search.map.view.MapAsyncProviderImpl$provideMap$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.avito_map.AvitoMapAttachHelper.MapAttachListener
            public void onMapAttach(@NotNull AvitoMap avitoMap) {
                Intrinsics.checkNotNullParameter(avitoMap, "map");
                this.a.invoke(avitoMap);
            }
        });
        this.a.attachView(this.b, this.c, this.d);
    }
}

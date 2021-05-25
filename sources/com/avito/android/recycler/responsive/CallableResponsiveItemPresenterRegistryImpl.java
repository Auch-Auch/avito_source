package com.avito.android.recycler.responsive;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemView;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ9\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistryImpl;", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistry;", "Lcom/avito/konveyor/blueprint/ItemView;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/lang/Class;", "viewType", "Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "itemPresenter", "", "register", "(Ljava/lang/Class;Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;)V", "unregister", "(Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;)V", "itemView", "", VKApiConst.POSITION, "onViewAttached", "(Lcom/avito/konveyor/blueprint/ItemView;I)V", "onViewDetached", "Lcom/avito/conveyor_item/Item;", AuthSource.SEND_ABUSE, "(Lcom/avito/konveyor/blueprint/ItemView;)Lcom/avito/android/recycler/responsive/ResponsiveItemPresenter;", "", "Lcom/avito/android/recycler/responsive/CallableResponsiveItemPresenterRegistryImpl$a;", "Ljava/util/List;", "entries", "<init>", "()V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class CallableResponsiveItemPresenterRegistryImpl implements CallableResponsiveItemPresenterRegistry {
    public final List<a> a = new ArrayList();

    public static final class a {
        public final Class<? extends ItemView> a;
        @NotNull
        public final ResponsiveItemPresenter<ItemView, Item> b;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.recycler.responsive.ResponsiveItemPresenter<? super com.avito.konveyor.blueprint.ItemView, ? super com.avito.conveyor_item.Item> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Class<? extends ItemView> cls, @NotNull ResponsiveItemPresenter<? super ItemView, ? super Item> responsiveItemPresenter) {
            Intrinsics.checkNotNullParameter(cls, "itemType");
            Intrinsics.checkNotNullParameter(responsiveItemPresenter, "presenter");
            this.a = cls;
            this.b = responsiveItemPresenter;
        }
    }

    public static final class b extends Lambda implements Function1<a, Boolean> {
        public final /* synthetic */ ResponsiveItemPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ResponsiveItemPresenter responsiveItemPresenter) {
            super(1);
            this.a = responsiveItemPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(a aVar) {
            a aVar2 = aVar;
            Intrinsics.checkNotNullParameter(aVar2, "it");
            return Boolean.valueOf(aVar2.b == this.a);
        }
    }

    public final ResponsiveItemPresenter<ItemView, Item> a(ItemView itemView) {
        T t;
        Iterator<T> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            T t2 = t;
            Objects.requireNonNull(t2);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            if (t2.a.isAssignableFrom(itemView.getClass())) {
                break;
            }
        }
        T t3 = t;
        if (t3 != null) {
            return t3.b;
        }
        return null;
    }

    @Override // com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry
    public void onViewAttached(@NotNull ItemView itemView, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ResponsiveItemPresenter<ItemView, Item> a3 = a(itemView);
        if (a3 != null) {
            a3.viewAttached(itemView, i);
        }
    }

    @Override // com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry
    public void onViewDetached(@NotNull ItemView itemView, int i) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ResponsiveItemPresenter<ItemView, Item> a3 = a(itemView);
        if (a3 != null) {
            a3.viewDetached(itemView, i);
        }
    }

    @Override // com.avito.android.recycler.responsive.ResponsiveItemPresenterRegistry
    public <V extends ItemView> void register(@NotNull Class<V> cls, @NotNull ResponsiveItemPresenter<? super V, ?> responsiveItemPresenter) {
        Intrinsics.checkNotNullParameter(cls, "viewType");
        Intrinsics.checkNotNullParameter(responsiveItemPresenter, "itemPresenter");
        this.a.add(new a(cls, responsiveItemPresenter));
    }

    @Override // com.avito.android.recycler.responsive.ResponsiveItemPresenterRegistry
    public void unregister(@NotNull ResponsiveItemPresenter<?, ?> responsiveItemPresenter) {
        Intrinsics.checkNotNullParameter(responsiveItemPresenter, "itemPresenter");
        h.removeAll((List) this.a, (Function1) new b(responsiveItemPresenter));
    }
}

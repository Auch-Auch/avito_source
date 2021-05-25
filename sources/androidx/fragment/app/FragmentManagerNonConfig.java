package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;
@Deprecated
public class FragmentManagerNonConfig {
    @Nullable
    public final Collection<Fragment> a;
    @Nullable
    public final Map<String, FragmentManagerNonConfig> b;
    @Nullable
    public final Map<String, ViewModelStore> c;

    public FragmentManagerNonConfig(@Nullable Collection<Fragment> collection, @Nullable Map<String, FragmentManagerNonConfig> map, @Nullable Map<String, ViewModelStore> map2) {
        this.a = collection;
        this.b = map;
        this.c = map2;
    }
}

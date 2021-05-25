package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;
public final class SetFactory<T> implements Factory<Set<T>> {
    public static final Factory<Set<Object>> c = InstanceFactory.create(Collections.emptySet());
    public final List<Provider<T>> a;
    public final List<Provider<Collection<T>>> b;

    public static final class Builder<T> {
        public final List<Provider<T>> a;
        public final List<Provider<Collection<T>>> b;

        public Builder(int i, int i2, a aVar) {
            this.a = DaggerCollections.presizedList(i);
            this.b = DaggerCollections.presizedList(i2);
        }

        public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> provider) {
            this.b.add(provider);
            return this;
        }

        public Builder<T> addProvider(Provider<? extends T> provider) {
            this.a.add(provider);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.a, this.b, null);
        }
    }

    public SetFactory(List list, List list2, a aVar) {
        this.a = list;
        this.b = list2;
    }

    public static <T> Builder<T> builder(int i, int i2) {
        return new Builder<>(i, i2, null);
    }

    public static <T> Factory<Set<T>> empty() {
        return (Factory<Set<T>>) c;
    }

    @Override // javax.inject.Provider
    public Set<T> get() {
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(this.b.size());
        int size2 = this.b.size();
        for (int i = 0; i < size2; i++) {
            Collection<T> collection = this.b.get(i).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSet = new HashSet(DaggerCollections.a(size));
        int size3 = this.a.size();
        for (int i2 = 0; i2 < size3; i2++) {
            hashSet.add(Preconditions.checkNotNull(this.a.get(i2).get()));
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object obj : (Collection) arrayList.get(i3)) {
                hashSet.add(Preconditions.checkNotNull(obj));
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}

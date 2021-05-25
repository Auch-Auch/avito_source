package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;
public class CollectionMapper {

    public interface Collection<T> {
        Object get(T t);

        Iterator<T> keyIterator();

        void set(T t, Object obj, OnErrorListener onErrorListener);
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object obj);
    }

    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    public interface ValueMapper {
        void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener);
    }

    public static class a implements OnMapperCompleteListener {
        public final /* synthetic */ Mutable a;
        public final /* synthetic */ Mutable b;
        public final /* synthetic */ OnMapperCompleteListener c;

        public a(Mutable mutable, Mutable mutable2, OnMapperCompleteListener onMapperCompleteListener) {
            this.a = mutable;
            this.b = mutable2;
            this.c = onMapperCompleteListener;
        }

        @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
        public void onComplete() {
            if (!this.a.value.booleanValue()) {
                Mutable mutable = this.b;
                T t = (T) Integer.valueOf(mutable.value.intValue() - 1);
                mutable.value = t;
                if (t.intValue() == 0) {
                    this.c.onComplete();
                }
            }
        }

        @Override // com.facebook.internal.CollectionMapper.OnErrorListener
        public void onError(FacebookException facebookException) {
            if (!this.a.value.booleanValue()) {
                this.a.value = (T) Boolean.TRUE;
                this.c.onError(facebookException);
            }
        }
    }

    public static class b implements OnMapValueCompleteListener {
        public final /* synthetic */ Collection a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ OnMapperCompleteListener c;

        public b(Collection collection, Object obj, OnMapperCompleteListener onMapperCompleteListener) {
            this.a = collection;
            this.b = obj;
            this.c = onMapperCompleteListener;
        }

        @Override // com.facebook.internal.CollectionMapper.OnMapValueCompleteListener
        public void onComplete(Object obj) {
            this.a.set(this.b, obj, this.c);
            this.c.onComplete();
        }

        @Override // com.facebook.internal.CollectionMapper.OnErrorListener
        public void onError(FacebookException facebookException) {
            this.c.onError(facebookException);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.facebook.internal.CollectionMapper$Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void iterate(Collection<T> collection, ValueMapper valueMapper, OnMapperCompleteListener onMapperCompleteListener) {
        Mutable mutable = new Mutable(Boolean.FALSE);
        Mutable mutable2 = new Mutable(1);
        a aVar = new a(mutable, mutable2, onMapperCompleteListener);
        Iterator keyIterator = collection.keyIterator();
        LinkedList linkedList = new LinkedList();
        while (keyIterator.hasNext()) {
            linkedList.add(keyIterator.next());
        }
        for (Object obj : linkedList) {
            Object obj2 = collection.get(obj);
            b bVar = new b(collection, obj, aVar);
            mutable2.value = (T) Integer.valueOf(mutable2.value.intValue() + 1);
            valueMapper.mapValue(obj2, bVar);
        }
        aVar.onComplete();
    }
}

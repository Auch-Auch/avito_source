package de.ailis.pherialize;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
public class MixedArray extends LinkedHashMap<Object, Object> {
    private static final long serialVersionUID = -194078593900457504L;

    public MixedArray(int i, float f) {
        super(i, f);
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public boolean containsKey(Object obj) {
        if (obj instanceof Mixed) {
            return super.containsKey(obj);
        }
        return super.containsKey(new Mixed(obj));
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public boolean containsValue(Object obj) {
        if (obj instanceof Mixed) {
            return super.containsValue(obj);
        }
        return super.containsValue(new Mixed(obj));
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public Object get(Object obj) {
        if (obj instanceof Mixed) {
            return super.get(obj);
        }
        return super.get(new Mixed(obj));
    }

    public MixedArray getArray(Object obj) {
        return getMixed(obj).toArray();
    }

    public boolean getBoolean(Object obj) {
        return getMixed(obj).toBoolean();
    }

    public boolean getBooolean(Object obj) {
        return getMixed(obj).toBoolean();
    }

    public byte getByte(Object obj) {
        return getMixed(obj).toByte();
    }

    public char getChar(Object obj) {
        return getMixed(obj).toChar();
    }

    public double getDouble(Object obj) {
        return getMixed(obj).toDouble();
    }

    public float getFloat(Object obj) {
        return getMixed(obj).toFloat();
    }

    public int getInt(Object obj) {
        return getMixed(obj).toInt();
    }

    public long getLong(Object obj) {
        return getMixed(obj).toLong();
    }

    public Mixed getMixed(Object obj) {
        return (Mixed) get(obj);
    }

    public short getShort(Object obj) {
        return getMixed(obj).toShort();
    }

    public String getString(Object obj) {
        return getMixed(obj).toString();
    }

    public Object getType(Object obj, int i) {
        return getMixed(obj).toType(i);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public Object put(Object obj, Object obj2) {
        Mixed mixed;
        Mixed mixed2;
        if (!(obj instanceof Mixed)) {
            mixed = new Mixed(obj);
        } else {
            mixed = (Mixed) obj;
        }
        if (!(obj2 instanceof Mixed)) {
            mixed2 = new Mixed(obj2);
        } else {
            mixed2 = (Mixed) obj2;
        }
        return super.put(mixed, mixed2);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public Object remove(Object obj) {
        if (obj instanceof Mixed) {
            return super.remove(obj);
        }
        return super.remove(new Mixed(obj));
    }

    public MixedArray(int i) {
        super(i);
    }

    public MixedArray getArray(int i) {
        return getMixed(i).toArray();
    }

    public boolean getBoolean(int i) {
        return getMixed(i).toBoolean();
    }

    public boolean getBooolean(int i) {
        return getMixed(i).toBoolean();
    }

    public byte getByte(int i) {
        return getMixed(i).toByte();
    }

    public char getChar(int i) {
        return getMixed(i).toChar();
    }

    public double getDouble(int i) {
        return getMixed(i).toDouble();
    }

    public float getFloat(int i) {
        return getMixed(i).toFloat();
    }

    public int getInt(int i) {
        return getMixed(i).toInt();
    }

    public long getLong(int i) {
        return getMixed(i).toLong();
    }

    public Mixed getMixed(int i) {
        return (Mixed) get(i);
    }

    public short getShort(int i) {
        return getMixed(i).toShort();
    }

    public String getString(int i) {
        return getMixed(i).toString();
    }

    public Object getType(int i, int i2) {
        return getMixed(i).toType(i2);
    }

    public MixedArray() {
    }

    public MixedArray(Map<?, ?> map) {
        super(map);
    }

    public Object get(int i) {
        return get(new Mixed(i));
    }

    public MixedArray(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            put(new Mixed(i), it.next());
            i++;
        }
    }
}

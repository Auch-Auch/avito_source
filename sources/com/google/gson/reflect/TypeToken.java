package com.google.gson.reflect;

import com.avito.android.lib.design.input.FormatterType;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
public class TypeToken<T> {
    public final Class<? super T> a;
    public final Type b;
    public final int c;

    public TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            Type canonicalize = C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
            this.b = canonicalize;
            this.a = (Class<? super T>) C$Gson$Types.getRawType(canonicalize);
            this.c = canonicalize.hashCode();
            return;
        }
        throw new RuntimeException("Missing type parameter.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.reflect.Type r9, java.lang.reflect.ParameterizedType r10, java.util.Map<java.lang.String, java.lang.reflect.Type> r11) {
        /*
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r10.equals(r9)
            r2 = 1
            if (r1 == 0) goto L_0x000c
            return r2
        L_0x000c:
            java.lang.Class r1 = com.google.gson.internal.C$Gson$Types.getRawType(r9)
            r3 = 0
            boolean r4 = r9 instanceof java.lang.reflect.ParameterizedType
            if (r4 == 0) goto L_0x0018
            r3 = r9
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
        L_0x0018:
            if (r3 == 0) goto L_0x008d
            java.lang.reflect.Type[] r9 = r3.getActualTypeArguments()
            java.lang.reflect.TypeVariable[] r4 = r1.getTypeParameters()
            r5 = 0
        L_0x0023:
            int r6 = r9.length
            if (r5 >= r6) goto L_0x0045
            r6 = r9[r5]
            r7 = r4[r5]
        L_0x002a:
            boolean r8 = r6 instanceof java.lang.reflect.TypeVariable
            if (r8 == 0) goto L_0x003b
            java.lang.reflect.TypeVariable r6 = (java.lang.reflect.TypeVariable) r6
            java.lang.String r6 = r6.getName()
            java.lang.Object r6 = r11.get(r6)
            java.lang.reflect.Type r6 = (java.lang.reflect.Type) r6
            goto L_0x002a
        L_0x003b:
            java.lang.String r7 = r7.getName()
            r11.put(r7, r6)
            int r5 = r5 + 1
            goto L_0x0023
        L_0x0045:
            java.lang.reflect.Type r9 = r3.getRawType()
            java.lang.reflect.Type r4 = r10.getRawType()
            boolean r9 = r9.equals(r4)
            if (r9 == 0) goto L_0x0089
            java.lang.reflect.Type[] r9 = r3.getActualTypeArguments()
            java.lang.reflect.Type[] r3 = r10.getActualTypeArguments()
            r4 = 0
        L_0x005c:
            int r5 = r9.length
            if (r4 >= r5) goto L_0x0087
            r5 = r9[r4]
            r6 = r3[r4]
            boolean r7 = r6.equals(r5)
            if (r7 != 0) goto L_0x0080
            boolean r7 = r5 instanceof java.lang.reflect.TypeVariable
            if (r7 == 0) goto L_0x007e
            java.lang.reflect.TypeVariable r5 = (java.lang.reflect.TypeVariable) r5
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r11.get(r5)
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r5 = 0
            goto L_0x0081
        L_0x0080:
            r5 = 1
        L_0x0081:
            if (r5 != 0) goto L_0x0084
            goto L_0x0089
        L_0x0084:
            int r4 = r4 + 1
            goto L_0x005c
        L_0x0087:
            r9 = 1
            goto L_0x008a
        L_0x0089:
            r9 = 0
        L_0x008a:
            if (r9 == 0) goto L_0x008d
            return r2
        L_0x008d:
            java.lang.reflect.Type[] r9 = r1.getGenericInterfaces()
            int r3 = r9.length
        L_0x0092:
            if (r0 >= r3) goto L_0x00a5
            r4 = r9[r0]
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>(r11)
            boolean r4 = a(r4, r10, r5)
            if (r4 == 0) goto L_0x00a2
            return r2
        L_0x00a2:
            int r0 = r0 + 1
            goto L_0x0092
        L_0x00a5:
            java.lang.reflect.Type r9 = r1.getGenericSuperclass()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>(r11)
            boolean r9 = a(r9, r10, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.reflect.TypeToken.a(java.lang.reflect.Type, java.lang.reflect.ParameterizedType, java.util.Map):boolean");
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    public static TypeToken<?> getArray(Type type) {
        return new TypeToken<>(C$Gson$Types.arrayOf(type));
    }

    public static TypeToken<?> getParameterized(Type type, Type... typeArr) {
        return new TypeToken<>(C$Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.equals(this.b, ((TypeToken) obj).b);
    }

    public final Class<? super T> getRawType() {
        return this.a;
    }

    public final Type getType() {
        return this.b;
    }

    public final int hashCode() {
        return this.c;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.b);
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0067 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.reflect.Type, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    @Deprecated
    public boolean isAssignableFrom(Type type) {
        boolean z;
        if (type == 0) {
            return false;
        }
        if (this.b.equals(type)) {
            return true;
        }
        Type type2 = this.b;
        if (type2 instanceof Class) {
            return this.a.isAssignableFrom(C$Gson$Types.getRawType(type));
        }
        if (type2 instanceof ParameterizedType) {
            return a(type, (ParameterizedType) type2, new HashMap());
        }
        if (!(type2 instanceof GenericArrayType)) {
            Class[] clsArr = {Class.class, ParameterizedType.class, GenericArrayType.class};
            StringBuilder sb = new StringBuilder("Unexpected type. Expected one of: ");
            for (int i = 0; i < 3; i++) {
                sb.append(clsArr[i].getName());
                sb.append(", ");
            }
            sb.append("but got: ");
            sb.append(type2.getClass().getName());
            sb.append(", for type token: ");
            sb.append(type2.toString());
            sb.append(FormatterType.defaultDecimalSeparator);
            throw new AssertionError(sb.toString());
        } else if (!this.a.isAssignableFrom(C$Gson$Types.getRawType(type))) {
            return false;
        } else {
            Type genericComponentType = ((GenericArrayType) this.b).getGenericComponentType();
            if (genericComponentType instanceof ParameterizedType) {
                if (type instanceof GenericArrayType) {
                    type = ((GenericArrayType) type).getGenericComponentType();
                } else if (type instanceof Class) {
                    type = (Class) type;
                    while (type.isArray()) {
                        type = type.getComponentType();
                    }
                }
                z = a(type, (ParameterizedType) genericComponentType, new HashMap());
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
            return false;
        }
    }

    public TypeToken(Type type) {
        Type canonicalize = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type));
        this.b = canonicalize;
        this.a = (Class<? super T>) C$Gson$Types.getRawType(canonicalize);
        this.c = canonicalize.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }
}

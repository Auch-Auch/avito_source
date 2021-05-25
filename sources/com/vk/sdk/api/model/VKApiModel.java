package com.vk.sdk.api.model;

import android.os.Parcelable;
import android.util.SparseArray;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public abstract class VKApiModel implements Parcelable {
    public Object a;
    public SparseArray<Object> b;
    public JSONObject fields;

    public VKApiModel() {
    }

    public Object getTag() {
        return this.a;
    }

    public VKApiModel parse(JSONObject jSONObject) throws JSONException {
        VKList vKList;
        if (jSONObject.has(CommonKt.EXTRA_RESPONSE)) {
            jSONObject = jSONObject.optJSONObject(CommonKt.EXTRA_RESPONSE);
        }
        if (jSONObject != null) {
            Field[] fields2 = getClass().getFields();
            for (Field field : fields2) {
                boolean z = true;
                field.setAccessible(true);
                String name = field.getName();
                Class<?> type = field.getType();
                Object opt = jSONObject.opt(name);
                if (opt != null) {
                    try {
                        if (!type.isPrimitive() || !(opt instanceof Number)) {
                            Object obj = field.get(this);
                            if (!opt.getClass().equals(type)) {
                                if (type.isArray() && (opt instanceof JSONArray)) {
                                    opt = AppCompatDelegateImpl.i.s1((JSONArray) opt, type);
                                } else if (VKPhotoSizes.class.isAssignableFrom(type) && (opt instanceof JSONArray)) {
                                    opt = type.getConstructor(JSONArray.class).newInstance((JSONArray) opt);
                                } else if (!VKAttachments.class.isAssignableFrom(type) || !(opt instanceof JSONArray)) {
                                    if (VKList.class.equals(type)) {
                                        Class cls = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                                        if (VKApiModel.class.isAssignableFrom(cls) && Parcelable.class.isAssignableFrom(cls) && Identifiable.class.isAssignableFrom(cls)) {
                                            if (opt instanceof JSONArray) {
                                                vKList = new VKList((JSONArray) opt, cls);
                                            } else if (opt instanceof JSONObject) {
                                                vKList = new VKList((JSONObject) opt, cls);
                                            }
                                            opt = vKList;
                                        }
                                    } else if (VKApiModel.class.isAssignableFrom(type) && (opt instanceof JSONObject)) {
                                        opt = ((VKApiModel) type.newInstance()).parse((JSONObject) opt);
                                    }
                                    opt = obj;
                                } else {
                                    opt = type.getConstructor(JSONArray.class).newInstance((JSONArray) opt);
                                }
                            }
                            field.set(this, opt);
                        } else {
                            Number number = (Number) opt;
                            if (type.equals(Integer.TYPE)) {
                                field.setInt(this, number.intValue());
                            } else if (type.equals(Long.TYPE)) {
                                field.setLong(this, number.longValue());
                            } else if (type.equals(Float.TYPE)) {
                                field.setFloat(this, number.floatValue());
                            } else if (type.equals(Double.TYPE)) {
                                field.setDouble(this, number.doubleValue());
                            } else if (type.equals(Boolean.TYPE)) {
                                if (number.intValue() != 1) {
                                    z = false;
                                }
                                field.setBoolean(this, z);
                            } else if (type.equals(Short.TYPE)) {
                                field.setShort(this, number.shortValue());
                            } else if (type.equals(Byte.TYPE)) {
                                field.setByte(this, number.byteValue());
                            }
                        }
                    } catch (InstantiationException e) {
                        throw new JSONException(e.getMessage());
                    } catch (IllegalAccessException e2) {
                        throw new JSONException(e2.getMessage());
                    } catch (NoSuchMethodException e3) {
                        throw new JSONException(e3.getMessage());
                    } catch (InvocationTargetException e4) {
                        throw new JSONException(e4.getMessage());
                    } catch (NoSuchMethodError e5) {
                        throw new JSONException(e5.getMessage());
                    }
                }
            }
        }
        return this;
    }

    public void setTag(Object obj) {
        this.a = obj;
    }

    public VKApiModel(JSONObject jSONObject) throws JSONException {
        parse(jSONObject);
    }

    public Object getTag(int i) {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return sparseArray.get(i);
        }
        return null;
    }

    public void setTag(int i, Object obj) {
        if (this.b == null) {
            this.b = new SparseArray<>(2);
        }
        this.b.put(i, obj);
    }
}

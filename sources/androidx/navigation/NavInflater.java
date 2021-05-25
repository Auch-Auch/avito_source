package androidx.navigation;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgument;
import androidx.navigation.NavOptions;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
public final class NavInflater {
    public static final ThreadLocal<TypedValue> c = new ThreadLocal<>();
    public Context a;
    public NavigatorProvider b;

    public NavInflater(@NonNull Context context, @NonNull NavigatorProvider navigatorProvider) {
        this.a = context;
        this.b = navigatorProvider;
    }

    public static NavType a(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType == null || navType == navType2) {
            return navType != null ? navType : navType2;
        }
        StringBuilder W = a.W("Type is ", str, " but found ", str2, ": ");
        W.append(typedValue.data);
        throw new XmlPullParserException(W.toString());
    }

    @NonNull
    public final NavDestination b(@NonNull Resources resources, @NonNull XmlResourceParser xmlResourceParser, @NonNull AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        int i2;
        NavDestination createDestination = this.b.getNavigator(xmlResourceParser.getName()).createDestination();
        createDestination.onInflate(this.a, attributeSet);
        int i3 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == i3 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
                    String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
                    if (string != null) {
                        createDestination.addArgument(string, c(obtainAttributes, resources, i));
                        obtainAttributes.recycle();
                    } else {
                        throw new XmlPullParserException("Arguments must have a name");
                    }
                } else if ("deepLink".equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R.styleable.NavDeepLink);
                    String string2 = obtainAttributes2.getString(R.styleable.NavDeepLink_uri);
                    if (!TextUtils.isEmpty(string2)) {
                        createDestination.addDeepLink(string2.replace("${applicationId}", this.a.getPackageName()));
                        obtainAttributes2.recycle();
                    } else {
                        throw new IllegalArgumentException("Every <deepLink> must include an app:uri");
                    }
                } else {
                    if ("action".equals(name)) {
                        TypedArray obtainAttributes3 = resources.obtainAttributes(attributeSet, R.styleable.NavAction);
                        int resourceId = obtainAttributes3.getResourceId(R.styleable.NavAction_android_id, 0);
                        NavAction navAction = new NavAction(obtainAttributes3.getResourceId(R.styleable.NavAction_destination, 0));
                        NavOptions.Builder builder = new NavOptions.Builder();
                        builder.setLaunchSingleTop(obtainAttributes3.getBoolean(R.styleable.NavAction_launchSingleTop, false));
                        builder.setPopUpTo(obtainAttributes3.getResourceId(R.styleable.NavAction_popUpTo, -1), obtainAttributes3.getBoolean(R.styleable.NavAction_popUpToInclusive, false));
                        builder.setEnterAnim(obtainAttributes3.getResourceId(R.styleable.NavAction_enterAnim, -1));
                        builder.setExitAnim(obtainAttributes3.getResourceId(R.styleable.NavAction_exitAnim, -1));
                        builder.setPopEnterAnim(obtainAttributes3.getResourceId(R.styleable.NavAction_popEnterAnim, -1));
                        builder.setPopExitAnim(obtainAttributes3.getResourceId(R.styleable.NavAction_popExitAnim, -1));
                        navAction.setNavOptions(builder.build());
                        Bundle bundle = new Bundle();
                        int i4 = 1;
                        int depth3 = xmlResourceParser.getDepth() + 1;
                        int i5 = i;
                        while (true) {
                            int next2 = xmlResourceParser.next();
                            if (next2 == i4) {
                                i2 = depth2;
                                break;
                            }
                            int depth4 = xmlResourceParser.getDepth();
                            i2 = depth2;
                            if (depth4 < depth3 && next2 == 3) {
                                break;
                            }
                            if (next2 == 2 && depth4 <= depth3) {
                                if ("argument".equals(xmlResourceParser.getName())) {
                                    TypedArray obtainAttributes4 = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
                                    String string3 = obtainAttributes4.getString(R.styleable.NavArgument_android_name);
                                    if (string3 != null) {
                                        NavArgument c2 = c(obtainAttributes4, resources, i5);
                                        if (c2.isDefaultValuePresent() && c2.c) {
                                            c2.a.put(bundle, string3, c2.d);
                                        }
                                        obtainAttributes4.recycle();
                                    } else {
                                        throw new XmlPullParserException("Arguments must have a name");
                                    }
                                }
                                i5 = i;
                            }
                            depth2 = i2;
                            i4 = 1;
                        }
                        if (!bundle.isEmpty()) {
                            navAction.setDefaultArguments(bundle);
                        }
                        createDestination.putAction(resourceId, navAction);
                        obtainAttributes3.recycle();
                    } else {
                        i2 = depth2;
                        if ("include".equals(name) && (createDestination instanceof NavGraph)) {
                            TypedArray obtainAttributes5 = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                            ((NavGraph) createDestination).addDestination(inflate(obtainAttributes5.getResourceId(R.styleable.NavInclude_graph, 0)));
                            obtainAttributes5.recycle();
                        } else if (createDestination instanceof NavGraph) {
                            ((NavGraph) createDestination).addDestination(b(resources, xmlResourceParser, attributeSet, i));
                        }
                    }
                    depth2 = i2;
                    i3 = 1;
                }
                i2 = depth2;
                depth2 = i2;
                i3 = 1;
            }
        }
        return createDestination;
    }

    @NonNull
    public final NavArgument c(@NonNull TypedArray typedArray, @NonNull Resources resources, int i) throws XmlPullParserException {
        NavType<?> navType;
        NavArgument.Builder builder = new NavArgument.Builder();
        boolean z = false;
        builder.setIsNullable(typedArray.getBoolean(R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = c;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(R.styleable.NavArgument_argType);
        int i2 = null;
        NavType<Integer> fromArgType = string != null ? NavType.fromArgType(string, resources.getResourcePackageName(i)) : null;
        int i3 = R.styleable.NavArgument_android_defaultValue;
        if (typedArray.getValue(i3, typedValue)) {
            NavType<Integer> navType2 = NavType.ReferenceType;
            if (fromArgType == navType2) {
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    i2 = Integer.valueOf(i4);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    i2 = 0;
                } else {
                    StringBuilder L = a.L("unsupported value '");
                    L.append((Object) typedValue.string);
                    L.append("' for ");
                    L.append(fromArgType.getName());
                    L.append(". Must be a reference to a resource.");
                    throw new XmlPullParserException(L.toString());
                }
            } else {
                int i5 = typedValue.resourceId;
                if (i5 != 0) {
                    if (fromArgType == null) {
                        fromArgType = navType2;
                        i2 = Integer.valueOf(i5);
                    } else {
                        StringBuilder L2 = a.L("unsupported value '");
                        L2.append((Object) typedValue.string);
                        L2.append("' for ");
                        L2.append(fromArgType.getName());
                        L2.append(". You must use a \"");
                        L2.append(navType2.getName());
                        L2.append("\" type to reference other resources.");
                        throw new XmlPullParserException(L2.toString());
                    }
                } else if (fromArgType == NavType.StringType) {
                    i2 = typedArray.getString(i3);
                } else {
                    int i6 = typedValue.type;
                    if (i6 == 3) {
                        String charSequence = typedValue.string.toString();
                        if (fromArgType == null) {
                            try {
                                navType = NavType.IntType;
                                navType.parseValue(charSequence);
                            } catch (IllegalArgumentException unused) {
                                try {
                                    navType = NavType.LongType;
                                    navType.parseValue(charSequence);
                                } catch (IllegalArgumentException unused2) {
                                    try {
                                        navType = NavType.FloatType;
                                        navType.parseValue(charSequence);
                                    } catch (IllegalArgumentException unused3) {
                                        try {
                                            navType = NavType.BoolType;
                                            navType.parseValue(charSequence);
                                        } catch (IllegalArgumentException unused4) {
                                            navType = NavType.StringType;
                                        }
                                    }
                                }
                            }
                            fromArgType = navType;
                        }
                        i2 = fromArgType.parseValue(charSequence);
                    } else if (i6 == 4) {
                        fromArgType = a(typedValue, fromArgType, NavType.FloatType, string, Types.FLOAT);
                        i2 = Float.valueOf(typedValue.getFloat());
                    } else if (i6 == 5) {
                        fromArgType = a(typedValue, fromArgType, NavType.IntType, string, ViewHierarchyConstants.DIMENSION_KEY);
                        i2 = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i6 == 18) {
                        fromArgType = a(typedValue, fromArgType, NavType.BoolType, string, Types.BOOLEAN);
                        if (typedValue.data != 0) {
                            z = true;
                        }
                        i2 = Boolean.valueOf(z);
                    } else if (i6 < 16 || i6 > 31) {
                        StringBuilder L3 = a.L("unsupported argument type ");
                        L3.append(typedValue.type);
                        throw new XmlPullParserException(L3.toString());
                    } else {
                        fromArgType = a(typedValue, fromArgType, NavType.IntType, string, "integer");
                        i2 = Integer.valueOf(typedValue.data);
                    }
                }
            }
        }
        if (i2 != null) {
            builder.setDefaultValue(i2);
        }
        if (fromArgType != null) {
            builder.setType(fromArgType);
        }
        return builder.build();
    }

    @NonNull
    @SuppressLint({"ResourceType"})
    public NavGraph inflate(@NavigationRes int i) {
        int next;
        Resources resources = this.a.getResources();
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        while (true) {
            try {
                next = xml.next();
            } catch (Exception e) {
                throw new RuntimeException("Exception inflating " + resources.getResourceName(i) + " line " + xml.getLineNumber(), e);
            } catch (Throwable th) {
                xml.close();
                throw th;
            }
            if (next == 2 || next == 1) {
                break;
            }
        }
        if (next == 2) {
            String name = xml.getName();
            NavDestination b2 = b(resources, xml, asAttributeSet, i);
            if (b2 instanceof NavGraph) {
                NavGraph navGraph = (NavGraph) b2;
                xml.close();
                return navGraph;
            }
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        throw new XmlPullParserException("No start tag found");
    }
}

package com.nevermoe.xehook;

import java.io.InputStream;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;


/**
 * Created by nevermoe on 2018/06/11.
 */
public class XEHook implements IXposedHookLoadPackage {
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {

        if (!lpparam.packageName.equals("com.example.sslpinningexample"))
            return;

        XposedBridge.log("Loaded app: " + lpparam.packageName);

        try {
            XposedHelpers.findAndHookMethod("android.app.Application", lpparam.classLoader,
                    "onCreate", new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws
                                Throwable {
                            NativeHook.initNativeHook();
                        }
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws
                                Throwable {
                        }
                    });
        } catch (Throwable e){
            XposedBridge.log("hook failed");
            XposedBridge.log(e);
        }


    }
}
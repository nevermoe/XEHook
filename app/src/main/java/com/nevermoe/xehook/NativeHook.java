package com.nevermoe.xehook;

/**
 * Created by nevermoe on 2018/06/11.
 */

public class NativeHook {

    public static final String PACKAGE_NAME = "com.nevermoe.xehook";
    public static final String NATIVE_LIB = "nativehook";
    public static final String NATIVE_LIB_PATH = String.format("/data/data/%s/lib/lib%s.so",
            PACKAGE_NAME, NATIVE_LIB);

    static{
        System.load(NATIVE_LIB_PATH);
    }
    public native static void initNativeHook();
}
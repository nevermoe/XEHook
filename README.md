# XEHook
Emulator Hooking Framework based on Xposed

# Usage
1. Modify `XEHook.java` to filter which app you want to hook: [https://github.com/nevermoe/XEHook/blob/master/app/src/main/java/com/nevermoe/xehook/XEHook.java#L19](https://github.com/nevermoe/XEHook/blob/master/app/src/main/java/com/nevermoe/xehook/XEHook.java#L19)
2. modify `nativehook.c` to hook functions: [https://github.com/nevermoe/XEHook/blob/master/app/src/jni/nativehook.c#L59](https://github.com/nevermoe/XEHook/blob/master/app/src/jni/nativehook.c#L59)
3. Build using `./gradlew assembleDebug`
4. Install the apk file as an Xposed module as usual.

# Notice
1. You may have to call dlopen in `nativehook.c` first if the native library is not loaded yet.
2. Use path like "nb/libc.so" to eliminate ambiguity because there are two architectures' libc. 

Refer to [EHOOK](https://github.com/nevermoe/EHOOK) for more information.

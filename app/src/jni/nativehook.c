//
// Created by nevermoe on 2018/06/11.
//

#include <stdio.h>
#include <jni.h>
#include "hook.h"


void inject();

JNIEXPORT void JNICALL
Java_com_nevermoe_xehook_NativeHook_initNativeHook( JNIEnv* env, jobject thiz)
{
    LOGD("initNativeHook");

    void* handler = dlopen("libc.so", RTLD_NOW);
    if(handler == NULL){
        LOGD("dlopen libc.so failed");
        return;
    }
    else {
        LOGD("libc.so addr is 0x%x", ((struct soinfo*)handler)->base );
    }

    inject();
}


static struct hook_t eph_sendto;

int hook_sendto(int p0,int p1,int p2,int p3)
{
    int (*orig_func)(int p0,int p1,int p2,int p3);
    orig_func = (void*)eph_sendto.proto;

    LOGD("hook_sendto 0x%x\n", (unsigned int)(eph_sendto.target_addr-eph_sendto.module_base));

    int ret = orig_func(p0,p1,p2,p3);

    return ret;
}

//static void inject() __attribute__((constructor));

void inject()
{
    LOGD("inject called\n");

    //long target_addr = 0;

    //target_addr = 0x590f0;//sendto

    /*Bluestacks*/
    //hook_by_addr(&eph_sendto, "arm/libc.so", target_addr, hook_sendto);
    //hook_by_name(&eph_recvfrom, "arm/libc.so", "recvfrom", hook_recvfrom);

    /*Other emulators*/
    hook_by_name(&eph_sendto, "nb/libc.so", "sendto", hook_sendto);
    //hook_by_name(&eph_recvfrom, "nb/libc.so", "recvfrom", hook_recvfrom);

    LOGD("inject ended\n");

}
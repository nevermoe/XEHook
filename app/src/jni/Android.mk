LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := hook
LOCAL_SRC_FILES := hook.c

include $(BUILD_STATIC_LIBRARY)

###########################################################

include $(CLEAR_VARS)
LOCAL_MODULE    := relocate
LOCAL_SRC_FILES := relocate.c

include $(BUILD_STATIC_LIBRARY)

###########################################################


include $(CLEAR_VARS)
LOCAL_DISABLE_FATAL_LINKER_WARNINGS := true
LOCAL_MODULE    := nativehook
LOCAL_SRC_FILES := nativehook.c
LOCAL_LDLIBS := -llog
LOCAL_STATIC_LIBRARIES := hook relocate

include $(BUILD_SHARED_LIBRARY)

###########################################################
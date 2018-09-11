# 不再维护
# Sensors Analytics

This is the official Android SDK for Sensors Analytics.

## Easy Installation

 __Gradle 编译环境（Android Studio）__

第一步：在 **project** 级别的 build.gradle 文件中添加 Sensors Analytics android-gradle-plugin 依赖：

```android
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'
        //添加 Sensors Analytics android-gradle-plugin 依赖
        classpath 'com.sensorsdata.analytics.android:android-gradle-plugin:1.1.1'
    }
}

allprojects {
    repositories {
        jcenter()
    }
}
```

第二步：在 **主 module** 的 build.gradle 文件中添加 com.sensorsdata.analytics.android 插件、Sensors Analytics SDK 依赖：

```android
apply plugin: 'com.android.application'
//添加 com.sensorsdata.analytics.android 插件
apply plugin: 'com.sensorsdata.analytics.android'

dependencies {
   compile 'com.android.support:appcompat-v7:25.1.1'
   //添加 Sensors Analytics SDK 依赖
   compile 'com.sensorsdata.analytics.android:SensorsAnalyticsSDK:1.8.5'
}
```

第三步：添加 Sensors Analytics SDK 需要的权限

修改 `app/src/main/AndroidManifest.xml`，添加 Sensors Analytics SDK 需要的权限:

```xml
	<!-- 同步数据需要网络权限 -->
    <uses-permission android:name="android.permission.INTERNET" />
    <!-- 获取网络状态 -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <!-- 获取运营商信息 -->
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

第四步：由于 SDK 会依赖 appcompat-v7 处理下面几个控件：

* android.support.v7.widget.SwitchCompat
* android.support.v7.app.AlertDialog

需要添加下面依赖( 如果项目中已引入了 v7包，可以不添加 )：

```android
compile 'com.android.support:appcompat-v7:25.1.1'
```

Android SDK 要求最低系统版本为 API 11（Android 3.0），特别地，AutoTrack功能要求系统最低版本为 API 14 （Android 4.0），可视化埋点功能要求最低系统版本为 API 16（Android 4.1）。目前，Android SDK (aar格式) 大小约为 230 KB。

**注：** 由于 SDK 中有一部分类或方法是被 javascript 调用的，再加上 SDK 的源码本身就是开源的，所以建议不要混淆 Android SDK。

如果开启了混淆，请在proguard文件中添加下边代码：

```
-dontwarn com.sensorsdata.analytics.android.sdk.**
-keep class com.sensorsdata.analytics.android.sdk.** {
*;
}
-keep class **.R$* {
    <fields>;
}
-keep public class * extends android.content.ContentProvider 
-keepnames class * extends android.view.View

-keep class * extends android.app.Fragment {
 public void setUserVisibleHint(boolean);
 public void onHiddenChanged(boolean);
 public void onResume();
 public void onPause();
}
-keep class android.support.v4.app.Fragment {
 public void setUserVisibleHint(boolean);
 public void onHiddenChanged(boolean);
 public void onResume();
 public void onPause();
}
-keep class * extends android.support.v4.app.Fragment {
 public void setUserVisibleHint(boolean);
 public void onHiddenChanged(boolean);
 public void onResume();
 public void onPause();
}

```

## To Learn More

See our [full manual](http://www.sensorsdata.cn/manual/android_sdk.html)

## For Java Developers

We also maintains a SDK for Java at 

    https://github.com/sensorsdata/sa-sdk-java
   
## 感谢
[mixpanel-android](https://github.com/mixpanel/mixpanel-android) 

## License

Copyright 2015－2017 Sensors Data Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

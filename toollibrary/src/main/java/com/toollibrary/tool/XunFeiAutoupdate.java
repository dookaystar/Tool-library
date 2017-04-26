package com.toollibrary.tool;

import android.content.Context;
import android.util.Log;

import com.iflytek.autoupdate.IFlytekUpdate;
import com.iflytek.autoupdate.IFlytekUpdateListener;
import com.iflytek.autoupdate.UpdateConstants;
import com.iflytek.autoupdate.UpdateErrorCode;
import com.iflytek.autoupdate.UpdateInfo;
import com.iflytek.autoupdate.UpdateType;

/**
 * Created by 李双 on 2017/3/17.
 */

public class XunFeiAutoupdate {
    static IFlytekUpdate updManager;

    public static void Autoupdate(Context context, boolean bool) {
        updManager = IFlytekUpdate.getInstance(context);
//开启调试模式，默认不开启
        updManager.setDebugMode(true);
//开启wifi环境下检测更新，仅对自动更新有效，强制更新则生效
        updManager.setParameter(UpdateConstants.EXTRA_WIFIONLY, "true");
//设置通知栏使用应用icon，详情请见示例
        updManager.setParameter(UpdateConstants.EXTRA_NOTI_ICON, "true");
//设置更新提示类型，默认为通知栏提示
        updManager.setParameter(UpdateConstants.EXTRA_STYLE, UpdateConstants.UPDATE_UI_DIALOG);
        if (bool) {
            updManager.forceUpdate(context, new UpdateIFlyt(context));
        } else {
            updManager.autoUpdate(context, new UpdateIFlyt(context));
        }

    }

    public static class UpdateIFlyt implements IFlytekUpdateListener {
        Context context;

        public UpdateIFlyt(Context contextact) {
            context = contextact;

        }

        @Override
        public void onResult(int i, UpdateInfo updateInfo) {
            if (i == UpdateErrorCode.OK && updateInfo != null) {
                if (updateInfo.getUpdateType() == UpdateType.NoNeed) {

                    Log.e("error", "已经是最新版本!");
                    return;
                }
                updManager.showUpdateInfo(context, updateInfo);
            } else {
                Log.e("error", "请求更新失败");

                // showTip("请求更新失败！\n更新错误码：" + errorcode);
            }
        }
    }
}

package com.minimajack.urovo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;

import android.device.DeviceManager;
import android.device.ScanManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

public class Urovo extends CordovaPlugin{

    protected static final String LOG_TAG = "Urovo";
	private static DeviceManager mDevice;
	private static ScanManager mScanManager;
	{
		mDevice = new DeviceManager();
		mScanManager = new ScanManager();
        mScanManager.openScanner(); 
	}
	
     public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startScan")) {
            Log.v(LOG_TAG, "startScan");
			mScanManager.startDecode();
            PluginResult result = new PluginResult(PluginResult.Status.OK);
			result.setKeepCallback(false); // release status callback in JS side
			callbackContext.sendPluginResult(result);
			callbackContext = null;
			return true;
        }
        else if (action.equals("stopScan")) {
            Log.v(LOG_TAG, "stopScan");
			mScanManager.stopDecode();
            PluginResult result = new PluginResult(PluginResult.Status.OK);
			result.setKeepCallback(false); // release status callback in JS side
			callbackContext.sendPluginResult(result);
			callbackContext = null;
			return true;
        }
        return false;
    }
   
}

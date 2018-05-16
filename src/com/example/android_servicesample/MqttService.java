package com.example.android_servicesample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MqttService extends Service {
	private MqttServiceListener onListener = null;

	public interface MqttServiceListener {
		public void onTest(final long val);
	};

	public class LocalBinder extends Binder {
		MqttService getService() {
			return MqttService.this;
		}
	}

	private LocalBinder mLocBin = new LocalBinder();

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return mLocBin;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		// TODO Auto-generated method stub
		Log.d("TTTTT", "onCreate()");

		
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d("TTTTT", "onStartCommand()");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// TODO Auto-generated method stub
	}

	public void setListener(MqttServiceListener listener) {
		Log.d("TTTTT", "setListener()");
		onListener = listener;
	}

}
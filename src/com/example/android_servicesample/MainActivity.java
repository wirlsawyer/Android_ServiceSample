package com.example.android_servicesample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.example.android_servicesample.MqttService.MqttServiceListener;


public class MainActivity extends Activity {

	final private String LOG_TAG = "TTTTT";

	private MqttService mMqttService = null;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	
		mMqttService = null;
		
		Intent intent = new Intent(MainActivity.this, MqttService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE); 
	}

	private ServiceConnection mServiceConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder serviceBinder) {
			// TODO Auto-generated method stub
			Log.d(LOG_TAG, "onServiceConnected()" + name.getClassName());
			mMqttService = ((MqttService.LocalBinder) serviceBinder)
					.getService();
			mMqttService.setListener(onServiceEvent);			
		}

		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d(LOG_TAG, "onServiceDisconnected()" + name.getClassName());
		}
	};
	
	private MqttServiceListener onServiceEvent = new MqttServiceListener() {
		
		@Override
		public void onTest(long val) {
			// TODO Auto-generated method stub
			Log.v("TTTTT", String.valueOf(val));
		}
	};
}

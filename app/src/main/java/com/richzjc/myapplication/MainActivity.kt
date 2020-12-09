package com.richzjc.myapplication

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleRegistry

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val dialog = TestDialog()
//        dialog.show(supportFragmentManager, "testDialog")
        val lifecycleRegistry = lifecycle as LifecycleRegistry
        val state = lifecycleRegistry.currentState
        Log.i("state", "oncreate : " + state.name)
        val receiver = TestReceiver()
        val filter = IntentFilter()
        filter.addAction("android.intent.action.DATE_CHANGED")
        registerReceiver(receiver, filter)
    }

    override fun onStart() {
        super.onStart()
        val lifecycleRegistry = lifecycle as LifecycleRegistry
        val state = lifecycleRegistry.currentState
        Log.i("state", "onStart : " + state.name)
    }


    override fun onResume() {
        super.onResume()
        val lifecycleRegistry = lifecycle as LifecycleRegistry
        val state = lifecycleRegistry.currentState
        Log.i("state", "onResume : " + state.name)
    }


    override fun onPause() {
        super.onPause()
        val lifecycleRegistry = lifecycle as LifecycleRegistry
        val state = lifecycleRegistry.currentState
        Log.i("state", "onPause : " + state.name)
    }

    override fun onStop() {
        super.onStop()
        val lifecycleRegistry = lifecycle as LifecycleRegistry
        val state = lifecycleRegistry.currentState
        Log.i("state", "onStop : " + state.name)
    }

    override fun onDestroy() {
        super.onDestroy()
        val lifecycleRegistry = lifecycle as LifecycleRegistry
        val state = lifecycleRegistry.currentState
        Log.i("state", "onDestroy : " + state.name)
    }
}

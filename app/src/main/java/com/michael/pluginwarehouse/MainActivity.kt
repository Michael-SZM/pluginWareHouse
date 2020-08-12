package com.michael.pluginwarehouse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val TAG = "test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnTestClickListener).setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(TAG,"-------btnTestClickListener------")
            }

        })
        findViewById<Button>(R.id.btnTestBackLamba).setOnClickListener { Log.d(TAG,"-------btnTestBackLamba------") }

        findViewById<Button>(R.id.btnTestBlock).setOnClickListener {
            Log.d(TAG,"-------btnTestBlock------")
        }
    }
}
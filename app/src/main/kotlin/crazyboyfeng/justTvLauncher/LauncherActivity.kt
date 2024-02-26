package crazyboyfeng.justTvLauncher

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.FragmentActivity


class LauncherActivity : FragmentActivity() {

    private lateinit var msgText: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        msgText = findViewById(R.id.screen_number_text_view)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        handleIntent(intent)

        // Retrieve the stored value from SharedPreferences
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        // Handle the new intent when it's delivered to the activity
        handleIntent(intent)
    }

    companion object {
        var screenID = ""
    }

    private fun saveValue(value: String) {
        val editor = sharedPreferences.edit()
        editor.putString("screen_number", value)
        editor.apply()
    }

    private fun handleIntent(intent: Intent?)  {
        var receivedValue = intent?.getStringExtra("screen_number")
        if (receivedValue != null) {
            saveValue(receivedValue)
            Log.d("Constants.screenID", "Received value: $receivedValue")

        } else {
            Log.e("Constants.screenID", "No value received")
        }

        try {

            msgText.setText(receivedValue);
        } catch ( e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getValue(): String? {
        return sharedPreferences.getString("screen_number", null)
    }

    override fun onBackPressed() {}
}
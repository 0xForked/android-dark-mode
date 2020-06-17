package id.bakode.darkmode

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appSettingPreferences: SharedPreferences =
            getSharedPreferences("AppSettingPrefs", 0)

        val sharedPreferencesEdit: SharedPreferences.Editor =
            appSettingPreferences.edit()

        val isNightModeOn: Boolean =
            appSettingPreferences.getBoolean("NightMode", false)

        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            btn_switch.text = getString(R.string.btn_dark_disable)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            btn_switch.text = getString(R.string.btn_dark_enable)
        }

        btn_switch.setOnClickListener {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferencesEdit.putBoolean("NightMode", false)
                sharedPreferencesEdit.apply()
                btn_switch.text = getString(R.string.btn_dark_enable)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferencesEdit.putBoolean("NightMode", true)
                sharedPreferencesEdit.apply()
                btn_switch.text = getString(R.string.btn_dark_disable)
            }
        }
    }
}
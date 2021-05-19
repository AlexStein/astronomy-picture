package ru.softmine.astronomypicture.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.softmine.astronomypicture.ui.picture.PictureOfTheDayFragment
import ru.softmine.astronomypicture.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }
}
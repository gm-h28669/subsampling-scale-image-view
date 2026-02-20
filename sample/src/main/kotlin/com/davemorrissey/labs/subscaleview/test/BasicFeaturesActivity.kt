package com.davemorrissey.labs.subscaleview.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davemorrissey.labs.subscaleview.test.databinding.PagesActivityBinding

class BasicFeaturesActivity : AppCompatActivity() {

    private lateinit var binding: PagesActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = PagesActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.basic_title)
        // binding.imageView.orientation = 90
        binding.imageView.setImage("/android_asset/Img0216.jpg")
        // binding.imageView.setImage("/android_asset/P1040281.jpg")
        // binding.imageView.setImage("/android_asset/P1050733.jpg")
    }
}

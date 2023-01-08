package com.v2.babelfish.pokedex

import android.os.Bundle
import com.v2.babelfish.pokedex.feature.landing.view.LandingFragment
import com.v2.babelfish.ui.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LandingFragment.newInstance())
                .commitNow()
        }
    }
}
package pe.edu.upc.gdsg.countriesatlas.controllers.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_on_boarding.*
import pe.edu.upc.gdsg.countriesatlas.R
import kotlin.math.log
import android.content.res.Configuration.*
import android.widget.ImageView

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        setSupportActionBar(toolbar)

        val startButton: Button = findViewById(R.id.start_buttom);
        startButton.setOnClickListener {v -> startActivity(Intent(v.context, MainActivity::class.java))}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_on_boarding, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }




    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        Log.d( "Atlas", if (newConfig!!.orientation == ORIENTATION_PORTRAIT ) "Portrait" else "Landscape")

        var pictureImageView: ImageView = findViewById(R.id.picture)
        pictureImageView.setImageResource(if (   newConfig.orientation == ORIENTATION_PORTRAIT ) {R.drawable.unknown} else {R.drawable.landsscape})
    }
}


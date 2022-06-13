package com.code.amazinghealth.Data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.code.amazinghealth.Data.SharedObjects.animalindex
import com.code.amazinghealth.Data.SharedObjects.index
import com.code.amazinghealth.Data.SharedObjects.nicequotes
import com.code.amazinghealth.Data.SharedObjects.nqindex
import com.code.amazinghealth.Data.SharedObjects.quotelist
import com.code.amazinghealth.Data.SharedObjects.themellist
import com.code.amazinghealth.MainActivity
import com.code.amazinghealth.R
import pl.droidsonroids.gif.GifImageView
import java.util.*
//Global ibject that is used to store data
object SharedObjects {
    var index = 0
    var animalindex =0
    var nqindex = 0
    val amllist = listOf(R.drawable.cat, R.drawable.cat, R.drawable.shiba)
    val themellist = listOf(
        R.drawable.appgif1,
        R.drawable.appgif2,
        R.drawable.appgif3,
        R.drawable.appgif4,
        R.drawable.appgif5
    )
    val quotelist = listOf(
        "\"Don't let  Grant beat you, outrun him!\"",
        " \"It's bunny time, go out there and jump around!\"",
        " \"Backflip week, go treat yourself to a trampoline park!\"",
        "\"Hee-yah, go out and try boxing or karate!\"",
        " \"End this week with a kick, go out and play something with your legs!\"",
        "")
    var nicequotes = listOf("\"You can do anything if you put your mind to it.\"",
        "\"The past is history, tomorrow is a mystery, and today is a gift, which is why we call it the present\"",
        " \"Sometimes it's not about the destination, it's about the hard work we put in and the friends we made along the way.\"",
        "\"Winning doesn't always mean getting first place ; It means getting the best out of yourself.\"",
        "\"One run can change your day, many runs can change your life.\"",
        "\"The miracle isn’t that I finished my run. The miracle is that I had the courage to start it.\"",
                "\"Running is the greatest metaphor for life, because you get out of it what you put into it.\"")


}
//First Class
class Popup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        fun numbergenerator(): Int {
            val time = Calendar.getInstance().time.seconds
            var radnum = (0..time).random()
            when (radnum % 4) {
                0 -> (return 0)
                1 -> (return 1)
                2 -> (return 2)
                3 -> (return 3)
                else -> {
                    (return 4)
                }
            }
        }
        SharedObjects.index = numbergenerator()
        animalindex = numbergenerator()
        nqindex = numbergenerator()*2
        if (animalindex <= 3)
        {
            animalindex = 2
        }
        else if (nqindex == 8){
            animalindex--
        }
        var themequote = findViewById<TextView>(R.id.themequote)
        var quote: String = quotelist.get(index)
        themequote.text = quote
        var gifdisplay2 = findViewById<GifImageView>(R.id.gifdisplay2)
        gifdisplay2.setImageResource(themellist.get(index))
        var dismissbutton = findViewById<Button>(R.id.dismissbutton)
        dismissbutton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
    }


    }
}
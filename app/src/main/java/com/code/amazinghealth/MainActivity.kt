package com.code.amazinghealth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.code.amazinghealth.Data.SharedObjects.amllist
import com.code.amazinghealth.Data.SharedObjects.animalindex
import com.code.amazinghealth.Data.SharedObjects.index
import com.code.amazinghealth.Data.SharedObjects.nicequotes
import com.code.amazinghealth.Data.SharedObjects.quotelist
import com.code.amazinghealth.Data.SharedObjects.themellist
import pl.droidsonroids.gif.GifImageView
import java.util.Calendar




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       /* fun numbergenerator(): Int {
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
        }*/



        fun setTime(): String {
            val time = Calendar.getInstance().time.hours.toInt()
            when (time) {
                0, 1, 2, 3 -> return "Go to bed soon "
                4, 5, 6, 7, 8, 9, 10, 11, 12 -> return "Good Morning!"
                13, 14, 15, 16, 17 -> return "Good Afternoon!"
                else -> {
                    return "Good Evening!"
                }

            }
        }

        fun photoandquotes() {
            var welcomemessage = findViewById<TextView>(R.id.welcomemessage)
            welcomemessage.text = setTime()
            var textView1 = findViewById<TextView>(R.id.textView)
            var quote: String = nicequotes.get(index)
            textView1.text = quote
            var gifdisplay = findViewById<GifImageView>(R.id.gifdisplay)
            gifdisplay.setImageResource(themellist.get(index))
            var urdayicon1 = findViewById<ImageView>(R.id.urdayicon1)
            urdayicon1.setImageResource(amllist.get(animalindex))

        }
            setContentView(R.layout.fragment_home)
            photoandquotes()
            var savebutton = findViewById<ImageButton>(R.id.savebutton)
            savebutton.setOnClickListener() {
                var numberofstepsinput = findViewById<EditText>(R.id.numberofstepsinput)
                var waterinput = findViewById<EditText>(R.id.waterinput)
                var howsurdayinput = findViewById<EditText>(R.id.howsurdayinput)
                setContentView(R.layout.fragment_history)
                val walkingtextoutputbox = findViewById<TextView>(R.id.walkingtextoutputbox)
                walkingtextoutputbox.text = (numberofstepsinput.text.toString() + " Steps")
                val watertextoutputbox = findViewById<TextView>(R.id.watertextoutputbox)
                watertextoutputbox.text = (waterinput.text.toString() + " Cups of Water")
                val urdaytextoutputbox = findViewById<TextView>(R.id.urdaytextoutputbox)
                urdaytextoutputbox.text = ("It was an " + howsurdayinput.text.toString() + " Day")
                var back = findViewById<Button>(R.id.back)
                var urdayicon2 = findViewById<ImageView>(R.id.urdayicon2)
                urdayicon2.setImageResource(amllist.get(animalindex))
                back.setOnClickListener() {
                   val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }



















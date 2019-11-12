package com.example.lookin


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.HORIZONTAL
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.info1.*
import kotlinx.android.synthetic.main.info3.*


class Info1Activity : AppCompatActivity(){

    private val onImageClick2 = { resId: Int ->
        val intent = Info3Activity.createIntent(this, resId)
        startActivity(intent)
    }

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                 setContentView(R.layout.info1)


        val MoodView = findViewById<View>(R.id.MoodView) as RecyclerView
        val FoodView = findViewById<View>(R.id.FoodView) as RecyclerView
        val DrinkView = findViewById<View>(R.id.DrinkView) as RecyclerView
        val DessertView = findViewById<View>(R.id.FourView) as RecyclerView


        val MoodPhoto = intArrayOf(
            R.drawable.mood11, R.drawable.mood19, R.drawable.mood12, R.drawable.mood14,
            R.drawable.mood19, R.drawable.mood14, R.drawable.mood11
        )

        val FoodPhoto = intArrayOf(
            R.drawable.food15, R.drawable.food14, R.drawable.food13, R.drawable.food11,
            R.drawable.food14, R.drawable.food15, R.drawable.food14)

        val DrinkPhoto = intArrayOf(
            R.drawable.drink11, R.drawable.drink12, R.drawable.drink13, R.drawable.drink14,
            R.drawable.drink14, R.drawable.drink16, R.drawable.drink15,  R.drawable.drink18,
            R.drawable.drink19, R.drawable.drink15, R.drawable.drink
        )

        val DessertPhoto = intArrayOf(
            R.drawable.dessert11, R.drawable.dessert12, R.drawable.dessert13, R.drawable.dessert14,
            R.drawable.dessert17, R.drawable.dessert18, R.drawable.dessert15, R.drawable.dessert16,
            R.drawable.dessert19
        )

        val MoodManager = GridLayoutManager(this, 1, HORIZONTAL, false)
        val FoodManager = GridLayoutManager(this, 1, HORIZONTAL, false)
        val DrinkManager = GridLayoutManager(this, 1, HORIZONTAL, false)
        val DessertManager = GridLayoutManager(this, 1, HORIZONTAL, false)

        MoodView.apply {
            layoutManager = MoodManager
            adapter = InfoAdapter(MoodPhoto, this@Info1Activity, onImageClick2)
        }
        FoodView.apply {
            layoutManager = FoodManager
            adapter = InfoAdapter(FoodPhoto, this@Info1Activity, onImageClick2)
        }

        DrinkView.apply {
            layoutManager = DrinkManager
            adapter = InfoAdapter(DrinkPhoto, this@Info1Activity, onImageClick2)
        }

        DessertView.apply {
            layoutManager =DessertManager
            adapter = InfoAdapter(DessertPhoto, this@Info1Activity, onImageClick2)
        }


        closeButton.setOnClickListener {
            finish()
        }



    }
    companion object {
        private const val PHOTO: String = "photo"

        fun CreateIntent(activity: Activity, @DrawableRes photo: Int) =
            Intent(activity, Info1Activity::class.java).apply {
                putExtra(PHOTO, photo)
            }
    }
}

package com.example.aplikasidadu

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Calls the button id
        val rollBtn: Button = findViewById(R.id.btn_roll)

        // Calls the image view id
        val diceImgFirst: ImageView = findViewById(R.id.iv_img_first)
        val diceImgSecond: ImageView = findViewById(R.id.iv_img_second)

        diceImgFirst.setImageResource(R.drawable.empty_dice)
        diceImgSecond.setImageResource(R.drawable.empty_dice)
        // Create a function to capture once the button is clicked
        rollBtn.setOnClickListener {
            // Do a dice roll when the app starts
            rollDice()
        }
    }

    // initiate rollDice method
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()

        // Find the ImageView in the layout
        val diceImgFirst: ImageView = findViewById(R.id.iv_img_first)
        val diceImgSecond: ImageView = findViewById(R.id.iv_img_second)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResourceFirst = when (diceRoll1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResourceSecond = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImgFirst.setImageResource(drawableResourceFirst)
        diceImgSecond.setImageResource(drawableResourceSecond)

        // Update the content description
        diceImgFirst.contentDescription = diceRoll1.toString()
        diceImgSecond.contentDescription = diceRoll2.toString()

        if (diceRoll1 != diceRoll2) {
            Toast.makeText(this, "Anda belum beruntung", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Selamat anda dapat dadu double", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.blackjack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.blackjack.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var deck = ArrayList<Cards>()
    private var playerHands = ArrayList<Cards>()
    private var dealerHands = ArrayList<Cards>()
    private var playerSum = 0
    private var dealerSum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val start = binding.start
        val hit = binding.hit
        val stand = binding.stand
        val fold = binding.fold
        val result = binding.result
        val player = binding.playerSum
        val dealer = binding.dealerSum

        hit.visibility = View.GONE
        stand.visibility = View.GONE
        fold.visibility = View.GONE
        result.visibility = View.GONE

        start.setOnClickListener {
            result.text = ""
            playerHands.clear()
            dealerHands.clear()
            deck.clear()
            deck.addAll(Cards.values())
            deck.shuffle()
            playerSum = playerHands.hit(2).count()
            dealerSum = dealerHands.hit(2).count()
            player.text = "あなたの手札は${playerHands.show()}\n合計は${playerSum}です"
            dealer.text = "ディーラーの手札は${dealerHands.show()}\n合計で${dealerSum}です"
            if (playerSum == 21) {
                open()
            } else {
                hit.visibility = View.VISIBLE
                stand.visibility = View.VISIBLE
                fold.visibility = View.VISIBLE
            }
        }

        hit.setOnClickListener{
            playerSum = playerHands.hit().count()
            player.text = "あなたの手札は${playerHands.show()}\n合計は${playerSum}です"
            if(playerSum > 21) finish("プレイヤーがバーストしました")
            if(playerSum == 21) open()
        }

        stand.setOnClickListener {
            while(dealerSum < 17){
                dealerSum = dealerHands.hit().count()
            }
            dealer.text = "ディーラーの手札は${dealerHands.show()}\n合計で${dealerSum}です"
            if(dealerSum > 21) finish("ディーラーがバーストしました")
            else open()
        }

        fold.setOnClickListener {
            finish("プレイヤーが勝負を降りました")
        }
    }

    private fun ArrayList<Cards>.hit(count: Int = 1): ArrayList<Cards>{
        for(c in 0 until count){
            this.add(deck[0])
            deck.removeFirst()
        }
        return this
    }

    private fun ArrayList<Cards>.count(): Int {
        var sum = 0
        for (c in 0 until this.size) {
            sum += if(this[c].num>10){
                10
            }else{
                this[c].num
            }
        }
        val sortedHands = this.sortedWith(compareBy{it.num}).first()
        if (sortedHands.num == 0) sum = 21
        if (sortedHands.num == 1 && sum < 12) sum += 10
        return sum
    }

    private fun ArrayList<Cards>.show(): String{
        var text = ""
        this.forEach { text += "${it.image}と" }
        return "${text.dropLast(1)}です"
    }

    private fun open(){
        if(playerSum == dealerSum){
            val sortedPlayer = playerHands.sortedWith(compareBy{it.num}).last()
            val sortedDealer = dealerHands.sortedWith(compareBy{it.num}).last()
            when{
                sortedPlayer.num > sortedDealer.num -> playerSum += 2
                sortedDealer.num > sortedPlayer.num -> dealerSum += 2
            }
            //suit joker:5 spade:4 heart:3 diamond:2 clover:1
            when{
                sortedPlayer.suit > sortedDealer.suit -> playerSum += 1
                sortedDealer.suit > sortedPlayer.suit -> dealerSum += 1
            }
        }
        when {
            playerSum > dealerSum -> finish("プレイヤーの勝利です")
            dealerSum > playerSum -> finish("ディーラーの勝利です")
            playerSum == dealerSum -> finish("引き分けです")
        }
    }

    private fun finish(result: String){
        binding.hit.visibility = View.GONE
        binding.stand.visibility = View.GONE
        binding.fold.visibility = View.GONE
        binding.result.text = result
        binding.result.visibility =View.VISIBLE
        binding.start.text = "RESTART"
        binding.start.visibility = View.VISIBLE
    }
}
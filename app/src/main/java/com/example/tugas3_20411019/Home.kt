package com.example.tugas3_20411019

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Home : AppCompatActivity() {

    private lateinit var sepakbolaRecyclerView: RecyclerView
    private lateinit var sepakbolaAdapter: MyAdapter
    private lateinit var listsepakbola : ArrayList<ItemData>

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sepakbola)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    sepakbolaRecyclerView = findViewById(R.id.sepakbola)
    listsepakbola = ArrayList()

        listsepakbola.add(ItemData(R.drawable.mbape1,"Kylian Mbappe", "Prance"))
        listsepakbola.add(ItemData(R.drawable.mane2,"Sadio mane", "Afrika"))
        listsepakbola.add(ItemData(R.drawable.img3,"Vinicius Jr ", "Brazil"))
        listsepakbola.add(ItemData(R.drawable.ronaldo4,"Ronaldo", "Portugal"))
        listsepakbola.add(ItemData(R.drawable.messi5,"Lionel Messi", "Argentina"))
        listsepakbola.add(ItemData(R.drawable.neymar6,"Neymar Jr", "Brazil"))
        listsepakbola.add(ItemData(R.drawable.karim7,"Karim Benzema", "Prance"))
        listsepakbola.add(ItemData(R.drawable.luka8,"Luka Modric", "Kroasia"))
        listsepakbola.add(ItemData(R.drawable.robert9,"Robert Lewandowski ", "Polandia"))
        listsepakbola.add(ItemData(R.drawable.mohamed10,"Mohamed Salah ", "Mesir"))

        sepakbolaRecyclerView.layoutManager = LinearLayoutManager(this)
        sepakbolaRecyclerView.setHasFixedSize(true)
        sepakbolaAdapter = MyAdapter(listsepakbola)
        sepakbolaRecyclerView.adapter = sepakbolaAdapter
    }

    }



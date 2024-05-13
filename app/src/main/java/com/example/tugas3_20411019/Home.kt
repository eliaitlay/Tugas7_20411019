package com.example.tugas3_20411019

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Home : AppCompatActivity() {

    private lateinit var sepakbolaRecyclerView: RecyclerView
    private lateinit var nama: Array<String>
    private lateinit var asal: Array<String>
    private lateinit var gambar: Array<Int>
    private lateinit var biografi: Array<String>
    private lateinit var listpemain: ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gambar = arrayOf(
            R.drawable.mbape1,
            R.drawable.mane2,
            R.drawable.img3,
            R.drawable.ronaldo4,
            R.drawable.messi5,
            R.drawable.neymar6,
            R.drawable.karim7,
            R.drawable.luka8,
            R.drawable.robert9,
            R.drawable.mohamed10,
        )

        nama = arrayOf(
            "Kylian Mbappe", "Sadio mane", "Vinicius Jr", "Ronaldo", "Lionel Messi",
            "Neymar Jr", "Karim Benzema", "Luka Modric", "Robert Lewandowski", "Mohamed Salah",
        )

        asal = arrayOf(
            "Prance",
            "Afrika",
            "Brasil",
            "Portugal",
            "Argentina",
            "Brasil",
            "Prance",
            "Kroasia",
            "Polandia",
            "Mesir",
        )

        biografi = arrayOf(
            getString(R.string.kylian_mbappe),
            getString(R.string.sadio_mane),
            getString(R.string.vinicius_jr),
            getString(R.string.ronaldo),
            getString(R.string.lionel_messi),
            getString(R.string.neymar_jr),
            getString(R.string.karim_benzema),
            getString(R.string.luka_mordric),
            getString(R.string.robert_lewandowski),
            getString(R.string.mohamed_salah),
        )

        sepakbolaRecyclerView = findViewById(R.id.sepakbola)
        sepakbolaRecyclerView.layoutManager = LinearLayoutManager(this)
        sepakbolaRecyclerView.setHasFixedSize(true)

        listpemain = arrayListOf<ItemData>()
        getDataUser()
    }

    private fun  getDataUser() {
        for (i in gambar.indices){
            val datapemain = ItemData(gambar[i], nama[i],asal[i])
            listpemain.add(datapemain)
        }

        var adapter = MyAdapter(listpemain)
        sepakbolaRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int){
                intent = Intent (this@Home,DetailActivity::class.java)
                intent.putExtra("idgambar",listpemain[position].gambar)
                intent.putExtra("idnama",listpemain[position].nama)
                intent.putExtra("idasal",listpemain[position].asal)
                intent.putExtra("idbiografi",biografi[position])

                startActivity(intent)
            }
        })
    }
}

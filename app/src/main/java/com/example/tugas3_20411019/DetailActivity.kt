package com.example.tugas3_20411019



import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val gambar : ImageView = findViewById(R.id.my_gambar)
        val nama : TextView = findViewById(R.id.nama_pemain)
        val asal : TextView = findViewById(R.id.asal_pemain)
        val biografi : TextView = findViewById(R.id.my_biografi)

        val bundle: Bundle?= intent.extras
        val bNama = bundle!!.getString("idnama")
        val bGambar = bundle.getInt("idgambar")
        val bAsal = bundle.getString("idasal")
        val bBiografi = bundle.getString("idbiografi")

        gambar.setImageResource(bGambar)
        nama.text = bNama
        asal.text = bAsal
        biografi.text = bBiografi
    }

}

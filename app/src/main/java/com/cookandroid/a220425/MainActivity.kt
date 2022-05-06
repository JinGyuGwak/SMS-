package com.cookandroid.a220425

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.cookandroid.a220425.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    val helper = SqliteHelper(this, "memo", 1)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = RecyclerAdapter()
        adapter.helper = helper
        adapter.listData.addAll(helper.selectMemo())
        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)
        binding.buttonSave.setOnClickListener {
            val memo = Memo(null, binding.editMemo.text.toString(), System.currentTimeMillis())
            Log.d("값 확인", "현재 값은 ${binding.editMemo.text}")
            helper.insertMemo(memo)
            Log.d("값 확인1", "현재 값은 ${helper.test}")

            adapter.listData.clear()
            adapter.listData.addAll(helper.selectMemo())
            adapter.notifyDataSetChanged()
            binding.editMemo.setText("")
        }
        binding.tosms.setOnClickListener {
            val intent = Intent(this, SendMessage::class.java)
            startActivity(intent)


        }
    }
}